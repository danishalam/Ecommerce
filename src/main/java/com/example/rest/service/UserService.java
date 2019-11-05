package com.example.rest.service;

import com.example.rest.entity.ProductCatalog;
import com.example.rest.entity.User;

/**
 * This is the Service class for User Entity
 * @author Mohd Danish
 *
 */
public interface UserService {

	/**
	 * 
	 * @param pCatalog
	 * @return
	 */
	public User addProductInCataloge(ProductCatalog pCatalog);
}
