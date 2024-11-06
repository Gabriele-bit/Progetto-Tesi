package edu.unict.magazon.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MagazonIndexController {

     @RequestMapping(value = {"/", "/Prodotti", "/Prodotto/{id}","/Carrello", "/Wishlist", "/Profilo"})
    public String index(){
        return "forward:/index.html";
    }

    
}
