package mk.ukim.finki.vpproekt.repository.jpa;

import mk.ukim.finki.vpproekt.model.Student;
import mk.ukim.finki.vpproekt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepositoryJpa extends JpaRepository<Student, Long> {

    Student findStudentById(Long id);

    Optional<Student> findByUser(User user);
}
