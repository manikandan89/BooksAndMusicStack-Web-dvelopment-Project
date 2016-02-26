package edu.neu.project.model;

public class FriendMapperModel {
	
	private int mapId;
	private String requestName;
	private String recepientName;
	private int requestId;
	private int recepientId;
	private boolean state;
	public int getMapId() {
		return mapId;
	}
	public void setMapId(int mapId) {
		this.mapId = mapId;
	}
	public String getRequestName() {
		return requestName;
	}
	public void setRequestName(String requestName) {
		this.requestName = requestName;
	}
	public String getRecepientName() {
		return recepientName;
	}
	public void setRecepientName(String recepientName) {
		this.recepientName = recepientName;
	}
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public int getRecepientId() {
		return recepientId;
	}
	public void setRecepientId(int recepientId) {
		this.recepientId = recepientId;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	
	
	

}
