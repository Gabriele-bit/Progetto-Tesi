package edu.unict.magazon.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class MagazonIndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
