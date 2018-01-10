package pl.swztz.portal.Repositories;

//import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.swztz.portal.Models.Prowadzacy;

public interface ProwadzacyRepository extends JpaRepository<Prowadzacy, Long> {

	Prowadzacy findById(Long id);
	//List<Prowadzacy> findByNazwa(String value);
}