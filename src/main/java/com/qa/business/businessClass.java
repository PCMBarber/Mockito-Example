package com.qa.business;

import java.util.ArrayList;
import java.util.List;

import com.qa.service.listService;

public class businessClass {
	
	private listService listService;

	public businessClass(listService listService) {
		this.listService = listService;
	}

	public List<String> retrieveChickenIdeas(String user) {
		List<String> filteredIdeas = new ArrayList<String>();
		List<String> allIdeas = listService.retrieveIdeas(user);
		for (String idea : allIdeas) {
			if (idea.contains("Chicken")) {
				filteredIdeas.add(idea);
			}
		}
		return filteredIdeas;
	}
	
	public void deleteIdeasNotRelatedToChicken(String user) {
		List<String> allIdeas = listService.retrieveIdeas(user);
		for (String idea : allIdeas) {
			if (!idea.contains("Chicken")) {
				listService.deleteIdea(idea);
			}
		}
	}
}
