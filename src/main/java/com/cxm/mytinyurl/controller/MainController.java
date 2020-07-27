package com.cxm.mytinyurl.controller;

import com.cxm.mytinyurl.service.MyTinyUrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class MainController {

  private final MyTinyUrlService myTinyUrlService;
  private final String URL_DOMAIN = "localhost:8080";

  @GetMapping("/generate/{fullUrl}")
  @ResponseBody
  public String generate(@PathVariable String fullUrl) {
    String urlSlug = myTinyUrlService.createOrGetTinyUrl(fullUrl);
    return URL_DOMAIN + "/tiny/"+urlSlug;
  }

  @GetMapping("/tiny/{tinyUrl}")
  @ResponseBody
  public String go(@PathVariable String tinyUrl) {
    return "redirect:" + myTinyUrlService.getFullUrl(tinyUrl);
  }
}
