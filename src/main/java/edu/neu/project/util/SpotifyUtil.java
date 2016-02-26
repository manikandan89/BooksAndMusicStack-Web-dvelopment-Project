package edu.neu.project.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Base64;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
//import java.util.Base64.Encoder;





import java.util.Random;

import org.apache.commons.codec.Encoder;
import org.apache.commons.codec.binary.Base64;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
//import org.springframework.security.crypto.codec.Base64;






















import com.belladati.httpclientandroidlib.HttpEntity;
import com.belladati.httpclientandroidlib.HttpResponse;
import com.belladati.httpclientandroidlib.client.ClientProtocolException;
import com.belladati.httpclientandroidlib.client.HttpClient;
import com.belladati.httpclientandroidlib.client.methods.HttpGet;
import com.belladati.httpclientandroidlib.client.methods.HttpPost;
import com.belladati.httpclientandroidlib.client.utils.URIBuilder;
import com.belladati.httpclientandroidlib.impl.client.HttpClientBuilder;
import com.belladati.httpclientandroidlib.protocol.HTTP;
import com.belladati.httpclientandroidlib.util.EntityUtils;
import com.wrapper.spotify.Api;
import com.wrapper.spotify.methods.AlbumRequest;
import com.wrapper.spotify.models.Album;
import com.wrapper.spotify.models.Image;

import edu.neu.project.model.AlbumSpotifyModel;
import edu.neu.project.model.SpotifyAuthentication;
import edu.neu.project.model.TrackEmotionModel;
import edu.neu.project.model.TrackSpotifyModel;

public class SpotifyUtil {
	
	static Api api = Api.builder()
			  .clientId(SpotifyAuthentication.getClientId())
			  .clientSecret(SpotifyAuthentication.getSecretId())
			  .redirectURI("<your_redirect_uri>")
			  .build();

