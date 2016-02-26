package com.wrapper.spotify.exceptions;

@SuppressWarnings("serial")
public class WebApiException extends Exception {

  public WebApiException(String message) {
    super(message);
  }

  public WebApiException() {
    super();
  }

}
