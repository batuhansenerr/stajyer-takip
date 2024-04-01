package com.batuhansener.stajyerTakip.repository;

import com.batuhansener.stajyerTakip.model.Comment;
import com.batuhansener.stajyerTakip.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {

    Project findProjectByComments(Comment comment);
}
