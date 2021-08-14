package lepetitcoin.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lepetitcoin.model.Category;
import lepetitcoin.model.SubCategory;
import lombok.Data;
@Data
public class SubCategoryDTO {
	private int id_subcat;
	private String  name;
	
	private String category;
	
	public SubCategoryDTO(SubCategory subCategory) {
		this.setId_subcat(subCategory.getId_subcat());
		this.setName(subCategory.getName());
		this.setCategory(subCategory.getCategory().getName());
		
	}
}
