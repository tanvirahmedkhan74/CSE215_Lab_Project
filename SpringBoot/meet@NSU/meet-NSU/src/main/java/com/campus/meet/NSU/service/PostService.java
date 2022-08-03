package com.campus.meet.NSU.service;

import com.campus.meet.NSU.dto.PostRequest;
import com.campus.meet.NSU.dto.PostResponse;
import com.campus.meet.NSU.exception.MeetNsuException;
import com.campus.meet.NSU.mapper.PostMapper;
import com.campus.meet.NSU.model.Hashtag;
import com.campus.meet.NSU.model.Post;
import com.campus.meet.NSU.model.User;
import com.campus.meet.NSU.repository.HashtagRepository;
import com.campus.meet.NSU.repository.PostRepository;
import com.campus.meet.NSU.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class PostService {

    private final PostRepository postRepository;
    private final HashtagRepository hashtagRepository;
    private final UserRepository userRepository;
    private final AuthService authService;
    private final PostMapper postMapper;

    @Transactional(readOnly = true)
    public PostResponse getPost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new MeetNsuException(id.toString()));
        return postMapper.mapToDto(post);
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(postMapper::mapToDto)
                .collect(toList());
    }

    public void save(PostRequest postRequest) {
        Hashtag hashtag = hashtagRepository.findByName(postRequest.getHashtagName())
                .orElseThrow(() -> new MeetNsuException(postRequest.getHashtagName()));
        postRepository.save(postMapper.map(postRequest, hashtag, authService.getCurrentUser()));
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getPostsByHashtag(Long subredditId) {
        Hashtag hashtag = hashtagRepository.findById(subredditId)
                .orElseThrow(() -> new MeetNsuException(subredditId.toString()));
        List<Post> posts = postRepository.findAllByHashtag(hashtag);
        return posts.stream().map(postMapper::mapToDto).collect(toList());
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getPostsByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        return postRepository.findByUser(user)
                .stream()
                .map(postMapper::mapToDto)
                .collect(toList());
    }
}