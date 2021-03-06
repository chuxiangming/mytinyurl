package com.cxm.mytinyurl.controller;

import com.cxm.mytinyurl.service.MyTinyUrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class MainController {

  private final MyTinyUrlService myTinyUrlService;
  private static final String URL_DOMAIN = "http://localhost:8080";

  @PostMapping("/generate")
  @ResponseBody
  public String generate(@RequestBody String fullUrl) {
    String urlSlug = myTinyUrlService.createOrGetTinyUrl(fullUrl);
    return URL_DOMAIN + "/tiny/"+urlSlug;
  }

  @GetMapping("/tiny/{tinyUrl}")
  @ResponseBody
  public String go(@PathVariable String tinyUrl) {
    return myTinyUrlService.getFullUrl(tinyUrl);
  }

  @GetMapping("/healthcheck")
  @ResponseBody
  public String healthCheck() {
    return "success";
  }
}
