SQL��䱾�����ִ�Сд������
��ʵ�ʹ�������һ��Լ���׳ɵĸ�ʽ
Ҫ�󣬹ؼ�����ǹؼ���ͨ��ʹ�ô�С
д���ֿ������ӿɶ��ԡ�
SELECT SYSDATE FROM dual

�������SQL
CREATE TABLE employee(
	id NUMBER(4),
	name VARCHAR2(20),
	gender CHAR(1),
	birth DATE,
  salary NUMBER(6,2),
  job VARCHAR2(30),
  deptno NUMBER(2)
);

�鿴��ṹ:
DESC table_name

DESC employee

ɾ����
DROP TABLE table_name

DROP TABLE employee


�ֶ�Ĭ��ֵ
�����ݿ��У�������������Ĭ��ֵ����NULL��
�����ڴ������ʱ��Ϊָ�����ֶ�����һ��
Ĭ��ֵ����ô������һ����¼ʱ���ֶ�û��
��ֵʱ���Ὣָ����Ĭ��ֵ���뵱ǰ�ֶΡ�
CREATE TABLE employee(
	id NUMBER(4),
	name VARCHAR2(20),
	gender CHAR(1) DEFAULT 'M',
	birth DATE,
  salary NUMBER(6,2),
  job VARCHAR2(30),
  deptno NUMBER(2)
);

��SQL������ַ���������ʹ�õ����ţ�
�����ַ������ִ�Сд!


NOT NULLԼ��
��һ���ֶα�NOT NULL���κ󣬸��ֶ�
��ֵ������Ϊ�ա�
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

�޸ı���:
RENAME old_name TO new_name

RENAME employee TO myemp

DESC myemp

�޸ı�ṹ
1:������ֶ�
��Ҫע�⣬����ӵ��ֶ�ֻ�ܱ�׷�ӵ�
���ĩβ�������������ֶ��м������
�ֶ�
ALTER TABLE myemp
ADD(
  hiredate DATE DEFAULT SYSDATE
)
DESC myemp

2:ɾ�������ֶ�
ALTER TABLE myemp
DROP(hiredate)

3:�޸������ֶ�
�޸ı��������ֶο����޸��ֶε�����
���ȡ�
���Ǳ�������������ʱ�����鲻Ҫ�޸�
���ͣ����޸ĳ���Ҳ���������������
��С�����������ΪΥ�����б�������
��ʵ��Ҫ���ʧ�ܡ�
ALTER TABLE myemp
MODIFY(
 job VARCHAR2(40) DEFAULT 'CLERK'
)

DESC myemp



DML���
1���������
INSERT INTO myemp
(id,name,job,salary)
VALUES
(1,'rose','CLERK',5000)

SELECT * FROM myemp

����ָ���ֶΣ�����ȫ�ֶβ���
INSERT INTO myemp
VALUES
(2,'JACK','M',SYSDATE,4000,'CLERK',20)

��������:
����ֱ�Ӳ����ַ��������Ǹ��ַ����ĸ�ʽ
���밴��"DD-MON-RR"����ʽ������������
���죬����ʹ��TO_DATE������ʵ��
INSERT INTO myemp 
(id, name, job,birth) 
VALUES
(1003, 'donna', 'MANAGER', 
 TO_DATE('2009-09-01',
         'YYYY-MM-DD')
);

�޸ı�������:
UPDATE myemp
SET salary=7000,job='MANAGER'
WHERE name='rose'

UPDATE���ͨ������Ҫʹ��WHERE
�Ӿ�������޶�����������ֻ�Ὣ
���������ļ�¼�����޸ġ��������
WHERE�������ű����������޸ġ�


SELECT * FROM myemp

ɾ������:
DELETE FROM myemp
WHERE name='JACK'

ɾ����������ҲҪע�����WHERE
�Ӿ䣬��������ձ������

��������:
--ɾ��ȫ����¼
 DELETE FROM myemp;
--����
TRUNCATE  TABLE myemp;
select *from myemp;





























