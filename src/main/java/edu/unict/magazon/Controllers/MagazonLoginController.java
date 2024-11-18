package edu.unict.magazon.Controllers;

import edu.unict.magazon.Models.MagazonUsersModel;
import edu.unict.magazon.Repositories.MagazonUsersRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class MagazonLoginController {

    private MagazonUsersRepository userRepo;

    public MagazonLoginController(MagazonUsersRepository repo){
        this.userRepo=repo;
    }

    @PostMapping("/checkUser")
    public boolean checkUser(@RequestBody MagazonUsersModel user) {
        String checkEmail= user.getEmail();
        String checkPassword= user.getPassword();
        if(userRepo.findByEmail(checkEmail)!=null && userRepo.findByPassword(checkPassword)!=null) return true;
        else return false;
    }
}
