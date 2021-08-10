package lepetitcoin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import lepetitcoin.model.User;

public interface UserRepository extends JpaRepository<User, String> {

	
}

