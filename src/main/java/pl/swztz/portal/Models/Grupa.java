package pl.swztz.portal.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import java.io.Serializable;

@Entity
@Table(name="grupy")
public class Grupa implements Serializable {
	@Id
	@GenericGenerator(name = "native_generator", strategy = "native")
	@GeneratedValue(generator = "native_generator")
	private Long id;
	@Column(name="nazwa")
	private String nazwa;
	@Column(name="rocznik")
	private String rocznik;
	@Column(name="kierunek")
	private String kierunek;
	@Column(name="wydzial")
	private String wydzial;
	
	public Grupa(String nazwa, String rocznik, String kierunek, String wydzial) {
		this.nazwa = nazwa;
		this.rocznik = rocznik;
		this.kierunek = kierunek;
		this.wydzial = wydzial;
	}

	private Grupa(){}

	public String[] toStringArray() {
		String[] s = new String[4];
		s[0] = nazwa;
		s[1] = rocznik;
		s[2] = kierunek;
		s[3] = wydzial;
		return s;
	}
	
	public void setAll(String nazwa, String rocznik, String kierunek, String wydzial) {
		this.nazwa = nazwa;
		this.rocznik = rocznik;
		this.kierunek = kierunek;
		this.wydzial = wydzial;
	}
	
	public static String[] getFieldNames() {
		String[] s = {"nazwa", "rocznik", "kierunek", "wydzial"};
		return s;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getRocznik() {
		return rocznik;
	}

	public void setRocznik(String rocznik) {
		this.rocznik = rocznik;
	}

	public String getKierunek() {
		return kierunek;
	}

	public void setKierunek(String kierunek) {
		this.kierunek = kierunek;
	}

	public String getWydzial() {
		return wydzial;
	}

	public void setWydzial(String wydzial) {
		this.wydzial = wydzial;
	}
}