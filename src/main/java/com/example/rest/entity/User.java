package com.example.rest.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author DanishA
 *
 */
@Entity
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userTableId;
	private String userId;
	
	/**
	 * This method will get Table ID 
	 * @return
	 */
	public int getUserTableId() {
		return userTableId;
	}

	/**
	 * This method will set Table ID
	 * @param userTableId
	 */
	public void setUserTableId(int userTableId) {
		this.userTableId = userTableId;
	}
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user",  cascade = CascadeType.ALL)
	private List<ProductCatalog> productCatalogList;
	
	
	/**
	 * Default Constructor
	 */
	public User() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * This method will get userID
	 * @return
	 */
	public String getUserId() {
		return userId;
	}
	
	
	/**
	 * This method will set user ID
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * This method will get ProductCatalog List.
	 * @return
	 */
	public List<ProductCatalog> getProductCatalogList() {
		return productCatalogList;
	}
	
	/**
	 * This method will set ProductCatalogList
	 * @param productCatalogList
	 */
	
	public void setProductCatalogList(List<ProductCatalog> productCatalogList) {
		this.productCatalogList = productCatalogList;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userTableId=" + userTableId + "]";
	}
	
	
	
	
	
}
