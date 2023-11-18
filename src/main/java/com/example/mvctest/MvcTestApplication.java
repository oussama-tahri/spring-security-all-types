package com.example.mvctest;

import com.example.mvctest.entities.Patient;
import com.example.mvctest.repositories.PatientRepository;
import com.example.mvctest.security.userDetails.services.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import java.util.Date;

@SpringBootApplication
public class MvcTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MvcTestApplication.class, args);
    }


    @Bean
    CommandLineRunner start(PatientRepository patientRepository) {
        return args -> {
            for (int i = 0; i < 25; i++) {
                patientRepository.save(
                        new Patient(null, "Nawfal", new Date(), Math.random() > 0.5 ? true:false, (int) (Math.random() * 5)));
                patientRepository.save(
                        new Patient(null, "Abrak", new Date(), Math.random() > 0.5 ? true:false, (int) (Math.random() * 5)));
                patientRepository.save(
                        new Patient(null, "Marouane", new Date(), Math.random() > 0.5 ? true:false, (int) (Math.random() * 5)));
                patientRepository.save(
                        new Patient(null, "Hamza", new Date(), Math.random() > 0.5 ? true:false, (int) (Math.random() * 5)));
            }

            patientRepository.findAll().forEach(p -> {
                System.out.println(p.getName());
            });
        };
    }



//    @Bean
//    CommandLineRunner commandLineRunner(JdbcUserDetailsManager jdbcUserDetailsManager) {
//        PasswordEncoder passwordEncoder = passwordEncoder();
//        return args -> {
//            UserDetails user11 = jdbcUserDetailsManager.loadUserByUsername("user11");
//            if (user11==null)
//            jdbcUserDetailsManager.createUser(
//                    User.withUsername("user11")
//                            .password(passwordEncoder.encode("1234"))
//                            .roles("USER")
//                            .build()
//                    );
//            UserDetails user22 = jdbcUserDetailsManager.loadUserByUsername("user22");
//            if (user22==null)
//            jdbcUserDetailsManager.createUser(
//                    User.withUsername("user22")
//                            .password(passwordEncoder.encode("1234"))
//                            .roles("USER")
//                            .build()
//            );
//            UserDetails admin11 = jdbcUserDetailsManager.loadUserByUsername("admin11");
//            if (admin11==null)
//            jdbcUserDetailsManager.createUser(
//                    User.withUsername("admin11")
//                            .password(passwordEncoder.encode("1234"))
//                            .roles("USER","ADMIN")
//                            .build()
//            );
//        };
//    }


    //@Bean
    CommandLineRunner lunch(AccountService accountService) {
        return args -> {
          accountService.addNewRole("USER");
          accountService.addNewRole("ADMIN");
          accountService.addNewUser("user11","1234","user11@users.com","1234");
          accountService.addNewUser("user22","1234","user22@users.com","1234");
          accountService.addNewUser("admin11","1234","admin11@admins.com","1234");
          accountService.addRoleToUser("user11","USER");
          accountService.addRoleToUser("user22","USER");
          accountService.addRoleToUser("admin11","USER");
          accountService.addRoleToUser("admin11","ADMIN");
        };
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
