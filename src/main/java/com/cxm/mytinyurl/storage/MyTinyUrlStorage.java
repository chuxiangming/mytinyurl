package com.cxm.mytinyurl.storage;

public interface MyTinyUrlStorage {

  void createTinyUrl(String fullUrl, String tinyUrl);

  String getTinyUrl(String fullUrl);

  String getFullUrl(String tinyUrl);
}
