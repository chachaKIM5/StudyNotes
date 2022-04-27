-- ex19_join.sql

/*

    관계형 데이터베이스 시스템이 지양하는 것들
    - 해법: 테이블을 다시 수정해야 고쳐지는 것들
    1. 테이블에 기본키가 없는 상태 > 데이터 조작 곤란
    2. null이 많은 상태의 테이블 > 공간 낭비
    3. 데이터가 중복되는 상태 > 공간 낭비
    4. 하나의 속성값이 원자값이 아닌 상태 > 더 이상 쪼개지지 않는 값을 넣어야 한다.

*/


create table tblTest(
    name varchar2(30) not null,
    age number(3) not null,
    nick varchar2(30) not null,
    id varchar2(30) not null
);

-- 홍길동, 20, 바보, hong
-- 아무개, 25, 천재, any
-- 테스트, 22, 멍멍이, test
-- 홍길동, 20, 바보, hong        -- 물리적 문제 X : 자료형, 길이, not null 제약..

-- 홍길동 별명 수정
update tblTest set nick = '고양이' where id = 'hong';

-- 홍길동 탈퇴
delete from tblTest where 조건?



create table tblTest(
    name varchar2(30) primary key,
    age number(3) not null,
    hobby varchar2(300) null,
    hobby2 varchar2(300) null,
    hobby3 varchar2(300) null,
    .
    .
    .
    hobby8 varchar2(300) null
);

-- 홍길동, 20, 독서, null, null, null, null, null, null, null
-- 아무개, 25, 달리기, 헬스, 게임, null, null, null, null, null
-- 테스트, 22, 달리기, 헬스, 게임, 독서, 낮잠, 맛집, 여행, 코딩
-- 홍길동, 20, 독서, null, null, null, null, null, null, null
-- 홍길동, 20, 독서, null, null, null, null, null, null, null
-- 홍길동, 20, 독서, null, null, null, null, null, null, null
-- 홍길동, 20, 독서, null, null, null, null, null, null, null... 공간 낭비!!




-- 직원 정보
-- 직원(번호, 직원명, 급여, 거주지, 담당프로젝트)

create table tblStaff(
    seq number primary key,         --직원번호(PK)
    name varchar2(30) not null,     --직원명
    salary number not null,         --급여
    address varchar2(300) not null, --거주지
    project varchar2(300) null      --담당프로젝트
);



insert into tblStaff(seq, name, salary, address, project)
    values (1, '홍길동', 300, '서울시', '홍콩 수출');
    
insert into tblStaff(seq, name, salary, address, project)
    values (2, '아무개', 250, '인천시', 'TV 광고');

insert into tblStaff(seq, name, salary, address, project)
    values (3, '홍길동', 350, '의정부시', '매출 분석');


select * from tblStaff;


--'홍길동'에게 담당 프로젝트 1건 추가 > '고객 관리'
insert into tblStaff(seq, name, salary, address, project)
    values (4, '홍길동', 300, '서울시', '고객 관리');
    
--'호호호' 직원 추가 + '게시판 관리 + 회원 응대'
insert into tblStaff(seq, name, salary, address, project)
    values (5, '호호호', 250, '서울시', '게시판 관리, 회원 응대');
    

-- 'TV 광고' 담당자 호출
select * from tblStaff where project = 'TV 광고';

-- 'TV 광고' > 'SNS 광고'
update tblStaff set project = 'SNS 광고' where project = 'TV 광고'; -- project는 UQ가 아니기 때문에 TV 광고 중복으로 들어있을 가능성 항상 생각해야 함


-- '회원 응대' 담당자 호출
-- 찾을 수 없음: 문제점 - 데이터가 원자값이 아니다
select * from tblStaff where project = '회원 응대';
select * from tblStaff where instr(project, '회원 응대') > 0 ;


-- '회원 응대' > '고객 불만 대응'
update tblStaff set project = '고객 불만 대응' where instr(project, '회원 응대') > 0;
-- '게시판 관리, 회원 응대'가 통째로 '고객 불만 대응'으로...



-- '홍길동' > 연봉 인상 > 350만 원
update tblStaff set salary = 350 where seq = 1;

-- 급여 지금 > 담당자 > '홍길동' 급여 확인
-- 문제점!! > 같은 데이터를 2번 이상 저장
select * from tblStaff where name = '홍길동';


