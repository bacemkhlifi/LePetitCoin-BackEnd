package lepetitcoin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import lepetitcoin.model.Criterion;

public interface CriterionRepository extends JpaRepository<Criterion, Integer> {

}
