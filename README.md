<img src="https://capsule-render.vercel.app/api?type=waving&color=BDBDC8&height=150&section=footer" />

# Spring Boot Data JPA User-Service Project
스프링 부트 JPA를 활용한 로그인, 회원가입, 조직, 게시글, 채팅등을 개발하는 프로젝트 입니다.


## Install Postman
포스트맨을 설치해서 localhost로 테스트 해보세요! 

https://www.postman.com/downloads

+ **Create MySQL database**
  ```properties
  spring.application.name=kjone-Spring-Boot-JPA-Project
  server.port=7490

  spring.datasource.url= jdbc:mysql://localhost:3306/Study_JPA
  spring.datasource.username=유저이름
  spring.datasource.password=비빌번호
  spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
  ```

+ **Create Mail Config**
  ```properties
  spring.application.name=kjone-Spring-Boot-JPA-Project
  server.port=7490

  spring.mail.default-encoding=UTF-8
  spring.mail.host=smtp.gmail.com
  spring.mail.port=587
  spring.mail.username=geniusfusion7@gmail.com
  spring.mail.password=#### #### ####
  spring.mail.properties.mail.smtp.starttls.enable=true
  spring.mail.properties.mail.smtp.auth=true
  ```
# DATA.SQL
  ```sql
  REPLACE INTO `roles` VALUES (1,'ADMIN');
  ```




