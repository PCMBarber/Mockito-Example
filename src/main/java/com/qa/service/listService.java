package com.qa.service;

import java.util.List;

public interface listService {
	public List<String> retrieveIdeas(String user);
	
	void deleteIdea(String Idea);
}
