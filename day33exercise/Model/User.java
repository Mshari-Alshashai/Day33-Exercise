package com.example.day33exercise.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Check(constraints = "role='user' OR role= 'admin' AND LENGTH(name)>4 AND LENGTH(username)>4")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotEmpty(message = "The name should not be empty")
    @Size(min = 5,message = "The name length should be more than 4 characters")
    private String name;

    @Column(unique = true, nullable = false)
    @NotEmpty(message = "The username should not be empty")
    @Size(min = 5,message = "The username should have more than 4 characters")
    private String username;

    @Column(nullable = false)
    @NotEmpty(message = "The password should not be empty")
    private String password;

    @Column(nullable = false, unique = true)
    @NotEmpty(message = "The email should not be empty")
    @Email(message = "The email should be in the right form")
    private String email;

    @Column(nullable = false)
    @NotEmpty(message = "The role should not be empty")
    @Pattern(regexp = "user|admin")
    private String role;

    @Column(nullable = false)
    @NotNull(message = "The age should have a value")
    private Integer age;
}
