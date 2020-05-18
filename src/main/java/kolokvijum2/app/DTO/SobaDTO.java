package kolokvijum2.app.DTO;

public class SobaDTO {
	Long id;
	String naziv;
	String opis;
	Long brojKreveta;
	
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
}
