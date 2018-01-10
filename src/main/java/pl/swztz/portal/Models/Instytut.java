package pl.swztz.portal.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import java.io.Serializable;

@Entity
@Table(name="instytuty")
public class Instytut implements Serializable {
	@Id
	@GenericGenerator(name = "native_generator", strategy = "native")
	@GeneratedValue(generator = "native_generator")
	private Long id;
	@Column(name="skrot")
	private String skrot;
	@Column(name="nazwa")
	private String nazwa;
	@Column(name="wydzial")
	private String wydzial;
	@Column(name="dyrektor")
	private String dyrektor;

	public Instytut(String skrot, String nazwa, String wydzial, String dyrektor) {
		this.skrot = skrot;
		this.nazwa = nazwa;
		this.wydzial = wydzial;
		this.dyrektor = dyrektor;
	}

	private Instytut(){}

	public String[] toStringArray() {
		String[] s = new String[4];
		s[0] = skrot;
		s[1] = nazwa;
		s[2] = wydzial;
		s[3] = dyrektor;
		return s;
	}
	
	public void setAll(String skrot, String nazwa, String wydzial, String dyrektor) {
		this.skrot = skrot;
		this.nazwa = nazwa;
		this.wydzial = wydzial;
		this.dyrektor = dyrektor;
	}
	
	public static String[] getFieldNames() {
		String[] s = {"skrot", "nazwa", "wydzial", "dyrektor"};
		return s;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSkrot() {
		return skrot;
	}

	public void setSkrot(String skrot) {
		this.skrot = skrot;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getWydzial() {
		return wydzial;
	}

	public void setWydzial(String wydzial) {
		this.wydzial = wydzial;
	}

	public String getDyrektor() {
		return dyrektor;
	}

	public void setDyrektor(String dyrektor) {
		this.dyrektor = dyrektor;
	}
}