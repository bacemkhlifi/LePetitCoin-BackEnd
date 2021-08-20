package lepetitcoin.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@AllArgsConstructor
@NoArgsConstructor
public class Criterion {
@GeneratedValue(strategy=GenerationType.IDENTITY)	
	
	private int id_cr;
	@Id
	private String name;
	private String value;
	@ManyToOne
	private SubCategory subCategory;

}
