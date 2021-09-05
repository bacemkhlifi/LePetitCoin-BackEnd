package lepetitcoin.controlleur;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lepetitcoin.dao.MessageRepository;
import lepetitcoin.dao.UserRepository;
import lepetitcoin.model.Messages;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/v1")
public class MessageControlleur {
	
	@Autowired MessageRepository msgRep;
	@Autowired UserRepository userRep;
	// api send msg
	@PostMapping(value="send/{email_e}/{email_r}")
	public Messages sendMessage(@RequestBody Messages msg , @PathVariable(value="email_e") String email_e,
			 @PathVariable(value="email_r") String email_r) {
		String userName = userRep.findById(email_e).get().getNom();
		Messages msg1 = new Messages();
		msg1.setName_e(userName);
		msg1.setEmail_e(email_e);
		msg1.setEmail_r(email_r);
		msg1.setMessage(msg.getMessage());
		
		return msgRep.save(msg1);
		}
	
	//api get messages by user
	 @GetMapping(value="message/{email_r}")
	public ArrayList<Messages> getMessages(@PathVariable(value="email_r") String email_r){
		 ArrayList<Messages> msgs = new ArrayList<Messages>();
		 List<Messages> allMsg=	msgRep.findAll();
		 for (Messages i : allMsg) {
			 if(i.getEmail_r().equals(email_r)) {
				 msgs.add(i);
			 }
		 }
		 return msgs;
	}
	 //find by id msg
	 @GetMapping(value="messages/{id}")
	 public Optional<Messages> getmsgbyID(@PathVariable(value="id") Integer id) {
		 return msgRep.findById(id);
	 }
	

}
