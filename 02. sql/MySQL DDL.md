---
marp: true
---
# [DDL(Data Definition Language)](https://www.fu3n-coding.org/mysql_basic3.html#gsc.tab=0)
데이터베이스와 테이블을 정의, 수정, 삭제하는 구문

---
## 데이터베이스
```sql
# 데이터베이스 생성
mysql> CREATE DATABASE dbname;
```
```sql
# 데이터베이스 목록 보기
mysql> SHOW DATABASES;
```
```sql
# dbname 데이터베이스 사용 시
mysql> USE dbname;
```
```sql
# dbname 데이터베이스 삭제
mysql> DROP DATABASE IF EXISTS dbname;
```

---
## 테이블
- [제약 조건](https://dev-coco.tistory.com/55)
    - `NOT NULL`: NOT NULL 제약 조건을 설정하면, 해당 필드는 NULL 값을 저장할 수 없다.
    - `UNIQUE`: UNIQUE 제약 조건을 설정하면, 해당 필드는 서로 다른 값을 가져야 한다.
    - `PRIMARY KEY`: PRIMARY KEY 제약 조건을 설정하면, 해당 필드는 NOT NULL과 UNIQUE 제약 조건의 특징을 모두 가진다.
    - `FOREIGN KEY`: FOREIGN KEY 제약 조건을 설정한 필드를 외래 키라고 부르며, 한 테이블을 다른 테이블과 연결해주는 역할을 한다.
    - `DEFAULT`: DEFAULT 제약 조건은 해당 필드의 기본값을 설정할 수 있게 해준다.

---
- [데이터 타입](https://dev.mysql.com/doc/refman/8.0/en/data-types.html)
    - [Numeric Data Types](https://dev.mysql.com/doc/refman/8.0/en/numeric-types.html)
    - [Date and Time Data Types](https://dev.mysql.com/doc/refman/8.0/en/date-and-time-types.html)
    - [String Data Types](https://dev.mysql.com/doc/refman/8.0/en/string-types.html)
    - [Spatial Data Types](https://dev.mysql.com/doc/refman/8.0/en/spatial-types.html)
    - [The JSON Data Type](https://dev.mysql.com/doc/refman/8.0/en/json.html)
    - [Data Type Default Values](https://dev.mysql.com/doc/refman/8.0/en/data-type-defaults.html)
    - [Data Type Storage Requirements](https://dev.mysql.com/doc/refman/8.0/en/storage-requirements.html)

---
## 테이블 생성
```sql
# 학생 student
create table student (
	student_id INT UNSIGNED auto_increment COMMENT '학생아이디',
	student_name varchar(10) not null COMMENT '학생이름',
	student_address varchar(50) null COMMENT '학생집주소',
	create_dt TIMESTAMP not null default now() COMMENT '생성일자',
	modify_dt TIMESTAMP not null default now() COMMENT '수정일자',
	PRIMARY KEY(student_id)
);

# 교수 professor
create table professor (
	professor_id INT UNSIGNED auto_increment COMMENT '교수아이디',
	professor_name varchar(10) not null COMMENT '교수이름',
	create_dt TIMESTAMP not null default now() COMMENT '생성일자',
	modify_dt TIMESTAMP not null default now() COMMENT '수정일자',
	PRIMARY KEY(professor_id)
);

commit;
```

---
```sql
# 과목 subject
create table subject (
	subject_cd varchar(10) COMMENT '과목코드',
	subject_name varchar(10) not null unique COMMENT '과목명',
	subject_desc text COMMENT '과목설명',
	professor_id INT unsigned not null COMMENT '교수아이디',
	create_dt TIMESTAMP not null default now() COMMENT '생성일자',
	modify_dt TIMESTAMP not null default now() COMMENT '수정일자',
	PRIMARY KEY(subject_cd),
	FOREIGN KEY (professor_id) REFERENCES professor(professor_id) ON UPDATE CASCADE
);

# 수강신청 enrolment
create table enrolment (
	enrolment_id INT UNSIGNED auto_increment COMMENT '수강신청아이디',
	semester varchar(10) not null COMMENT '학기',
	student_id INT unsigned not null COMMENT '학생아이디',
	subject_cd varchar(10) not null COMMENT '과목코드',
	create_dt TIMESTAMP not null default now() COMMENT '생성일자',
	modify_dt TIMESTAMP not null default now() COMMENT '수정일자',
	PRIMARY KEY(enrolment_id),
	FOREIGN KEY (student_id) REFERENCES student(student_id) ON UPDATE cascade,
	FOREIGN KEY (subject_cd) REFERENCES subject(subject_cd) ON UPDATE CASCADE
);

commit;
```

---
## 테이블 조회

```sql
# 생성할 테이블에 적용할 데이터베이스 선언
mysql> USE dbname;
```
```sql
# 데이터베이스안의 테이블들 조회 
SHOW TABLES;
```
```sql
# 테이블 정보 조회
mysql> desc mytable;
```

---
## 테이블 수정

```sql
# 테이블 수정 > 새로운 컬럼 추가
mysql> ALTER TABLE mytable ADD COLUMN new_column varchar(10) NOT NULL;
```
```sql
# 테이블 수정 > 컬럼 타입 변경
mysql> ALTER TABLE mytable MODIFY COLUMN modelnumber varchar(20) NOT NULL;
```
```sql
# 테이블 수정 > 컬럼 이름 변경
mysql> ALTER TABLE mytable CHANGE COLUMN modelnumber new_modelnumber varchar(10) NOT NULL;
```
```sql
# 테이블 수정 > 컬럼 삭제
mysql> ALTER TABLE mytable DROP COLUMN series;
```
```sql
# 테이블 삭제
mysql> DROP TABLE IF EXISTS mytable;
```



