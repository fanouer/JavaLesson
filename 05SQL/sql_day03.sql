��ҵ6
1��
SELECT 
 TO_CHAR(
  SYSDATE,
  'YYYY"��"MM"��"DD"��" HH24"ʱ"MI"��"SS"��"'
 )
FROM
 dual
 
2:
SELECT 
 ename,
 TO_CHAR(hiredate,'YYYY"��"MM"��"DD"��"'),
 TO_CHAR(hiredate,'YYYY/MM/DD')
FROM
 emp


��ҵ8:
SELECT * FROM customer
WHERE birthday IS NULL

��ҵ9
SELECT empno,ename,sal+NVL(comm,0)
FROM emp

��ҵ10
SELECT 
 empno,ename,
 NVL2(hiredate,
      TO_CHAR(hiredate,'YYYY-MM-DD'),
      'not available'
 )
FROM
 emp


DQL���
�ڲ�ѯ�����SELECT�������
ʹ�ñ��ʽ���ߺ�������������
һ��������и��ֶε����־���
ֱ��ʹ�ñ��ʽ���ߺ��������׶�
Ϊ�ˣ�����Ϊ���ֶ���ӱ�����

��������ʹ��˫������������������
�������ִ�Сд�ˣ����ҿ��Ժ��пո�
SELECT 
 LOWER(ename) "ename",
 sal*12 sal
FROM
 emp

��н����20000
SELECT ename,sal
FROM emp
WHERE sal*12>20000

ʹ��AND��OR���Ӷ�������ж�:
SELECT ename, sal, job FROM emp 
WHERE sal > 1000 AND job = 'CLERK';

SELECT ename, sal, job FROM emp 
WHERE sal > 1000 OR job = 'CLERK';

�鿴���ʸ���1000��ְλ
��SALESMAN��CLERK��Ա����
SELECT ename,job,sal
FROM emp
WHERE sal>1000
AND (job='SALESMAN'
OR job='CLERK')

AND�����ȼ��Ǹ���OR�ġ�

LIKEģ��ƥ���ַ���
_:��ʾһ���ַ�
%:��ʾ0-������ַ�

�鿴���ֵڶ�����ĸ��"A"��Ա��?
SELECT ename, job FROM emp 
WHERE ename LIKE '_A%';


IN��NOT IN
�ж��ֶε�ֵ�Ƿ����б��л����б���

--��ѯְλ��MANAGER����CLERK��Ա��
SELECT ename, job FROM emp  
WHERE job IN ('MANAGER', 'CLERK');
--��ѯ���ǲ���10��20��Ա��
SELECT ename, job FROM emp 
WHERE deptno NOT IN (10, 20);

IN��NOT IN�������ж��Ӳ�ѯ�Ľ����


ANY��ALL
��ʹ������">","<",">="�Ȳ����ж�
һ���б�ʱ��Ҫͬʱʹ��ANY��ALL
>ANY(list):�����б�����С��
>ALL(list):�����б�������
ͨ���б��е����ݲ��ǹ̶�ֵ������һ��
��ѯ���Ľ���������Գ������Ӳ�ѯ


DISTINCTȥ���ظ���
�Ὣ�����ֶ�ֵ��ͬ�ļ�¼ȥ����ֻ��ʾ
һ�Ρ�
�鿴��˾���ж�����ְλ?
SELECT DISTINCT job
FROM emp

DISTINCT�ؼ��ֱ������SELECT�ؼ���֮��

�Զ���ȥ�أ����ܱ�֤ÿ�ж�û���ظ�ֵ��
ֻ�����Щ�е����ȥ��
SELECT DISTINCT job,deptno
FROM emp

����
ORDER BY �Ӿ�
ORDER BY�Ӿ�ֻ�ܶ�����SELECT���
����󣬿��ԶԲ�ѯ�����Ľ��������
ָ���ֶ�ֵ��������߽��򽫽��������
����������
����:ASC ���Բ�д��Ĭ�Ͼ�������
����:DESC

���չ��ʴӴ�С��˳����ʾԱ����Ϣ
SELECT ename,sal
FROM emp
ORDER BY sal DESC

NULL����Ϊ�����ֵ
���ս�������
SELECT ename,comm
FROM emp
ORDER BY comm DESC

ORDER BY���ԶԶ��ֶ����򣬵���
�������Ȱ��յ�һ���ֶε������
����һ���ֶ����ظ�ֵʱ�Ű��յڶ���
�ֶ������Դ����ơ�

SELECT ename,deptno,sal
FROM emp
ORDER BY deptno DESC,sal DESC



�ۺϺ���
�ۺϺ����Ὣ������¼��Ӧ���ֶ�ֵ
����ͳ�ƣ�Ȼ��ó�һ�������

�鿴��˾��߹�������͹���?
SELECT MAX(sal),MIN(sal)
FROM emp

�鿴ƽ��ֵ���ܺ�
SELECT AVG(sal),SUM(sal)
FROM emp

COUNT()��������ע��¼���ֶε�ֵ
�Ƕ��٣�ֻ��ע��¼��������COUNT
������ͳ�Ƽ�¼������

