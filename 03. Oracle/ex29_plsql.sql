-- ex29_plsql.sql

/*

    PL/SQL
    - Oracle's Procedural Language Extension to SQL
    - 기존의 ANSI-SQL에 절차 지향 언어의 기능을 추가한 SQL
    
    ANSI-SQL
    - 비절차 지향 언어. 순서가 없고 연속적이지 않다.
    - 문장 단위 구조
    - ANSI-SQL + 절차적 기능(제어) = PL/SQL
    
    
    프로시저, Procedure
    - 메소드, 함수 등...
    - 순서가 있는 명령어들의 집합
    - PL/SQL 명령어는 반드시 프로시저 내에서만 작성 + 동작이 가능하다.
    
    
    1. 익명 프로시저
        - 1회용 코드 작성용
    
    2. 실명 프로시저
        - 재사용 가능
        - 저장 가능
        - 데이터베이스에 이름을 가지고 객체로 저장된다.
        
        
    PL/SQL 프로시저 블럭 구조
    - 4개의 키워드(블럭)으로 구성
    - 키워드 4개가 합쳐져 프로시저를 만든다
        a. DECLARE
        b. BEGIN
        c. EXCEPTION
        d. END
        
        
    1. DECLARE
        - 선언부
        - 프로시저에서 사용할 변수, 객체 등을 선언하는 영역
        - 생략 가능
        
    2. BEGIN
        - 실행부, 구현부
        - BEGIN ~ END
        - 구현된 코드를 가지는 영역(메소드의 body와 동일)
        - 생략 불가능
        - 핵심
        - PL/SQL + ANSI + SQL 작성
        
    3. EXCEPTION
        - 예외처리부
        - catch 역할
        - 예외 처리 코드를 작성
        - 생략 가능
    
    
    4. END
        - BEGIN 블럭의 종료 역할
        - 생략 불가능
        
        
        
    PL/SQL의 자료형
    - ANSI-SQL과 동일

    변수 선언하기
    - 변수명 자료형 [not null] [default 값];
    - 주로 질의(select)의 결과값을 저장하는 용도로 사용
    - 일반 변수로서의 역할도 동일하게 한다
    
    PL/SQL 연산자
    - ANSI-SQL과 동일
    
    대입 연산자
    - ANSI-SQL
        ex) update table set column = '값';
    - PL/SQL
        ex) 변수 := '값';
    
*/


-- dbms_output.put_line의 결과 > 기본적으로 안 보이도록 설정
-- 보이게 하려면? set serverout on; 으로 설정, 접속할 때마다 다시 실행해야 함

set serverout on;
set serverout off;


declare
    num number;
    name varchar2(20);
    today date;
begin
    num := 10;
    dbms_output.put_line(num);    
    
    name := '홍길동';
    dbms_output.put_line(name);
    
    today := sysdate;
    dbms_output.put_line(today);

end;
/


declare
    num1 number;
    num2 number;
    num3 number := 30; --declare부에서도 초기화 가능
    num4 number default 40; -- 변수 초기값
    num5 number not null := 50; -- not null 제약이 붙으면 declare부에서 초기화
    num6 number not null default 0; -- body에서 초기화해야만 하는 상황이면... default값으로라도 값을 넣어 선언해야 함
begin
    num1 := 10;
    dbms_output.put_line(num1);
    
    dbms_output.put_line('---');
    dbms_output.put_line(num2); -- null 상태, 아무것도 찍히지 않음
    dbms_output.put_line('---');
    
    dbms_output.put_line(num3);
    
    -- 구현부 변수 선언은 불가능
    -- num4 number;
    
    dbms_output.put_line(num4);
    
    -- num5 := 50;
    -- PLS-00218: a variable declared NOT NULL must have an initialization assignment
    dbms_output.put_line(num5);
    
    num6 := 60;
    dbms_output.put_line(num6);
    
end;
/


-- select into 절
-- 변수 > select 결과를 담는 용도

declare
    vname varchar2(15);
    buseo varchar2(15);
begin
    -- vname := (select name from tblInsa where num = 1001); -- 에러! 대입연산자로는 변수에 select 값을 넣지 못한다
    -- select 컬럼 into 변수 from절
    select name into vname from tblInsa where num = 1001;
    select buseo into buseo from tblInsa where num = 1001;
    
    dbms_output.put_line(vname);
    dbms_output.put_line(buseo);
end;


-- PLS-00428: an INTO clause is expected in this SELECT statement
-- PLS-00201: identifier 'BUSEO' must be declared
begin

    -- ** PL/SQL 블럭 안에서는 절대! 일반 SQL을 작성할 수 없다
    -- > 반드시 select into절을 사용해야 한다
    -- > ANSI-SQL의 결과값을 바로 사용하지 못하고, PL/SQL로 옮겨서 사용이 가능하다
    select buseo from tblInsa where num = 1001;
    -- dbms_output.put_line(buseo); -- 가져온 컬럼값을 변수에 넣지 않고 바로 조작(출력)?
end;



create table tblName (
    name varchar2(15)
);


-- select > tblName 추가
-- 1. ANSI-SQL
-- 2. PL/SQL


declare
    vname varchar2(15);
begin

    select name into vname from tblInsa where buseo = '개발부' and jikwi = '부장';
    
    insert into tblname (name) values (vname);
end;

select * from tblName;


insert into tblname (name) values ((select name from tblInsa where buseo = '개발부' and jikwi = '부장'));




-- select into > 1개의 값을 select > 1개의 PL/SQL 변수에 대입
-- 여러개 값을 select 후 여러개 PL/SQL 변수에 대입?

declare
    vname varchar2(15);
    vbuseo varchar2(15);
    vjikwi varchar2(15);

begin

    -- into 주의점
    -- 1. 컬럼의 개수와 변수의 개수의 일치
    --    PL/SQL: ORA-00947: not enough values, PL/SQL: ORA-00913: too many values
    -- 2. 컬럼의 순서와 변수의 순서의 일치
    -- 3. 컬럼과 변수의 자료형 일치
    --    ORA-06502: PL/SQL: numeric or value error: character to number conversion error
    select name, buseo, jikwi into vname, vbuseo, vjikwi from tblInsa where num = 1001;
    dbms_output.put_line(vname);
    dbms_output.put_line(vbuseo);
    dbms_output.put_line(vjikwi);

