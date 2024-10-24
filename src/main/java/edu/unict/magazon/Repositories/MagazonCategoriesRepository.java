package edu.unict.magazon.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unict.magazon.Models.MagazonCategoriesModel;

public interface MagazonCategoriesRepository extends JpaRepository<MagazonCategoriesModel, Long> {
    
}
