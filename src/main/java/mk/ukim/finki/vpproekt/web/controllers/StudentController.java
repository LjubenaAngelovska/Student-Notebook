package mk.ukim.finki.vpproekt.web.controllers;

import mk.ukim.finki.vpproekt.model.Predmet;
import mk.ukim.finki.vpproekt.service.PolaganjeService;
import mk.ukim.finki.vpproekt.service.PredmetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping("/studentController")
public class StudentController {

    private final PredmetService predmetService;
    private final PolaganjeService polaganjeService;

    public StudentController(PredmetService predmetService, PolaganjeService polaganjeService) {
        this.predmetService = predmetService;
        this.polaganjeService = polaganjeService;
    }

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

        List<Predmet> predmeti = this.predmetService.listAll();
        model.addAttribute("predmeti", predmeti);

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
