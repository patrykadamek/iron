package pl.swztz.portal;

import java.lang.reflect.Method;
import org.springframework.data.jpa.repository.JpaRepository;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

/**
 * Klasa Okna edycji elementu rozszerzajaca klase abstrakcyjna Okno Elementu
 * @author SWZTZ Team
 *
 */
public class OknoEdycji<T> extends OknoElementu {

	private T obiekt;
	private Class<T> typ;
	private Method toStringArray, setAll;
	
	/**
	 * Konstrukotr klasy Okno Edycji
	 * @param nazwyPol Nazwy pol
	 * @param repo Repozytorium do tabel
	 * @param typ Typ obiektu
	 * @param obiekt Obiekt przekazywany
	 */
	public OknoEdycji(String[] nazwyPol, JpaRepository repo, Class<T> typ, T obiekt) {
		super("Edytuj element", nazwyPol, repo);
		this.obiekt = obiekt;
		this.typ = typ;
		
		getMethods();		
		loadToForm();
		
		ok.setCaption("Wprowadź zmiany");	
		// listener przycisku dodaj
		ok.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				updateObiekt();
				repo.save(obiekt); 
				close();
			}
		});
	}
	
	/**
	 * Funkcja pobiera wszystkie pola i zwraca je jako tablice stringow
	 */
	private void getMethods() {
		Method[] allMethods = typ.getDeclaredMethods();

		for(Method x : allMethods) {
			if(x.getName() == "toStringArray")
				toStringArray = x;
			if(x.getName() == "setAll")
				setAll = x;
		}
	}

	/**
	 * Funkcja ladujaca wszystkie pola do formularza
	 */
	private void loadToForm() {
		//Field[] pola = typ.getFields();
		String[] s = new String[tf.length];
		
		try {
			s = (String[]) toStringArray.invoke(obiekt);
			
			for(int i=0; i<tf.length; i++)
				tf[i].setValue(s[i]);
			
			/*for(int i=0; i<pola.length; i++)
				s[i] = (String) pola[i].get(obiekt);*/

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Funkcja aktualizujaca element na podstawie wpisow dokonanych przez uzytkownika w formularzu
	 */
	private void updateObiekt() {
		String[] s = new String[tf.length];
		for(int i=0; i<tf.length; i++) {
			if(!tf[i].isEmpty())
				s[i] = tf[i].getValue();
			else s[i] = "-";
		}
		
		try {
			setAll.invoke(obiekt, s);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}