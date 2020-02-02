#일정관리 프로젝트
##### dev for toyProject with REST Api/Spring boot

* * * 

## 개발환경
> Spring boot 2.2.1.RELEASE  
> Java 8  
> lombok (Slf4j)  
> gradle  
> swagger 2.9.2

* * * 

## 구조
 swagger-ui.html 참조  

* * * 

## 알려진 문제점
 

## Version Log
#### 기능 추가 및 db연동
GET /todo : 모든 todo  
POST /todo : post로 todo(json객체) 전달하여 저장


#### todo CRUD
GET /todo : 사용자 todo list 조회  
POST /todo : todo 추가  
PUT /todo : todo 수정  
DELETE /todo : todo 삭제  

#### logging 처리  
access (embedded tomcat) logging  
server(sql, error) logging  