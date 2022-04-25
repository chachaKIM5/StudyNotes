-- ex17_group_by.sql


/*


    GROUP BY
    - GROUP BY 컬럼명
    - GROUP BY 컬럼명, 컬럼명, 컬럼명
    - 레코드들을 특정 컬럼값(1~N)으로 그룹을 나누는 역할
    - 그룹을 나누는 이유: 각각의 나눠진 그룹을 대상 > 집계 함수를 적용하기 위해서 (****************)

    SELECT 컬럼리스트
    FROM 테이블
    WHERE 조건
    GROUP BY 기준
    ORDER BY 기준
    
    
    
    실행 순서
    1. FROM 테이블
    2. WHERE 조건
    3. GROUP BY 기준
    4. SELECT 컬럼리스트
    5. ORDER BY 기준
    
    
*/



-- tblInsa. 부서별 평균 급여?
select * from tblINsa;

select round(avg(basicpay)) from tblInsa; --1556527 (60명 평균)

select distinct buseo from tblInsa; -- 7개

select round(avg(basicpay)) from tblInsa where buseo = '총무부';
select round(avg(basicpay)) from tblInsa where buseo = '개발부';
select round(avg(basicpay)) from tblInsa where buseo = '영업부';
select round(avg(basicpay)) from tblInsa where buseo = '기획부';
select round(avg(basicpay)) from tblInsa where buseo = '인사부';
select round(avg(basicpay)) from tblInsa where buseo = '자재부';
select round(avg(basicpay)) from tblInsa where buseo = '홍보부';


-- group by를 사용하면 컬럼리스트에는 2가지만 사용 가능
-- 1. 집계 함수
-- 2. group by 뒤에 있는 컬럼 이름

select
    --name, -- ORA-00979: not a GROUP BY expression > 개별값 (개인의 데이터)
    buseo, --집합값(여러명의 값을 가지고 낸 결과)
    round(avg(basicpay))
from tblInsa
    group by buseo;
    
    


select
    count(*) as "전체 인원수",
    sum(basicpay) as "전체 지급액",
    round(avg(basicpay)) as "전체 평균급여",
    max(ibsadate) as "전체 막내 입사일",
    min(ibsadate) as "전체 최고참 입사일"
from tblInsa;



-- 남자? 여자?
-- A보다 B가 더 자주 쓰인다

-- A.
select * from tblComedian;

select
    count(decode(gender, 'm', 1)) as "남자수",
    count(decode(gender, 'f', 2)) as "여자수"
from tblComedian;


-- B.
select
    gender,
    count(*)
from tblComedian
    group by gender;
    
    


-- 지역별 인원수?
select
    city,
    count(*) as cnt
from tblInsa
    group by city
        order by cnt desc;
        
        
select
    continent,
    count(*),
    sum(population)
from tblCountry
    group by continent;
    
    

select
    gender,
    max(height),
    min(height),
    max(weight),
    min(weight)
from tblComedian
    group by gender;



select
    buseo,
    jikwi,
    city,
    count(*)
from tblInsa
    group by buseo, jikwi, city
        order by buseo asc, jikwi asc;
        
        
        
        
        
-- 급여별 그룹
-- 100만 원 이하
-- 100만 원 ~ 200만 원
-- 200만 원 이상

select
    basicpay,
    count(*)
from tblInsa
    group by basicpay;
    
    
select
    basicpay,
    floor(basicpay / 1000000)
from tblInsa;


select
    (floor(basicpay / 1000000) + 1) * 100 || '만원대 이하',
    count(*)
from tblInsa
    group by floor(basicpay / 1000000)
        order by floor(basicpay / 1000000) asc;
        
        
        
-- tblTodo. 한 일의 개수? 안 한 일의 개수? > 일의 완료 유무


-- 12  8
select
    count(case
        when completedate is not null then 'O'
    end) as "한 일",
    count(case
        when completedate is null then 'X'
    end) as "안 한 일"
from tblTodo;



-- O 12
-- X 8
select
    case
        when completedate is not null then 'O'
        else 'X'
    end as iscompleted,
    count(*)
from tblTodo
    group by case
        when completedate is not null then 'O'
        else 'X'
        end;
        
        


-- 지역별 인원수?
select distinct city from tblInsa;


-- 모든 지역을 수동으로 작성해야 함! x 11번 작성...
-- 신입 사원 입사 > "강릉" 거주
-- 새로운 데이터 / 수정된 데이터에 아주 취약한 방식!!!! > 정적인 데이터에는 무난.
select
    count(decode(city, '서울', 1)) as "서울",
    count(decode(city, '인천', 2)) as "인천",
    count(decode(city, '경기', 3)) as "경기"
from tblInsa;


-- 새로운 데이터(새로운 도시!) 수정 필요없이 추가되어도 알아서 그룹을 나눠준다. > 정적/동적인 데이터 모두에 무난.
select
    city,
    count(*)
