package edu.unict.magazon.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import edu.unict.magazon.Models.MagazonProductsModel;
import edu.unict.magazon.Repositories.MagazonCategoriesRepository;
import edu.unict.magazon.Repositories.MagazonProductsRepository;

@Controller
@RequestMapping("/product")
public class MagazonProductController {
    private final MagazonProductsRepository products_repository;
    private final MagazonCategoriesRepository categories_repository;

    public MagazonProductController(MagazonProductsRepository products_repository,
            MagazonCategoriesRepository categories_repository) {
        this.products_repository = products_repository;
        this.categories_repository = categories_repository;
    }

    @GetMapping
    public String getProduct(Model model) {
        model.addAttribute("product", new MagazonProductsModel());
        model.addAttribute("categories", categories_repository.findAll());
        return "product";
    }

     @GetMapping(path = "/{id}")
     public String getProductById(Model model, @PathVariable Long id) {
         model.addAttribute("product", products_repository.getReferenceById(id));
         model.addAttribute("categories", categories_repository.findAll());
         return "product";
     }

    @GetMapping(path = "/delete/{id}")
    public String deleteProduct(Model model, @PathVariable Long id) {
        MagazonProductsModel p = products_repository.getReferenceById(id);
        products_repository.delete(p);
        return "redirect:/products";
    }

    @PostMapping
    public String saveProduct(@ModelAttribute MagazonProductsModel p, Model model) {
        products_repository.save(p);
        return "redirect:/products";
    }
}
