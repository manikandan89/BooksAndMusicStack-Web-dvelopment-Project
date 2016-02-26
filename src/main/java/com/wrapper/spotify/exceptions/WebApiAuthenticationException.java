package com.wrapper.spotify.exceptions;

@SuppressWarnings("serial")
public class WebApiAuthenticationException extends WebApiException {

  public WebApiAuthenticationException(String message) {
    super(message);
  }
}
