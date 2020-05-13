package com.qa.service;

import java.util.Arrays;
import java.util.List;

public class IdeasServiceStub implements listService {

	public List<String> retrieveIdeas(String user) {
		return Arrays.asList("Chicken soda", "Leather gumshield", "Chicken flavored icecream");
	}

}
