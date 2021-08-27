package lepetitcoin.controlleur;

import java.awt.SystemColor;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lepetitcoin.dao.AnnonceRepository;
import lepetitcoin.dao.CategoryRepository;
import lepetitcoin.dao.RoleRepository;
import lepetitcoin.dao.SubCategoryRepository;
import lepetitcoin.dao.UserRepository;
import lepetitcoin.dto.AnnonceDTO;
import lepetitcoin.dto.UserDTO;
import lepetitcoin.model.Annonce;
import lepetitcoin.model.Category;
import lepetitcoin.model.Role;
import lepetitcoin.model.SubCategory;
import lepetitcoin.model.User;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/v1")
public class AnnonceControlleur {

	@Autowired
	public UserRepository userRep;
	@Autowired
	public AnnonceRepository  adsRep;
	@Autowired 
	public CategoryRepository catRep;
	@Autowired
	public RoleRepository roleRep;
 

//APi add new adsence
	@PostMapping(value="add/ads/{email}/{subCategory}/{name}/{price}/{ville}/{region}/{description}/{livraison}")
	public  String creatAds(@PathVariable(value="name") String name,
			@PathVariable(value="price") String price,
			@PathVariable(value="ville") String ville,
			@PathVariable(value="region") String region,
			@PathVariable(value="description") String description,
			@PathVariable(value="livraison") String livraison,
			@PathVariable(value="email") User email
			,@PathVariable(value="subCategory") SubCategory subCategory
			,@RequestParam("file") MultipartFile file  ) {
		Annonce ads = new Annonce();
		String fileName = file.getOriginalFilename();
		
			try {
				file.transferTo(new File ("D:\\AnnoncesProject\\lenextad\\public\\fileAds\\"+fileName));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		ads.setName(name);
		ads.setPrice(price);
		ads.setDescription(description);
		ads.setVille(ville);
		ads.setRegion(region);
		ads.setLivraison(livraison);
		ads.setPhoto(fileName);
		ads.setSubCategory(subCategory);
		ads.setUser(email);
		 
		adsRep.save(ads);
	  	return "annonce a été ajoutée";
		
	}
//API get all annonces
	@Autowired
	AnnonceService annonceService;
	@GetMapping(value="/annonces")
	 List<AnnonceDTO> getAnnonces() {
		return annonceService.getAnnonces().stream().map(AnnonceDTO::new).collect(Collectors.toList());
	}
	
	//Api delete an ad
	@PostMapping(value="annonce/delete/{id}")
	public String deleteAd(@PathVariable(value = "id") Integer id ) {
		 adsRep.deleteById(id);
		return "l'annonce a été supprimée";
	}
	
	//Api update an ad
	@PutMapping(value="annonce/update/{id}")
	public String updateAd(@RequestBody Annonce annonce ,@PathVariable(value="id") Integer id ) {
		Optional<Annonce> annonce1 = adsRep.findById(id);
		
		Annonce ad = annonce1.get();
		//ad.setCategory(annonce.getCategory());
		ad.setDate(annonce.getDate());;
		//ad.setDescription(annonce.getDescription());
		//ad.setVille(annonce.getVille());
		//ad.setRegion(annonce.getRegion());
		//ad.setId_ad(id);
		ad.setName(annonce.getName());
		ad.setPrice(annonce.getPrice());
		//ad.setUser(annonce.getUser());
		
		adsRep.save(ad);
		
		return " l'annonce a été modifiée correctement ";
	}
	//get api by id
	
	@GetMapping(value="/annonce/{id}")
	public AnnonceDTO getAdById(@PathVariable(value="id") Integer id ) {
		 List<AnnonceDTO> lista=	annonceService.getAnnonces().stream().map(AnnonceDTO::new).collect(Collectors.toList());
		for (AnnonceDTO ad : lista)
		{
			
				if (ad.getId_ad() == id) {
					return ad;
				
				
			}

		}
		return null;
		 
		 
	}
	
	//get api by ville
	
		@GetMapping(value="/villes/annonce/{ville}")
		public List<AnnonceDTO> getAdByVille(@PathVariable(value="ville") String ville ) {
			 List<AnnonceDTO> lista=	annonceService.getAnnonces().stream().map(AnnonceDTO::new).collect(Collectors.toList());
			
			 List<AnnonceDTO> listeSorted= new ArrayList<AnnonceDTO>();
			 for (AnnonceDTO ad : lista)
			{

					if (ad.getVille().equals(ville)) {
						 listeSorted.add(ad); 
				}
			}
			return listeSorted;	 
		}
		
		//get api by region
		
			@GetMapping(value="/region/annonce/{region}")
			public List<AnnonceDTO> getAdByRegion(@PathVariable(value="region") String region ) {
				 List<AnnonceDTO> lista=	annonceService.getAnnonces().stream().map(AnnonceDTO::new).collect(Collectors.toList());
				
				 List<AnnonceDTO> listeSorted= new ArrayList<AnnonceDTO>();
				 for (AnnonceDTO ad : lista)
				{

						if (ad.getRegion().equals(region)) {
							 listeSorted.add(ad); 
					}
				}
				return listeSorted;	 
			}
			//get api by region
			
			@GetMapping(value="/subcat/annonce/{subcat}")
			public List<AnnonceDTO> getAdBySubCat(@PathVariable(value="subcat") String subcat ) {
				 List<AnnonceDTO> lista=	annonceService.getAnnonces().stream().map(AnnonceDTO::new).collect(Collectors.toList());
				
				 List<AnnonceDTO> listeSorted= new ArrayList<AnnonceDTO>();
				 for (AnnonceDTO ad : lista)
				{

						if (ad.getSubCategory().equals(subcat)) {
							 listeSorted.add(ad); 
					}
				}
				return listeSorted;	 
			}
			
	//get api by category
			
			@GetMapping(value="/category/annonce/{category}")
			public List<AnnonceDTO> getAdBycategory(@PathVariable(value="category") String category ) {
				 List<AnnonceDTO> lista=	annonceService.getAnnonces().stream().map(AnnonceDTO::new).collect(Collectors.toList());
				
				 List<AnnonceDTO> listeSorted= new ArrayList<AnnonceDTO>();
				 for (AnnonceDTO ad : lista)
				{

						if (ad.getCategory().equals(category)) {
							 listeSorted.add(ad); 
					}
				}
				return listeSorted;	 
			}
	//Upload photo
/*	@PostMapping("/upload")
	public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file){
		String fileName = file.getOriginalFilename();
		try {
			file.transferTo(new File ("c:\\upload\\"+fileName));
		} catch(Exception e) {
			return ResponseEntity.ok("File not Uploaded ");
		}
		return ResponseEntity.ok("File Uploaded ");
	}*/
}
