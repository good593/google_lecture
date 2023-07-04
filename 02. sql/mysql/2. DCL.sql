###############################################
# 사용자 계정  
###############################################

# 사용자 확인 
use mysql;
select * from user;

# 로컬에서만 접속 가능한 localid 생성 
create user 'localid'@localhost identified by '111111111';
# 결과 확인 
select * from user;

# 모든 호스트에서 접속 가능한 allid 생성 
create user 'allid'@'%' identified by '222222222';
# 결과 확인 
select * from user;

# 사용자 비밀번호 변경  
set password for 'allid'@'%' = '333333333';
# 결과 확인 
select * from user;

# 사용자 삭제 
drop user 'localid'@localhost;
# 결과 확인 
select * from user;


###############################################
# 사용자 권한   
###############################################

use mysql;

# classicmodels에만 권한 부여  
grant all privileges on classicmodels.* to 'allid'@'%';
# grant table reload
FLUSH PRIVILEGES;
# 결과 확인 
select * from user;

# select만 권한 부여 
grant select on classicmodels.* to 'allid'@'%';
# grant table reload
FLUSH PRIVILEGES;
# 결과 확인 
select * from user;

# select만 권한 부여 
grant select,insert on classicmodels.* to 'allid'@'%';
# grant table reload
FLUSH PRIVILEGES;
# 결과 확인 
select * from user;








