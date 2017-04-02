作业9
1:
RENAME account TO t_account

2:
ALTER TABLE t_account
ADD(
  bak VARCHAR2(50)
)

3:
ALTER TABLE t_account
MODIFY(
  bak VARCHAR2(40) DEFAULT 'login'
)

4:
ALTER TABLE t_account
DROP(bak)

作业10
INSERT INTO t_account
(id,login_name,login_passwd,create_date,real_name,idcard_no,telephone)
VALUES
(1,'shiyl','256528',TO_DATE('2008-01-28','YYYY-MM-DD'),'shiyuanli','410381194302256523','13669351234')

作业11
UPDATE t_account
SET login_passwd='801206'
WHERE id=1

作业12
DELETE FROM t_account
WHERE id=1

DQL:
SELECT语句
用来查询数据库中的数据

查看指定表中所有字段的值:
SELECT * FROM table_name

SELECT * FROM emp

查看指定字段的值
SELECT ename,job,sal,deptno
FROM emp

查看满足指定条件的记录
查看20号部门的员工:
SELECT ename,job,sal,deptno
FROM emp
WHERE deptno=20

SELECT ename,job,sal,deptno
FROM emp
WHERE sal>1000

字符串函数
CONCAT(char1,char2)
该函数会将给定的两个字符串连接在
一起后返回
SELECT CONCAT(ename,sal)
FROM emp

SELECT 
 CONCAT(CONCAT(ename,':'),sal)
FROM emp

'||'操作符也是用来拼接字符串使用
建议使用这个，书写简单也易于理解

SELECT 
 ename||':'||sal
FROM 
 emp


LENGTH(char)
查看指定字符串的长度

SELECT ename,LENGTH(ename)
FROM emp

当查询的字段与任何一张表没有关系
时，为了满足SELECT语法要求，我们
可以使用"伪表:dual"，它不是一张
真实存在的表，查询数据只会显示一条

UPPER(char),LOWER(char),
INITCAP(char)
三个函数分别将字符串转换为全大写，全
小写，首字母大写。
对于INITCAP而言，字符串可以使用空格
分割多项，那么每项的首字母都会大写。
SELECT 
 UPPER('helloworld'),
 LOWER('HELLOWORLD'),
 INITCAP('HELLO WORLD')
FROM dual

SELECT * FROM emp
WHERE ename=UPPER('scott')

TRIM
去除字符串两边重复的指定字符
SELECT 
 TRIM('e' FROM 'eeeeliteeee')
FROM dual

LTRIM,RTRIM
单独去除左面或右面的指定内容
SELECT
 LTRIM('eeeeliteeee','e')
FROM 
 dual

LPAD,RPAD函数
补位函数
将指定内容显示指定长度，若不足
则补充若干指定字符以达到指定长度
若超过则截取以显示指定长度。
SELECT 
 LPAD(ename,10,' ')
FROM
 emp


SUBSTR(char,index,len)
截取当前字符串，从index处
开始取len个字符
len可以不写，不写则是截取到
字符串末尾，若len超过了实际
可以截取的长度，也是截取到字
符串末尾
index可以是负数，若是负数，则
是从倒数位置开始截取。
需要注意，数据库中下标都是从1开始!

SELECT 
 SUBSTR('thinking in java',-7,2)
FROM 
 dual


INSTR(char1,char2,m,n)
查看char2在char1中的位置
m:从第几个字符开始检索
n:第几次出现
m与n都可以不指定，默认值为1

SELECT 
 INSTR('thinking in java','in',4,3)
FROM
 dual


数字函数
ROUND(n,m)
四舍五入，保留n的小数点后m位
m若为0则保留到正数为，负数则
保留到小数点前的位数(十位，百位等)

SELECT 
 ROUND(45.678,2),
 ROUND(45.678,0),
 ROUND(55.678,-2)
FROM
 dual





TRUNC(m,n)
参数与ROUND一样，该参数不进行
四舍五入，只截取数字
SELECT 
 TRUNC(45.678,2),
 TRUNC(45.678,0),
 TRUNC(55.678,-1)
FROM
 dual

MOD(m,n)
求余

SELECT MOD(11,4)
FROM dual

SELECT ename,MOD(sal,1000)
FROM emp


