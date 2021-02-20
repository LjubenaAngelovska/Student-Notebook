package mk.ukim.finki.vpproekt.service.impl;

import mk.ukim.finki.vpproekt.model.Predmet_Finki;
import mk.ukim.finki.vpproekt.repository.jpa.PredmetFinkiRepositoryJpa;
import mk.ukim.finki.vpproekt.service.PredmetFinkiService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PredmetFinkiServiceImpl implements PredmetFinkiService {

    private final PredmetFinkiRepositoryJpa predmetFinkiRepositoryJpa;

    public PredmetFinkiServiceImpl(PredmetFinkiRepositoryJpa predmetFinkiRepositoryJpa) {
        this.predmetFinkiRepositoryJpa = predmetFinkiRepositoryJpa;
    }

    @Override
    public List<Predmet_Finki> listAll() {
        return predmetFinkiRepositoryJpa.findAll();
    }

    @Override
    public Optional<Predmet_Finki> findPredmet_FinkiByIme(String ime) {
        return predmetFinkiRepositoryJpa.findPredmet_FinkiByIme(ime);
    }

}
