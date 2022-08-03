package com.campus.meet.NSU.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campus.meet.NSU.model.Hashtag;

import java.util.Optional;

public interface HashtagRepository extends JpaRepository<Hashtag, Long> {
    Optional<Hashtag> findByName(String hashtagName);
}