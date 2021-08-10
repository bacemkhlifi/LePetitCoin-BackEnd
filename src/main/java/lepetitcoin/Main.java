package lepetitcoin;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lepetitcoin.dao.CategoryRepository;
import lepetitcoin.dao.RoleRepository;
import lepetitcoin.dao.UserRepository;
import lepetitcoin.model.Category;
import lepetitcoin.model.Role;
import lepetitcoin.model.User;

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
	
	 @Bean
	public void addCats()   {
		Category cat = new Category(0,"immobilier",null);
		Category cat1 = new Category(1,"véhiculess",null);
		Category cat2 = new Category(2,"loisirs",null);
		Category cat3 = new Category(3,"informatique",null);
		Category cat4 = new Category(4,"emploi",null);
		
		this.catRep.save(cat);
		this.catRep.save(cat1);
		this.catRep.save(cat2);
		this.catRep.save(cat3);
		this.catRep.save(cat4);
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
		Role role1= new Role(0,"membre",null);
		
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
		Role role1= new Role(0,"admin",null);
		
		user0.setRole(role1);
		this.roleRep.save(role1);
		
			
		this.userRep.save(user0);
	}

}