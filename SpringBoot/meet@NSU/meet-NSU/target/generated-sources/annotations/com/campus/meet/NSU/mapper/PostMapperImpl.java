package com.campus.meet.NSU.mapper;

import com.campus.meet.NSU.dto.PostRequest;
import com.campus.meet.NSU.dto.PostResponse;
import com.campus.meet.NSU.model.Hashtag;
import com.campus.meet.NSU.model.Post;
import com.campus.meet.NSU.model.Post.PostBuilder;
import com.campus.meet.NSU.model.User;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-04T23:09:21+0600",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.15 (Private Build)"
)
@Component
public class PostMapperImpl extends PostMapper {

    @Override
    public Post map(PostRequest postRequest, Hashtag hashtag, User user) {
        if ( postRequest == null && hashtag == null && user == null ) {
            return null;
        }

        PostBuilder post = Post.builder();

        if ( postRequest != null ) {
            post.description( postRequest.getDescription() );
            post.postId( postRequest.getPostId() );
            post.postName( postRequest.getPostName() );
            post.url( postRequest.getUrl() );
        }
        if ( hashtag != null ) {
            post.hashtag( hashtag );
        }
        if ( user != null ) {
            post.user( user );
        }
        post.createdDate( java.time.Instant.now() );
        post.voteCount( 0 );

        return post.build();
    }

    @Override
    public PostResponse mapToDto(Post post) {
        if ( post == null ) {
            return null;
        }

        PostResponse postResponse = new PostResponse();

        postResponse.setHashtagName( postHashtagName( post ) );
        postResponse.setId( post.getPostId() );
        postResponse.setUserName( postUserUsername( post ) );
        postResponse.setPostName( post.getPostName() );
        postResponse.setUrl( post.getUrl() );
        postResponse.setDescription( post.getDescription() );
        postResponse.setVoteCount( post.getVoteCount() );

        postResponse.setDuration( getDuration(post) );
        postResponse.setCommentCount( commentCount(post) );

        return postResponse;
    }

    private String postHashtagName(Post post) {
        if ( post == null ) {
            return null;
        }
        Hashtag hashtag = post.getHashtag();
        if ( hashtag == null ) {
            return null;
        }
        String name = hashtag.getName();
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
