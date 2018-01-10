package pl.swztz.portal.Repositories;

//import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.swztz.portal.Models.Inspekcja;

public interface InspekcjaRepository extends JpaRepository<Inspekcja, Long> {

	Inspekcja findById(Long id);
	//List<Inspekcja> findByNazwa(String value);
}