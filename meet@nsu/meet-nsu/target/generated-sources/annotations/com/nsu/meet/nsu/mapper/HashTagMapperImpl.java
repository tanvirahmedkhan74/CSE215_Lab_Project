package com.nsu.meet.nsu.mapper;

import com.nsu.meet.nsu.dto.HashTagDto;
import com.nsu.meet.nsu.dto.HashTagDto.HashTagDtoBuilder;
import com.nsu.meet.nsu.model.HashTag;
import com.nsu.meet.nsu.model.HashTag.HashTagBuilder;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-03T19:30:26+0600",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.15 (Private Build)"
)
@Component
public class HashTagMapperImpl implements HashTagMapper {

    @Override
    public HashTagDto mapHashTagToDto(HashTag hashTag) {
        if ( hashTag == null ) {
            return null;
        }

        HashTagDtoBuilder hashTagDto = HashTagDto.builder();

        hashTagDto.id( hashTag.getId() );
        hashTagDto.name( hashTag.getName() );
        hashTagDto.description( hashTag.getDescription() );

        hashTagDto.numberOfPosts( mapPosts(hashTag.getPosts()) );

        return hashTagDto.build();
    }

    @Override
    public HashTag mapDtoToHashTag(HashTagDto hashTagDto) {
        if ( hashTagDto == null ) {
            return null;
        }

        HashTagBuilder hashTag = HashTag.builder();

        hashTag.id( hashTagDto.getId() );
        hashTag.name( hashTagDto.getName() );
        hashTag.description( hashTagDto.getDescription() );

        return hashTag.build();
    }
}
