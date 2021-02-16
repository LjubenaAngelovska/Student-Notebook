package mk.ukim.finki.vpproekt.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/studentController")
public class StudentController {

    @GetMapping
    public String getHomePage(@RequestParam(required = false) String error, Model model) {
        return "home-page";
    }

    @GetMapping("/polaganjaPage")
    public String getPolaganjaPage(@RequestParam(required = false) String error, Model model) {
        return "polaganja-page";
    }

    @GetMapping("/predmetiPage")
    public String getPredmetiPage(@RequestParam(required = false) String error, Model model) {
        return "predmeti-page";
    }

    @GetMapping("/rasporedPage")
    public String getRasporedPage(@RequestParam(required = false) String error, Model model) {
        return "raspored-page";
    }
    @GetMapping("/mojProfilPage")
    public String getMojProfilPage(@RequestParam(required = false) String error, Model model) {
        return "mojprofil-page";
    }


}
