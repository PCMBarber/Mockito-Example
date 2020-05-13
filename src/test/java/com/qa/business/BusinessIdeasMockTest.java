package com.qa.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.qa.service.listService;

public class BusinessIdeasMockTest {

	@Test
	public void testingMocks1() {
		
		listService listServiceMock = mock(listService.class);
		
		List<String> ideas = Arrays.asList("Chicken soda", "Leather gumshield", "Chicken flavored icecream");
		
		when(listServiceMock.retrieveIdeas("Something")).thenReturn(ideas);
		
		
		businessClass businessClass = new businessClass(listServiceMock);
		
		List<String> filteredIdeas = businessClass.retrieveChickenIdeas("Something");
		assertEquals(2, filteredIdeas.size());
	}
	
	@Test
	public void testingMocks2() {
		
		listService listServiceMock = mock(listService.class);
		
		List<String> ideas1 = Arrays.asList("Chicken soda", "Leather gumshield", "Chicken flavored icecream");
		List<String> ideas2 = Arrays.asList("Chicken soda");
		
		when(listServiceMock.retrieveIdeas("Nothing")).thenReturn(ideas1).thenReturn(ideas2);
		
		businessClass businessClass = new businessClass(listServiceMock);
		
		List<String> filteredIdeas = businessClass.retrieveChickenIdeas("Nothing");
		assertEquals(2, filteredIdeas.size());
		
		filteredIdeas = businessClass.retrieveChickenIdeas("Nothing");
		assertEquals(1, filteredIdeas.size());
		
	}
	
	
	@Test
	public void testingMocks3() {
		
		listService listServiceMock = mock(listService.class);
		
		List<String> ideas1 = Arrays.asList("Chicken soda", "Leather gumshield", "Chicken flavored icecream");
		
		businessClass businessClass = new businessClass(listServiceMock);
		
		//given
		given(listServiceMock.retrieveIdeas("")).willReturn(ideas1);

		//when
		List<String> filteredIdeas = businessClass.retrieveChickenIdeas("");

		//then
		assertThat(filteredIdeas.size(), is(2));
		verify(listServiceMock, times(1)).retrieveIdeas(anyString());
	}
	
	@Test
	public void testingMocks4() {

		listService listServiceMock = mock(listService.class);
		List<String> allIdeas = Arrays.asList("Chicken soda", 
				"Leather gumshield", "Chicken flavored icecream");
		
		when(listServiceMock.retrieveIdeas(anyString())).thenReturn(allIdeas);

		businessClass businessClass = new businessClass(listServiceMock);
		
		businessClass.deleteIdeasNotRelatedToChicken("Piers");
		
		verify(listServiceMock, never()).deleteIdea("Chicken soda");
		verify(listServiceMock, never()).deleteIdea("Chicken flavored icecream");
		verify(listServiceMock, times(1)).deleteIdea("Leather gumshield");

	}

}

