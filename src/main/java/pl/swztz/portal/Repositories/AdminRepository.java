package pl.swztz.portal.Repositories;

//import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.swztz.portal.Models.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

	Admin findById(Long id);
	//List<Admin> findByNazwa(String value);
}