select * from tblStaff;




drop table tblStaff;


-- 직원 정보
-- 직원(번호(PK), 직원명, 급여, 거주지, 담당 프로젝트)
create table tblStaff(
    seq number primary key,         --직원번호(PK)
    name varchar2(30) not null,     --직원명
    salary number not null,         --급여
    address varchar2(300) not null  --거주지
);





-- 프로젝트 정보
-- 프로젝트(프로젝트명)

create table tblProject (
    seq number primary key,             -- 프로젝트 번호
    project varchar2(30) not null,      -- 프로젝트명
    staff_seq number not null           -- 직원번호
);



insert into tblStaff (seq, name, salary, address) values (1, '홍길동', 300, '서울시');
insert into tblStaff (seq, name, salary, address) values (2, '아무개', 250, '서울시');
insert into tblStaff (seq, name, salary, address) values (3, '하하하', 350, '부산시');

insert into tblProject (seq, project, staff_seq) values (1, '홍콩 수출', 1);    -- 홍길동
insert into tblProject (seq, project, staff_seq) values (2, 'TV 광고', 2);      -- 아무개
insert into tblProject (seq, project, staff_seq) values (3, '매출 분석', 3);    -- 하하하
insert into tblProject (seq, project, staff_seq) values (4, '노조 협상', 1);    -- 홍길동
insert into tblProject (seq, project, staff_seq) values (5, '대리점 분양', 2);  -- 아무개


-- 위 테이블 2개의 특징
--1. 원자값 보장
--2. 데이터 중복 X
select * from tblStaff;
select * from tblProject;


-- A. 신입 사원 입사 > 신규 프로젝트 담당
-- A.1 신입 사원 추가
insert into tblStaff (seq, name, salary, address) values (4, '호호호', 250, '성남시');

-- A.2 신규 프로젝트 추가
insert into tblProject (seq, project, staff_seq) values (6, '자재 매입', 4);

-- A.3 신규 프로젝트 추가 -> 문제 발생, 유령 직원???
insert into tblProject (seq, project, staff_seq) values (7, '고객 유치', 5); -- ****** 논리 오류, 5번 직원은 없다

-- '고객 유치' 담당자?
select staff_seq from tblProject where project = '고객 유치';
select * from tblStaff where seq = (select staff_seq from tblProject where project = '고객 유치');



-- B. '홍길동' 퇴사
-- B.1 '홍길동' 삭제
delete from tblStaff where seq = 1;

select * from tblStaff where seq = (select staff_seq from tblProject where project = 'TV 광고');
select * from tblStaff where seq = (select staff_seq from tblProject where project = '홍콩 수출');

-- B.2 '아무개' 퇴사 > 인수인계 (위임)

update tblProject set staff_seq = 3 where staff_seq = 2;

update tblProject set staff_seq = (select seq from tblStaff where name = '하하하')
    where staff_seq = (select seq from tblStaff where name = '아무개');

-- B.3 '아무개' 퇴사 > 삭제
delete from tblStaff where seq = 2;

select * from tblStaff;
select * from tblProject;



-- tblProject에 들어가는 staff_seq가 반드시 tblStaff에 존재하는지 검사 > 제약사항, foreign key
-- foreign key 제약사항 추가해서 A, B 시나리오 다시 해보기


drop table tblStaff;
drop table tblProject;




create table tblStaff(
    seq number primary key,         --직원번호(PK)
    name varchar2(30) not null,     --직원명
    salary number not null,         --급여
    address varchar2(300) not null  --거주지
); --부모 테이블


create table tblProject (
    seq number primary key,                                      -- 프로젝트 번호
    project varchar2(30) not null,                               -- 프로젝트명
    staff_seq number not null references tblStaff(seq)           -- 직원번호(FK) 외래키
); -- 자식 테이블

insert into tblStaff (seq, name, salary, address) values (1, '홍길동', 300, '서울시');
insert into tblStaff (seq, name, salary, address) values (2, '아무개', 250, '서울시');
insert into tblStaff (seq, name, salary, address) values (3, '하하하', 350, '부산시');

