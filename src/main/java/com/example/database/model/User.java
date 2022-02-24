package com.example.database.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Data

@EqualsAndHashCode
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    @Column(name = "ID", updatable = false)
    Long id;
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    public List<AnswerSheet> answerSheetList;

    String username;
}