	public static SpotifyAuthentication getSpotifyAccessToken() {

		HttpClient client = HttpClientBuilder.create().build();
		URIBuilder url = new URIBuilder();
		url.setScheme("https").setHost("accounts.spotify.com")
				.setPath("/api/token")
				.addParameter("grant_type", "client_credentials");

		URI buildurl;
		String token = "";
		try {
			buildurl = url.build();
			HttpPost requset = new HttpPost(buildurl);
			requset.setHeader(HTTP.CONTENT_TYPE,
					"application/x-www-form-urlencoded");
			String header = new String("20f7c83db6d548a4aaadf057691661eb" + ":"
					+ "c5366c21e94a41fbb9b73bae365e5a38");
			//Encoder encoder = Base64.getEncoder();
			/*byte[] byteArr = Base64.encode(header.getBytes());
			String headerString = byteArr.toString();*/
			 byte[] encoded = Base64.encodeBase64(header.getBytes());  
			 String headerString = new String(encoded);
			//String headerString = encoder.encodeToString(header.getBytes());
			requset.setHeader("Authorization", "Basic " + headerString);
			SpotifyAuthentication auth = new SpotifyAuthentication();
			HttpResponse response = client.execute(requset);
			System.out.println(response);
			HttpEntity entity = response.getEntity();

			if (entity != null) {
				String retSrc = EntityUtils.toString(entity);
				// parsing JSON
				JSONParser parser = new JSONParser();
				JSONObject obj = (JSONObject) parser.parse(retSrc);
				System.out.println(obj.get("access_token"));
				token = (String) obj.get("access_token");
				if (token != null && !token.equals("")) {
					Calendar cal = Calendar.getInstance();
					cal.getTime();
					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
					System.out.println(sdf.format(cal.getTime()));
					long currentTime = System.currentTimeMillis();
					System.out.println("checkkkk");
					/*FileOutputStream out = new FileOutputStream(
							"src\\config.properties");
					FileInputStream in = new FileInputStream(
							"src\\config.properties");
					Properties props = new Properties();
					props.load(in);
					in.close();
					props.setProperty("time", String.valueOf(currentTime));
					props.setProperty("token", token);
					props.store(out, null);
					out.close();*/
					SpotifyAuthentication.setToken(token);
					SpotifyAuthentication.setTokenTime(System.currentTimeMillis());
					return auth;
				} else {
					System.out.println("Spotify access token is null");
				}

			}
		} catch (URISyntaxException e) {
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

	private static long retrieveTimerFromPropFile() {

		try {

			long timerFromConfigLong = 0;
			FileInputStream in = new FileInputStream("src\\config.properties");
			Properties props = new Properties();
			props.load(in);
			String timerFromConfigString = props.getProperty("time");
			in.close();
			if (timerFromConfigString != null
					&& !timerFromConfigString.equals("0")) {
				timerFromConfigLong = Long.parseLong(timerFromConfigString);
			}
			return timerFromConfigLong;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static boolean isAccessTokenCallNecessary(SpotifyAuthentication auth) {

		long configTimer = SpotifyAuthentication.getTokenTime();

		long currentTime = System.currentTimeMillis();

		if (configTimer != 0 && (currentTime - configTimer) < 3600000) {
			return false;
		}
		return true;
	}
	
	public static String retrieveTokenFromPropFile() {

		System.out.println("retrieveTokenFromPropFile");
		try {

			String tokenFromConfigString = "";
			FileInputStream in = new FileInputStream("config.properties");
			Properties props = new Properties();
			props.load(in);
			tokenFromConfigString = props.getProperty("token");
			in.close();
			return tokenFromConfigString;

		} catch (IOException e) {
			System.err.println("METHOD ONE FAILED");
			// e.printStackTrace();
		}

		try {

			String tokenFromConfigString = "";
			FileInputStream in = new FileInputStream("src\\config.properties");
			Properties props = new Properties();
			props.load(in);
			tokenFromConfigString = props.getProperty("token");
			in.close();
			return tokenFromConfigString;

		} catch (IOException e) {
			System.err.println("METHOD TWO FAILED");
			// e.printStackTrace();
		}

		try {

			String tokenFromConfigString = "";
			FileInputStream in = new FileInputStream("\\src\\config.properties");
			Properties props = new Properties();
			props.load(in);
			tokenFromConfigString = props.getProperty("token");
			in.close();
			return tokenFromConfigString;

		} catch (IOException e) {
			System.err.println("METHOD THREE FAILED");
			// e.printStackTrace();
		}
		return null;
	}
	
	public static List<AlbumSpotifyModel> getLatestAlbums() {
		
		HttpClient client = HttpClientBuilder.create().build();

	    String completeUrl = "https://api.spotify.com/v1/browse/new-releases/";
	    
	    String token = "";
	    
	    try {
	    	
			HttpGet requset = new HttpGet(completeUrl);
			requset.setHeader("Accept","application/json");
			System.out.println("token::::" + SpotifyAuthentication.getToken());
			String header = new String("Bearer BQCIfBQDpoSlZBcpYEzLNetMsqxCEMst2kQGPzrIEfxu-uXyFBSs_N0ZBcAiObmqVFzIzhCnoAPzLaUj3VZOiQ");
		    //requset.setHeader("Authorization", "Bearer BQD-H2xb2m7N6jsndcUgtC9ahgjEJetrVtR_HZ7GBrSjqmF9FkFIlF5T6PYY0NHEZkeY7hI1URr7aOz3Rlx-Xw");
			  requset.setHeader("Authorization", "Bearer " + SpotifyAuthentication.getToken()); 
		    HttpResponse response = client.execute(requset);
		   // System.out.println(response);
		    HttpEntity entity = response.getEntity();
		    
		    if (entity != null) {
		    	String retSrc = EntityUtils.toString(entity); 
		    	JSONParser parser=new JSONParser();
		           JSONObject obj = (JSONObject) parser.parse(retSrc);
		           JSONObject albumJson = (JSONObject) obj.get("albums");
		           System.out.println(albumJson.get("href"));
		           JSONArray items = (JSONArray) albumJson.get("items");
		           List<AlbumSpotifyModel> models = new ArrayList<AlbumSpotifyModel>();
		        
		           	if(items != null && items.size() > 0) {
		           		
		           		for (int i = 0; i < items.size(); i++) {
			        	   
			        	   JSONObject itemObj = (JSONObject) items.get(i);
			        	   System.out.println(itemObj.get("id"));
			        	   AlbumSpotifyModel model = new AlbumSpotifyModel();
			        	   model.setAlbumId((String) itemObj.get("id"));
			        	   model.setAlbumName((String) itemObj.get("name"));
			        	   JSONArray imageArr = (JSONArray) itemObj.get("images"); 
			        	  if(imageArr != null && imageArr.size() > 1) {
			        		  JSONObject imageArrIndexObj = (JSONObject) imageArr.get(1);
				        	  model.setImage((String) imageArrIndexObj.get("url"));
			        	  }
			        	  models.add(model);
		           	 	}
		           	}
		        return models;
		    }
		    
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

	public static List<TrackSpotifyModel> getTracksForAlbum(AlbumSpotifyModel album, String albumId) {
		
		if(album != null && album.getAlbumId() != null && albumId.equalsIgnoreCase(album.getAlbumId())) {
			System.out.println("AlbumIds match while retieving tracks");
		} else {
			System.out.println("AlbumIds DO NOT match while retieving tracks");
		}
		
		HttpClient client = HttpClientBuilder.create().build();

		String firstPart = 	"https://api.spotify.com/v1/albums/";
		String secondPart = "/tracks";
	    String completeUrl = firstPart + albumId + secondPart;
	    
	    String token = "";
	    
	    try {
	    	
			HttpGet requset = new HttpGet(completeUrl);
			requset.setHeader("Accept","application/json");
			//System.out.println("token::::" + SpotifyAuthentication.getToken());
			//String header = new String("Bearer BQCIfBQDpoSlZBcpYEzLNetMsqxCEMst2kQGPzrIEfxu-uXyFBSs_N0ZBcAiObmqVFzIzhCnoAPzLaUj3VZOiQ");
		    //requset.setHeader("Authorization", "Bearer BQD-H2xb2m7N6jsndcUgtC9ahgjEJetrVtR_HZ7GBrSjqmF9FkFIlF5T6PYY0NHEZkeY7hI1URr7aOz3Rlx-Xw");
			 // requset.setHeader("Authorization", "Bearer " + SpotifyAuthentication.getToken()); 
		    HttpResponse response = client.execute(requset);
		   // System.out.println(response);
		    HttpEntity entity = response.getEntity();
		    
		    if (entity != null) {
		    	String retSrc = EntityUtils.toString(entity); 
		    	JSONParser parser=new JSONParser();
		           JSONObject obj = (JSONObject) parser.parse(retSrc);
		           
		           System.out.println(obj.get("href"));
		           JSONArray items = (JSONArray) obj.get("items");
		           List<TrackSpotifyModel> models = new ArrayList<TrackSpotifyModel>();
		        
		           	if(items != null && items.size() > 0) {
		           		
		           		for (int i = 0; i < items.size(); i++) {
			        	   
			        	   JSONObject itemObj = (JSONObject) items.get(i);
			        	   System.out.println(itemObj.get("id"));
			        	   TrackSpotifyModel model = new TrackSpotifyModel();
			        	   model.setName((String) itemObj.get("name"));
			        	   model.setPreviewUrl((String) itemObj.get("preview_url"));
			        	   model.setTrackId((String) itemObj.get("id"));
			        	   model.setAlbum(album);
			        	   models.add(model);
			        	  }
			        	  
		           	 	}
		            return models;
		          	}
		       
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

	public static AlbumSpotifyModel getAlbumForAlbumId(String albumId) {
		
		HttpClient client = HttpClientBuilder.create().build();
		
		String firstPart = "https://api.spotify.com/v1/albums/";

	    String completeUrl = firstPart + albumId;
	    
	    String token = "";
	    
	    try {
	    	
			HttpGet requset = new HttpGet(completeUrl);
			requset.setHeader("Accept","application/json");
			//System.out.println("token::::" + SpotifyAuthentication.getToken());
			String header = new String("Bearer BQCIfBQDpoSlZBcpYEzLNetMsqxCEMst2kQGPzrIEfxu-uXyFBSs_N0ZBcAiObmqVFzIzhCnoAPzLaUj3VZOiQ");
		    //requset.setHeader("Authorization", "Bearer BQD-H2xb2m7N6jsndcUgtC9ahgjEJetrVtR_HZ7GBrSjqmF9FkFIlF5T6PYY0NHEZkeY7hI1URr7aOz3Rlx-Xw");
			  //requset.setHeader("Authorization", "Bearer " + SpotifyAuthentication.getToken()); 
		    HttpResponse response = client.execute(requset);
		   // System.out.println(response);
		    HttpEntity entity = response.getEntity();
		    
		    if (entity != null) {
		    	String retSrc = EntityUtils.toString(entity); 
		    		JSONParser parser=new JSONParser();
		           JSONObject obj = (JSONObject) parser.parse(retSrc);
		           
		           AlbumSpotifyModel model = new AlbumSpotifyModel();
		           model.setAlbumName((String) obj.get("name"));
		           model.setAlbumId((String) obj.get("id"));
		           JSONArray imageArr = (JSONArray) obj.get("images"); 
		        	  if(imageArr != null && imageArr.size() > 1) {
		        		  JSONObject imageArrIndexObj = (JSONObject) imageArr.get(1);
			        	  model.setImage((String) imageArrIndexObj.get("url"));
		        	  }
		        	  
		           JSONArray artistArr = (JSONArray) obj.get("artists"); 
		           if(artistArr != null && artistArr.size() > 0) {
		        		  JSONObject artistArrIndexObj = (JSONObject) artistArr.get(0);
			        	  model.setArtist((String) artistArrIndexObj.get("name"));
		        	  }
		        	  
		        return model;
		    }
		    
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

	public static List<AlbumSpotifyModel> findAlbumsForSearch(String album) {
		
		HttpClient client = HttpClientBuilder.create().build();
		String query = "";
		String[] splitAlbum = album.split(" ");
		
		for (int i = 0; i < splitAlbum.length; i++) {
			if (i > 0) {
				query = query + "%20";
			}
			query = query + album;
		}
		
		String firstPart = "https://api.spotify.com/v1/search?q=";
		String secondPart = "&type=album";
		
		String completeUrl = firstPart + query + secondPart;
		completeUrl = completeUrl.replaceAll(" ", "%20");
	    
	    String token = "";
	    
	    try {
	    	
			HttpGet requset = new HttpGet(completeUrl);
			requset.setHeader("Accept","application/json");
			//System.out.println("token::::" + SpotifyAuthentication.getToken());
			String header = new String("Bearer BQCIfBQDpoSlZBcpYEzLNetMsqxCEMst2kQGPzrIEfxu-uXyFBSs_N0ZBcAiObmqVFzIzhCnoAPzLaUj3VZOiQ");
		    //requset.setHeader("Authorization", "Bearer BQD-H2xb2m7N6jsndcUgtC9ahgjEJetrVtR_HZ7GBrSjqmF9FkFIlF5T6PYY0NHEZkeY7hI1URr7aOz3Rlx-Xw");
			  //requset.setHeader("Authorization", "Bearer " + SpotifyAuthentication.getToken()); 
		    HttpResponse response = client.execute(requset);
		   // System.out.println(response);
		    HttpEntity entity = response.getEntity();
		    
		    if (entity != null) {
		    	String retSrc = EntityUtils.toString(entity); 
		    	JSONParser parser=new JSONParser();
		           JSONObject obj = (JSONObject) parser.parse(retSrc);
		           JSONObject albumJson = (JSONObject) obj.get("albums");
		           System.out.println(albumJson.get("href"));
		           JSONArray items = (JSONArray) albumJson.get("items");
		           List<AlbumSpotifyModel> models = new ArrayList<AlbumSpotifyModel>();
		        
		           	if(items != null && items.size() > 0) {
		           		
		           		for (int i = 0; i < items.size(); i++) {
			        	   
			        	   JSONObject itemObj = (JSONObject) items.get(i);
			        	   System.out.println(itemObj.get("id"));
			        	   AlbumSpotifyModel model = new AlbumSpotifyModel();
			        	   model.setAlbumId((String) itemObj.get("id"));
			        	   model.setAlbumName((String) itemObj.get("name"));
			        	   JSONArray imageArr = (JSONArray) itemObj.get("images"); 
			        	  if(imageArr != null && imageArr.size() > 1) {
			        		  JSONObject imageArrIndexObj = (JSONObject) imageArr.get(1);
				        	  model.setImage((String) imageArrIndexObj.get("url"));
			        	  }
			        	  models.add(model);
		           	 	}
		           	}
		        return models;
		    }
		    
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

	public static TrackSpotifyModel findTrackById(String trackId) {
	
		if (trackId == null) {
			return null;
		}
		
		HttpClient client = HttpClientBuilder.create().build();

		String firstPart = 	"https://api.spotify.com/v1/tracks/";
	    String completeUrl = firstPart + trackId ;
	    
	    String token = "";
	    
	    try {
	    	
			HttpGet requset = new HttpGet(completeUrl);
			requset.setHeader("Accept","application/json");
			//System.out.println("token::::" + SpotifyAuthentication.getToken());
			//String header = new String("Bearer BQCIfBQDpoSlZBcpYEzLNetMsqxCEMst2kQGPzrIEfxu-uXyFBSs_N0ZBcAiObmqVFzIzhCnoAPzLaUj3VZOiQ");
		    //requset.setHeader("Authorization", "Bearer BQD-H2xb2m7N6jsndcUgtC9ahgjEJetrVtR_HZ7GBrSjqmF9FkFIlF5T6PYY0NHEZkeY7hI1URr7aOz3Rlx-Xw");
			 // requset.setHeader("Authorization", "Bearer " + SpotifyAuthentication.getToken()); 
		    HttpResponse response = client.execute(requset);
		   // System.out.println(response);
		    HttpEntity entity = response.getEntity();
		    
		    if (entity != null) {
		    	String retSrc = EntityUtils.toString(entity); 
		    	JSONParser parser=new JSONParser();
		           JSONObject obj = (JSONObject) parser.parse(retSrc);
		           JSONObject albumObj = (JSONObject) obj.get("album");
		           AlbumSpotifyModel albumModel = new AlbumSpotifyModel();
		           
		           albumModel.setAlbumId((String) albumObj.get("id"));
		           albumModel.setAlbumName((String) albumObj.get("name"));
		           
		           JSONArray imageArr = (JSONArray) albumObj.get("images"); 
		        	  if(imageArr != null && imageArr.size() > 1) {
		        		  JSONObject imageArrIndexObj = (JSONObject) imageArr.get(1);
		        		  albumModel.setImage((String) imageArrIndexObj.get("url"));
		        	  }
		           
		           System.out.println(albumObj.get("name"));
		           
		           JSONArray artistArr = (JSONArray) obj.get("artists");
		           if (artistArr != null && artistArr.size() > 0) {
		        	   JSONObject artistObj = (JSONObject) artistArr.get(0);
		        	   if (artistObj != null) {
		        		   albumModel.setArtist((String) artistObj.get("name"));
		        	   }
		           }
		           
		           TrackSpotifyModel trackModel = new TrackSpotifyModel();
		           
		           trackModel.setName((String) obj.get("name"));
		           trackModel.setTrackId((String) obj.get("id"));
		           trackModel.setPreviewUrl((String) obj.get("preview_url"));
		           trackModel.setAlbum(albumModel);
		           
		          return trackModel;
		        
		    }
		       
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

}
