作业1:
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

作业2:
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

作业三
2:
SELECT MAX(score)
FROM student
GROUP BY classid,subject


作业四
2:
SELECT name
FROM student
GROUP BY name
HAVING MIN(fenshu)>80


SELECT ename,job,sal
FROM emp


子查询:
子查询是一条查询语句，其嵌套在其他
SQL语句之中，为其嵌套的SQL语句提供
数据以便执行使用。

查看比CLARK工资高的员工？
SELECT ename,sal
FROM emp
WHERE sal>(SELECT sal
           FROM emp
           WHERE ename='CLARK')

查看和FORD相同部门的员工?
SELECT ename,deptno
FROM emp
WHERE deptno=(SELECT deptno
              FROM emp
              WHERE ename='FORD')

查看比公司平均工资高的员工信息?
SELECT ename,sal
FROM emp
WHERE sal>(SELECT AVG(sal)
           FROM emp)

DDL中使用子查询
创建一张表myemployee，
包含empno,ename,sal,job,
deptno,dname,loc字段，并且
数据与emp和dept一致

子查询创建表:将子查询的结果集
作为一张表创建出来。
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
      
DML中也可以使用子查询
删除与FORD同部门的所有员工
DELETE FROM emp
WHERE deptno=(SELECT deptno
              FROM emp
              WHERE ename='FORD')
SELECT * FROM emp

查看与20号部门职位相同的员工信息?
SELECT ename,job
FROM emp
WHERE job IN(SELECT job
             FROM emp
             WHERE deptno=20)

查看比职位是CLERK的工资
都高的员工信息?
SELECT ename,sal
FROM emp
WHERE sal>ALL(SELECT sal
              FROM emp
              WHERE job='CLERK')

EXISTS关键字
用于WHERE子句，EXISTS关键字后面
跟一个子查询，只要该查询能查询出
至少一条记录，那么就返回TRUE
SELECT deptno, dname FROM dept d
WHERE 
 EXISTS(SELECT * FROM emp e
        WHERE d.deptno=e.deptno
        );

查看哪些人是别人的领导?
SELECT m.ename FROM emp m
WHERE EXISTS(SELECT * FROM emp e
             WHERE m.empno=e.mgr)


查看各部门的最低薪水，前提是比
20号部门的最低薪水高？
SELECT MIN(sal),deptno
FROM emp
GROUP BY deptno
HAVING MIN(sal)>(SELECT MIN(sal)
                 FROM emp
                 WHERE deptno=20)

查看谁比自己所在部门平均工资高?
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

分页查询
当查询数据量庞大时，通常会将
数据"分段查询出来"，这样做可以
减少内存开销，提高响应速度。

由于标准SQL中没有规定分页的语法，
所以不同数据库针对分页的操作是
不一样的。

在ORACLE中分页是基于伪列ROWNUM
实现的
ROWNUM不存在于任何一张表中，但是
每张表都可以查询该列，该列的值是为
查询出来的每一条记录添加一个行号。
ROWNUM的值会自增，从1开始，只要可以
从表中查询出一条记录，就会为其编号，
然后自增。

SELECT ROWNUM,ename,sal,
       job,deptno
FROM emp

查看第五条以后的数据?
SELECT ROWNUM,ename,sal,
       job,deptno
FROM emp
WHERE ROWNUM > 1
在使用ROWNUM对结果集编行号的
过程中，不应当使用WHERE进行
ROWNUN>1以上的数字进行过滤，
否则得不到任何结果。

查看5-10条记录
SELECT *
FROM(SELECT ROWNUM rn,ename,sal,
            job,deptno
     FROM emp) t
WHERE rn BETWEEN 5 AND 10

查看公司工资排名的5-10名
SELECT *
FROM(SELECT ROWNUM rn,t.*
     FROM(SELECT ename,sal,
                 job,deptno
          FROM emp
          ORDER BY sal DESC) t)
WHERE rn BETWEEN 6 AND 10
page(页数) pageSize(每页的条目数)
star= (page-1)*pageSize+1
end = pagSize*page


DECODE函数可以实现分支

SELECT ename, job, sal,
     DECODE(job,  
            'MANAGER', sal * 1.2,
            'ANALYST', sal * 1.1,
            'SALESMAN', sal * 1.05,
            sal
     ) bonus
FROM emp;


统计公司中:MANAGER和ANALYST
一共多少人，其他职位共多少人?
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

排序函数
排序函数允许我们根据指定的字段
分组，然后再按照指定的字段排序后
生成一个组内记录的编号

ROW_NUMBER函数生成组内连续且
唯一的数字。
查看每个部门的工资排名?
SELECT 
 ename,sal,deptno,
 ROW_NUMBER() OVER(
  PARTITION BY deptno
  ORDER BY sal DESC
 ) rank
FROM 
 emp


RANK函数
生成组内不连续不唯一的数字
SELECT 
 ename,sal,deptno,
 RANK() OVER(
  PARTITION BY deptno
  ORDER BY sal DESC
 ) rank
FROM 
 emp

DENSE_RANK
生成组内连续但不唯一的数字
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


查看每天营业额?
SELECT year_id,month_id,
       day_id,SUM(sales_value)
FROM sales_tab
GROUP BY year_id,month_id,day_id
ORDER BY year_id,month_id,day_id

查看每月营业额?
SELECT year_id,month_id,
       SUM(sales_value)
FROM sales_tab
GROUP BY year_id,month_id
ORDER BY year_id,month_id

查看每年营业额?
SELECT year_id,SUM(sales_value)
FROM sales_tab
GROUP BY year_id
ORDER BY year_id

开点至今的总营业额?
SELECT SUM(sales_value)
FROM sales_tab

高级分组函数
ROLLUP()
ROLLUP函数可以使用在GROUP BY
子句中，ROLLUP函数的参数可以是
任意个。ROLLUP会根据参数逐个递
减的方式分别进行分组，然后将所有
分组的结果并在一个结果集里显示

GROUP BY ROLLUP(a,b,c)

GROUP BY a,b,c
UNION ALL
GROUP BY a,b
UNION ALL
GROUP BY a
UNION ALL
全表

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
全表

SELECT year_id,month_id,
       day_id,SUM(sales_value)
FROM sales_tab
GROUP BY 
 CUBE(year_id,month_id,day_id)
ORDER BY year_id,month_id,day_id

查看每天和每月的销售额?
GROUPING SETS()
该高级分组函数允许我们按照自定义的
分组方式进行统计，再将它们并到一个
结果集显示
SELECT year_id,month_id,
       day_id,SUM(sales_value)
FROM sales_tab
GROUP BY 
 GROUPING SETS(
   (year_id,month_id,day_id),
   (year_id,month_id)
 )
ORDER BY year_id,month_id,day_id








