package com.example.rest.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest.entity.ProductCatalog;
import com.example.rest.entity.User;
import com.example.rest.entity.repository.ProductRepository;
import com.example.rest.entity.repository.UserRepository;
import com.example.rest.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProductRepository productRepository;
	
	
	/**
	 *@param pCatalog
	 *@return
	 *This is the implementation of method declared in UserService
	 */
	@Override
	public User addProductInCataloge(ProductCatalog pCatalog) {
		
		
		List<User> user = userRepository.findByUserIdFromUser(pCatalog.getUserId());
		ProductCatalog newProductCatalog;
		User newUser;
		if (user.size() > 0 && user.get(0).getUserId().equalsIgnoreCase(pCatalog.getUserId())) {
			newUser = user.get(0);
			newUser.setUserId(pCatalog.getUserId());
			List<ProductCatalog> productCatalogList = newUser.getProductCatalogList();
			newProductCatalog = new ProductCatalog(pCatalog.getProductId(), pCatalog.getProductName(),
					pCatalog.getPrice(), pCatalog.getProductDescription(), pCatalog.getProductAvailability(),
					pCatalog.getUserId());
			newProductCatalog.setUser(newUser);
			productCatalogList.add(newProductCatalog);
			newUser.setProductCatalogList(productCatalogList);
			userRepository.save(newUser);
		} else {
			newUser = new User();
			newUser.setUserId(pCatalog.getUserId());
			List<ProductCatalog> productCatalogList = new ArrayList();
			newProductCatalog = new ProductCatalog(pCatalog.getProductId(), pCatalog.getProductName(),
					pCatalog.getPrice(), pCatalog.getProductDescription(), pCatalog.getProductAvailability(),
					pCatalog.getUserId());
			newProductCatalog.setUser(newUser);
			productCatalogList.add(newProductCatalog);
			newUser.setProductCatalogList(productCatalogList);
			userRepository.save(newUser);
		}
		 productRepository.save(newProductCatalog);
		
		return newUser;
	}

}
