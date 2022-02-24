package com.example.database.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Data

@EqualsAndHashCode
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "ANSWER_SHEET")
public class AnswerSheet {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "answer_sheet_sequence"
    )
    @Column(name = "ID", updatable = false)
    private Long id;
    private String answer;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="USER_ID", nullable=false)
    private User user;
}
