package edu.unict.magazon.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.unict.magazon.Repositories.MagazonProductsRepository;
import edu.unict.magazon.Models.MagazonProductsModel;
@Controller
@RequestMapping("/Prodotti")
public class MagazonProductsController {
    private final MagazonProductsRepository repository;
    public MagazonProductsController(MagazonProductsRepository repository){
        this.repository= repository;
    }

    @GetMapping
    public ResponseEntity<List<MagazonProductsModel>> showProducts() {
        List<MagazonProductsModel> products = repository.findAll();
        return ResponseEntity.ok(products); // Restituisce i prodotti in formato JSON
    }
}
