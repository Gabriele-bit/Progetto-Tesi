package edu.unict.magazon.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.unict.magazon.Models.MagazonCategoriesModel;
import edu.unict.magazon.Repositories.MagazonCategoriesRepository;

@RestController
@RequestMapping("/api/categorie")
public class MagazonCategoriesController {
    private final MagazonCategoriesRepository categoriesRepository;

    public MagazonCategoriesController(MagazonCategoriesRepository categoriesRepository){
        this.categoriesRepository= categoriesRepository;
    }

    @GetMapping
    public  ResponseEntity<List<MagazonCategoriesModel>> showCategories() {
        List<MagazonCategoriesModel> categories = categoriesRepository.findAll();
        return ResponseEntity.ok(categories); 
    }
}
