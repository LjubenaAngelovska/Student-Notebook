package mk.ukim.finki.vpproekt.service;

import mk.ukim.finki.vpproekt.model.Predmet;
import mk.ukim.finki.vpproekt.model.Predmet_Finki;
import mk.ukim.finki.vpproekt.model.Student;

import java.util.List;
import java.util.Optional;

public interface PredmetService {

    List<Predmet> listAll();

    Optional<Predmet> save(String ime, String opis, String semestar, char zadolzitelen, char tekovnoZapisan, int kojPat, String semestarZapisan, char polozen, int ocenka);

    Predmet findPredmetById(Long id);

    List<Predmet> findAllByStudent(Student student);

    List<Predmet> findAllByTekovnoZapisan(char tekovnoZapisan);

    List<Predmet> findAllByKojPat(int kojPat);

    List<Predmet> findAllBySemestarZapisan(String semestarZapisan);

    List<Predmet> findAllByPolozen(char polozen);

    List<Predmet> findAllByOcenka(int ocenka);
}
