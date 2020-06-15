package com.libraryManagementSystem.User.Repository;

import com.libraryManagementSystem.User.Model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<AppUser,Integer> {
    void deleteByUsername(String username);

    Optional<AppUser> findByUsername(String username);
}
