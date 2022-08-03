package com.nsu.meet.nsu.service;

import com.nsu.meet.nsu.dto.PostRequest;
import com.nsu.meet.nsu.dto.PostResponse;
import com.nsu.meet.nsu.exceptions.HashTagNotFoundException;
import com.nsu.meet.nsu.exceptions.PostNotFoundException;
import com.nsu.meet.nsu.mapper.PostMapper;
import com.nsu.meet.nsu.model.HashTag;
import com.nsu.meet.nsu.model.Post;
import com.nsu.meet.nsu.model.User;
import com.nsu.meet.nsu.repository.HashTagRepository;
import com.nsu.meet.nsu.repository.PostRepository;
import com.nsu.meet.nsu.repository.UserRepository;
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
    private final HashTagRepository hashTagRepository;
    private final UserRepository userRepository;
    private final AuthService authService;
    private final PostMapper postMapper;

    @Transactional(readOnly = true)
    public PostResponse getPost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id.toString()));
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
        HashTag hashTag = hashTagRepository.findByName(postRequest.getHashTagName())
                .orElseThrow(() -> new HashTagNotFoundException(postRequest.getHashTagName()));
        postRepository.save(postMapper.map(postRequest, hashTag, authService.getCurrentUser()));
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getPostsByHashTag(Long subredditId) {
        HashTag hashTag = hashTagRepository.findById(subredditId)
                .orElseThrow(() -> new HashTagNotFoundException(subredditId.toString()));
        List<Post> posts = postRepository.findAllByHashTag(hashTag);
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