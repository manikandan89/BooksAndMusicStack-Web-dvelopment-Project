package edu.neu.project.model;

import java.util.HashSet;
import java.util.Set;

public class FriendMapperModelSet {
	
	private Set<FriendMapperModel> models = new HashSet<FriendMapperModel>();

	public Set<FriendMapperModel> getModels() {
		return models;
	}

	public void setModels(Set<FriendMapperModel> models) {
		this.models = models;
	}

}
