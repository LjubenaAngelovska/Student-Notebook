package mk.ukim.finki.vpproekt.repository.jpa;

import mk.ukim.finki.vpproekt.model.Predmet_Finki;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PredmetFinkiRepositoryJpa extends JpaRepository<Predmet_Finki, Long> {

    Predmet_Finki findPredmet_FinkiById(Long id);

    Optional<Predmet_Finki> findPredmet_FinkiByIme(String ime);
}
