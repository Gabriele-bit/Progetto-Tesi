package edu.unict.magazon.Controllers;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.unict.magazon.MagazonNPLService;
import edu.unict.magazon.MagazonFunctions;
import org.springframework.http.ResponseEntity;

@Controller
@RequestMapping("/magazon")
public class MagazonController {
    private final MagazonFunctions magazonFunctions;
    private final MagazonNPLService openAIService;

    public MagazonController(MagazonFunctions magazonFunctions, MagazonNPLService openAIService) {
        this.magazonFunctions = magazonFunctions;
        this.openAIService = openAIService;
    }

    @PostMapping("/gestisci")
    //restituisce una risposta http (corpo, headers e stato)
    public ResponseEntity<String> handleRequest(@RequestBody String userInput) {
        String openAIresponse = openAIService.sendOpenAI(userInput);
        //se non è un json (cioè openAIresponse mi sta restitendo un errore, da correggere in seguito)
        if (!openAIresponse.startsWith("{")) {
            return ResponseEntity.badRequest().body("{\"message\": \"Risposta non valida da OpenAI\"}");
        }
        //altrimenti lo mappo in un hashmap
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
                    String responseMessage = magazonFunctions.newProductFunction().apply(params);
                    return ResponseEntity.ok("{\"message\": \"" + responseMessage + "\"}");
                }
                // Qui puoi aggiungere il supporto per altre funzioni
            }
            //la risposta di OpenAI non contiene una funzione da chiamare
            return ResponseEntity.badRequest().body("{\"message\": \"Richiesta non riconosciuta...\"}");

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("{\"message\": \"Errore nella lettura del JSON\"}");
        } catch (ClassCastException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("{\"message\": \"Errore durante il casting degli oggetti\"}");
        }
    }
}
