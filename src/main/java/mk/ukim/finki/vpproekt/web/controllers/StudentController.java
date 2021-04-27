package mk.ukim.finki.vpproekt.web.controllers;

import mk.ukim.finki.vpproekt.model.Polaganje;
import mk.ukim.finki.vpproekt.model.Predmet;
import mk.ukim.finki.vpproekt.model.Sesija;
import mk.ukim.finki.vpproekt.model.Student;
import mk.ukim.finki.vpproekt.model.exceptions.InvalidArgumentsException;
import mk.ukim.finki.vpproekt.model.exceptions.PasswordsDoNotMatchException;
import mk.ukim.finki.vpproekt.service.PolaganjeService;
import mk.ukim.finki.vpproekt.service.PredmetService;
import mk.ukim.finki.vpproekt.service.SesijaService;
import mk.ukim.finki.vpproekt.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping(value = {"/", "/studentController"})
public class StudentController {

    private final PredmetService predmetService;
    private final PolaganjeService polaganjeService;
    private final SesijaService sesijaService;
    private final StudentService studentService;

    public StudentController(PredmetService predmetService, PolaganjeService polaganjeService, SesijaService sesijaService, StudentService studentService) {
        this.predmetService = predmetService;
        this.polaganjeService = polaganjeService;
        this.sesijaService = sesijaService;
        this.studentService = studentService;
    }

    @GetMapping
    public String getHomePage(@RequestParam(required = false) String error, Model model) {

        List<Predmet> predmeti = this.predmetService.listAll();
        model.addAttribute("predmeti", predmeti);

        return "predmeti-page";
    }

    @GetMapping("/access_denied")
    public String getAccessDeniedPage(Model model) {
        return "access_denied";
    }

    @GetMapping("/predmetiPage")
    public String getPredmetiPage(@RequestParam(required = false) String error, Model model) {

        List<Predmet> predmeti = this.predmetService.listAll();
        model.addAttribute("predmeti", predmeti);

        return "predmeti-page";
    }

    @GetMapping("/polaganjaPage")
    public String getPolaganjaPage(@RequestParam(required = false) String error, Model model) {

        List<Polaganje> polaganja = this.polaganjeService.listAll();
        model.addAttribute("polaganja", polaganja);

        List<Predmet> predmeti = this.predmetService.listAll();
        model.addAttribute("predmeti", predmeti);

        List<Sesija> sesii =  this.sesijaService.listAll();
        model.addAttribute("sesii", sesii);

        java.sql.Date today = new java.sql.Date(System.currentTimeMillis());

        List<Polaganje> minatiPolaganja = this.polaganjeService.findAllByDatumPolaganjeBefore(today);
        List<Polaganje> idniPolaganja = this.polaganjeService.findAllByDatumPolaganjeAfter(today);
        model.addAttribute("minatiPolaganja", minatiPolaganja);
        model.addAttribute("idniPolaganja", idniPolaganja);

        return "polaganja-page";
    }

