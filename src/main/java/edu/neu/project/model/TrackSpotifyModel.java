package edu.neu.project.model;

public class TrackSpotifyModel {
	
	private String trackId;
	private String name;
	private String previewUrl;
	private AlbumSpotifyModel album;
	
	
	public AlbumSpotifyModel getAlbum() {
		return album;
	}
	public void setAlbum(AlbumSpotifyModel album) {
		this.album = album;
	}
	public String getTrackId() {
		return trackId;
	}
	public void setTrackId(String trackId) {
		this.trackId = trackId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPreviewUrl() {
		return previewUrl;
	}
	public void setPreviewUrl(String previewUrl) {
		this.previewUrl = previewUrl;
	}

}
