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
import lepetitcoin.dao.UserRepository;
import lepetitcoin.dto.CategoryDTO;
import lepetitcoin.model.Annonce;
import lepetitcoin.model.Category;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/v1")
public class CategoryControlleur {
	@Autowired
	public UserRepository userRep;
	@Autowired
	public AnnonceRepository  adsRep;
	@Autowired 
	public CategoryRepository catRep;
	
	
	
	//Api add new category
	@PostMapping(value="new/category")
	public Category setNewCategoty(@RequestBody Category category) {
		return catRep.save(category);
		
		
	}
	//Api delete a category
	@PostMapping(value="delete/category/{id}")
	public String DeleteCategory(@PathVariable Integer id ) {
		catRep.deleteById(id);
		return "La catégorie " + id +" a été supprimé";
	}
	
	//API get all categories
	@Autowired
	CategoryService categoryService;
	@GetMapping(value="/categories")
	 List<CategoryDTO> getCategories() {
		return categoryService.getCategories().stream().map(CategoryDTO::new).collect(Collectors.toList());
	}
	
	
	//API update category
	@PutMapping(value="category/update/{id}")
	public String updateAd(@RequestBody Category category ,@PathVariable(value="id") Integer  id ) {
		Optional<Category> category0 = catRep.findById(id);
		
		Category categoryBeta = category0.get();
		categoryBeta.setName(category.getName());
		
		catRep.save(categoryBeta);
		
		return " la catégorie a été modifiée correctement ";
	}
}
