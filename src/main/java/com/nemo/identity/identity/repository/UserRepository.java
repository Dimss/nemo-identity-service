package com.nemo.identity.identity.repository;

import com.nemo.identity.identity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, String> {

    @Query("SELECT u FROM User u where email = :email")
    User findUserByEmail(@Param("email") String email);
}
