package com.wrapper.spotify.exceptions;

@SuppressWarnings("serial")
public class BadRequestException extends WebApiException {

  public BadRequestException(String message) {
    super(message);
  }

}
