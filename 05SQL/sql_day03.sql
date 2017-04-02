作业6
1：
SELECT 
 TO_CHAR(
  SYSDATE,
  'YYYY"年"MM"月"DD"日" HH24"时"MI"分"SS"秒"'
 )
FROM
 dual
 
2:
SELECT 
 ename,
 TO_CHAR(hiredate,'YYYY"年"MM"月"DD"日"'),
 TO_CHAR(hiredate,'YYYY/MM/DD')
FROM
 emp


作业8:
SELECT * FROM customer
WHERE birthday IS NULL

作业9
SELECT empno,ename,sal+NVL(comm,0)
FROM emp

作业10
SELECT 
 empno,ename,
 NVL2(hiredate,
      TO_CHAR(hiredate,'YYYY-MM-DD'),
      'not available'
 )
FROM
 emp


DQL语句
在查询语句中SELECT后面可以
使用表达式或者函数，但是这样
一来结果集中该字段的名字就是
直接使用表达式或者函数，不易读
为此，可以为该字段添加别名。

别名可以使用双引号括起来，这样别
名就区分大小写了，并且可以含有空格
SELECT 
 LOWER(ename) "ename",
 sal*12 sal
FROM
 emp

年薪大于20000
SELECT ename,sal
FROM emp
WHERE sal*12>20000

使用AND与OR连接多个条件判断:
SELECT ename, sal, job FROM emp 
WHERE sal > 1000 AND job = 'CLERK';

SELECT ename, sal, job FROM emp 
WHERE sal > 1000 OR job = 'CLERK';

查看工资高于1000且职位
是SALESMAN或CLERK的员工？
SELECT ename,job,sal
FROM emp
WHERE sal>1000
AND (job='SALESMAN'
OR job='CLERK')

AND的优先级是高于OR的。

LIKE模糊匹配字符串
_:表示一个字符
%:表示0-任意个字符

查看名字第二个字母是"A"的员工?
SELECT ename, job FROM emp 
WHERE ename LIKE '_A%';


IN于NOT IN
判断字段的值是否在列表中或不在列表中

--查询职位是MANAGER或者CLERK的员工
SELECT ename, job FROM emp  
WHERE job IN ('MANAGER', 'CLERK');
--查询不是部门10或20的员工
SELECT ename, job FROM emp 
WHERE deptno NOT IN (10, 20);

IN和NOT IN常用在判断子查询的结果中


ANY与ALL
当使用诸如">","<",">="等操作判断
一个列表时，要同时使用ANY与ALL
>ANY(list):大于列表中最小的
>ALL(list):大于列表中最大的
通常列表中的内容不是固定值，而是一个
查询语句的结果集，所以常用语子查询


DISTINCT去除重复行
会将后面字段值相同的记录去除，只显示
一次。
查看公司共有多少中职位?
SELECT DISTINCT job
FROM emp

DISTINCT关键字必须跟在SELECT关键字之后

对多列去重，不能保证每列都没有重复值，
只会对这些列的组合去重
SELECT DISTINCT job,deptno
FROM emp

排序
ORDER BY 子句
ORDER BY子句只能定义在SELECT语句
的最后，可以对查询出来的结果集按照
指定字段值的升序或者降序将结果集排序
排序有两种
升序:ASC 可以不写，默认就是升序
降序:DESC

按照工资从大到小的顺序显示员工信息
SELECT ename,sal
FROM emp
ORDER BY sal DESC

NULL被认为是最大值
按照奖金排序
SELECT ename,comm
FROM emp
ORDER BY comm DESC

ORDER BY可以对多字段排序，但是
排序是先按照第一个字段的排序后，
若第一个字段有重复值时才按照第二个
字段排序，以此类推。

SELECT ename,deptno,sal
FROM emp
ORDER BY deptno DESC,sal DESC



聚合函数
聚合函数会将多条记录对应的字段值
进行统计，然后得出一个结果。

查看公司最高工资与最低工资?
SELECT MAX(sal),MIN(sal)
FROM emp

查看平均值与总和
SELECT AVG(sal),SUM(sal)
FROM emp

COUNT()函数不关注记录中字段的值
是多少，只关注记录数。所以COUNT
是用来统计记录条数的

查看公司总共多少员工?
SELECT COUNT(ename)
FROM emp

聚合函数忽略NULL值记录
查看公司平均奖金?
SELECT AVG(comm)
FROM emp

