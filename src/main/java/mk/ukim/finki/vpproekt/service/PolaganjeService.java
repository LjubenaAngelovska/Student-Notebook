package mk.ukim.finki.vpproekt.service;

import mk.ukim.finki.vpproekt.model.Polaganje;
import mk.ukim.finki.vpproekt.model.Predmet;
import mk.ukim.finki.vpproekt.model.Sesija;

import java.sql.Date;
import java.util.List;

public interface PolaganjeService {

    List<Polaganje> listAll();

    Polaganje findPolaganjeById(Long id);

    List<Polaganje> findAllByPredmet(Predmet predmet);

    List<Polaganje> findAllBySesija(Sesija sesija);

    List<Polaganje> findAllByDatumPolaganje(Date datumPolaganje);

    List<Polaganje> findAllByOnline(char online);

    List<Polaganje> findAllByPolozen(char polozen);

    List<Polaganje> findAllByOsvoeniPoeni(double osvoeniPoeni);

    List<Polaganje> findAllByTeorijaPrakticno(char teorijaPrakticno);
}
