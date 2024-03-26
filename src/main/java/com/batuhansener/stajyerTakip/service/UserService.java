package com.batuhansener.stajyerTakip.service;

import com.batuhansener.stajyerTakip.dto.request.auth.CreateUserRequest;
import com.batuhansener.stajyerTakip.model.User;
import com.batuhansener.stajyerTakip.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final InternService internService;
    private final MentorService mentorService;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, InternService internService, MentorService mentorService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.internService = internService;
        this.mentorService = mentorService;
    }

    public Optional<User> getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User createUser(CreateUserRequest request) {
//        Set<Role> authorities = request.authorities().stream()
//                .map(role -> Role.fromValue(String.valueOf(role)))
//                .collect(Collectors.toSet());

        User newUser = User.builder()
                .name(request.name())
                .username(request.username())
                .password(passwordEncoder.encode(request.password()))
                .authorities(request.authorities())
                .accountNonExpired(true)
                .credentialsNonExpired(true)
                .isEnabled(true)
                .accountNonLocked(true)
                .build();
        System.out.println(newUser.getAuthorities().size());

        newUser = userRepository.save(newUser);

        User finalNewUser = newUser;

        newUser.getAuthorities().stream().forEach(auth-> {
            if (auth.getAuthority().equals("ROLE_MENTOR")) {
                System.out.println(auth.getAuthority());
                mentorService.createMentor(finalNewUser);
            }else if (auth.getAuthority().equals("ROLE_INTERN")) {
                System.out.println(auth.getAuthority());
                internService.createIntern(finalNewUser);
            }
        });

        return newUser;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        return user.orElseThrow(EntityNotFoundException::new);
    }
}