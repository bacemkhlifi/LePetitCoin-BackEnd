package lepetitcoin.model;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Annonce implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_ad;
	private String name;
	
	private String price ;
	
	private String ville;
	private String region;
	private String description;
	
	private Date date = new Date(id_ad) ;
	
	
	//@JsonBackReference
		@ManyToOne(fetch = FetchType.LAZY, optional=false)
		 @JoinColumn(name="subCategory_id_subcat", insertable=true, updatable=true)
			@JsonProperty("subCategory_id_subcat")
			@JsonIgnoreProperties("subCategory")
		private SubCategory subCategory;

	//@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, optional=false)
	 @JoinColumn(name="user_email", insertable=true, updatable=true)
	@JsonProperty("user_email")
	@JsonIgnoreProperties("user")
	private User user;
	
	
	
	
}
