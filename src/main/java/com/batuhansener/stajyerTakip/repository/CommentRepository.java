package com.batuhansener.stajyerTakip.repository;

import com.batuhansener.stajyerTakip.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository  extends JpaRepository<Comment, String> {
}
