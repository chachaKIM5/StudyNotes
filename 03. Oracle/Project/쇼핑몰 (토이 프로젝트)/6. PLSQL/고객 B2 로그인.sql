
-- B-02. 회원 로그인
-- procLogin('회원 아이디', '회원 비밀번호');


-- procedure 생성

create or replace procedure procLogin(
    pid varchar2,
    ppw varchar2
)
is
    vname tblMember.name%type;
    vseq tblMember.seq%type;
begin
    select name, seq into vname, vseq from tblMember where id = pid and pw = ppw;
    dbms_output.put_line('----------------------------------------------------');
    dbms_output.put_line(vname || '(회원번호 ' || vseq || ') 님, 환영합니다.');
    dbms_output.put_line('로그인에 성공했습니다.');
    

exception
    when others then
        dbms_output.put_line('입력한 아이디: ' || pid || ', 입력한 비밀번호: ' || ppw);
        dbms_output.put_line('로그인에 실패했습니다.');
end;
/



-- procedure 실행
select * from tblMember;

begin
    procLogin(' sineob7', 'CkwPPWmoME%');
end;
