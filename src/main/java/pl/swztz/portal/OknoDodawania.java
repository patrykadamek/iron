package pl.swztz.portal;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
/**
 * Klasa Okna dodawnia elementu rozszerzajaca klase abstrakcyjna Okno Elementu
 * @author SWZTZ Team
 *
 */
public class OknoDodawania<T> extends OknoElementu {
 /**
  * Konstruktor klasy Okno Dodawania
  * @param nazwyPol Nazwy pol
  * @param repo Repozytorium do tabel
  * @param typ typ Obiektu
  */
	public OknoDodawania(String[] nazwyPol, JpaRepository repo, Class<T> typ) {
		super("Dodaj nowy element", nazwyPol, repo);
		
		ok.setCaption("Dodaj");
		
		// listener przycisku dodaj
		ok.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				try {
					//Class[] c = typ.getConstructors()[0].getParameterTypes();
					//c.length;
					T instance = (T) typ.getConstructors()[0].newInstance(getTextFiledValues());
					repo.save(instance);
				} catch (Exception e) {
					e.printStackTrace();
				}
				close();
			}
		});
	}
	
	/**
	 * Zwraca wartosci pol formularza w postaci stringa
	 * @return Zwracany string z wartosciami pol formularza
	 */
	String[] getTextFiledValues() {
		String[] s = new String[tf.length];
		for(int i=0; i<tf.length; i++)
			s[i] = tf[i].getValue();
		return s;
	}

}
