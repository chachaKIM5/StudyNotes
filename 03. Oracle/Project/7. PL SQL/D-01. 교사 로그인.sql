
-- 1. 교사 로그인
-- procTeacherLogin('로그인할 교사 이름', 로그인할 교사 주민등록번호 뒷자리);


-- procedure 생성
create or replace procedure procTeacherLogin(
    pname varchar2,
    pjumin varchar2
)
is

    cursor vcursor
    is select name, jumin from tblTeacher;
    vname tblTeacher.name%type;
    vjumin tblTeacher.jumin%type;
    vresult number;
begin
    open vcursor;
    loop
        fetch vcursor into vname, vjumin;
        exit when vcursor%notfound;
    
        if pname = vname and pjumin = vjumin then
            vresult := 1;
        end if;
    end loop;
    
    if vresult = 1 then
        dbms_output.put_line('로그인에 성공했습니다.');
    else 
        dbms_output.put_line('로그인에 실패했습니다.');
    end if;
end;



select * from tblTeacher;

-- procedure 실행
begin
    procTeacherLogin('나윤철', 1785425);
end;
