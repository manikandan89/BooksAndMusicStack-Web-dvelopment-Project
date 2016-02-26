package edu.neu.project.util;

import java.util.HashMap;

public class EmotionConstants {
	
	public static HashMap<String,String> map;
	
	
	public EmotionConstants() {
		if (map == null) {
			map = new HashMap<String,String>();
			loadHashMapDetails();
		}
	}
	
	private void loadHashMapDetails() {
		System.out.println("Hashmap is loaded");
		
		map.put("music_fun", "party,comedy,rock");
		map.put("music_classical", "classical,decades,country");
		map.put("music_chill", "chill,travel,pop");
		map.put("music_love", "romance,mood");
		map.put("music_dance", "hiphop,edm_dance");
		map.put("music_tradition", "blues,folk_americana");
		
	}

	

}
