package lepetitcoin.controlleur;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lepetitcoin.dao.ReclamationRepository;
import lepetitcoin.model.Reclamation;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/v1")
public class ReclamationControlleur {
	@Autowired ReclamationRepository reclamRep;
	
	@PostMapping(value="new/reclamation")
	public Reclamation setReclamation(@RequestBody Reclamation reclam) {
		return reclamRep.save(reclam);
		
	}
	
	@GetMapping(value="/reclamations")
	public List<Reclamation> getReclamations(){
		return reclamRep.findAll();
	}
	@GetMapping(value="/reclamation/{id}")
	public Optional<Reclamation> getReclamationById(@PathVariable(value="id") Integer id) {
		return reclamRep.findById(id);
	}

}
