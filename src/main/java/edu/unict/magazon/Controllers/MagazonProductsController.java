package edu.unict.magazon.Controllers;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.unict.magazon.Repositories.MagazonProductsRepository;

@Controller
@RequestMapping("/products")
public class MagazonProductsController {
    private final MagazonProductsRepository repository;
    public MagazonProductsController(MagazonProductsRepository repository){
        this.repository= repository;
    }

    @GetMapping
    public String showProducts(Model model){
        model.addAttribute("products", repository.findAll());
        return "products";
    }
}