insert into tblProject (seq, project, staff_seq) values (1, '홍콩 수출', 1);    -- 홍길동
insert into tblProject (seq, project, staff_seq) values (2, 'TV 광고', 2);      -- 아무개
insert into tblProject (seq, project, staff_seq) values (3, '매출 분석', 3);    -- 하하하
insert into tblProject (seq, project, staff_seq) values (4, '노조 협상', 1);    -- 홍길동
insert into tblProject (seq, project, staff_seq) values (5, '대리점 분양', 2);  -- 아무개


-- A. 신입사원 추가, 신규 프로젝트 추가
insert into tblStaff (seq, name, salary, address) values (4, '호호호', 250, '성남시');

--ORA-02291: integrity constraint (HR.SYS_C007142) violated - parent key not found
insert into tblProject (seq, project, staff_seq) values (7, '고객 유치', 5);


-- B. '홍길동' 퇴사
-- ORA-02292: integrity constraint (HR.SYS_C007142) violated - child record found
-- tblProject에 '홍길동' 기본키 값을 foreign key 로 참조하고 있는 행이 발견됨 -> 삭제 불가!
delete from tblStaff where seq = 1;

-- 인수인계 홍길동(1) > 하하하(3)
update tblProject set staff_seq = (select seq from tblStaff where name = '하하하') 
    where staff_seq = (select seq from tblStaff where name = '홍길동');

-- 홍길동 퇴사
delete from tblStaff where seq = 1;

select * from tblStaff;
select * from tblProject;





-- 고객 테이블
create table tblCustomer (
    seq number primary key,          -- 고객번호(PK)
    name varchar2(30) not null,      -- 고객명
    tel varchar2(15) not null,       -- 연락처
    address varchar2(100) not null   -- 주소
);


-- 판매내역 테이블
create table tblSales (
    seq number primary key,                          -- 판매번호(PK)
    item varchar2(50) not null,                      -- 제품명
    qty number not null,                             -- 판매 수량
    regdate date default sysdate not null,           -- 판매일
    cseq number not null references tblCustomer(seq) -- 판매한 고객 번호(FK)
);

select * from tblCustomer;
select * from tblSales;



-- [비디오 대여점]
-- 장르 테이블
create table tblGenre (
    seq number primary key,         -- 장르 번호(PK)
    name varchar2(30) not null,     -- 장르명
    price number not null,          -- 대여가격
    period number not null          -- 대여기간(일)
);

-- 비디오 테이블
create table tblVideo (
    seq number primary key,                        -- 비디오 번호(PK)
    name varchar2(100) not null,                   -- 비디오 제목
    qty number not null,                           -- 보유 수량
    company varchar2(50) null,                     -- 제작사
    director varchar2(50) null,                    -- 감독
    major varchar2(50) null,                       -- 주연배우
    genre number not null references tblGenre(seq) -- 장르번호(FK)    
);

-- 고객 테이블
create table tblMember (
    seq number primary key,         -- 고객번호(PK)
    name varchar2(30) not null,     -- 고객명
    grade number(1) not null,       -- 고객등급(1,2,3)
    byear number(4) not null,       -- 생년
    tel varchar2(15) not null,      -- 연락처
    address varchar2(300) null,     -- 주소
    money number not null           -- 예치금
);


-- 대여 테이블
create table tblRent (
    seq number primary key,                           -- 대여번호(PK)
    member number not null references tblMember(seq), -- 회원번호(FK)
    video number not null references tblVideo(seq),   -- 비디오번호(FK)
    rentdate date default sysdate not null,           -- 대여시각
    retdate date null,                                -- 반납시각
    remark varchar2(500) null                         -- 비고
);


-- 장르 <- 비디오 <- 대여 -> 고객
select * from tblGenre;   --6
select * from tblVideo;   --11
select * from tblMember;  --10
select * from tblRent;    --6



/*

    조인, Join
    - (서로 관계를 맺은) 2개(1개) 이상의 테이블로 1개의 결과셋을 만드는 기술
    
    조인의 종류
    1. 단순 조인, CROSS JOIN, 카티션곱(데카르트곱)
    2. 내부 조인, INNER JOIN *****
    3. 외부 조인, OUTER JOIN *****
    4. 셀프 조인, SELF JOIN
    5. 전체 외부 조인, FULL OUTER JOIN
    
    
*/



-- 1. 단순 조인, CROSS JOIN, 카티션곱(데카르트곱)
-- SELECT 컬럼리스트 FROM 테이블A CROSS JOIN 테이블B;
    
