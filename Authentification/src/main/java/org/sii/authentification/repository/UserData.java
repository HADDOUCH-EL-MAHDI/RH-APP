package org.sii.authentification.repository;

import lombok.RequiredArgsConstructor;
import org.sii.authentification.model.Role;
import org.sii.authentification.model.Utilisateur;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
@RequiredArgsConstructor
public class UserData implements CommandLineRunner {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) {
        Utilisateur user1 = new Utilisateur();
        user1.setLastName("bouarga");
        user1.setFirstName("zakaria");
        user1.setPassword(passwordEncoder.encode("1111"));
        user1.setEmail("zakaria.bouarga@ump.ac.ma");
        user1.setHireDate(LocalDate.of(2024, 2, 1));
        user1.setRole(Role.MANAGER);

        Utilisateur user2 = new Utilisateur();
        user2.setLastName("zaki");
        user2.setFirstName("zaki");
        user2.setPassword(passwordEncoder.encode("1111"));
        user2.setEmail("zakaria.bouarga09@gmail.com");
        user2.setHireDate(LocalDate.of(2022, 3, 1));
        user2.setRole(Role.ADMIN);

        Utilisateur user3 = new Utilisateur();
        user3.setLastName("bourga");
        user3.setFirstName("zaki");
        user3.setPassword(passwordEncoder.encode("1111"));
        user3.setEmail("irakazbrg@gmail.com");
        user3.setHireDate(LocalDate.of(2023, 3, 1));
        user3.setRole(Role.USER);

        Utilisateur user4 = new Utilisateur();
        user4.setLastName("amigo");
        user4.setFirstName("zeekouu");
        user4.setPassword(passwordEncoder.encode("1111"));
        user4.setEmail("zakaria.bouarga@sii-maroc.com");
        user4.setHireDate(LocalDate.of(2023, 4, 5));
        user4.setRole(Role.ADMIN_RH);
        saveUser(user1);
        saveUser(user2);
        saveUser(user3);
        saveUser(user4);



    }
    private void saveUser(Utilisateur user) {
        Boolean exists = userRepository.existsByEmail(user.getEmail());
        if(!exists){
            userRepository.save(user);
        }
    }
}