end;


/*

    타입 참조
    - 변수를 선언할 때 사용
    
    1. %type
        - 사용하는 테이블의 특정 컬럼의 스키마를 알아내서 변수에 적용
        - 복사되는 정보
            a. 자료형
            b. 길이
            
    2. %rowtype

    
    cf) 프로시저에서 select 값을 저장하기 위한 변수를 만드는 경우
    1. vbuseo varchar2(15)
        - 정적
    
    2. vbuseo tblInsa.buseo%type
        - 동적(참조)
*/

desc tblInsa;
-- PL/SQL 변수를 만들 때 desc 테이블명으로 테이블 스키마를 미리 확인해야 하는 번거로움


declare
--  vbuseo varchar2(15);
    vbuseo tblInsa.buseo%type;  -- tblInsa의 buseo 컬럼을 확인해서 동일한 타입과 동일한 길이를 변수에 적용해 준다
begin
    select buseo into vbuseo from tblInsa where num = 1001;
    dbms_output.put_line(vbuseo);
end;


declare
    vname     tblInsa.name%type;
    vbuseo    tblInsa.buseo%type;
    vcity     tblInsa.city%type;
    vbasicpay tblInsa.basicpay%type;
begin
    select
        name, buseo, city, basicpay
        into
        vname, vbuseo, vcity, vbasicpay
    from tblInsa where num = 1001;    
    
    dbms_output.put_line(vname);
    dbms_output.put_line(vbuseo);
    dbms_output.put_line(vcity);
    dbms_output.put_line(vbasicpay);
    
end;


-- 직원 중 일부에게 보너스 지급 > 내역 저장
-- 보너스는 basicpay의 1.5배
create table tblBonus (
    seq number primary key,
    num number(5) not null references tblInsa(num), -- 직원번호(FK)
    bonus number not null
);


-- 같은 작업을 ANSI-SQL과 PL/SQL로... 

-- ANSI-SQL
create or replace view vwjikwon
as
select * from tblInsa where city = '서울' and jikwi = '부장' and buseo = '영업부';

insert into tblBonus(seq, num, bonus)
    values (1, (select num from vwjikwon), (select basicpay * 1.5 from vwjikwon));
   

-- PL/SQL
declare 
    vnum tblInsa.num%type;
    vbasicpay tblInsa.basicpay%type;
begin
    select num, basicpay into vnum, vbasicpay from tblInsa where city = '서울' and jikwi = '부장' and buseo = '영업부';
    
    insert into tblBonus (seq, num, bonus) values (2, vnum, vbasicpay * 1.5);
end;


 
select * from tblBonus;



/*


    타입 참조
    
    1. %type           
        - 컬럼 1개 참조
    2. %rowtype
        - 행 전체 참조(모든 컬럼 참조)
    
*/


-- 홍길동의 정보 + 출력

declare
    --vnum    tblInsa.num%type;
    --vname   tblInsa.name%type;
    --vbuseo  tblInsa.buseo%type;
    vrow tblInsa%rowtype; -- vrow > 일종의 배열 역할 > 레코드 역할
begin
    --select num, name, buseo, jikwi, ssn, city, basicpay, sudang, ibsadate, tel from tblInsa where num = 1001;
    
--    select
--        num, name, ssn, ibsadate, city, tel, buseo, jikwi, basicpay, sudang
--        into
--        vrow
--    from tblInsa where num = 1001;
    select * into vrow from tblInsa where num = 1001;
    
    
    -- dbms_output.put_line(vrow); = 불가능
    dbms_output.put_line(vrow.num);
    dbms_output.put_line(vrow.name);
    dbms_output.put_line(vrow.buseo);
    dbms_output.put_line(vrow.basicpay);
    
end;

select * from tblInsa;



------------------


select * from tblMan;
select * from tblWoman;

-- '하하하'가 성전환 > tblMan에서 tblWoman으로 이동
-- 1. tblMan > select 정보
-- 2. tblWoman > insert
-- 3. tblMan > 하하하 정보 delete


declare
    vrow tblMan%rowtype;
begin
    --1.
    select * into vrow from tblMan where name = '하하하';
    
    --2
    insert into tblWoman values(vrow.name, vrow.age, vrow.height, vrow.weight, vrow.couple);
    
    --3
    delete from tblMan where name = '하하하';
    
end;



-- 제어문
-- 1. 조건문
-- 2. 반복문


-- if문
declare
    vnum number := -1;
begin
    if vnum > 0 then
        dbms_output.put_line('양수');
    elsif vnum < 0 then
        dbms_output.put_line('음수');
    else
        dbms_output.put_line('0');
    end if;    
end;



-- 직원 1명 선택 > 보너스 지급 > 간부(basicpay * 1.5), 사원(basicpay * 2)

declare
    vnum        tblInsa.num%type;
    vbasicpay   tblInsa.basicpay%type;
    vjikwi      tblInsa.jikwi%type;
    vbonus number;
    
begin

    --1.
    select num, basicpay, jikwi into vnum, vbasicpay, vjikwi from tblInsa where name = '이순신';
    
    --2.
    if vjikwi = '부장' or vjikwi = '과장' then
        vbonus := vbasicpay * 1.5;
    elsif vjikwi in ('대리', '사원') then
        vbonus := vbasicpay * 2;
    end if;
    
    --3.
    insert into tblBonus values (3, vnum, vbonus);
    
    dbms_output.put_line('완료');
    
end;


-- 프로시저가 올바르게 동작했는지 확인해보기
select b.*,
    (select name from tblInsa where num = b.num) as name,
    (select jikwi from tblInsa where num = b.num) as jikwi,
    (select basicpay from tblInsa where num = b.num) as basicpay
from tblBonus b;



/*
    
    case문
    - ANSI-SQL case와 유사
    - 자바의 switch문, 다중 if문과 유사


*/


declare
    vcontinent tblCountry.continent%type;
    vresult varchar2(30);
