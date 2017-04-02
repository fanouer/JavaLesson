��ҵ1:
1:
SELECT ename,deptno
FROM emp
WHERE deptno IN (20,30)

2:
SELECT ename,job
FROM emp
WHERE mgr IS NULL
ORDER BY job

3:
SELECT ename,sal,comm
FROM emp
WHERE comm IS NOT NULL
ORDER BY sal DESC

4:
SELECT ename
FROM emp
WHERE ename LIKE '__A%'

5:
SELECT 
 ename||','||job||','||sal out_put
FROM 
 emp

6:
SELECT 
 empno,ename,sal,sal*1.2
FROM
 emp
 
7:
SELECT ename,sal
FROM emp
WHERE sal>1200
ORDER BY hiredate
 
8:
SELECT deptno,dname,loc
FROM dept
WHERE dname <> 'ACCOUNT'

��ҵ2:
1:
SELECT MAX(sal),job,deptno
FROM emp
GROUP BY job,deptno

3:
SELECT e.ename,e.sal,
       m.ename,m.sal
FROM emp e,emp m
WHERE e.mgr=m.empno
AND e.sal>m.sal

��ҵ��
2:
SELECT MAX(score)
FROM student
GROUP BY classid,subject


��ҵ��
2:
SELECT name
FROM student
GROUP BY name
HAVING MIN(fenshu)>80


SELECT ename,job,sal
FROM emp


�Ӳ�ѯ:
�Ӳ�ѯ��һ����ѯ��䣬��Ƕ��������
SQL���֮�У�Ϊ��Ƕ�׵�SQL����ṩ
�����Ա�ִ��ʹ�á�

�鿴��CLARK���ʸߵ�Ա����
SELECT ename,sal
FROM emp
WHERE sal>(SELECT sal
           FROM emp
           WHERE ename='CLARK')

�鿴��FORD��ͬ���ŵ�Ա��?
SELECT ename,deptno
FROM emp
WHERE deptno=(SELECT deptno
              FROM emp
              WHERE ename='FORD')

�鿴�ȹ�˾ƽ�����ʸߵ�Ա����Ϣ?
SELECT ename,sal
FROM emp
WHERE sal>(SELECT AVG(sal)
           FROM emp)

DDL��ʹ���Ӳ�ѯ
����һ�ű�myemployee��
����empno,ename,sal,job,
deptno,dname,loc�ֶΣ�����
������emp��deptһ��

�Ӳ�ѯ������:���Ӳ�ѯ�Ľ����
��Ϊһ�ű���������
CREATE TABLE myemployee
AS
SELECT 
 e.empno,e.ename,e.sal,
 e.job,d.deptno,d.dname,
 d.loc
FROM 
 emp e,dept d
WHERE
 e.deptno=d.deptno
      
DML��Ҳ����ʹ���Ӳ�ѯ
ɾ����FORDͬ���ŵ�����Ա��
DELETE FROM emp
WHERE deptno=(SELECT deptno
              FROM emp
              WHERE ename='FORD')
SELECT * FROM emp

�鿴��20�Ų���ְλ��ͬ��Ա����Ϣ?
SELECT ename,job
FROM emp
WHERE job IN(SELECT job
             FROM emp
             WHERE deptno=20)

�鿴��ְλ��CLERK�Ĺ���
���ߵ�Ա����Ϣ?
SELECT ename,sal
FROM emp
WHERE sal>ALL(SELECT sal
              FROM emp
              WHERE job='CLERK')

EXISTS�ؼ���
����WHERE�Ӿ䣬EXISTS�ؼ��ֺ���
��һ���Ӳ�ѯ��ֻҪ�ò�ѯ�ܲ�ѯ��
����һ����¼����ô�ͷ���TRUE
SELECT deptno, dname FROM dept d
WHERE 
 EXISTS(SELECT * FROM emp e
        WHERE d.deptno=e.deptno
        );

�鿴��Щ���Ǳ��˵��쵼?
SELECT m.ename FROM emp m
WHERE EXISTS(SELECT * FROM emp e
             WHERE m.empno=e.mgr)


�鿴�����ŵ����нˮ��ǰ���Ǳ�
20�Ų��ŵ����нˮ�ߣ�
SELECT MIN(sal),deptno
FROM emp
GROUP BY deptno
HAVING MIN(sal)>(SELECT MIN(sal)
                 FROM emp
                 WHERE deptno=20)

�鿴˭���Լ����ڲ���ƽ�����ʸ�?
SELECT e.ename,e.sal,e.deptno
FROM emp e,(SELECT AVG(sal) avg_sal,
                   deptno
            FROM emp
            GROUP BY deptno) s
WHERE e.deptno=s.deptno
AND e.sal>s.avg_sal





SELECT 
  e.ename, e.sal, 
  (SELECT d.dname FROM dept d 
   WHERE d.deptno = e.deptno) dname
FROM emp e;

��ҳ��ѯ
����ѯ�������Ӵ�ʱ��ͨ���Ὣ
����"�ֶβ�ѯ����"������������
�����ڴ濪���������Ӧ�ٶȡ�

���ڱ�׼SQL��û�й涨��ҳ���﷨��
���Բ�ͬ���ݿ���Է�ҳ�Ĳ�����
��һ���ġ�

