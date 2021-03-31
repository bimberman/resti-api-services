package com.cognixia.jump.controller;

import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cognixia.jump.exception.ResourceNotFoundException;
import com.cognixia.jump.model.Restaurant;
import com.cognixia.jump.repository.RestaurantRepository;
import com.cognixia.jump.service.RestaurantService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(RestaurantController.class)
//@AutoConfigureMockMvc
class RestaurantControllerTest {
	
	private final String STARTING_URI = "http://localhost:8080/api";
	
	@MockBean
	private RestaurantRepository repo;
	
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private RestaurantService service;
	
	@InjectMocks
	private RestaurantController controller;


	@Test
	void testGetAllRestaurants() throws Exception {
		
		String uri = STARTING_URI + "/restaurants";
		
		List<Restaurant> allRestaurants = Arrays.asList(
				new Restaurant(1L, "Burger King", "123 Some Street", "some description"), 
				new Restaurant(2L, "Subway", "456 Another Street", "another description")
				);
		
		when( service.getAllRestaurants() ).thenReturn( allRestaurants );
		
		mockMvc.perform(get(uri))
				.andDo(print())
				.andExpect( status().isOk() )
				.andExpect( content().contentType(MediaType.APPLICATION_JSON_VALUE) )
				.andExpect( jsonPath("$.length()").value(allRestaurants.size()) )
				.andExpect( jsonPath("$[0].Id").value(allRestaurants.get(0).getId()) )				
				.andExpect( jsonPath("$[0].name").value(allRestaurants.get(0).getName()) )
				.andExpect( jsonPath("$[0].address").value(allRestaurants.get(0).getAddress()) )
				.andExpect( jsonPath("$[0].description").value(allRestaurants.get(0).getDescription()) )
				.andExpect( jsonPath("$[1].Id").value(allRestaurants.get(1).getId()) )
				.andExpect( jsonPath("$[1].name").value(allRestaurants.get(1).getName()) )
				.andExpect( jsonPath("$[1].address").value(allRestaurants.get(0).getAddress()) )
				.andExpect( jsonPath("$[1].description").value(allRestaurants.get(1).getDescription()) );
		
		
	verify(service, times(1)).getAllRestaurants();
	verifyNoMoreInteractions(service);
	}

	@Test
	void testGetRestaurant() throws Exception {
		
		long id = 1;
		String uri = STARTING_URI + "/restaurants/{id}";
		
		Restaurant restaurant = new Restaurant("Burger King", "123 Some Street", "some description");
		
		when( service.getRestaurantById(id) ).thenReturn(restaurant);
		
		mockMvc.perform( get(uri, id) )
				.andExpect( status().isOk() )
				.andExpect( content().contentType(MediaType.APPLICATION_JSON_VALUE) )
				.andExpect( jsonPath("$.Id").value(restaurant.getId() ) )
				.andExpect( jsonPath("$.name").value(restaurant.getName()) )
				.andExpect( jsonPath("$.address").value(restaurant.getAddress()) )
				.andExpect( jsonPath("$.description").value(restaurant.getDescription()) );
		
		verify(service, times(1)).getRestaurantById(id);
		verifyNoMoreInteractions(service);
	}
	
	@Test
	void testGetRestaurantNotFound() throws Exception {
		
		long id = 1;
		String uri = STARTING_URI + "/restaurants/" + id;
		
		when( service.getRestaurantById(id) )
			.thenThrow(new ResourceNotFoundException("Restaurant with id = " + id + " could not be found"));
		
		mockMvc.perform( get(uri, id) )
			.andExpect( status().isNotFound() );
		
		verify(service, times(1)).getRestaurantById(id);
		verifyNoMoreInteractions(service);
	}

//	@Test
//	void testCreateRestaurant() throws Exception {
//		
//		String uri = STARTING_URI + "/add/restaurant";
//		
//		Restaurant restaurant = new Restaurant(1L, "Burger King", "123 Some Street", "some description");
//		
//		MediaType textPlainUtf8 = new MediaType(MediaType.TEXT_PLAIN, Charset.forName("UTF-8"));
//		
//		String restaurantJson = restaurant.toJson();
//		
//		mockMvc.perform(post(uri)
//				.content(restaurantJson)
//				.contentType(MediaType.APPLICATION_JSON_VALUE) )
//				.andExpect( status().isCreated() )
//				.andExpect( content().contentType(textPlainUtf8) );
//		
//		when (controller.addRestaurant(restaurant)).thenReturn(restaurant);		
//		mockMvc.perform(post(uri)
//							.contentType(MediaType.APPLICATION_JSON_VALUE)
//							.content( asJsonString(restaurant) ))
//							
//					.andExpect(status().isCreated());
//		
//	}
	
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}

