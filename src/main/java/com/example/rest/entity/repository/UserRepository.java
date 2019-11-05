package com.example.rest.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.rest.entity.User;

/**
 * @author Mohd Danish
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	 /**
	  * This is used for custom Query for UserId as String
	 * @param userId
	 * @return
	 */
	@Query("select u from User u where u.userId= :userId")
	 List<User> findByUserIdFromUser(String userId);

	
}
