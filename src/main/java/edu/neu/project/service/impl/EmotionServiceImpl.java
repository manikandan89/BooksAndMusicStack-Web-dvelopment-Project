package edu.neu.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wrapper.spotify.models.Track;

import edu.neu.project.model.TrackEmotionModel;
import edu.neu.project.service.util.EmotionService;
import edu.neu.project.util.EmotionUtil;

@Service
@Transactional
public class EmotionServiceImpl implements EmotionService {

	@Override
	public List<TrackEmotionModel> getTracksForEmotionService(String[] musicKeywords) {
		
		if(musicKeywords == null || musicKeywords.length == 0) {
			return null;
		}
		List<TrackEmotionModel> finalTracks = new ArrayList<TrackEmotionModel>();
		for (int i = 0; i < musicKeywords.length; i++) {
			System.out.println("Calling util for emotion::" + musicKeywords[i]);
			List<TrackEmotionModel> tracks = EmotionUtil.getTracksForMusicKeyWord(musicKeywords[i]);
			System.out.println("size of tracks for emotion ::" + musicKeywords[i] + "::" + tracks.size());
			for (TrackEmotionModel trackModel : tracks) {
				if (trackModel != null) {
					finalTracks.add(trackModel);
				}
			}
			
			
		}
		 return finalTracks;
	}
	
	

}
