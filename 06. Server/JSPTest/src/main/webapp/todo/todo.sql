-- C:\class\server\JSPTest\todo.sql

drop table tblTodo;
drop sequence tblTodo;


create table tblTodo (
    seq number primary key,                                 --번호(PK)
    todo varchar2(300) not null,                            --할일
    regdate date default sysdate,                           --날짜
    priority char(1) not null,                              --중요도(A,B,C)
    complete char(1) default 'n' not null                   --완료 유무(y-완료, n-미완료)
);

create sequence seqTodo;



-- 할 일 조회
select * from tblTodo order by regdate asc;


-- 할 일 등록
insert into tblTodo (seq, todo, regdate, priority, complete) values (seqTodo.nextVal, '스쿼트 100개', default, 'A', default);




-- 완료 유무 수정

-- n -> y
update tblTodo set complete = 'y' where seq = 4;

-- y -> n
update tblTodo set complete = 'n' where seq = 1;



commit;





























