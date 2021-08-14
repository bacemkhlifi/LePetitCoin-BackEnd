package lepetitcoin.controlleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lepetitcoin.dao.RegionRepository;
import lepetitcoin.model.Region;

@Service
public class RegionService {
	@Autowired
	RegionRepository regionRep;
	public List<Region> getRegions(){
		return regionRep.findAll();
		
	}
}
