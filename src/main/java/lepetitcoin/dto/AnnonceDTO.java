package lepetitcoin.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lepetitcoin.model.Annonce;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnnonceDTO {
	private int id_ad;
	private String name;
	
	private String price ;
	
	private String emplacement;
	private String description;
	private String date ;
	private List<String> user= new ArrayList<>();
	
	private String category;
	public AnnonceDTO(Annonce annonce) {
		this.setName(annonce.getName());
		this.setEmplacement(annonce.getEmplacement());
		this.setPrice(annonce.getPrice());
		this.setDate(annonce.getDate());
		this.setDescription(annonce.getDescription());
		 this.user.add( annonce.getUser().getEmail());
		 this.user.add(annonce.getUser().getNom());
		 
		 this.user.add(annonce.getUser().getTelephone());
		// this.user.add(annonce.getUser().getRole().getRole());
		 //this.user.add(annonce.getUser().getDatenaissance());
		 //this.user.add(annonce.getUser().getType_user());
		 this.user.add(annonce.getUser().getVille());
		 
		 this.setId_ad(annonce.getId_ad());
		
		this.setCategory(annonce.getCategory().getName());
	}
}
