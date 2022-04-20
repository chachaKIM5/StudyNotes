-- ex03_select.sql

/*

SQL, Query (질의)


SELECT문
 - DML, DQL
 - 관계대수 연산 중 셀렉션 작업을 구현한 명령어
 - 대상 테이블로부터 원하는 행(튜플)을 추출하는 작업 > 오라클 서버에 데이터 요구

SELECT문: 아래의 절들이 모여 하나의 문장을 이룬 형태

[WITH <Sub Query>] --WITH절
SELECT column_list --SELECT절
FROM table_name    --FROM절...
[WHERE search_condition]
[GROUP BY group_by_expression]
[HAVING serach_condition]
[ORDER BY order_expression [ASC|DESC]]


SELECT column_list
FROM table_name

*/


/*
    SELECT 컬럼리스트
    FROM 테이블;
    
    SELECT를 구성하는 절의 실행 순서 (**************)
    1. FROM 절
    2. SELECT 절
    
    1. FROM 테이블 > 데이터를 가져올 테이블을 지정한다
    2. SELECT 컬럼리스트 > 가져올 특정 컬럼을 지정한다
    
*/

-- SELECT: 셀렉션
-- 컬럼리스트: 프로젝션
select first_name
from employees;



--명령어
-- 1. SQL 명령어 > 기억 O 공부하기
-- 2. SQL Plus 명령어 > 기억할 필요 X

--desc 명령어(description): 해당 테이블의 스키마 > 컬럼 구조 보여주는 명령어
desc tblCountry;

-- 단일 컬럼 가져오기
select name from tblCountry;
select capital from tblCountry;
select population from tblCountry;

-- 여러 컬럼  가져오기(프로젝션)
select name,capital from tblCountry;
select name,capital,population,continent,area from tblCountry;
select * from tblCountry; -- 와일드카드 (*) > 모든 컬럼 가져오기

select name, name from tblCountry;
select name, length(name) from tblCountry;

-- 컬럼리스트의 순서는 원본 테이블의 컬럼 순서와 무관하다.
select name, capital from tblCountry;
select capital, name from tblCountry;


/*

시스템 테이블
    - 1. 사용자 정보
*/

--00942. 00000 -  "table or view does not exist"
--관리자 계정에서만 볼 수 있다!
select * from dba_users;

--  - 2. 특정 사용자가 소유한 테이블 정보
select * from tabs;
select * from dba_tables where owner = 'HR';

--  - 3. 특정 테이블의 컬럼 정보 > 스키마
select * from dba_tab_columns where owner = 'HR' and table_name = 'TBLCOUNTRY';