package lepetitcoin.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lepetitcoin.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	private String fullName;
	private String telephone;
	private String sexe;
	private String date_insc;
	private String datenaissance;
	private String registre_comm;
	private int etat_email;
	private String type_user;
	private String ville;
	private String region;
	private String email;
	private String password;
	private String role;

	private List<AnnonceDTO> annonces = new ArrayList<>();
	public  UserDTO(User user) { 
	
			this.setEmail(user.getEmail());
			this.setPassword(user.getPassword());
			this.setFullName(user.getNom() + " " + user.getPrenom());
			this.setDate_insc(user.getDate_insc());
			this.setVille(user.getVille());
			this.setRegion(user.getRegion());
			this.setType_user(user.getType_user());
			this.setTelephone(user.getTelephone());
			this.setRegistre_comm(user.getRegistre_comm());
			this.setEtat_email(user.getEtat_email());
			this.setDatenaissance(user.getDatenaissance());
			this.setSexe(user.getSexe());
			this.setRole(user.getRole().getRole());
			
			List<AnnonceDTO> annonceDTOs  =user.getAnnonce().stream().map(AnnonceDTO::new).collect(Collectors.toList());
			 this.setAnnonces(annonceDTOs);
	
	}
 
}
