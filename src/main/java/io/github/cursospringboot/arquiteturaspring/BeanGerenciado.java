package io.github.cursospringboot.arquiteturaspring;

import io.github.cursospringboot.arquiteturaspring.todos.TodoEntity;
import io.github.cursospringboot.arquiteturaspring.todos.TodoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// singleton: Escopo padrão de qualquer bean
// singleton -> Padrão de projeto em que eu tenho uma instância única de um objeto que vai atender a toda a aplicação.
// prototype -> Padrão de projeto contrário ao singleton, para cada requisição, usuário, ele vai criar uma instância.

//@Scope("singleton")
//@Scope("request") -> Aplicação Web: Ao mandar uma requisição, o objeto so vai existir durante esta requisição, e depois o objeto vai morrer.
//@Scope("session") -> Aplicação Web: Objeto que vai durar, enquanto a sessão do usuário durar, interessante para guardar dados do usuário que esta logado, por exemplo. -> guarda estado
//@Scope("application") -> Aplicação Web: Parece com o session, mas se extende a todos os usuários. -> guarda estado

/** Ao invés de digitar dentro da annotation */
// @Scope(WebApplicationContext.SCOPE_REQUEST)
// @Scope(WebApplicationContext.SCOPE_SESSION)
// @Scope(WebApplicationContext.SCOPE_APPLICATION)

@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class BeanGerenciado {

    private String idUsuarioLogado;

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
