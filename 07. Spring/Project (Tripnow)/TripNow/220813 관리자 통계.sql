select * from tblQuestion;
select * from tblAnswer;

delete from tblAnswer where seq = 6;
create sequence seqQuestion start with 15;
create sequence seqAnswer start with 6;
insert into tblQuestion values (seqQuestion.nextVal, 'user', 1, '상품 신고', 'asasdgasdgs 상품이 상품 소개와는 다르게 예약 시 추가금을 받았습니다.', sysdate);
commit;

select * from tblPayment;
select * from tblPayState;
select * from tblHomeBook;
select * from tblActivityBook;
select * from tblActivity;



select * from tblPayment;
select * from tblBookList;
select * from tblHomeBook;
select * from tblRoom;


-- 통계 select문
-- 숙소 예약의 예약상태(hb.bsseq)가 예약완료, 사용완료(2, 3)인 것들 중 예약시작일이 7월인 것들의
-- 매출(최종 결제금액 = tblPayment의 finalprice) 합 구하기
-- 예시: 7월
select 7 as month, sum(p.finalprice) as sales
from tblPayment p inner join tblBookList bl on p.blseq = bl.seq
inner join tblHomeBook hb on hb.bseq = bl.seq
where hb.bsseq in (2, 3) and to_char(hb.startdate, 'mm') = 7;

select 7 as month, nvl(sum(p.finalprice), 0) as sales
from tblPayment p inner join tblBookList bl on p.blseq = bl.seq
inner join tblCarBook cb on cb.bseq = bl.seq
where cb.bsseq in (2, 3) and to_char(cb.startdate, 'mm') = 7;

select 8 as month, nvl(sum(p.finalprice), 0) as sales
from tblPayment p inner join tblBookList bl on p.blseq = bl.seq
inner join tblActivityBook ab on ab.blseq = bl.seq
where ab.bsseq in (2, 3) and to_char(ab.regdate, 'mm') = 8;



-- 성별 통계 select문
select count(*) as "all", count(decode(gender, '남', 1)) as 'male', count(decode(gender, '여', 2)) as 'female'

-- 숙소
select
    7 as month,
    count(decode(u.gender, '남', 1)) as male,
    count(decode(u.gender, '여', 2)) as female
from tblPayment p inner join tblBookList bl on p.blseq = bl.seq
inner join tblHomeBook hb on hb.bseq = bl.seq
inner join tblUser u on hb.id = u.id
where hb.bsseq in (2, 3) and to_char(hb.startdate, 'mm') = 7;

-- 렌터카
select
    7 as month,
    count(decode(u.gender, '남', 1)) as male,
    count(decode(u.gender, '여', 2)) as female
from tblPayment p inner join tblBookList bl on p.blseq = bl.seq
inner join tblCarBook cb on cb.bseq = bl.seq
inner join tblUser u on cb.id = u.id
where cb.bsseq in (2, 3) and to_char(cb.startdate, 'mm') = 7;

-- 액티비티
select
    8 as month,
    count(decode(u.gender, '남', 1)) as male,
    count(decode(u.gender, '여', 2)) as female
from tblPayment p inner join tblBookList bl on p.blseq = bl.seq
inner join tblActivityBook ab on ab.blseq = bl.seq
inner join tblUser u on ab.id = u.id
where ab.bsseq in (2, 3) and to_char(ab.regdate, 'mm') = 8;


-- home
update tblHomeBook set bseq = 3 where seq = 2;
update tblHomeBook set bsseq = 2 where seq in (2, 3);
update tblHomeBook set bseq = 4 where seq = 3;
insert into tblBookList values (3, 'user');
insert into tblBookList values (4, 'user');
insert into tblBookList values (6, 'user');
insert into tblBookList values (7, 'user');
insert into tblBookList values (8, 'user');
insert into tblBookList values (9, 'user');
insert into tblPayment values (2, 3, 'y', 55000);
insert into tblPayment values (3, 4, 'y', 160000);
insert into tblPayment values (4, 6, 'y', 42400);
insert into tblPayment values (5, 7, 'y', 39990);
insert into tblPayment values (6, 8, 'y', 59990);
insert into tblPayment values (7, 9, 'y', 32190);

update tblActivityBook set blseq = 7 where seq = 4;
update tblActivityBook set blseq = 8 where seq = 5;
update tblActivityBook set blseq = 9 where seq = 6;


commit;