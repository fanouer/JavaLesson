作业1:
SELECT e.job
FROM emp e,dept d
WHERE e.deptno=d.deptno
AND d.dname='SALES'

SELECT job
FROM emp
WHERE deptno=(SELECT deptno
              FROM dept
              WHERE dname='SALES')
              
2:
SELECT m.ename FROM emp m
WHERE NOT EXISTS
(SELECT * FROM emp e 
 WHERE m.empno=e.mgr)

3:
SELECT ename,sal
FROM emp
WHERE sal > ANY(SELECT sal
                FROM emp
                WHERE ename='FORD')

4:
SELECT ename,deptno
FROM emp
WHERE deptno = (SELECT deptno
                FROM emp
                WHERE ename='FORD')
AND ename<>'FORD'

5:
SELECT COUNT(*),deptno
FROM emp
GROUP BY deptno
HAVING COUNT(*)>(SELECT COUNT(*)
                 FROM emp
                 WHERE deptno=20)

SELECT ename,deptno
FROM emp
WHERE deptno IN (SELECT deptno
                 FROM emp
                 GROUP BY deptno
                 HAVING AVG(sal)>2000)
                 
作业3
SELECT *
FROM(SELECT ROWNUM rn,t.*
     FROM (SELECT id,title,content,occurtime
           FROM news
           ORDER BY occurtime DESC) t
     WHERE ROWNUM<=10      
    )
WHERE rn >=6           

SELECT * FROM emp

作业6
1:
SELECT 
 id,sname,score,class_id,
 ROW_NUMBER() OVER(
   PARTITION BY class_id
   ORDER BY score DESC
 ) rank
FROM 
 student

2:
SELECT 
 id,sname,score,class_id,
 ROW_NUMBER() OVER(
   PARTITION BY class_id
   ORDER BY score DESC,sid
 ) rank
FROM 
 student

3:
SELECT 
 c.cname,s.sname,s.score,
 ROW_NUMBER() OVER(
  PARTITION BY class_id
  ORDER BY s.score DESC,s.sid
 ) rank
FROM 
 student s,class c
WHERE
 s.class_id=c.cid

4:
SELECT group_id,SUM(salary)
FROM mygroup
GROUP BY ROLLUP(group_id)

5:
SELECT group_id,job,SUM(salary)
FROM mygroup
GROUP BY CUBE(group_id,job)

6:
SELECT group_id,job,SUM(salary)
FROM mygroup
GROUP BY GROUPING SETS(group_id,job)

视图
视图也是数据库对象
视图在SQL语句中体现的样子是表的
样子，但是其并不是一张真实存在的
表，而是一个查询语句的结果集。
使用视图通常是为了重用子查询。

CREATE VIEW v_emp_10
AS
SELECT empno, ename, sal, deptno 
FROM emp 
WHERE deptno = 10;

SELECT * FROM v_emp_10

DESC v_emp_10

视图中对应的SELECT子句中的
字段可以使用别名，这样视图对应
的该字段的字段名就是别名了。
当SELECT中的字段是函数或者表达式
那么视图要求该字段必须给别名!

CREATE OR REPLACE VIEW v_emp_10
AS
SELECT empno id, ename name , 
       sal salary, deptno 
FROM emp 
WHERE deptno = 10;

SELECT * FROM v_emp_10

对视图进行DML操作，就是对视图数据
来源的基表进行的。
DML只能对简单视图进行，复杂视图不允许
进行DML操作。
向视图插入数据:
INSERT INTO v_emp_10
(id,name,salary,deptno)
VALUES
(1001,'JACK',5000,10)

SELECT * FROM v_emp_10
SELECT * FROM emp

INSERT INTO v_emp_10
(id,name,salary,deptno)
VALUES
(1002,'ROSE',5000,20)
上面的SQL是向视图插入了一条视图
看不到得数据到基表中，这种通过视图
插入但视图不可控的数据的操作时对
基表的"污染"
UPDATE语句也通常存在该问题，因为
修改视图上的数据就是修改基表的该数据
所以，有可能修改后的数据视图不在对其
可见。
UPDATE v_emp_10
SET name='JACKSON'
WHERE id=1001

