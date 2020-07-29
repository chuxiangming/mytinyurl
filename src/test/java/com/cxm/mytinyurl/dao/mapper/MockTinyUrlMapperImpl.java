package com.cxm.mytinyurl.dao.mapper;

import com.cxm.mytinyurl.dao.domain.DbTinyUrl;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MockTinyUrlMapperImpl implements TinyUrlMapper {

  List<DbTinyUrl> rows = new ArrayList<>();

  @Override
  public int insert(String tinyUrlSlug, String fullUrl) {
    rows.add(DbTinyUrl.builder().full_url(fullUrl).tiny_url_slug(tinyUrlSlug).build());
    return 1;
  }

  @Override
  public List<DbTinyUrl> findByTinyUrl(String tinyUrlSlug) {
    return rows.stream().filter(dbTinyUrl -> dbTinyUrl.getTinyUrlSlug().equals(tinyUrlSlug)).collect(Collectors.toList());
  }

  @Override
  public List<DbTinyUrl> findByFullUrl(String fullUrl) {
    return rows.stream().filter(dbTinyUrl -> dbTinyUrl.getFullUrl().equals(fullUrl)).collect(Collectors.toList());
  }

  @Override
  public int countByFullUrlOrTinyUrlSlug(String fullUrl, String tinyUrlSlug) {
    return rows.stream().anyMatch(dbTinyUrl -> dbTinyUrl.getFullUrl().equals(fullUrl) || dbTinyUrl.getTinyUrlSlug().equals(tinyUrlSlug)) ? 1 : 0;
  }
}
