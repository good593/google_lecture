###############################################
# 데이터베이스 
###############################################

# 데이터베이스 생성
CREATE database dbname;

# 데이터베이스 목록 보기 
show databases;

# dbname 데이터베이스 사용 
use dbname;

# dbname 데이터베이스 삭제 
drop database if exists dbname;



###############################################
# 테이블 
###############################################

# 테이블에 적용할 데이터베이스 선언
use dbname;

# 테이블 생성
CREATE TABLE mytable (
	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	modelnumber VARCHAR(15) NOT NULL,
	series VARCHAR(30) NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE newtable (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name CHAR(20) NOT NULL,
    age TINYINT,
    phone VARCHAR(20),
    email VARCHAR(30) NOT NULL,
    address VARCHAR(50),
    PRIMARY KEY(id)
);

# 데이터베이스안의 테이블들 조회  
show tables;

# 테이블 정보 조회 
desc mytable;

desc newtable;


# 새로운 컬럼 추가 
ALTER TABLE mytable ADD COLUMN new_column varchar(10) NOT NULL;
# 결과 확인 
desc mytable;

# 컬럼 타입 변경 
ALTER TABLE mytable MODIFY COLUMN modelnumber varchar(20) NOT NULL;
# 결과 확인 
desc mytable;

# 컬럼 이름 변경 
ALTER TABLE mytable CHANGE COLUMN modelnumber new_modelnumber varchar(10) NOT NULL;
# 결과 확인 
desc mytable;

# 컬럼 삭제 
ALTER TABLE mytable DROP COLUMN series;
# 결과 확인 
desc mytable;

# 테이블 삭제 
DROP TABLE IF EXISTS mytable;
# 결과 확인 
show tables;







