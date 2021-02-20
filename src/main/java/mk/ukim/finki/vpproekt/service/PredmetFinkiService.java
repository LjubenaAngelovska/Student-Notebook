package mk.ukim.finki.vpproekt.service;

import mk.ukim.finki.vpproekt.model.Predmet_Finki;

import java.util.List;
import java.util.Optional;

public interface PredmetFinkiService {

    List<Predmet_Finki> listAll();

    Optional<Predmet_Finki> findPredmet_FinkiByIme(String ime);

}
