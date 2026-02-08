package io.github.cursospringboot.arquiteturaspring;

import io.github.cursospringboot.arquiteturaspring.todos.TodoEntity;
import io.github.cursospringboot.arquiteturaspring.todos.TodoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanGerenciado {

    @Autowired /** Injeção via propriedade */
    private TodoValidator validator;

    @Autowired /** Injeção via construtor (forma recomendada pelo spring)*/
    public BeanGerenciado(TodoValidator validator) {
        this.validator = validator;
    }

    public void utilizar() {
        var todo = new TodoEntity();
        validator.validarTodo(todo);
    }

    @Autowired /** Injeção via metodo setter */
    public void setValidator(TodoValidator validator) {
        this.validator = validator;
    }
}
