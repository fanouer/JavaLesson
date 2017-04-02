��ҵ9
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

��ҵ10
INSERT INTO t_account
(id,login_name,login_passwd,create_date,real_name,idcard_no,telephone)
VALUES
(1,'shiyl','256528',TO_DATE('2008-01-28','YYYY-MM-DD'),'shiyuanli','410381194302256523','13669351234')

��ҵ11
UPDATE t_account
SET login_passwd='801206'
WHERE id=1

��ҵ12
DELETE FROM t_account
WHERE id=1

DQL:
SELECT���
������ѯ���ݿ��е�����

�鿴ָ�����������ֶε�ֵ:
SELECT * FROM table_name

SELECT * FROM emp

�鿴ָ���ֶε�ֵ
SELECT ename,job,sal,deptno
FROM emp

�鿴����ָ�������ļ�¼
�鿴20�Ų��ŵ�Ա��:
SELECT ename,job,sal,deptno
FROM emp
WHERE deptno=20

SELECT ename,job,sal,deptno
FROM emp
WHERE sal>1000

�ַ�������
CONCAT(char1,char2)
�ú����Ὣ�����������ַ���������
һ��󷵻�
SELECT CONCAT(ename,sal)
FROM emp

SELECT 
 CONCAT(CONCAT(ename,':'),sal)
FROM emp

'||'������Ҳ������ƴ���ַ���ʹ��
����ʹ���������д��Ҳ�������

SELECT 
 ename||':'||sal
FROM 
 emp


LENGTH(char)
�鿴ָ���ַ����ĳ���

SELECT ename,LENGTH(ename)
FROM emp

����ѯ���ֶ����κ�һ�ű�û�й�ϵ
ʱ��Ϊ������SELECT�﷨Ҫ������
����ʹ��"α��:dual"��������һ��
��ʵ���ڵı���ѯ����ֻ����ʾһ��

UPPER(char),LOWER(char),
INITCAP(char)
���������ֱ��ַ���ת��Ϊȫ��д��ȫ
Сд������ĸ��д��
����INITCAP���ԣ��ַ�������ʹ�ÿո�
�ָ�����ôÿ�������ĸ�����д��
SELECT 
 UPPER('helloworld'),
 LOWER('HELLOWORLD'),
 INITCAP('HELLO WORLD')
FROM dual

SELECT * FROM emp
WHERE ename=UPPER('scott')

TRIM
ȥ���ַ��������ظ���ָ���ַ�
SELECT 
 TRIM('e' FROM 'eeeeliteeee')
FROM dual

LTRIM,RTRIM
����ȥ������������ָ������
SELECT
 LTRIM('eeeeliteeee','e')
FROM 
 dual

LPAD,RPAD����
��λ����
��ָ��������ʾָ�����ȣ�������
�򲹳�����ָ���ַ��Դﵽָ������
���������ȡ����ʾָ�����ȡ�
SELECT 
 LPAD(ename,10,' ')
FROM
 emp


SUBSTR(char,index,len)
��ȡ��ǰ�ַ�������index��
��ʼȡlen���ַ�
len���Բ�д����д���ǽ�ȡ��
�ַ���ĩβ����len������ʵ��
���Խ�ȡ�ĳ��ȣ�Ҳ�ǽ�ȡ����
����ĩβ
index�����Ǹ��������Ǹ�������
�Ǵӵ���λ�ÿ�ʼ��ȡ��
��Ҫע�⣬���ݿ����±궼�Ǵ�1��ʼ!

SELECT 
 SUBSTR('thinking in java',-7,2)
FROM 
 dual


INSTR(char1,char2,m,n)
�鿴char2��char1�е�λ��
m:�ӵڼ����ַ���ʼ����
n:�ڼ��γ���
m��n�����Բ�ָ����Ĭ��ֵΪ1

SELECT 
 INSTR('thinking in java','in',4,3)
FROM
 dual


���ֺ���
ROUND(n,m)
�������룬����n��С�����mλ
m��Ϊ0����������Ϊ��������
������С����ǰ��λ��(ʮλ����λ��)

SELECT 
 ROUND(45.678,2),
 ROUND(45.678,0),
 ROUND(55.678,-2)
FROM
 dual





TRUNC(m,n)
������ROUNDһ�����ò���������
�������룬ֻ��ȡ����
SELECT 
 TRUNC(45.678,2),
 TRUNC(45.678,0),
 TRUNC(55.678,-1)
FROM
 dual

MOD(m,n)
����

SELECT MOD(11,4)
FROM dual

SELECT ename,MOD(sal,1000)
FROM emp


