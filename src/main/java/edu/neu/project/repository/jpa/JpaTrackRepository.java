package edu.neu.project.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.neu.project.model.FavouriteTrack;
import edu.neu.project.model.TrackModel;
import edu.neu.project.model.TrackRecommendation;
import edu.neu.project.model.User;
import edu.neu.project.repository.TrackRepository;

@SuppressWarnings("unchecked")
@Repository
public class JpaTrackRepository implements TrackRepository {
	
	@PersistenceContext
	 private EntityManager em;
	
	@Override
	public void addTrackRepository(TrackModel track) {
		
		em.persist(track);
	}

	@Override
	public TrackModel getTrackByTrackId(String trackId) {
		
		Query q = em.createNamedQuery("TrackModel.findTrackByTrackId");
		q.setParameter("trackId", trackId);
		List<TrackModel> tracks = q.getResultList();
		if (tracks == null) {
			return null;
		}
		
		return tracks.get(0);
	}

	@Override
	public void insertFavouriteTrack(FavouriteTrack trackFavourite) {
		
		em.persist(trackFavourite);
	}


	@Override
	public List<String> getTrackIdsForIds(List<Integer> idList) {
		
		if (idList == null) {
			return null;
		}
		
		Query q = em.createNamedQuery("TrackModel.findTracksForMultipleTrackIds");
		q.setParameter("id", idList);
		List<String> tracks = q.getResultList();

		return tracks;
	}

	@Override
	public void persistTrackRecommendation(TrackRecommendation recommendation) {
		
		em.persist(recommendation);
	}

	@Override
	public List<TrackRecommendation> getRecommendationForUser(User user) {
		
		if (user == null) {
			return null;
		}
		
		Query q = em.createNamedQuery("TrackRecommendation.findReceivedRecommendations");
		q.setParameter("userId", user.getUserId());
		List<TrackRecommendation> receivedTrackRecommendationList = q.getResultList();

		return receivedTrackRecommendationList;
	}

	
}
