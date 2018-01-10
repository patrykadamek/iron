package pl.swztz.portal.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import java.io.Serializable;

@Entity
@Table(name="prowadzacy")
public class Prowadzacy implements Serializable {
	@Id
	@GenericGenerator(name = "native_generator", strategy = "native")
	@GeneratedValue(generator = "native_generator")
	private Long id;
	@Column(name="imie")
	private String imie;
	@Column(name="nazwisko")
	private String nazwisko;
	@Column(name="stopien")
	private String stopien;
	@Column(name="wydzial")
	private String wydzial;
	@Column(name="instytut")
	private String instytut;
	@Column(name="pokoj")
	private String pokoj;

	public Prowadzacy(String imie, String nazwisko, String stopien, String wydzial, String instytut, String pokoj) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.stopien = stopien;
		this.wydzial = wydzial;
		this.instytut = instytut;
		this.pokoj = pokoj;
	}

	private Prowadzacy(){}

	public String[] toStringArray() {
		String[] s = new String[6];
		s[0] = imie;
		s[1] = nazwisko;
		s[2] = stopien;
		s[3] = wydzial;
		s[4] = instytut;
		s[5] = pokoj;
		return s;
	}
	
	public void setAll(String imie, String nazwisko, String stopien, String wydzial, String instytut, String pokoj) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.stopien = stopien;
		this.wydzial = wydzial;
		this.instytut = instytut;
		this.pokoj = pokoj;
	}
	
	public static String[] getFieldNames() {
		String[] s = {"imie", "nazwisko", "stopien", "wydzial", "instytut", "pokoj"};
		return s;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getStopien() {
		return stopien;
	}

	public void setStopien(String stopien) {
		this.stopien = stopien;
	}

	public String getWydzial() {
		return wydzial;
	}

	public void setWydzial(String wydzial) {
		this.wydzial = wydzial;
	}

	public String getInstytut() {
		return instytut;
	}

	public void setInstytut(String instytut) {
		this.instytut = instytut;
	}

	public String getPokoj() {
		return pokoj;
	}

	public void setPokoj(String pokoj) {
		this.pokoj = pokoj;
	}
}