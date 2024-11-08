package edu.unict.magazon.Services;

import java.util.Map;
import java.util.function.Function;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

//Contiene le funzioni per la gestione di Magazon
@Configuration
public class MagazonFunctions {
    public String newProduct(String name, int quantity) {
        return "Aggiunto " + name + " in quantità " + quantity;
    }

    @Bean
    @Description("Add new product")
    public Function<Map<String, Object>, String> newProductFunction() {
        return params -> {
            String name = (String) params.get("name");
            int quantity = (Integer) params.get("quantity");
            return newProduct(name, quantity);
        };
    }
}
