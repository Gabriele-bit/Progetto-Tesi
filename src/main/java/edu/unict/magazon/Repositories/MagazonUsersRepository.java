package edu.unict.magazon.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unict.magazon.Models.MagazonUsersModel;

public interface MagazonUsersRepository extends JpaRepository<MagazonUsersModel,Long> {

    MagazonUsersModel findByEmail(String email);
    MagazonUsersModel findByUserName(String userName);
    MagazonUsersModel findByPassword(String checkPassword);
}
