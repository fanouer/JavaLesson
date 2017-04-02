select *
from (
  select rownum r,e.*
  from (select * from emp_czh1 order by id) e
)
where r between 2 and 4