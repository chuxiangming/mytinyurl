package com.cxm.mytinyurl.storage;

import com.cxm.mytinyurl.dao.domain.DbTinyUrl;
import com.cxm.mytinyurl.dao.mapper.TinyUrlMapper;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MyTinyUrlDbStorage extends MyTinyUrlStorage {

  private final TinyUrlMapper tinyUrlMapper;

  public void createTinyUrl(String fullUrl, String tinyUrl) {
    tinyUrlMapper.insert(tinyUrl, fullUrl);
  }

  public String getTinyUrl(String fullUrl) {
    return Optional.ofNullable(tinyUrlMapper.findByFullUrl(fullUrl)).map(list -> list.size() > 0 ? list.get(0) : null).map(DbTinyUrl::getTinyUrlSlug).orElse(null);
  }

  public String getFullUrl(String tinyUrl) {
    return Optional.ofNullable(tinyUrlMapper.findByTinyUrl(tinyUrl)).map(list -> list.size() > 0 ? list.get(0) : null).map(DbTinyUrl::getFullUrl).orElse(null);
  }
}
