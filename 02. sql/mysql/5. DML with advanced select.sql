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
# 데이터 조회 
###############################################

###### 테이블들 조회 ######
show tables;

select 
	orderNumber 
	, orderDate 
	, requiredDate 
	, shippedDate 
	, status 
	, comments 
	, customerNumber 
from orders t1;

select 
	orderNumber 
	, productCode 
	, quantityOrdered 
	, priceEach 
	, orderLineNumber 
from orderdetails t2;


###### left join ######
select 
	t1.orderNumber 
	, t1.orderDate 
	, t1.status 
	, t1.comments
	, t2.productCode 
	, t2.quantityOrdered 
	, t2.priceEach 
from orders t1
left join orderdetails t2
	on t1.orderNumber = t2.orderNumber
;

select 
	t1.orderNumber 
	, t1.orderDate 
	, t1.status 
	, t1.comments
	, t2.productCode 
	, t2.quantityOrdered 
	, t2.priceEach 
from orders t1
left join orderdetails t2
	on t1.orderNumber = t2.orderNumber
where 1=1
	and t1.comments is not null
	and t2.priceEach >= 50
;

select 
	t1.orderNumber 
	, t1.status  
	, sum(t2.quantityOrdered) as quantity_sum
	, avg(t2.priceEach) as price_avg
from orders t1
left join orderdetails t2
	on t1.orderNumber = t2.orderNumber
where 1=1
	and t1.comments is not null
	and t2.priceEach >= 50
group by orderNumber, status
;

select 
	t1.orderNumber 
	, t1.status  
	, sum(t2.quantityOrdered) as quantity_sum
	, avg(t2.priceEach) as price_avg
from orders t1
left join orderdetails t2
	on t1.orderNumber = t2.orderNumber
where 1=1
	and t1.comments is not null
	and t2.priceEach >= 50
group by orderNumber, status
HAVING 1=1
	and quantity_sum > 50
order by price_avg DESC
;


###### inner join ######
show tables;

desc offices;
select * from offices;
-- insert into offices(officeCode, city, phone, addressLine1, country, postalCode, territory) values('8', 'seoul', '+82 11 222 3333', '1-11 seoul', 'Korea', '000-0000', 'KOR');
-- insert into offices(officeCode, city, phone, addressLine1, country, postalCode, territory) values('9', 'incheon', '+82 11 222 3333', '1-11 seoul', 'Korea', '000-0000', 'KOR');
-- insert into offices(officeCode, city, phone, addressLine1, country, postalCode, territory) values('10', 'busan', '+82 11 222 3333', '1-11 seoul', 'Korea', '000-0000', 'KOR');
select * from employees;

# 26 -> seoul, incheon, busan 데이터 포함 
select 
	count(*) 
from offices t1
left join employees t2
	on t1.officeCode  = t2.officeCode
where 1=1
;
# 23 -> seoul, incheon, busan 데이터는 제외
select 
	count(*) 
from offices t1
inner join employees t2
	on t1.officeCode  = t2.officeCode
where 1=1
;

select 
	t1.*
from offices t1
inner join employees t2
	on t1.officeCode  = t2.officeCode
where 1=1
;


###### full outer join ######
# mysql에서는 full outer join이 없다.  
# 그래서 left join, right join, union을 이용하여 구현해야 한다.  

select 
	t1.officeCode 
	, t1.city 
	, t2.email 
	, t2.jobTitle 
from offices t1
left join employees t2
	on t1.officeCode  = t2.officeCode
where 1=1
union 
select 
	t1.officeCode 
	, t1.city 
	, t2.email 
	, t2.jobTitle 
from offices t1
right join employees t2
	on t1.officeCode  = t2.officeCode
where 1=1
;

select 
	tt1.* 
from (
	select 
		t1.officeCode 
		, t1.city 
		, t2.email 
		, t2.jobTitle 
	from offices t1
	left join employees t2
		on t1.officeCode  = t2.officeCode
	where 1=1
	union 
	select 
		t1.officeCode 
		, t1.city 
		, t2.email 
		, t2.jobTitle 
	from offices t1
	right join employees t2
		on t1.officeCode  = t2.officeCode
	where 1=1
) tt1
where 1=1
	and tt1.officeCode > 5
order by tt1.city ASC
;