begin

    select continent into vcontinent from tblCountry where name = '대한민국';
    
    if vcontinent = 'AS' then
        vresult := '아시아';
    elsif vcontinent = 'EU' then
        vresult := '유럽';
    elsif vcontinent = 'AF' then
        vresult := '아프리카';
    else
        vresult := '기타';
    end if;
    
    dbms_output.put_line(vresult);


    
    case
        when vcontinent = 'AS' then vresult := '아시아2';
        when vcontinent = 'EU' then vresult := '유럽2';
        when vcontinent = 'AF' then vresult := '아프리카2';
        else vresult := '기타2';
    end case;
    
    dbms_output.put_line(vresult);


    case vcontinent
        when 'AS' then vresult := '아시아3';
        when 'EU' then vresult := '유럽3';
        when 'AF' then vresult := '아프리카3';
        else vresult := '기타3';
    end case;
    
    dbms_output.put_line(vresult);
    
end;
/

select
    case continent
        when 'AS' then '아시아'
        when 'EU' then '유럽'
        when 'AF' then '아프리카'
        else '기타'
    end
from tblCountry;





-- '신숙주'가 대여한 비디오 제목은? > '뽀뽀할까요'
-- 풀이 방법 3가지
select * from tblMember;
select * from tblRent;
select * from tblVideo;

-- 1. 조인
select v.name from tblMember m
    inner join tblRent r
        on m.seq = r.member
            inner join tblVideo v
                on v.seq = r.video
                    where m.name = '신숙주';
                    
                    

-- 2. 서브 쿼리
select name from tblVideo where seq = (select video from tblRent where member = (select seq from tblMember where name = '신숙주'));


-- 3. 프로시저
declare
    mseq tblMember.seq%type;
    vseq tblRent.video%type;
    vname tblVideo.name%type;
begin
    select seq into mseq from tblMember where name = '신숙주';
    
    select video into vseq from tblRent where member = mseq;
    
    select name into vname from tblVideo where seq = vseq;
    
    dbms_output.put_line(vname);
end;






/*

    반복문
    
    1. loop
        - 단순 반복 
    2. for loop
        - 횟수 반복(자바 for문과 비슷하다)
        - 1의 loop 기반
    
    3. while loop
        - 조건 반복(자바 while)
        - loop 기반
    
*/

set serverout on;


-- 현재 시각을 찍어내는 무한루프!
begin

    loop
    
        dbms_output.put_line(to_char(sysdate, 'hh24:mi:ss'));
    
    end loop;

end;
/


declare
    vnum number := 1;
begin
    loop
        dbms_output.put_line(to_char(sysdate, 'hh24:mi:ss'));
        vnum := vnum + 1;   
    
        exit when vnum > 10; --조건을 만족하면 Loop 탈출!
        
    end loop;
end;
/



create table tblLoop (
    seq number primary key,
    data varchar2(30) not null
);

create sequence seqLoop;


-- 데이터 x 1000건 추가

declare
    vnum number := 1;
begin

    loop
        insert into tblLoop values (seqLoop.nextVal, '데이터' || vnum);
        vnum := vnum + 1;
        exit when vnum > 1000;
    end loop;
end;
/


select * from tblLoop order by seq asc;
select count(*) from tblLoop order by seq asc;


/*
-- 2. for loop
-- 1 loop와 비교해서... loop 변수와 증감식, 탈출 구문을 따로 만들 필요가 X

begin
    for 변수 in 최소범위..최대범위 loop
    end loop;
end;

*/


begin
    for i in 1..10 loop
        dbms_output.put_line(i);
    
    end loop;

end;
/

-- for loop 이용해서 구구단 만들기

create table tblGugudan (
    dan number,
    num number,
    result number not null,
    
    constraint tblgugudan_dan_num_pk primary key(dan, num)
);


declare

begin
    for vdan in 2..9 loop
        for vnum in 1..9 loop
            insert into tblGugudan (dan, num, result)
            values (vdan, vnum, vdan * vnum);
        end loop;
    end loop;

end;
/

select * from tblGugudan;




/*

3. while loop
declare

begin
    while 조건 loop
    
    end loop;
end;
*/

declare
    vnum number := 1;
begin
    while vnum <= 10 loop
        dbms_output.put_line(vnum);
        vnum := vnum + 1;
    end loop;
end;





/*

    select > 결과셋 > PL/SQL 변수 대입
    
    1. select into
        - 결과셋의 레코드가 1개일 때만 가능하다.
    
    2. cursor + loop
        - 결과셋의 레코드가 N개일 때 사용한다.
        - 커서: select문을 가지고 있는 객체, ANSI-SQL select문을 적는다

    declare
        변수 선언;
        커서 선언; (cursor 커서이름 is select문;)
    begin
        커서 열기; (open 커서이름;)
             
             fetch 커서이름 into 변수;
             
             loop
                제이터 접근 + 조작
             end loop;
        커서 닫기; (close 커서이름;)
    end;
    
*/

--ORA-01422: exact fetch returns more than requested number of rows
declare
    vname tblInsa.name%type;
begin
    select name into vname from tblInsa;
    dbms_output.put_line(vname);
end;
/


declare
    
    cursor vcursor
        is
    select name from tblInsa;
    vname tblInsa.name%type;
    
begin

    open vcursor; -- open하는 순간 커서의 select문 실행, 결과셋에 커서 연결(참조) > 탐색 가능
    
        fetch vcursor into vname;    --select into와 동일한 역할
        dbms_output.put_line(vname); --첫번쨰 name 가져온다
        
        fetch vcursor into vname;
        dbms_output.put_line(vname); --두번째 name
        
        fetch vcursor into vname;
        dbms_output.put_line(vname); --세번째 name... JAVA의 iterator와 유사하다

--      for i in 1..60 loop
--          fetch vcursor into vname;
--          dbms_output.put_line(vname);
--      end loop;

        loop
            fetch vcursor into vname;
            exit when vcursor%notfound; -- boolean
            
            dbms_output.put_line(vname);
        end loop;

    close vcursor;
end;
/



-- 요구사항] 기획부 직원 명단 출력(이름, 직위, 지역) or 다른 테이블에 복사
create table tblTemp (
    name varchar2(30),
    jikwi varchar2(15),
    city varchar2(15)
);


