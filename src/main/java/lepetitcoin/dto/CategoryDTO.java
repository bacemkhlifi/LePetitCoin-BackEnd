
package lepetitcoin.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lepetitcoin.model.Category;
import lombok.Data;

@Data
public class CategoryDTO {
	private int id_cat;
	private String  name;
	
	private List<SubCategoryDTO> subCategory = new ArrayList<>();
	public CategoryDTO(Category category) {
		this.setId_cat(category.getId_cat());
		this.setName(category.getName());
		List<SubCategoryDTO> subCategoryDTOs  =category.getSubCategory().stream().map(SubCategoryDTO::new).collect(Collectors.toList());
		 this.setSubCategory(subCategoryDTOs);
		
	}
}