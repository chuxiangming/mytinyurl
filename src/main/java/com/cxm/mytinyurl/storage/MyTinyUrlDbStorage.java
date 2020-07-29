package com.cxm.mytinyurl.storage;

import static com.google.common.base.Preconditions.checkArgument;

import com.cxm.mytinyurl.dao.domain.DbTinyUrl;
import com.cxm.mytinyurl.dao.mapper.TinyUrlMapper;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MyTinyUrlDbStorage implements MyTinyUrlStorage {

  private final TinyUrlMapper tinyUrlMapper;

  public void createTinyUrl(String fullUrl, String tinyUrl) {
    checkArgument(!isDuplicated(fullUrl, tinyUrl));
    tinyUrlMapper.insert(tinyUrl, fullUrl);
  }

  public String getTinyUrl(String fullUrl) {
    return Optional.ofNullable(tinyUrlMapper.findByFullUrl(fullUrl)).map(list -> list.size() > 0 ? list.get(0) : null).map(DbTinyUrl::getTinyUrlSlug).orElse(null);
  }

  public String getFullUrl(String tinyUrl) {
    return Optional.ofNullable(tinyUrlMapper.findByTinyUrl(tinyUrl)).map(list -> list.size() > 0 ? list.get(0) : null).map(DbTinyUrl::getFullUrl).orElse(null);
  }

  private boolean isDuplicated(String fullUrl, String tinyUrlSlug) {
    return tinyUrlMapper.countByFullUrlOrTinyUrlSlug(fullUrl, tinyUrlSlug) > 0;
  }
}
