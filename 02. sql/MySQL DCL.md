---
marp: true
---
# [DCL(Data Control Language)](https://www.fun-coding.org/post/mysql_basic5.html#gsc.tab=0)
데이터의 보안, 무결성, 회복 등을 제어하는 구문

---
## 사용자 권한
- 사용자 확인
```sql
mysql> use mysql;
mysql> select * from user;
```
- 로컬에서만 접속 가능한 userid 생성
```sql
mysql> create user 'userid'@localhost identified by '비밀번호';
```

---
- 모든 호스트에서 접속 가능한 userid 생성
```sql
mysql> create user 'userid'@'%' identified by '비밀번호';
```
- 사용자 비밀번호 변경
```sql
mysql> SET PASSWORD FOR 'userid'@'%' = '신규비밀번호';
```
- 사용자 삭제
```sql
mysql> drop user 'userid'@'%';
```
---
## 데이터베이스 권한 
- 전체 데이터베이스 전체 테이블의 조회/수정/추가 권한 부여
```sql
mysql> GRANT ALL privileges ON *.* to '계정명'@계정 호스트 정보;
# grant table reload
mysql> FLUSH PRIVILEGES; # 새로운 권한 적용
```
- 특정 데이터베이스 전체 테이블의 조회 권한 부여
```sql
mysql> GRANT select ON 특정 데이터베이스.* to '계정명'@계정 호스트 정보;
# grant table reload
mysql> FLUSH PRIVILEGES; # 새로운 권한 적용
```
- 특정 데이터베이스 특정 테이블의 조회/수정/추가 권한 부여
```sql
mysql> GRANT select,insert,update ON 특정 데이터베이스.특정 테이블 to '계정명'@계정 호스트 정보;
# grant table reload
mysql> FLUSH PRIVILEGES; # 새로운 권한 적용
```

---
## root 계정 비번 잊어버렸을 때,
1. MySQL 서버를 멈춘다.
  ```bash
  > mysql.server stop
  ```
2. [MySQL 서버 승인 생략 옵션](https://it-mesung.tistory.com/135)
  ```bash
  > mysql.server start --skip-grant-tables
  ```
3. 비번없시 root 유저로 접속
  ```bash
  > mysql -u root
  ```

---
4. mysql 데이터베이스 사용
  ```sql
  mysql> use mysql;
  ```
5. [비밀번호 정책 확인](https://junho85.pe.kr/1484)
  ```sql
  mysql> show variables like 'validate_password%';
  ```
  - (필요시)비밀번호 정잭 변경
    ```sql
    mysql> set global validate_password.policy=LOW;

    ```

---
6. root 계정 정보 확인
  ```sql
  mysql> select * from user;
  ```
  - root 계정 비번 변경
    ```sql
    mysql> SET PASSWORD FOR 'root'@localhost = '신규비밀번호';
    ```
  - 변경사항 적용 & 나가기
    ```sql
    mysql> flush privileges;
    mysql> exit;
    ```
7. 서버 재기동 & 접속
  ```bash
  > mysql.server restart
  > mysql -u root -p
  ```
