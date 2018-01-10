package pl.swztz.portal.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import java.io.Serializable;

@Entity
@Table(name="inspekcje")
public class Inspekcja implements Serializable {
	@Id
	@GenericGenerator(name = "native_generator", strategy = "native")
	@GeneratedValue(generator = "native_generator")
	private Long id;
	@Column(name="blokZajec")
	private String blokZajec;
	@Column(name="dyrektorInstytutu")
	private String dyrektorInstytutu;
	@Column(name="trescKomentarza")
	private String trescKomentarza;

	public Inspekcja(String blokZajec, String dyrektorInstytutu, String trescKomentarza) {
		this.blokZajec = blokZajec;
		this.dyrektorInstytutu = dyrektorInstytutu;
		this.trescKomentarza = trescKomentarza;
	}

	private Inspekcja(){}

	public String[] toStringArray() {
		String[] s = new String[3];
		s[0] = blokZajec;
		s[1] = dyrektorInstytutu;
		s[2] = trescKomentarza;
		return s;
	}
	
	public void setAll(String blokZajec, String dyrektorInstytutu, String trescKomentarza) {
		this.blokZajec = blokZajec;
		this.dyrektorInstytutu = dyrektorInstytutu;
		this.trescKomentarza = trescKomentarza;
	}
	
	public static String[] getFieldNames() {
		String[] s = {"blokZajec", "dyrektorInstytutu", "trescKomentarza"};
		return s;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBlokZajec() {
		return blokZajec;
	}

	public void setBlokZajec(String blokZajec) {
		this.blokZajec = blokZajec;
	}

	public String getDyrektorInstytutu() {
		return dyrektorInstytutu;
	}

	public void setDyrektorInstytutu(String dyrektorInstytutu) {
		this.dyrektorInstytutu = dyrektorInstytutu;
	}

	public String getTrescKomentarza() {
		return trescKomentarza;
	}

	public void setTrescKomentarza(String trescKomentarza) {
		this.trescKomentarza = trescKomentarza;
	}
}