package lepetitcoin;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lepetitcoin.dao.CategoryRepository;
import lepetitcoin.dao.CriterionRepository;
import lepetitcoin.dao.RegionRepository;
import lepetitcoin.dao.RoleRepository;
import lepetitcoin.dao.SubCategoryRepository;
import lepetitcoin.dao.UserRepository;
import lepetitcoin.dao.VilleRepository;
import lepetitcoin.model.Category;
import lepetitcoin.model.Criterion;
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
	@Autowired
	public CriterionRepository criRep;
	
	@Bean
	public void villes() {
		///1er ville 
		Ville ville= new Ville(1,"Sfax",null);
		this.villeRep.save(ville);
			Region region=new Region(1,"Jbeniyana",ville);
			this.regionRep.save(region);
			Region region1=new Region(2,"Agareb",ville);
			this.regionRep.save(region1);
		///2eme ville 
		Ville ville1= new Ville(2,"Sousse",null);
		this.villeRep.save(ville1);
			Region region3=new Region(3,"Akouda",ville1);
			this.regionRep.save(region3);
		///3eme ville 
		Ville ville2= new Ville(3,"Tunis",null);
		this.villeRep.save(ville2);
		///1er ville 
		Ville ville3= new Ville(4,"Nabeul",null);
		this.villeRep.save(ville3);
		
		
	}
	
	@Bean
	public void addCats()   {
		//1er categories
		Category categ= new Category(1,"Immobilier",null);
		this.catRep.save(categ);
		 
		SubCategory subCat = new SubCategory(1,"Bureaux&commerces",null,categ,null);
		this.subCatRep.save(subCat);
		SubCategory subCat1 = new SubCategory(2,"Ventes immobilières",null,categ,null);
		this.subCatRep.save(subCat1);
		SubCategory subCat2 = new SubCategory(3,"Locations",null,categ,null);
		this.subCatRep.save(subCat2);
		///// 2eme categorie
		Category categ1= new Category(2,"Multimédia",null);
		this.catRep.save(categ1);
		
		SubCategory subCat0 = new SubCategory(4,"Informatique",null,categ1,null);
		this.subCatRep.save(subCat0);
		SubCategory subCat11 = new SubCategory(5,"Consoles & Jeux vidéo",null,categ1,null);
		this.subCatRep.save(subCat11);
		SubCategory subCat21 = new SubCategory(6,"Téléphonie",null,categ1,null);
		
		this.subCatRep.save(subCat21);
		SubCategory subCat31 = new SubCategory(7,"Image & Son",null,categ1,null);
		this.subCatRep.save(subCat31);
		
		//3eme category
		
		Category categ10= new Category(3,"Véhicules",null);
		this.catRep.save(categ10);
		
		SubCategory subCat00 = new SubCategory(8,"Motos",null,categ10,null);
		this.subCatRep.save(subCat00);
		SubCategory subCat110 = new SubCategory(9,"Voitures",null,categ10,null);
		this.subCatRep.save(subCat110);
		Criterion critere = new Criterion(0,"Kilométrage",null,subCat110);
		this.criRep.save(critere);
		Criterion critere1 = new Criterion(1,"Boite",null,subCat110);
		this.criRep.save(critere1);
		
		
		
		SubCategory subCat210 = new SubCategory(10,"Vélos",null,categ10,null);
		
		this.subCatRep.save(subCat210);
		SubCategory subCat310 = new SubCategory(11,"Remorques et Caravanes",null,categ10,null);
		this.subCatRep.save(subCat310);
		
		
		//4émè categorie
		Category categ20= new Category(4,"Maison",null);
		this.catRep.save(categ20);
		//5émè categorie
		Category categ30= new Category(5,"Loisirs et Divertissemen",null);
		this.catRep.save(categ30);
		//6émè categorie
		Category categ40= new Category(6,"Habillement et Bien Etre",null);
		this.catRep.save(categ40);
		//7émè categorie
		Category categ50= new Category(7,"Matériel Professionnel",null);
		this.catRep.save(categ50);
		//8émè categorie
		Category categ60= new Category(8,"Emploi et Services",null);
		this.catRep.save(categ60);
		//9émè categorie
		Category categ70= new Category(9,"Autres",null);
		this.catRep.save(categ70);
		
		
	
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