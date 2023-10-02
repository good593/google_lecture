---
marp: true
---
# 반복문 
- for
```java
for (int i=0; i<10; i++) {
  System.out.println(i);
}
```

- while 
```java
int x = 0;

while (x<10) {
  System.out.println(x);
  x++;
}
```
---
- for each
```java
int[] score = { 78, 70, 65, 98, 58 };
int sum = 0;

for (int i : score) {
  sum += i; // sum = sum + i;
}
System.out.println("점수 합계 : " + sum); // 결과 : 369
```
```java
ArrayList<String> numbers = new ArrayList<>(Arrays.asList("one", "two", "three"));

for (String number : numbers) {
    System.out.println(number);
}
```

---
- break:  만나는 즉시 반복문 전체 탈출
```java
for (int i=0; i<10; i++) {
  if (i == 6) {
    break;
  }
  System.out.println(i);
}
```
- continue:  만나면 해당 반복부분 탈출 후 다음반복실행
```java
for (int i=0; i<10; i++) {
  if (i == 6) {
    continue; // 6만 출력이 안됨 
  }
  System.out.println(i);
}
```
