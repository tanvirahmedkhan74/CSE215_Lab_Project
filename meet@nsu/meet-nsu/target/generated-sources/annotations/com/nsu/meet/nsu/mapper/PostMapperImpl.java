package com.nsu.meet.nsu.mapper;

import com.nsu.meet.nsu.dto.PostRequest;
import com.nsu.meet.nsu.dto.PostResponse;
import com.nsu.meet.nsu.model.HashTag;
import com.nsu.meet.nsu.model.Post;
import com.nsu.meet.nsu.model.Post.PostBuilder;
import com.nsu.meet.nsu.model.User;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-03T19:30:26+0600",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.15 (Private Build)"
)
@Component
public class PostMapperImpl implements PostMapper {

    @Override
    public Post map(PostRequest postRequest, HashTag hashTag, User user) {
        if ( postRequest == null && hashTag == null && user == null ) {
            return null;
        }

        PostBuilder post = Post.builder();

        if ( postRequest != null ) {
            post.description( postRequest.getDescription() );
            post.postId( postRequest.getPostId() );
            post.postName( postRequest.getPostName() );
            post.url( postRequest.getUrl() );
        }
        if ( hashTag != null ) {
            post.user( hashTag.getUser() );
        }
        post.createdDate( java.time.Instant.now() );

        return post.build();
    }

    @Override
    public PostResponse mapToDto(Post post) {
        if ( post == null ) {
            return null;
        }

        PostResponse postResponse = new PostResponse();

        postResponse.setHashTagName( postHashTagName( post ) );
        postResponse.setId( post.getPostId() );
        postResponse.setUserName( postUserUsername( post ) );
        postResponse.setPostName( post.getPostName() );
        postResponse.setUrl( post.getUrl() );
        postResponse.setDescription( post.getDescription() );

        return postResponse;
    }

    private String postHashTagName(Post post) {
        if ( post == null ) {
            return null;
        }
        HashTag hashTag = post.getHashTag();
        if ( hashTag == null ) {
            return null;
        }
        String name = hashTag.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String postUserUsername(Post post) {
        if ( post == null ) {
            return null;
        }
        User user = post.getUser();
        if ( user == null ) {
            return null;
        }
        String username = user.getUsername();
        if ( username == null ) {
            return null;
        }
        return username;
    }
}
