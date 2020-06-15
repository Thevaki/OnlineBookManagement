package com.libraryManagementSystem.AuthService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libraryManagementSystem.AuthService.Model.AppUser;

public interface UserRepository extends JpaRepository<AppUser,Integer> {
	AppUser findByUsername(String username);
}