declare
    cursor vcursor 
        is
    select name, jikwi, city from tblInsa where buseo = '기획부';
    
    vname tblInsa.name%type;
    vjikwi tblInsa.jikwi%type;
    vcity tblInsa.city%type;

begin
    
    open vcursor;
    
    loop
    
        fetch vcursor into vname, vjikwi, vcity;
        exit when vcursor%notfound;
        
        dbms_output.put_line(vname || ',' || vjikwi || ',' || vcity);
        insert into tblTemp(name, jikwi, city) values (vname, vjikwi, vcity);

        
    end loop;
    
    close vcursor;

end;
/
select * from tblTemp;


-- 직원 > 보너스 지급
select * from tblBonus;


-- 모든 직원에게 보너스 지급 > 간부(1.5) 사원(2)

declare
    cursor vcursor
    is
    select num, basicpay, jikwi from tblInsa;
    
    vnum tblInsa.num%type;
    vbasicpay tblInsa.basicpay%type;
    vjikwi tblInsa.jikwi%type;
    vseq number;
    
begin

    -- boilerplate code > 생각없이, 무의식적으로 반복할 수 있는 반복패턴 코드(=축제 코드)
    open vcursor;
    loop
    
        fetch vcursor into vnum, vbasicpay, vjikwi;
        exit when vcursor%notfound;
        
        -- 여기부터 생각
        -- seq? 간부 vs 사원을 어떻게 구분? 그에 따른 보너스 지급을 어떻게 차등 지급?
        -- 프로시저 밖에서 --create sequence seqBonus start with 4; 하는 방법도 있음
        
            select max(seq) into vseq from tblBonus;
            vseq := vseq + 1; -- sequence객체 사용하지 않는 방법
            
            if vjikwi in ('과장', '부장') then
                insert into tblBonus values (vseq, vnum, vbasicpay * 1.5);
            elsif vjikwi in ('사원', '대리') then 
                insert into tblBonus values (vseq, vnum, vbasicpay * 2);
            end if;
    
    end loop;
    close vcursor;
    
end;
/

select * from tblBonus;



-- loop와 row의 사용
declare
    cursor vcursor is
        select * from tblInsa;
    vrow tblInsa%rowtype;
begin

    open vcursor;
    loop
    
        fetch vcursor into vrow;    --10컬럼 -> 10변수
        exit when vcursor%notfound;
        
        dbms_output.put_line(vrow.name || ',' || vrow.ssn);
    end loop;
    close vcursor;

end;


-- 커서 탐색
-- 1. 커서 loop > 사용 O
-- 2. 커서 + for loop -> open, close cursor, fetch, exit까지도 생략 가능 > 사용 O
-- 둘 다 공부하기!

declare
    cursor vcursor is
        select * from tblInsa;

begin

    --open vcursor;
    --loop
    
    for vrow in vcursor loop
        
        -- fetch vcursor into vrow;
        -- exit when vcursor%notfound;
        
        dbms_output.put_line(vrow.name);
        
    end loop;
    
    --end loop;
    --close vcursor;

end;
/



-- 예외 처리
-- - 실행부(begin~end)에서 발생하는 예외를 처리하는 블럭

declare
    vname varchar2(30);
    
begin
    
    dbms_output.put_line('시작');
    
    select name into vname from tblInsa; --where num = 1001;
    dbms_output.put_line(vname);
    
    dbms_output.put_line('끝');
   
exception
    --when 예외상수 then
    when others then
        dbms_output.put_line('예외 처리');

end;
/

-- DB 오류 발생 > 기록을 남긴다.
create table tblError (
    seq number primary key,                                                 --기본키(PK)
    code varchar2(7) not null check(code in ('A001', 'B001', 'B002')),      --에러 상태 코드
    regdate date default sysdate not null                                   --에러 발생 시각
);

create sequence seqError;


-- 예외상수의 종류 알아보기
rollback;
delete from tblCountry; 

declare
    vcnt number;
    vname tblInsa.name%type;
begin
    select count(*) into vcnt from tblCountry;
    -- ORA-01476: divisor is equal to zero
    dbms_output.put_line(100 / vcnt);
    
    select name into vname from tblInsa; --where num = 1001;
    dbms_output.put_line(vname);
    
exception
    when ZERO_DIVIDE then
        dbms_output.put_line('0으로 나누었습니다.');
        insert into tblError values (seqError.nextVal, 'A001', default);
    when TOO_MANY_ROWS then
        dbms_output.put_line('가져온 행이 너무 많습니다.');
        insert into tblError values (seqError.nextVal, 'B001', default);
    when others then
        dbms_output.put_line('범용 예외 처리');
        insert into tblError values (seqError.nextVal, 'B002', default);
end;

select * from tblError;





/*

    프로시저
    1. 익명 프로시저
        - 일회용
        
    2. 실명 프로시저
        - 재사용
        - 오라클에 저장
        
        
    
    실명 프로시저
    - 저장 프로시저(Stored Procedure)
       1. 저장 프로시저, Stored Procedure
        - 매개변수 구성 / 반환값 구성 > 자유
       2. 저장 함수, Stored Function
        - 매개변수 필수 / 반환값 필수 > 고정
        
        
    
    익명 프로시저 선언
    
    [declare
        변수 선언;
        커서 선언;]
    begin
        구현부;
    [exception
        처리부;]
    end;
    
    
    
    저장 프로시저 선언
    
    create [or replace] procedure 프로시저명
    is(as)
        [변수 선언;
         커서 선언;]
    begin
        구현부;
    [exception
        처리부;]
    end;
    
*/



declare
    vnum number;
begin
    vnum := 100;
    dbms_output.put_line(vnum);
end;



-- "Procedure PROCTEST이(가) 컴파일되었습니다."
-- 오라클 서버에 procTest 저장 > 생성
create or replace procedure procTest
is
    vnum number;
begin
    vnum := 100;
    dbms_output.put_line(vnum);
end;



-- 저장 프로시저를 호출하기

-- 가장 안정적인 방법
begin
    procTest; -- 프로시저 실행(호출)
end;


-- 사용 X
execute procTest;
exec procTest;
call procTest; -- 나중에 사용


/





