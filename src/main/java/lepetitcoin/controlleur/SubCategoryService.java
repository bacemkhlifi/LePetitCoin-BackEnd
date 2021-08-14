package lepetitcoin.controlleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lepetitcoin.dao.CategoryRepository;
import lepetitcoin.dao.SubCategoryRepository;
import lepetitcoin.model.Category;
import lepetitcoin.model.SubCategory;
@Service
public class SubCategoryService {
	@Autowired
	SubCategoryRepository subCatRep;
	public List<SubCategory> getSubCategories() {
		return subCatRep.findAll();
	}
	
}
