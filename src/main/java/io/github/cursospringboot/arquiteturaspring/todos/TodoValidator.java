package io.github.cursospringboot.arquiteturaspring.todos;

import org.springframework.stereotype.Component;

@Component
public class TodoValidator {

    private TodoRepository repository;

    /** Construtor para injetar dependências do TodoRepository */
    public TodoValidator(TodoRepository repository) {
        this.repository = repository;
    }

    public void validarTodo(TodoEntity todo) {
        if (existeTodoComDescricao(todo.getDescricao())) {
            throw new IllegalArgumentException("Já existe um TODO com esta descricao");
        }
    }

    private boolean existeTodoComDescricao(String descricao) {
        return repository.existsByDescricao(descricao);
    }
}
