package pl.swztz.portal.Repositories;

//import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.swztz.portal.Models.Zapytanie;

public interface ZapytanieRepository extends JpaRepository<Zapytanie, Long> {

	Zapytanie findById(Long id);
	//List<Zapytanie> findByNazwa(String value);
}