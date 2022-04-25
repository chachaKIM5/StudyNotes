-- ex14_sequence.sql


/*

    시퀀스, Sequence
     - 데이터베이스 객체 중 하나
     - 오라클 전용 객체(다른 DBMS에는 없음)
     - 일련번호를 생성하는 객체 (******)
     - (주로) 식별자를 만드는 데 사용한다. > PK 컬럼에 값을 넣을 때 잘 사용한다.


    시퀀스 객체 생성하기
     - create sequence 시퀀스명;
     
    시퀀스 객체 생성하기
     - drop sequence 시퀀스명;
    
    시퀀스 객체 사용하기
     - 시퀀스.nextVal (*****)
     - 시퀀스.currVal

*/


create sequence seqNum;

select seqNum.nextVal from dual;


drop table tblMemo;

create table tblMemo (

    seq number(3) primary key,
    name varchar2(30),
    memo varchar2(1000),
    regdate date
);

create sequence seqMemo;

-- sequence를 활용하니 같은 insert 라인을 계속 실행해도 에러가 없다
insert into tblMemo(seq, name, memo, regdate) values (seqmemo.nextVal, '홍길동', '메모입니다.', sysdate);



-- ORA-12899: value too large for column "HR"."TBLMEMO"."NAME" (actual: 36, maximum: 30)
insert into tblMemo(seq, name, memo, regdate) values (seqmemo.nextVal, '홍길동홍길동홍길동홍길동', '메모입니다.', sysdate);


-- 정상 3번 -> 에러 3번 -> 정상 1번 하니 seqMemo가 3 -> 7이 되어버림!
-- 에러는 insert에서 났고, seqmemo.nextVal에서 난 게 아니기 때문에
select * from tblMemo;




-- sequence는 다양한 형태로도 활용
-- 쇼핑몰 > 상품 테이블 > 상품 번호(A10214)
select 'A' || seqNum.nextVal from dual;
select 'A' || to_char(seqNum.nextVal, '0000') from dual; --'A 0009': 한 칸 공백 자동으로 띄워지는건 부호 자리
select 'A' || ltrim(to_char(seqNum.nextVal, '0000')) from dual;

-- 컨트롤이 힘들다
select 'A' || ltrim(to_char(seqNum.nextVal, '0000')) || 'B' || ltrim(to_char(seqMemo.nextVal, '0000')) from dual;





-- currVal > Current Value > Peek()와 같은 역할, 소비하지 않고 확인만
-- 종료했다가 다시 켜면 에러가 난다!
-- ORA-08002: sequence SEQNUM.CURRVAL is not yet defined in this session
-- session은 현재 로그인 상태, 즉 currVal을 쓰기 위해서는 nextVal가 최소 1회 이상 호출되어야...
select seqNum.currVal from dual;

select seqNum.nextVal from dual;





/*

    시퀀스 객체 생성하기 (옵션)
   
    create sequence 시퀀스명;
    
    create sequence 시퀀스명
                    incretment by n : 증감치(양수/음수)
                    start with n : 시작값(seed)
                    maxvalue n : 최댓값
                    minvalue n : 최솟값
                    cycle
                    cache n;
                                      
*/

drop sequence seqTest;

create sequence seqTest
                --increment by 1 -- 증감치
                --start with 1
                --maxvalue 30    
                --minvalue 5; -- ORA-04006: START WITH cannot be less than MINVALUE
                --cycle -- maxvalue를 넘어서면 1로 돌아가 다시 시작! loop
                cache 20; --cache의 기본값은 20
                
select seqTest.nextVal from dual;
