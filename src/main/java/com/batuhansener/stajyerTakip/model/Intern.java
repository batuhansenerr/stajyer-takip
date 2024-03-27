package com.batuhansener.stajyerTakip.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Intern {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Mentor mentor;
//    @Id
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

}
