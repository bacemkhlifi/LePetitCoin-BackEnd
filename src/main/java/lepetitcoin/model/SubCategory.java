package lepetitcoin.model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data 
@AllArgsConstructor
@NoArgsConstructor
public class SubCategory {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	@Id
	private int id_subcat;
	
	private String name;
	
	//@JsonManagedReference
	@OneToMany(mappedBy = "subCategory",cascade = CascadeType.ALL, orphanRemoval=true)
	private List <Annonce>  annonce;
	@ManyToOne
	private Category category;
}
