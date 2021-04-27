package mk.ukim.finki.vpproekt.service;

import mk.ukim.finki.vpproekt.model.Student;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> listAll();

    Optional<Student> save(String embg, String brojIndeks, String ime, String prezime, String grad, Date datumZapisuvanje, String email, String telefon, char redovenVonreden, String smer);

    Student getActiveStudent(String username);
}
