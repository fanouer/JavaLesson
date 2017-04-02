��ҵ1:
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
                 
��ҵ3
SELECT *
FROM(SELECT ROWNUM rn,t.*
     FROM (SELECT id,title,content,occurtime
           FROM news
           ORDER BY occurtime DESC) t
     WHERE ROWNUM<=10      
    )
WHERE rn >=6           

SELECT * FROM emp

��ҵ6
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

��ͼ
��ͼҲ�����ݿ����
��ͼ��SQL��������ֵ������Ǳ��
���ӣ������䲢����һ����ʵ���ڵ�
������һ����ѯ���Ľ������
ʹ����ͼͨ����Ϊ�������Ӳ�ѯ��

CREATE VIEW v_emp_10
AS
SELECT empno, ename, sal, deptno 
FROM emp 
WHERE deptno = 10;

SELECT * FROM v_emp_10

DESC v_emp_10

��ͼ�ж�Ӧ��SELECT�Ӿ��е�
�ֶο���ʹ�ñ�����������ͼ��Ӧ
�ĸ��ֶε��ֶ������Ǳ����ˡ�
��SELECT�е��ֶ��Ǻ������߱��ʽ
��ô��ͼҪ����ֶα��������!

CREATE OR REPLACE VIEW v_emp_10
AS
SELECT empno id, ename name , 
       sal salary, deptno 
FROM emp 
WHERE deptno = 10;

SELECT * FROM v_emp_10

����ͼ����DML���������Ƕ���ͼ����
��Դ�Ļ�����еġ�
DMLֻ�ܶԼ���ͼ���У�������ͼ������
����DML������
����ͼ��������:
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
�����SQL������ͼ������һ����ͼ
�����������ݵ������У�����ͨ����ͼ
���뵫��ͼ���ɿص����ݵĲ���ʱ��
�����"��Ⱦ"
UPDATE���Ҳͨ�����ڸ����⣬��Ϊ
�޸���ͼ�ϵ����ݾ����޸Ļ���ĸ�����
���ԣ��п����޸ĺ��������ͼ���ڶ���
�ɼ���
UPDATE v_emp_10
SET name='JACKSON'
WHERE id=1001

SELECT * FROM v_emp_10
SELECT * FROM emp

UPDATE v_emp_10
SET deptno=20

              
DELETE FROM v_emp_10
WHERE deptno=20
              
             
Ϊ��ͼ��Ӽ��ѡ�����ͨ��
��ͼ����DML������Ⱦ����
CREATE OR REPLACE VIEW v_emp_10
AS
SELECT empno id, ename name , 
       sal salary, deptno 
FROM emp 
WHERE deptno = 10
WITH CHECK OPTION
������˼��ѡ��󣬸���ͼ��DML
������Ҫ��:
��������ʱ�����뱣֤�����������ͼ
�ɼ���
�޸�����ʱ�����뱣֤�޸ĺ��������ͼ
����ɼ���
             
����ͼ���ֻ��ѡ���ô���������ͼ
����DML����
CREATE OR REPLACE VIEW v_emp_10
AS
SELECT empno id, ename name , 
       sal salary, deptno 
FROM emp 
WHERE deptno = 10
WITH READ ONLY      




����һ����¼ÿ������нˮ
�������ͼ
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
�鿴��ЩԱ�����Լ����ڲ���
ƽ�����ʸ�?
SELECT e.ename,e.sal,e.deptno
FROM emp e,v_emp_sal v
WHERE e.deptno=v.deptno
AND e.sal>v.avg_sal

DELETE FROM v_emp_sal


����Ҳ�����ݿ����
�����Ը���ָ���Ĺ�������һ������
ͨ��������Ϊ��ĳ��������ṩֵ��

CREATE SEQUENCE seq_emp_id
START WITH 1000
INCREMENT BY 1

����֧������α��:
CURRVAL:��ȡ���е�ǰֵ(���һ�����ɵ���)
NEXTVAL:��ȡ������һ������(��ǰֵ�Ӳ���)

�����ǲ�����ģ�ÿ��������NEXTVAL����
�µ����ֺ����в������ṩ֮ǰ�����֡�
CURRVAL���Ե��ö�Σ����ᵼ�²�����

�´��������б������ٵ���һ��NEXTVAL��
�ſ��Կ�ʼʹ��CURRVAL

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


UUIDҲ��һ����Ϊ�����������㷨
ORACLE�ṩ�˺�������32λ���ظ��ַ���
SELECT sys_guid() FROM dual 

www.xxbbs.com/show?tid=F7E2B221399546DD9B1BA1BE8F66685C


Ψһ��Լ��
��һ���ֶ�ʹ����Ψһ��Լ������ô���ֶ�
�����ű���ÿ����¼���������ظ���NULLֵ
����
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










����Լ��:
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






             
             
             
              
              
              
              