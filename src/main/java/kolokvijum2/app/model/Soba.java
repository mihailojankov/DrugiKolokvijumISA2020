package kolokvijum2.app.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Soba {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String naziv;
	String opis;
	Long brojKreveta;
	
	@OneToMany(mappedBy = "soba")
	List<Rezervacija> rezervacije;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public Long getBrojKreveta() {
		return brojKreveta;
	}
	public void setBrojKreveta(Long brojKreveta) {
		this.brojKreveta = brojKreveta;
	}
	
	public List<Rezervacija> getRezervacije() {
		return rezervacije;
	}
	public void setRezervacije(List<Rezervacija> rezervacije) {
		this.rezervacije = rezervacije;
	}
	
	public Soba(Long id, String naziv, String opis, Long brojKreveta, List<Rezervacija> rezervacije) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
		this.brojKreveta = brojKreveta;
		this.rezervacije = rezervacije;
	}
	public Soba() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