/*

    SQL 처리 순서
    
    1. ANSI-SQL or 익명 프로시저
        - 클라이언트 > 구문 작성(select) > 실행(Ctrl+Enter) > 명령어를 오라클 서버에 전달
            > 서버가 명령어를 수신 > 구문 분석(파싱) + 문법 검사 > 컴파일 실행
            > 실행 > 결과 도출 > 서버가 결과셋을 클라이언트(SQL Developer)에게 반환
            > 결과셋을 화면에 출력
        - 한 번 실행했던 명령어를 다시 실행? > 위의 과정을 다시 처음부터 끝까지 반복
        - 첫 번째 실행 비용 = 재실행 비용
                
        
    2. 저장 프로시저
        - 클라이언트 > 구문 작성(create) > 실행 (Ctrl+Enter) > 명령어를 오라클 서버에 전달
            > 서버가 명령어를 수신 > 구문 분석(파싱) + 문법 검사 > 컴파일 실행
            > 실행 > 컴파일된(*****) 프로시저를 서버에 저장
    
        
        - 클라이언트 > 구문 작성(호출) > 실행 (Ctrl+Enter) > 명령어를 오라클 서버에 전달
            > 서버가 명령어를 수신 > 구문 분석(파싱) + 문법 검사 > 컴파일 실행
            > 실행 > 프로시저 실행

        - 한 번 실행했던 명령어를 다시 실행 > 구문 분석 + 컴파일 생략 > 비용 절감!
        - 첫 번째 실행 비용 > 재실행 비용
*/


begin
    procTest;
end;





-- 저장 프로시저 = 메소드
-- 매개변수 + 반환값

-- 1. 매개변수가 있는 프로시저
create or replace procedure procTest(pnum number)
is
    vresult number;
begin
    vresult := pnum * 2;
    dbms_output.put_line(vresult);

end procTest;


begin
    procTest(100);
    procTest(200);
    procTest(300);
end;


create or replace procedure procTest(
    width number,
    height number
)
is
    vresult number;
    vresult2 number;
begin

    vresult := width * height;
    dbms_output.put_line(vresult);

end procTest;

begin
    procTest(10, 20);
end;



-- 프로시저의 매개변수는 길이와 not null을 표현할 수가 없다
create or replace procedure procTest(
    name varchar2
)
is -- 변수 선언이 없어도 반드시 기재, 생략 불가!
begin
    dbms_output.put_line('안녕하세요, ' || name || '님!');
end procTest;


begin
    procTest('홍길동');
end;



create or replace procedure procTest(
    width number,
    height number default 10
)
is
    vresult number;
begin
    vresult := width * height;
    dbms_output.put_line(vresult);
end procTest;



begin
    procTest(10, 20);   --width(10), height(20) 
    procTest(20);       --width(20), height(10)
end;




/*
    
    매개변수 모드(*****)
     - 매개변수가 값을 전달하는 방식
     - Call by Value
     - Call by Reference
     
     1. in 모드 > 기본 모드
     2. out 모드
     3. in out 모드

*/


create or replace procedure procTest (
    pnum1 in number,
    pnum2 in number,
    presult1 out number, -- 변수 자체를 매개변수로 받는다. => 주소값을 받아온다.
    presult2 out number,
    presult3 out number
)
is
begin
    presult1 := pnum1 + pnum2;
    presult2 := pnum1 * pnum2;
    presult3 := pnum1 - pnum2;
    dbms_output.put_line('프로시저 실행 완료');
end;



declare
    vresult1 number;
    vresult2 number;
    vresult3 number;
begin
    procTest(10, 20, vresult1, vresult2, vresult3);
    dbms_output.put_line(vresult1);
    dbms_output.put_line(vresult2);
    dbms_output.put_line(vresult3);
end;





-- 프로시저 생성 + 호출 문제

--1. 부서를 지정 > 해당 부서 직원 중 급여를 가장 많이 받는 사람의 번호를 반환하는 프로시저
--      in 1개 > out 1개
select * from tblInsa;

create or replace procedure procTest1 (
    pbuseo in varchar2,
    pnum out number
)
is
begin
    
    select num into pnum from tblInsa where basicpay = (select max(basicpay) from tblInsa where buseo = pbuseo);
end;


declare
    vnum tblInsa.num%type;
begin
    procTest1('기획부', vnum);
    dbms_output.put_line(vnum || '번 직원');
end;



--2. 직원 번호 지정 > 그 직원과 같은 지역에 사는 직원의 수, 같은 직위의 직원 수, 해당 직원보다 급여를 더 많이 받는 직원의 수를 반환
--      in 1개 > out 3개

create or replace procedure procTest2 (
    pnum in number,   -- 직원 번호
    pcnt1 out number, -- 같은 지역에 사는 직원 수
    pcnt2 out number, -- 같은 직위의 직원 수
    pcnt3 out number  -- 해당 직원보다 급여를 더 많이 받는 직원 수
)
is 

begin
    
    -- 같은 지역에 사는 직원 수
    select count(*) into pcnt1 from tblInsa where city = (select city from tblInsa where num = pnum);
    
    -- 같은 직위의 직원 수
    select count(*) into pcnt2 from tblInsa where jikwi = (select jikwi from tblInsa where num = pnum);
    
    -- 해당 직원보다 급여를 더 많이 받는 직원 수
    select count(*) into pcnt3 from tblInsa where basicpay > (select basicpay from tblInsa where num = pnum);
    
end;


declare
    vcnt1 number;
    vcnt2 number;
    vcnt3 number;
begin
    procTest2(1001, vcnt1, vcnt2, vcnt3);
    dbms_output.put_line('같은 지역에 사는 직원 수는 ' || vcnt1 || '명');
    dbms_output.put_line('같은 직위의 직원 수는 ' || vcnt2 || '명');
    dbms_output.put_line('급여를 더 많이 받는 직원 수는 ' || vcnt3 || '명');
end;



-- 메소드 체인닝처럼
-- 부서명 > procTest1 > 직원번호 > procTest2

declare
    vnum number;
    vcnt1 number;
    vcnt2 number;
    vcnt3 number;
