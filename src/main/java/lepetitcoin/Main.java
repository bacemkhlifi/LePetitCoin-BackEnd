package lepetitcoin;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lepetitcoin.dao.CategoryRepository;
import lepetitcoin.dao.RegionRepository;
import lepetitcoin.dao.RoleRepository;
import lepetitcoin.dao.SubCategoryRepository;
import lepetitcoin.dao.UserRepository;
import lepetitcoin.dao.VilleRepository;
import lepetitcoin.model.Category;
import lepetitcoin.model.Region;
import lepetitcoin.model.Role;
import lepetitcoin.model.SubCategory;
import lepetitcoin.model.User;
import lepetitcoin.model.Ville;

@SpringBootApplication
public class Main {
public static void main(String[] args) {
SpringApplication.run(Main.class,args);
}
	
	@Autowired 
	public CategoryRepository catRep;
	@Autowired 
	public UserRepository userRep;
	@Autowired
	public RoleRepository roleRep;
	@Autowired 
	public SubCategoryRepository subCatRep;
	@Autowired
	public RegionRepository regionRep;
	@Autowired
	public VilleRepository villeRep;
	
	@Bean
	public void villes() {
		///1er ville 
		Ville ville= new Ville(0,"Sfax",null);
		this.villeRep.save(ville);
		
		Region region=new Region(0,"Jbeniyana",ville);
		this.regionRep.save(region);
	}
	
	@Bean
	public void addCats()   {
		/////1er categories
		Category categ= new Category(1,"Immobilier",null);
		this.catRep.save(categ);
		
		SubCategory subCat = new SubCategory(1,"Bureaux&commerces",null,categ);
		this.subCatRep.save(subCat);
		SubCategory subCat1 = new SubCategory(2,"Ventes immobilières",null,categ);
		this.subCatRep.save(subCat1);
		SubCategory subCat2 = new SubCategory(3,"Locations",null,categ);
		this.subCatRep.save(subCat2);
		///// 2eme categorie
		Category categ1= new Category(2,"Multimédia",null);
		this.catRep.save(categ1);
		
		SubCategory subCat0 = new SubCategory(4,"Informatique",null,categ1);
		this.subCatRep.save(subCat0);
		SubCategory subCat11 = new SubCategory(5,"Consoles & Jeux vidéo",null,categ1);
		this.subCatRep.save(subCat11);
		SubCategory subCat21 = new SubCategory(6,"Téléphonie",null,categ1);
		
		this.subCatRep.save(subCat21);
		SubCategory subCat31 = new SubCategory(7,"Image & Son",null,categ1);
		this.subCatRep.save(subCat31);
		
	
	} 
	@Bean 
	public void defaultUsers() {
		User user0 = new User();
		user0.setEmail("bacem@gmail.com");
		user0.setPassword("12333");
		user0.setAddresse("Tunisie,sfax");
		user0.setNom("bacem");
		user0.setTelephone("22780333");
		user0.setDate_insc("30/07/2021");
		user0.setAnnonce(null);
		user0.setRole(null);
	
		user0.setType_user("membre");
		user0.setEtat_email(1);
		Role role1= new Role(1,"membre",null);
		
		user0.setRole(role1);
		this.roleRep.save(role1);
		this.userRep.save(user0);
	}
	@Bean 
	public void admin() {
		User user0 = new User();
		user0.setEmail("admin@gmail.com");
		user0.setPassword("12333");
		user0.setAddresse("Tunisie");
		user0.setNom("admin");
		user0.setTelephone("55380888");
		user0.setDate_insc("30/07/2021");
		user0.setAnnonce(null);
		user0.setRole(null);
		user0.setEtat_email(1);
		user0.setType_user("admin");
		Role role1= new Role(2,"admin",null);
		user0.setRole(role1);
		this.roleRep.save(role1);	
		this.userRep.save(user0);
	}

}