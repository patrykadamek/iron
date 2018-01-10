package pl.swztz.portal.Repositories;

//import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.swztz.portal.Models.Konsultacja;

public interface KonsultacjaRepository extends JpaRepository<Konsultacja, Long> {

	Konsultacja findById(Long id);
	//List<Konsultacja> findByNazwa(String value);
}