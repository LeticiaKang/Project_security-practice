# security-practice
회원가입 및 로그인 연습  
배포 : [security-practice 사이트](http://ec2-43-203-199-47.ap-northeast-2.compute.amazonaws.com:8081/)
  
## 프로젝트 목적
이유 : Spring Security5에서 Spring Security6로 넘어가면서 변경된 사항을 습득하고 적용하기 위함  
목적 : 회원가입 및 로그인 기능 구현
   
## 어려웠던 점
Security 자료 대부분이 변경 전 사항이라 자료를 찾는데 쉽지 않았습니다.  
외국 유튜브 영상과 spring security document를 참고하여 원리를 이해하면서 구현하기 위해 노력했으며,  
해당 프로젝트를 배포까지 완료함으로써 어려웠던 spring security와 AWS 사용방법을 습득할 수 있었습니다.

## 요구사항
- 회원가입과 로그인 기능 구현
- 권한은 ADMIN, USER, VIP로 구분
- Authentication에 따른 접근 구분
   - /index, /login, /registration : 누구나
   - /normal-page, /users : 로그인된 상태)  
- 권한에 따른 버튼 노출(thymeleaf로 설정함)
  - 사용자 목록(/users) : ADMIN
  - 상태페이지(/normal-page) : 모든 권한(ADMIN, USER, VIP)

## 개발 환경
* Intellij IDEA Ultimate 2023.2.6
* Java 17
* Gradle 8.2
* Spring Boot 3.2.2
  
## 기술 세부 스택
- Spring Boot
  * Spring Web / Spring Data JPA / Spring Security / Spring Boot DevTools / Spring Configuration Processor
  * Rest Repositories / Rest Repositories HAL Explorer / H2 Database / MySQL Driver
  * Thymeleaf / Lombok

- 배포
  * AWS EC2
  * AWS RDS(MYSQL)

## git branch 전략
- git hub 사용, 간단한 실습용임으로 main만 사용

## 데모 영상
<img width="80%" src="https://github.com/LeticiaKang/Project_board/assets/87592790/db08494a-84ea-4e8b-8cc3-ac00d2fd4d5d" />
 
