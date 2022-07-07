-- crawling.sql

-- 크롤링 > 네이버 영화 현재 상영작
-- https://movie.naver.com/movie/running/current.naver


create table tblMovie (
    seq number primary key,             -- 번호(PK)
    title varchar2(200) not null,       -- 제목
    category varchar2(200) null,    -- 개요
    time number not null,               -- 러닝타임
    rdate varchar2(10) not null,        -- 개봉일
    director varchar2(100) not null,    -- 감독
    actor varchar2(300) null,           -- 배우
    poster varchar2(300) not null       -- 포스터
);

create sequence seqMovie;

select * from tblMovie;