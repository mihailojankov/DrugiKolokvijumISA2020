package kolokvijum2.app.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import kolokvijum2.app.model.Gost;

@Repository
public interface GostRepo extends CrudRepository<Gost, Long>{
	
	@Query("SELECT r FROM Gost as r  WHERE r.email = :email")
	public Gost dobaviPoEmail(@PathVariable("email") String email);
}
