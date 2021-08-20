package lepetitcoin.model;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data 
@AllArgsConstructor
@NoArgsConstructor
public class SubCategory implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	
	private int id_subcat;
	@Id
	private String name;
	
	//@JsonManagedReference
	@OneToMany(mappedBy = "subCategory")
	private List <Annonce>  annonce;
	@ManyToOne
	private Category category;
	@OneToMany(mappedBy = "subCategory")
	private List <Criterion>  criterion;
}
