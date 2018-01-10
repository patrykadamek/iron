package pl.swztz.portal.Repositories;

//import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.swztz.portal.Models.Instytut;

public interface InstytutRepository extends JpaRepository<Instytut, Long> {

	Instytut findById(Long id);
	//List<Instytut> findByNazwa(String value);
}