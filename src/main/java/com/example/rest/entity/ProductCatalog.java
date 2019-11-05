package com.example.rest.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Mohd Danish
 *
 */
@Entity 
public class ProductCatalog {
	
	/*When we Use String as a Primary key then we will use UUID
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid") */
	
	@Id
	Long productId;
	String productName;
	Float price;
	String productDescription;
	String productAvailability;
	String userId;
	
	/**
	 * This is the default constructor
	 */
	public ProductCatalog() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * This is the parametrized constructor for this classs
	 * @param productId
	 * @param productName
	 * @param price
	 * @param productDescription
	 * @param productAvailability
	 * @param userId
	 */
	public ProductCatalog(long productId, String productName, float price, String productDescription,
			String productAvailability, String userId) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.productDescription = productDescription;
		this.productAvailability = productAvailability;
		this.userId = userId;
	}
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;

	/**
	 * This method will get user ID from User
	 * @return
	 */
	public String getUserId() {
		return userId;
	}
	
	/**
	 * This method will set the user ID
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	/**This method will get the user
	 * @return
	 */
	public User getUser() {
		return user;
	}
	
	/**
	 * This method will set the User
	 * @param user
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * This method will get the Product ID
	 * @return
	 */
	public Long getProductId() {
		return productId;
	}
	
	/**This method will set the Product ID
	 * @param productId
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	/**
	 * This method is used to get the Product Name 
	 * @return
	 */
	public String getProductName() {
		return productName;
	}
	
	/**
	 * This method is used to set the Product Name
	 * @param productName
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
	/**
	 * This method is used to get the Price
	 * @return
	 */
	public Float getPrice() {
		return price;
	}
	
	/**
	 * This method is used to set the Price
	 * @param price
	 */
	public void setPrice(Float price) {
		this.price = price;
	}
	
	
	/**
	 * This method is used to get the Product Description
	 * @return
	 */
	public String getProductDescription() {
		return productDescription;
	}
	
	
	/**
	 * This method is used to set the Product Description
	 * @param productDescription
	 */
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	
	/**
	 * This method is used to get the Product Availability 
	 * @return
	 */
	public String getProductAvailability() {
		return productAvailability;
	}
	
	
	/**
	 * This method is used to set the Product Availability 
	 * @param productAvailability
	 */
	public void setProductAvailability(String productAvailability) {
		this.productAvailability = productAvailability;
	}
	
	@Override
	public String toString() {
		return "ProductCatalog [productId=" + productId + ", productName=" + productName + ", price=" + price
				+ ", productDescription=" + productDescription + ", productAvailability=" + productAvailability
				+ ", user=" + user + "]";
	}
	
	
	
}
