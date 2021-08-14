
package lepetitcoin.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lepetitcoin.model.Category;
import lepetitcoin.model.Ville;
import lombok.Data;

@Data
public class VilleDTO {
	private int id_ville;
	private String  name;
	
	private List<RegionDTO> region = new ArrayList<>();
	public VilleDTO(Ville ville) {
		this.setId_ville(ville.getId_ville());
		this.setName(ville.getName());
		List<RegionDTO> regionDTOs  =ville.getRegion().stream().map(RegionDTO::new).collect(Collectors.toList());
		 this.setRegion(regionDTOs);
		
	}
}