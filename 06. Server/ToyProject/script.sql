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
select seq, subject, content, id, (select name from tblUser where id = tblBoard.id) as name, regdate, readcount,
    (select count(*) from tblComment where pseq = tblBoard.seq) as commentcount, depth,
    (sysdate - regdate) as isnew from tblBoard order by thread desc;


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


select nvl(max(thread), 0) as thread from tblBoard;

select * from tblBoard order by thread;





-- 파일 업로드, 테이블 다시 만들기

drop table tblComment;
drop table tblBoard;

create table tblBoard (
    seq number primary key,                             -- 번호(PK)
    subject varchar2(300) not null,                     -- 제목
    content varchar2(4000) not null,                    -- 내용
    id varchar2(30) not null references tblUser(id),    -- 아이디(FK)
    regdate date default sysdate not null,              -- 작성시각
    readcount number default 0 not null,                -- 읽음
    thread number not null,                             -- 답변형 게시판
    depth number not null,                              -- 답변형 게시판
    filename varchar2(100) null,                        -- 첨부파일
    orgfilename varchar2(100) null                      -- 첨부파일(원본 이름 for 다운로드)
);



-- 해시 태그 테이블
create table tblHashTag (
    seq number primary key,                 -- 번호(PK)
    tag varchar2(100) unique not null       -- 해시 태그(UQ)
);


create sequence seqHashTag;


-- 게시판 < (연결) > 해시 태그
create table tblTagging (
    seq number primary key,                             -- 번호(PK)
    bseq number not null references tblBoard(seq),      -- 게시물(FK)
    hseq number not null references tblHashTag(seq)     -- 해시태그(FK)
);

create sequence seqTagging;


select * from tblBoard order by seq desc;
select * from tblHashTag;
select * from tblTagging;

drop table tblTagging;
drop sequence seqTagging;

drop table tblHashTag;
drop sequence seqHashTag;


select * from tblHashTag h inner join tblTagging t on h.seq = t.hseq where bseq = 1;



-- 해시태그를 클릭했을 때 같은 해시태그의 글만 조회할 수 있도록 해시태그를 where절에 넣기
select b.* from vwBoard b
    inner join tblTagging t
        on b.seq = t.bseq
            inner join tblHashTag h
                on h.seq = t.hseq
                    where h.tag = '수업';
                    
  

create table tblGoodBad (
    seq number primary key,                                 -- 번호(PK)
    id varchar2(30) not null references tblUser(id),        -- 아이디(FK)
    bseq number not null references tblBoard(seq),          -- 글번호(FK)
    good number default 0 not null,                         -- 좋아요
    bad number default 0 not null                           -- 싫어요
);


create sequence seqGoodBad;


select * from tblGoodBad;


select tblBoard.*, (select name from tblUser where id = tblBoard.id) as name, () as good, () as bad from tblBoard where seq = 29;

select tblBoard.*,
    (select name from tblUser where id = tblBoard.id) as name,
    nvl((select sum(good) from tblGoodBad where bseq = tblBoard.seq), 0) as good,
    nvl((select sum(bad) from tblGoodBad where bseq = tblBoard.seq), 0) as bad,
    (select
        case
            when good = 1 then 1
            when bad = 1 then 2
            else 3
        end
        from tblGoodBad where bseq = tblBoard.seq and id = 'yoni') as goodbad    
from tblBoard where seq = 29;







select u.id, (select name from tblUser where id = u.id) as name, (select count(*) from tblBoard where id = u.id) as cnt from tblBoard b right outer join tblUser u on u.id = b.id group by u.id;

select u.id, (select name from tblUser where id = u.id) as name, (select count(*) from tblComment where id = u.id) as cnt from tblComment b right outer join tblUser u on u.id = b.id group by u.id;


select h.tag, (select count(*) from tblTagging where hseq = h.seq) as cnt from tblHashTag h left outer join tblTagging t on h.seq = t.hseq group by h.tag, h.seq;




-- 맛집 즐겨찾기
create table tblFood (
    
    seq number primary key,                                 -- 번호(PK)
    name varchar2(100) not null,                            -- 상호명
    lat number not null,                                    -- 위도(Latitude)
    lng number not null,                                    -- 경도(Longitude)
    star number(3) not null,                                -- 별점(1~5)
    category number not null references tblCategory(seq)    -- 업종
);


create sequence seqFood;


create table tblCategory (
    
    seq number primary key,
    name varchar2(100) not null,
    marker varchar2(100) not null,
    icon varchar2(100) not null

);



insert into tblCategory values (1, '한식', 'm1', 'fa-solid fa-bowl-food');
insert into tblCategory values (2, '양식', 'm2', 'fa-solid fa-pizza-slice');
insert into tblCategory values (3, '카페', 'm3', 'fa-solid fa-mug-hot');

commit;

select * from tblFood;










-- Ajax

-- 설문(질문) <-> 설문(항목)
-- ^
-- |
-- 선택


-- 설문 조사
create table tblResearch (
    seq number primary key,                     -- 번호(PK)
    question varchar2(500) not null,            -- 질문
    item1 varchar2(300) not null,               -- 항목
    item2 varchar2(300) not null,               -- 항목
    item3 varchar2(300) not null,               -- 항목
    item4 varchar2(300) not null,               -- 항목
    cnt1 number default 0 not null,             -- 선택
    cnt2 number default 0 not null,             -- 선택
    cnt3 number default 0 not null,             -- 선택
    cnt4 number default 0 not null             -- 선택
);


insert into tblResearch values (1, '가장 잘 사용하는 프로그래밍 언어는?', 'JAVA', 'Python', 'Visual C++', 'Node.js', default, default, default, default);

select * from tblResearch;


update tblResearch set
    cnt1 = 10,
    cnt2 = 17,
    cnt3 = 5,
    cnt4 = 10
    where seq = 1;
    
commit;


select * from tblAddress;
delete from tblAddress where seq = 13;

create sequence seqAddress;
