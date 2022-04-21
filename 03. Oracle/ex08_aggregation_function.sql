-- ex08_aggregation_function.sql

/*

    자바
    - 클래스(객체) = 멤버 변수 + 멤버 메소드
    - 클래스가 소유하는 함수를 메소드라고 부른다.
    
    
    일반적인 언어에서는 함수는 독립적인 선언과 실행이 가능하다.
    
    
    
    함수, Function
    - 함수 역시 계정에 소속된다. HR
    1. 내장형 함수(Built-in Function)
    2. 사용자 정의 함수 (User Function) > PL/SQL


    함수의 특징
    - input(매개변수) > 처리 > output(반환값)

    
    집계함수, Aggregation Function (*****************)
    - 통계값을 구하는 함수
    1. count()
    2. sum()
    3. avg()
    4. max()
    5. min()
    
    
    
    1. count()
    - 결과 테이블의 레코드 수를 반환한다. > select 결과의 레코드 수를 반환
    - number count(컬럼명) : 매개변수 컬럼은 1개만 올 수 있다, 하지만 예외: * (와일드카드, all)
    
*/

select name from tblCountry;
select count(name) from tblCountry;

select name from tblCountry where continent = 'AS';
select count(name) from tblCountry where continent = 'AS'; --아시아에 속한 나라 개수

select count(*) from tblCountry; --14
select count(name) from tblCountry; --14
select count(capital) from tblCountry; --14
select count(population) from tblCountry; --13
select population from tblCountry; -- null이 1개 있다

select count(*) from tblTodo where completedate is null;     --8
select count(*) from tblTodo where completedate is not null; --12

select 
    count (*) as "전체 할일의 개수",
    count(completedate) as "한 일의 개수",
    count(*) - count(completedate) as "안 한 일의 개수"
from tblTodo;


-- tblInsa. 총 직원 명 수? 연락처 있는 직원 수? 없는 직원 수?
select
    count(*) as "총 직원 수",
    count(tel) as "연락처 있는 직원",
    count(*) - count(tel) as "연락처가 없는 직원"
from tblInsa;


-- tblInsa. 어떤 부서들이 있는지?
select distinct buseo from tblInsa;

-- tblInsa. 부서가 몇 개 있나요?
select count(distinct buseo) from tblInsa;


--tblComedian. 남자수? 여자수?
select * from tblComedian;

select count(*) from tblComedian where gender = 'm';
select count(*) from tblComedian where gender = 'f';

-- ************ 자주 사용되는 패턴, 꼭 복습하고 기억할 것
select
    count(case
        when gender = 'm' then gender
    end) as "남자인원수",
    count(case
        when gender = 'f' then gender
    end) as "여자인원수"
from tblComedian;


-- 대륙별 나라수?
select 
    count(case
        when continent = 'AS' then 1
    end) as "아시아",
    count(case
        when continent = 'AF' then 1
    end) as "아프리카",   
    count(case
        when continent = 'EU' then 1
    end) as "유럽"
from tblCountry;





/*

    2. sum()
    - 해당 컬럼의 합을 구한다.
    - number sum(컬럼명)
    - 숫자형만 적용 가능

*/

select sum(height) from tblComedian;
select sum(first) from tblComedian; --ORA-01722: invalid number

select
    sum(basicpay) as "지출 급여 합",
    sum(sudang) as "지출 수당 합",
    sum(basicpay) + sum(sudang) as "총 지출",
    sum(basicpay + sudang) as "총 지출"
from tblInsa;






/*

    3. avg()
    - 해당 컬럼값의 평균을 구한다
    - number avg(컬럼명)
    - 숫자형만 적용 가능
    - null을 제외함 (*****************)

*/


-- 평균 급여?
select sum(basicpay) / 60 from tblInsa;
select sum(basicpay) / count(*) from tblInsa;
select avg(basicpay) from tblInsa;

-- 주의!! > 모든 국가의 평균 인구수?
-- population에 null값이 있음!!
-- count(*) 하면 null값이 포함, count(population) 하면 null값이 미포함되어 결과값이 다르다

select
    avg(population),                    --15588.6153846153846153846153846153846154
    sum(population) / count(*),         --14475.1428571428571428571428571428571429
    sum(population) / count(population) --15588.6153846153846153846153846153846154
from tblCountry;


-- 회사 성과급 지급 > 성과급 출처 > 팀1의 공로
-- 1. 균등 지급: 총지급액 / 모든 팀원수 = sum() / count(*)
-- 2. 차등 지급: 총지급액 / 참여 팀원수 = sum() / count(참여인원) = avg()



/*

    4. max()
    - object max(컬럼명)
    - 최댓값 반환
    
    5. min()
    - object min(컬럼명)
    - 최솟값 반환

*/

select max(height), min(height) from tblComedian;

select max(name) from tblInsa;

select max(ibsadate), min(ibsadate) from tblInsa;

select
    count(*) as "영업부 직원수",
    sum(basicpay) as "영업부 총급여 합",
    avg(basicpay) as "영업부 평균 급여",
    max(basicpay) as "영업부 최고 급여",
    min(basicpay) as "영업부 최저 급여"
from tblInsa
    where buseo = '영업부';
    
    
    
    
    

-- 집계 함수 사용 주의점!

-- 1. ORA-00937: not a single-group group function
-- 컬럼리스트에 집계함수와 일반 컬럼은 동시 사용할 수 없다. > 성질이 다르기 때문에.
-- 집계 함수 반환값 = 집합 값

select count(*) from tblInsa; -- 직원 수
select name from tblInsa; --직원명

select count(*), name from tblInsa;
select count(*), 100 from tblInsa;

select count(*), sum(sudang) from tblInsa;


-- 2. ORA-00934: group function is not allowed here
-- where절에는 집계함수를 사용할 수 없다.
-- where절은 개인에 대한 질문(조건)을 다루는 영역이기 때문에!
select avg(baiscpay) from tblInsa;

select * from tblInsa where basicpay >= avg(basicpay);