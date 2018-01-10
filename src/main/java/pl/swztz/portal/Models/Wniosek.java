package pl.swztz.portal.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import java.io.Serializable;

@Entity
@Table(name="wnioski")
public class Wniosek implements Serializable {
	@Id
	@GenericGenerator(name = "native_generator", strategy = "native")
	@GeneratedValue(generator = "native_generator")
	private Long id;
	@Column(name="sala")
	private String sala;
	@Column(name="grupa")
	private String grupa;
	@Column(name="dataPrzenosin")
	private String dataPrzenosin;
	@Column(name="godzinaPrzenosin")
	private String godzinaPrzenosin;
	
	public Wniosek(String sala, String grupa, String dataPrzenosin, String godzinaPrzenosin) {
		this.sala = sala;
		this.grupa = grupa;
		this.dataPrzenosin = dataPrzenosin;
		this.godzinaPrzenosin = godzinaPrzenosin;
	}

	private Wniosek(){}

	public String[] toStringArray() {
		String[] s = new String[4];
		s[0] = sala;
		s[1] = grupa;
		s[2] = dataPrzenosin;
		s[3] = godzinaPrzenosin;
		return s;
	}
	
	public void setAll(String sala, String grupa, String dataPrzenosin, String godzinaPrzenosin) {
		this.sala = sala;
		this.grupa = grupa;
		this.dataPrzenosin = dataPrzenosin;
		this.godzinaPrzenosin = godzinaPrzenosin;
	}
	
	public static String[] getFieldNames() {
		String[] s = {"sala", "grupa", "dataPrzenosin", "godzinaPrzenosin"};
		return s;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public String getGrupa() {
		return grupa;
	}

	public void setGrupa(String grupa) {
		this.grupa = grupa;
	}

	public String getDataPrzenosin() {
		return dataPrzenosin;
	}

	public void setDataPrzenosin(String dataPrzenosin) {
		this.dataPrzenosin = dataPrzenosin;
	}

	public String getGodzinaPrzenosin() {
		return godzinaPrzenosin;
	}

	public void setGodzinaPrzenosin(String godzinaPrzenosin) {
		this.godzinaPrzenosin = godzinaPrzenosin;
	}
}