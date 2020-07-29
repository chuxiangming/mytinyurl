package com.cxm.mytinyurl.service;

import com.cxm.mytinyurl.storage.MyTinyUrlStorage;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyTinyUrlService {

  private final MyTinyUrlStorage myTinyUrlStorage;
  private final TinyUrlGenerator tinyUrlGenerator;

  public String createOrGetTinyUrl(String fullUrl) {
    return Optional.ofNullable(myTinyUrlStorage.getTinyUrl(fullUrl))
        .orElseGet(
            () -> {
              for (int attempt = 1; attempt <= 3; attempt++) {
                try {
                  String tinyUrl = tinyUrlGenerator.generate();
                  myTinyUrlStorage.createTinyUrl(fullUrl, tinyUrl);
                  return tinyUrl;
                } catch (Exception e) {
                  System.out.println("Failed to create tiny url for attempt=" + attempt);
                }
              }
              throw new RuntimeException("Failed to create tiny url, please try later.");
            });
  }

  public String getFullUrl(String tinyUrl) {
    return myTinyUrlStorage.getFullUrl(tinyUrl);
  }
}
