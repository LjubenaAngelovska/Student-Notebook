package mk.ukim.finki.vpproekt.service.impl;

import mk.ukim.finki.vpproekt.model.Predmet;
import mk.ukim.finki.vpproekt.model.Student;
import mk.ukim.finki.vpproekt.repository.jpa.PredmetRepositoryJpa;
import mk.ukim.finki.vpproekt.service.PredmetService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PredmetServiceImpl implements PredmetService {

    private final PredmetRepositoryJpa predmetRepositoryJpa;

    public PredmetServiceImpl(PredmetRepositoryJpa predmetRepositoryJpa) {
        this.predmetRepositoryJpa = predmetRepositoryJpa;
    }

    @Override
    public List<Predmet> listAll() {
        return predmetRepositoryJpa.findAll();
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
