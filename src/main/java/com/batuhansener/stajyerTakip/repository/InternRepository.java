package com.batuhansener.stajyerTakip.repository;

import com.batuhansener.stajyerTakip.model.Intern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternRepository extends JpaRepository<Intern, String> {
}
