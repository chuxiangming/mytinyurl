package com.cxm.mytinyurl;

import static org.junit.Assert.assertEquals;

import java.net.URL;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(classes = MainApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MyTinyUrlApplicationTest {

  @LocalServerPort
  private int port;

  private URL base;

  @Autowired
  private TestRestTemplate restTemplate;

  @BeforeEach
  void beforeEach() throws Exception {
    String url = String.format("http://localhost:%d", port);
    System.out.println(String.format("port is : [%d]", port));
    base = new URL(url);
  }

  @Test
  void should_start_application() {
    assertEquals("success", httpGet("/healthcheck"));
  }

  @Test
  void should_generate_tiny_url() {
    String fullUrl = "www.baidu.com";
    String tinyUrl = callGenerate(fullUrl);
    assertEquals(fullUrl, go(tinyUrl));
  }

  @Test
  void should_return_same_tiny_url() {
    String fullUrl = "www.baidu.com/1";
    String tinyUrl = callGenerate(fullUrl);
    assertEquals(tinyUrl, callGenerate(fullUrl));
  }

  private String go(String tinyUrl) {
    String newTinyUrl = tinyUrl.replace("8080", String.valueOf(port));
    return httpGet(newTinyUrl);
  }

  private String httpGet(String url) {
    return this.restTemplate.getForEntity(url, String.class).getBody();
  }

  private String callGenerate(String fullUrl) {
    String absolutePath = base.toString() + "/generate";
    ResponseEntity<String> response = this.restTemplate.postForEntity(absolutePath, fullUrl, String.class);
    return response.getBody();
  }
}
