package com.cxm.mytinyurl.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.cxm.mytinyurl.TestUtil;
import com.cxm.mytinyurl.storage.MyTinyUrlStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyTinyUrlServiceTest {

  MyTinyUrlService service = null;

  @BeforeEach
  void before() {
    service = new MyTinyUrlService(new MyTinyUrlStorage());
  }

  @Test
  void should_return_same_tiny_url_when_input_full_url() {
    assertEquals(
        service.createOrGetTinyUrl(TestUtil.TEST_FULL_URL)
        , service.createOrGetTinyUrl(TestUtil.TEST_FULL_URL));
  }

  @Test
  void should_return_full_url_by_tiny_url() {
    String tinyUrl = service.createOrGetTinyUrl(TestUtil.TEST_FULL_URL);
    assertEquals(TestUtil.TEST_FULL_URL, service.getFullUrl(tinyUrl));
  }

  @Test
  void should_return_tiny_url_within_8_characters() {
    String tinyUrl = service.createOrGetTinyUrl(TestUtil.TEST_FULL_URL);
    assertTrue(tinyUrl.length() <= 8);
  }

  @Test
  void should_return_different_tiny_url_for_similar_full_url() {
    assertNotEquals(service.createOrGetTinyUrl(TestUtil.TEST_FULL_URL + "/1"), service.createOrGetTinyUrl(TestUtil.TEST_FULL_URL + "/2"));
  }
}
