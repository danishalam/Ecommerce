/**
 * 
 */
package com.example.rest.controller;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.example.rest.entity.ProductCatalog;
import com.example.rest.serviceImpl.ProductCatalogServiceImpl;
import com.example.rest.serviceImpl.UserServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Mohd Danish
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	ProductCatalogServiceImpl productCatalogServiceImpl;
	ProductCatalog productCatalog;

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

	}

	/**
	 * Test method for
	 * {@link com.example.rest.controller.UserController#addProductInCatalog(com.example.rest.entity.ProductCatalog)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAddProductInCatalog() throws Exception {

		RequestBuilder builder = MockMvcRequestBuilders.post("/addProductInCatalog")
				.contentType(MediaType.APPLICATION_JSON).content(asObjectToJsonString(productCatalog))
				.characterEncoding("utf-8").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(builder).andReturn();
		int status = result.getResponse().getStatus();
		assertEquals(200, status);
	}

	private String asObjectToJsonString(ProductCatalog productCatalog) {

		try {
			return new ObjectMapper().writeValueAsString(productCatalog);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private String asObjectToJsonString(List<ProductCatalog> productCatalogList) {

		try {
			return new ObjectMapper().writeValueAsString(productCatalogList);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Test method for
	 * {@link com.example.rest.controller.UserController#getUserProductList(java.lang.String)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetUserProductList() throws Exception {

		List<ProductCatalog> productCatalogList = productCatalogServiceImpl
				.findByUserIdFromProductCatalog(productCatalog.getUserId());
		RequestBuilder builder = MockMvcRequestBuilders.get("/getAllProductByUserId/danish@hcl.com")
				.contentType(MediaType.APPLICATION_JSON).content(asObjectToJsonString(productCatalogList))
				.characterEncoding("utf-8").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(builder).andReturn();
		int status = result.getResponse().getStatus();
		assertEquals(200, status);
	}

}
