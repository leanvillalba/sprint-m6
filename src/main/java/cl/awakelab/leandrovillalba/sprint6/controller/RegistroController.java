package cl.awakelab.leandrovillalba.sprint6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registro")
public class RegistroController {
    @GetMapping
    public String registro(){
        return "registro";
    }
}
