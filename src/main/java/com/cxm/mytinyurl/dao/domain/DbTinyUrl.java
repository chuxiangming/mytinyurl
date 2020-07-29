package com.cxm.mytinyurl.dao.domain;

import lombok.Builder;

@Builder(toBuilder = true)
public class DbTinyUrl {
  private String tiny_url_slug;
  private String full_url;

  public String getTinyUrlSlug() {
    return tiny_url_slug;
  }

  public String getFullUrl() {
    return full_url;
  }
}
