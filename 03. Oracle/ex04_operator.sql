--ex04_operator.sql


/*

    연산자, Operator
    
    1. 산술 연산자
    - +, -, *, /
    - %(없음) > 함수로 제공(mod())
    
    2. 문자열 연산자
    - + (X) > ||(O)
    
    3. 비교  연산자
    - >, >=, <=
    - =(같다), <>(같지 않다)
    - 논리값을 반환, 하지만 명시적으로 표현할 수 있는 자료형이 아님 > 내부적 처리에만 쓰임
    - 컬럼 리스트에서 사용 불가
    - 조건절에서 사용 가능
    
    4. 논리 연산자
    - and, or, not
    - 컬럼 리스트에서 사용 불가
    - 조건절에서 사용 가능
    
    5. 대입 연산자
    - =
    - 컬럼에 값을 넣을 때 사용함 (컬럼 = 값)
    - UPDATE문에서 사용
    
    6. 3항 연산자
    - 없음
    - 제어문 없음
    
    7. 증감 연산자
    - 없음
    
    8. SQL 연산자
    - 자바: instanceof, typeof 등...
    - in, between, like, is 등... (=연산자 = ~구 = ~절)
*/

select name||capital from tblCountry;

-- select name <> capital from tblCountry;
-- select population > area from tblCountry;




select * from tblMan;
select * from tblWoman;


-- 컬럼의 별칭(Alias) 만들기
-- 컬럼명 as 별명
-- SELECT의 결과 테이블에만 적용 > 일시적인 행동, **원본은 그대로!!**

select name, couple from tblMan;
select name from tblWoman;

select name as 남자이름, couple as 여자이름 from tblMan;

desc tblMan;

select name, weight as 회식전, weight + 5 as 회식후 from tblMan;

select name, name as name2 from tblMan;

-- 식별자로 쓰일 수 없는 것들을 무시하고 식별자로 쓸 수 있도록 해준다 -> ""
select name as "남자 이름" from tblMan;
select name as "10+20+30" from tblMan;
select name as "select" from tblMan;


-- 테이블 별칭 만들기

select
    hr.tblCountry.name,
    hr.tblCountry.capital,
    hr.tblCountry.population
from hr.tblCountry;
-- JAVA에서 클래스 앞에 패키지 붙이듯..
-- table 앞에 계정 이름 붙이고, 컬럼 이름 앞에 table 이름 붙이고...: 현재 계정이 가지고 있지 않아도 불러올 수 있다

select             -- 실행순서 2
    c.name,        
    c.capital,     
    c.population   
from tblCountry c; -- 실행순서 1

-- Alias: 같이 사용 가능한 별명 (X) > 개명

