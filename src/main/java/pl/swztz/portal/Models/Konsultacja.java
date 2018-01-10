package pl.swztz.portal.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import java.io.Serializable;

@Entity
@Table(name="konsultacje")
public class Konsultacja implements Serializable {
	@Id
	@GenericGenerator(name = "native_generator", strategy = "native")
	@GeneratedValue(generator = "native_generator")
	private Long id;
	@Column(name="prowadzacy")
	private String prowadzacy;
	@Column(name="sala")
	private String sala;
	@Column(name="data")
	private String data;
	@Column(name="godzina")
	private String godzina;

	public Konsultacja(String prowadzacy, String sala, String data, String godzina) {
		this.prowadzacy = prowadzacy;
		this.sala = sala;
		this.data = data;
		this.godzina = godzina;
	}

	private Konsultacja(){}

	public String[] toStringArray() {
		String[] s = new String[4];
		s[0] = prowadzacy;
		s[1] = sala;
		s[2] = data;
		s[3] = godzina;
		return s;
	}
	
	public void setAll(String prowadzacy, String sala, String data, String godzina) {
		this.prowadzacy = prowadzacy;
		this.sala = sala;
		this.data = data;
		this.godzina = godzina;
	}
	
	public static String[] getFieldNames() {
		String[] s = {"prowadzacy", "sala", "data", "godzina"};
		return s;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProwadzacy() {
		return prowadzacy;
	}

	public void setProwadzacy(String prowadzacy) {
		this.prowadzacy = prowadzacy;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getGodzina() {
		return godzina;
	}

	public void setGodzina(String godzina) {
		this.godzina = godzina;
	}
}