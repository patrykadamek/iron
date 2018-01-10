package pl.swztz.portal;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
/**
 * Klasa abstrakcyjna, po ktorej dziedzicza klasy operacji na formularzach
 * @author SWZTZ Team
 *
 */
public abstract class OknoElementu extends Window {
	
	private VerticalLayout layout = new VerticalLayout();
	private FormLayout form = new FormLayout();
	protected TextField tf[];
	private HorizontalLayout hlayout = new HorizontalLayout();
	protected Button ok = new Button("OK");
	private Button anuluj = new Button("Anuluj");
	
	/**
	 * Konstruktor klasy Okno Elementu
	 * @param nazwa Nazwa - tyutl okna
	 * @param nazwyPol Nazwy pol
	 * @param repo Repozytorium do tabel
	 */
	public OknoElementu(String nazwa, String[] nazwyPol, JpaRepository repo) {
		super(nazwa); // nazwa okienka
		
		tf = new TextField[nazwyPol.length];
		for(int i=0; i<nazwyPol.length; i++) {
			tf[i] = new TextField(nazwyPol[i]);
			form.addComponent(tf[i]);
		}
	
		hlayout.addComponents(ok, anuluj);
		layout.addComponents(form, hlayout);
		
		// listener przycisku anuluj
		anuluj.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				close();
			}
		});

		setWidth("40%");
		//setHeight("60%");
		
		setResizable(false); // zablokowanie zmiany rozmiaru okienka
		setDraggable(true); // zablokowanie przesuwania okienka
		setContent(layout); // ustaw glowny layout okienka
	}
}