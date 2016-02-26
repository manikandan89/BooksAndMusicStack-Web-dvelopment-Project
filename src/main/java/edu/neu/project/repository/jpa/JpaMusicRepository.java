package edu.neu.project.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.neu.project.model.AlbumModel;
import edu.neu.project.model.AlbumRecommendation;
import edu.neu.project.model.FavouriteAlbum;
import edu.neu.project.model.TrackModel;
import edu.neu.project.model.TrackRecommendation;
import edu.neu.project.model.User;
import edu.neu.project.repository.MusicRepository;

@SuppressWarnings("unchecked")
@Repository
public class JpaMusicRepository implements MusicRepository {

	@PersistenceContext
	 private EntityManager em;

	@Override
	public void addAlbumRepository(AlbumModel album) {
		
		em.persist(album);
	
	}

	@Override
	public AlbumModel getAlbumByAlbumId(String albumId) {
		Query q = em.createNamedQuery("AlbumModel.findAlbumByAlbumId");
		q.setParameter("albumId", albumId);
		List<AlbumModel> albums = q.getResultList();
		if (albums == null) {
			return null;
		}
		
		return albums.get(0);
	}

	@Override
	public void insertFavouriteAlbum(FavouriteAlbum albumFavourite) {
		
		em.persist(albumFavourite);
	}

	@Override
	public void persistAlbumRecommendation(AlbumRecommendation recommendation) {
		
		em.persist(recommendation);
	}

	@Override
	public List<AlbumRecommendation> getRecommendationForUser(User user) {
		if (user == null) {
			return null;
		}
		
		Query q = em.createNamedQuery("AlbumRecommendation.findReceivedRecommendations");
		q.setParameter("userId", user.getUserId());
		List<AlbumRecommendation> receivedAlbumRecommendationList = q.getResultList();

		return receivedAlbumRecommendationList;
	}

}
