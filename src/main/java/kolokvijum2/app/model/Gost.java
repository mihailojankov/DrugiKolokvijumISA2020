package kolokvijum2.app.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Gost {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String ime;
	String prezime;
	@Column(unique = true)
	String email;
	String lozinka;
	
	@OneToMany(mappedBy = "gost")
	List<Rezervacija> rezervacije;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLozinka() {
		return lozinka;
	}
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	
	public List<Rezervacija> getRezervacije() {
		return rezervacije;
	}
	public void setRezervacije(List<Rezervacija> rezervacije) {
		this.rezervacije = rezervacije;
	}
	
	public Gost(Long id, String ime, String prezime, String email, String lozinka, List<Rezervacija> rezervacije) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.lozinka = lozinka;
		this.rezervacije = rezervacije;
	}
	public Gost() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
