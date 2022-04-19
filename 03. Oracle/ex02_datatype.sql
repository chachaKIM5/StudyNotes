/*

ex02_datatype.sql

ANSI-SQL 자료형
- 오라클 자료형

1. 숫자형
    - 정수, 실수
    a. number 
        - (유효자리) 38자리 이하의 숫자를 표현하는 자료형
        - 12345678901234567890123456789012345678
        - 5~22byte
        - 1x10^-130 ~ 9.9999x10^125
        
        - number
        - number(precision)
        - number(precision, scale)
        
        
2. 문자형
    - 문자, 문자열
    
3. 날짜/시간형

4. 이진 데이터형(binary형)




*/


/*
-- 테이블 선언(생성)

create table 테이블명 (
    컬럼 선언
    컬럼명 자료형,
    컬럼명 자료형,
    컬럼명 자료형
);


-- 테이블 삭제

drop table 테이블명;

*/
--오라클은 사용자가 정의한 식별자들을 DB에 저장할 때 항상 대문자로 변환해서 저장한다. (**********)

create table tblType (
    num number
);

drop table tblType;


-- 테이블 잘 만들어졌는지 확인?

select * from tabs; --tables > 현재 계정이 소유하고 있는 테이블 정보

select * from tabs where table_name = 'tblType'; -- 결과 X
select * from tabs where table_name = 'TBLTYPE'; -- 결과 O


-- 데이터 추가하기
--insert into 테이블명 (컬럼명) values (값);
insert into tblType (num) values (100);  --정수형 리터럴 -- 1 행 이(가) 삽입되었습니다.
insert into tblType (num) values (3.14); --실수형 리터럴

-- 데이터 가져오기
-- select * from 테이블명;
select * from tblType;