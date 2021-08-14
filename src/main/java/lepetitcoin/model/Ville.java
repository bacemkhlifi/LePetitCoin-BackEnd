package lepetitcoin.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ville {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_ville;
	@Column(unique=true)
	private String name;
	@OneToMany(mappedBy = "ville")
	private List<Region> region;

}
