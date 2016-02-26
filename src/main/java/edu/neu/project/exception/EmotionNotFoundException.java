package edu.neu.project.exception;

@SuppressWarnings("serial")
public class EmotionNotFoundException extends RuntimeException {
	
	private String emotion;
	
	public EmotionNotFoundException(String emotion) {
	this.emotion = emotion;
	}
	
	public String getEmotion() {
	return emotion;
	}

}
