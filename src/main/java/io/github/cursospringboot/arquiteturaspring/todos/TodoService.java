package io.github.cursospringboot.arquiteturaspring.todos;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private TodoRepository repository;
    private TodoValidator validator;
    private MailSender mailSender;

    public TodoService(TodoRepository todoRepository,
                       TodoValidator todoValidator,
                       MailSender mailSender) {
        this.repository = todoRepository;
        this.validator = todoValidator;
        this.mailSender = mailSender;
    }

    public TodoEntity salvar(TodoEntity todoEntity) {
        validator.validarTodo(todoEntity);
        return repository.save(todoEntity);
    }

    public void atualizarStatus(TodoEntity todo) {
        repository.save(todo);
        String status = todo.getConcluido() == Boolean.TRUE ? "Concluído" : "Não concluído";
        mailSender.enviarEmail("Todo " + todo.getDescricao() + " foi atualizado para " + status);
    }

    public TodoEntity buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
