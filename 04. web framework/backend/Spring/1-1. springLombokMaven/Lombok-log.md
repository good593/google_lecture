---
marp: true

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
## [@Slf4j(Simple Logging Facade for Java)](https://howtodoinjava.com/spring-boot/configure-logging-application-yml/)
- Slf4j는 뜻 그대로 로깅을 간단하게 사용할 수 있도록 하는 Facade로 로깅 라이브러리들을 하나의 통일된 방식으로 사용할 수 있는 방법이다.


---
### 로그 레벨 
TRACE < DEBUG < INFO < WARN < ERROR

- TRACE : 추적 레벨은 Debug보다 좀더 상세한 정보를 나타냄
- DEBUG : 프로그램을 디버깅하기 위한 정보 지정
- INFO : `(기본 값)`상태변경과 같은 정보성 메시지를 나타냄
- WARN : 처리 가능한 문제, 향후 시스템 에러의 원인이 될 수 있는 경고성 메시지를 나타냄
- ERROR : 요청을 처리하는 중 문제가 발생한 경우

---
### 로그사용의 이점 
- 시스템콘솔은 단순히 텍스트만 출력되지만 로그를 사용하면 시간, 로그레벨, 클래스명등 다양한 정보를 제공받는다.
- 로그레벨에 따라 개발 서버에는 모든 로그를 출력하고 운영서버에는 출력하지 않는 등의 상황에 맞는 로그 관리가 가능하다. 
- 콘솔뿐 아니라 파일이나 네트워크 등 로그를 별도의 위치에 기록 가능하다. 
- 성능이 System.out 보다 좋다.
