package com.wrapper.spotify.methods;

import com.google.common.base.Joiner;
import com.google.common.util.concurrent.SettableFuture;

import net.sf.json.JSONObject;

import com.wrapper.spotify.JsonUtil;
import com.wrapper.spotify.exceptions.*;
import com.wrapper.spotify.models.AlbumType;
import com.wrapper.spotify.models.Page;
import com.wrapper.spotify.models.SimpleAlbum;
import com.wrapper.spotify.models.SimpleTrack;

import java.io.IOException;

public class TracksForAlbumRequest extends AbstractRequest {

	 public TracksForAlbumRequest(Builder builder) {
		    super(builder);
	 }
	 
	  public SettableFuture<Page<SimpleTrack>> getAsync() {
		    SettableFuture<Page<SimpleTrack>> searchResultFuture = SettableFuture.create();

		    try {
		      final String jsonString = getJson();
		      final JSONObject jsonObject = JSONObject.fromObject(jsonString);

		      searchResultFuture.set(JsonUtil.createSimpleTrackPage(jsonObject));
		    } catch (Exception e) {
		      searchResultFuture.setException(e);
		    }

		    return searchResultFuture;
		  }
	  
	  public Page<SimpleTrack> get() throws IOException, WebApiException {
		    final String jsonString = getJson();
		    final JSONObject jsonObject = JSONObject.fromObject(jsonString);

		    return JsonUtil.createSimpleTrackPage(jsonObject);
		  }

		  public static Builder builder() {
		    return new Builder();
		  }
		  
		  public static final class Builder extends AbstractRequest.Builder<Builder> {

			    public Builder forAlbum(String id) {
			      assert (id != null);
			      return path(String.format("/v1/albums/%s/tracks", id));
			    }
			    
			    public Builder market(String market) {
				      assert (market != null);
				      return parameter("market", market);
				    }

				    public Builder limit(int limit) {
				      assert (limit > 0);
				      return parameter("limit", String.valueOf(limit));
				    }

				    public Builder offset(int offset) {
				      assert (offset >= 0);
				      return parameter("offset", String.valueOf(offset));
				    }

				    public TracksForAlbumRequest build() {
				      return new TracksForAlbumRequest(this);
				    }
		  }
		  
		
}

