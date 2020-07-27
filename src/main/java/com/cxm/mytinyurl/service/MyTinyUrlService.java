package com.cxm.mytinyurl.service;

import com.cxm.mytinyurl.storage.MyTinyUrlStorage;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyTinyUrlService {

  private final MyTinyUrlStorage myTinyUrlStorage;

  public String createOrGetTinyUrl(String fullUrl) {
    return Optional.ofNullable(myTinyUrlStorage.getTinyUrl(fullUrl)).orElseGet(() -> {
      String tinyUrl = generateTinyUrl();
      myTinyUrlStorage.createTinyUrl(fullUrl, tinyUrl);
      return tinyUrl;
    });
  }

  public String getFullUrl(String tinyUrl) {
    return myTinyUrlStorage.getFullUrl(tinyUrl);
  }

  private static String generateTinyUrl() {
    return UUID.randomUUID().toString().substring(0, 7);
  }
}
