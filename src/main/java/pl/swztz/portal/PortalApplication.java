package pl.swztz.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
/**
 * Glowna klasa uruchomieniowa aplikacji
 * @author SWZTZ Team
 */
@SpringBootApplication
public class PortalApplication extends SpringBootServletInitializer {

	/**
	 * Glowna metoda uruchomieniowa aplikacji
	 * @param args Parametry startowe
	 */
	public static void main(String[] args) {
		SpringApplication.run(PortalApplication.class,args);
	}
	
	private static Class<PortalApplication> 
	applicationClass = PortalApplication.class;
		
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(applicationClass);
	}
}
