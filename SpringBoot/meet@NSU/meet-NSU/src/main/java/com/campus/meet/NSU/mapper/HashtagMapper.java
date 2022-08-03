package com.campus.meet.NSU.mapper;

import com.campus.meet.NSU.dto.HashtagDto;
import com.campus.meet.NSU.model.Hashtag;
import com.campus.meet.NSU.model.Post;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HashtagMapper {

    @Mapping(target = "numberOfPosts", expression = "java(mapPosts(hashtag.getPosts()))")
    HashtagDto mapHashtagToDto(Hashtag hashtag);

    default Integer mapPosts(List<Post> numberOfPosts) {
        return numberOfPosts.size();
    }

    @InheritInverseConfiguration
    @Mapping(target = "posts", ignore = true)
    Hashtag mapDtoToHashtag(HashtagDto hashtag);
}