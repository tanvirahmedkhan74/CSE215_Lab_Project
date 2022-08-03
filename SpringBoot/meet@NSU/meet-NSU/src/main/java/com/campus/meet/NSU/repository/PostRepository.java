package com.campus.meet.NSU.repository;

import com.campus.meet.NSU.model.Hashtag;
import com.campus.meet.NSU.model.Post;
import com.campus.meet.NSU.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByHashtag(Hashtag hashtag);

    List<Post> findByUser(User user);
}
