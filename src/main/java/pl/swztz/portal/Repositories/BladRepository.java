package pl.swztz.portal.Repositories;

//import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.swztz.portal.Models.Blad;

public interface BladRepository extends JpaRepository<Blad, Long> {

	Blad findById(Long id);
	//List<Blad> findByNazwa(String value);
}