-- 1. tblInsa. 남자 급여(기본급+수당)을 (내림차순)순위대로 가져오시오. (이름, 부서, 직위, 급여, 순위 출력)
select * from tblInsa;

select name as "이름",
       buseo as "부서",
       jikwi as "직위",
       basicpay + sudang as "급여",
       rownum as "순위"

from (select * from tblInsa where substr(ssn, 8, 1) = 1
                        order by (basicpay + sudang) desc);


-- 2. tblInsa. 여자 급여(기본급+수당)을 (오름차순)순위대로 가져오시오. (이름, 부서, 직위, 급여, 순위 출력)

select 이름, 부서, 직위, 급여, 순위

from (select name as "이름",
       buseo as "부서",
       jikwi as "직위",
       basicpay + sudang as "급여",
       rownum as "순위"

    from (select * from tblInsa where substr(ssn, 8, 1) = 2
                            order by (basicpay + sudang) desc)
    order by 순위 desc);
                        
                        

-- 3. tblInsa. 여자 인원수가 (가장 많은 부서 및 인원수) 가져오시오.
select * from tblInsa where substr(ssn, 8, 1) = 2 order by buseo;

select
    부서,
    인원수,
    rownum
from (select buseo as 부서, count(*) as 인원수 from tblInsa where substr(ssn, 8, 1) = 2
                            group by buseo order by count(*) desc)
    where rownum = 1;
    
    
-- 4. tblInsa. 지역별 인원수 (내림차순)순위를 가져오시오.(city, 인원수)

select
    지역,
    인원수,
    순위
from (select 지역, 인원수, rownum as "순위" from (select city as "지역", count(*) as "인원수" from tblInsa group by city order by count(*) desc));


-- 5. tblInsa. 부서별 인원수가 가장 많은 부서 및원수 출력.

select "부서", "부서별 인원수" from (select buseo as "부서", count(*) as "부서별 인원수" from tblInsa group by buseo order by "부서별 인원수" desc)
    where rownum = 1;

-- 6. tblInsa. 남자 급여(기본급+수당)을 (내림차순) 3~5등까지 가져오시오. (이름, 부서, 직위, 급여, 순위 출력)

select
    "이름",
    "부서",
    "직위",
    "급여",
    "순위"
from (select
            name as "이름",
            buseo as "부서",
            jikwi as "직위",
            basicpay + sudang as "급여",
            rownum as "순위"
        from (select * from tblInsa where substr(ssn, 8, 1) = '1' order by basicpay + sudang desc))
where "순위" between 3 and 5;


-- 7. tblInsa. 입사일이 빠른 순서로 5순위까지만 가져오시오.

select a.*, rownum from (select * from tblInsa order by ibsadate asc) a
where rownum <= 5;


-- 8. tblhousekeeping. 지출 내역(가격 * 수량) 중 가장 많은 금액을 지출한 내역 3가지를 가져오시오.

select a.*, rownum from (select * from tblhousekeeping order by price * qty desc) a
where rownum <= 3;


-- 9. tblinsa. 평균 급여 2위인 부서에 속한 직원들을 가져오시오.
select * from tblInsa where buseo = (select buseo from
(select
buseo,
avgbasicpay,
rownum as rnum
    from (select 
        buseo,
        avg(basicpay) as avgbasicpay
    from tblInsa
        group by buseo
            order by avg(basicpay) desc)) where rnum = 2);

-- 10. tbltodo. 등록 후 가장 빠르게 완료한 할일을 순서대로 5개 가져오시오.


select title as "할일", rownum as "순위"
    from (select title, (completedate - adddate) from tblTodo where completedate is not null order by (completedate - adddate) asc)
        where rownum <= 5;



-- 11. tblinsa. 남자 직원 중에서 급여를 3번째로 많이 받는 직원과 9번째로 많이 받는 직원의 급여 차액은 얼마인가?

-- ** 3~9번째만 가져와서 max - min을 하면 더 간단하다!

select (select "급여" from vwRecord where "순위" = 3)
        - (select "급여" from vwRecord where "순위" = 9) as "급여 차액"
from dual;

create or replace view vwRecord
as
(select
    basicpay+sudang as "급여",
    rownum as "순위"
from (select * from tblInsa where substr(ssn, 8, 1) = '1' order by (basicpay + sudang) desc));