日期相关操作
DATE与TIMESTAMP
DATE占7个字节分别是年月日时分秒
TIMESTAMP又称为时间戳，前7个字节
与DATE一致，后4个字节记录秒一下的
精度。最多可以表示到纳秒
常用关键字:
SYSDATE:表示一个内置函数，返回值为
一个表示当前系统时间的DATE类型值
SYSTIMESTAMP:表示一个内置函数，返回
值为表示当前系统时间的时间戳类型值。

SELECT SYSDATE FROM dual

SELECT SYSTIMESTAMP FROM dual

日期类型可以进行计算，对一个日期类型
的值加减一个数字等同于加减天数。
两个日期类型的值进行减法，差为相差的
天数。
日期类型也可以比较大小，晚的大早的小。

查看每个员工到今天为止入职多少天了?
SELECT ename,SYSDATE-hiredate
FROM emp

查看到今天为止你活了多少天?
SELECT 
 SYSDATE - TO_DATE('1992-08-21','YYYY-MM-DD')
FROM 
 dual

TO_CHAR函数
可以使用该函数将一个日期按照
指定的格式转换为字符串。

SELECT 
 TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI:SS')
FROM
 dual

在日期格式字符串中，若出现的字符不是
符号或者英文，需要使用双引号括起来
TO_DATE与TO_CHAR都遵循。

SELECT 
 TO_CHAR(
  SYSDATE,
  'YYYY"年"MM"月"DD"日"'
 )
FROM
 dual

RR:自动判定世纪的2位数字年
SELECT
  TO_CHAR(
   TO_DATE('49-12-20','RR-MM-DD'),
   'YYYY-MM-DD'
  )
FROM
  dual


LAST_DAY(date)
返回给定日期所在月的最后一天
SELECT LAST_DAY(SYSDATE)
FROM dual

ADD_MONTHS(date,i)
对指定的日期加上指定的月，
若i为负数，则是减去。
SELECT 
 ename,ADD_MONTHS(hiredate,3)
FROM
 emp

MONTHS_BETWEEN(date1,date2)
计算两个给定日期相差的月数

查看每个员工到今天为止入职了多少个月?
SELECT 
 ename,MONTHS_BETWEEN(SYSDATE,hiredate)
FROM emp


NEXT_DAY(date,i)
i可以是字符串也可以是数字，
字符串的话应当传入周一至周日的英文
数字的话传入1-7即可，但是1表示周日
返回距离给定日志最近的还没有过的周几

SELECT 
 NEXT_DAY(SYSDATE,5)
FROM
 dual

SELECT 
 ename,
 LEAST(hiredate, '10-10月 -08') 
FROM emp;

SELECT 
 LEAST(SYSDATE, '10-10月 -08') 
 GREATEST
FROM DUAL;

查看1981年入职的员工?
SELECT ename,hiredate
FROM emp
WHERE 
 EXTRACT(YEAR FROM hiredate)='1981'



CREATE TABLE student
(id NUMBER(4), 
 name CHAR(20), 
 gender CHAR(1)
)

INSERT INTO student 
VALUES(1000, '李莫愁', 'F')

INSERT INTO student 
VALUES(1001, '林平之', NULL)

INSERT INTO student
(id, name) 
VALUES
(1002, '张无忌')

SELECT * FROM student

UPDATE student
SET gender=NULL
WHERE id=1000

查看性别为空的学生信息
判断某个字段的值是否为NULL要使用
IS NULL或者IS NOT NULL
不能使用"="判断。
SELECT * FROM student
WHERE gender IS NOT NULL

NULL与字符串拼接，结果等于什么
都没做
NULL与数字运算，结果仍为NULL。
SELECT 
 ename,sal,comm,sal+comm
FROM emp

NVL(exp1,exp2)
将NULL值替换为非NULL值
SELECT 
 ename,sal,comm,
 sal+NVL(comm,0)
FROM emp

查看每个员工的奖金情况，奖金不为NULL
的则显示"有奖金",为NULL的则显示为
"没有奖金"
NVL2(exp1,exp2,exp3)
根据exp1是否为NULL返回exp2或exp3
SELECT 
 ename,comm,
 NVL2(comm,'有奖金','没有奖金')
FROM
 emp

SELECT 
 ename,sal,comm,
 NVL2(comm,sal+comm,sal)
FROM
 emp























CREATE TABLE student
(id NUMBER(4), 
 name CHAR(20), 
 gender CHAR(1) NOT NULL
)






