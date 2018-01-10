package pl.swztz.portal.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import java.io.Serializable;

@Entity
@Table(name="starosci")
public class Starosta implements Serializable {
	@Id
	@GenericGenerator(name = "native_generator", strategy = "native")
	@GeneratedValue(generator = "native_generator")
	private Long id;
	@Column(name="imie")
	private String imie;
	@Column(name="nazwisko")
	private String nazwisko;
	@Column(name="grupa")
	private String grupa;

	public Starosta(String imie, String nazwisko, String grupa) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.grupa = grupa;
	}

	private Starosta(){}

	public String[] toStringArray() {
		String[] s = new String[3];
		s[0] = imie;
		s[1] = nazwisko;
		s[2] = grupa;
		return s;
	}
	
	public void setAll(String imie, String nazwisko, String grupa) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.grupa = grupa;
	}
	
	public static String[] getFieldNames() {
		String[] s = {"imie", "nazwisko", "grupa"};
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

	public String getGrupa() {
		return grupa;
	}

	public void setGrupa(String grupa) {
		this.grupa = grupa;
	}
}