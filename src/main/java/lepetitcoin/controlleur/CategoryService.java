package lepetitcoin.controlleur;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lepetitcoin.dao.CategoryRepository;

import lepetitcoin.model.Category;
@Service
public class CategoryService {
	
	
	@Autowired
	CategoryRepository catRep;
	public List<Category> getCategories() {
		return catRep.findAll();
	}
	
	
	
}
