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

import kolokvijum2.app.DTO.RezervacijaDTO;
import kolokvijum2.app.model.Rezervacija;
import kolokvijum2.app.service.RezervacijaService;

@Controller
@RequestMapping(path = "/rezervacija")
public class RezervacijaCtrl {
	
	@Autowired
	RezervacijaService service;
	ArrayList<RezervacijaDTO> lista;
	
	//Dobavi sve
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<RezervacijaDTO>> dobaviSve(){
		ModelMapper mm = new ModelMapper();
		
		lista = new ArrayList<RezervacijaDTO>();
		for(Rezervacija x:service.dobaviSve()) {
			lista.add(mm.map(x, RezervacijaDTO.class));
		}
		
		return new ResponseEntity<ArrayList<RezervacijaDTO>>(lista, HttpStatus.OK);
	}
	
	
	//Dobavi po ID
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<RezervacijaDTO> dobaviPoId(@PathVariable("id") Long id){
		ModelMapper mm = new ModelMapper();
		Rezervacija existing = service.dobaviPoId(id);
		
		if(existing == null) {
			return new ResponseEntity<RezervacijaDTO>(HttpStatus.NOT_FOUND);
		}
		RezervacijaDTO obj = mm.map(existing, RezervacijaDTO.class);
		return new ResponseEntity<RezervacijaDTO>(obj, HttpStatus.OK);
		
	}
	
	//Dodavanje novog
	@RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<Rezervacija> dodajNovi(@RequestBody Rezervacija obj) {
        if (service.dobaviPoId(obj.getId()) != null) {
            return new ResponseEntity<Rezervacija>(HttpStatus.CONFLICT);
        }
        service.save(obj);
        return new ResponseEntity<Rezervacija>(HttpStatus.OK);
    }
	
	//Izmena
    @RequestMapping(path = "", method = RequestMethod.PUT)
    public ResponseEntity<Rezervacija> izmeni(@RequestBody Rezervacija obj) {
    	Rezervacija existing = service.dobaviPoId(obj.getId());
        
        if (existing == null) {
            return new ResponseEntity<Rezervacija>(HttpStatus.NOT_FOUND);
        }
        
        existing.setDoKad(obj.getDoKad());
        
        service.save(existing);
        return new ResponseEntity<Rezervacija>(HttpStatus.OK);
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