��ORACLE�з�ҳ�ǻ���α��ROWNUM
ʵ�ֵ�
ROWNUM���������κ�һ�ű��У�����
ÿ�ű����Բ�ѯ���У����е�ֵ��Ϊ
��ѯ������ÿһ����¼���һ���кš�
ROWNUM��ֵ����������1��ʼ��ֻҪ����
�ӱ��в�ѯ��һ����¼���ͻ�Ϊ���ţ�
Ȼ��������

SELECT ROWNUM,ename,sal,
       job,deptno
FROM emp

�鿴�������Ժ������?
SELECT ROWNUM,ename,sal,
       job,deptno
FROM emp
WHERE ROWNUM > 1
��ʹ��ROWNUM�Խ�������кŵ�
�����У���Ӧ��ʹ��WHERE����
ROWNUN>1���ϵ����ֽ��й��ˣ�
����ò����κν����

�鿴5-10����¼
SELECT *
FROM(SELECT ROWNUM rn,ename,sal,
            job,deptno
     FROM emp) t
WHERE rn BETWEEN 5 AND 10

�鿴��˾����������5-10��
SELECT *
FROM(SELECT ROWNUM rn,t.*
     FROM(SELECT ename,sal,
                 job,deptno
          FROM emp
          ORDER BY sal DESC) t)
WHERE rn BETWEEN 6 AND 10
page(ҳ��) pageSize(ÿҳ����Ŀ��)
star= (page-1)*pageSize+1
end = pagSize*page


DECODE��������ʵ�ַ�֧

SELECT ename, job, sal,
     DECODE(job,  
            'MANAGER', sal * 1.2,
            'ANALYST', sal * 1.1,
            'SALESMAN', sal * 1.05,
            sal
     ) bonus
FROM emp;


ͳ�ƹ�˾��:MANAGER��ANALYST
һ�������ˣ�����ְλ��������?
SELECT 
 COUNT(*),DECODE(job,
           'MANAGER','VIP',
           'ANALYST','VIP',
           'OTHER')
FROM emp
GROUP BY DECODE(job,
           'MANAGER','VIP',
           'ANALYST','VIP',
           'OTHER')

������
�������������Ǹ���ָ�����ֶ�
���飬Ȼ���ٰ���ָ�����ֶ������
����һ�����ڼ�¼�ı��

ROW_NUMBER������������������
Ψһ�����֡�
�鿴ÿ�����ŵĹ�������?
SELECT 
 ename,sal,deptno,
 ROW_NUMBER() OVER(
  PARTITION BY deptno
  ORDER BY sal DESC
 ) rank
FROM 
 emp


RANK����
�������ڲ�������Ψһ������
SELECT 
 ename,sal,deptno,
 RANK() OVER(
  PARTITION BY deptno
  ORDER BY sal DESC
 ) rank
FROM 
 emp

DENSE_RANK
����������������Ψһ������
SELECT 
 ename,sal,deptno,
 DENSE_RANK() OVER(
  PARTITION BY deptno
  ORDER BY sal DESC
 ) rank
FROM 
 emp

SELECT year_id,month_id,day_id,sales_value
FROM sales_tab
ORDER BY year_id,month_id,day_id


�鿴ÿ��Ӫҵ��?
SELECT year_id,month_id,
       day_id,SUM(sales_value)
FROM sales_tab
GROUP BY year_id,month_id,day_id
ORDER BY year_id,month_id,day_id

�鿴ÿ��Ӫҵ��?
SELECT year_id,month_id,
       SUM(sales_value)
FROM sales_tab
GROUP BY year_id,month_id
ORDER BY year_id,month_id

�鿴ÿ��Ӫҵ��?
SELECT year_id,SUM(sales_value)
FROM sales_tab
GROUP BY year_id
ORDER BY year_id

�����������Ӫҵ��?
SELECT SUM(sales_value)
FROM sales_tab

�߼����麯��
ROLLUP()
ROLLUP��������ʹ����GROUP BY
�Ӿ��У�ROLLUP�����Ĳ���������
�������ROLLUP����ݲ��������
���ķ�ʽ�ֱ���з��飬Ȼ������
����Ľ������һ�����������ʾ

GROUP BY ROLLUP(a,b,c)

GROUP BY a,b,c
UNION ALL
GROUP BY a,b
UNION ALL
GROUP BY a
UNION ALL
ȫ��

SELECT year_id,month_id,
       day_id,SUM(sales_value)
FROM sales_tab
GROUP BY 
 ROLLUP(year_id,month_id,day_id)
ORDER BY year_id,month_id,day_id


GROUP BY CUBE(a,b,c)
a,b,c
a,b,
a,c
b,c
a
b
c
ȫ��

SELECT year_id,month_id,
       day_id,SUM(sales_value)
FROM sales_tab
GROUP BY 
 CUBE(year_id,month_id,day_id)
ORDER BY year_id,month_id,day_id

�鿴ÿ���ÿ�µ����۶�?
GROUPING SETS()
�ø߼����麯���������ǰ����Զ����
���鷽ʽ����ͳ�ƣ��ٽ����ǲ���һ��
�������ʾ
SELECT year_id,month_id,
       day_id,SUM(sales_value)
FROM sales_tab
GROUP BY 
 GROUPING SETS(
   (year_id,month_id,day_id),
   (year_id,month_id)
 )
ORDER BY year_id,month_id,day_id








