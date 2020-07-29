package com.cxm.mytinyurl.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

import com.cxm.mytinyurl.TestUtil;
import com.cxm.mytinyurl.storage.MockMyTinyUrlStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyTinyUrlServiceTest {

  private MyTinyUrlService service = null;
  private TinyUrlGenerator mockGenerator = mock(TinyUrlGenerator.class);

  @BeforeEach
  void before() {
    service = new MyTinyUrlService(new MockMyTinyUrlStorage(), mockGenerator);
    when(mockGenerator.generate()).thenCallRealMethod();
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

  @Test
  void should_throw_runtime_exception_when_retries_used_up() {
    when(mockGenerator.generate()).thenReturn("abcd1234");
    service.createOrGetTinyUrl(TestUtil.TEST_FULL_URL);
    assertThrows(RuntimeException.class, () -> service.createOrGetTinyUrl(TestUtil.TEST_FULL_URL+"/1"));
  }
}
