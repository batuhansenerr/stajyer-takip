package com.batuhansener.stajyerTakip.repository;

import com.batuhansener.stajyerTakip.model.Project;
import com.batuhansener.stajyerTakip.model.Role;
import com.batuhansener.stajyerTakip.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);
    List<User> findByAuthoritiesContaining(Role role);

    List<User> findByProjects(Project project);

    List<User> findByAuthoritiesContainingAndProjects(Role role, Project project);
}