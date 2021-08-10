package lepetitcoin.controlleur;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lepetitcoin.dao.UserRepository;
import lepetitcoin.model.User;
@Service
public class UserService {
	@Autowired
	public UserRepository userRep;
	//get users
	public List<User> getAllUsers() {
		return userRep.findAll();
	}
	//get annonces user
	/*@GetMapping(value="user/annonce/{email}")
	public Optional<User> getAnnoncesUser(@PathVariable(value="email") String email){
		return userRep.findById(email);
		
	}*/
	
}
