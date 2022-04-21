-- ex07_order.sql

/*

    SELECT 컬럼리스트
    FROM 테이블명
    WHERE 조건
    ORDER BY 기준;
    
    
    정렬, Sort
    - order by 절
    - order by 정렬 기준
    - order by 정렬할 기준 컬럼명 asc|desc (오름차순|내림차순)

    
    다중 정렬
    - order by 컬럼명 asc > 1차정렬
    - order by 컬럼명 asc, 컬럼명 asc > 2차정렬
    - order by 컬럼명 asc, 컬럼명 asc, 컬럼명 asc > 3차정렬
    

    실행 순서
    1. FROM 테이블명
    2. WHERE 조건
    3. SELECT 컬럼리스트
    4. ORDER BY 기준
    
*/

-- 관계형 데이터베이스는 물리적으로 저장된 행의 순서는 중요하지 않다.
select * from tblCountry order by name asc;
select * from tblCountry order by name desc;

select * from tblCountry order by area asc;

select * from tblInsa order by name asc;     -- 문자열 정렬
select * from tblInsa order by basicpay asc; -- 숫자 정렬
select * from tblInsa order by ibsadate asc; -- 날짜 정렬

-- 실행 순서
select name, jikwi
from tblInsa
where buseo = '기획부'
order by name asc;


select name, buseo, jikwi, basicpay from tblInsa;
select name, buseo, jikwi, basicpay from tblInsa order by buseo asc;
select name, buseo, jikwi, basicpay from tblInsa order by buseo asc, jikwi desc;
select name, buseo, jikwi, basicpay from tblInsa order by buseo asc, jikwi desc, name asc;

-- 컬럼명 대신 번호를 사용해도 정렬해주지만... 권장하지 않음. 사용하지 말 것. 가독성+유지보수 취약함
select name, buseo, jikwi, basicpay from tblInsa order by 2 asc, 3 desc, 1 asc;

-- *** 가공(조작)한 값도 정렬의 대상이 된다
-- 급여와 수당을 합친 금액을 내림차순으로 정렬
select * from tblInsa order by basicpay + sudang desc;


-- ***** 더욱 더 가공!
-- 직위: 부장 > 과장 > 대리 > 사원

select
    name, jikwi,
    case
        when jikwi = '부장' then 4
        when jikwi = '과장' then 3
        when jikwi = '대리' then 2
        when jikwi = '사원' then 1
    end as jikwiseq
from tblInsa
    order by jikwiseq desc;
    
    
    
select
    name, jikwi
from tblInsa
    order by case
        when jikwi = '부장' then 4
        when jikwi = '과장' then 3
        when jikwi = '대리' then 2
        when jikwi = '사원' then 1
    end desc;    
    

-- 기획부 > 성별 순으로 정렬! 남자순, 여자순으로...    
select 

from tblInsa
    where buseo = '기획부';
    
select * from tblInsa
    where buseo = '기획부'
        order by     case
            when ssn like '%-1%' then '남자'
            when ssn like '%-2%' then '여자'
        end asc;
    
