package lepetitcoin.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Messages implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name_e;
	private String email_e;
	
	private String email_r;
	private String message;
}
