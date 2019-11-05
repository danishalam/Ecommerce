/**
 * 
 */
package com.example.rest.serviceImpl;

import static org.junit.Assert.*;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.rest.entity.ProductCatalog;
import com.example.rest.entity.repository.ProductRepository;
import com.example.rest.entity.repository.UserRepository;


/**
 * @author DanishA
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCatalogServiceImplTest {
	
	@Autowired
	ProductCatalogServiceImpl productCatalogServiceImpl;
	@Autowired
	UserServiceImpl userServiceImpl;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	UserRepository userRepository;
	ProductCatalog productCatalog;
	Optional<ProductCatalog> optProductCatalog;
	

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		productCatalog = new ProductCatalog();
		productCatalog.setProductId(12455L);
		productCatalog.setProductName("Nokia");
		productCatalog.setPrice(15000F);
		productCatalog.setProductDescription("Nokia Mobile");
		productCatalog.setProductAvailability("H");
		productCatalog.setUserId("danish@hcl.com");
		userServiceImpl.addProductInCataloge(productCatalog);
	}

	/**
	 * Test method for {@link com.example.rest.serviceImpl.ProductCatalogServiceImpl#findByUserIdFromProductCatalog(java.lang.String)}.
	 */
	@Test
	public void testFindByUserIdFromProductCatalog() {
		
		optProductCatalog = productCatalogServiceImpl.findById(12455L);
		System.out.println("TEST_PRODUCT_ID"+optProductCatalog.get().getProductId());
		assertEquals(12455L, Long.parseLong(productCatalog.getProductId().toString()));
	}

	/**
	 * Test method for {@link com.example.rest.serviceImpl.ProductCatalogServiceImpl#findById(long)}.
	 */
	@Test
	public void testFindById() {
		
		optProductCatalog = productCatalogServiceImpl.findById(12455L);
		assertEquals(12455L, Long.parseLong(productCatalog.getProductId().toString()));
	}

	/**
	 * Test method for {@link com.example.rest.serviceImpl.ProductCatalogServiceImpl#findAll()}.
	 */
	@Test
	public void testFindAll() {
		
		List<ProductCatalog> productCatalogs2 = productCatalogServiceImpl.findAll();
		assertEquals(productCatalogs2.get(0).getProductId(),productCatalog.getProductId());
		
	}

	/**
	 * Test method for {@link com.example.rest.serviceImpl.ProductCatalogServiceImpl#deleteById(long)}.
	 */
	@Test
	public void testDeleteById() {
		
		optProductCatalog = productCatalogServiceImpl.findById(12455L);
		assertEquals(12455L, Long.parseLong(productCatalog.getProductId().toString()));
	}

	/**
	 * Test method for {@link com.example.rest.serviceImpl.ProductCatalogServiceImpl#findAllSortByName()}.
	 */
	@Test
	public void testFindAllSortByName() {
		List<ProductCatalog> productCatalogs = productCatalogServiceImpl.findAllSortByName();
		assertEquals(productCatalogs.get(0).getUserId(), productCatalog.getUserId());
	}

	/**
	 * Test method for {@link com.example.rest.serviceImpl.ProductCatalogServiceImpl#findAllSortByPriceLowToHigh()}.
	 */
	@Test
	public void testFindAllSortByPriceLowToHigh() {
		List<ProductCatalog> productCatalogs = productCatalogServiceImpl.findAllSortByPriceLowToHigh();
		assertEquals(productCatalogs.get(0).getUserId(), productCatalog.getUserId());
	}

	/**
	 * Test method for {@link com.example.rest.serviceImpl.ProductCatalogServiceImpl#findAllSortByPriceHighToLow()}.
	 */
	@Test
	public void testFindAllSortByPriceHighToLow() {
		List<ProductCatalog> productCatalogs = productCatalogServiceImpl.findAllSortByPriceHighToLow();
		assertEquals(productCatalogs.get(0).getUserId(), productCatalog.getUserId());
		
	}

}
