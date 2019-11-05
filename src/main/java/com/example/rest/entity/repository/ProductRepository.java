package com.example.rest.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.rest.entity.ProductCatalog;

/**
 * @author Mohd Danish
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<ProductCatalog, Long> {

	
	 /**
	  * This is used for custom Query for UserId as String
	 * @param userId
	 * @return
	 */
	@Query("select p from ProductCatalog p where p.userId= :userId")
	 List<ProductCatalog> findByUserIdFromProductCatalog(String userId);
}
