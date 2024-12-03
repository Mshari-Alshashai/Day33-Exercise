package com.example.day33exercise.Service;

import com.example.day33exercise.ApiResponse.ApiException;
import com.example.day33exercise.Model.User;
import com.example.day33exercise.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(Integer id, User user) {
        User oldUser=userRepository.findUserById(id);
        if(oldUser==null) throw new ApiException("user not found");
        oldUser.setName(user.getName());
        oldUser.setEmail(user.getEmail());
        oldUser.setAge(user.getAge());
        oldUser.setRole(user.getRole());
        oldUser.setUsername(user.getUsername());
        oldUser.setPassword(user.getPassword());
        userRepository.save(oldUser);

    }

    public void deleteUser(Integer id) {
        if (userRepository.findUserById(id) == null) throw new ApiException("user not found");
        userRepository.deleteById(id);
    }

    public void checkUsernameAndPassword(String username, String password) {
        if (userRepository.checkUsernameAndPassword(username, password)== null) throw new ApiException("user or password are incorrect");
    }

    public User getUserByEmail(String email) {
        if (userRepository.findUserByEmail(email) == null) throw new ApiException("user not found");
        return userRepository.findUserByEmail(email);
    }

    public List<User> getUserByRole(String role) {
        return userRepository.getAllUsersWithSameRole(role);
    }

    public List<User> getUsersInAgeRange(Integer age) {
        return userRepository.getAllUsersByAgeRange(age);
    }
}
