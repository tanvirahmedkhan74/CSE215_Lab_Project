package com.nsu.meet.nsu.mapper;

import com.nsu.meet.nsu.dto.HashTagDto;
import com.nsu.meet.nsu.model.HashTag;
import com.nsu.meet.nsu.model.Post;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HashTagMapper {

    @Mapping(target = "numberOfPosts", expression = "java(mapPosts(hashTag.getPosts()))")
    HashTagDto mapHashTagToDto(HashTag hashTag);

    default Integer mapPosts(List<Post> numberOfPosts) {
        return numberOfPosts.size();
    }

    @InheritInverseConfiguration
    @Mapping(target = "posts", ignore = true)
    HashTag mapDtoToHashTag(HashTagDto hashTagDto);
}
