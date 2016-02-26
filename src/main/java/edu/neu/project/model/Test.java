package edu.neu.project.model;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Test {

	public static void main(String[] args) {
		 // JAXBContext jaxbContext;
		//try {
			/*jaxbContext = JAXBContext.newInstance(BookMap.class);
			System.out.println("Check");
			  Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			    BookMap empMap = (BookMap) jaxbUnmarshaller.unmarshal( new File("c:/temp/book.xml") );
			    
			    for(Integer empId : empMap.getBookMap().keySet())
			    {
			    	System.out.println("nside for");
			        System.out.println(empMap.getBookMap().get(empId).getId());
			        System.out.println(empMap.getBookMap().get(empId).getAverage_rating());
			    }*/
			/*File file = new File("c:/temp/book.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(BookMap.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			BookMap museums = (BookMap) jaxbUnmarshaller.unmarshal(file);
			Book book = museums.getSearch().getResults().getBooks().get(7);
			System.out.println(book.getAverage_rating());*/
			
			/*File file = new File("c:/temp/reviews.xml");
			
			JAXBContext jaxbContext = JAXBContext.newInstance(BookMap.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			BookMap museums = (BookMap) jaxbUnmarshaller.unmarshal(file);
			Book book = museums.getSearch().getResults().getBooks().get(0);
			System.out.println(book.getBestBook().getTitle());*/
			
			
			/*JAXBContext jaxbContext = JAXBContext.newInstance(BookMap.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			BookMap museums = (BookMap) jaxbUnmarshaller.unmarshal(file);
			BookReview book = museums.getBook();
			System.out.println(book.getDescription());*/
		/*} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		String key = "Eric Harr$Triathlon Training in Four Hours a Week: From Beginner to Finish Line in Just Six Weeks";
		
		String author = "";
		String title = "";
		String[] keywords = key.split("$");
		
		if(keywords != null && keywords.length == 2) {
			
			author = keywords[0];
			title = keywords[1];
			System.out.println("author::title::" + author + "::" + title);
		} else {
			System.out.println("Something wrong with book keyword");
			if(keywords != null) {
				System.out.println(keywords[0]);
				System.out.println("keywordLength::" + keywords.length);
			}
		}
		  

	}

}
