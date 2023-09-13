---
marp: true
---
# 디자인 패턴 
> (소프트웨어) 디자인 패턴이란 특정 문맥에서 공통적으로 발생하는 문제에 대해 쓰이는 재사용 가능한 해결책 목적별로 일정한 패턴이 제시되어 있음    
### 장점
- 소프트웨어의 구조를 파악하기 용이함
- 재사용을 통해 개발 시간 단축 
### 단점 
- 객체지향적 설계를 고려하여 진행해야 함
- 초기 투자 비용이 많이 들어감(돈, 시간 등)

---
## MVC(Model View Controller) 패턴 
![Alt text](./img/image-1.png)

---
### Controller(컨트롤러)
- Model(모델)과 View(뷰)) 사이에서 브릿지 역할을 수행
- 앱의 사용자로부터 입력에 대한 응답으로 모델 및 뷰를 업데이트하는 로직을 포함
- 사용자의 요청은 모두 컨트롤러를 통해 진행되어야 함
### Model(모델)
- 데이터를 처리하는 영역
- 데이터베이스와 연동을 위한 DAO(Data Access Object)와 데이터의 구조를 표현하는 DO(Data Object)로 구성됨
### View(뷰)
- 데이터를 보여주는 화면 자체의 영역을 뜻함
- 사용자 인터페이스(UI) 요소들이 여기에 포함되며, 데이터를 각 요소에 배치함 

---
### MVC 패턴의 특징 
- 어플리케이션의 역할을 세 구간으로 나누어 설계함으로써 서로 간의 의존성이 낮아짐
- 각 영역이 독립적으로 구성되어 개발자 간 분업 및 협업이 원활해짐
- 한 영역을 업데이트 하더라도 다른 곳에 영향을 주지 않음 

---
# REST API
### API (Application Programming Interface)란?
- 응용 프로그램에서 사용할 수 있도록 다른 응용 프로그램을 제어할 수 있게 만든 인터페이스를 뜻함
- API를 사용하면 내부 구현 로직을 알지 못해도 정의되어 있는 기능을 쉽게 사용할 수 있음 
### REST(Respresentational State Transfer)란?
- 서버와 클라이언트의 통신 방식 중 하나임 
- HTTP URI(Uniform Resource Identifier)를 통해 자원을 명시하고 HTTP Method를 통해 자원을 교환하는 것
  - HTTP Method: GET, POST 등 

---
### REST 특징 
- Server-Client 구조 
  - 자원이 있는 쪽이 Server, 요청하는 쪽이 Client
  - 클라이언트와 서버가 독립적으로 분리되어 있어야 함
- Stateless
  - 요청 간에 클라이언트 정보가 서버에 저장되지 않음
  - 서버는 각각의 요청을 완전히 별개의 것으로 인식하고 처리
- 인터페이스 일관성(Uniform Interface)
  - HTTP 프로토콜을 따르는 모든 플랫폼에서 사용 가능하게끔 설계

---
### REST API란?
- REST 아키텍처의 조건을 준수하는 어플리케이션 프로그래밍 인터페이스를 뜻함
- 일반적으로 REST 아키텍처를 구현하는 웹서비스를 RESTful 하다고 표현한다.
### REST API 특징
- REST 기반으로 시스템을 분산하여 확장성과 재사용성을 높임
- HTTP 표준을 따르고 있어 여러 프로그래밍 언어로 구현할 수 있음


---
# Maven
- pom.xml
  - Maven 프로젝트를 생성하면 루트 디렉토리에 생성되는 파일 
  - Project Obejct Model 정보를 담고 있음
  - 주요 설정 정보
    - 프로젝트 정보: 프로젝트의 이름, 개발자 목록, 라이센스 등
    - 빌드설정 정보: 소스, 리소스, 라이프 사이클 등 실행할 플러그인 등
    - POM 연관 정보: 의존 프로젝트(모듈) 등 
- https://mvnrepository.com/

---
![Alt text](./img/image.png)

---
# Lombok
- 반복되는 메소드를 Annotation을 사용하여 자동으로 작성해주는 라이브러리 
- 일반적으로 VO, DTO, Model, Entity 등의 데이터 클래스에서 주로 사용함 
- 대표적으로 많이 사용되는 Annotation
  - @Getter
  - @Setter
  - @NoArgConstructor
  - @AllArgConstructor
  - @ToString


---
# 소스
- https://github.com/Around-Hub-Studio/AroundHub_SpringBoot/tree/master

# 참고자료
- [1편](https://www.youtube.com/watch?v=7t6tQ4KV37g&t=498s)
- [2편](https://www.youtube.com/watch?v=1Jc-SD9YrV4)



1:55
