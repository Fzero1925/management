
-- 创建表空间
create tablespace management 
datafile 'management.dbf' 
size 10m -- 数据文件初始大小
autoextend on -- 表空间容量不足时自动扩展
next 5m -- 表空间每扩展一次增加5m
;

-- 创建员工表
create table staff(
	id number(12,0) not null primary key,
	name varchar2(125),
	gender number(1,0),
	job varchar2(20),
	salary number(12,0),
	department varchar2(20),
	email varchar2(125),
	regdate date 	
) tablespace management;

-- 创建序列，实现自增主键功能
create SEQUENCE management_primary_key start with 1 increment by 1;
-- 使用方法：在执行insert语句的时候，在主键的值中调用序列的nextval方法，即management_primary_key.nextval

-- 创建部门表


-- 创建职位表
create table position(
	id number(10) not null primary key,
	job varchar2(20) not null,
	
)tablespace management;


-- 删除表空间
drop tablespace management including contents;-- including contents表示同时删除表空间内的所有数据文件