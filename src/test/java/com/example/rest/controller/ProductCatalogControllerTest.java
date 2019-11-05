/**
 * 
 */
package com.example.rest.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
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
public class ProductCatalogControllerTest {

	@Autowired
	MockMvc mockMvc;
	@MockBean
	UserServiceImpl userServiceImpl;
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
	 * Test method for {@link com.example.rest.controller.ProductCatalogController#getSingleProductFromCatalogByProductId(long)}.
	 * @throws Exception 
	 */
	@Test
	public void testGetSingleProductFromCatalogByProductId() throws Exception {
		
		MvcResult result = mockMvc.perform(requestBuilder("/getSingleProductFromCatalogByProductId/121")).andReturn();
		int status = result.getResponse().getStatus();
		assertEquals(200, status);
		
	}

	
	/**
	 * This method will return JSON to String
	 * @param productCatalog2
	 * @return
	 */
	private String asObjectToJsonString(ProductCatalog productCatalog2) {
		
		try {
			return new ObjectMapper().writeValueAsString(productCatalog2);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * This method will check your path and return RequestBuilder Object 
	 * @param Path
	 * @return
	 */
	private RequestBuilder requestBuilder(String path) {
		RequestBuilder builder=MockMvcRequestBuilders.get(path)
				.contentType(MediaType.APPLICATION_JSON)
				.content(asObjectToJsonString(productCatalog))
				.characterEncoding("utf-8")
				.accept(MediaType.APPLICATION_JSON);
		return builder;
		
	}

	/**
	 * Test method for {@link com.example.rest.controller.ProductCatalogController#retrievAllProductFromCatalog()}.
	 * @throws Exception 
	 */
	@Test
	public void testRetrievAllProductFromCatalog() throws Exception {
		
		MvcResult result = mockMvc.perform(requestBuilder("/getAllProductCatalog")).andReturn();
		int status = result.getResponse().getStatus();
		assertEquals(200, status);
	}

	/**
	 * Test method for {@link com.example.rest.controller.ProductCatalogController#deleteProductById(long)}.
	 * @throws Exception 
	 */
	@Test
	public void testDeleteProductById() throws Exception {
		
		RequestBuilder builder=MockMvcRequestBuilders.delete("/deleteProductById/121").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(builder).andReturn();
		int status = result.getResponse().getStatus();
		assertEquals(200, status);
	}

	/**
	 * Test method for {@link com.example.rest.controller.ProductCatalogController#retrievAllProductFromCatalogBasedOnNameSort()}.
	 * @throws Exception 
	 */
	@Test
	public void testRetrievAllProductFromCatalogBasedOnNameSort() throws Exception {
		
		MvcResult result = mockMvc.perform(requestBuilder("/getAllProductsSortByName")).andReturn();
		int status = result.getResponse().getStatus();
		assertEquals(200, status);
	}

	/**
	 * Test method for {@link com.example.rest.controller.ProductCatalogController#retrievAllProductFromCatalogBasedOnPriceSortHighToLow()}.
	 * @throws Exception 
	 */
	@Test
	public void testRetrievAllProductFromCatalogBasedOnPriceSortHighToLow() throws Exception {
		MvcResult result = mockMvc.perform(requestBuilder("/getAllProductsSortByPriceHighToLow")).andReturn();
		int status = result.getResponse().getStatus();
		assertEquals(200, status);
	}

	/**
	 * Test method for {@link com.example.rest.controller.ProductCatalogController#retrievAllProductFromCatalogBasedOnPriceSortLowToHigh()}.
	 * @throws Exception 
	 */
	@Test
	public void testRetrievAllProductFromCatalogBasedOnPriceSortLowToHigh() throws Exception {
		MvcResult result = mockMvc.perform(requestBuilder("/getAllProductsSortByPriceLowToHigh")).andReturn();
		int status = result.getResponse().getStatus();
		assertEquals(200, status);
	}

}
