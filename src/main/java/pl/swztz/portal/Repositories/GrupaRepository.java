package pl.swztz.portal.Repositories;

//import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.swztz.portal.Models.Grupa;

public interface GrupaRepository extends JpaRepository<Grupa, Long> {

	Grupa findById(Long id);
	//List<Grupa> findByNazwa(String value);
}