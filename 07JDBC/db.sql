

create table emps (
	empno		number(8)	primary key,
	ename		varchar(20),
	job			varchar(20),
	mgr			number(8),
	hiredate	date,
	sal			number(11,2),
	comm		number(11,2),
	deptno		number(8)
);


create table emps (
	empno		int(8)	primary key,
	ename		varchar(20),
	job			varchar(20),
	mgr			int(8),
	hiredate	date,
	sal			double(11,2),
	comm		double(11,2),
	deptno		int(8)
);


create sequence emps_seq;

insert into emps values(emps_seq.nextval,'张三','领导',0,sysdate,18000.0,3000.0,1);
insert into emps values(emps_seq.nextval,'李四','销售',1,sysdate,7000.0,5000.0,1);
insert into emps values(emps_seq.nextval,'王五','销售',1,sysdate,8000.0,2000.0,1);
insert into emps values(emps_seq.nextval,'马六','市场',1,sysdate,6000.0,0,1);
insert into emps values(emps_seq.nextval,'周七','市场',1,sysdate,5000.0,0,1);
insert into emps values(emps_seq.nextval,'冯八','市场',1,sysdate,4000.0,0,1);
commit;




insert into emps values(1,'张三','领导',0,CURDATE(),18000.0,3000.0,1);
insert into emps values(2,'李四','市场',1,CURDATE(),7000.0,5000.0,1);
insert into emps values(3,'王五','市场',1,CURDATE(),8000.0,2000.0,1);
insert into emps values(4,'马六','市场',1,CURDATE(),6000.0,0,1);
insert into emps values(5,'周七','市场',1,CURDATE(),5000.0,0,1);
insert into emps values(6,'冯八','市场',1,CURDATE(),4000.0,0,1);


create table users(
  id number(8),
  username varchar2(30),
  password varchar2(30)
);

insert into users values(1,'tarena','123');
commit;


create table accounts (
	id varchar2(20),
	name varchar2(30),
	money number(11,2)
);

insert into accounts values('00001','张三',9000.0);
insert into accounts values('00002','李四',4000.0);
commit;

create table depts (
	deptno number(8)	primary key,
	dname varchar(20),
	loc varchar(100)
);

create sequence depts_seq;

insert into depts values(depts_seq.nextval,'销售部','北京');
insert into depts values(depts_seq.nextval,'市场部','上海');
insert into depts values(depts_seq.nextval,'开发部','广州');
commit;








