-- ex15_insert.sql



/*

    INSERT
    - DML
    - 테이블에 데이터를 추가하는 명령어(행 추가, 레코드 추가, 튜플 추가)
    
    
    INSERT
    - INSERT INTO 테이블명(컬럼리스트) VALUES(값리스트);

*/


drop table tblMemo;

create table tblMemo (

    seq number(3) primary key,
    name varchar2(30) default '익명',
    memo varchar2(1000),
    regdate date default sysdate not null
);

drop sequence seqMemo;
create sequence seqMemo;



--1. 표준: 원본 테이블에 정의된 컬럼 순서대로 컬럼리스트와 값리스트를 구성하는 방법
--         특별한 이유가 없으면 이 방식을 사용한다
insert into tblMemo(seq, name, memo, regdate) values(seqMemo.nextVal, '홍길동', '메모', sysdate);


--2. 컬럼리스트의 순서는 원본 테이블과 상관없다.
--    *** 컬럼리스트의 순서와 값리스트의 순서가 일치해야 한다.
insert into tblMemo(name, memo, regdate, seq) values('홍길동', '메모', sysdate, seqMemo.nextVal);


--3. SQL 오류: ORA-00947: not enough values
insert into tblMemo(seq, name, memo, regdate) values(seqMemo.nextVal, '홍길동', sysdate);


--4. SQL 오류: ORA-00913: too many values
insert into tblMemo(seq, name, regdate) values(seqMemo.nextVal, '홍길동', '메모', sysdate);


-- 3+4의 결론: 컬럼리스트의 개수와 값리스트의 개수는 반드시 일치해야 한다.


-- >>> 컬럼리스트와 값리스트의 순서, 개수는 일치해야 한다.


--5. null 컬럼 조작
-- null을 적고 싶다? (1. null 상수 사용, 2. 컬럼 자체를 생략)
insert into tblMemo(seq, name, memo, regdate) values(seqMemo.nextVal, '홍길동', null, null);
insert into tblMemo(seq, name) values(seqMemo.nextVal, '홍길동');


--6. dafault 컬럼 조작
-- default 값을 넣고 싶다? 6-1. 컬럼 생략 > null 처리 
insert into tblMemo(seq, memo, regdate) values(seqMemo.nextVal, '메모', sysdate);
insert into tblMemo(seq, memo) values(seqMemo.nextVal, '메모');


-- 6-2. null 상수 사용 > 사용자의 명시적 의지 표현으로 받아들여 default 동작 안 함
--ORA-01400: cannot insert NULL into ("HR"."TBLMEMO"."REGDATE"), regdate에 default와 not null 적용
insert into tblMemo(seq, name, memo, regdate) values(seqMemo.nextVal, null, '메모', sysdate);


-- 6-3. default 사용
insert into tblMemo(seq, name, memo, regdate) values(seqMemo.nextVal, default, '메모', default); 


-- 7. 단축
-- 컬럼리스트를 생략할 수 있다!!!
insert into tblMemo values(seqMemo.nextVal, '홍길동', '메모', sysdate);

-- 컬럼리스트가 생략됐을 때에는 값리스트가 꼭 정의된 컬럼(원본 컬럼) 순서대로 써야 한다!!
insert into tblMemo values('홍길동', '메모', sysdate, seqMemo.nextVal);

-- null 조작
insert into tblMemo values(seqMemo.nextVal, '메모', sysdate); -- X
insert into tblMemo values(seqMemo.nextVal, null, '메모', sysdate); -- O

-- default 조작
insert into tblMemo values(seqMemo.nextVal, '홍길동', '메모'); -- X
insert into tblMemo values(seqMemo.nextVal, '홍길동', '메모', default); -- O

select * from tblMemo;



-- 8.
-- tblMemo 테이블 복사 -> 새 테이블 생성
-- Sub Query

create table tblMemoCopy (

    seq number(3) primary key,
    name varchar2(30) default '익명',
    memo varchar2(1000),
    regdate date default sysdate not null
);

insert into tblMemoCopy select * from tblMemo;

select * from tblMemoCopy;


-- 9. *** 테이블 생성 + 데이터 복사
-- 생성과 동시에 데이터 카피까지 한번에
-- 하지만 테이블 생성 시의 제약 사항은 복사하지 않는다. (not null만 복사한다!)
-- -> 개발자들이 더미데이터 만드는 용도로 사용한다. (실사용 X)
create table tblMemoCopy2 as select * from tblMemo;
select * from tblMemoCopy2;

desc tblMemoCopy2;


insert into tblMemoCopy2(seq, name, memo, regdate) values(14, '홍길동', '메모', sysdate);