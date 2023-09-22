---
marp: true

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

