package mk.ukim.finki.vpproekt.service.impl;

import mk.ukim.finki.vpproekt.model.Predmet;
import mk.ukim.finki.vpproekt.model.Predmet_Finki;
import mk.ukim.finki.vpproekt.model.Student;
import mk.ukim.finki.vpproekt.repository.jpa.PredmetFinkiRepositoryJpa;
import mk.ukim.finki.vpproekt.repository.jpa.PredmetRepositoryJpa;
import mk.ukim.finki.vpproekt.repository.jpa.StudentRepositoryJpa;
import mk.ukim.finki.vpproekt.service.PredmetService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PredmetServiceImpl implements PredmetService {

    private final PredmetRepositoryJpa predmetRepositoryJpa;
    private final PredmetFinkiRepositoryJpa predmetFinkiRepositoryJpa;
    private final StudentRepositoryJpa studentRepositoryJpa;

    public PredmetServiceImpl(PredmetRepositoryJpa predmetRepositoryJpa, PredmetFinkiRepositoryJpa predmetFinkiRepositoryJpa, StudentRepositoryJpa studentRepositoryJpa) {
        this.predmetRepositoryJpa = predmetRepositoryJpa;
        this.predmetFinkiRepositoryJpa = predmetFinkiRepositoryJpa;
        this.studentRepositoryJpa = studentRepositoryJpa;
    }

    @Override
    public List<Predmet> listAll() {
        return predmetRepositoryJpa.findAll();
    }

    @Override
    public Optional<Predmet> save(String ime, String opis, String semestar, char zadolzitelen, char tekovnoZapisan, int kojPat, String semestarZapisan, char polozen, int ocenka) {

        Student student = this.studentRepositoryJpa.findStudentById(1L);

        Predmet_Finki predmetFinki = predmetFinkiRepositoryJpa.findPredmet_FinkiByIme(ime)
                .orElseGet(() -> this.predmetFinkiRepositoryJpa.save(new Predmet_Finki(ime, opis, semestar, zadolzitelen)));

        Predmet predmet = new Predmet(predmetFinki, student, tekovnoZapisan, kojPat, semestarZapisan, polozen, ocenka);
        this.predmetRepositoryJpa.save(predmet);

        return Optional.of(predmet);
    }

    @Override
    public Predmet findPredmetById(Long id) {
        return predmetRepositoryJpa.findPredmetById(id);
    }

    @Override
    public List<Predmet> findAllByStudent(Student student) {
        return predmetRepositoryJpa.findAllByStudent(student);
    }

    @Override
    public List<Predmet> findAllByTekovnoZapisan(char tekovnoZapisan) {
        return predmetRepositoryJpa.findAllByTekovnoZapisan(tekovnoZapisan);
    }

    @Override
    public List<Predmet> findAllByKojPat(int kojPat) {
        return predmetRepositoryJpa.findAllByKojPat(kojPat);
    }

    @Override
    public List<Predmet> findAllBySemestarZapisan(String semestarZapisan) {
        return predmetRepositoryJpa.findAllBySemestarZapisan(semestarZapisan);
    }

    @Override
    public List<Predmet> findAllByPolozen(char polozen) {
        return predmetRepositoryJpa.findAllByPolozen(polozen);
    }

    @Override
    public List<Predmet> findAllByOcenka(int ocenka) {
        return predmetRepositoryJpa.findAllByOcenka(ocenka);
    }
}
