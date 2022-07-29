package com.geosocial.meetatNSU.repository;

import com.geosocial.meetatNSU.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
