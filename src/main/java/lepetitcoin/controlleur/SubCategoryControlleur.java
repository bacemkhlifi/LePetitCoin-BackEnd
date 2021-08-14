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
import lepetitcoin.dao.RoleRepository;
import lepetitcoin.dao.SubCategoryRepository;
import lepetitcoin.dao.UserRepository;
import lepetitcoin.dto.CategoryDTO;
import lepetitcoin.dto.SubCategoryDTO;
import lepetitcoin.model.Category;
import lepetitcoin.model.SubCategory;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/v1")
public class SubCategoryControlleur {
	@Autowired
	public UserRepository userRep;
	@Autowired
	public AnnonceRepository  adsRep;
	@Autowired 
	public CategoryRepository catRep;

	@Autowired 
	public SubCategoryRepository subCatRep;
	
	//APi create new sub-category
	@PostMapping(value="new/subcategory/{category}")
	public String addSubCategory(@RequestBody SubCategory subCategory , 
			@PathVariable(value="category") Category category ) {
		subCategory.setCategory(category);
		subCatRep.save(subCategory);
		return "sous-catégorie ajoutée";
	}
	////api get all sub-categories
	@Autowired
	 SubCategoryService  subCategoryService;
	@GetMapping(value="subcategories")
	List<SubCategoryDTO> getCategories() {
		return subCategoryService.getSubCategories().stream().map(SubCategoryDTO::new).collect(Collectors.toList());
	}
}
