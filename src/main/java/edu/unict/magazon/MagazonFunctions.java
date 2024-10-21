package edu.unict.magazon;

import java.util.Map;
import java.util.function.Function;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Contiene le funzioni per la gestione di Magazon
@Configuration
public class MagazonFunctions {
    public String newProduct(String name, int quantity) {
        return "Aggiunto " + name + " in quantità " + quantity;
    }

    @Bean
    public Function<Map<String, Object>, String> newProductFunction() {
        return params -> {
            String name = (String) params.get("name");
            int quantity = (Integer) params.get("quantity");
            return newProduct(name, quantity);
        };
    }
}
