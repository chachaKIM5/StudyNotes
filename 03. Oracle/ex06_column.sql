-- ex06_column.sql


/*

SELECT 컬럼리스트
FROM 테이블명   > 테이블 지정
WHERE 조건;     > 레코드를 선별하는 역할 > where절에 할 수 있는 행동

컬럼 리스트에서 할 수 있는 행동

*/

-- 컬럼 연산

select
    last || first as name
    weight + 10 as weight2
from tblComedian;
    
    
select
    first,
    nick,
    '코미디언',
    100,
    sysdate
from tblComedian;


/*

    distinct
    - 컬럼 리스트에서 사용 
    - 중복값 제거(레코드, 행)
    - distinct 컬럼명 > distinct 컬럼리스트
    - 특정 컬럼의 중복 배제 (X) > 레코드의 중복 배제 (O)

*/

select continent from tblCountry;

-- tblCountry에는 어떤 어떤 대륙이 있습니까? > 종류
select distinct continent from tblCountry;

-- tblInsa 어떤 부서?
select distinct buseo from tblInsa;

-- tblInsa 어떤 직위?
select distinct jikwi from tblInsa;

-- 중복값이 존재하지 않을 때 dintinct? > 아무 일도 일어나지 않는다.
select distinct name from tblCountry;

select * from tblCountry;
select distinct continent from tblCountry; -- + 각 대륙에 어떤 나라가 있는지를 같이 표시하고 싶음

-- ***** 공용 데이터와 개별 데이터는 하나의 테이블에 넣을 수 없다.
-- (JAVA: 공용 데이터와 개별 데이터는 메모리 한곳에 넣을 수 없다. 공용은 static, 개별은 stack)

select * from tblComedian;
select distinct continent, name from tblCountry;

select distinct continent from tblCountry;
select continent, name from tblCountry;

select distinct gender, weight from tblComedian;


/*

    case
    - 컬럼 리스트에서 사용
    - 다른 절에서 사용
    - 자바의 조건문 역할 > 컬럼값 조작
    - 모든 조건에 불일치 > null 반환! (*******)


select
    case
        when 조건 then 반환값
    end
from

*/

select
    last || first as name,
    case
        when gender = 'm' then '남자'
        when gender = 'f' then '여자'
    end as gender
from tblComedian;

-- 국가명 + 대륙명
select name, continent,
    case
        when continent = 'AS' then '아시아'
        when continent = 'NA' then '북아메리카'
        when continent = 'EU' then '유럽'
        -- else '기타'
        -- else continent
        -- else name > 사용금지!! ** 하나의 속성(컬럼) 안에는 같은 도메인(성격, 표현)을 가지는 값이 들어간다. (*********)
        -- else population
        -- *** 모든 반환값이 동일한 성격 + 동일한 자료형을 가져야 한다.
    end as continentName
from tblCountry;


select
    last || first as name,
    weight,
    case
        when weight > 100 then '과체중'
        when weight > 50 then '정상체중'
        else '저체중'
    end as state,
    
    case
        when weight > 50 and weight <= 100 then '정상체중'
        else '이상체중'
    end as state2,
    
    case
        when weight between 50 and 100 then '정상체중'
        else '이상체중'
    end as state3
from tblComedian;

 
select
    name,
    jikwi,
    case
        when jikwi in ('부장', '과장') then '간부'
        else '평사원'
    end as state,
    
    case
        when name like '김%' then '김씨'
        when name like '이%' then '이씨'
        when name like '박%' then '박씨'
        else '기타'
    end as lastname
from tblInsa;


select
    title,
    case
        when completedate is null then '미완료'
        when completedate is not null then '완료'
    end as state
from tblTodo;


select
    name as 남자,
    case
        when couple is not null then couple
        else '없음'
    end as 여자친구
from tblMan;


select 
    name, jikwi, sudang,
    case
        when jikwi = '부장' then sudang * 2
        when jikwi = '과장' then sudang * 1.7
        when jikwi = '대리' then sudang * 1.5
        when jikwi = '사원' then sudang * 1.2
    end as bonus,
    
    case
        when jikwi in ('부장', '과장') then sudang * 2
        when jikwi in ('대리', '사원') then sudang * 1.5
    end as bonus2
from tblInsa;