--      - A 테이블 컬럼 개수 + B 테이블 컬럼 개수 = 결과셋 컬럼 개수
--      - A 테이블 레코드 개수 x B 테이블 레코드 개수 = 결과셋 레코드 개수
select * from tblCustomer; --3명
select * from tblSales;    --9건



select * from tblCustomer cross join tblSales; -- ANSI-SQL(*****)
select * from tblCustomer, tblSales;    -- Oracle




/*

    2. 내부 조인, INNER JOIN ********
    - 단순 조인에서 유효한 레코드만 추출한 조인
    
    SELECT 컬럼리스트 FROM 테이블A INNER JOIN 테이블B ON 테이블A.PK = 테이블B.FK; -- ANSI-SQL 구문
    
    SELECT 컬럼리스트 FROM 테이블A, 테이블B WHERE 테이블A.PK = 테이블B.FK; -- Oracle

    
    실제 사용 시
    SELECT
        컬럼리스트
    FROM 테이블A
        INNER JOIN 테이블B
            ON 테이블A.PK = 테이블B.FK; --조인 조건
*/


-- 직원 테이블, 프로젝트 테이블
-- 직원 명단을 가져오시오. (담당하는 프로젝트를 포함해서)
select * from tblStaff;

select * from tblProject;

select
    name, project
from tblStaff inner join tblProject
    on tblStaff.seq = tblProject.staff_seq;
    
    
--고객 정보와 판매내역을 가져오시오. > 고객명, 연락처, 어떤 물건을 몇 개 사갔는지?
-- 대부분의 상황에서 > 내부 조인의 결과는 자식 테이블 레코드와 동일한 레코드가 나온다.
-- 대부분의 상황에서 > 내부 조인의 결과는 부모 테이블 레코드가 반복되는 현상이 생긴다.
select
    name,
    tel,
    item,
    qty
from tblCustomer
    inner join tblSales
        on tblCustomer.seq = tblSales.cseq;
        -- on 부모테이블.PK = 자식테이블.FK;
        
        
select * from tblGenre; --Parent table

select * from tblVideo; --Child table


--비디오 제목(tblVideo)과 대여 가격(tblGenre)을 가져오시오.
--ORA-00918: column ambiguously defined: 컬럼이 모호하게 정의되었습니다.
select
    tblVideo.name,
    tblGenre.price
from tblGenre
    inner join tblVideo
        on tblGenre.Seq = tblvideo.Genre;
        
        
        
select
    v.name,
    g.price,
    g.name
from tblGenre g
    inner join tblVideo v
        on g.Seq = v.Genre;
        
        
        
select * from tblMan;
select * from tblWoman;

-- 커플 테이블
select
    m.name as "남자",
    w.name as "여자"
from tblMan m
    inner join tblWoman w
        on m.couple = w.name;
        
        
        
select * from tblCustomer;
select * from tblSales;


-- 서브쿼리와 조인은 겹치는 부분이 있다
-- 고객명 + 판매물품명을 가져오시오.

-- 1. 조인
select
    c.name as "고객명",
    s.item as "판매물품명"
from tblCustomer c
    inner join tblSales s
        on c.seq = s.cseq;


-- 2. 서브 쿼리
select
    --cseq as "고객번호",
    (select name from tblCustomer where seq = tblSales.cseq) as "고객명",
    item as "판매물품명"
from tblSales; -- 반드시 자식을 가져와야 한다




select * from tblGenre; -- 부모
select * from tblVideo; -- 자식   부모
select * from tblRent;  --        자식


--3개 테이블 조인하기

select
    v.name,         -- 어떤 비디오?
    r.rentdate,     -- 언제?
    g.price         -- 얼마?
from tblGenre g                             -- tblGenre x tblVideo
    inner join tblVideo v                   -- tblGenre x tblVideo
        on g.seq = v.genre                  -- tblGenre x tblVideo
            inner join tblRent r            -- tblVideo x tblRent
                on r.video = v.seq;         -- tblVideo x tblRent
                                            -- tblGenre x tblVideo x tblRent
                                            
                                            
-- 4개의 테이블을 조인
select
    -- 조인의 결과에는 *를 잘 사용하지 않는다.
    m.name as "회원명",
    v.name as "비디오명",
    r.rentdate as "대여일시",
    g.price as "가격"
