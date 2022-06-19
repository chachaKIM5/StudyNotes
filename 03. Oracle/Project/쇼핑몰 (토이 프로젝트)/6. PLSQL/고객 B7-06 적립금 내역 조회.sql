--B7-06. ������ ���� ��ȸ
--      : �ֹ� �� ���� �ۼ����� ���� ������ �� ������ ��ȸ (���� ��¥, ���� ����(�ֹ�/���� �ۼ�), ���� �ݾ�, ���� �ݾ�

--������ �� ���� Ȯ��(���� + �����ݾ�)
-- procPoints('ȸ�� ���̵�', 'ȸ�� ��й�ȣ');

-- ansi view ����
create or replace view vwPoints
as
select 
    p.memberSeq as "ȸ����ȣ",
    p.savedate as "������¥",
    pc.category as "��������",
    p.point || '��' as "�����ݾ�" 
from tblPoint p
    inner join tblPointCategory pc on p.pcategorySeq = pc.seq;
    
    


-- view + ���ν��� ����
create or replace procedure procPoints (
    pid varchar2,
    ppw varchar2
)
is
    cursor vcursor
    is
    select * from vwPoints where "ȸ����ȣ" = (select seq from tblMember where id = pid and pw = ppw);
    vrow vwPoints%rowtype;
    vindex number;
    vspace varchar2(2);
    vspace2 varchar2(2);
    vtotal number;
    vname tblMember.name%type;
begin
    
    vindex := 0;
    vspace := ' ';
    vtotal := 0;

    open vcursor;
    loop
        fetch vcursor into vrow;
        exit when vcursor%notfound;
        
        select name into vname from tblMember where seq = vrow."ȸ����ȣ";
        if (to_number(replace(vrow."�����ݾ�", '��', '')) >= 1000) then
            vspace2 := '';
        else 
            vspace2 := ' ';
        end if;
        
        vtotal := vtotal + to_number(replace(vrow."�����ݾ�", '��', ''));
        if (vindex >= 10) then
            vspace := '';
        end if;
        
        if (vindex = 0) then
            dbms_output.put_line('---------- ' || vname || ' (ȸ����ȣ ' || vrow."ȸ����ȣ" || ') ���� ���� ���� ----------');
            dbms_output.put_line('');
            dbms_output.put_line('  ��ȣ    ������¥    ��������    �����ݾ�    �����ݾ�');
            vindex := 1;
        end if;     
        

        dbms_output.put_line('   ' || vspace || vindex || '   ' || vrow."������¥" || '     ' || vrow."��������" || '       ' || vspace2 || vrow."�����ݾ�" || '    ' || vtotal || '��');
        vindex := vindex + 1;
            
    end loop;
    close vcursor;
    
    if (vindex = 0) then
        dbms_output.put_line('--------------------------------------------------');
        dbms_output.put_line(''); dbms_output.put_line('');
        dbms_output.put_line('            ���� ������ ã�� �� �����ϴ�.');
        dbms_output.put_line(''); 
        
    end if;
    dbms_output.put_line('');
    dbms_output.put_line('--------------------------------------------------');

exception
    when others then
    
        dbms_output.put_line('--------------------------------------------------');    
        dbms_output.put_line('');
        dbms_output.put_line('              ������ ã�� �� �����ϴ�.');
        dbms_output.put_line('');
        dbms_output.put_line('--------------------------------------------------');    
end;
        
        
    

-- ���ν��� ����        
begin
    procPoints('sineob7', 'CkwPPWmoME%');
end;