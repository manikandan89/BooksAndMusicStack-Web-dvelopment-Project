package edu.neu.project.model;

public class SpotifyAuthentication {
	
	private static final String clientId = "<20f7c83db6d548a4aaadf057691661eb>";
	private static final String secretId = "<c5366c21e94a41fbb9b73bae365e5a38>";
	private static String token;
	private static long tokenTime;
	
	public static long getTokenTime() {
		return tokenTime;
	}

	public static void setTokenTime(long tokenTime) {
		SpotifyAuthentication.tokenTime = tokenTime;
	}

	public static String getToken() {
		return token;
	}

	public static void setToken(String token) {
		SpotifyAuthentication.token = token;
	}

	public static String getClientId() {
		return clientId;
	}
	
	public static String getSecretId() {
		return secretId;
	}
	
	

}
