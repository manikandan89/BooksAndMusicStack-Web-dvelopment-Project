package edu.neu.project.model;

import java.util.ArrayList;
import java.util.List;

import edu.neu.project.model.BooksRecommendedModel;

public class BookRecommendationModelList {
	
	private List<BooksRecommendedModel> recommendedList = new ArrayList<BooksRecommendedModel>();
	private List<BooksRecommendedModel> similarList = new ArrayList<BooksRecommendedModel>();
	
	public List<BooksRecommendedModel> getRecommendedList() {
		return recommendedList;
	}
	public void setRecommendedList(List<BooksRecommendedModel> recommendedList) {
		this.recommendedList = recommendedList;
	}
	public List<BooksRecommendedModel> getSimilarList() {
		return similarList;
	}
	public void setSimilarList(List<BooksRecommendedModel> similarList) {
		this.similarList = similarList;
	}

}
