package lepetitcoin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import lepetitcoin.model.Role;

public interface  RoleRepository extends JpaRepository<Role,Integer>  {

}