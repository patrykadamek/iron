package pl.swztz.portal;

import org.springframework.beans.factory.annotation.Autowired;
import com.vaadin.annotations.Theme;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Window.CloseEvent;
import com.vaadin.ui.Window.CloseListener;
import pl.swztz.portal.Models.*;
import pl.swztz.portal.Repositories.*;
/**
 * Klasa Frameworka Vaadin
 * @author SWZTZ Team
 *
 */
@SpringUI
@Theme("mytheme")
public class VaadinUI extends UI {
	
	// repozytoria do tabel sql
	private ZapytanieRepository zapytanieRepo;
	private KonsultacjaRepository konsultacjaRepo;
	private WniosekRepository wniosekRepo;
	private UrlopRepository urlopRepo;
	private InspekcjaRepository inspekcjaRepo;
	private SalaRepository salaRepo;
	private GrupaRepository grupaRepo;
	private StudentRepository studentRepo;
	private StarostaRepository starostaRepo;
	private ProwadzacyRepository prowadzacyRepo;
	private InstytutRepository instytutRepo;
	private DyrektorRepository dyrektorRepo;
	private PlanistaRepository planistaRepo;
	private AdminRepository adminRepo;
	private BladRepository bladRepo;
	
	// rozdzielczosc ekranu
	private static int resX, resY;
	
	// elementy UI
	private Image logo;
	private Label tytul;
	private Button[] przyciskApp = new Button[19];
	private CustomLayout customLayout;
	private Panel panel1;
	private HorizontalLayout layout;
	private OknoAplikacji oknoAplikacji;
	
	/**
	 * Kontruktor VaadinUI
	 * 
	 * @param zapytanieRepo repzytorium do tabeli zapytania
	 * @param konsultacjaRepo repzytorium do tabeli
	 * @param wniosekRepo repzytorium do tabeli wnioski
	 * @param urlopRepo repzytorium do tabeli urlopy
	 * @param inspekcjaRepo repzytorium do tabeli inspekcje
 	 * @param salaRepo repzytorium do tabeli sale
	 * @param grupaRepo repzytorium do tabeli grupy
	 * @param studentRepo repzytorium do tabeli studenci 
	 * @param starostaRepo repzytorium do tabeli starosci
	 * @param prowadzacyRepo repzytorium do tabeli prowadzacy
	 * @param instytutRepo repzytorium do tabeli instytuty
	 * @param dyrektorRepo repzytorium do tabeli dyrektorzy
	 * @param planistaRepo repzytorium do tabeli planisci
	 * @param adminRepo repzytorium do tabeli  admini
	 * @param bladRepo repzytorium do tabeli bledy
	 */
	@Autowired
	public VaadinUI(ZapytanieRepository zapytanieRepo,KonsultacjaRepository konsultacjaRepo, WniosekRepository wniosekRepo, UrlopRepository urlopRepo, InspekcjaRepository inspekcjaRepo,
			SalaRepository salaRepo, GrupaRepository grupaRepo, StudentRepository studentRepo, StarostaRepository starostaRepo, ProwadzacyRepository prowadzacyRepo,
			InstytutRepository instytutRepo, DyrektorRepository dyrektorRepo, PlanistaRepository planistaRepo, AdminRepository adminRepo, BladRepository bladRepo) {
		this.zapytanieRepo = zapytanieRepo;
		this.konsultacjaRepo = konsultacjaRepo;
		this.wniosekRepo = wniosekRepo;
		this.urlopRepo = urlopRepo;
		this.inspekcjaRepo = inspekcjaRepo;
		this.salaRepo = salaRepo;
		this.grupaRepo = grupaRepo;
		this.studentRepo = studentRepo;
		this.starostaRepo = starostaRepo;
		this.prowadzacyRepo = prowadzacyRepo;
		this.instytutRepo = instytutRepo;
		this.dyrektorRepo = dyrektorRepo;
		this.planistaRepo = planistaRepo;
		this.adminRepo = adminRepo;
		this.bladRepo = bladRepo;
	}

