package de.inex;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "testdb")
public class Testdb {

	private int id;

	private String email;

	private String vorname;

	private String nachname;

	private String telefonnummer;

	private String geburtsdatum;

	@Id
	@GeneratedValue
	@Column(name = "Id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "Email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "Vorname")
	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	@Column(name = "Nachname")
	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	@Column(name = "Telefonnummer")
	public String getTelefonnummer() {
		return telefonnummer;
	}

	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}

	@Column(name = "Geburtstagsdatum")
	public String getGeburtsdatum() {
		return geburtsdatum;
	}

	public void setGeburtsdatum(String geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}

}
