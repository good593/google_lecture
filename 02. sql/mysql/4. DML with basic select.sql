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


###### 데이터 조회 ######
select * from customers;
select customerNumber, customerName, phone from customers;
select customerNumber as cust_no, customerName as cust_nm, phone from customers; # as를 이용하면 컬럼의 별칭을 쓸 수 있다.

select * from employees e; # e: emplyees 테이블의 별칭이다.
select e.employeeNumber, e.email, e.jobTitle from employees e;
select e.employeeNumber as emp_nm, e.email as emp_email, e.jobTitle as emp_jobtitle from employees e;

###### 데이터 조회 & 정렬 ######
select * from offices o;
select * from offices o order by officeCode desc;
select * from offices o order by country, city asc;

###### 데이터 조회 결과 중 일부만 조회 ######
select * from orderdetails o2 ;
select * from orderdetails o2 limit 10;
select * from orderdetails o2 limit 20, 10;
select * from orderdetails o2 order by orderLineNumber desc limit 20, 10;

###### 조건을 이용하여 데이터 조회 ######
select 
	orderNumber 
	, productCode 
	, quantityOrdered 
	, orderLineNumber 
from orderdetails o2 
where 1=1
	and productCode = 'S18_3278' 
order by orderLineNumber desc 
limit 20, 10;

select * from orders o
where 1=1
	and status = 'Shipped'
	and comments is not null;

select * from products p
where 1=1
	and (productLine = 'Motorcycles' or productLine = 'Trucks and Buses')
	and quantityInStock >= 1000
	and buyPrice <= 50;

select * from products p 
where 1=1 
	and productDescription like 'This%';

select * from products p 
where 1=1 
	and productDescription like 'This%' 
	and productDescription like '%scale%';

###### 그룹화하여 데이터 조회 ######
# group by: 틀정 컬럼을 기준으로 그룹화 
# having: 특정 컬럼을 그룹화한 결과에 조건 적용 
show tables;
select * from payments p;

select DISTINCT customerNumber from payments p;
select customerNumber from payments p group by customerNumber;

select 
	customerNumber 
	, count(*) as cnt 
	, sum(amount) as amount_sum 
	, avg(amount) as amount_avg
	, min(amount) as amount_min
	, max(amount) as amount_max
from payments p
where 1=1 
group by customerNumber;

select 
	customerNumber 
	, count(*) as cnt 
	, sum(amount) as amount_sum 
	, avg(amount) as amount_avg
	, min(amount) as amount_min
	, max(amount) as amount_max
from payments p
where 1=1 
	and amount > 5000
	and amount < 10000
group by customerNumber;

select 
	customerNumber 
	, count(*) as cnt 
	, sum(amount) as amount_sum 
	, avg(amount) as amount_avg
	, min(amount) as amount_min
	, max(amount) as amount_max
from payments p
where 1=1 
group by customerNumber
having 1=1 
	and cnt > 2
	and amount_avg > 20000
order by amount_sum DESC
;
