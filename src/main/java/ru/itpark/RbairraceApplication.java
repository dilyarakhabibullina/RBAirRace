package ru.itpark;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itpark.domain.User;
import ru.itpark.repository.UserRepository;

import java.util.List;

@SpringBootApplication
public class RbairraceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RbairraceApplication.class, args);
    }
    @Bean
    // в аргументах - любые сервисы, репозитории, которые вам нужны
    public CommandLineRunner runner(UserRepository repository, PasswordEncoder passwordEncoder) {
        return (args) -> {
            repository.save(
                    new User(
                            0,
                            "admin",
                            passwordEncoder.encode("password"),
                            List.of(new SimpleGrantedAuthority("ROLE_ADMIN")),
                            true,
                            true,
                            true,
                            true
                    )
            );

        };
    }}