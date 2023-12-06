---
marp: true

---
# [Mustache](https://www.tsmean.com/articles/mustache/the-ultimate-mustache-tutorial/)
> 자바 진영에서 흔히 이야기 하는 서버 템플릿 엔진은 JSP, Velocity, Freemarker, Thymeleaf, Mustache 등등 여러가지 템플릿 엔진이 존재한다.

---
위에서 말한 템플릿 엔진의 단점들은 다음과 같다.
- `JSP`, `Velocity` : 스프링 부트에서는 권장하지 않는 템플릿 엔진임
- `Freemarker` : 템플릿 엔진으로는 너무 과하게 많은 기능을 지원한다 -> 숙련도가 낮을수록 비즈니스 로직이 추가될 가능성이 높다
- `Thymleaf` : 스프링 진영에서 적극적으로 지원하는 템플릿 엔진이지만 문법이 어렵다.

반면 `Mustache`의 장점이다.
- 문법이 다른 템플릿 엔진보다 쉽다.
- 비즈니스 로직을 사용할 수 없다. -> View의 역할과 서버의 역할이 명확하게 구분된다.

---
## Mustache 설정 
- build.gradle

```
dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-mustache'
}
```
- application.yml

```yml
spring:
  mustache:
    predix: classpath:templates/
    check-template-location: true 
    suffix: .mustache
    cache: false # default true, 개발 시에는 false로 두는 것이 좋음 
```

---
## [Mustache 문법](https://taegon.kim/archives/4910)

---
### 변수
- 데이터 
```json
{
  "name" : "Chris",
  "company" : {
    "name" : "Github",
    "address" : {
      "country" : "USA"
    }
  }
}
```
- 템플릿 
```mustache
Country : {{company.address.country}}
```
- 출력 결과 
```html
Country : USA
```

---
- 데이터
```json
{
  "name" : "Chris",
  "company" : "<b>Github</b>"
}
```
- 템플릿 
```mustache
* {{name}}
* {{age}}
* {{company}}
* {{{company}}}
```
- 출력 결과 
```html
* Chris
*
* &lt;b&gt;Github&lt;/b&gt;
* <b>Github</b>
```

---
### 조건문 
- 데이터 
```json
{
  "person" : false
}
```
- 템플릿 
```mustache
출력됩니다.
{{#person}}
  출력안됩니다.
{{/person}}
```
- 출력 결과 
```html
출력됩니다.
```

---
- 데이터 
```json
{
  "person" : {"name" : "Jon"}
}
```
- 템플릿 
```mustache
{{#person}}
  {{name}}
{{/person}}
```
- 출력 결과 
```html
Jon
```

---
- 데이터 
```json
{
  "person" : {"name" : "Jon"},
  "company" : {"name" : "Google"}
}
```
- 템플릿 
```mustache
{{#person}}
  {{name}}의 회사는 {{company.name}}입니다.
{{/person}}
```
- 출력 결과 
```html
Jon의 회사는 Google입니다.
```

---
### 반복문 
- 데이터 
```json
{
  "repo" : [
    { "name" : "resque" },
    { "name" : "hub" }
  ]
}
```
- 템플릿 
```mustache
{{#repo}}
  <b>{{name}}</b>
{{/repo}}
```
- 출력 결과 
```html
<b>resque</b>
<b>hub</b>
```

---
### 반전 섹션 
- 데이터 
```json
{
  "repo": []
}
```
- 템플릿 
```mustache
{{#repo}}
  <b>{{name}}</b>
{{/repo}}
{{^repo}}
  저장소가 없네요. -_-
{{/repo}}
```
- 출력 결과 
```html
저장소가 없네요. -_-
```

---
### 주석 
- 템플릿 
```mustache
<h1>Today{{! 여기는 안 나옵니다. }}</h1>
```
- 출력 결과 
```html
<h1>Today</h1>
```

---
### 부분템플릿 
- base.mustache 파일:
```mustache
<h2>Names</h2>
{{#names}}
  {{> user}}
{{/names}}
```
- user.mustache 파일:
```mustache
<strong>{{name}}</strong>
```

---
# 참고문서들 
- https://velog.io/@nyong_i/%EB%A8%B8%EC%8A%A4%ED%85%8C%EC%B9%98Mustache%EB%9E%80-%EB%AC%B4%EC%97%87%EC%9D%B8%EA%B0%80
- https://github.com/walbatrossw/boot-qna/tree/master
- https://github.com/farhanatsani/spring-boot-mustache-core-ui-demo/tree/master