# My Tiny Url

## Introduction

A simple demo for a tiny url application.

Core functionality: convert a completed url to a (very) short url.
The original url may contain a very long path and many parameters, the corresponding url will be very short and without parameters.

For example:

**Original Url**

```
https://www.google.com/search?source=hp&ei=7YchX4r9HaSLmge2mJH4Dw&q=what+is+tiny+url&oq=what+is+tiny+url&gs_lcp=CgZwc3ktYWIQAzIECAAQCjIGCAAQChAeMgYIABAIEB4yBggAEAoQHjoCCAA6BAgAEAw6BAgAEB5QjgxYjSFg8CJoAnAAeAKAAb4DiAH7HJIBCjAuMTMuMi4yLjGYAQCgAQGqAQdnd3Mtd2l6sAEA&sclient=psy-ab&ved=0ahUKEwjKp96i1vLqAhWkheYKHTZMBP8Q4dUDCAc&uact=5
```

**Tiny Url**

```
${domain_name}/tiny/abcd1234
``` 

The length of the tiny url slug will be 8.

## Framework Support

- Gradle
- Springboot / Springboot test
- MyBatis
- Junit5
- PowerMock

## Key Content List

- Requirements: docs/requirements.md
- Source: src/main
- SQL: src/main/resources/sql/tb_tiny_url.sql
- Test Source: src/test
- Test Coverage: test_coverage/index.html or run ```gradlew test``` with coverage
