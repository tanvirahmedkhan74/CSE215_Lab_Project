package com.campus.meet.NSU.mapper;

import com.campus.meet.NSU.dto.PostRequest;
import com.campus.meet.NSU.dto.PostResponse;
import com.campus.meet.NSU.model.Hashtag;
import com.campus.meet.NSU.model.Post;
import com.campus.meet.NSU.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostMapper {
    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "hashtag", source = "hashtag")
    @Mapping(target = "user", source = "user")
    @Mapping(target = "description", source = "postRequest.description")
    Post map(PostRequest postRequest, Hashtag hashtag, User user);

    @Mapping(target = "id", source = "postId")
    @Mapping(target = "postName", source = "postName")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "url", source = "url")
    @Mapping(target = "hashtagName", source = "hashtag.name")
    @Mapping(target = "userName", source = "user.username")
    PostResponse mapToDto(Post post);
}