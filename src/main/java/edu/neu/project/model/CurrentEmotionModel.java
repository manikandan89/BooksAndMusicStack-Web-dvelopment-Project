package edu.neu.project.model;

public class CurrentEmotionModel {
	
	private static String currentEmotion;

	public static String getCurrentEmotion() {
		return currentEmotion;
	}

	public static void setCurrentEmotion(String currentEmotion) {
		CurrentEmotionModel.currentEmotion = currentEmotion;
	}

}
