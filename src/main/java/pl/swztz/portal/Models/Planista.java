package pl.swztz.portal.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import java.io.Serializable;

@Entity
@Table(name="planisci")
public class Planista implements Serializable {
	@Id
	@GenericGenerator(name = "native_generator", strategy = "native")
	@GeneratedValue(generator = "native_generator")
	private Long id;
	@Column(name="imie")
	private String imie;
	@Column(name="nazwisko")
	private String nazwisko;
	@Column(name="wydzial")
	private String wydzial;

	public Planista(String imie, String nazwisko, String wydzial) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.wydzial = wydzial;
	}

	private Planista(){}

	public String[] toStringArray() {
		String[] s = new String[3];
		s[0] = imie;
		s[1] = nazwisko;
		s[2] = wydzial;
		return s;
	}
	
	public void setAll(String imie, String nazwisko, String wydzial) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.wydzial = wydzial;
	}
	
	public static String[] getFieldNames() {
		String[] s = {"imie", "nazwisko", "wydzial"};
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

	public String getWydzial() {
		return wydzial;
	}

	public void setWydzial(String wydzial) {
		this.wydzial = wydzial;
	}
}