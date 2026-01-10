package io.github.cursospringboot.arquiteturaspring.todos;

import org.springframework.stereotype.Component;

@Component
public class MailSender {

    public void enviarEmail(String mensagem) {
        System.out.println("Enviado email: " + mensagem);
    }
}
