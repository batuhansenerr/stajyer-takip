package com.batuhansener.stajyerTakip.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.List;

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
    LocalDateTime initialDate;
    LocalDateTime finishDate;
    int score;
    @Enumerated(EnumType.STRING)
    ProjectStatus projectStatus = ProjectStatus.ONGOING;
    @ManyToOne
    @JoinColumn(name = "mentor_id")
    private Mentor mentor;
    @OneToMany(mappedBy = "project")
    private List<Intern> interns;


}
