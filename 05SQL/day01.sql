SQL语句本身不区分大小写，但是
在实际工作中有一种约定俗成的格式
要求，关键字与非关键字通常使用大小
写区分开来增加可读性。
SELECT SYSDATE FROM dual

创建表的SQL
CREATE TABLE employee(
	id NUMBER(4),
	name VARCHAR2(20),
	gender CHAR(1),
	birth DATE,
  salary NUMBER(6,2),
  job VARCHAR2(30),
  deptno NUMBER(2)
);

查看表结构:
DESC table_name

DESC employee

删除表
DROP TABLE table_name

DROP TABLE employee


字段默认值
在数据库中，所有数据类型默认值都是NULL。
可以在创建表的时候为指定的字段设置一个
默认值，那么当插入一条记录时该字段没有
给值时，会将指定的默认值插入当前字段。
CREATE TABLE employee(
	id NUMBER(4),
	name VARCHAR2(20),
	gender CHAR(1) DEFAULT 'M',
	birth DATE,
  salary NUMBER(6,2),
  job VARCHAR2(30),
  deptno NUMBER(2)
);

在SQL语句中字符串字面量使用单引号，
并且字符串区分大小写!


NOT NULL约束
当一个字段被NOT NULL修饰后，该字段
的值不允许为空。
DROP TABLE employee
CREATE TABLE employee(
	id NUMBER(4),
	name VARCHAR2(20) NOT NULL,
	gender CHAR(1) DEFAULT 'M',
	birth DATE,
  salary NUMBER(6,2),
  job VARCHAR2(30),
  deptno NUMBER(2)
);
DESC employee

修改表名:
RENAME old_name TO new_name

RENAME employee TO myemp

DESC myemp

修改表结构
1:添加新字段
需要注意，新添加的字段只能被追加到
表的末尾，不能在现有字段中间插入新
字段
ALTER TABLE myemp
ADD(
  hiredate DATE DEFAULT SYSDATE
)
DESC myemp

2:删除现有字段
ALTER TABLE myemp
DROP(hiredate)

3:修改现有字段
修改表中现有字段可以修改字段的类型
长度。
但是表中若含有数据时，建议不要修改
类型，若修改长度也尽可能扩大而不是
缩小，否则可能因为违反现有表中数据
的实际要求而失败。
ALTER TABLE myemp
MODIFY(
 job VARCHAR2(40) DEFAULT 'CLERK'
)

DESC myemp



DML语句
1：插入操作
INSERT INTO myemp
(id,name,job,salary)
VALUES
(1,'rose','CLERK',5000)

SELECT * FROM myemp

若不指定字段，则是全字段插入
INSERT INTO myemp
VALUES
(2,'JACK','M',SYSDATE,4000,'CLERK',20)

插入日期:
可以直接插入字符串，但是该字符串的格式
必须按照"DD-MON-RR"的形式，由于有语言
差异，建议使用TO_DATE函数来实现
INSERT INTO myemp 
(id, name, job,birth) 
VALUES
(1003, 'donna', 'MANAGER', 
 TO_DATE('2009-09-01',
         'YYYY-MM-DD')
);

修改表中数据:
UPDATE myemp
SET salary=7000,job='MANAGER'
WHERE name='rose'

UPDATE语句通常都需要使用WHERE
子句来添加限定条件，这样只会将
满足条件的记录进行修改。若不添加
WHERE则是整张表所有数据修改。


SELECT * FROM myemp

删除数据:
DELETE FROM myemp
WHERE name='JACK'

删除表中数据也要注意添加WHERE
子句，否则是清空表操作。

清除表操作:
--删除全部记录
 DELETE FROM myemp;
--或者
TRUNCATE  TABLE myemp;
select *from myemp;





























