package io.github.cursospringboot.arquiteturaspring.todos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // não é obrigatória essa annotation
public interface TodoRepository extends JpaRepository<TodoEntity, Integer> {
}
