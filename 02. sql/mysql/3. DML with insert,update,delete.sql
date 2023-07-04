###############################################
# 초기 세팅 
###############################################
# 1) https://www.mysqltutorial.org/how-to-load-sample-database-into-mysql-database-server.aspx
# -> mysqlsampledatabase.sql 다운로드 
# 2) > mysql -u root -p
# 3) myslq> source /Users/gyoungwon-cho/Downloads/mysqlsampledatabase.sql

# 데이터베이스들 조회 
show databases;

# classicmodels 데이터베이스 사용 
USE classicmodels;


###############################################
# 데이터 생성/수정/삭제 
###############################################

###### 테이블 생성 ######
CREATE TABLE mytable (
	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	modelnumber VARCHAR(15) NOT NULL,
	series VARCHAR(30) NOT NULL,
	PRIMARY KEY(id)
);

###### 생성한 테이블 확인 ###### 
desc mytable;
 
###### 데이터 조회 ######
select * from mytable;

###### 데이터 생성 ######
insert into mytable values(1, 'name1', '11111', '111');
select * from mytable;

# AUTO_INCREMENT인 경우는 자동으로 1식 증가 
insert into mytable(name, modelnumber, series) values('name1', '11111', '111');
select * from mytable;

insert into mytable values(5, 'name1', '11111', '111');
select * from mytable;

insert into mytable(name, modelnumber, series) values('name1', '11111', '111');
select * from mytable;


###### 데이터 수정 ######
update mytable set name = 'name2' where id = 2;
select * from mytable;

update mytable set modelnumber = '22222', series = '222' where id = 2;
select * from mytable;


###### 데이터 삭제 ######
delete from mytable where id = 5;
select * from mytable;

delete from mytable where id = 6;
select * from mytable;



###### 테이블 삭제 ######
drop table if exists mytable;