begin
    procTest1('기획부', vnum);
    procTest2(vnum, vcnt1, vcnt2, vcnt3);
    dbms_output.put_line('같은 지역에 사는 직원 수는 ' || vcnt1 || '명');
    dbms_output.put_line('같은 직위의 직원 수는 ' || vcnt2 || '명');
    dbms_output.put_line('급여를 더 많이 받는 직원 수는 ' || vcnt3 || '명');
end;





select * from tblStaff;
select * from tblProject;


-- procDeleteStaff
-- 특정 직원 퇴사 > 담당 업무 존재 확인? > 업무 위임 > 퇴사

create or replace procedure procDeleteStaff(
    pseq in number,            -- 퇴사할 직원번호
    pstaff in number,          -- 인수인계받을 직원번호
    presult out number         -- 성공(1) or 실패(0) > 예외처리로!
)
is

    vcnt number; -- 퇴사 직원의 담당 프로젝트 개수
begin
    
    -- 1. 퇴사 직원의 담당 프로젝트가 있는지?
    select count(*) into vcnt from tblProject where staff_seq = pseq;
    dbms_output.put_line('퇴사할 직원이 ' || vcnt || '개의 프로젝트를 담당하고 있습니다.');
    
    -- 2. 조건 > 위임 유무 결정
    if vcnt > 0 then
        -- 3. 위임
        update tblProject set staff_seq = pstaff where staff_seq = pseq;
        dbms_output.put_line(pseq || '의 프로젝트를 ' || pstaff || '에게 위임했습니다.');

    else
        -- 3. 아무것도 안 함
        null;   -- 이 조건의 else 절에서는 아무것도 하지 마시오! > 개발자의 의도 표현 > dont touch!!
    end if;
    
    -- 4. 퇴사
    delete from tblStaff where seq = pseq;    
    dbms_output.put_line(pseq || '이(가) 퇴사합니다.');
    
    -- 5. 성공
    presult := 1;

exception
    when others then
        presult := 0;

end procDeleteStaff;


declare
    vresult number;
begin
    procDeleteStaff(2, 3, vresult);
    if vresult = 1 then
        dbms_output.put_line('성공');
    else
        dbms_output.put_line('실패');
end;


-- 현재 담당하는 프로젝트의 수가 가장 적은 직원에게 위임하도록 하기
-- 가장 적은 사람이 같으면? > rownum =1
create or replace procedure procDeleteStaff(
    pseq number,            -- 퇴사할 직원번호
    presult out number      -- 성공(1) or 실패(0) > 예외처리로!
)
is
    vcnt number;
    vstaff_seq number;
begin

     -- 1. 퇴사 직원의 담당 프로젝트가 있는지?
    select count(*) into vcnt from tblProject where staff_seq = pseq;
    dbms_output.put_line('퇴사할 직원이 ' || vcnt || '개의 프로젝트를 담당하고 있습니다.');
    
    -- 2. 조건 > 위임 유무 결정
    if vcnt > 0 then
    
        -- 2.5 위임받을 직원이 누군지 결정
        
        select staff_seq into vstaff_seq
            from tblProject where staff_seq <> pseq
                group by staff_seq
                    having count(*) = (select min(count(*)) from tblProject where staff_seq <> 2 group by staff_seq);
        
        -- 3. 위임
        update tblProject set staff_seq = vstaff_seq where staff_seq = pseq;
        dbms_output.put_line(pseq || '의 프로젝트를 ' || vstaff_seq || '에게 위임했습니다.');

    else
        -- 3. 아무것도 안 함
        null;   -- 이 조건의 else 절에서는 아무것도 하지 마시오! > 개발자의 의도 표현 > dont touch!!
    end if;

    -- 4. 퇴사
    delete from tblStaff where seq = pseq;    
    dbms_output.put_line(pseq || '이(가) 퇴사합니다.');
    
    -- 5. 성공
    presult := 1;

exception
    when others then
        presult := 0;

end procDeleteStaff;


declare
    vresult number;
begin
    procDeleteStaff(2, vresult);
    if vresult = 1 then
        dbms_output.put_line('성공');
    else
        dbms_output.put_line('실패');
    end if;
end;






---------------- 22/05/09 ▼ --------------------



/*

    저장 프로시저
        1. 저장 프로시저
        2. 저장 함수
    
    저장 함수, Stored Function > 함수, Function
    - 저장 프로시저와 동일
    - 반환값이 반드시 존재
    - out 파라미터 사용 X, return문만 사용
    - in 파라미터는 사용할 수 있다
    

*/


create or replace function funSum(pnum1 in number, pnum2 in number) return number
is
begin

    return pnum1 + pnum2;

end funSum;


set serveroutput on;

declare
    vresult number;
begin
    -- 프로시저는 변수 := procSum(10, 20, vresult);
    -- 함수 호출 특징 > 자바의 메소드 반환값과 동일한 형태로 사용
    -- 단일값을 반환(return문 특징) > 호출했던 곳에서 대입 연산자 사용 가능
    vresult := FunSum(10, 20);
    dbms_output.put_line(vresult);
end;


-- 저장 프로시저는 ANSI-SQL에서는 사용이 불가능하다 (*****) > 예외적으로 함수는 가능하다 (**********)
-- 반환값을 돌려주는 방식의 차이 > 프로시저와 함수는 사용하는 장소가 다르다.
-- 함수: ANSI-SQL에서 값으로 사용!


select
    height, weight,
    height + weight,
    funSum(height, weight) -- 반환값이 1개 > 값으로 사용
    --procSum(height, weight ??)
from tblComedian;


-- tblInsa. 이름, 부서, 직위, 성별(남자|여자)
select
    name, buseo, jikwi,
    case
        when substr(ssn, 8, 1) = '1' then '남자'
        when substr(ssn, 8, 1) = '2' then '여자'
    end as gender
from tblInsa;


create or replace function fnGender(
    pssn varchar2
) return varchar2
is
begin
    return case
                when substr(pssn, 8, 1) = '1' then '남자'
                when substr(pssn, 8, 1) = '2' then '여자'
           end;
end;


select
    name, buseo, jikwi, fnGender(ssn)
from tblInsa;




-- 반복되는 업무 or (다량의) 복잡한 업무 > 아래 2가지 비교

