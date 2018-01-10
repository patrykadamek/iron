package pl.swztz.portal.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import java.io.Serializable;

@Entity
@Table(name="zapytania")
public class Zapytanie implements Serializable {
	@Id
	@GenericGenerator(name = "native_generator", strategy = "native")
	@GeneratedValue(generator = "native_generator")
	private Long id;
	@Column(name="nadawca")
	private String nadawca;
	@Column(name="odbiorca")
	private String odbiorca;
	@Column(name="trescZapytania")
	private String trescZapytania;
	@Column(name="decyzjaProwadzacego")
	private String decyzjaProwadzacego;

	public Zapytanie(String nadawca, String odbiorca, String trescZapytania, String decyzjaProwadzacego) {
		this.nadawca = nadawca;
		this.odbiorca = odbiorca;
		this.trescZapytania = trescZapytania;
		this.decyzjaProwadzacego = decyzjaProwadzacego;
	}

	private Zapytanie(){}

	public String[] toStringArray() {
		String[] s = new String[4];
		s[0] = nadawca;
		s[1] = odbiorca;
		s[2] = trescZapytania;
		s[3] = decyzjaProwadzacego;
		return s;
	}
	
	public void setAll(String nadawca, String odbiorca, String trescZapytania, String decyzjaProwadzacego) {
		this.nadawca = nadawca;
		this.odbiorca = odbiorca;
		this.trescZapytania = trescZapytania;
		this.decyzjaProwadzacego = decyzjaProwadzacego;
	}
	
	public static String[] getFieldNames() {
		String[] s = {"nadawca", "odbiorca", "trescZapytania", "decyzjaProwadzacego"};
		return s;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNadawca() {
		return nadawca;
	}

	public void setNadawca(String nadawca) {
		this.nadawca = nadawca;
	}

	public String getOdbiorca() {
		return odbiorca;
	}

	public void setOdbiorca(String odbiorca) {
		this.odbiorca = odbiorca;
	}

	public String getTrescZapytania() {
		return trescZapytania;
	}

	public void setTrescZapytania(String trescZapytania) {
		this.trescZapytania = trescZapytania;
	}

	public String getDecyzjaProwadzacego() {
		return decyzjaProwadzacego;
	}

	public void setDecyzjaProwadzacego(String decyzjaProwadzacego) {
		this.decyzjaProwadzacego = decyzjaProwadzacego;
	}
}