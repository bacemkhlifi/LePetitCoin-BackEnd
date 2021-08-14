package lepetitcoin.controlleur;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lepetitcoin.dao.AnnonceRepository;
import lepetitcoin.dao.CategoryRepository;
import lepetitcoin.dao.RoleRepository;
import lepetitcoin.dao.SubCategoryRepository;
import lepetitcoin.dao.UserRepository;
import lepetitcoin.dao.VilleRepository;
import lepetitcoin.dto.CategoryDTO;
import lepetitcoin.dto.VilleDTO;
import lepetitcoin.model.Category;
import lepetitcoin.model.Ville;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/v1")
public class VilleControlleur {
	@Autowired
	public UserRepository userRep;
	@Autowired
	public AnnonceRepository  adsRep;
	@Autowired 
	public CategoryRepository catRep;
	@Autowired
	public RoleRepository roleRep;
	@Autowired 
	public SubCategoryRepository subCatRep;
	@Autowired
	public VilleRepository villeRep;
	
	//API get all villes
		@Autowired
		VilleService villeService;
		@GetMapping(value="/villes")
		 List<VilleDTO> getVilles() {
			return villeService.getVilles().stream().map(VilleDTO::new).collect(Collectors.toList());
		}
		//Api add new ville
		@PostMapping(value="new/ville")
		public Ville setNewCategoty(@RequestBody Ville ville) {
			return villeRep.save(ville);
			
			
		}
		//Api delete a ville
		@PostMapping(value="delete/ville/{id}")
		public String DeleteCategory(@PathVariable Integer id ) {
			villeRep.deleteById(id);
			return "La ville " + id +" a été supprimé";
		}

		//API update ville
		@PutMapping(value="ville/update/{id}")
		public String updateAd(@RequestBody Ville ville ,@PathVariable(value="id") Integer  id ) {
			Optional<Ville> ville0 = villeRep.findById(id);
			
			Ville villeBeta = ville0.get();
			villeBeta.setName(ville.getName());
			
			villeRep.save(villeBeta);
			
			return " la ville a été modifiée correctement ";
		}
}