������ز���
DATE��TIMESTAMP
DATEռ7���ֽڷֱ���������ʱ����
TIMESTAMP�ֳ�Ϊʱ�����ǰ7���ֽ�
��DATEһ�£���4���ֽڼ�¼��һ�µ�
���ȡ������Ա�ʾ������
���ùؼ���:
SYSDATE:��ʾһ�����ú���������ֵΪ
һ����ʾ��ǰϵͳʱ���DATE����ֵ
SYSTIMESTAMP:��ʾһ�����ú���������
ֵΪ��ʾ��ǰϵͳʱ���ʱ�������ֵ��

SELECT SYSDATE FROM dual

SELECT SYSTIMESTAMP FROM dual

�������Ϳ��Խ��м��㣬��һ����������
��ֵ�Ӽ�һ�����ֵ�ͬ�ڼӼ�������
�����������͵�ֵ���м�������Ϊ����
������
��������Ҳ���ԱȽϴ�С����Ĵ����С��

�鿴ÿ��Ա��������Ϊֹ��ְ��������?
SELECT ename,SYSDATE-hiredate
FROM emp

�鿴������Ϊֹ����˶�����?
SELECT 
 SYSDATE - TO_DATE('1992-08-21','YYYY-MM-DD')
FROM 
 dual

TO_CHAR����
����ʹ�øú�����һ�����ڰ���
ָ���ĸ�ʽת��Ϊ�ַ�����

SELECT 
 TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI:SS')
FROM
 dual

�����ڸ�ʽ�ַ����У������ֵ��ַ�����
���Ż���Ӣ�ģ���Ҫʹ��˫����������
TO_DATE��TO_CHAR����ѭ��

SELECT 
 TO_CHAR(
  SYSDATE,
  'YYYY"��"MM"��"DD"��"'
 )
FROM
 dual

RR:�Զ��ж����͵�2λ������
SELECT
  TO_CHAR(
   TO_DATE('49-12-20','RR-MM-DD'),
   'YYYY-MM-DD'
  )
FROM
  dual


LAST_DAY(date)
���ظ������������µ����һ��
SELECT LAST_DAY(SYSDATE)
FROM dual

ADD_MONTHS(date,i)
��ָ�������ڼ���ָ�����£�
��iΪ���������Ǽ�ȥ��
SELECT 
 ename,ADD_MONTHS(hiredate,3)
FROM
 emp

MONTHS_BETWEEN(date1,date2)
������������������������

�鿴ÿ��Ա��������Ϊֹ��ְ�˶��ٸ���?
SELECT 
 ename,MONTHS_BETWEEN(SYSDATE,hiredate)
FROM emp


NEXT_DAY(date,i)
i�������ַ���Ҳ���������֣�
�ַ����Ļ�Ӧ��������һ�����յ�Ӣ��
���ֵĻ�����1-7���ɣ�����1��ʾ����
���ؾ��������־����Ļ�û�й����ܼ�

SELECT 
 NEXT_DAY(SYSDATE,5)
FROM
 dual

SELECT 
 ename,
 LEAST(hiredate, '10-10�� -08') 
FROM emp;

SELECT 
 LEAST(SYSDATE, '10-10�� -08') 
 GREATEST
FROM DUAL;

�鿴1981����ְ��Ա��?
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
VALUES(1000, '��Ī��', 'F')

INSERT INTO student 
VALUES(1001, '��ƽ֮', NULL)

INSERT INTO student
(id, name) 
VALUES
(1002, '���޼�')

SELECT * FROM student

UPDATE student
SET gender=NULL
WHERE id=1000

�鿴�Ա�Ϊ�յ�ѧ����Ϣ
�ж�ĳ���ֶε�ֵ�Ƿ�ΪNULLҪʹ��
IS NULL����IS NOT NULL
����ʹ��"="�жϡ�
SELECT * FROM student
WHERE gender IS NOT NULL

NULL���ַ���ƴ�ӣ��������ʲô
��û��
NULL���������㣬�����ΪNULL��
SELECT 
 ename,sal,comm,sal+comm
FROM emp

NVL(exp1,exp2)
��NULLֵ�滻Ϊ��NULLֵ
SELECT 
 ename,sal,comm,
 sal+NVL(comm,0)
FROM emp

�鿴ÿ��Ա���Ľ������������ΪNULL
������ʾ"�н���",ΪNULL������ʾΪ
"û�н���"
NVL2(exp1,exp2,exp3)
����exp1�Ƿ�ΪNULL����exp2��exp3
SELECT 
 ename,comm,
 NVL2(comm,'�н���','û�н���')
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






