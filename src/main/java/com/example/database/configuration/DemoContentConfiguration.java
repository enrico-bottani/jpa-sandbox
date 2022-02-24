package com.example.database.configuration;

import com.example.database.model.AnswerSheet;
import com.example.database.model.Assignable;
import com.example.database.model.Todo;
import com.example.database.model.User;
import com.example.database.repository.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DemoContentConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(TodoRepository todoRepository) {
        return args -> {
            List<Assignable> a = new ArrayList<>();
            a.add(new Assignable());
            var answ = new AnswerSheet();

            var todo = new Todo("TODO 1 Test",a);
            todo.setAnswerSheetList(List.of(answ));

            User u = new User();
            u.setUsername("Enrico");
            answ.setUser(u);
            u.setAnswerSheetList(List.of(answ));
            var t = todoRepository.save(todo);
            System.out.println(t);
        };
    }
}

