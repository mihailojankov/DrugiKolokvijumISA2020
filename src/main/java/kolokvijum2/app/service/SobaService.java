package kolokvijum2.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kolokvijum2.app.model.Soba;
import kolokvijum2.app.repo.SobaRepo;

@Service
public class SobaService {
	@Autowired
	SobaRepo repo;
	
	public Iterable<Soba> dobaviSve(){
		return repo.findAll();
	}
	
	public Soba dobaviPoId(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public void save(Soba obj) {
		repo.save(obj);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
