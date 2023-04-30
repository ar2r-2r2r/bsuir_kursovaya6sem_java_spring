package com.starterkit.springboot.brs;

import com.starterkit.springboot.brs.model.user.Role;
import com.starterkit.springboot.brs.model.user.User;
import com.starterkit.springboot.brs.repository.discussion.DiscussionRepository;
import com.starterkit.springboot.brs.repository.user.RoleRepository;
import com.starterkit.springboot.brs.repository.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.HashSet;

@SpringBootApplication
public class QuestionAnswerSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuestionAnswerSystemApplication.class, args);
    }

    @Bean
    CommandLineRunner init(RoleRepository roleRepository, UserRepository userRepository,
                           DiscussionRepository discussionRepository) {
        return args -> {
            //Create Admin and CLIENT Roles
            Role adminRole = roleRepository.findByRole("ADMIN");
            if (adminRole == null) {
                adminRole = new Role();
                adminRole.setRole("ADMIN");
                roleRepository.save(adminRole);
            }

            Role userRole = roleRepository.findByRole("CLIENT");
            if (userRole == null) {
                userRole = new Role();
                userRole.setRole("CLIENT");
                roleRepository.save(userRole);
            }

            //Create an Admin user
            User admin = userRepository.findByEmail("admin.agencya@gmail.com");
            if (admin == null) {
                admin = new User()
                        .setEmail("admin.agencya@gmail.com")
                        .setPassword("$2a$10$7PtcjEnWb/ZkgyXyxY1/Iei2dGgGQUbqIIll/dt.qJ8l8nQBWMbYO") // "123456"
                        .setFirstName("John")
                        .setLastName("Doe")
                        .setRoles(new HashSet<>(Arrays.asList(adminRole)));
                userRepository.save(admin);
            }


        };
    }
}
