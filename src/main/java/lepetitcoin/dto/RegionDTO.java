package lepetitcoin.dto;

import lepetitcoin.model.Region;
import lepetitcoin.model.SubCategory;
import lombok.Data;
@Data
public class RegionDTO {
	private int id_region;
	private String  name;
	
	private String ville;
	
	public RegionDTO(Region region) {
		this.setId_region(region.getId_region());
		this.setName(region.getName());
		this.setVille(region.getVille().getName());
		
	}

}
