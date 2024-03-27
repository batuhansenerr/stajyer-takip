package com.batuhansener.stajyerTakip.repository;

import com.batuhansener.stajyerTakip.model.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MentorRepository  extends JpaRepository<Mentor, String> {
}
