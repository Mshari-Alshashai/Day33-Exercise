package com.example.day33exercise.Repository;

import com.example.day33exercise.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserById(Integer id);

    @Query("select u from User u where u.username=?1 and u.password=?2 ")
    User checkUsernameAndPassword(String username, String password);

    User findUserByEmail(String email);

    @Query("select u from User u where u.role=?1")
    List<User> getAllUsersWithSameRole(String role);

    @Query("select u from User u where u.age>=?1")
    List<User> getAllUsersByAgeRange(Integer age);
}
