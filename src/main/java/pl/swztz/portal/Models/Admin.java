package pl.swztz.portal.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import java.io.Serializable;

@Entity
@Table(name="admini")
public class Admin implements Serializable {
	@Id
	@GenericGenerator(name = "native_generator", strategy = "native")
	@GeneratedValue(generator = "native_generator")
	private Long id;
	@Column(name="imie")
	private String imie;
	@Column(name="nazwisko")
	private String nazwisko;
	@Column(name="uprawnienia")
	private String uprawnienia;

	public Admin(String imie, String nazwisko, String uprawnienia) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.uprawnienia = uprawnienia;
	}

	private Admin(){}

	public String[] toStringArray() {
		String[] s = new String[3];
		s[0] = imie;
		s[1] = nazwisko;
		s[2] = uprawnienia;
		return s;
	}
	
	public void setAll(String imie, String nazwisko, String uprawnienia) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.uprawnienia = uprawnienia;
	}
	
	public static String[] getFieldNames() {
		String[] s = {"imie", "nazwisko", "uprawnienia"};
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

	public String getUprawnienia() {
		return uprawnienia;
	}

	public void setUprawnienia(String uprawnienia) {
		this.uprawnienia = uprawnienia;
	}
}