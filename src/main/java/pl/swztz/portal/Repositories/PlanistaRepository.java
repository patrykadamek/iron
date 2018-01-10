package pl.swztz.portal.Repositories;

//import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.swztz.portal.Models.Planista;

public interface PlanistaRepository extends JpaRepository<Planista, Long> {

	Planista findById(Long id);
	//List<Planista> findByNazwa(String value);
}