package io.github.cursospringboot.arquiteturaspring;

import io.github.cursospringboot.arquiteturaspring.todos.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracaoAcessoEmail {

    @Autowired
    private AppProperties properties;

    @Bean
    public MailSender mailSender() { // Faz a conexão com o email pegando as propriedades
        String host = properties.getVariavel();
        Integer port = properties.getValor1();
        return new MailSender();
    }
}
