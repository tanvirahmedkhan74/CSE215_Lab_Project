package com.campus.meet.NSU.repository;

import com.campus.meet.NSU.model.Post;
import com.campus.meet.NSU.model.User;
import com.campus.meet.NSU.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
    Optional<Vote> findTopByPostAndUserOrderByVoteIdDesc(Post post, User currentUser);
}