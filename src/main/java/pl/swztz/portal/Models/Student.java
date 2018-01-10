package pl.swztz.portal.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import java.io.Serializable;

@Entity
@Table(name="studenci")
public class Student implements Serializable {
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
	@Column(name="nrIndeksu")
	private String nrIndeksu;
	@Column(name="pesel")
	private String pesel;

	public Student(String imie, String nazwisko, String grupa, String nrIndeksu, String pesel) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.grupa = grupa;
		this.nrIndeksu = nrIndeksu;
		this.pesel = pesel;
	}

	private Student(){}

	public String[] toStringArray() {
		String[] s = new String[5];
		s[0] = imie;
		s[1] = nazwisko;
		s[2] = grupa;
		s[3] = nrIndeksu;
		s[4] = pesel;
		return s;
	}
	
	public void setAll(String imie, String nazwisko, String grupa, String nrIndeksu, String pesel) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.grupa = grupa;
		this.nrIndeksu = nrIndeksu;
		this.pesel = pesel;
	}
	
	public static String[] getFieldNames() {
		String[] s = {"imie", "nazwisko", "grupa", "nrIndeksu", "pesel"};
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

	public String getNrIndeksu() {
		return nrIndeksu;
	}

	public void setNrIndeksu(String nrIndeksu) {
		this.nrIndeksu = nrIndeksu;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
}