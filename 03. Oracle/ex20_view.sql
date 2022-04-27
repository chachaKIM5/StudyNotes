-- ex20_view.sql

/*

    View, 뷰
    - 데이터베이스 객체 중 하나(CREATE,ALTER,DROP > 테이블, 시퀀스, 제약사항, 뷰)
    - 가상 테이블, 복사 테이블, 뷰 테이블 등...
    - 테이블처럼 사용한다. (***********)
    - 반복된 SELECT or 긴 SELECT > 뷰 생성 > 효과
    - 뷰의 정의 > SQL을 저장한 객체 (***********************)
    
    
    CREATE VIEW 뷰이름
    AS
    SELECT문;


    --'뷰이름'이 없으면 만들고, 있으면 덮어쓴다
    CREATE OR REPLACE VIEW 뷰이름
    AS
    SELECT문;


*/


create view vwInsa
as
select * from tblInsa;

select * from vwInsa; --tblInsa처럼 행동

drop view vwInsa;

create or replace view vwINsa
as
select * from tblInsa where buseo = '영업부';

select * from vwInsa;



-- 뷰 사용 용도? > 쿼리의 양을 줄이는 게 목적
--select * from tblInsa where buseo = '영업부'; vs select * from vwInsa;



-- 비디오 가게 사장 > 하루 업무
create or replace view 대여체크
as
select
    m.name as mname,
    v.name as vanme,
    to_char(r.rentdate, 'yyyy-mm-dd') as rentdate,
    case
        when r.retdate is not null then '반납 완료'
        else '반납 미완료'
    end as state
from tblRent r
    inner join tblVideo v
        on v.seq = r.video
            inner join tblMember m
                on m.seq = r.member;
                
                
                
select * from 대여체크;




-- tblInsa > 서울 직원 > view
create or replace view vwSeoul
as
select * from tblInsa where city = '서울'; -- 뷰를 만드는 시점 : 20명

-- tblInsa > 서울 직원 3명 제주로 발령

-- A와 B는 같다
select * from vwSeoul; -- 20명                             -- A. 실명. 이름이 있는 뷰 
select * from (select * from tblInsa where city = '서울'); -- B. 익명. 이름이 없는 뷰


update tblInsa set city = '제주' where num in (1001, 1005, 1008); -- VIEW가 아니라 tblInsa를 수정
select * from tblInsa where city = '서울'; -- 17명

select * from vwSeoul; -- 20명 > 17명, VIEW는 단순한 복사본이 아니다




-- 권한 > 계정별로 객체에 대한 접근/조작 등을 통제

select * from tblInsa;  -- 신입은 tblInsa의 basicpay, sudang 접근 권한 없도록 하고 싶으면?
select * from 신입전용; -- 신입은 tblInsa의 접근 권한 X, 신입전용 view에 접근 권한을 줌

create or replace view 신입전용
as
select num, name, ssn, city from tblInsa;



create or replace view vwTodo
as
select * from tblTodo;



--뷰 사용 (주의점)
-- 1. SELECT > 실행 O > 뷰는 읽기 전용으로 사용한다. (*****) == """"읽기 전용 테이블""""
-- 2. INSERT > 실행 O > 절대 사용 금지 > 직접 테이블에서 처리
-- 3. UPDATE > 실행 O > 절대 사용 금지 > 직접 테이블에서 처리
-- 4. DELETE > 실행 O > 절대 사용 금지 > 직접 테이블에서 처리

select * from vwTodo;
insert into vwTodo values (21, '오라클 정리하기', sysdate, null);
update vwTodo set completedate = sysdate where seq = 21;
delete from vwTodo where seq = 21;


--vwTodo의 데이터 조작이 실행되었던 이유 > 단순뷰이기 때문에 > 뷰의 SELECT가 1개의 테이블로 구성
select * from 대여체크;
insert into 대여체크 values ('홍길동', '영구와 땡칠이', sysdate, '미완료'); --불가능! 복합뷰이기 때문에 > 2개 이상의 테이블을 SELECT


-- >>>> ****** 뷰 이름만 봐서는 단순뷰인지 복합뷰인지 알 수 없다 >> INSERT, UPDATE, DELETE 절대 사용 금지! 