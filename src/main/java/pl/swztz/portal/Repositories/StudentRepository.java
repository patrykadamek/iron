package pl.swztz.portal.Repositories;

//import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.swztz.portal.Models.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	Student findById(Long id);
	//List<Student> findByNazwa(String value);
}