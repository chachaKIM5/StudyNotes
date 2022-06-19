--B7-05. 개인정보 관리
--      : 회원가입 시 입력했던 정보들을 수정
--         procEditInfo('로그인 아이디', '로그인 비밀번호', 바꿀 정보 선택, '바꿀 정보 값');
--      : 회원 탈퇴
--         procWithdraw('로그인 아이디', '로그인 비밀번호');





--      : 회원가입 시 입력했던 정보들을 수정

select * from tblMember;

-- pchoice = 바꿀 정보 선택 (1: 비밀번호, 2: 주소, 3: 전화번호, 4: 문자 수신여부, 5: 이메일, 6: 이메일 수신여부)
-- pedit = 바꿀 값 입력
-- 바꿀 정보의 유효성 검사는 고객 B1 회원가입의 유효성 검사 함수를 재사용
create or replace procedure procEditInfo(
    pid varchar2,
    ppw varchar2,
    pchoice number,
    pedit varchar2
)
is
    vidpw number;
begin
    
    select count(*) into vidpw from tblMember where id = pid and pw = ppw;
    
    dbms_output.put_line('-----------------------------------------------------------------');
    dbms_output.put_line('');
    
    if (vidpw = 1) then
        
        if (pchoice = 1) then
            
            if (fnCheckPW(pedit) = 1) then
                update tblMember set pw = pedit where id = pid and pw = ppw;
                dbms_output.put_line('  회원 정보 수정에 성공했습니다.');
                dbms_output.put_line('  수정 정보: 비밀번호, 수정된 값: ' || pedit);
            else 
                dbms_output.put_line('  비밀번호 형식이 올바르지 않습니다.');
                dbms_output.put_line('  (영문 대소문자 및 숫자, 특수문자(~!@#$%^&*) 8~15자)');
            end if;
        
        elsif (pchoice = 2) then
        
            if (fnCheckAddress(pedit) = 1) then
                update tblMember set address = pedit where id = pid and pw = ppw;
                dbms_output.put_line('  회원 정보 수정에 성공했습니다.');
                dbms_output.put_line('  수정 정보: 주소, 수정된 값: ' || pedit);
            else
                dbms_output.put_line('  주소 형식(한글+숫자)이 올바르지 않습니다.');
            end if;
            
        elsif (pchoice = 3) then
        
            if (fnCheckTel(pedit) = 1) then
                update tblMember set tel = pedit where id = pid and pw = ppw; 
                dbms_output.put_line('  회원 정보 수정에 성공했습니다.');
                dbms_output.put_line('  수정 정보: 전화번호, 수정된 값: ' || pedit);
            else
                dbms_output.put_line('  전화번호 형식(010-xxxx-xxxx)이 올바르지 않습니다.');
            end if;
            
        elsif (pchoice = 4) then
            
            if (pedit in ('y', 'Y', 'n', 'N')) then
                update tblMember set smsconsent = upper(pedit) where id = pid and pw = ppw;
                dbms_output.put_line('  회원 정보 수정에 성공했습니다.');
                dbms_output.put_line('  수정 정보: 문자 수신 동의 여부, 수정된 값: ' || pedit);
            else
                dbms_output.put_line('  문자 수신 동의 여부 형식(Y/N)이 올바르지 않습니다.');
            end if;
            
        elsif (pchoice = 5) then
        
            if (fnCheckEmail(pedit) = 1) then
                update tblMember set email = pedit where id = pid and pw = ppw;
                dbms_output.put_line('  회원 정보 수정에 성공했습니다.');
                dbms_output.put_line('  수정 정보: 이메일, 수정된 값: ' || pedit);
            else 
                dbms_output.put_line('  이메일 형식(아이디@도메인)이 올바르지 않습니다.');
            end if;
            
        elsif (pchoice = 6) then
        
            if (pedit in ('y', 'Y', 'n', 'N')) then
                update tblMember set emailconsent = upper(pedit) where id = pid and pw = ppw;
                dbms_output.put_line('  회원 정보 수정에 성공했습니다.');
                dbms_output.put_line('  수정 정보: 이메일 수신 동의 여부, 수정된 값: ' || pedit);
            else
                dbms_output.put_line('  이메일 수신 동의 여부 형식(Y/N)이 올바르지 않습니다.');
            end if;
            
        else
            dbms_output.put_line('  변경하실 정보를 올바르게 선택해 주세요.');
            dbms_output.put_line('  (1: 비밀번호, 2: 주소, 3: 전화번호, 4: 문자 수신여부, 5: 이메일, 6: 이메일 수신여부)');
            
        end if;
        
    else 
    
        dbms_output.put_line('  아이디 혹은 비밀번호를 다시 확인해 주세요.');
        
    end if;
    
    dbms_output.put_line('');
    dbms_output.put_line('-----------------------------------------------------------------');
end;




-- 프로시저 실행
-- pchoice = 바꿀 정보 선택 (1: 비밀번호, 2: 주소, 3: 전화번호, 4: 문자 수신여부, 5: 이메일, 6: 이메일 수신여부)
-- pedit = 바꿀 값 입력

begin
    procEditInfo('sy333262', 'qwera33#', 1, 'adgasgd@g'); 
end;

select * from tblMember where seq = 51 order by seq;





--      : 회원 탈퇴
-- 프로시저 생성

create or replace procedure procWithdraw (
    pid varchar2,
    ppw varchar2
)
is
    vidpw number;
begin
    
    select count(*) into vidpw from tblMember where id = pid and pw = ppw;
    
    dbms_output.put_line('----------------------------------------------');
    dbms_output.put_line('');
    
    if (vidpw = 1) then
        delete from tblMember where id = pid and pw = ppw;
        dbms_output.put_line('  회원(id: ' || pid || ') 탈퇴되었습니다.');
    else
        dbms_output.put_line('  아이디 혹은 비밀번호를 다시 확인해 주세요.');
    end if;
    
    dbms_output.put_line('');
    dbms_output.put_line('----------------------------------------------');

end;



-- 프로시저 실행, 주문 내역 및 추가 정보 등 자식 테이블 없는 경우만 실행 가능 (***)

begin
    procWithdraw('sy333262', 'qwera33#');
end;