    @GetMapping("/mojProfilPage")
    public String getMojProfilPage(@RequestParam(required = false) String error, HttpServletRequest req, Model model) {

        String username = req.getRemoteUser();
        Student student = this.studentService.getActiveStudent(username);
        model.addAttribute("student", student);

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


    @PostMapping("/addPolaganje")
    public String savePolaganje(@RequestParam Long predmet_polag,
                              @RequestParam Date date_polag,
                              @RequestParam Long ses_polag,
                              @RequestParam char tip_polag,
                              @RequestParam char nacin_polag,
                              @RequestParam char polozen_cb,
                              @RequestParam double poeni_inp) {

        this.polaganjeService.save(predmet_polag, date_polag, ses_polag, tip_polag, nacin_polag, polozen_cb, poeni_inp);
        return "redirect:/studentController/polaganjaPage";
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

    @RequestMapping(value = "/sortirajPolaganja", method = RequestMethod.GET)
    public String sortirajPolaganja(Model model, @RequestParam("sortby") String sortby) {

        java.sql.Date today = new java.sql.Date(System.currentTimeMillis());

        switch (sortby) {
            case "1": {
                List<Polaganje> idniPolaganja = this.polaganjeService.findAllByDatumPolaganjeAfter(today)
                        .stream()
                        .sorted(Comparator.comparing(Polaganje::getDatumPolaganje).reversed())
                        .collect(Collectors.toList());
                model.addAttribute("idniPolaganja", idniPolaganja);

                List<Polaganje> minatiPolaganja = this.polaganjeService.findAllByDatumPolaganjeBefore(today)
                        .stream()
                        .sorted(Comparator.comparing(Polaganje::getDatumPolaganje).reversed())
                        .collect(Collectors.toList());
                model.addAttribute("minatiPolaganja", minatiPolaganja);

                break;
            }
            case "2": {
                List<Polaganje> idniPolaganja = this.polaganjeService.findAllByDatumPolaganjeAfter(today)
                        .stream()
                        .sorted(Comparator.comparing(p -> p.getPredmet().getPredmetFinki().getIme()))
                        .collect(Collectors.toList());
                model.addAttribute("idniPolaganja", idniPolaganja);

                List<Polaganje> minatiPolaganja = this.polaganjeService.findAllByDatumPolaganjeBefore(today)
                        .stream()
                        .sorted(Comparator.comparing(p -> p.getPredmet().getPredmetFinki().getIme()))
                        .collect(Collectors.toList());
                model.addAttribute("minatiPolaganja", minatiPolaganja);

                break;
            }
            case "3": {
                List<Polaganje> idniPolaganja = this.polaganjeService.findAllByDatumPolaganjeAfter(today)
                        .stream()
                        .sorted(Comparator.comparing(p -> p.getSesija().getDatumOd()))
                        .collect(Collectors.toList());
                model.addAttribute("idniPolaganja", idniPolaganja);

                List<Polaganje> minatiPolaganja = this.polaganjeService.findAllByDatumPolaganjeBefore(today)
                        .stream()
                        .sorted(Comparator.comparing(p -> p.getSesija().getDatumOd()))
                        .collect(Collectors.toList());
                model.addAttribute("minatiPolaganja", minatiPolaganja);

                break;
            }
            case "4": {
                List<Polaganje> idniPolaganja = this.polaganjeService.findAllByDatumPolaganjeAfter(today)
                        .stream()
                        .sorted(Comparator.comparing(Polaganje::getTeorijaPrakticno))
                        .collect(Collectors.toList());
                model.addAttribute("idniPolaganja", idniPolaganja);

                List<Polaganje> minatiPolaganja = this.polaganjeService.findAllByDatumPolaganjeBefore(today)
                        .stream()
                        .sorted(Comparator.comparing(Polaganje::getTeorijaPrakticno))
                        .collect(Collectors.toList());
                model.addAttribute("minatiPolaganja", minatiPolaganja);

                break;
            }
            case "5": {
                List<Polaganje> idniPolaganja = this.polaganjeService.findAllByDatumPolaganjeAfter(today)
                        .stream()
                        .sorted(Comparator.comparing(Polaganje::getOnline))
                        .collect(Collectors.toList());
                model.addAttribute("idniPolaganja", idniPolaganja);

                List<Polaganje> minatiPolaganja = this.polaganjeService.findAllByDatumPolaganjeBefore(today)
                        .stream()
                        .sorted(Comparator.comparing(Polaganje::getOnline))
                        .collect(Collectors.toList());
                model.addAttribute("minatiPolaganja", minatiPolaganja);

                break;
            }
            case "6": {
                List<Polaganje> idniPolaganja = this.polaganjeService.findAllByDatumPolaganjeAfter(today)
                        .stream()
                        .sorted(Comparator.comparing(Polaganje::getOsvoeniPoeni))
                        .collect(Collectors.toList());
                model.addAttribute("idniPolaganja", idniPolaganja);

                List<Polaganje> minatiPolaganja = this.polaganjeService.findAllByDatumPolaganjeBefore(today)
                        .stream()
                        .sorted(Comparator.comparing(Polaganje::getOsvoeniPoeni))
                        .collect(Collectors.toList());
                model.addAttribute("minatiPolaganja", minatiPolaganja);

                break;
            }
            case "7": {
                List<Polaganje> idniPolaganja = this.polaganjeService.findAllByDatumPolaganjeAfter(today)
                        .stream()
                        .sorted(Comparator.comparing(Polaganje::getPolozen))
                        .collect(Collectors.toList());
                model.addAttribute("idniPolaganja", idniPolaganja);

                List<Polaganje> minatiPolaganja = this.polaganjeService.findAllByDatumPolaganjeBefore(today)
                        .stream()
                        .sorted(Comparator.comparing(Polaganje::getPolozen))
                        .collect(Collectors.toList());
                model.addAttribute("minatiPolaganja", minatiPolaganja);

                break;
            }
        }

        return "polaganja-page";
    }

    @PostMapping("/registerStudent")
    public String registerStudent(@RequestParam String username,
                                  @RequestParam String embg,
                                  @RequestParam String brojIndeks,
                                  @RequestParam String ime,
                                  @RequestParam String prezime,
                                  @RequestParam String grad,
                                  @RequestParam Date datumZapisuvanje,
                                  @RequestParam String email,
                                  @RequestParam String telefon,
                                  @RequestParam char redovenVonreden,
                                  @RequestParam String smer) {
        try{
            this.studentService.update(username, embg, brojIndeks, ime, prezime, grad, datumZapisuvanje, email, telefon, redovenVonreden, smer);
            return "redirect:/predmetiPage";

        } catch (InvalidArgumentsException | PasswordsDoNotMatchException exception) {
            return "redirect:/register?error=" + exception.getMessage();
        }
    }

    @DeleteMapping("/deletePredmet/{id}")
    public String deletePredmet(@PathVariable Long id) {
        this.predmetService.deleteById(id);
        return "redirect:/predmetiPage";
    }

    @DeleteMapping("/deletePolaganje/{id}")
    public String deletePolaganje(@PathVariable Long id) {
        this.polaganjeService.deleteById(id);
        return "redirect:/polaganjaPage";
    }

}
