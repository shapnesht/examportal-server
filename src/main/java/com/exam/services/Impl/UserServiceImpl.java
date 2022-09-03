package com.exam.services.Impl;

import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.repository.RoleRepository;
import com.exam.repository.UserRepository;
import com.exam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;




    // creating User
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
        System.out.println(user.getUsername());
        User localUser = userRepository.findByUsername(user.getUsername());
        if (localUser != null) {
            System.out.println("User Already exists!!");
            throw new Exception("User Already Exist.");
        }
        for (UserRole ur: userRoles) {
            roleRepository.save(ur.getRole());
        }
        user.getUserRoles().addAll(userRoles);
        localUser = userRepository.save(user);

        return localUser;
    }

    // Get User By Username
    @Override
    public User getUserByUsername(String username) throws Exception {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new Exception("User Not Found!!");
        }
        return user;
    }

    // Delete User By Username
    @Override
    public void deleteUserByUsername(String username) throws Exception {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new Exception("User Not Found!!");
        }
        userRepository.delete(user);
    }

    // Update User By Username
    @Override
    public User updateUserByUsername(String username, User user) throws Exception {
        User localUser = userRepository.findByUsername(username);
        if (user == null) {
            throw new Exception("User Not Found!!");
        }
        if (user.getUsername() != null) localUser.setUsername(user.getUsername());
        if (user.getUserRoles() != null) localUser.setUserRoles(user.getUserRoles());
        if (user.getAbout() != null) localUser.setAbout(user.getAbout());
        if (user.getFirstName() != null) localUser.setFirstName(user.getFirstName());
        if (user.getEmail() != null) localUser.setEmail(user.getEmail());
        if (user.getLastName() != null) localUser.setLastName(user.getLastName());
        if (user.getPassword() != null) localUser.setPassword(user.getPassword());
        if (user.getPhoneNumber() != null) localUser.setPhoneNumber(user.getPhoneNumber());
        userRepository.save(localUser);
        return localUser;
    }
}
