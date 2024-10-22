package edu.unict.magazon.Controllers;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.unict.magazon.MagazonNPLService;
import edu.unict.magazon.MagazonFunctions;

@Controller
@RequestMapping("/magazon")
public class MagazonController {
    private final MagazonFunctions magazonFunctions;
    private final MagazonNPLService openAIService;

    public MagazonController(MagazonFunctions magazonFunctions, MagazonNPLService openAIService) {
        this.magazonFunctions = magazonFunctions;
        this.openAIService = openAIService;
    }

    @GetMapping("/gestisci")
    public String handleRequest(@RequestBody String userInput) {
        String openAIresponse = openAIService.sendOpenAI(userInput);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Mappa la risposta in un HashMap
            Map<String, Object> responseMap = objectMapper.readValue(openAIresponse, HashMap.class);

            // Verifica se è presente una chiamata a funzione
            if (responseMap.containsKey("function_call")) {
                Map<String, Object> functionCall = (Map<String, Object>) responseMap.get("function_call");
                String functionName = (String) functionCall.get("name");

                // Verifica la funzione "newProduct"
                if ("newProduct".equals(functionName)) {
                    Map<String, Object> arguments = (Map<String, Object>) functionCall.get("arguments");
                    String productName = (String) arguments.get("name");
                    int quantity = (int) arguments.get("quantity");

                    //Prepara i parametri per la funzione
                    Map<String, Object> params = new HashMap<>();
                    params.put("nome", productName);
                    params.put("quantita", quantity);

                    // Chiama la funzione di aggiunta prodotto
                    return magazonFunctions.newProductFunction().apply(params);
                }
                // Qui puoi aggiungere il supporto per altre funzioni
            }
        } catch (IOException e) {
            // Gestione dell'errore di lettura JSON
            e.printStackTrace();
            return "Errore durante la gestione della richiesta";
        } catch (ClassCastException e) {
            // Gestione dell'errore di tipo
            e.printStackTrace();
            return "Errore durante il casting degli oggetti";
        }

        return "Richiesta non riconosciuta...";
    }
}
