---
marp: true

---
# [TDD(Test Drive Development)](https://inpa.tistory.com/entry/QA-%F0%9F%93%9A-TDD-%EB%B0%A9%EB%B2%95%EB%A1%A0-%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%A3%BC%EB%8F%84-%EA%B0%9C%EB%B0%9C)
- 테스트 주도 개발이라는 의미를 가짐 
- 단순하게 표현하자면 테스트를 먼저 설계 및 구축 후 테스트를 통과할 수 있는 코드를 짜는 것 
- 코드 작성 후 테스트를 진행하는 지금까지 사용된 일반적인 방식과 다소 차이가 있음 

---
### 애자일 개발 방식 중 하나 
- 코드 설계시 원하는 단계적 목표에 대해 설정하여 진행하고자 하는 것에 대한 결정 방향의 갭을 줄이고자 함
- 최초 목표에 맞춘 테스트를 구축하여 그에 맞게 코드를 설계하기 때문에 보다 적은 의견 충돌을 기대할 수 있음 

### 테스트 코드 작성 목적 
- 코드의 안정성을 높일 수 있음 
- 기능을 추가하거나 변경하는 과정에서 발생할 수 있는 Side-Effect를 줄일 수 있음 
- 해당 코드가 작성된 목적을 명확하게 표현할 수 있음
    - 코드에 불필요한 내용이 들어가는 것을 비교적 줄일 수 있음 


---
# [JUnit](https://cheershennah.tistory.com/220)
- Java 진영의 대표적인 Test Framework
- 어노테이션(Annotation)을 기반으로 테스트를 지원 
- 단정문(Assert)으로 테스트 케이스의 기대값에 대해 수행 결과를 확인 
- `단위 테스트(Unit Test)`를 위한 도구를 제공 
    - 코드의 특정 모듈이 의도된 대로 동작하는지 테스트 
    - 모든 함수(메소드)에 대한 테스트 케이스(Test Case)를 작성 


---
## JUnit LifeCycle Annotation

![Alt text](./img/image.png)

---
## JUnit Main Annotation

- @SpringBootTest
    - 통합 테스트 용도로 사용됨 
    - @SpringBootApplication을 찾아가 하위의 모든 Bean을 스캔하여 로드함 
    - 그 후 Test용 Application Context를 만들어 Bean을 추가하고, MockBean을 찾아 교체 

- @ExtendWith
    - @ExtendWith는 메인으로 실행될 Class를 지정할 수 있음 
    - @SpringBootTest는 기본적으로 @ExtendWith가 추가되어 있음 

---
- @WebMvcTest(Class명.class)
    - ()에 작성된 클래스만 실제로 로드하여 테스트를 진행 
    - 매개변수를 지정해주지 않으면 @Controller, @RestController, @RestControllerAdvice 등 컨트롤러와 연괸된 Bean이 모두 로드됨 
    - 스프링의 모든 Bean을 로드하는 @SpringBootTest 대신 컨트롤러 관련 코드만 테스트할 경우 사용 

- @Autowired about Mockbean
    - Controller의 API를 테스트하는 용도인 MockMvc 객체를 주입 받음 
    - perform() 메소드를 활용하여 컨트롤러의 동작을 확인할 수 있음 
        - andExpect(), andDo(), andReturn() 등의 메소드를 같이 활용함 

---
- @MockBean
    - 테스트할 클래스에서 주입 받고 있는 객체에 대해 `가짜 객체`를 생성해주는 어노테이션 
    - 해당 객체는 실제 행위를 하지 않음 
    - given() 메소드를 활용하여 가짜 객체의 동작에 대해 정의하여 사용할 수 있음 

- @AutoConfigureMockMvc
    - spring.test.mockmvc의 설정을 로드하면서 MockMvc의 의존성을 자동으로 주입 
    - MockMvc 클래스는 REST API 테스트를 할 수 있는 클래스 

---
- @Import 
    - 필요한 Class들을 Configuration으로 만들어 사용할 수 있음 
    - Configuration Component 클래스도 의존성 설정할 수 있음 
    - Import된 클래스는 주입으로 사용 가능 

---
# 통합 테스트
- 통합 테스트는 여러 기능을 조합하여 전체 비지니스 로직이 제대로 동작하는지 확인하는 것을 의미 
- 통합 테스트의 경우, @SpringBootTest를 사용하여 진행 
    - @SpringBootTest는 @SpringBootApplication을 찾아가서 모든 Bean을 로드하게 됨 
    - 이 방법을 대규모 프로젝트에서 사용할 경우, 테스트를 실행할 때마다 모든 빈을 스캔하고 로드하는 작업이 반복되어 매번 무거운 작업을 수행해야 함 

---
# 단위 테스트 
- 단위 테스트는 프로젝트에 필요한 모든 기능에 대한 테스트를 각각 진행하는 것을 의미 
- 일반적으로 스프링 부트에서는 
    - 'spring-boot-starter-test' 디펜던시만으로 의존성을 모두 가질 수 있음 

### F.I.R.S.T 원칙 
- Fast: 테스트 코드의 실행은 빠르게 진행되어야 함 
- Independent: 독립적인 테스트가 가능해야 함 
- Repeatable: 테스트는 매번 같은 결과를 만들어야 함 
- Self-Validating: 테스트는 그 자체로 실행하여 결과를 확인할 수 있어야 함 
- Timely: 단위 테스트는 비지니스 코드가 완성되기 전에 구성하고 테스트가 가능해야 함 
    - 코드가 완성되기 전부터 테스트가 따라와야 한다는 `TDD의 원칙`을 담고 있음 

---
# 소스
- https://github.com/Around-Hub-Studio/AroundHub_SpringBoot/tree/master

# 참고자료
- [1편](https://www.youtube.com/watch?v=7t6tQ4KV37g&t=498s)
- [2편](https://www.youtube.com/watch?v=1Jc-SD9YrV4)

