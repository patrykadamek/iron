package pl.swztz.portal.Repositories;

//import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.swztz.portal.Models.Wniosek;

public interface WniosekRepository extends JpaRepository<Wniosek, Long> {

	Wniosek findById(Long id);
	//List<Wniosek> findByNazwa(String value);
}