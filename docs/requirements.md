# Requirements

## Factored Requirement Lists
1. Design a pattern for full url & tiny url
1. API design: full url set & get tiny url API
2. API design: get full url by tiny url (what if we don't have it？)
3. same tiny url for same full url (not create new one every time)

## Reference: Original requirements
Q1.

参考短域名服务（细节可以百度/谷歌）

撰写两个API接口
- 短域名存储接口：接受长域名信息，返回短域名信息
- 短域名读取接口：接受短域名信息，返回长域名信息。

限制：
- 短域名长度最大为8个字符


递交作业内容
1. 源代码
2. 单元测试代码以及单元测试覆盖率
3. API集成测试案例以及测试结果
4. 简单的框架设计图，以及所有做的假设
5. 涉及的SQL或者NoSQL的Schema，注意标注出Primary key 和Index 如果有。 