package pl.swztz.portal.Repositories;

//import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.swztz.portal.Models.Sala;

public interface SalaRepository extends JpaRepository<Sala, Long> {

	Sala findById(Long id);
	//List<Sala> findByNazwa(String value);
}