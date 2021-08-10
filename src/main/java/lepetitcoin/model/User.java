package lepetitcoin.model;



import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor

public class User implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nom;
	private String prenom;
	private int cin ;
	
	private String telephone;
	private String sexe;
	private String date_insc;
	private String datenaissance;
	private String registre_comm;
	private int etat_email;
	private String type_user;
	private String ville;
	private String addresse;
	@Id
	private String email;
	private String password;

	//@JsonBackReference
	@ManyToOne
	private Role role ;
	

	//@JsonManagedReference
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval=true) 
   	List <Annonce>  annonce;


}
