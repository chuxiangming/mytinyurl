package com.cxm.mytinyurl.storage;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class MyTinyUrlStorage {
  private final Map<String, String> fullToTiny = new HashMap<>();
  private final Map<String, String> tinyToFull = new HashMap<>();

  public void createTinyUrl(String fullUrl, String tinyUrl) {
    checkArgument(!fullToTiny.containsKey(fullUrl) && !tinyToFull.containsKey(tinyUrl));
    fullToTiny.put(fullUrl, tinyUrl);
    tinyToFull.put(tinyUrl, fullUrl);
  }

  public String getTinyUrl(String fullUrl) {
    return fullToTiny.get(fullUrl);
  }

  public String getFullUrl(String tinyUrl) {
    return tinyToFull.get(tinyUrl);
  }
}
