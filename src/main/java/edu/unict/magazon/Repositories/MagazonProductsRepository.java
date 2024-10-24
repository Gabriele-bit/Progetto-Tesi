package edu.unict.magazon.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unict.magazon.Models.MagazonProductsModel;

public interface MagazonProductsRepository extends JpaRepository<MagazonProductsModel, Long> {
    
}