-- 생산, 호출 고비용
-- 개발자 가독성 + 조작성 저하 > 유지보수성 저하
-- 팀작업 나쁨
select
    name, buseo, jikwi
    case
        when substr(ssn, 8, 1) = '1' then '남자'
        when substr(ssn, 8, 1) = '2' then '여자'
    end as gender
from tblInsa;


-- 생산, 호출 저비용
-- 개발자 가독성 + 조작성 향상 > 유지보수성 ㅑㅇ상
-- 팀작업 좋음
select
    name, buseo, jikwi,
    fnGender(ssn) as gender
from tblInsa;








/*

    트리거, Trigger
    - 프로시저의 한 종류
    - 개발자의 호출이 아닌, 미리 지정한 특정 사건이 발생하면 자동으로 실행되는 프로시저
    - 예약(사건) > 사건 발생 > 프로시저 자동 호출
    - 특정 테이블 지정 > 지정 테이블 감시(오라클) > insert or update or delete > 미리 준비해놓은 프로시저 호출
    - 부하가 걸린다 (감시해야 하기 때문에) 매우 필요한 경우 아니면 신중하게...
    
    트리거 구문
    
    create or replace trigger 트리거명
        before|afetr
        insert|update|delete on 테이블명
        [for each row]
    declare
        선언부;
    begin
        실행부;
    exception
        예외처리부;
    end;
    
*/


-- before trigger: 트리거 실행 > 쿼리 실행
-- 쿼리를 실행하기 전에 트리거를 실행하기 때문에 조건에 따라 쿼리의 실행 유무를 통제할 수 있다
-- 사전 검사 가능 (ex.. 월요일에는 퇴사 불가!)

-- after trigger: 쿼리 실행 > 트리거 실행



-- tblInsa > 직원 퇴사(삭제)
create or replace trigger trgInsa
    before      -- 삭제하기 직전에 아래 구현부를 실행
--    after       -- 삭제한 후 아래 구현부를 실행
    delete      -- 삭제가 발생하는지 감시
    on tblInsa  -- 인사 테이블에서
begin

    dbms_output.put_line('트리거가 실행되었습니다.');

    -- 월요일에는 퇴사가 불가능하게 만들기
    if to_char(sysdate, 'dy') = '월' then
    
        -- 현재 진행하려던 업무(delete 실행 전) > 취소 > 취소하는 법은 강제로 예외 발생시키기 > 뒤에 이어질 업무(delete)가 취소
        -- 자바의 throw new Exception()
        -- -20000 ~ - 29999: 에러 코드는 마음대로
        raise_application_error(-20001, '월요일에는 퇴사가 불가능합니다.');
        
    end if;

end;
/

select * from tblInsa;

delete from tblInsa where num = 1005;
-- ORA-20001: 월요일에는 퇴사가 불가능합니다.
delete from tblInsa where num = 1006;

select * from tblBonus where num = 1006;
delete from tblBonus;
commit;




-- 로그 기록
create table tblLogMan (
    seq number primary key,
    message varchar2(1000) not null,
    regdate date default sysdate not null
);

create sequence seqLogMan;


select * from tblMan;


create or replace trigger trgLogMan
    after
    insert or update or delete
    on tblMan
declare
    vmessage varchar2(1000);
begin

    -- insert or update or delete?
    -- 어떤 명령이 일어났는지에 따라 다른 결과 나오게 하기
    dbms_output.put_line('트리거 실행');
    
    if inserting then
        dbms_output.put_line('추가 실행');
        vmessage := '새로운 항목이 추가되었습니다.';
    elsif updating then
        dbms_output.put_line('수정 실행');
        vmessage := '항목이 수정되었습니다.';
    elsif deleting then
        dbms_output.put_line('삭제 실행');
        vmessage := '항목이 삭제되었습니다.';
    end if;
    
    insert into tblLogMan values (seqLogMan.nextVal, vmessage, default);
end;
/


insert into tblMan values ('테스트', 22, 175, 60, null);
update tblMan set weight = 65 where name = '테스트';
delete from tblMan where name = '테스트';

select * from tblLogMan;




/*

    [for each row]
    
    1. 사용 X
        - 문장(Query) 단위 트리거
        - 트리거 실행 1회 -> 사건이 적용되는 레코드의 개수와 상관없이 트리거는 1회 호출
        - 적용된 레코드의 정보가 중요하지 않은 경우 + 사건 자체가 중요한 경우
    2. 사용 O
        - 행(Record) 단위 트리거
        - 트리거 실행 반복 -> 사건이 적용되는 레코드의 개수만큼 트리거가 반복 호출
        - 적용된 레코드의 정보가 중요한 경우 + 사건 자체보다 영향을 받은 레코드의 정보 하나하나가 중요한 경우


*/


select * from tblMan;

create or replace trigger trgMan1
    after
    delete
    on tblMan
begin
    dbms_output.put_line('트리거1');
end;

create or replace trigger trgMan2
    after
    delete
    on tblMan
begin
    dbms_output.put_line('트리거2');
end;

create or replace trigger trgMan3
    after
    delete
    on tblMan
begin
    dbms_output.put_line('트리거3');
end;
    
-- 특정 테이블에 여러 개의 트리거 적용 > 관리가 어렵다 > 확인도 귀찮다 > 트리거끼리 충돌! or 재귀 호출... 무한 루프
delete from tblMan where name = '홍길동';

select * from tblMan;
 
 
-- 때문에 쓰지 않는 트리거는 지워주는 것이 좋다

drop trigger trgInsa;
drop trigger trgLogMan;
drop trigger trgMan1;
drop trigger trgMan2;
drop trigger trgMan3;



-- Table A > insert 트리거 > Table B 기록
-- Table B > insert 트리거 > Table A 기록

create or replace trigger trgMan
    after
    delete
    on tblMan
begin
    dbms_output.put_line('레코드를 삭제했습니다.');
end;


-- delete 1회 실행 > 적용된 행 10개 > 프로시저 1회 실행
-- >>>>> 문장 단위 프로시저!

delete from tblMan; -- 10명 삭제
rollback;


create or replace trigger trgMan
    after
    delete
    on tblMan
    for each row
begin
    dbms_output.put_line('레코드를 삭제했습니다.');
end;


