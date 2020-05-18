package kolokvijum2.app.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Rezervacija {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	LocalDateTime odKad;
	//Do pripada java sintaksi(do/while) pa nisam mogao da ga korisitim kao atribut
	LocalDateTime doKad;
	
	@ManyToOne
	Soba soba;
	@ManyToOne
	Gost gost;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getOdKad() {
		return odKad;
	}
	public void setOdKad(LocalDateTime odKad) {
		this.odKad = odKad;
	}
	public LocalDateTime getDoKad() {
		return doKad;
	}
	public void setDoKad(LocalDateTime doKad) {
		this.doKad = doKad;
	}
	public Soba getSoba() {
		return soba;
	}
	public void setSoba(Soba soba) {
		this.soba = soba;
	}
	public Gost getGost() {
		return gost;
	}
	public void setGost(Gost gost) {
		this.gost = gost;
	}
	public Rezervacija(Long id, LocalDateTime odKad, LocalDateTime doKad, Soba soba, Gost gost) {
		super();
		this.id = id;
		this.odKad = odKad;
		this.doKad = doKad;
		this.soba = soba;
		this.gost = gost;
	}
	public Rezervacija() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
