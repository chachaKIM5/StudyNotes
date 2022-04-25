-- ex13_ddl.sql

/*

    ex01 ~ ex12: DML의 기본
    
    DDL
    - 데이터 정의어
    - 데이터 정의?: 데이터베이스 객체를 생성/수정/삭제하는 작업
    - 데이터베이스 객체 > 대표적으로 테이블. 나머지: 뷰, 인덱스, 프로시저, 트리거, 제약 사항, 시노닙 등..
    - CREATE, ALTER, DROP
    
    테이블 생성하기 > 스키마 정의하기 > 속성(컬럼) 정의하기 > 속성(컬럼)의 성격(이름)과 도메인(자료형, 제약)을 정의하기
    
    CREATE TABLE 테이블명
    (
        컬럼 정의,
        [컬럼 정의, X n]
        컬럼명 자료형(길이) NULL 제약사항 --컬럼 정의의 원형
    );


    제약 사항, Constraint
    - 해당 컬럼에 들어갈 데이터(값)에 대한 조건
        > 조건에 만족하면 > 대입
        > 조건에 만족하지 못하면 > 에러 발생
    - 유효성 검사 도구
    - 데이터 무결성을 보장하기 위한 도구 (*****)

    1. NOT NULL
        - 해당 컬럼이 반드시 값을 가져야 한다.
        - 해당 컬럼에 값이 없으면 에러 발생
        - 필수값!
        
    2. PRIMARY KEY, PK
        - 기본키: 행을 식별하는 수많은 키들 중 대표로 지정한 키
        - 테이블의 행을 구분하기 위한 제약사항
        - 모든 테이블 안에는 반드시 1개의 기본키가 존재해야 한다. (*********)
        - 중복값을 가질 수 없다 > Unique
        - 값을 반드시 가진다 > not null
            - Unique(4) + not null(1) = PRIMARY KEY
        
    3. FOREIGN KEY
    
    4. UNIQUE
        - 유일하다 > 행들 간에서 동일값을 가질 수 없다.
        - UNIQUE 제약은 null을 가질 수 있다 
        ex) 경품
            - 고객(번호(PK),이름,주소,당첨(UQ))
                1,홍길동,서울,1등
                2,아무개,부산,NULL
                3,하하하,서울,2등
                4,호호호,경기,3등
                5,후후후,제주,NULL
        ex) 초등학교 교실
            - 학생(번호(PK),이름,직책(UQ))
                1,홍길동,반장
                2,아무개,체육부장
                3,하하하,부반장
                4,호호호,NULL
                5,후후후,NULL
                
    5. CHECK
        - 사용자 정의 제약 조건
        - where절과 동일한 조건을 컬럼에 적용한다.
        
    6. DEFAULT
        - 기본값 설정
        - insert/update 작업 때 컬럼값을 대입하지 않으면(null) null 대신 미리 설정한 값을 넣는다.

*/



-- 1. NOT NULL

-- 메모 테이블
create table tblMemo (

    -- 컬럼명 자료형(길이) NULL 제약사항
    seq number(3) null,              -- 메모번호
    name varchar2(30) null,          -- 작성자
    memo varchar2(1000) null,        -- 메모
    regdate date null                -- 작성날짜
);


select * from tblMemo;

insert into 테이블(컬럼리스트) values (값리스트);

insert into tblMemo(seq, name, memo, regdate) values (1, '홍길동', '메모입니다.', sysdate);
insert into tblMemo(seq, name, memo, regdate) values (2, '아무개', null, sysdate);
insert into tblMemo(seq, name, memo, regdate) values (3, null, null, null);
insert into tblMemo(seq, name, memo, regdate) values (null, null, null, null); -- 절대 생성 금지!!!!!
insert into tblMemo(seq, name, memo, regdate) values (4, '홍길동', '테스트', '2022-01-01'); -- 편법, 암시적인 형변환 일어난다
insert into tblMemo(seq, name, memo, regdate) values (4, '홍길동', '테스트', '2022-01-01 12:30:00'); -- 에러, 지금 표현 형식은 시간을 넣을 곳이 없기 때문에

insert into tblMemo(seq, name, memo, regdate) values (5, '홍길동', '테스트', to_date('2022-01-01 12:30:00', 'yyyy-mm-dd hh24:mi:ss')); -- 정석적인 방법



drop table tblMemo;

create table tblMemo (

    seq number(3) not null,          -- 메모번호(NN)
    name varchar2(30) null,          -- 작성자
    memo varchar2(1000) not null,    -- 메모(NN)
    regdate date null                -- 작성날짜
);


