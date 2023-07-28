# 데이터베이스 생성 
create database django_db;
show databases;

# 사용자 계정 생성
use mysql;

create user 'django_root'@localhost identified by 'django_root1!';
select * from user;

# 사용자 권한 부여 
grant all privileges on django_db.* to 'django_root'@localhost;
flush privileges; # 새로운(수정된) 권한 적용 

# 사용자 계정 삭제 
drop user 'django_root'@localhost;
select * from user;

# 데이터베이스 삭제 
drop database if exists django_db;
show databases;