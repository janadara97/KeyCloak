package com.vizuamatix.keycloak.payload;

import java.util.List;

public class ApiResponse {
  private boolean status;
  private String message;
  private List<?> list;

  public ApiResponse(boolean status, String message) {
    this.status = status;
    this.message = message;
  }

  public ApiResponse(boolean status, String message, List<?> list) {
    this.status = status;
    this.message = message;
    this.list = list;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public List<?> getList() {
    return list;
  }

  public void setList(List<?> list) {
    this.list = list;
  }

}