from tblInsa
    group by city;
    
    
    
    
    /*

    WHERE 절
    - 조건절
    - FROM의 조건

    HAVING
    - 반드시 GROUP BY와 같이 사용 (단독 사용 불가)
    -
    
    
    
    SELECT 컬럼리스트
    FROM 테이블
    WHERE 조건
    GROUP BY 기준
    HAVING 조건
    ORDER BY 기준
    
    
    
    실행 순서
    1. FROM 테이블
    2. WHERE 조건
    3. GROUP BY 기준
    4. HAVING 조건
    5. SELECT 컬럼리스트
    6. ORDER BY 기준
    
    
*/



--평균 급여가 150만 원 이상인 부서?

select                               --4: 급여가 150만 원 이상인 사람들의 평균 급여 
    buseo,
    round(avg(basicpay))
from tblInsa                         --1: 60명의 데이터를 가져온다
    where basicpay >= 1500000        --2: 60명을 대상으로 조건 검사
        group by buseo;              --3: 2번을 통과한 27명을 대상으로 그룹 형성

총무부	2431333
개발부	2303750
영업부	2164275
기획부	2174000
인사부	2200000
자재부	2410000
홍보부	1967000

    
select                                      --4: 출력
    buseo,
    round(avg(basicpay))
from tblInsa                                --1: 60명의 데이터를 가져온다
    group by buseo                          --2: 60명을 대상으로 그룹 형성
        having avg(basicpay) >= 1500000;    --3: 그룹을 대상으로 조건 검사 > 그룹을 탈락시킨다
        
       
총무부	1714857
영업부	1601513
기획부	1855714
인사부	1533000


select                                                --5: 컬럼을 구성
    buseo,
    round(avg(basicpay))
from tblInsa                                          --1: 60명의 데이터를 가져온다.
    where basicpay >= 1500000                         --2: 60명 중 basicpay가 1500000 이상인 27명만 남긴다 (개인 탈락)
        group by buseo                                --3: 27명을 가지고 그룹 형성
            having avg(basicpay) >= 2200000;          --4: 그룹을 대상으로 그룹의 평균 급여가 2200000 이상인 부서만 남긴다 (부서 탈락)
                order by round(avg(basicpay)) asc;    --6: 정렬
                
                
                

-- 서울 직원 > 남/녀 그룹 > 그룹별 평균 급여 155만원 > 각 그룹의 인원수?
select
    decode(substr(ssn, 8, 1), '1', '서울 사는 남자', '2', '서울 사는 여자'),
    count(*)                                                                         --5
from tblInsa                                                                         --1
    where city = '서울'                                                              --2
       group by substr(ssn, 8, 1)                                                    --3
            having avg(basicpay) >= 1550000;                                         --4
            
            
            
            
            
            
-- 문제 풀이
--1. tblCountry) 대륙별 최대 인구수, 최소 인구수, 평균 인구수를 가져오시오

select 
    continent,
    max(population),
    min(population),
    round(avg(population))
from tblCountry
    group by continent;


--2. employees) 직업별(job_id) 직원수를 가져오시오.

select
    job_id,
    count(*)
from employees
    group by job_id;


--3. tblInsa) 부서별 부서인원수, 부서 내 최고급여, 최저급여, 평균급여를 가져오시오

select
    buseo,
    count(*),
    max(basicpay),
    min(basicpay),
    round(avg(basicpay))
from tblInsa
    group by buseo;


--4. tblInsa) 부서별 직급의 인원수를 가져오시오
-- [부서명]    [총인원]   [부장]    [과장]    [대리]    [사원]
-- 기획부            ?       ?          ?         ?         ?

select
    buseo as "[부서명]",
    count(*) as "[총인원]",
    count(decode(jikwi, '부장', 1)) as "[부장]",
    count(decode(jikwi, '과장', 2)) as "[과장]",
    count(decode(jikwi, '대리', 3)) as "[대리]",
    count(decode(jikwi, '사원', 4)) as "[사원]"
from tblInsa
    group by buseo;
    
    
    
    


/*
    
    group by + having + rollup + cube
    
    rollup()
    - group by의 결과에서 집계 결과를 좀 더 자세하게 반환
    - 그룹별 중간 통계를 내고자 할 때 사용
    - () 순서가 달라지면 다른 결과가 나옴    
    
    


*/


select
    buseo,
    count(*),
    round(avg(basicpay))
from tblInsa
    group by rollup(buseo);
    
    
    
select
    buseo,
    jikwi,
    count(*),
    round(avg(basicpay))
from tblInsa
    group by rollup(buseo, jikwi);   
    
    


/*
    
    cube()
    - group by의 결과에서 집계 결과를 더 자세하게 반환
    - 그룹별 중간 통계를 내고 싶을 때 사용
    - 순서에 상관없이 모든 경우의 수의 중간통계를 보여준다
    
*/


select
    jikwi,
    buseo,
    count(*),
    round(avg(basicpay))
from tblInsa
    group by cube(jikwi, buseo);   