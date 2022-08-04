
-- C:\class\server\SpringREST\script.sql


drop table tblAddress;
drop sequence seqAddress;

select * from tblAddress;

create table tblAddress (
    seq number primary key,
    name varchar2(30) not null,
    age number not null,
    tel varchar2(15) not null,
    address varchar2(100) not null
);

create sequence seqAddress;

commit;