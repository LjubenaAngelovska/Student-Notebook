package mk.ukim.finki.vpproekt.service.impl;

import mk.ukim.finki.vpproekt.model.Polaganje;
import mk.ukim.finki.vpproekt.model.Predmet;
import mk.ukim.finki.vpproekt.model.Sesija;
import mk.ukim.finki.vpproekt.repository.jpa.PolaganjeRepositoryJpa;
import mk.ukim.finki.vpproekt.service.PolaganjeService;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class PolaganjeServiceImpl implements PolaganjeService {

    private final PolaganjeRepositoryJpa polaganjeRepositoryJpa;

    public PolaganjeServiceImpl(PolaganjeRepositoryJpa polaganjeRepositoryJpa) {
        this.polaganjeRepositoryJpa = polaganjeRepositoryJpa;
    }

    @Override
    public List<Polaganje> listAll() {
        return polaganjeRepositoryJpa.findAll();
    }

    @Override
    public Polaganje findPolaganjeById(Long id) {
        return polaganjeRepositoryJpa.findPolaganjeById(id);
    }

    @Override
    public List<Polaganje> findAllByPredmet(Predmet predmet) {
        return polaganjeRepositoryJpa.findAllByPredmet(predmet);
    }

    @Override
    public List<Polaganje> findAllBySesija(Sesija sesija) {
        return polaganjeRepositoryJpa.findAllBySesija(sesija);
    }

    @Override
    public List<Polaganje> findAllByDatumPolaganje(Date datumPolaganje) {
        return polaganjeRepositoryJpa.findAllByDatumPolaganje(datumPolaganje);
    }

    @Override
    public List<Polaganje> findAllByOnline(char online) {
        return polaganjeRepositoryJpa.findAllByOnline(online);
    }

    @Override
    public List<Polaganje> findAllByPolozen(char polozen) {
        return polaganjeRepositoryJpa.findAllByPolozen(polozen);
    }

    @Override
    public List<Polaganje> findAllByOsvoeniPoeni(double osvoeniPoeni) {
        return polaganjeRepositoryJpa.findAllByOsvoeniPoeni(osvoeniPoeni);
    }

    @Override
    public List<Polaganje> findAllByTeorijaPrakticno(char teorijaPrakticno) {
        return polaganjeRepositoryJpa.findAllByTeorijaPrakticno(teorijaPrakticno);
    }
}
