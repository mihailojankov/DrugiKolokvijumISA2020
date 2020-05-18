package kolokvijum2.app.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kolokvijum2.app.model.Soba;

@Repository
public interface SobaRepo extends CrudRepository<Soba,Long>{

}
