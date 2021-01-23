package pl.sda.finalapp.users;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationUserController {

    @GetMapping("/login")
    public String displayLoginPage(){
        return "login";
    }

}