from tblGenre g
    inner join tblVideo v
        on g.seq = v.genre
            inner join tblRent r
                on v.seq = r.video
                    inner join tblMember m
                        on m.seq = r.member;
                        
                        
select * from tblStaff; -- 직원
select * from tblSales; -- 판매

-- 부모, 자식 아니어도 join 가능하지만.. 100% 쓸모없는 결과!
select
    *
from tblStaff f
    inner join tblSales e
        on f.seq = e.cseq; -- 아무 상관없는 관계
        
        
        
-- HR > 7개
select * from employees;    -- 직원 정보
select * from jobs;         -- 직원들의 직업 정보
select * from departments;  -- 직원들의 부서 정보
select * from locations;    -- 부서가 위치한 지역 정보
select * from countries;    -- 지역이 속한 국가 정보
select * from regions;      -- 국가가 속한 대륙 정보
select * from job_history;  -- 직원들의 이직 이력

select
    e.first_name || ' ' || e.last_name as "직원명",
    d.department_name as "부서명",
    l.city as "도시명",
    c.country_name as "국가명",
    r.region_name as "대륙명",
    j.job_title as "직업"
    
from employees e
    inner join departments d
        on d.department_id = e.department_id
            inner join locations l
                on d.location_id = l.location_id
                    inner join countries c
                        on c.country_id = l.country_id
                            inner join regions r
                                on r.region_id = c.region_id
                                    inner join jobs j
                                        on j.job_id = e.job_id;
                                        
                                        




select * from tblCustomer; --3명
select * from tblSales;    --9건

insert into tblCustomer values (4, '호호호', '010-1234-5678', '서울시');

-- 9개 > 9개
-- 문장: 절의 실행 순서대로 읽는 연습 + 부드럽게(업무상) 표현
-- > 물건을 한 번이라도 구매한 이력이 있는 고객의 정보와 그 고객이 사간 판매 내역을 가져오시오.

-- 내부 조인의 특징 > 두 테이블에 '동시에' 존재하는 정보만을 가져온다! (***************) 일종의 교집합
select
    *
from tblCustomer c
    inner join tblSales s
        on c.seq = s.cseq;
        

-- inner join과 cross join의 비교
select
    *
from tblCustomer c
    cross join tblSales s;
    
    
    
    
/*

    3. 외부 조인, OUTER JOIN *****
    - INNER JOIN의 반대 X
    - INNER JOIN의 결과 + 결과 셋에 포함되지 못한 부모 테이블의 나머지 레코드를 합하는 행동
    
    SELECT
        컬럼리스트
    FROM 테이블A
        INNER JOIN 테이블B
            ON 테이블A.컬럼 = 테이블B.컬럼;
            
    SELECT
        컬럼리스트
    FROM 테이블A
        (LEFT|RIGHT) OUTER JOIN 테이블B
            ON 테이블A.컬럼 = 테이블B.컬럼;

*/


-- 단순 조인 > 테이블 행 x 테이블 행 > 유효 O + 유효 X > 더미 데이터
-- 내부 조인 > 단순 조인 결과 > 유효한 행 추출
--           > 양쪽 테이블 모두 존재하는 데이터만 가져온다.


select * from tblCustomer; -- 4명(3명 구매 이력 있음, 1명 구매 이력 없음)
select * from tblSales;    -- 9건(3명이 구매한 이력)


-- >>한 번이라도 구매한 이력이 있는<< 고객 정보와 함께 구매 이력을 가져오시오.

select 
    *
from tblCustomer c
    inner join tblSales s
        on c.seq = s.cseq;
        

-- >>구매 이력과 상관없이<<          고객 정보와 함께 구매 이력을 가져오시오.

select
    *
from tblCustomer c
    left outer join tblSales s
        on c.seq = s.cseq;
        
        
        

-- tblVideo, tblRent


select * from tblVideo;
select * from tblRent;

-- 대여가 한 번이라도 된 비디오와 그 대여 내역을 가져오시오.

select
    *
from tblVideo v
    inner join tblRent r
        on v.seq = r.video;
        

-- 대여가 한 번이라도 됐었던 상품의 개수?
select
    count(distinct v.name) as "대여 기록 있는 개수"
from tblVideo v
    inner join tblRent r
        on v.seq = r.video;
    

