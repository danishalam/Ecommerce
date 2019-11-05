package com.example.rest.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.rest.entity.ProductCatalog;
import com.example.rest.entity.User;
import com.example.rest.entity.repository.ProductRepository;
import com.example.rest.entity.repository.UserRepository;
import com.example.rest.service.ProductCatalogService;

/**
 * This class is the Implementation of ProcuctCatalogService.class
 * 
 * @author DanishA
 *
 */
@Service
public class ProductCatalogServiceImpl implements ProductCatalogService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProductRepository productRepository;

	/**
	 * This is the implementation of method which is declared in
	 * ProductCatalogService.class.
	 */
	@Override
	public List<ProductCatalog> findByUserIdFromProductCatalog(String userId) {
		// TODO Auto-generated method stub
		List<ProductCatalog> productList = productRepository.findByUserIdFromProductCatalog(userId);
		List<User> user = userRepository.findByUserIdFromUser(userId);
		user.get(0).setProductCatalogList(productList);
		return productList;
	}

	/**
	 * This is the implementation of method which is declared in
	 * ProductCatalogService and it is used to get single product 
	 * from Catalog by product ID. 
	 */
	@Override
	public Optional<ProductCatalog> findById(long ids) {
		// TODO Auto-generated method stub
		Optional<ProductCatalog> proCataologObj = productRepository.findById(ids);
		return proCataologObj;
	}

	@Override
	public List<ProductCatalog> findAll() {
		List<ProductCatalog> productCatalog = productRepository.findAll();
		return productCatalog;
	}

	@Override
	public void deleteById(long ids) {
		productRepository.deleteById(ids);
	}

	@Override
	public List<ProductCatalog> findAllSortByName() {
		List<ProductCatalog> productCatalogs = productRepository.findAll(Sort.by("productName"));
		return productCatalogs;
	}


	@Override
	public List<ProductCatalog> findAllSortByPriceLowToHigh() {
		List<ProductCatalog> productCatalogs = productRepository.findAll(Sort.by("price").ascending());
		return productCatalogs;
	}

	@Override
	public List<ProductCatalog> findAllSortByPriceHighToLow() {
		List<ProductCatalog> productCatalogs = productRepository.findAll(Sort.by("price").descending());
		return productCatalogs;
	}

}
