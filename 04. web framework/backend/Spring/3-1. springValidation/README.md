---
marp: true

---

# [유효성 검사(Validation)](https://kdhyo98.tistory.com/80#Jakarta%20Validation%20API%20%EC%82%B4%ED%8E%B4%EB%B3%B4%EA%B8%B0-1)
- 서비스의 비즈니스 로직이 올바르게 동작하기 위해 사용되는 데이터에 대한 사전 검증하는 작업이 필요함
- Validation은 들어오는 데이터에 대해 의도한 형식의 값이 제대로 들어오는지 체크하는 과정을 뜻함 

```
// Gradle
implementation 'org.springframework.boot:spring-boot-starter-validation'

// Maven
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>

```

---
## 일반적인 유효성 검사
- 간단한 검증을 하더라도 검증관련 로직이 길어짐
- 검증 로직이 중복으로 여러 Layer(Controller, Service, DAO 등)에 존재하게 됨 
- Layer에 검증 로직이 섞여있기 때문에 추적이 어렵고, 애플리케이션이 복잡해짐 

```java
if (itemDTO == null) {
    throw new IllegalArgumentException("아이템 정보가 존재하지 않습니다.");
}

if (itemDTO.getItemName() == null || itemDTO.getItemName().isEmpty()) {
    throw new IllegalArgumentException("아이템 명은 필수 입니다.");
}

if (itemDTO.getQuantity() == null) {
    throw new IllegalArgumentException("아이템 개수는 필수 입니다.");
}
...

```

---

![Alt text](./img/image.png)

---
## @Valid를 이용한 유효성 검사

```java
public ResponseEntity<String> save(@Valid @RequestBody ItemDTO itemDTO) {
    itemService.save(itemDTO);
    return new ResponseEntity<>(HttpStatus.CREATED);
}
```

---

![Alt text](./img/image-1.png)

---
## Validation 관련 주요 어노테이션
### 문자열 
- `@Size`: 문자의 길이 조건 / `@NotNull`: null 값 불가 
- `@NotEmpty`: @NotNull + "" 값 불가 / `@NotBlank`: @NotEmpty + " " 값 불가 
- `@Pattern(regexp="", message="")`: 정규식을 통한 조건 
- `@Email`: 이메일 

### 날짜 
- `@Past`: 과거 날짜 /  `@PastOrPresent`: @Past + 오늘 날짜
- `@Future`: 미래 날짜 / `@FutureOrPresent`: @Future + 오늘 날짜

---
### 숫자 
- `@Max`: 최대값 / `@Min`: 최소값 
- `@Positive`: 양수만 / `@PositiveOrZero`: 양수와 0만
- `@Negative`: 음수만 / `@NegativeOrZero`: 음수와 0만

### 직접 검증 
- `AssertTrue`: 참 / `AssertFalse`: 거짓

---
```java
public class ProductDto {
  
  private String productId;

  @NotBlank
  @Size(min = 4, max = 10)
  private String ProductName;

  @Min(value = 50)
  private int ProductPrice;

  @Min(value = 0)
  @Max(value = 99)
  private int productStock;

}


```

---
# 소스
- https://github.com/Around-Hub-Studio/AroundHub_SpringBoot/tree/master

# 참고자료
- [1편](https://www.youtube.com/watch?v=7t6tQ4KV37g&t=498s)
- [2편](https://www.youtube.com/watch?v=1Jc-SD9YrV4)

# 단축키
- Override 단축키
  - 컨트롤러 + .

