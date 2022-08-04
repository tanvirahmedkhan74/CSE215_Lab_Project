package com.campus.meet.NSU.mapper;

import com.campus.meet.NSU.dto.PostRequest;
import com.campus.meet.NSU.dto.PostResponse;
import com.campus.meet.NSU.model.Hashtag;
import com.campus.meet.NSU.model.Post;
import com.campus.meet.NSU.model.User;
import com.campus.meet.NSU.repository.CommentRepository;
import com.campus.meet.NSU.repository.VoteRepository;
import com.campus.meet.NSU.service.AuthService;
import com.github.marlonlom.utilities.timeago.TimeAgo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class PostMapper {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private VoteRepository voteRepository;
    @Autowired
    private AuthService authService;


    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "description", source = "postRequest.description")
    @Mapping(target = "hashtag", source = "hashtag")
    @Mapping(target = "user", source = "user")
    @Mapping(target = "voteCount", constant = "0")
    public abstract Post map(PostRequest postRequest, Hashtag hashtag, User user);

    @Mapping(target = "id", source = "postId")
    @Mapping(target = "hashtagName", source = "hashtag.name")
    @Mapping(target = "userName", source = "user.username")
    @Mapping(target = "commentCount", expression = "java(commentCount(post))")
    @Mapping(target = "duration", expression = "java(getDuration(post))")
    public abstract PostResponse mapToDto(Post post);

    Integer commentCount(Post post) {
        return commentRepository.findByPost(post).size();
    }

    String getDuration(Post post) {
        return TimeAgo.using(post.getCreatedDate().toEpochMilli());
    }
}