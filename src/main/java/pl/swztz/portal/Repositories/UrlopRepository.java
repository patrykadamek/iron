package pl.swztz.portal.Repositories;

//import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.swztz.portal.Models.Urlop;

public interface UrlopRepository extends JpaRepository<Urlop, Long> {

	Urlop findById(Long id);
	//List<Urlop> findByNazwa(String value);
}