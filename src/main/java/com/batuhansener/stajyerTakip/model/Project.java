package com.batuhansener.stajyerTakip.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    String id;
    String name;
    String requirements;
    LocalDateTime initialDate;
    LocalDateTime finishDate;
    int score;
    @Enumerated(EnumType.STRING)
    ProjectStatus projectStatus = ProjectStatus.ONGOING;
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Comment> comments;
//    @ManyToOne
//    @JoinColumn(name = "user_id")
    @ManyToMany(mappedBy = "projects", fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<User> users;
//    @ManyToMany(mappedBy = "project")
//    private List<Intern> interns;

    public List<Comment> getSortedComments() {
        return this.comments.stream()
                .sorted(Comparator.comparing(Comment::getReleaseDate).reversed())
                .collect(Collectors.toList());
    }
}