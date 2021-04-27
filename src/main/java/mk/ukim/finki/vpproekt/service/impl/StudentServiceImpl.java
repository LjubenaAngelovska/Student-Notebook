package mk.ukim.finki.vpproekt.service.impl;

import mk.ukim.finki.vpproekt.model.Student;
import mk.ukim.finki.vpproekt.model.User;
import mk.ukim.finki.vpproekt.model.exceptions.UserNotFoundException;
import mk.ukim.finki.vpproekt.repository.jpa.StudentRepositoryJpa;
import mk.ukim.finki.vpproekt.repository.jpa.UserRepository;
import mk.ukim.finki.vpproekt.service.StudentService;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepositoryJpa studentRepositoryJpa;
    private final UserRepository userRepository;

    public StudentServiceImpl(StudentRepositoryJpa studentRepositoryJpa, UserRepository userRepository) {
        this.studentRepositoryJpa = studentRepositoryJpa;
        this.userRepository = userRepository;
    }

    @Override
    public List<Student> listAll() {
        return studentRepositoryJpa.findAll();
    }

    @Override
    public Optional<Student> save(String embg, String brojIndeks, String ime, String prezime, String grad, Date datumZapisuvanje, String email, String telefon, char redovenVonreden, String smer) {

        Student student = new Student(embg, brojIndeks, ime, prezime, grad, datumZapisuvanje, email, telefon, redovenVonreden, smer);
        this.studentRepositoryJpa.save(student);
        return Optional.of(student);
    }

    @Override
    public Student getActiveStudent(String username) {

        User user = this.userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username));

        return this.studentRepositoryJpa
                .findByUser(user)
                .orElseGet(() -> {
                    java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
                    //Student student = new Student("embg", "123", "ime", "prezime", "grad", sqlDate , "email", "telefon", 'r', "smer");
                    Student student = new Student(null, null, null, null,null,null,null,null,'x', null);
                    //Student student = new Student();
                    student.setUser(user);
                    return this.studentRepositoryJpa.save(student);
                });
    }

    @Override
    public Optional<Student> update(String username, String embg, String brojIndeks, String ime, String prezime, String grad, Date datumZapisuvanje, String email, String telefon, char redovenVonreden, String smer) {

        User user = this.userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username));

        Student student = this.studentRepositoryJpa.findByUser(user)
                .orElseThrow(() -> new UserNotFoundException(username));

        student.setEmbg(embg);
        student.setBrojIndeks(brojIndeks);
        student.setIme(ime);
        student.setPrezime(prezime);
        student.setGrad(grad);
        student.setDatumZapisuvanje(datumZapisuvanje);
        student.setEmail(email);
        student.setTelefon(telefon);
        student.setRedovenVonreden(redovenVonreden);
        student.setSmer(smer);

        return Optional.of(this.studentRepositoryJpa.save(student));
    }
}
