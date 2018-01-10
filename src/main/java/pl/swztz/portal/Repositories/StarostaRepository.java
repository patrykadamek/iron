package pl.swztz.portal.Repositories;

//import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.swztz.portal.Models.Starosta;

public interface StarostaRepository extends JpaRepository<Starosta, Long> {

	Starosta findById(Long id);
	//List<Starosta> findByNazwa(String value);
}