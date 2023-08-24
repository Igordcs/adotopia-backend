package br.edu.ufape.poo.adotopia;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/adotopia")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
