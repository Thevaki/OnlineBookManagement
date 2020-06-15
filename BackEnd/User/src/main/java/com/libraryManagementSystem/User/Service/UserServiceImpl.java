package com.libraryManagementSystem.User.Service;

import com.libraryManagementSystem.User.Model.AppUser;
import com.libraryManagementSystem.User.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public AppUser createUser(AppUser user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public AppUser editUserDetails(AppUser user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public AppUser deleteUser(String username){
        Optional<AppUser> user = userRepository.findByUsername(username);

        if(user.isPresent()) {
            userRepository.deleteByUsername(username);
            return user.get();
        }
        return null;

    }

    public AppUser findByUsername(String username){
        Optional<AppUser> user = userRepository.findByUsername(username);

        if(user.isPresent()) {
            return user.get();
        }
        return null;
    }

    public List<AppUser> fetchAllUsers(){
        List<AppUser> users = userRepository.findAll();

        if(users.isEmpty()){
            return null;
        }
        return  users;
    }
}
