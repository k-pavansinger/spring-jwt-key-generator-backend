package com.example.spring_jwt_auth;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.spring_jwt_auth.entity.User;
import com.example.spring_jwt_auth.repository.UserRepository;

@SpringBootApplication
public class SpringJwtAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJwtAuthApplication.class, args);
	}

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, PasswordEncoder encoder) {
        return args -> {
            if (userRepository.findByUsername("admin").isEmpty()) {
                User admin = new User();
                admin.setUsername("admin");
                admin.setEmail("admin@example.com");
                admin.setPassword(encoder.encode("admin123"));
                userRepository.save(admin);
            }
        };
    }


	@Bean
	CommandLineRunner initAdminUser(UserRepository userRepository, PasswordEncoder encoder) {
		return args -> {
			if (userRepository.findByUsername("admin").isEmpty()) {
				User admin = new User();
				admin.setUsername("admin");
				admin.setPassword(encoder.encode("admin123"));
				admin.setEmail("admin@example.com");
				admin.setRoles(List.of("ADMIN"));
				userRepository.save(admin);
			}
		};
	}

}
