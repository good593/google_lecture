---
marp: true
---
# 자바 조건문 
- if else 
```java
int i = 10; 

if (i < 3) {
  System.out.println("True");
} else if (i < 5) {
  System.out.println("False");
} else {
  System.out.println("None");
}
```

---
- 3항 연산자 
> 조건 ? 조건이 참일 때 : 조건이 거짓일 때 

```java
boolean isMarried = true; 
String str = isMarried ? "Yes" : "No";
System.out.println(str);

// 3항 다항식을 if else문으로 변경 
if (isMarried) {
  str = "Yes";
} else {
  str = "No";
}
System.out.println(str);
```
---
- 조건 
  - and 조건: &&
  - or 조건: || 
  - not 조건: !
```java
boolean isMarried = true; 
boolean isOld = false;
String str; 

if (isMarried && isOld) { // 결혼을 했으면서, 나이가 많음 
  str = "1";
} else if (isMarried || isOld) { // 결혼을 했거나 나이가 많거나 
  str = "2";
} else if (!isMarried) { // 결혼을 하지 않음 
  str = "3";
} else { // 그외...
  str = "0";
}

System.out.println(str);
```

---
- switch/case
```java
int month = 3;
String monthString = "";
switch (month) {  // 입력 변수의 자료형은 byte, short, char, int, enum, String만 가능하다.
  case 1:  monthString = "January";
    break;
  case 2:  monthString = "February";
    break;
  case 3:  monthString = "March";
    break;
  default: monthString = "Invalid month";
    break;
}
System.out.println(monthString);
```

