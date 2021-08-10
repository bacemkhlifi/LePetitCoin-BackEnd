package lepetitcoin.controlleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lepetitcoin.dao.AnnonceRepository;
import lepetitcoin.model.Annonce;

@Service
public class AnnonceService {
	
	@Autowired
	AnnonceRepository annonceRep;
	public List<Annonce> getAnnonces(){
		return annonceRep.findAll();
	}
}
