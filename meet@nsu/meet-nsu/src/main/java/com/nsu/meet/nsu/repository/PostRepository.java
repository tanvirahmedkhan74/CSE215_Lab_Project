package com.nsu.meet.nsu.repository;

import com.nsu.meet.nsu.model.HashTag;
import com.nsu.meet.nsu.model.Post;
import com.nsu.meet.nsu.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByHashTag(HashTag hashTag);

    List<Post> findByUser(User user);
}