insert into tblMemo(seq, name, memo, regdate) values (1, '홍길동', '메모입니다.', sysdate);

--ORA-01400: cannot insert NULL into ("HR"."TBLMEMO"."MEMO")
insert into tblMemo(seq, name, memo, regdate) values (1, '홍길동', null, sysdate);
insert into tblMemo(seq, name, memo, regdate) values (1, '홍길동', '', sysdate);  -- null 말고 ''도 안 됨!
insert into tblMemo(seq, name, memo, regdate) values (1, '홍길동', ' ', sysdate); -- ' '는 된다

select * from tblMemo;





-- 2. PRIMARY KEY

drop table tblMemo;

create table tblMemo (

    seq number(3) primary key,          -- 메모번호(PK)
    name varchar2(30) null,          -- 작성자
    memo varchar2(1000) not null,    -- 메모(NN)
    regdate date null                -- 작성날짜
);

insert into tblMemo(seq, name, memo, regdate) values (1, '홍길동', '메모입니다.', sysdate);

-- 에러: ORA-00001: unique constraint (HR.SYS_C007081) violated > 중복값을 넣으려고 시도
insert into tblMemo(seq, name, memo, regdate) values (1, '홍길동', '메모입니다.', sysdate);

insert into tblMemo(seq, name, memo, regdate) values (2, '홍길동', '메모입니다.', sysdate);

-- 에러: ORA-01400: cannot insert NULL into ("HR"."TBLMEMO"."SEQ")
insert into tblMemo(seq, name, memo, regdate) values (null, '홍길동', '메모입니다.', sysdate);

select * from tblMemo;



create table tblMemo (

    -- 컬럼명 자료형(길이) NULL 제약사항
    seq number(3) null,              -- 메모번호
    name varchar2(30) null,          -- 작성자
    memo varchar2(1000) null,        -- 메모
    regdate date null                -- 작성날짜
);

insert into tblMemo(seq, name, memo, regdate) values (1, '홍길동', '메모입니다.', sysdate);
insert into tblMemo(seq, name, memo, regdate) values (2, '아무개', null , sysdate);

-- 2번째 행을 가져오기 위한 where절 조건
select * from tblMemo where seq = 1;




-- 4. UNIQUE

drop table tblMemo;

create table tblMemo (

    seq number(3) primary key,          --메모번호(PK)
    name varchar2(30) unique null,      --작성자(UQ)
    memo varchar2(1000) not null,       --메모(NN)
    regdate date null                   --작성날짜
);

insert into tblMemo(seq, name, memo, regdate) values (1, '홍길동', '메모입니다.', sysdate);

--에러: ORA-00001: unique constraint (HR.SYS_C007083) violated
insert into tblMemo(seq, name, memo, regdate) values (2, '홍길동', '메모입니다.', sysdate);
insert into tblMemo(seq, name, memo, regdate) values (2, '아무개', '메모입니다.', sysdate);


-- PRIMARY와 UNIQUE의 차이? UNIQUE는 null을 넣을 수 있다. 심지어 여러 개 넣을 수 있음
-- -> null은 중복을 허용함, '값'으로 취급 안 하기 때문에
insert into tblMemo(seq, name, memo, regdate) values (3, null, '메모입니다.', sysdate);
insert into tblMemo(seq, name, memo, regdate) values (4, null, '메모입니다.', sysdate);

select * from tblMemo;




-- 5. CHECK (활용도 높다!)

drop table tblMemo;

create table tblMemo (

    seq number(3) primary key,                                                             --메모번호(PK)
    name varchar2(30),                                                                     --작성자
    memo varchar2(1000),                                                                   --메모
    regdate date,                                                                          --작성날짜
    priority number check (priority between 1 and 3),                                      --1(중요), 2(보통), 3(안중요)
    category varchar2(30) check (category in ('할일', '장보기', '공부', '가족', '친구'))   --할일,장보기,공부,가족,친구
    
);

insert into tblMemo(seq, name, memo, regdate, priority, category)
                     values (1, '홍길동', '메모입니다.', sysdate, 1, '할일');
                    
-- ORA-02290: check constraint (HR.SYS_C007088) violated
insert into tblMemo(seq, name, memo, regdate, priority, category)
                     values (2, '홍길동', '메모입니다.', sysdate, 5, '할일');

-- ORA-02290: check constraint (HR.SYS_C007089) violated                     
insert into tblMemo(seq, name, memo, regdate, priority, category)
                     values (2, '홍길동', '메모입니다.', sysdate, 3, '코딩');
                     
                     
