package kolokvijum2.app.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kolokvijum2.app.model.Rezervacija;

@Repository
public interface RezervacijaRepo extends CrudRepository<Rezervacija, Long>{
	
}
