package lepetitcoin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import lepetitcoin.model.Ville;

public interface VilleRepository extends JpaRepository<Ville, Integer> {

}
