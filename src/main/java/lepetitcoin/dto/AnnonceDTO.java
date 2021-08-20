package lepetitcoin.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lepetitcoin.model.Annonce;
import lepetitcoin.model.Criterion;
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
	
	private String ville;
	private String region;
	private String description;
	private Date date = new Date(id_ad) ;
	private List<String> user= new ArrayList<>();
	private List<String> criteres= new ArrayList<>();
	private String livraison;
	private String category;
	private String subCategory;
	public AnnonceDTO(Annonce annonce) {
		this.setName(annonce.getName());
		this.setVille(annonce.getVille());
		this.setRegion(annonce.getRegion());
		this.setPrice(annonce.getPrice());
		this.setDate(annonce.getDate());

		this.setLivraison(annonce.getLivraison());
		
		this.setDescription(annonce.getDescription());
		 this.user.add( annonce.getUser().getEmail());
		 this.user.add(annonce.getUser().getNom());
		 
		 this.user.add(annonce.getUser().getTelephone());
		// this.user.add(annonce.getUser().getRole().getRole());
		 //this.user.add(annonce.getUser().getDatenaissance());
		 //this.user.add(annonce.getUser().getType_user());
		 this.user.add(annonce.getUser().getVille());
		 
		 this.setId_ad(annonce.getId_ad());
		
		this.setCategory(annonce.getSubCategory().getCategory().getName());
		this.setSubCategory(annonce.getSubCategory().getName());
	
		this.criteres.add(annonce.getCritere1());
		this.criteres.add(annonce.getCritere2());
		this.criteres.add(annonce.getCritere3());
		this.criteres.add(annonce.getCritere4());
		this.criteres.add(annonce.getCritere5());
		
	}
}
