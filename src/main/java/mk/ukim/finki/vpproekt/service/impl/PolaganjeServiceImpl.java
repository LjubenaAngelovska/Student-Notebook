package mk.ukim.finki.vpproekt.service.impl;

import mk.ukim.finki.vpproekt.model.*;
import mk.ukim.finki.vpproekt.model.exceptions.PredmetNotFoundException;
import mk.ukim.finki.vpproekt.repository.jpa.*;
import mk.ukim.finki.vpproekt.service.PolaganjeService;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PolaganjeServiceImpl implements PolaganjeService {

    private final PolaganjeRepositoryJpa polaganjeRepositoryJpa;
    private final StudentRepositoryJpa studentRepositoryJpa;
    private final PredmetRepositoryJpa predmetRepositoryJpa;
    private final PredmetFinkiRepositoryJpa predmetFinkiRepositoryJpa;
    private final SesijaRepositoryJpa sesijaRepositoryJpa;

    public PolaganjeServiceImpl(PolaganjeRepositoryJpa polaganjeRepositoryJpa, StudentRepositoryJpa studentRepositoryJpa, PredmetRepositoryJpa predmetRepositoryJpa, PredmetFinkiRepositoryJpa predmetFinkiRepositoryJpa, SesijaRepositoryJpa sesijaRepositoryJpa) {
        this.polaganjeRepositoryJpa = polaganjeRepositoryJpa;
        this.studentRepositoryJpa = studentRepositoryJpa;
        this.predmetRepositoryJpa = predmetRepositoryJpa;
        this.predmetFinkiRepositoryJpa = predmetFinkiRepositoryJpa;
        this.sesijaRepositoryJpa = sesijaRepositoryJpa;
    }

    @Override
    public List<Polaganje> listAll() {
        return polaganjeRepositoryJpa.findAll();
    }

    @Override
    public Optional<Polaganje> save(Long predmet_id, Date datumPolaganje, Long sesijaId, char teorijaPrakticno, char online, char polozen, double osvoeniPoeni) {



        Student student = this.studentRepositoryJpa.findStudentById(1L);

        Predmet predmet = this.predmetRepositoryJpa.findPredmetById(predmet_id);

        Sesija sesija = this.sesijaRepositoryJpa.findSesijaById(sesijaId);

        Polaganje polaganje = new Polaganje(predmet, sesija, datumPolaganje, online, polozen, osvoeniPoeni, teorijaPrakticno);
        this.polaganjeRepositoryJpa.save(polaganje);

        return Optional.of(polaganje);

    }

    @Override
    public List<Polaganje> findAllByDatumPolaganjeBefore(Date date) {
        return this.polaganjeRepositoryJpa.findAllByDatumPolaganjeBefore(date);
    }

    @Override
    public List<Polaganje> findAllByDatumPolaganjeAfter(Date date) {
        return this.polaganjeRepositoryJpa.findAllByDatumPolaganjeAfter(date);
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
