package lepetitcoin.controlleur;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
import lepetitcoin.dto.AnnonceDTO;
import lepetitcoin.dto.UserDTO;
import lepetitcoin.model.Annonce;
import lepetitcoin.model.Category;
import lepetitcoin.model.Role;
import lepetitcoin.model.SubCategory;
import lepetitcoin.model.User;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/v1")
public class AnnonceControlleur {

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
	//APi add new adsence
	
	@PostMapping(value="add/ads/{email}/{subCategory}")
	public  String creatAds(@RequestBody Annonce ads,@PathVariable(value="email") User email
			,@PathVariable(value="subCategory") SubCategory subCategory) {
		
		
		ads.setSubCategory(subCategory);
		ads.setUser(email);
		 
		adsRep.save(ads);
	  	return "annonce a été ajoutée";
		
	}
//API get all annonces
	@Autowired
	AnnonceService annonceService;
	@GetMapping(value="/annonces")
	 List<AnnonceDTO> getAnnonces() {
		return annonceService.getAnnonces().stream().map(AnnonceDTO::new).collect(Collectors.toList());
	}
	
	//Api delete an ad
	@PostMapping(value="annonce/delete/{id}")
	public String deleteAd(@PathVariable(value = "id") Integer id ) {
		 adsRep.deleteById(id);
		return "l'annonce a été supprimée";
	}
	
	//Api update an ad
	@PutMapping(value="annonce/update/{id}")
	public String updateAd(@RequestBody Annonce annonce ,@PathVariable(value="id") Integer id ) {
		Optional<Annonce> annonce1 = adsRep.findById(id);
		
		Annonce ad = annonce1.get();
		//ad.setCategory(annonce.getCategory());
		ad.setDate(annonce.getDate());;
		ad.setDescription(annonce.getDescription());
		ad.setVille(annonce.getVille());
		ad.setRegion(annonce.getRegion());
		//ad.setId_ad(id);
		ad.setName(annonce.getName());
		ad.setPrice(annonce.getPrice());
		//ad.setUser(annonce.getUser());
		
		adsRep.save(ad);
		
		return " l'annonce a été modifiée correctement ";
	}
	
	
	
}
