package lepetitcoin.controlleur;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lepetitcoin.dao.AnnonceRepository;
import lepetitcoin.dao.CategoryRepository;
import lepetitcoin.dao.RegionRepository;
import lepetitcoin.dao.RoleRepository;
import lepetitcoin.dao.SubCategoryRepository;
import lepetitcoin.dao.UserRepository;
import lepetitcoin.dto.RegionDTO;
import lepetitcoin.dto.SubCategoryDTO;
import lepetitcoin.model.Category;
import lepetitcoin.model.Region;
import lepetitcoin.model.SubCategory;
import lepetitcoin.model.Ville;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/v1")
public class RegionControlleur {
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
	public RegionRepository regionRep;
	
////api get all Regions
	@Autowired
	 RegionService  regionService;
	@GetMapping(value="regions")
	List<RegionDTO> getRegions() {
		return regionService.getRegions().stream().map(RegionDTO::new).collect(Collectors.toList());
	}
	//APi create new region
		@PostMapping(value="new/region/{ville}")
		public String addSubCategory(@RequestBody Region region , 
				@PathVariable(value="ville") Ville ville ) {
			region.setVille(ville);
			regionRep.save(region);
			return "sous-catégorie ajoutée";
		}
}
