-- ex23_pseudo.sql


/*

    의사 컬럼, Pseudo Column
    - 실제 컬럼이 아닌데 컬럼처럼 행동하는 객체
    
    
    rownum
    - 행번호
    - 데이터
    - from절이 실행될 때 각 레코드에 rownum을 할당한다. (*******************)
    - where절의 영향을 받아 reindexing을 한다. (****************************)
    - rownum과 함께 서브 쿼리를 자주 사용한다. (****************************)

*/

select
    name, buseo,    -- 컬럼(속성)   > output > 객체의 특성에 따라 다른 값을 가진다
    rownum,         -- 의사 컬럼    > output > 컬럼의 모습이나 특성과 가장 유사함
    substr(name, 2),-- 함수         > input + output > 각기 다른 input인 name을 넣어 다른 output > 객체의 특성에 따라 다른 값을 가진다.
    sysdate,        -- 함수         > output > 모든 레코드가 동일한 값을 가진다.
    '상수'          -- 상수         > 모든 레코드가 동일한 값을 가진다
from tblInsa;


-- 게시판 > 페이지
-- 1페이지 > rownum between 1 and 20
-- 2페이지 > rownum between 21 and 40
-- 3페이지 > rownum between 41 and 60...


select name, buseo, rownum from tblInsa where rownum = 1;
select name, buseo, rownum from tblInsa where rownum <= 5;


select name, buseo, rownum from tblInsa where rownum = 10; --1(O), 2~60(X)
select name, buseo, rownum from tblInsa where rownum > 5;



select name, buseo, rownum      --2. 1에서 이미 할당된 숫자를 rownum 표현을 통해 가져온다
from tblInsa;                   --1. from절이 실행되는 순간 모든 레코드의 rownum이 할당


select name, buseo, rownum      --3. 소비
from tblInsa                    --1. 생성
where rownum = 1;               --2. 조건 > 1에서 생성된 번호를 조건으로 검색


select name, buseo, rownum      --3. 소비
from tblInsa                    --1. 생성
where rownum = 3;               --2. 조건 > 1에서 생성된 번호를 조건으로 검색




select name, buseo, basicpay, rownum    --2.
from tblInsa                            --1. 번호 생성
order by basicpay desc;                 --3. 


select
    name, buseo, basicpay,
    rownum          -- B절의 행번호
from (select        -- B절
            name, buseo, basicpay,
            rownum as rnum  -- A절이 실행될 때 할당된 행번호
      from tblInsa  -- A절
            order by basicpay desc)
                where rownum <= 3;
                
                

-- rnum(고정), rownum(계산되는 값)
select name, buseo, basicpay, rnum, rownum from (select
                name, buseo, basicpay,
                rownum as rnum         
            from (select      
                        name, buseo, basicpay
                  from tblInsa
                        order by basicpay desc))
where rnum >= 3 and rnum <= 7;


-- 원하는 정렬 상태 > 서브쿼리 1번
-- 원하는 범위의 rownum 가져오기 > 서브쿼리 1번 더



-- ********************** 자주 사용되는 패턴, 연습하기!
-- tblAddressBook. 고객 명단 > 페이지 단위 출력 > 10명씩

select * from tblAddressBook;

--1. 원하는 정렬을 한다
select * from tblAddressBook order by name asc;

--2. 1을 뷰로 생성 + rownum 생성
select a.*, rownum as rnum from (select * from tblAddressBook order by name asc) a;

--3. 2를 뷰로 생성 + 사용
select * from (select a.*, rownum as rnum from (select * from tblAddressBook order by name asc) a)
    where rnum between 1 and 10;
    
select * from (select a.*, rownum as rnum from (select * from tblAddressBook order by name asc) a)
    where rnum between 11 and 20;
    
select * from (select a.*, rownum as rnum from (select * from tblAddressBook order by name asc) a)
    where rnum between 21 and 30;
    

-- 반복되는 곳은 이름 있는 view로 만들자    
create or replace view vwAddressBook
as
select a.*, rownum as rnum from (select * from tblAddressBook order by name asc) a;


select * from vwAddressBook where rnum between 31 and 40;
select * from vwAddressBook where rnum between 41 and 50;