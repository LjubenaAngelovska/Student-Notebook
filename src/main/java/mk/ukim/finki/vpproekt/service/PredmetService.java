package mk.ukim.finki.vpproekt.service;

import mk.ukim.finki.vpproekt.model.Predmet;
import mk.ukim.finki.vpproekt.model.Student;

import java.util.List;

public interface PredmetService {

    List<Predmet> listAll();

    Predmet findPredmetById(Long id);

    List<Predmet> findAllByStudent(Student student);

    List<Predmet> findAllByTekovnoZapisan(char tekovnoZapisan);

    List<Predmet> findAllByKojPat(int kojPat);

    List<Predmet> findAllBySemestarZapisan(String semestarZapisan);

    List<Predmet> findAllByPolozen(char polozen);

    List<Predmet> findAllByOcenka(int ocenka);
}
