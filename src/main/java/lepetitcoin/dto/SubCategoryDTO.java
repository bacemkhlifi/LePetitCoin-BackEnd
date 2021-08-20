package lepetitcoin.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lepetitcoin.model.Category;
import lepetitcoin.model.SubCategory;
import lepetitcoin.dto.CriterionDTO;
import lombok.Data;
@Data
public class SubCategoryDTO {
	private int id_subcat;
	private String  name;
	
	private String category;
	private List<CriterionDTO> critere = new ArrayList<>();

	public SubCategoryDTO(SubCategory subCategory) {
		this.setId_subcat(subCategory.getId_subcat());
		this.setName(subCategory.getName());
		this.setCategory(subCategory.getCategory().getName());
		List<CriterionDTO> critereDTO  =subCategory.getCriterion().stream().map(CriterionDTO::new).collect(Collectors.toList());
		 this.setCritere(critereDTO);
		
		
	}
}
