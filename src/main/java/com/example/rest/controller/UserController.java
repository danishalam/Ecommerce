package com.example.rest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.rest.entity.ProductCatalog;
import com.example.rest.entity.User;
import com.example.rest.serviceImpl.ProductCatalogServiceImpl;
import com.example.rest.serviceImpl.UserServiceImpl;

@RestController
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;
	@Autowired
	private ProductCatalogServiceImpl productCatalogServiceImpl;

	/** 
	 * This method will add the Product in Catalog according to the user ID(Example:xyz@gmail.com )
	 * 
	 * @param pCatalog
	 * @return
	 */

	@PostMapping("/addProductInCatalog")
	public User addProductInCatalog(@RequestBody ProductCatalog pCatalog) {

		return userServiceImpl.addProductInCataloge(pCatalog);
	}

	/**
	 * This method will get all product from Catalog on the basis of User Id
	 * 
	 * @param userId
	 * @return
	 */

	@GetMapping("/getAllProductByUserId/{userId}")
	public List<ProductCatalog> getUserProductList(@PathVariable String userId) {

		return productCatalogServiceImpl.findByUserIdFromProductCatalog(userId);
	}

}