-- check 조건과 not null은 별개, 서로 간섭 X
-- check는 값이 있을 때만 검사한다. null도 거르고 싶으면 check 옵션 뒤에 not null을 붙여주기
--     category varchar2(30) check (category in ('할일', '장보기', '공부', '가족', '친구')) not null
insert into tblMemo(seq, name, memo, regdate, priority, category)
                     values (2, '홍길동', '메모입니다.', sysdate, null, null);
                     
select * from tblMemo;





-- 6. DEFAULT
-- *** 사용자가 값을 넣을 의지가 없을 때에만 default 값이 들어간다

drop table tblMemo;

create table tblMemo (

    seq number(3) primary key,                 --메모번호(PK)
    name varchar2(30) default '(익명)',        --작성자
    memo varchar2(1000),                       --메모
    regdate date                               --작성날짜
    
);


insert into tblMemo(seq, name, memo, regdate) values (1, '홍길동', '메모입니다.', sysdate);
insert into tblMemo(seq, name, memo, regdate) values (2, null, '메모입니다.', sysdate); -- null이 들어간다, 개발자의 의도적 표현으로 취급

-- 소극적인 default 실행 방법
-- default가 없으면 null이 들어가고, default 제약 사항이 있으면 들어간다
insert into tblMemo(seq, memo, regdate) values (3, '메모입니다.', sysdate);             -- default 제약 사항으로 설정한 값이 들어간다, 비의도적 표현으로 취급


-- 적극적인 default 실행 방법
insert into tblMemo(seq, name, memo, regdate) values (4, default, '메모입니다.', sysdate);

select * from tblMemo;



drop table tblMemo;

create table tblMemo (

    seq number(3) primary key,                                                             --메모번호(PK)
    name varchar2(30) default '(익명)',                                                    --작성자
    memo varchar2(1000),                                                                   --메모
    regdate date default sysdate                                                           --작성날짜
    
);


-- '작성 날짜에는 신경쓰고 싶지 않다' = default 값으로 sysdate 넣어둔다
insert into tblMemo(seq, name, memo) values (1, '홍길동', '메모입니다.');
select * from tblMemo;






-- 3. FOREIGN KEY는 다음 시간에!



---------- ▼ 복습 후 4/25 수업 ▼ -----------


-- DDL > 테이블 생성 > 컬럼 생성 = 컬럼명 + 자료형(길이) + 제약사항

-- 1. not null
-- 2. primary key = not null + unique
-- 3. unique
-- 4. check
-- 5. default
-- 6. foreign



/*

    제약 사항을 만드는 방법
    
    1. 컬럼 수준에서 만드는 방법
     - 위에서 수업한 방법
     - 컬럼을 정의할 때 제약 사항도 같이 정의하는 방법
          
    2. 테이블 수준에서 만드는 방법
     - 컬럼 정의와 제약 사항 정의를 분리시킨 방법
     - 제약 사항만 따로 정의 > 관리 차원 > 코드 분리
     - not null, default > 컬럼 수준에서만 정의할 수 있다
    
    
    3. 외부에서 만드는 방법
     - alter 명령어 (추후 테이블 수정 배운 후 수업!)

*/

drop table tblMemo;

create table tblMemo (

    seq number(3),
    -- seq number(3) constraint tblmemo_seq_pk primary key, (정석)
    name varchar2(30) not null,
    memo varchar2(1000) null,
    regdate date,
    
    -- 테이블 수준의 제약사항 정의
    -- 제약사항명: 테이블명_컬럼명_제약사항
    constraint tblmemo_seq_pk primary key(seq),
    constraint tblmemo_name_uq unique(name),
    -- 메모 내용을 최소 10글자 이상
    constraint tblmemo_memo_ck check(length(memo) >= 10)
    -- ***** not null, dafault 제약은 외부에서 할 수 없고 반드시 컬럼 수준에서 정의해야 한다
);


insert into tblMemo(seq, name, memo, regdate) values (1, '홍길동', '메모입니다.', sysdate);
--ORA-00001: unique constraint (HR.TBLMEMO_SEQ_PK) violated
--HR.TBLMEMO_SEQ_PK: 제약사항의 이름!
--ORA-02290: check constraint (HR.TBLMEMO_MEMO_CK) violated
insert into tblMemo(seq, name, memo, regdate) values (1, '홍길동', '메모입니다.', sysdate);
insert into tblMemo(seq, name, memo, regdate) values (1, '홍길동', '메모입니다. 홍길동입니다.', sysdate);
insert into tblMemo(seq, name, memo, regdate) values (2, '아무개', '메모입니다. 홍길동입니다.', sysdate);

select * from tblMemo;
