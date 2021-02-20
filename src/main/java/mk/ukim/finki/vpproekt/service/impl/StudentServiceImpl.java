package mk.ukim.finki.vpproekt.service.impl;

import mk.ukim.finki.vpproekt.model.Student;
import mk.ukim.finki.vpproekt.repository.jpa.StudentRepositoryJpa;
import mk.ukim.finki.vpproekt.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepositoryJpa studentRepositoryJpa;

    public StudentServiceImpl(StudentRepositoryJpa studentRepositoryJpa) {
        this.studentRepositoryJpa = studentRepositoryJpa;
    }

    @Override
    public List<Student> listAll() {
        return studentRepositoryJpa.findAll();
    }
}
