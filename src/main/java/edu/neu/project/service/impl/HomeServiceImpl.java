package edu.neu.project.service.impl;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.project.model.Book;
import edu.neu.project.model.Employee;
import edu.neu.project.service.util.*;
import edu.neu.project.exception.*;

@Service
@Transactional
public class HomeServiceImpl implements HomeService {

	/*@Override
	public Employee findEmployee() {
		// TODO Auto-generated method stub
		Employee person = new Employee();
		person.setId(1);
		person.setFirstName("Christiano");
		person.setLastName("Ronaldo");
		return person;
	}

	@Override
	public List<Book> findBooksForEmotionService(String emotion) throws EmotionNotFoundException {
		
		String url = "https://cxxxxxxx.web.cddbp.net/webapi/json/1.0/radio/create?mood=65323&client=12350720-B385E691FE0070542F09D07480D62CFA&user=280724043670296033-A27A26963F5BC27EA44E46E08D72D6BA";
    	try {
			List<Book> books = new ArrayList();
    		URL urlModel = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) urlModel.openConnection();
			connection.setRequestMethod("GET");
			InputStreamReader isr = new InputStreamReader(connection.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			String inputLine;
			StringBuffer buffer = new StringBuffer();
			while((inputLine = br.readLine()) != null) {
				buffer.append(inputLine);
			}
			br.close();
			JSONParser parser = new JSONParser();
			JSONObject objArr = (JSONObject) parser.parse(buffer.toString());
			JSONArray responseEleArr = (JSONArray) objArr.get("RESPONSE");
			JSONObject responseObj = (JSONObject) responseEleArr.get(0);
			JSONArray albumEleArr = (JSONArray) responseObj.get("ALBUM");
			for (int i = 0 ; i < albumEleArr.size(); i++) {
				Book book = new Book();
				JSONObject albumObj = (JSONObject) albumEleArr.get(i);
				JSONArray titleEleArr = (JSONArray) albumObj.get("TITLE");
				JSONObject titleObj = (JSONObject) titleEleArr.get(0);
				String title = titleObj.get("VALUE").toString();
				book.setTitle(title);
				books.add(book);
			}
			return books;
    	}catch (Exception e) {
    		e.printStackTrace();
    		throw new EmotionNotFoundException(emotion);
    	}
		
		
	}*/
	
	

	
}