�鿴��˾�ܹ�����Ա��?
SELECT COUNT(ename)
FROM emp

�ۺϺ�������NULLֵ��¼
�鿴��˾ƽ������?
SELECT AVG(comm)
FROM emp

SELECT AVG(NVL(comm,0))
FROM emp

�鿴һ�ű����ж�������¼?
SELECT COUNT(*)
FROM emp

����
GROUP BY�Ӿ�
���Ӿ�Ϊ����ϾۺϺ���ʹ�ã����Խ�
���м�¼����ָ���ֶε�ֵ��ͬ�Ļ���
Ϊһ�飬Ȼ����ͳ�ƽ����
�鿴ÿ�����ŵ�ƽ������?
SELECT AVG(sal),deptno
FROM emp
GROUP BY deptno

��SELECT����к��оۺϺ���ʱ����ô
�����ھۺϺ����е������ֶΣ��������
��GROUP BY�Ӿ��У����������Ǳ���ġ�

�鿴ÿ��ְλ����߹���?
SELECT MAX(sal),job
FROM emp
GROUP BY job

�鿴ÿ��ְλ�ܹ�������?
SELECT COUNT(*)
FROM emp
GROUP BY job

GROUP BYҲ���԰��ն���ֶη���
����ԭ������Щ�ֶ�ֵ�����ͬ�ļ�¼
����һ��
�鿴ÿ������ÿ��ְλ��������?
SELECT COUNT(*),deptno,job
FROM emp
GROUP BY deptno,job

�鿴ƽ�����ʸ���2000�Ĳ��ŵ�
����ƽ������?
SELECT AVG(sal),deptno
FROM emp
WHERE AVG(sal)>2000
GROUP BY deptno

WHERE�в���ʹ�÷��麯����ԭ������
����ʱ�����ԡ�
���麯�����ڷ��������ͳ�ƽ���ģ�
��˵���Ѿ��õ��˱������ݣ���ôWHERE
���Ѿ�ִ�й��ˡ�����Ӧ��ʹ��HAVING
HAVING�Ӿ��ǽ����ڷ�������ϣ���ͳ��
������й���ʹ�õġ�
HAVING�������GROUP BY�Ӿ�֮��
SELECT AVG(sal),deptno
FROM emp
GROUP BY deptno
HAVING AVG(sal)>2000

�鿴ƽ�����ʸ���2000�Ĳ��ŵ���߹���
����͹���?
SELECT MAX(sal),MIN(sal),deptno
FROM emp
GROUP BY deptno
HAVING AVG(sal)>2000


SELECT ename,sal,deptno
FROM emp

SELECT deptno,dname
FROM dept

������ѯ
�鿴SALES���ŵ�Ա����Ϣ?
SELECT e.ename,e.sal,
       e.job,e.deptno,
       d.dname,d.loc
FROM emp e,dept d
WHERE e.deptno=d.deptno
AND d.dname='SALES'

�鿴SCOTT��ʲô�ط�����?
SELECT d.loc
FROM emp e,dept d
WHERE e.deptno=d.deptno
AND e.ename='SCOTT'

�鿴��DALLAS����������Щְλ?
SELECT DISTINCT e.job
FROM emp e,dept d
WHERE e.deptno=d.deptno
AND d.loc='DALLAS'

������ѯ����д��������������ָ��
�������������ֵѿ�����������һ��
������Ľ����������Դ���ļ���
���ԣ�N�ű����ϲ�ѯ������ҪдN-1��
����������
SELECT e.ename,d.dname
FROM emp e,dept d

������
ʹ��������Ҳ����ʵ�ֹ�����ѯ

�鿴���ʸ���2000��Ա���Լ���������
SELECT e.ename,e.sal,d.dname
FROM emp e,dept d
WHERE e.deptno=d.deptno
AND e.sal>2000

������:
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

�����ӿ��Խ����������������ļ�¼
Ҳ��ѯ����
�����ӷ�Ϊ�������ӣ��������Ӻ�
ȫ������
��������:��JOIN����ı���Ϊ������
�ñ��ϵ����м�¼�����Գ��ڽ������
�����ڽ����������JOIN�Ҳ���е��ֶ�
���ü�¼����������������ô��ΪNULL��
SELECT e.ename,d.dname
FROM emp e 
     LEFT|RIGHT|FULL OUTER JOIN 
     dept d
ON e.deptno=d.deptno

SELECT e.ename,d.dname
FROM emp e,dept d
WHERE e.deptno(+)=d.deptno



������
����Ҫ�������������ͬ���͵ļ�¼
���������д������¼���ϵʱ(Ҳ����
��ν����״�ṹ����)����Ʊ��ʱ��
Ӧ��ʹ�������ӡ�
������:
�Լ����е�һ����¼���Զ�Ӧ�Լ���
�еĶ�����¼��

�鿴ÿ��Ա���Լ����쵼������?
SELECT e.ename,m.ename
FROM emp e,emp m
WHERE e.mgr=m.empno









