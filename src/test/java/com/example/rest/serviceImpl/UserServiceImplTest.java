package com.example.rest.serviceImpl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.rest.entity.ProductCatalog;
import com.example.rest.entity.User;

/**
 * @author DanishA
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
	
	@Autowired
	UserServiceImpl userServiceImpl;
	ProductCatalog productCatalog;
	
	
	/**
	 * This method initialize our required initial setup's
	 */
	@Before
	public void setUp() {
		productCatalog = new ProductCatalog();
		productCatalog.setProductId(12455L);
		productCatalog.setProductName("Nokia");
		productCatalog.setPrice(15000F);
		productCatalog.setProductDescription("Nokia Mobile");
		productCatalog.setProductAvailability("H");
		productCatalog.setUserId("danish@hcl.com");
	}
	
	
	/**
	 * This method validate add Product in Catalog
	 */
	@Test
	public void testAddProductInCatalog() {
		User user = userServiceImpl.addProductInCataloge(productCatalog);
		System.out.println("USER_ID"+user.getUserId());
		assertEquals("danish@hcl.com", user.getUserId());
	}
	
	/**
	 * 
	 */
	@Test
	public void test() {
		
	}

}
