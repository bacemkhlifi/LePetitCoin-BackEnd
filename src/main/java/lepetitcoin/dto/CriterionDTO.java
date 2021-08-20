package lepetitcoin.dto;

import lepetitcoin.model.Criterion;
import lepetitcoin.model.Region;
import lombok.Data;

@Data
public class CriterionDTO {
	private int id_crit;
	private String  name;
	private String  value;
	private String subcategory;
	public CriterionDTO(Criterion critere) {
		this.setId_crit(critere.getId_cr());
		this.setName(critere.getName());
		this.setValue(critere.getValue());
		this.setSubcategory(critere.getSubCategory().getName());
		
	}

}