-- delete 1회 실행 > 적용된 행 10개 > 프로시저 10회 실행!
-- >> 행 단위 프로시저
delete from tblMan;
rollback;




-- for each row를 활용하는 방법? 왜 행 단위로 실행해야 할까?
-- 상관 관계(:old, :new) 사용 > 일종의 가상 레코드

-- insert
-- > :new (방금 추가된 행을 참조)

-- update
-- > :old, :new (수정되기 전, 수정된 후 행 참조)
create or replace trigger trgMan
    after
    update
    on tblMan
    for each row
begin
    dbms_output.put_line('나이 레코드가 수정되었습니다. : ' || :old.name);
    dbms_output.put_line('수정 전 나이: ' || :old.age);
    dbms_output.put_line('수정 후 나이: ' || :new.age);
end;

update tblMan set age = age + 1 where couple is not null; --여자 친구가 없는 사람만 나이를 1살씩 증가시키기
select * from tblMan;




-- delete
-- > :old (삭제된 행을 참조)
create or replace trigger trgMan
    after
    delete
    on tblMan
    for each row
begin
    dbms_output.put_line('레코드를 삭제했습니다.' || :old.name);
end;

delete from tblMan;
rollback;




select * from tblProject; 


-- 2번 직원 퇴사 > 4번에게 위임
-- 직원 퇴사시키기 직전 > 담당 프로젝트를 체크, 자동 위임

create or replace trigger trgDeleteStaff
    before              -- 3. 퇴사하기 전에
    delete              -- 2. 퇴사
    on tblStaff         -- 1. 직원 테이블에서
    for each row        -- 4. 해당 직원 정보 가져오기
begin

    --5 무언가를 할지? > 퇴사 직원의 프로젝트를 다른 직원에게 위임
    update tblProject set
        staff_seq = 4
            where staff_seq = :old.seq;

end;


delete from tblStaff where seq = 2;
select * from tblStaff;
select * from tblProject;



-- 회원 테이블, 게시판 테이블
-- 포인트 제도 
-- 1. 글 작성 > 포인트 + 100
-- 2. 글 삭제 > 포인트 - 50

create table tblBoardUser (
    id varchar2(30) primary key,
    point number default 10000 not null
);

create table tblBoard (
    seq number primary key,
    subject varchar2(1000) not null,
    id varchar2(30) not null references tblBoardUser(id)
);

create sequence seqBoard;


insert into tblBoardUser values('hong', default);
select * from tblBoardUser;


-- Case 1. ANSI-SQL로 하드코딩 > 사용 X
-- 절차 > 개발자가 직접 제어
-- 실수 확률 높음 > 일부 절차 누락...


-- 1.1 글쓰기
insert into tblBoard values (seqBoard.nextVal, '게시판입니다.', 'hong');

-- 1.2 포인트 누적하기
update tblBoardUser set point = point + 100 where id = 'hong';

-- 1.3 글삭제
delete from tblBoard where seq = 1;

-- 1.4 포인트 차감하기
update tblBoardUser set point = point - 50 where id = 'hong';


select * from tblBoard;
select * from tblBoardUser;




-- Case 2. 프로시저
create or replace procedure procAddBoard (
    psubject varchar2,
    pid varchar2
)
is 
begin

    -- 2.1 글쓰기
    insert into tblBoard values (seqBoard.nextVal, psubject, pid);
    
    -- 2.2 포인트 누적하기
    update tblBoardUser set point = point + 100 where id = pid;
    commit;
    
exception
    when others then
        rollback;

end;



create or replace procedure procDeleteBoard (
    pseq number
)
is 
    vid varchar2(30);
begin

    -- 2. 삭제글의 작성자 알아내기
    select id into vid from tblBoard where seq = pseq;
    
    -- 2.3 글삭제
    delete from tblBoard where seq = pseq;
    
    -- 2.4 포인트 누적하기
    update tblBoardUser set point = point - 50 where id = vid;
    commit;
    
exception
    when others then
        rollback;

end;



begin
    --procAddBoard('다시 글을 씁니다.', 'hong');
    procDeleteBoard(3);
end;

select * from tblBoard;
select * from tblBoardUser;





-- Case 3. 트리거

create or replace trigger trgBoard
    after
    insert or delete
    on tblBoard
    for each row
begin
    
    if inserting then
        update tblBoardUser set point = point + 100 where id = :new.id;
    elsif deleting then
        update tblBoardUser set point = point - 50 where id = :old.id;
    end if;

end;


insert into tblBoard values (seqBoard.nextVal, '트리거를 시험하기 위해 다시 글을 씁니다.', 'hong');
delete from tblBoard where seq = 4;

select * from tblBoard;
select * from tblBoardUser;




/*

    프로시저 Out Parameter
    1. 단일값
        a. number
        b. varchar2
        c. date
    2. 다중값
        a. cursor *******
        
        
    저장 프로시저 내에서 커서 사용
    1. 커서 호출 > 결과값 > 프로시저 내에서 소비
    
*/


create or replace procedure procBuseo (
    pbuseo varchar2
)
is 

    cursor vcursor
    is
    select * from tblInsa where buseo = pbuseo;
    
    vrow tblInsa%rowtype;
    
begin
    open vcursor;
    
    loop
        fetch vcursor into vrow;
        exit when vcursor%notfound;
        
        dbms_output.put_line(vrow.name || ', ' || vrow.buseo);
    end loop;
    close vcursor;
end procBuseo;


begin
    procBuseo('영업부');
end;


create or replace procedure procBuseo(
    pbuseo in varchar2,
    pcursor out sys_refcursor       -- 커서를 반환값으로 사용할 때 쓰는 자료형!! 필수
)
is
begin

    open pcursor
    for 
    select * from tblInsa where buseo = pbuseo;
    
end procBuseo;


declare
    vcursor sys_refcursor; -- 커서 참조 변수
    vrow tblInsa%rowtype;
begin
    procBuseo('영업부', vcursor); -- open cursor
    
    loop
        fetch vcursor into vrow;
        exit when vcursor%notfound;
        
        dbms_output.put_line(vrow.name || ', ' || vrow.buseo);
    end loop;
end;



-- 프로시저 + 커서 사용
-- 1. 자체 소비용
-- 2. 반환용