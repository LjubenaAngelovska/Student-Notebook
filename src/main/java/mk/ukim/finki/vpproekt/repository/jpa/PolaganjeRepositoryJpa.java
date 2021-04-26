package mk.ukim.finki.vpproekt.repository.jpa;

import mk.ukim.finki.vpproekt.model.Polaganje;
import mk.ukim.finki.vpproekt.model.Predmet;
import mk.ukim.finki.vpproekt.model.Sesija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface PolaganjeRepositoryJpa extends JpaRepository<Polaganje, Long> {

    Polaganje findPolaganjeById(Long id);

    List<Polaganje> findAllByPredmet(Predmet predmet);

    List<Polaganje> findAllBySesija(Sesija sesija);

    List<Polaganje> findAllByDatumPolaganje(Date datumPolaganje);

    List<Polaganje> findAllByOnline(char online);

    List<Polaganje> findAllByPolozen(char polozen);

    List<Polaganje> findAllByOsvoeniPoeni(double osvoeniPoeni);

    List<Polaganje> findAllByTeorijaPrakticno(char teorijaPrakticno);

    List<Polaganje> findAllByDatumPolaganjeBefore(Date date);

    List<Polaganje> findAllByDatumPolaganjeAfter(Date date);
}
