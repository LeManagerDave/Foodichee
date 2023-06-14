package ch.fhnw.dish.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import ch.fhnw.dish.business.service.ShoppingCartService;

@Configuration
@ComponentScan("ch.fhnw.dish.business.service")
public class AppConfig {
    @Bean
    public ShoppingCartService shoppingCartService() {
        return new ShoppingCartService();
    }
}