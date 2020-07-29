package com.cxm.mytinyurl.service;

import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class TinyUrlGenerator {
  String generate() {
    return UUID.randomUUID().toString().substring(0, 7);
  }
}
