package mk.ukim.finki.vpproekt.repository.jpa;

import mk.ukim.finki.vpproekt.model.Sesija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SesijaRepositoryJpa extends JpaRepository<Sesija, Long> {

    Sesija findSesijaById(Long id);

    Sesija findByOpis(String opis);

    List<Sesija> findAllBySesKol(String sesKol);
}
