package lepetitcoin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import lepetitcoin.model.SubCategory;


public interface  SubCategoryRepository extends JpaRepository<SubCategory,String>  {

}