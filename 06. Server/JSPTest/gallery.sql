-- C:\class\server\JSPTest\gallery.sql

create table tblGallery (
    
    seq number primary key,             -- 번호(PK)
    filename varchar2(100) not null,    -- 이미지 파일명(하드디스크에 저장된 이름)
    subject varchar2(100) not null,     -- 제목(이미지 설명)
    regdate date default sysdate        -- 작성 시각
);


create sequence seqGallery;
drop sequence seqGallery;


-- 업무 쿼리 (조회, 등록, 삭제)

select * from tblGallery;

insert into tblGallery (seq, filename, subject, regdate) values (seq.nextVal, '강아지.jpg', '날아라 시바~!', default);

delete from tblGallery where seq = 3;

