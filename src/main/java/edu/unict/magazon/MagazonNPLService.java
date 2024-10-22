package edu.unict.magazon;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


@Service
// Classe per l'interazione con Open AI.
public class MagazonNPLService {
        private String openaiApiKey= System.getenv("openai.api.key");
        @Value("${openai.api.url}")
        private String openaiApiUrl;

        public String sendOpenAI(String userInput) {
                //deprecato?
                RestTemplate restTemplate = new RestTemplate();
                try {
                        // il corpo della richiesta API è una hashmap
                        Map<String, Object> body = new HashMap<>();
                        // Si specifica il modello
                        body.put("model", "gpt-3.5-turbo");
                        // Si crea un array messagges che contiene un solo elemento
                        body.put("messages", new Object[] {
                                        Map.of("role", "user", "content", userInput)
                        });
                        body.put("functions", new Object[] {
                                        Map.of(
                                                        "name", "newProduct",
                                                        "parameters", Map.of(
                                                                        "type", "object", //oggetto in input
                                                                        "properties", Map.of( //proprietà dell'oggetto
                                                                                        "name",
                                                                                        Map.of("type", "string"),
                                                                                        "quantity",
                                                                                        Map.of("type", "integer")),
                                                                        "required",
                                                                        new String[] { "name", "quantity" }))
                        });
                        body.put("function_call", "auto");

                        HttpHeaders headers = new HttpHeaders();
                        headers.set("Authorization", "Bearer " + openaiApiKey);
                        headers.set("Content-Type", "application/json");

                        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

                        // response definita come string, ma ha una struttura più elaborata (gestita in
                        // magazoncontroller) in JSON
                        String response = restTemplate.postForObject(openaiApiUrl, request, String.class);
                        return response;
                } catch (HttpClientErrorException e) {
                        // Cattura eventuali errori relativi alla richiesta HTTP
                        e.printStackTrace();
                        return "Errore durante la richiesta HTTP: " + e.getMessage();
                } catch (Exception e) {
                        // Cattura eventuali altre eccezioni
                        e.printStackTrace();
                        return "Si è verificato un errore: " + e.getMessage();
                }
        }
}