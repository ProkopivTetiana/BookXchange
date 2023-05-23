package com.bookxchange.repository;

import java.util.Optional;

import com.bookxchange.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByEmail(String email);

    Optional<User> findByPasswordResetToken(String token);

    @Modifying
    @Query("UPDATE User a " +
            "SET a.isActive = TRUE " +
            "WHERE a.email = ?1 ")
    int enableUser(String email);

    @Query(value = "SELECT id FROM User WHERE email LIKE ?1 ")
    String findUserIdByEmail(String email);

    User findUserById(String userId);
}
