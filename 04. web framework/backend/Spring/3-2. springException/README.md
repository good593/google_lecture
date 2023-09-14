---
marp: true

---
# [예외 처리(Exception)](https://velog.io/@kiiiyeon/%EC%8A%A4%ED%94%84%EB%A7%81-ExceptionHandler%EB%A5%BC-%ED%86%B5%ED%95%9C-%EC%98%88%EC%99%B8%EC%B2%98%EB%A6%AC)

---
## 예외 클래스
- 모든 예외 클래스는 Throwable 클래스를 상속 받고 있음

![Alt text](./img/image.png)

---

- RuntimeException은 Unchecked Exception이며, 그 외 Exception은 Checked Exception으로 볼 수 있음 

![Alt text](./img/image-1.png)

---
## 스프링 부트의 예외 처리 방식 
- @ControllerAdvice를 통한 모든 Controller에서 발생할 수 있는 예외 처리 
- @exceptionHandler를 통한 특정 Controller의 예외 처리 

`@ControllerAdvice`로 모든 컨트롤러에서 발생할 예외를 정의하고, `@ExceptionHandler`를 통해 발생하는 예외 마다 처리할 메소드를 정의 

---
### @ExceptionHandler
- @ExceptionHandler는 Controller계층에서 발생하는 에러를 잡아서 메서드로 처리해주는 기능이다.
- Service, Repository에서 발생하는 에러는 제외한다.

```java
@Controller
public class SimpleController {

    // ...

    @ExceptionHandler
    public ResponseEntity<String> handle(IOException ex) {
        // ...
    }
}
```

---
- 여러개의 Exception 처리 
  - @ExceptionHandler의 value 값으로 어떤 Exception을 처리할 것인지 넘겨줄 수 있는데,
value를 설정하지 않으면 모든 Exception을 잡게 되기 때문에 Exception을 구체적으로 적어주는 것이 좋다고 한다.

```java
@Controller
public class SimpleController {

    // ...

    @ExceptionHandler({FileSystemException.class, RemoteException.class})
    public ResponseEntity<String> handle(Exception ex) {
        // ...
    }
}
```

---
- 우선 순위
  - Exception.class보다 구체적인 오류클래스(NullPointerException.class)가 우선순위 높음 

![Alt text](./img/image-2.png)


---
### @ControllerAdvice
- @ControllerAdvice안에서 @ExceptionHandler를 사용하여 에러를 잡을 수 있다.

```java
@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity handleFileException() {
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}
```

---

- 범위 설정 
  - @ControllerAdvice는 모든 에러를 잡아주기 때문에 일부 에러만 처리하고 싶을 경우에는 따로 설정을 해주면 된다.

```java
// 1.
@ControllerAdvice(annotations = RestController.class)
public class ExampleAdvice1 {}

// 2.
@ControllerAdvice("org.example.controllers")
public class ExampleAdvice2 {}

// 3.
@ControllerAdvice(assignableTypes = {ControllerInterface.class, AbstractController.class})
public class ExampleAdvice3 {}

```



---
### @RestControllerAdvice
- @RestControllerAdvice는 @ControllerAdvice와 @ResponseBody로 이루어져있어 오류 메세지를 Response body(즉, json)로 리턴할 수 있다.

```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ControllerAdvice
@ResponseBody
public @interface RestControllerAdvice {
	// ...	
}
```

---
# [Custom Exception](https://tecoble.techcourse.co.kr/post/2020-08-17-custom-exception/)
- 자바에서는 기본적으로 충분한 예외(Java Exceptions)들을 제공하고 있다. 
- 하지만 비지니스 로직에 의한 논리 오류인 경우에는 사용자 정의 예외(Custom Exception)를 이용하는 것이 좋을 수 있다. 

```java
@Getter
public class HubException extends Exception {
  
  private HttpStatus httpStatus;

  public HubException(HttpStatus httpStatus, String message) {
    super(message);
    this.httpStatus = httpStatus;
  }
}
```

---
## Custom Exception의 장점 
1. 예외 이름으로도 정보 전달이 가능하다.
    - 상품 오류, 고객 오류 등 
2. 상세한 예외를 정의할 수 있다.
    - 제고상품50미만 오류, 고객 잔고 10만원미만 오류 등 
3. 예외에 대한 응집도가 향상된다.
    - 예외 메시지, 데이터 가공 메소드 등 각 예외에 맞는 메시지/메소드를 관리하기 편하다. 
4. 예외발생 후처리가 용이하다.
    - 각 예외별 후처리용 메소드를 정의할 수 있다. 

---
# [Enum](https://bcp0109.tistory.com/334)
Java Enum 타입은 일정 개수의 상수 값을 정의하고, 그 외의 값은 허용하지 않습니다.
과거에는 특정 상수값을 사용하기 위해선 모두 상수로 선언해서 사용했습니다.

```java
public static final String MON = "Monday";
public static final String TUE = "Tuesday";
public static final String WED = "Wednesday";
```
이렇게 사용하면 개발자가 실수하기도 쉽고 한눈에 알아보기도 쉽지 않습니다.    
그리고 관련있는 값들끼리 묶으려면 접두어를 사용해서 점점 변수명도 지저분해집니다.

> Enum 클래스는 이러한 문제점을 말끔히 해결해주는 굉장히 유용한 클래스입니다.

---
## 정의 및 생성 

```java

public enum Day1 {
    MON, TUE, WED, THU, FRI, SAT, SUN
};

Day1.MON.name(); // MON

public enum Day2 {
    MON("Monday"), TUE("Tuesday"), WED("Wednesday");

    private final String label;

    Day2(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }
};

Day2.MON.name(); // MON
Day2.MON.label(); // Monday

```

---
## Enum 값 찾기 
- name을 이용하여 Enum 클래스 정의 
```java
Day2 day = Day2.valueOf("TUE"); 

```

## values()
- enum 타입의 모든 값들을 배열로 만들어 리턴해주는 메소드 
```java
for (Day2 day : Day2.values()) {
  day.label();
}
```

---
# 소스
- https://github.com/Around-Hub-Studio/AroundHub_SpringBoot/tree/master

# 참고자료
- [1편](https://www.youtube.com/watch?v=7t6tQ4KV37g&t=498s)
- [2편](https://www.youtube.com/watch?v=1Jc-SD9YrV4)



