package kolokvijum2.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kolokvijum2.app.model.Rezervacija;
import kolokvijum2.app.repo.RezervacijaRepo;

@Service
public class RezervacijaService {
	
	@Autowired
	RezervacijaRepo repo;
	
	public Iterable<Rezervacija> dobaviSve(){
		return repo.findAll();
	}
	
	public Rezervacija dobaviPoId(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public void save(Rezervacija obj) {
		repo.save(obj);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
