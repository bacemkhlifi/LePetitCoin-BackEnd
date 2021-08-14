package lepetitcoin.controlleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lepetitcoin.dao.VilleRepository;
import lepetitcoin.model.Ville;
@Service
public class VilleService {
	@Autowired 
	public VilleRepository villeRep;
	public List<Ville> getVilles(){
		return villeRep.findAll();
		}
}
