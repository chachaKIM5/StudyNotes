-- ex22_alter.sql


/*

    테이블 수정하기
    - 테이블 정의 수정 > 테이블 스키마 수정 > 컬럼 수정 (컬럼명 or 자료형(길이) or 제약사항)
    - 되도록 테이블 수정하는 상황을 발생시키면 안 된다!! > 설계를 반드시 완벽하게!
    
    테이블 수정해야 하는 상황 발생!
    1. 테이블 삭제(DROP) > 테이블 DDL(CREATE) 수정 > 수정된 DDL로 새롭게 테이블 생성
        a. 기존 테이블에 데이터가 없었을 경우 > 아무 문제 없음
        b. 기존 테이블에 데이터가 있었을 경우 > 미리 데이터 백업 > 테이블 삭제 > 수정 후 생성 > 데이터 복구
            - 개발 중에 사용 가능
            - 공부할 때 사용 가능
            - 서비스 운영 중에는 거의 불가능한 방법
    
    2. ALTER 명령어 사용 > 기존 테이블의 구조 변경
        a. 기존 테이블에 데이터가 없었을 경우 > 아무 문제 없음
        b. 기존 테이블에 데이터가 있었을 경우 > 경우에 따라 무난/추가 조치 필요
            - 개발 중에 사용 가능
            - 공부할 때 사용 가능
            - 서비스 운영 중 가능한 방법

*/



drop table tblEdit;

create table tblEdit (
    seq number primary key,
    data varchar2(20) not null
);

insert into tblEdit values (1, '마우스');
insert into tblEdit values (2, '키보드');
insert into tblEdit values (3, '모니터');


-- Case 1. 새로운 컬럼을 추가하기
-- alter table 컬럼명 add (새로 추가될 컬럼의 정의);

alter table tblEdit
        add (price number null);


select * from tblEdit;
delete from tblEdit;

-- 기존 행이 있는 상태에서 not null 제약의 새 컬럼을 넣으면? 추가 불가
-- 기존 행이 없는 상태에서 not null 제약의 새 컬럼을 넣으면? 추가 가능!

alter table tblEdit
        add (memo varchar2(100) not null);
       
insert into tblEdit values (1, '마우스', 3000, '로지텍');

-- 기존 행을 모두 delete하고 다시 insert하기에는 번거로움
-- > default로 임시값을 정해 놓고 alter, 추후에 데이터 수정
alter table tblEdit
        add (memo2 varchar2(100) default '임시' not null);
        
        

-- Case 2. 컬럼 삭제하기
--alter table 테이블명 drop column 지우고 싶은 컬럼명;

alter table tblEdit
    drop column memo2;

alter table tblEdit
    drop column memo;
    
alter table tblEdit
    drop column seq; --PK 컬럼 삭제 > 절대 금지!!!!
    
select * from tblEdit;



-- Case 3. 컬럼 수정하기

insert into tblEdit values (4, '인텔 i7 12세대 최신형 노트북');

-- Case 3-1. 컬럼의 길이 수정하기 (확장/축소)
alter table tblEdit
    modify (data varchar2(100));
    
-- Case 3-2. 컬럼의 제약사항 수정하기
alter table tblEdit
    modify (data varchar2(100) null);
    
alter table tblEdit
    modify (data varchar2(100) not null);
    
desc tblEdit;

-- Case 3-3. 컬럼의 자료형 바꾸기
-- 무조건 테이블을 비우고 자료형을 바꾼다!
alter table tblEdit
    modify (data number);

alter table tblEdit
    modify (seq varchar2(100));


-- Case 3.4 컬럼명 바꾸기
alter table tblEdit
    rename column data to etc;
    
desc tblEdit;

select * from tblEdit;


------------------------------------------------------------------------


-- 제약사항 수정하기

drop table tblEdit;

create table tblEdit (
    seq number,
    data varchar2(20) not null,
    color varchar2(30) null
);

alter table tblEdit
    modify (seq number primary key);
    
alter table tblEdit
    add constraint tbledit_seq_pk primary key(seq);

alter table tblEdit
    add constraint tbledit_color_ck
        check (color in ('red', 'yellow', 'blue'));
        
insert into tblEdit values (1, '마우스', 'red');
insert into tblEdit values (2, '키보드', 'yellow');
insert into tblEdit values (3, '모니터', 'white'); -- 에러, 삽입 불가능 -> 제약사항 삭제 -> 삽입 가능


-- 제약사항 없애기
-- 테이블의 데이터에 영향은 X
alter table tblEdit
    drop constraint tbledit_color_ck;
    
