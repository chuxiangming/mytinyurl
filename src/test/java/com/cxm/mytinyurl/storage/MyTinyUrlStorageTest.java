package com.cxm.mytinyurl.storage;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.cxm.mytinyurl.TestUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyTinyUrlStorageTest {
  private MyTinyUrlStorage storage;

  @BeforeEach
  public void before() {
    storage = new MyTinyUrlStorage();
  }

  @Test
  void should_create_tiny_url() {
    storage.createTinyUrl(TestUtil.TEST_FULL_URL, TestUtil.TEST_TINY_URL);
    assertEquals(TestUtil.TEST_FULL_URL, storage.getFullUrl(TestUtil.TEST_TINY_URL));
    assertEquals(TestUtil.TEST_TINY_URL, storage.getTinyUrl(TestUtil.TEST_FULL_URL));
  }

  @Test
  void should_throw_exception_when_full_url_is_duplicated() {
    storage.createTinyUrl(TestUtil.TEST_FULL_URL, TestUtil.TEST_TINY_URL);
    Exception e = assertThrows(Exception.class, () -> storage.createTinyUrl(TestUtil.TEST_FULL_URL, ""));
    assertEquals(e.getClass(), IllegalArgumentException.class);
    }

  @Test
  void should_throw_exception_when_tiny_url_is_duplicated() {
    storage.createTinyUrl(TestUtil.TEST_FULL_URL, TestUtil.TEST_TINY_URL);
    Exception e = assertThrows(Exception.class, () -> storage.createTinyUrl("", TestUtil.TEST_TINY_URL));
    assertEquals(e.getClass(), IllegalArgumentException.class);
    }
}
