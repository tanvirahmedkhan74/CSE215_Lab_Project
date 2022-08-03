package com.campus.meet.NSU.mapper;

import com.campus.meet.NSU.dto.HashtagDto;
import com.campus.meet.NSU.dto.HashtagDto.HashtagDtoBuilder;
import com.campus.meet.NSU.model.Hashtag;
import com.campus.meet.NSU.model.Hashtag.HashtagBuilder;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-03T23:07:59+0600",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.15 (Private Build)"
)
@Component
public class HashtagMapperImpl implements HashtagMapper {

    @Override
    public HashtagDto mapHashtagToDto(Hashtag hashtag) {
        if ( hashtag == null ) {
            return null;
        }

        HashtagDtoBuilder hashtagDto = HashtagDto.builder();

        hashtagDto.id( hashtag.getId() );
        hashtagDto.name( hashtag.getName() );
        hashtagDto.description( hashtag.getDescription() );

        hashtagDto.numberOfPosts( mapPosts(hashtag.getPosts()) );

        return hashtagDto.build();
    }

    @Override
    public Hashtag mapDtoToHashtag(HashtagDto hashtag) {
        if ( hashtag == null ) {
            return null;
        }

        HashtagBuilder hashtag1 = Hashtag.builder();

        hashtag1.id( hashtag.getId() );
        hashtag1.name( hashtag.getName() );
        hashtag1.description( hashtag.getDescription() );

        return hashtag1.build();
    }
}
