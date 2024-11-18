package edu.unict.magazon.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.unict.magazon.Models.MagazonUsersModel;
import edu.unict.magazon.Repositories.MagazonUsersRepository;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;

@RestController
@RequestMapping("/api/signup")
public class MagazonSignupController {
    private final MagazonUsersRepository userRepository;
    // private BCryptPasswordEncoder bCryptPasswordEncoder;

    public MagazonSignupController(MagazonUsersRepository repository) {
        userRepository = repository;
    }

    @GetMapping("/checkExistingEmail")
    public boolean checkEmail(@RequestParam String email) {
        if(userRepository.findByEmail(email) != null) return true;
        return false;
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody MagazonUsersModel userModel) {
      
        if (userModel.getUser_surname().isEmpty())
            userModel.setUser_surname(null);
        if (userModel.getAddress().isEmpty())
            userModel.setAddress(null);
        if (userModel.getNumber().isEmpty())
            userModel.setNumber(null);
        // userModel.setPassword(bCryptPasswordEncoder
        //         .encode(userModel.getPassword()));
        userRepository.save(userModel);
    }

}