-- 대여와 상관없이 모든 비디오와 그 대여 내역을 가져오시오.
select
    *
from tblVideo v
    left outer join tblRent r
        on v.seq = r.video;
        

-- tblMember, tblRent

select * from tblMember;
select * from tblRent;

-- 대여를 한 번이라도 한 고객의 정보와 대여 내역을 가져오시오.
select
    *
from tblMember m
    inner join tblRent r
        on m.seq = r.member;

-- 대여와 상관없이 모든 고객의 정보와 대여 내역을 가져오시오.
select
    *
from tblMember m
    left outer join tblRent r
        on m.seq = r.member;

        
-- 대여 기록이 있는 회원의 이름과 대여 횟수를 가져오시오.
select
    m.name,
    count(r.seq)
from tblMember m
    inner join tblRent r
        on m.seq = r.member
            group by m.name;
            
            
-- 대여 기록과 무관하게 모든 회원의 이름과 대여 횟수를 가져오시오.

select
    m.name,
    count(r.seq) --*********** 복습!
from tblMember m
    left outer join tblRent r
        on m.seq = r.member
            group by m.name
                order by count(r.seq) desc;
                
                
    
    
    
/*

    4. 셀프 조인, SELF JOIN
    - 1개의 테이블을 사용해서 조인
    - 테이블이 스스로 관계를 맺는 경우
    
    - 다중 조인(2개~) + 내부 조인
    - 다중 조인 + 외부 조인
    
    - 셀프 조인(1개) + 내부 조인
    - 셀프 조인 + 외부 조인

*/


-- 직원 테이블
create table tblSelf (
    seq number primary key,                    -- 직원번호(PK)
    name varchar2(30) not null,                -- 직원 이름
    department varchar2(50) null,              -- 부서
    super number null references tblSelf(seq)  -- 상사번호
)


insert into tblSelf values (1, '홍사장', null, null);
insert into tblSelf values (2, '김부장', '영업부', 1);
insert into tblSelf values (3, '이과장', '영업부', 2);
insert into tblSelf values (4, '정대리', '영업부', 3);
insert into tblSelf values (5, '최사원', '영업부', 4);
insert into tblSelf values (6, '박부장', '개발부', 1);
insert into tblSelf values (7, '하과장', '개발부', 6);

select * from tblSelf;

-- 직원 명단을 가져오시오. 단 상사의 이름까지
-- 푸는 방법: join, sub query

-- join으로 풀어보기
select
    b.name as "직원 이름",
    b.department as "직원 부서",
    a.name as "상사 이름"
from tblSelf a                        -- 역할: 부모 > 상사 테이블
    right outer join tblSelf b        -- 역할: 자식 > 직원 테이블
        on a.seq = b.super;
        
        
-- sub query로 풀어보기

select
    seq as "직원번호",
    name as "직원명",
    department as "부서명",
    super as "상사번호",
    (select name from tblSelf where seq = s.super) as "상사명"
from tblSelf s;





-- employees, 직원의 이름과 매니저 이름을 가져오시오.
select * from employees;

select
    b.first_name as "직원명",
    a.first_name as "매니저명"
from employees a                -- 매니저
    inner join employees b      -- 직원
        on a.employee_id = b.manager_id;
        
        





-- 5. 전체 외부 조인, FULL OUTER JOIN
-- 서로 참조하고 있는 관계에서만 사용이 가능한 조인

select * from tblMan;
select * from tblWoman;

select 
    *
from tblMan m
    left outer join tblWoman w
        on m.couple = w.name;
        
select 
    *
from tblMan m
    right outer join tblWoman w
        on m.couple = w.name;
        
        
    
select 
    *
from tblMan m
    full outer join tblWoman w
        on m.couple = w.name;
        



    
select
    *
from tblCustomer c
    left outer join tblSales s  --부모 가리킨 조인
        on c.seq = s.cseq;    
    
select
    *
from tblCustomer c
    right outer join tblSales s --자식 가리킨 조인 == 대부분 내부 조인
        on c.seq = s.cseq;
        
        
select
    *
from tblCustomer c
    full outer join tblSales s --left outer join과 동일한 결과, 서로 참조하는 관계에 있을 때에만 full outer join이 유의미하다
        on c.seq = s.cseq;
        
        
