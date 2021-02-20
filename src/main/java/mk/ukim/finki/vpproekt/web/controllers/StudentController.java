package mk.ukim.finki.vpproekt.web.controllers;

import mk.ukim.finki.vpproekt.model.Predmet;
import mk.ukim.finki.vpproekt.service.PolaganjeService;
import mk.ukim.finki.vpproekt.service.PredmetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


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

    @RequestMapping(value = "/izberiSemestar", method = RequestMethod.GET)
    public String izberiSemestar(Model model, @RequestParam("dd_semestar") String brSem) {

        if (brSem.equals("7")) {
            List<Predmet> predmeti = this.predmetService.listAll();
            model.addAttribute("predmeti", predmeti);
        } else {
            List<Predmet> predmeti = this.predmetService.findAllBySemestarZapisan(brSem);
            model.addAttribute("predmeti", predmeti);
        }
        return "predmeti-page";
    }

    @PostMapping("/add")
    public String savePredmet(@RequestParam String ime_nov_pr,
                              @RequestParam String opis_nov_pr,
                              @RequestParam char zadolz_nezadolz,
                              @RequestParam String sem_nov_pr,
                              @RequestParam String sem_zapisan_nov_pr,
                              @RequestParam int koj_pat_nov_pr,
                              @RequestParam char tek_zap_nov_pr,
                              @RequestParam char poloz_nov_pr,
                              @RequestParam int ocenka_nov_pr) {

        this.predmetService.save(ime_nov_pr, opis_nov_pr, sem_nov_pr, zadolz_nezadolz, tek_zap_nov_pr, koj_pat_nov_pr, sem_zapisan_nov_pr, poloz_nov_pr, ocenka_nov_pr);
        return "redirect:/studentController/predmetiPage";
    }

    @RequestMapping(value = "/sortiraj", method = RequestMethod.GET)
    public String sortiraj(Model model, @RequestParam("sortby") String sortby) {

        switch (sortby) {
            case "1": {
                List<Predmet> predmeti = this.predmetService.listAll()
                        .stream()
                        .sorted(Comparator.comparing(p -> p.getPredmetFinki().getIme()))
                        .collect(Collectors.toList());
                model.addAttribute("predmeti", predmeti);
                break;
            }
            case "2": {
                List<Predmet> predmeti = this.predmetService.listAll()
                        .stream()
                        .sorted(Comparator.comparing(Predmet::getKojPat))
                        .collect(Collectors.toList());
                model.addAttribute("predmeti", predmeti);
                break;
            }
            case "3": {
                List<Predmet> predmeti = this.predmetService.listAll()
                        .stream()
                        .sorted(Comparator.comparing(p -> p.getPredmetFinki().getZadolzitelen()))
                        .collect(Collectors.toList());
                model.addAttribute("predmeti", predmeti);
                break;
            }
            case "4": {
                List<Predmet> predmeti = this.predmetService.listAll()
                        .stream()
                        .sorted(Comparator.comparing(Predmet::getOcenka))
                        .collect(Collectors.toList());
                model.addAttribute("predmeti", predmeti);
                break;
            }
            case "5": {
                List<Predmet> predmeti = this.predmetService.listAll()
                        .stream()
                        .sorted(Comparator.comparing(Predmet::getPolozen))
                        .collect(Collectors.toList());
                model.addAttribute("predmeti", predmeti);
                break;
            }
            case "6": {
                List<Predmet> predmeti = this.predmetService.listAll()
                        .stream()
                        .sorted(Comparator.comparing(Predmet::getSemestarZapisan))
                        .collect(Collectors.toList());
                model.addAttribute("predmeti", predmeti);
                break;
            }
        }
        return "predmeti-page";
    }


}
