package edu.neu.project.service.util;

import java.util.List;

import com.wrapper.spotify.models.Track;

import edu.neu.project.model.TrackEmotionModel;

public interface EmotionService {

	List<TrackEmotionModel> getTracksForEmotionService(String[] musicKeywords);

}
