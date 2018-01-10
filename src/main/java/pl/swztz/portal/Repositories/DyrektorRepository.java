package pl.swztz.portal.Repositories;

//import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.swztz.portal.Models.Dyrektor;

public interface DyrektorRepository extends JpaRepository<Dyrektor, Long> {

	Dyrektor findById(Long id);
	//List<Dyrektor> findByNazwa(String value);
}