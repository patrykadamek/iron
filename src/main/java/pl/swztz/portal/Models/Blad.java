package pl.swztz.portal.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import java.io.Serializable;

@Entity
@Table(name="bledy")
public class Blad implements Serializable {
	@Id
	@GenericGenerator(name = "native_generator", strategy = "native")
	@GeneratedValue(generator = "native_generator")
	private Long id;
	@Column(name="nazwa")
	private String nazwa;
	@Column(name="opis")
	private String opis;
	@Column(name="uzytkownik")
	private String uzytkownik;
	@Column(name="dataZgloszenia")
	private String dataZgloszenia;

	public Blad(String nazwa, String opis, String uzytkownik, String dataZgloszenia) {
		this.nazwa = nazwa;
		this.opis = opis;
		this.uzytkownik = uzytkownik;
		this.dataZgloszenia = dataZgloszenia;
	}

	private Blad(){}

	public String[] toStringArray() {
		String[] s = new String[4];
		s[0] = nazwa;
		s[1] = opis;
		s[2] = uzytkownik;
		s[3] = dataZgloszenia;
		return s;
	}
	
	public void setAll(String nazwa, String opis, String uzytkownik, String dataZgloszenia) {
		this.nazwa = nazwa;
		this.opis = opis;
		this.uzytkownik = uzytkownik;
		this.dataZgloszenia = dataZgloszenia;
	}
	
	public static String[] getFieldNames() {
		String[] s = {"nazwa", "opis", "uzytkownik", "dataZgloszenia"};
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

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getUzytkownik() {
		return uzytkownik;
	}

	public void setUzytkownik(String uzytkownik) {
		this.uzytkownik = uzytkownik;
	}

	public String getDataZgloszenia() {
		return dataZgloszenia;
	}

	public void setDataZgloszenia(String dataZgloszenia) {
		this.dataZgloszenia = dataZgloszenia;
	}
}