SELECT * FROM v_emp_10
SELECT * FROM emp

UPDATE v_emp_10
SET deptno=20

              
DELETE FROM v_emp_10
WHERE deptno=20
              
             
为视图添加检查选项，避免通过
视图进行DML操作污染基表
CREATE OR REPLACE VIEW v_emp_10
AS
SELECT empno id, ename name , 
       sal salary, deptno 
FROM emp 
WHERE deptno = 10
WITH CHECK OPTION
当添加了检查选项后，该视图对DML
操作有要求:
插入数据时，必须保证插入的数据视图
可见。
修改数据时，必须保证修改后的数据视图
对其可见。
             
对视图添加只读选项，那么不允许对视图
进行DML操作
CREATE OR REPLACE VIEW v_emp_10
AS
SELECT empno id, ename name , 
       sal salary, deptno 
FROM emp 
WHERE deptno = 10
WITH READ ONLY      




创建一个记录每个部门薪水
情况的视图
CREATE VIEW v_emp_sal
AS
SELECT 
 d.deptno,d.dname,
 AVG(e.sal) avg_sal,
 SUM(e.sal) sum_sal,
 MIN(e.sal) min_sal,
 MAX(e.sal) max_sal
FROM emp e,dept d
WHERE  e.deptno=d.deptno
GROUP BY d.deptno,d.dname

SELECT * FROM v_emp_sal
查看哪些员工比自己所在部门
平均工资高?
SELECT e.ename,e.sal,e.deptno
FROM emp e,v_emp_sal v
WHERE e.deptno=v.deptno
AND e.sal>v.avg_sal

DELETE FROM v_emp_sal


序列也是数据库对象
它可以根据指定的规则生成一组数字
通常序列是为了某表的主键提供值。

CREATE SEQUENCE seq_emp_id
START WITH 1000
INCREMENT BY 1

序列支持两个伪列:
CURRVAL:获取序列当前值(最后一次生成的数)
NEXTVAL:获取序列下一个数字(当前值加步进)

序列是不可逆的，每当调用完NEXTVAL生成
新的数字后，序列不会再提供之前的数字。
CURRVAL可以调用多次，不会导致步进。

新创建的序列必须至少调用一次NEXTVAL后
才可以开始使用CURRVAL

SELECT seq_emp_id.NEXTVAL
FROM dual

SELECT seq_emp_id.CURRVAL
FROM dual

INSERT INTO emp
(empno,ename,sal,job,deptno)
VALUES
(seq_emp_id.NEXTVAL,'JACKSON',
 6000,'CLERK',20)

SELECT * FROM emp

DROP SEQUENCE seq_emp_id


UUID也是一种作为主键的生成算法
ORACLE提供了函数生成32位不重复字符串
SELECT sys_guid() FROM dual 

www.xxbbs.com/show?tid=F7E2B221399546DD9B1BA1BE8F66685C


唯一性约束
当一个字段使用了唯一性约束，那么该字段
在整张表中每条记录都不允许重复，NULL值
除外
CREATE TABLE employees1 (
eid NUMBER(6) UNIQUE,
name VARCHAR2(30),
email VARCHAR2(50),
salary NUMBER(7, 2),
hiredate DATE,
CONSTRAINT employees_email_uk UNIQUE(email)
 );

INSERT INTO employees1
(eid,name,email)
VALUES
(NULL,'JACK',NULL)

SELECT * FROM employees1










主键约束:
CREATE TABLE employees2 (
eid NUMBER(6) PRIMARY KEY,
name VARCHAR2(30),
email VARCHAR2(50),
salary NUMBER(7, 2),
hiredate DATE
);

INSERT INTO employees2
(eid,name)
VALUES
(NULL,'JACK')






             
             
             
              
              
              
              