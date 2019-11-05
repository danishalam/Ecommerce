package com.example.rest.service;

import java.util.List;
import java.util.Optional;

import com.example.rest.entity.ProductCatalog;


/**
 * @author DanishA
 *
 */
public interface ProductCatalogService {

	/**
	 * This custom method will return product list on the basis of user Id,
	 * which is implemented in ProductCatalogServiceImpl.class.
	 * @param userId
	 * @return
	 */
	public List<ProductCatalog> findByUserIdFromProductCatalog(String userId);
	
	
	/**
	 * This method is used which is declared in ProductCatalogServiceImpl.class.
	 * @param ids
	 * @return
	 */
	public Optional<ProductCatalog> findById(long ids);
	
	/**
	 * This method will return Product List from Catalog
	 * @return
	 */
	public List<ProductCatalog> findAll();
	
	
	/**
	 * @param ids
	 * @return
	 */
	public void deleteById(long ids);
	
	/**
	 * This method will return all product in Sort Order by Product Name 
	 * @return
	 */
	public List<ProductCatalog> findAllSortByName();
	
	
	/**
	 * This method will return all Product in Sort Order by Price High to Low
	 * @return
	 */
	public List<ProductCatalog> findAllSortByPriceHighToLow();
	
	/**
	 * This method will return All Product in Sort order by Price Low to High
	 * @return
	 */
	public List<ProductCatalog> findAllSortByPriceLowToHigh();
	
	
}
