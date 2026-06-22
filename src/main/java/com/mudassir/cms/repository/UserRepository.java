package com.mudassir.cms.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mudassir.cms.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

}