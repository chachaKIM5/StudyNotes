-- C:\class\java\JDBCTest\script.sql


-- 주소록 테이블 만들기
create table tblAddress (
    seq number primary key,                                 -- PK
    name varchar2(10) not null,                             -- 이름
    age number(3) not null check (age between 0 and 150),   -- 나이
    gender char(1) not null check (gender in ('m', 'f')),   -- 성별 (m, f)
    tel varchar2(15) not null,                              -- 전화번호
    address varchar2(300) not null,                         -- 주소
    regdate date default sysdate not null                   -- 등록일
);


create sequence seqAddress;

insert into tblAddress(seq, name, age, gender, tel, address, regdate)
    values (seqAddress.nextVal, '홍길동', 20, 'm', '010-1234-5678', '서울시 강남구 역삼동 한독빌딩', default);
    
    
select * from tblAddress;

commit;


update tblAddress set age = age + 1 where seq = 1;


select seqJava.nextVal from dual;


select * from tblInsa;

select * from tblBonus;

create sequence seqBonus;


select m.name, v.name from tblVideo v inner join tblRent r on v.seq = r.video inner join tblMember m on m.seq = r.member;



-- Ex06_CallableStatement.java

--m1 인자값, 반환값 X
create or replace procedure procM1
is
begin
    insert into tblAddress(seq, name, age, gender, tel, address, regdate)
    values (seqAddress.nextVal, '홍길동', 20, 'm', '010-1234-5678', '서울시 강남구 역삼동 한독빌딩', default);
end;


select * from tblAddress;


--m2 인자값 O, 반환값 X
create or replace procedure procM2(
    pname       tblAddress.name%type,
    page        tblAddress.age%type,
    pgender     tblAddress.gender%type,
    ptel        tblAddress.tel%type,
    paddress    tblAddress.address%type
)
is
begin

    insert into tblAddress(seq, name, age, gender, tel, address, regdate)
        values (seqAddress.nextVal, pname, page, pgender, ptel, paddress, default);
end;

-- 프로시저가 올바르게 만들어졌는지 검증 필수
begin
    procm2('이름', 20, 'm', '010-1111-1111', '주소');
end;

select * from tblAddress order by seq asc;



--m3. 인자값(X), 반환값(O)
create or replace procedure procM3(
    pcount out number
)
is
begin
    
    select count(*) into pcount from tblAddress;    
    
end;

set serverout on;

declare
    vcount number;
begin
    procM3(vcount);
    dbms_output.put_line(vcount);
end;



--m4. 연습문제

create or replace procedure procM4(
    pnum tblInsa.num%type,
    pname out tblInsa.name%type,
    pbuseo out tblInsa.name%type,
    pjikwi out tblInsa.name%type,
    pcity out tblInsa.name%type
)
is
begin

    select name, buseo, jikwi, city into pname, pbuseo, pjikwi, pcity from tblInsa where num = pnum;

end;


declare
    vname tblInsa.name%type;
    vbuseo tblInsa.buseo%type;
    vjikwi tblInsa.jikwi%type;
    vcity tblInsa.city%type;
begin

    procM4(1001, vname, vbuseo, vjikwi, vcity);
    dbms_output.put_line('직원 이름: ' || vname);
    dbms_output.put_line('직원 부서: ' || vbuseo);
    dbms_output.put_line('직원 직위: ' || vjikwi);
    dbms_output.put_line('직원 지역: ' || vcity);
end;




--m5. 다중 레코드, 입력한 부서 사람들의 이름, 직위, basicpay를 가져오는 프로시저
create or replace procedure procM5(
    pbuseo in varchar2,
    pcursor out sys_refcursor
)
is
begin

    open pcursor
    for
    select name, jikwi, basicpay
        from tblInsa
            where buseo = pbuseo;
            
end;


declare
    vcursor     sys_refcursor;
    vname       tblInsa.name%type;
    vjikwi      tblInsa.jikwi%type;
    vbasicpay   tblInsa.basicpay%type;
begin
    procM5('개발부', vcursor);
    
    loop
    
        fetch vcursor into vname, vjikwi, vbasicpay;
        exit when vcursor%notfound;
        
        dbms_output.put_line('이름: ' || vname || ', 직위: ' || vjikwi || ', 급여: ' || vbasicpay);
        
    end loop;
end;


--m6.
--내가 푼 방식: inner join 이용: 보너스 받은 적 있는 사람만 출력하기
create or replace procedure procM6(
    pbuseo in varchar2,
    pcursor out sys_refcursor
)
is
begin
    open pcursor
    for
    select i.name, b.num, b.bonus
        from tblInsa i
            inner join tblBonus b
                on i.num = b.num
                    where i.buseo = pbuseo;
    

end;

--선생님이 푼 방식: outer join 이용: 보너스 받은 적 없어도 출력하기

create or replace procedure procM6(
    pbuseo in varchar2,
    pcursor out sys_refcursor
)
is
begin
    open pcursor
    for
    select name, i.num, bonus from tblInsa i
        left outer join tblBonus b
            on i.num = b.num
                where buseo = pbuseo;
end procM6;

declare
    vcursor sys_refcursor;
    vname tblInsa.name%type;
    vnum tblBonus.num%type;
    vbonus tblBonus.bonus%type;
begin
    procM6('기획부', vcursor);
    
    loop
        fetch vcursor into vname, vnum, vbonus;
        exit when vcursor%notfound;
        
        dbms_output.put_line('[이름] ' || vname || ' [직원번호] ' || vnum || ' [보너스 금액] ' || vbonus);
    end loop;
end;

select * from tblInsa;