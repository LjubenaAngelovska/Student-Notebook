package mk.ukim.finki.vpproekt.repository.jpa;

import mk.ukim.finki.vpproekt.model.Predmet;
import mk.ukim.finki.vpproekt.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PredmetRepositoryJpa extends JpaRepository<Predmet, Long> {

    Predmet findPredmetById(Long id);

    List<Predmet> findAllByStudent(Student student);

    List<Predmet> findAllByTekovnoZapisan(char tekovnoZapisan);

    List<Predmet> findAllByKojPat(int kojPat);

    List<Predmet> findAllBySemestarZapisan(String semestarZapisan);

    List<Predmet> findAllByPolozen(char polozen);

    List<Predmet> findAllByOcenka(int ocenka);

}