SELECT AVG(NVL(comm,0))
FROM emp

查看一张表中有多少条记录?
SELECT COUNT(*)
FROM emp

分组
GROUP BY子句
该子句为了配合聚合函数使用，可以将
表中记录按照指定字段的值相同的划分
为一组，然后按组统计结果。
查看每个部门的平均工资?
SELECT AVG(sal),deptno
FROM emp
GROUP BY deptno

当SELECT语句中含有聚合函数时，那么
凡不在聚合函数中的其他字段，必须出现
在GROUP BY子句中，返过来不是必须的。

查看每个职位的最高工资?
SELECT MAX(sal),job
FROM emp
GROUP BY job

查看每个职位总共多少人?
SELECT COUNT(*)
FROM emp
GROUP BY job

GROUP BY也可以按照多个字段分组
分组原则是这些字段值组合相同的记录
看做一组
查看每个部门每种职位各多少人?
SELECT COUNT(*),deptno,job
FROM emp
GROUP BY deptno,job

查看平均工资高于2000的部门的
具体平均工资?
SELECT AVG(sal),deptno
FROM emp
WHERE AVG(sal)>2000
GROUP BY deptno

WHERE中不能使用分组函数，原因在于
过滤时机不对。
分组函数是在分完组进行统计结果的，
这说明已经得到了表中数据，那么WHERE
就已经执行过了。所以应当使用HAVING
HAVING子句是建立在分组基础上，将统计
结果进行过滤使用的。
HAVING必须跟在GROUP BY子句之后。
SELECT AVG(sal),deptno
FROM emp
GROUP BY deptno
HAVING AVG(sal)>2000

查看平均工资高于2000的部门的最高工资
与最低工资?
SELECT MAX(sal),MIN(sal),deptno
FROM emp
GROUP BY deptno
HAVING AVG(sal)>2000


SELECT ename,sal,deptno
FROM emp

SELECT deptno,dname
FROM dept

关联查询
查看SALES部门的员工信息?
SELECT e.ename,e.sal,
       e.job,e.deptno,
       d.dname,d.loc
FROM emp e,dept d
WHERE e.deptno=d.deptno
AND d.dname='SALES'

查看SCOTT在什么地方工作?
SELECT d.loc
FROM emp e,dept d
WHERE e.deptno=d.deptno
AND e.ename='SCOTT'

查看在DALLAS工作的有哪些职位?
SELECT DISTINCT e.job
FROM emp e,dept d
WHERE e.deptno=d.deptno
AND d.loc='DALLAS'

关联查询必须写连接条件，若不指定
连接条件则会出现笛卡尔积，这是一个
无意义的结果集，对资源消耗极大。
所以，N张表联合查询，至少要写N-1个
连接条件。
SELECT e.ename,d.dname
FROM emp e,dept d

内连接
使用内连接也可以实现关联查询

查看工资高于2000的员工以及部门名称
SELECT e.ename,e.sal,d.dname
FROM emp e,dept d
WHERE e.deptno=d.deptno
AND e.sal>2000

内连接:
SELECT e.ename,e.sal,d.dname
FROM emp e JOIN dept d
ON e.deptno=d.deptno
WHERE e.sal>2000

UPDATE emp
SET deptno=50
WHERE ename='SCOTT'

SELECT e.ename,d.dname
FROM emp e JOIN dept d
ON e.deptno=d.deptno

外连接可以将不满足连接条件的记录
也查询出来
外连接分为左外连接，右外连接和
全外连接
左外连接:以JOIN左面的表作为驱动表
该表上的所有记录都会显出在结果集中
但是在结果集中来自JOIN右侧表中的字段
若该记录不满足连接条件那么则为NULL。
SELECT e.ename,d.dname
FROM emp e 
     LEFT|RIGHT|FULL OUTER JOIN 
     dept d
ON e.deptno=d.deptno

SELECT e.ename,d.dname
FROM emp e,dept d
WHERE e.deptno(+)=d.deptno



自连接
当需要保存的数据是相同类型的记录
但是自身有存在上下级关系时(也就是
所谓的树状结构数据)，设计表的时候
应当使用自连接。
自连接:
自己表中的一条记录可以对应自己表
中的多条记录。

查看每个员工以及其领导的名字?
SELECT e.ename,m.ename
FROM emp e,emp m
WHERE e.mgr=m.empno