	/**
	 * Inicjalizacja widoku głównego
	 */
	@Override
	protected void init(VaadinRequest request) {
		
		// pobierz rozdzielczosc ekranu
		resX = (int) UI.getCurrent().getPage().getBrowserWindowWidth();
		resY = (int) UI.getCurrent().getPage().getBrowserWindowHeight();
		
		// inicjalizacja elementow UI
		initComponents();
						
		// dodaj komponenty do layoutu i go ustaw
		setPageContent();

		// dodaj listenery do przyciskow
		addListeners();
		
		lockButtons(); //
		unlockButtons(); //
	}
	
	/**
	 * Inicjalizacja elementow UI
	 */
	private void initComponents() {
		logo = new Image("", new ThemeResource("images/logo.png"));
		logo.setWidth("118px");
		logo.setHeight("93px");
		
		tytul = new Label("System Wspomagania Zmiany Terminu Zajęć");
		tytul.setStyleName("tytul");
		
		przyciskApp[0] = new Button ("Plany zajęć"); //-
		przyciskApp[1] = new Button ("Ankiety o zmianę terminu zajęć"); //-
		przyciskApp[2] = new Button ("Zapytania o zmianę terminu zajęć");
		przyciskApp[3] = new Button ("Wiadomości"); //-
		przyciskApp[4] = new Button ("Konsultacje");
		przyciskApp[5] = new Button ("Wnioski o przeniesienie zajęć");
		przyciskApp[6] = new Button ("Listy obecności"); //-
		przyciskApp[7] = new Button ("Urlopy");
		przyciskApp[8] = new Button ("Inspekcje");
		przyciskApp[9] = new Button ("Sale");
		przyciskApp[10] = new Button ("Grupy studenckie");
		przyciskApp[11] = new Button ("Studenci");
		przyciskApp[12] = new Button ("Starości grup studenckich");
		przyciskApp[13] = new Button ("Prowadzący zajęcia");
		przyciskApp[14] = new Button ("Instytuty");
		przyciskApp[15] = new Button ("Dyrektorzy instytutów");
		przyciskApp[16] = new Button ("Planiści");
		przyciskApp[17] = new Button ("Administratorzy");
		przyciskApp[18] = new Button ("Błędy");
		
		for(int i=0; i<19; i++) {
			przyciskApp[i].removeStyleNames("mytheme", "v-widget");
		}
	}
	
	/**
	 *Dodanie elementow do GUI 
	 */
	private void setPageContent() {
		customLayout = new CustomLayout("mylayout");
		customLayout.addComponent(logo, "logo");
		customLayout.addComponent(tytul, "tytul");
		customLayout.addComponent(przyciskApp[0], "przyciskApp0");
		customLayout.addComponent(przyciskApp[1], "przyciskApp1");
		customLayout.addComponent(przyciskApp[2], "przyciskApp2");
		customLayout.addComponent(przyciskApp[3], "przyciskApp3");
		customLayout.addComponent(przyciskApp[4], "przyciskApp4");
		customLayout.addComponent(przyciskApp[5], "przyciskApp5");
		customLayout.addComponent(przyciskApp[6], "przyciskApp6");
		customLayout.addComponent(przyciskApp[7], "przyciskApp7");
		customLayout.addComponent(przyciskApp[8], "przyciskApp8");
		customLayout.addComponent(przyciskApp[9], "przyciskApp9");
		customLayout.addComponent(przyciskApp[10], "przyciskApp10");
		customLayout.addComponent(przyciskApp[11], "przyciskApp11");
		customLayout.addComponent(przyciskApp[12], "przyciskApp12");
		customLayout.addComponent(przyciskApp[13], "przyciskApp13");
		customLayout.addComponent(przyciskApp[14], "przyciskApp14");
		customLayout.addComponent(przyciskApp[15], "przyciskApp15");
		customLayout.addComponent(przyciskApp[16], "przyciskApp16");
		customLayout.addComponent(przyciskApp[17], "przyciskApp17");
		customLayout.addComponent(przyciskApp[18], "przyciskApp18");
		
		customLayout.setSizeFull();
		panel1 = new Panel();
		panel1.setContent(customLayout);
		panel1.setSizeUndefined();
		//panel1.setSizeFull();
		layout = new HorizontalLayout();
		layout.addComponents(panel1);
		//layout.setSizeFull();
		setContent(layout);
	}
	
