package kolokvijum2.app.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kolokvijum2.app.model.Gost;
import kolokvijum2.app.model.Rezervacija;
import kolokvijum2.app.repo.GostRepo;



@Service
public class GostService implements UserDetailsService{
	
	@Autowired
	GostRepo repo;
	
	@Autowired
	RezervacijaService service2;
	
	public Iterable<Gost> dobaviSve(){
		return repo.findAll();
	}
	
	public Gost dobaviPoId(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public void save(Gost obj) {
		repo.save(obj);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public ArrayList<Rezervacija> dobaviPoEmail(String email) {
		Gost gost = repo.dobaviPoEmail(email);
		ArrayList<Rezervacija> rez = new ArrayList<Rezervacija>();
		
		for(Rezervacija x: service2.dobaviSve()){
			if(gost.getId() == x.getGost().getId()) {
				rez.add(x);
			}
		}
		return rez;
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Gost korisnik = repo.dobaviPoEmail(email);
		
		return new User(korisnik.getEmail(), korisnik.getLozinka(), new ArrayList<>());
	}
}
