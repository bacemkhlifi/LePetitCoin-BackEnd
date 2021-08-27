package lepetitcoin.controlleur;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lepetitcoin.model.Annonce;
import lepetitcoin.model.Category;
import lepetitcoin.model.Role;
import lepetitcoin.model.User;

import lepetitcoin.dao.RoleRepository;
import lepetitcoin.dao.UserRepository;
import lepetitcoin.dto.AnnonceDTO;
import lepetitcoin.dto.UserDTO;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/v1", produces = "application/json")

public class UserControlleur {
	
	@Autowired
	public RoleRepository roleRep;
	@Autowired
	public UserRepository userRep;
	
	//Api add user (membre par defaut)
	
		@PostMapping(value="/add/user" )
		
		public User createUser(@RequestBody  User user) {
			Role role = new Role();
			role.setRole("membre");
			roleRep.save(role);
			
			user.setRole(role);
			user.setType_user(user.getRole().getRole());
			
			return userRep.save(user);
		}
		
	
		
		//Api delete user 
		
		@DeleteMapping(value="/user/delete/{email}")
		public void deleteUser(@PathVariable(value="email") String email) {
		 userRep.deleteById(email);
		
			
		}
		
		//Api get users 
		@Autowired
		UserService userService;
		@GetMapping(value="/users")
		 List<UserDTO> getAllUsers() {
			return userService.getAllUsers().stream().map(UserDTO::new).collect(Collectors.toList());
		}
		
		
		//API update user
		@PutMapping(value="user/update/{id}")
		public String updateAd(@RequestBody User user ,@PathVariable(value="id") String id ) {
			Optional<User> user0 = userRep.findById(id);
			Optional<Role> roleBeta = roleRep.findById(user0.get().getRole().id_r);
			
			Role roleBeta0 = roleBeta.get();
			roleBeta0.setRole(user.getType_user());
			User userBeta = user0.get();
			//userBeta.setEmail(user.getEmail());
			userBeta.setPassword(user.getPassword());
			//userBeta.setCin(user.getCin());
			userBeta.setNom(user.getNom());
			userBeta.setPrenom(user.getPrenom());
			//userBeta.setVille(user.getVille());
			//userBeta.setType_user(user.getType_user());
			userBeta.setTelephone(user.getTelephone());
			//userBeta.setRegistre_comm(user.getRegistre_comm());
			//userBeta.setEtat_email(user.getEtat_email());
			//userBeta.setDatenaissance(user.getDatenaissance());
			//userBeta.setSexe(user.getSexe());
			//userBeta.setDate_insc(user.getDate_insc());
			userBeta.setRole(roleBeta0);
		userRep.save(userBeta);
			
			return " 200 ok  ";
		}
		
		
		
		//api show annonces user 
		@Autowired
		UserService userService1;
		@GetMapping(value="user/annonce/{email}")
	
		public UserDTO getAnnoncesUser(@PathVariable(value="email") String email){
			
			List<UserDTO> users=	userService.getAllUsers().stream().map(UserDTO::new).collect(Collectors.toList());
			for (UserDTO user1: users) {
				if(user1.getEmail().contentEquals(email)) {
					   
					   return user1;
				}
				
			}
			return null;
			
		
			
			
		
			}
}
