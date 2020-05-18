package kolokvijum2.app.ctrl;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kolokvijum2.app.DTO.SobaDTO;
import kolokvijum2.app.model.Soba;
import kolokvijum2.app.service.SobaService;

@Controller
@RequestMapping(path = "/soba")
public class SobaCtrl {
	@Autowired
	SobaService service;
	ArrayList<SobaDTO> lista;
	
	//Dobavi sve
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<SobaDTO>> dobaviSve(){
		ModelMapper mm = new ModelMapper();
		
		lista = new ArrayList<SobaDTO>();
		for(Soba x:service.dobaviSve()) {
			lista.add(mm.map(x, SobaDTO.class));
		}
		
		return new ResponseEntity<ArrayList<SobaDTO>>(lista, HttpStatus.OK);
	}
	
	
	//Dobavi po ID
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<SobaDTO> dobaviPoId(@PathVariable("id") Long id){
		ModelMapper mm = new ModelMapper();
		Soba existing = service.dobaviPoId(id);
		
		if(existing == null) {
			return new ResponseEntity<SobaDTO>(HttpStatus.NOT_FOUND);
		}
		SobaDTO obj = mm.map(existing, SobaDTO.class);
		return new ResponseEntity<SobaDTO>(obj, HttpStatus.OK);
		
	}
	
	//Dodavanje novog
	@RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<Soba> dodajNovi(@RequestBody Soba obj) {
        if (service.dobaviPoId(obj.getId()) != null) {
            return new ResponseEntity<Soba>(HttpStatus.CONFLICT);
        }
        service.save(obj);
        return new ResponseEntity<Soba>(HttpStatus.OK);
    }
	
	//Izmena
    @RequestMapping(path = "", method = RequestMethod.PUT)
    public ResponseEntity<Soba> izmeni(@RequestBody Soba obj) {
    	Soba existing = service.dobaviPoId(obj.getId());
        
        if (existing == null) {
            return new ResponseEntity<Soba>(HttpStatus.NOT_FOUND);
        }
        
        existing.setOpis(obj.getOpis());
        
        service.save(existing);
        return new ResponseEntity<Soba>(HttpStatus.OK);
    }

    //Brisanje
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> brisanje(@PathVariable("id") Long id) {
    	
        if (service.dobaviPoId(id) == null) {
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }
        
        service.delete(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}
