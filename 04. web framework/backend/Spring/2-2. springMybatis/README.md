---
marp: true
---
# [MyBatis](https://khj93.tistory.com/entry/MyBatis-MyBatis%EB%9E%80-%EA%B0%9C%EB%85%90-%EB%B0%8F-%ED%95%B5%EC%8B%AC-%EC%A0%95%EB%A6%AC)
- 객체 지향 언어인 자바의 관계형 데이터베이스 프로그래밍을 좀 더 쉽게 할 수 있게 도와 주는 개발 프레임 워크로서 
  - JDBC를 통해 데이터베이스에 엑세스하는 작업을 캡슐화하고 
  - 일반 SQL 쿼리, 저장 프로 시저 및 고급 매핑을 지원하며 
  - 모든 JDBC 코드 및 매개 변수의 중복작업을 제거 합니다. 
- Mybatis에서는 프로그램에 있는 SQL쿼리들을 한 구성파일에 구성하여 프로그램 코드와 SQL을 분리할 수 있는 장점을 가지고 있습니다.

---
![Alt text](./img/image.png)

---
# [Mybatis 설정](https://adjh54.tistory.com/65)

---
- build.gradle

```gradle
dependencies {
  ...
	implementation 'org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.2'
  ...
	testImplementation 'org.mybatis.spring.boot:mybatis-spring-boot-starter-test:3.0.2'
  ...
}
```

---
- application.yml

```yml
# Mybatis 설정
mybatis:
  # default Package location - resultType의 Alias를 지정합니다.
  type-aliases-package: com.example.basic.model
  # mapper location - 바라 볼 xml 파일을 지정합니다.
  mapper-locations: classpath:mapper/**/*.xml
  # column name to camel case - 반환 받는 컬럼명을 CamelCase로 받는 설정을 합니다.
  configuration:
    map-underscore-to-camel-case: true
```

---
# [Mybatis 동적 SQL](./mybatis_동적_sql.md)

---
# [Mybatis 예제](./mybatis_예제.md)