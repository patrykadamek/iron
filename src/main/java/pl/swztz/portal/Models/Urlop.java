package pl.swztz.portal.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import java.io.Serializable;

@Entity
@Table(name="urlopy")
public class Urlop implements Serializable {
	@Id
	@GenericGenerator(name = "native_generator", strategy = "native")
	@GeneratedValue(generator = "native_generator")
	private Long id;
	@Column(name="pracownik")
	private String pracownik;
	@Column(name="dataRozpoczecia")
	private String dataRozpoczecia;
	@Column(name="dataZakonczenia")
	private String dataZakonczenia;

	public Urlop(String pracownik, String dataRozpoczecia, String dataZakonczenia) {
		this.pracownik = pracownik;
		this.dataRozpoczecia = dataRozpoczecia;
		this.dataZakonczenia = dataZakonczenia;
	}

	private Urlop(){}

	public String[] toStringArray() {
		String[] s = new String[3];
		s[0] = pracownik;
		s[1] = dataRozpoczecia;
		s[2] = dataZakonczenia;
		return s;
	}
	
	public void setAll(String pracownik, String dataRozpoczecia, String dataZakonczenia) {
		this.pracownik = pracownik;
		this.dataRozpoczecia = dataRozpoczecia;
		this.dataZakonczenia = dataZakonczenia;
	}
	
	public static String[] getFieldNames() {
		String[] s = {"pracownik", "dataRozpoczecia", "dataZakonczenia"};
		return s;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPracownik() {
		return pracownik;
	}

	public void setPracownik(String pracownik) {
		this.pracownik = pracownik;
	}

	public String getDataRozpoczecia() {
		return dataRozpoczecia;
	}

	public void setDataRozpoczecia(String dataRozpoczecia) {
		this.dataRozpoczecia = dataRozpoczecia;
	}

	public String getDataZakonczenia() {
		return dataZakonczenia;
	}

	public void setDataZakonczenia(String dataZakonczenia) {
		this.dataZakonczenia = dataZakonczenia;
	}
}