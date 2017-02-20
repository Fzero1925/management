
-- 创建表空间
create tablespace management 
datafile 'management.dbf' 
size 10m -- 数据文件初始大小
autoextend on -- 表空间容量不足时自动扩展
next 5m -- 表空间每扩展一次增加5m
;

-- 创建员工表，先查看user_objects表中是否存在相同名称的表，如果有就删除
prompt create table staff 员工信息表...
declare 
	rowcount number(10);
begin 
	select count(*) into rowcount from dual where exists(
		select * from user_objects where object_name = upper('staff')
	);
	if rowcount = 1 then
		execute immediate 'drop table staff';
	end if;
end;
/


create table staff(
	id number(12,0) not null primary key,
	name nvarchar2(125),
	gender nvarchar2(10),
	job nvarchar2(20),
	salary number(12,0),
	department varchar2(20),
	email nvarchar2(125),
	regdate date
) tablespace management;

-- 创建序列，实现自增主键功能
-- 使用方法：在执行insert语句的时候，在主键的值中调用序列的nextval方法，即management_primary_key.nextval
create SEQUENCE staff_seq start with 1 increment by 1 minvalue 1;

-- 插入员工测试数据
insert into staff(id,name,gender,job,salary,email,regdate)
	values(staff_seq.nextval,'小明','男','Java',2500,'xiaoming@gmail.com',sysdate);
insert into staff(id,name,gender,job,salary,email,regdate)
	values(staff_seq.nextval,'小花','女','美工',2000,'xiaohua@gmail.com',sysdate);
insert into staff(id,name,gender,job,salary,email,regdate)
	values(staff_seq.nextval,'小红','女','前端',3000,'xiaohong@gmail.com',add_months(sysdate,-6));
insert into staff(id,name,gender,job,salary,email,regdate)
	values(staff_seq.nextval,'小王','男','PHP',2500,'xiaowang@gmail.com',add_months(sysdate,-3));
insert into staff(id,name,gender,job,salary,email,regdate)
	values(staff_seq.nextval,'小张','男','产品',4000,'xiaozhang@gmail.com',add_months(sysdate,-12));

-- 删除操作
drop table staff;
drop sequence staff_seq;


-- 创建部门表


-- 创建职位表，先查看user_objects表中是否存在相同名称的表，如果有就删除
prompt create table position 职位表...
declare 
	rowcount number(10);
begin 
	select count(*) into rowcount from dual where exists(
		select * from user_objects where object_name = upper('positon')
	);
	if rowcount = 1 then
		execute immediate 'drop table position';
	end if;
end;
/

create table position(
	id number(10) not null primary key,
	job varchar2(20) not null
)tablespace management;

-- 创建职位表的自增序列
create SEQUENCE position_seq start with 1 increment by 1;

-- 插入职位表数据
insert into position(id,job) values(position_seq.nextval,'Java');
insert into position(id,job) values(position_seq.nextval,'PHP');
insert into position(id,job) values(position_seq.nextval,'美工');
insert into position(id,job) values(position_seq.nextval,'前端');
insert into position(id,job) values(position_seq.nextval,'产品');


-- 创建登录用户信息表
prompt create table management_login 登录用户信息表...

declare 
	rowcount number(10);
begin
	select count(*) into rowcount from dual where exists(
		select * from user_objects where object_name = upper('manage_login')
	);
	if rowcount = 1 then
		execute immediate 'drop table manage_login';
	end if;
end;
/

create table manage_login(
	id number(12) not null primary key,
	username varchar2(100) not null,
	password varchar2(100)
)tablespace management;

-- 创建登录用户信息表自增主键序列
create SEQUENCE mlogin_seq start with 1 increment by 1;

-- 插入登录用户信息数据
insert into manage_login(id,username,password)
	values(mlogin_seq.nextval,'admin','admin');
insert into manage_login(id,username,password)
	values(mlogin_seq.nextval,'fzero','fzero1925');
insert into manage_login(id,username,password)
	values(mlogin_seq.nextval,'小王','xiaowang');
	
-- 删除操作
drop table manage_login;
drop sequence mlogin_seq;


-- 删除表空间
drop tablespace management including contents;-- including contents表示同时删除表空间内的所有数据文件