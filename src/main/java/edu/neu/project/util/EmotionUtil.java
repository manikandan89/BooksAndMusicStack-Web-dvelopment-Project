package edu.neu.project.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.belladati.httpclientandroidlib.HttpEntity;
import com.belladati.httpclientandroidlib.HttpResponse;
import com.belladati.httpclientandroidlib.client.ClientProtocolException;
import com.belladati.httpclientandroidlib.client.HttpClient;
import com.belladati.httpclientandroidlib.client.methods.HttpGet;
import com.belladati.httpclientandroidlib.client.utils.URIBuilder;
import com.belladati.httpclientandroidlib.impl.client.HttpClientBuilder;
import com.belladati.httpclientandroidlib.util.EntityUtils;
import com.wrapper.spotify.models.Track;

import edu.neu.project.model.SpotifyAuthentication;
import edu.neu.project.model.TrackEmotionModel;

public class EmotionUtil {

	public static String[] getMusicKeywordsForEmotion(String emotion) {
		
		if(emotion == null || emotion.length() == 0) {
			return null;
		}
		
			EmotionConstants emotionConstants = new EmotionConstants();
			HashMap<String,String> mapper = null;
			if (EmotionConstants.map != null) {
				mapper = EmotionConstants.map;
			} else {
				System.out.println("map is null");
			}
			String label = "music_" + emotion;
			for (String key : mapper.keySet()) {
				System.out.println("key::" + mapper.get(key));
			}
			
			if (mapper.get(label) != null) {
				String keyWordStr = mapper.get(label);
				if (keyWordStr != null && keyWordStr.length() > 0) {
					String[] keys = keyWordStr.split(",");
					return keys;
				}
			} else {
				System.out.println("index is null");
			}
	
		return null;
	}
	
	public static List<TrackEmotionModel> getUserIdsAndPlayListIds(String keyword) {
		
		HttpClient client = HttpClientBuilder.create().build();
	    URIBuilder url = new URIBuilder();
	    
	    String urlFirstPart = "https://api.spotify.com/v1/browse/categories/";
	    String urlSecondPart = "/playlists";
	    String completeUrl = urlFirstPart + keyword + urlSecondPart;
	    
	    URI buildurl;
	    String token = "";
	    
	    try {
	    	
	    	buildurl = url.build();
			HttpGet requset = new HttpGet(completeUrl);
			requset.setHeader("Accept","application/json");
			token = SpotifyAuthentication.getToken();
			String header = new String("Bearer " + token);
		    requset.setHeader("Authorization", header);
			   
		    HttpResponse response = client.execute(requset);
		   // System.out.println(response);
		    HttpEntity entity = response.getEntity();
		    
		    if (entity != null) {
		    	String retSrc = EntityUtils.toString(entity); 
		    	JSONParser parser=new JSONParser();
		           JSONObject obj = (JSONObject) parser.parse(retSrc);
		           JSONObject playlistJson = (JSONObject) obj.get("playlists");
		           //System.out.println(playlistJson.get("href"));
		           JSONArray items = (JSONArray) playlistJson.get("items");
		           List<TrackEmotionModel> models = null;
		           int startIndex = 0;
		           if (items != null && items.size() > 1) {
		        	   Random rand = new Random(); 
		        	   startIndex = rand.nextInt(items.size());
		           }
		           for (int i = startIndex; i < items.size(); i++) {
		        	   
		        	   JSONObject itemObj = (JSONObject) items.get(i);
		        	   System.out.println(itemObj.get("name"));
		        	   String playListId = (String) itemObj.get("id");
		        	   JSONObject ownerObj = (JSONObject) itemObj.get("owner");
		        	   String userId = (String) ownerObj.get("id");
		        	   if (playListId != null && userId != null) {
		        		  models =  getTracksForKeyword(userId,playListId);
		        	   }
		        	   if (models != null && models.size() > 0) {
		        		   break;
		        	   }
		        }
		           
		        return models;
		    }
		    
	    }catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 
	}

	private static List<TrackEmotionModel> getTracksForKeyword(String userId, String playListId) {
		HttpClient client = HttpClientBuilder.create().build();
	    URIBuilder url = new URIBuilder();
	    
	    String urlFirstPart = "https://api.spotify.com/v1/users/";
	    String urlSecondPart = "/playlists/";
	    String urlThirdPart = "/tracks";
	    String completeUrl = urlFirstPart + userId + urlSecondPart + playListId + urlThirdPart;
	    System.out.println("url:::" + completeUrl);
	    URI buildurl;
	    String token = "";
	    
	    System.out.println("userId::playlistId::" + userId + "::" + playListId);
	    
	    try {
	    	
	    	buildurl = url.build();
			HttpGet requset = new HttpGet(completeUrl);
			requset.setHeader("Accept","application/json");
			token = SpotifyAuthentication.getToken();
			String header = new String("Bearer " + token);
		    requset.setHeader("Authorization", header);
			   
		    HttpResponse response = client.execute(requset);
		    //System.out.println(response);
		    HttpEntity entity = response.getEntity();
		    
		    if (entity != null) {
		        String retSrc = EntityUtils.toString(entity); 
		        //System.out.println(retSrc);
		        JSONParser parser=new JSONParser();
	           JSONObject obj = (JSONObject) parser.parse(retSrc);
	           JSONArray items = (JSONArray) obj.get("items");
	           
	          List<TrackEmotionModel> modelList = new ArrayList<TrackEmotionModel>();
	          
	          int size = modelList.size();
	          int startIndex = 0;
	          
	          if (size > 7) {
	        	  Random rand = new Random(); 
	        	  startIndex = rand.nextInt(size - 7);
	          }
	          
	           for (int i = startIndex; i < items.size(); i++) {
	        	   if (i  > (startIndex+7)) {
	        		   break;
	        	   }
	        	   TrackEmotionModel model = new TrackEmotionModel();
	        	   JSONObject itemObj = (JSONObject) items.get(i);
	        	   JSONObject trackObj = (JSONObject) itemObj.get("track");
	        	   
	        	  model.setTrackId((String) trackObj.get("id"));
	        	  model.setPreviewUrl((String) trackObj.get("preview_url"));
	        	  model.setName((String) trackObj.get("name"));
	        	  
	        	  JSONObject albumObj = (JSONObject) trackObj.get("album");
	        	  
	        	  JSONArray imageArr = (JSONArray) albumObj.get("images"); 
	        	  if(imageArr != null && imageArr.size() > 1) {
	        		  JSONObject imageArrIndexObj = (JSONObject) imageArr.get(1);
		        	  model.setImage((String) imageArrIndexObj.get("url"));
	        	  }
	        	  
	        	  
	        	  modelList.add(model);
	           }
	           return modelList;
		    }
		    
		    
		    
	    }catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 
		
	}

	public static List<TrackEmotionModel> getTracksForMusicKeyWord(String keyword) {
		
		if(keyword != null && keyword.length() > 0) {
			
			List<TrackEmotionModel> categoryModels = getUserIdsAndPlayListIds(keyword);
			return categoryModels;
		}
		return null;
	}
	
	

}
