-- 문제03.sql

-- 1. tblCountry. 아시아(AS)와 유럽(EU)에 속한 나라의 개수?? -> 7개
select 
    count(case
        when continent = 'AS' then '아시아'
    end) as "아시아",
    count(case
        when continent = 'EU' then '유럽'
    end) as "유럽"
from tblCountry;


select
    count(*) as "아시아+유럽"
from tblCountry where continent in ('AS', 'EU');


-- 2. 인구수가 7000 ~ 20000 사이인 나라의 개수?? -> 2개

select
    count(*) as "인구수"
from tblCountry where population between 7000 and 20000;


-- 3. hr.employees. job_id > 'IT_PROG' 중에서 급여가 5000불이 넘는 직원이 몇명? -> 2명

select
    count(case
        when job_id = 'IT_PROG' and salary > 5000 then 1  
    end) as "조건 만족 직원 수"
from employees;

select
    count(*) as "조건 만족 직원 수"
from employees where job_id = 'IT_PROG' and salary > 5000;



-- 4. tblInsa. tel. 010을 안쓰는 사람은 몇명?(연락처가 없는 사람은 제외) -> 42명

select
    count(*) as "010 아닌 인원수"
from tblInsa where tel not like '010-%';

    
-- 5. city. 서울, 경기, 인천 -> 그 외의 지역 인원수? -> 18명

select
    count(case
        when city not in ('서울', '경기', '인천') then 1
    end) as "수도권 제외 인원수"
from tblInsa;
        

-- 6. 여름태생(7~9월) + 여자 직원 총 몇명? -> 7명

select
    count(case
        when ssn like '__07%-2%' then '7월생'
        when ssn like '__08%-2%' then '8월생'
        when ssn like '__09%-2%' then '9월생'
    end) as "조건 만족 직원 수"
from tblInsa;
    

-- 7. 개발부 + 직위별 인원수? -> 부장 ?명, 과장 ?명, 대리 ?명, 사원 ?명

select
    count(case
        when buseo = '개발부' and jikwi = '부장' then 1
    end) as "개발부 부장",
    count(case
        when buseo = '개발부' and jikwi = '과장' then 1
    end) as "개발부 과장",
    count(case
        when buseo = '개발부' and jikwi = '대리' then 1
    end) as "개발부 대리",
    count(case
        when buseo = '개발부' and jikwi = '사원' then 1
    end) as "개발부 사원"
from tblInsa;





