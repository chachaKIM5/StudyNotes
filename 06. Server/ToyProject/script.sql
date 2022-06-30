-- C:\class\server\ToyProject\script.sql


drop table tblUser;


-- 회원 테이블
create table tblUser (
    id varchar2(30) primary key,                    -- 아이디(PK)
    pw varchar2(30) not null,                       -- 암호
    name varchar2(30) not null,                     -- 이름
    lv char(1) not null,                            -- 등급(1. 일반회원, 2. 관리자)
    pic varchar2(100) default 'pic.png' not null,   -- 회원 프로필 사진
    regdate date default sysdate not null,          -- 가입 날짜
    active char(1) default 'y' not null             -- 탈퇴 여부(y. 활동중, n. 탈퇴)
);


insert into tblUser (id, pw, name, lv, pic, regdate) values ('hong', '1111', '홍길동', '1', default, default);
insert into tblUser (id, pw, name, lv, pic, regdate) values ('admin', '1111', '관리자', '2', default, default);


commit;

select * from tblUser;


alter table tblUser
    add (active char(1) default 'y' not null);

update tblUser set pic = '김승연 증명사진.jpg' where id = 'yoni';







-- 게시판

create table tblBoard (
    seq number primary key,                             -- 번호(PK)
    subject varchar2(300) not null,                     -- 제목
    content varchar2(4000) not null,                    -- 내용
    id varchar2(30) not null references tblUser(id),    -- 아이디(FK)
    regdate date default sysdate not null,              -- 작성시각
    readcount number default 0 not null                 -- 읽음
);

create sequence seqBoard;


select * from vwBoard;



-- 게시판 뷰
create or replace view vwBoard
as
select seq, subject, content, id, (select name from tblUser where id = tblBoard.id) as name, regdate, readcount, (select count(*) from tblComment where pseq = tblBoard.seq) as commentcount, depth from tblBoard order by thread desc;


-- 페이징
select * from (select a.*, rownum as rnum from vwBoard a) where rnum between 1 and 10;
select * from (select a.*, rownum as rnum from vwBoard a) where rnum between 11 and 20;
select * from (select a.*, rownum as rnum from vwBoard a) where rnum between 21 and 30;





-- 댓글


create sequence seqComment;
drop sequence seqComment;

create table tblComment (
    seq number primary key,                             -- 댓글 번호(PK)
    content varchar2(1000) not null,                    -- 내용
    id varchar2(30) not null,                           -- 아이디(FK)
    regdate date default sysdate not null,              -- 날짜
    pseq number not null references tblBoard(seq)       -- 부모글번호(FK)
);

create sequence seqComment;

select * from tblComment;
delete from tblComment where seq = 13;



--답변
--테이블 다시 만들기!

drop table tblComment;
drop table tblBoard;
drop sequence seqComment;
drop sequence seqBoard;

create table tblBoard (
    seq number primary key,                             -- 번호(PK)
    subject varchar2(300) not null,                     -- 제목
    content varchar2(4000) not null,                    -- 내용
    id varchar2(30) not null references tblUser(id),    -- 아이디(FK)
    regdate date default sysdate not null,              -- 작성시각
    readcount number default 0 not null,                -- 읽음
    thread number not null,                             -- 답변형 게시판
    depth number not null                               -- 답변형 게시판
);

create sequence seqBoard;

commit;


select nvl(max(thread), 0) as thread from tblBoard

select * from tblBoard order by thread;