	/**
	 * Ustawienie listenerow do przyciskow
	 */
	private void addListeners() {
		przyciskApp[0].addClickListener(e -> {
			//...
		});
		przyciskApp[1].addClickListener(e -> {
			//...
		});
		przyciskApp[2].addClickListener(e -> {
			lockButtons();
			oknoAplikacji = new OknoAplikacji<Zapytanie>("Zapytania o przełożenie zajęć", zapytanieRepo, Zapytanie.class);
			//oknoAplikacji.changeColumnsNames("");
			oknoAplikacji.setPosition((int)(getResX()*0.2+10), 123);
        	addWindow(oknoAplikacji);
        	oknoAplikacji.setResY((int)(VaadinUI.getResY()*0.45));
        	oknoAplikacji.setResX((int)(VaadinUI.getResX()*0.45));

        	oknoAplikacji.addCloseListener(new CloseListener() {
				public void windowClose(CloseEvent e) {
					oknoAplikacji = null;
					unlockButtons();
				}
			});
		});
		przyciskApp[3].addClickListener(e -> {
			//...
		});
		przyciskApp[4].addClickListener(e -> {
			lockButtons();
			//nowe okno
			oknoAplikacji = new OknoAplikacji<Konsultacja>("Konsultacje", konsultacjaRepo, Konsultacja.class);
			//oknoAplikacji.changeColumnsNames("");
			oknoAplikacji.setPosition((int)(getResX()*0.2+10), 123);
        	addWindow(oknoAplikacji);
        	oknoAplikacji.setResY((int)(VaadinUI.getResY()*0.45));
        	oknoAplikacji.setResX((int)(VaadinUI.getResX()*0.45));

        	oknoAplikacji.addCloseListener(new CloseListener() {
				public void windowClose(CloseEvent e) {
					oknoAplikacji = null;
					unlockButtons();
				}
			});
		});
		przyciskApp[5].addClickListener(e -> {
			lockButtons();
			//nowe okno
			oknoAplikacji = new OknoAplikacji<Wniosek>("Wnioski o przełożenie zajęć", wniosekRepo, Wniosek.class);
			//oknoAplikacji.changeColumnsNames("");
			oknoAplikacji.setPosition((int)(getResX()*0.2+10), 123);
        	addWindow(oknoAplikacji);
        	oknoAplikacji.setResY((int)(VaadinUI.getResY()*0.45));
        	oknoAplikacji.setResX((int)(VaadinUI.getResX()*0.45));

        	oknoAplikacji.addCloseListener(new CloseListener() {
				public void windowClose(CloseEvent e) {
					oknoAplikacji = null;
					unlockButtons();
				}
			});
		});
		przyciskApp[6].addClickListener(e -> {
			//...
		});
		przyciskApp[7].addClickListener(e -> {
			lockButtons();
			//nowe okno
			oknoAplikacji = new OknoAplikacji<Urlop>("Urlopy", urlopRepo, Urlop.class);
			//oknoAplikacji.changeColumnsNames("");
			oknoAplikacji.setPosition((int)(getResX()*0.2+10), 123);
        	addWindow(oknoAplikacji);
        	oknoAplikacji.setResY((int)(VaadinUI.getResY()*0.45));
        	oknoAplikacji.setResX((int)(VaadinUI.getResX()*0.45));

        	oknoAplikacji.addCloseListener(new CloseListener() {
				public void windowClose(CloseEvent e) {
					oknoAplikacji = null;
					unlockButtons();
				}
			});
		});
		przyciskApp[8].addClickListener(e -> {
			lockButtons();
			//nowe okno
			oknoAplikacji = new OknoAplikacji<Inspekcja>("Inspekcje", inspekcjaRepo, Inspekcja.class);
			//oknoAplikacji.changeColumnsNames("");
			oknoAplikacji.setPosition((int)(getResX()*0.2+10), 123);
        	addWindow(oknoAplikacji);
        	oknoAplikacji.setResY((int)(VaadinUI.getResY()*0.45));
        	oknoAplikacji.setResX((int)(VaadinUI.getResX()*0.45));

        	oknoAplikacji.addCloseListener(new CloseListener() {
				public void windowClose(CloseEvent e) {
					oknoAplikacji = null;
					unlockButtons();
				}
			});
		});
		przyciskApp[9].addClickListener(e -> {
			lockButtons();
			//nowe okno
			oknoAplikacji = new OknoAplikacji<Sala>("Sale", salaRepo, Sala.class);
			//oknoAplikacji.changeColumnsNames("");
			oknoAplikacji.setPosition((int)(getResX()*0.2+10), 123);
        	addWindow(oknoAplikacji);
        	oknoAplikacji.setResY((int)(VaadinUI.getResY()*0.45));
        	oknoAplikacji.setResX((int)(VaadinUI.getResX()*0.45));

        	oknoAplikacji.addCloseListener(new CloseListener() {
				public void windowClose(CloseEvent e) {
					oknoAplikacji = null;
					unlockButtons();
				}
			});
		});
		przyciskApp[10].addClickListener(e -> {
			lockButtons();
			oknoAplikacji = new OknoAplikacji<Grupa>("Grupy studenckie", grupaRepo, Grupa.class);
			//oknoAplikacji.changeColumnsNames("");
			oknoAplikacji.setPosition((int)(getResX()*0.2+10), 123);
        	addWindow(oknoAplikacji);
        	oknoAplikacji.setResY((int)(VaadinUI.getResY()*0.45));
        	oknoAplikacji.setResX((int)(VaadinUI.getResX()*0.45));

        	oknoAplikacji.addCloseListener(new CloseListener() {
				public void windowClose(CloseEvent e) {
					oknoAplikacji = null;
					unlockButtons();
				}
			});
		});
		przyciskApp[11].addClickListener(e -> {
			lockButtons();
			//nowe okno
			oknoAplikacji = new OknoAplikacji<Student>("Studenci", studentRepo, Student.class);
			//oknoAplikacji.changeColumnsNames("");
			oknoAplikacji.setPosition((int)(getResX()*0.2+10), 123);
        	addWindow(oknoAplikacji);
        	oknoAplikacji.setResY((int)(VaadinUI.getResY()*0.45));
        	oknoAplikacji.setResX((int)(VaadinUI.getResX()*0.45));

        	oknoAplikacji.addCloseListener(new CloseListener() {
				public void windowClose(CloseEvent e) {
					oknoAplikacji = null;
					unlockButtons();
				}
			});
		});
		przyciskApp[12].addClickListener(e -> {
			lockButtons();
			//nowe okno
			oknoAplikacji = new OknoAplikacji<Starosta>("Starości grup studenckich", starostaRepo, Starosta.class);
			//oknoAplikacji.changeColumnsNames("");
			oknoAplikacji.setPosition((int)(getResX()*0.2+10), 123);
        	addWindow(oknoAplikacji);
        	oknoAplikacji.setResY((int)(VaadinUI.getResY()*0.45));
        	oknoAplikacji.setResX((int)(VaadinUI.getResX()*0.45));

        	oknoAplikacji.addCloseListener(new CloseListener() {
				public void windowClose(CloseEvent e) {
					oknoAplikacji = null;
					unlockButtons();
				}
			});
		});
		przyciskApp[13].addClickListener(e -> {
			lockButtons();
			//nowe okno
			oknoAplikacji = new OknoAplikacji<Prowadzacy>("Prowadzący zajęcia", prowadzacyRepo, Prowadzacy.class);
			//oknoAplikacji.changeColumnsNames("");
			oknoAplikacji.setPosition((int)(getResX()*0.2+10), 123);
        	addWindow(oknoAplikacji);
        	oknoAplikacji.setResY((int)(VaadinUI.getResY()*0.45));
        	oknoAplikacji.setResX((int)(VaadinUI.getResX()*0.45));

        	oknoAplikacji.addCloseListener(new CloseListener() {
				public void windowClose(CloseEvent e) {
					oknoAplikacji = null;
					unlockButtons();
				}
			});
		});
		przyciskApp[14].addClickListener(e -> {
			lockButtons();
			//nowe okno
			oknoAplikacji = new OknoAplikacji<Instytut>("Instytuty", instytutRepo, Instytut.class);
			//oknoAplikacji.changeColumnsNames("");
			oknoAplikacji.setPosition((int)(getResX()*0.2+10), 123);
        	addWindow(oknoAplikacji);
        	oknoAplikacji.setResY((int)(VaadinUI.getResY()*0.45));
        	oknoAplikacji.setResX((int)(VaadinUI.getResX()*0.45));

        	oknoAplikacji.addCloseListener(new CloseListener() {
				public void windowClose(CloseEvent e) {
					oknoAplikacji = null;
					unlockButtons();
				}
			});
		});
		przyciskApp[15].addClickListener(e -> {
			lockButtons();
			//nowe okno
			oknoAplikacji = new OknoAplikacji<Dyrektor>("Dyrektorzy instytutów", dyrektorRepo, Dyrektor.class);
			//oknoAplikacji.changeColumnsNames("");
			oknoAplikacji.setPosition((int)(getResX()*0.2+10), 123);
        	addWindow(oknoAplikacji);
        	oknoAplikacji.setResY((int)(VaadinUI.getResY()*0.45));
        	oknoAplikacji.setResX((int)(VaadinUI.getResX()*0.45));

        	oknoAplikacji.addCloseListener(new CloseListener() {
				public void windowClose(CloseEvent e) {
					oknoAplikacji = null;
					unlockButtons();
				}
			});
		});
		przyciskApp[16].addClickListener(e -> {
			lockButtons();
			//nowe okno
			oknoAplikacji = new OknoAplikacji<Planista>("Planiści", planistaRepo, Planista.class);
			//oknoAplikacji.changeColumnsNames("");
			oknoAplikacji.setPosition((int)(getResX()*0.2+10), 123);
        	addWindow(oknoAplikacji);
        	oknoAplikacji.setResY((int)(VaadinUI.getResY()*0.45));
        	oknoAplikacji.setResX((int)(VaadinUI.getResX()*0.45));

        	oknoAplikacji.addCloseListener(new CloseListener() {
				public void windowClose(CloseEvent e) {
					oknoAplikacji = null;
					unlockButtons();
				}
			});
		});
		przyciskApp[17].addClickListener(e -> {
			lockButtons();
			//nowe okno
			oknoAplikacji = new OknoAplikacji<Admin>("Administratorzy", adminRepo, Admin.class);
			//oknoAplikacji.changeColumnsNames("");
			oknoAplikacji.setPosition((int)(getResX()*0.2+10), 123);
        	addWindow(oknoAplikacji);
        	oknoAplikacji.setResY((int)(VaadinUI.getResY()*0.45));
        	oknoAplikacji.setResX((int)(VaadinUI.getResX()*0.45));

        	oknoAplikacji.addCloseListener(new CloseListener() {
				public void windowClose(CloseEvent e) {
					oknoAplikacji = null;
					unlockButtons();
				}
			});
		});
		przyciskApp[18].addClickListener(e -> {
			lockButtons();
			//nowe okno
			oknoAplikacji = new OknoAplikacji<Blad>("Błędy", bladRepo, Blad.class);
			//oknoAplikacji.changeColumnsNames("");
			oknoAplikacji.setPosition((int)(getResX()*0.2+10), 123);
        	addWindow(oknoAplikacji);
        	oknoAplikacji.setResY((int)(VaadinUI.getResY()*0.45));
        	oknoAplikacji.setResX((int)(VaadinUI.getResX()*0.45));

        	oknoAplikacji.addCloseListener(new CloseListener() {
				public void windowClose(CloseEvent e) {
					oknoAplikacji = null;
					unlockButtons();
				}
			});
		});
	}
	
	/**
	 * Odblokowanie przyciskow, do ktorych zostaly dostarczone rozwiazania w postaci zaimplementowanych formularzy
	 */
	public void unlockButtons() {
		for(int i=0; i<19; i++) {
			if(i==0 || i==1 || i==3 || i==6) continue; //
			przyciskApp[i].setEnabled(true);
		}
	}
	
	/**
	 * Zablokowanie przyciskow, do ktorych nie zostaly dostarczone rozwiazania w postaci zaimplementowanych formularzy
	 */
	public void lockButtons() {
		for(int i=0; i<19; i++) {
			przyciskApp[i].setEnabled(false);
		}
	}
	/**
	 * 	Funkcja zwraca szerokosc ekranu w pikselach
	 *@return resX Zwraca szerokosc
	 */
	public static int getResX() {
		return resX;
	}
		
	/**
	 * 	Funkcja zwraca wysokosc ekranu w pikselach
	 * 	 @return resY Zwraca wysokosc
	 */
	public static int getResY() {
		return resY;
	}
}