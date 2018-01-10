package pl.swztz.portal.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import java.io.Serializable;

@Entity
@Table(name="sale")
public class Sala implements Serializable {
	@Id
	@GenericGenerator(name = "native_generator", strategy = "native")
	@GeneratedValue(generator = "native_generator")
	private Long id;
	@Column(name="nrSali")
	private String nrSali;
	@Column(name="typSali")
	private String typSali;
	@Column(name="budynek")
	private String budynek;
	@Column(name="wydzial")
	private String wydzial;

	public Sala(String nrSali, String typSali, String budynek, String wydzial) {
		this.nrSali = nrSali;
		this.typSali = typSali;
		this.budynek = budynek;
		this.wydzial = wydzial;
	}

	private Sala(){}

	public String[] toStringArray() {
		String[] s = new String[4];
		s[0] = nrSali;
		s[1] = typSali;
		s[2] = budynek;
		s[3] = wydzial;
		return s;
	}
	
	public void setAll(String nrSali, String typSali, String budynek, String wydzial) {
		this.nrSali = nrSali;
		this.typSali = typSali;
		this.budynek = budynek;
		this.wydzial = wydzial;
	}
	
	public static String[] getFieldNames() {
		String[] s = {"nrSali", "typSali", "budynek", "wydzial"};
		return s;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNrSali() {
		return nrSali;
	}

	public void setNrSali(String nrSali) {
		this.nrSali = nrSali;
	}

	public String getTypSali() {
		return typSali;
	}

	public void setTypSali(String typSali) {
		this.typSali = typSali;
	}

	public String getBudynek() {
		return budynek;
	}

	public void setBudynek(String budynek) {
		this.budynek = budynek;
	}

	public String getWydzial() {
		return wydzial;
	}

	public void setWydzial(String wydzial) {
		this.wydzial = wydzial;
	}
}