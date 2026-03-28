package pl.com.pl.lab2;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/")
    public String publicPage() {
        return "index";
    }

    @GetMapping("/secured")
    public String securedPage(Authentication authentication, Model model) {
        if (authentication.getName().equals("admin")) {
            model.addAttribute("message", "Zalogowano administratora");
        } else {
            model.addAttribute("message", "Numer indeksu: 12345");
        }
        return "secured";
    }
}

