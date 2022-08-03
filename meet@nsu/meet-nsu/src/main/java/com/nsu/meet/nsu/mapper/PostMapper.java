package com.nsu.meet.nsu.mapper;

import com.nsu.meet.nsu.dto.PostRequest;
import com.nsu.meet.nsu.dto.PostResponse;
import com.nsu.meet.nsu.model.HashTag;
import com.nsu.meet.nsu.model.Post;
import com.nsu.meet.nsu.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostMapper {
    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "description", source = "postRequest.description")
    Post map(PostRequest postRequest, HashTag hashTag, User user);

    @Mapping(target = "id", source = "postId")
    @Mapping(target = "hashTagName", source = "hashTag.name")
    @Mapping(target = "userName", source = "user.username")
    PostResponse mapToDto(Post post);
}
