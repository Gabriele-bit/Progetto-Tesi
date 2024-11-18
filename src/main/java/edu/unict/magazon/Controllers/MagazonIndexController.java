package edu.unict.magazon.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MagazonIndexController {

     @RequestMapping(value = {"/", "/Catalogo", "/Catalogo/Prodotto/{id}","/Carrello", "/Wishlist", "/Profilo", "/Login", "/Registrazione"})
    public String index(){
        return "forward:/index.html";
    }

    
}
