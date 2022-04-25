-- ex16_update_delete.sql


/*

    UPDATE
    - DML
    - 원하는 행의 원하는 컬럼값을 수정하는 명령어
    
    UPDATE 테이블명 SET 컬럼명=값 [,컬럼명=값] [WHERE절]
 
    
    DELETE
    - DML
    - 원하는 행을 삭제하는 명령어
    
    DELETE [FROM] 테이블명 [WHERE절]

*/



commit;
rollback;


select * from tblCountry;


-- 대한민국 수도: 서울 > 세종
update tblCountry set capital = '세종'; -- 모든 나라의 수도가 세종으로
update tblCountry set capital = '세종' where name = '대한민국'; -- 대한민국의 수도만 세종으로


-- 전체 레코드 업데이트
-- 전세계 인구 수 증가 > 10% 증가
update tblCountry set population = population * 1.1;

update tblCountry set capital = '부산', continent = 'EU', area = 30 where name = '대한민국';





--DELETE, 행 전체 삭제


-- tblInsa
select * from tblInsa;


-- 구조조정
-- basicpay 180~200만 원
delete from tblInsa where basicpay between 1800000 and 2000000;

-- 행이 아니라 특정 컬럼 값만 지우고 싶을 때에는 delete가 아니라 update
-- 해당 컬럼이 null을 허용하는지 확인해야 사용할 수 있다 (desc 컬럼명)
update tblInsa set tel = null where num = 1001;
