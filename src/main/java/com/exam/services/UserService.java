package com.exam.services;

import com.exam.model.User;
import com.exam.model.UserRole;
import java.util.Set;

public interface UserService {

    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    public User getUserByUsername(String username) throws Exception;

    public void deleteUserByUsername(String username) throws Exception;

    public User updateUserByUsername(String username, User user) throws Exception;
}
