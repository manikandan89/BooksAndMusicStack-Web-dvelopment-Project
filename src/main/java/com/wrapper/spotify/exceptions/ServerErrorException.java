package com.wrapper.spotify.exceptions;

@SuppressWarnings("serial")
public class ServerErrorException extends WebApiException {

  public ServerErrorException(String message) {
    super(message);
  }
}
