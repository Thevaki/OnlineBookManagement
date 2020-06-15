package com.libraryManagementSystem.User.Service;

import com.libraryManagementSystem.User.Model.AppUser;

import java.util.List;

public interface UserService {

    AppUser createUser(AppUser book);

    AppUser editUserDetails(AppUser book);

    AppUser deleteUser(String username);

    AppUser findByUsername(String username);

    List<AppUser> fetchAllUsers();
}
