package mk.ukim.finki.vpproekt.service.impl;

import mk.ukim.finki.vpproekt.model.Sesija;
import mk.ukim.finki.vpproekt.repository.jpa.SesijaRepositoryJpa;
import mk.ukim.finki.vpproekt.service.SesijaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SesijaServiceImpl implements SesijaService {

    private final SesijaRepositoryJpa sesijaRepositoryJpa;

    public SesijaServiceImpl(SesijaRepositoryJpa sesijaRepositoryJpa) {
        this.sesijaRepositoryJpa = sesijaRepositoryJpa;
    }

    @Override
    public List<Sesija> listAll() {
        return this.sesijaRepositoryJpa.findAll();
    }
}
