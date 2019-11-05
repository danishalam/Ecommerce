package com.example.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.rest.entity.ProductCatalog;
import com.example.rest.serviceImpl.ProductCatalogServiceImpl;

/**
 * @author DanishA
 *
 */

@RestController
public class ProductCatalogController {

	@Autowired
	private ProductCatalogServiceImpl productCatalogServiceImpl;


	/**
	 * This method will get Single product from the Catalog by ProductId 
	 * @param ids
	 * @return 
	 */
	@GetMapping("/getSingleProductFromCatalogByProductId/{id}")
	public Optional<ProductCatalog> getSingleProductFromCatalogByProductId(@PathVariable("id") long ids) {

		return productCatalogServiceImpl.findById(ids);
	}

	/**
	 * 
	 * This method will get All the Product in the Product Catalog
	 * @return
	 */
	@GetMapping("/getAllProductCatalog")
	public List<ProductCatalog> retrievAllProductFromCatalog() {
		return productCatalogServiceImpl.findAll();
	}

	/**
	 * 
	 * This method will delete the Product by ProductId
	 * @param id
	 */
	@DeleteMapping("/deleteProductById/{id}")
	public void deleteProductById(@PathVariable long id) {
		productCatalogServiceImpl.deleteById(id);
	}

	
	/**
	 * This method will sort the Product By name
	 * @return
	 */
	@GetMapping("/getAllProductsSortByName")
	public List<ProductCatalog> retrievAllProductFromCatalogBasedOnNameSort() {
		return productCatalogServiceImpl.findAllSortByName();
	}
	
	
	/**
	 * This method will Sort Product by Price High to Low
	 * @return
	 */
	@GetMapping("/getAllProductsSortByPriceHighToLow")
	public List<ProductCatalog> retrievAllProductFromCatalogBasedOnPriceSortHighToLow() {
		return productCatalogServiceImpl.findAllSortByPriceHighToLow();
	}

	/**
	 * This method will Sort Product by Low To High
	 * @return
	 */
	@GetMapping("/getAllProductsSortByPriceLowToHigh")
	public List<ProductCatalog> retrievAllProductFromCatalogBasedOnPriceSortLowToHigh() {
		return productCatalogServiceImpl.findAllSortByPriceLowToHigh();
	}
}
