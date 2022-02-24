package com.example.database.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@Data

@EqualsAndHashCode
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "TODO")
public class Todo {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "todo_sequence"
    )
    @Column(name = "ID", updatable = false)
    Long id;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "TODO_ID", referencedColumnName = "ID")
    public List<Assignable> todoList;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "ANSWER_SHEET_ID", referencedColumnName = "ID")
    public List<AnswerSheet> answerSheetList;

    private String name;

    public Todo( String name,List<Assignable> todoList ){
        this.name = name;
        this.todoList = todoList;
    }
}
