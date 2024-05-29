# hibernate-search 7
apache-lucene을 활용한 검색엔진 

## Features
- Entity 인덱싱
- 키워드 조회
- 검색 기능

## Tech Stack 📚
<div style="margin-left: 1em">
   <img src="https://img.shields.io/badge/language-%23121011?style=for-the-badge" alt=""><img src="https://img.shields.io/badge/java-%23ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt=""><img src="https://img.shields.io/badge/21-515151?style=for-the-badge" alt="">
</div>
<div style="margin-left: 1em">
   <img src="https://img.shields.io/badge/framework-black?style=for-the-badge" alt=""><img src="https://img.shields.io/badge/spring_boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white" alt=""><img src="https://img.shields.io/badge/3.2.5-515151?style=for-the-badge" alt=""><img src="https://img.shields.io/badge/spring_security-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white" alt=""><img src="https://img.shields.io/badge/6.2.4-515151?style=for-the-badge" alt=""><img src="https://img.shields.io/badge/hibernate_search-59666C?style=for-the-badge&logo=hibernate&logoColor=white" alt=""><img src="https://img.shields.io/badge/7.1.1-515151?style=for-the-badge" alt="">
</div>
<div style="margin-left: 1em">
   <img src="https://img.shields.io/badge/template_engine-black?style=for-the-badge" alt=""><img src="https://img.shields.io/badge/thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white" alt=""><img src="https://img.shields.io/badge/3.1.2-515151?style=for-the-badge" alt="">
</div>
<div style="margin-left: 1em">
   <img src="https://img.shields.io/badge/build-%23121011?style=for-the-badge" alt=""><img src="https://img.shields.io/badge/gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white" alt=""><img src="https://img.shields.io/badge/8.7-515151?style=for-the-badge" alt="">
</div>
<div style="margin-left: 1em">
   <img src="https://img.shields.io/badge/database-%23121011?style=for-the-badge" alt=""><img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white" alt=""><img src="https://img.shields.io/badge/8.0.36-515151?style=for-the-badge" alt="">
</div>
<div style="margin-left: 1em">
   <img src="https://img.shields.io/badge/openapi-%23121011?style=for-the-badge" alt=""><img src="https://img.shields.io/badge/swagger--ui-85EA2D?style=for-the-badge&logo=swagger&logoColor=white" alt=""><img src="https://img.shields.io/badge/4.18.2-515151?style=for-the-badge" alt="">
</div>

## Getting Started

### Prerequisites
- Java 11, 17 or 21
- Gradle
- MySQL

### Setup
1. Clone the repository:
    ```
    git clone https://github.com/gjwnssud/hibernate-search.git
    ```
2. Navigate to the project directory:
    ```
    cd hibernate-search
    ```
3. Configure MySQL:
    - MySQL에서 ***'your-database-name'*** 데이터베이스를 생성합니다.
    - ***src/main/resources/application.yml*** 파일에 데이터베이스 설정을 추가합니다:
   ```yaml
   spring:
       datasource:
           url: jdbc:mysql://localhost:3306/your-database-name?useSSL=false&serverTimezone=UTC
           username: your_mysql_username
           password: your_mysql_password
   jpa:
       hibernate:
           ddl-auto: update
   ```
4. Run the application using Gradle:
   ```
   gradle bootRun
   ```
   애플리케이션이 ***http://localhost:8080*** 에서 실행됩니다. Swagger UI는 ***http://localhost:8080/swagger-ui/index.html*** 에서 확인할 수 있습니다.

## Contact
hzn - gjwnssud@gmail.com 
<br>
project link - https://github.com/gjwnssud/hibernate-search
