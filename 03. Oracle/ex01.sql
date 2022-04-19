-- 


-- 단일라인 주석
/*
    다중라인 주석
*/

/*

오라클 수업 설치 3가지
Oracle(데이터베이스), sqldeveloper(클라이언트 툴), eXERD

1. 오라클: Oracle XE (압축 풀면 DISK1 폴더) 설치할 때
java1234, java1234 입력

오라클은 UI 없음 > 화면 없음 > 서비스 프로그램 > 데이터베이스 서비스 제공


2. SQL Developer (클라이언트 툴)
 > 데이터베이스 접속 + 서비스 이용


C:\class\oracle 폴더 생성 
도구-환경설정-인코딩 'UTF-8'로 변경
코드 편집기 - 글꼴, 샘플 텍스트 확인하면서 글꼴 바꾸기

SQL Developer -> (접속) -> 오라클 데이터베이스

Name: "localhost.system"
사용자 이름: "system"
비밀번호"java1234"
비밀번호 저장 체크

호스트 이름:  "localhost" (=내 컴퓨터) = 오라클이 설치된 컴퓨터(IP주소, 도메인)
포트: 네트워크 프로그램이 운영 체제 내/외부를 통과하는 통신 회로 (경로, 통로) 65535개 > 프로그램 독점 > 1521
SID : 한 컴퓨터에 오라클 여러개 설치 가능 > 설치된 오라클 구분 ID > xe

테스트 누르고 성공 뜨면 저장!

*/



/*

"ex01.sql"
- 스크립트 파일(O), 소스 파일(X)
- SQL Developer > 워크시트

*/

select * from tabs;
select sysdate from dual;


/*

사용 계정
- sys, system > 최고 관리자 계정
- 일반 사용자 계정
 a. 직접 생성
 b. 공부(수업) > 오라클 제공하는 사용자 계정(scott, hr)
- 수업(hr) > 프로젝트(직접 생성)

아이디: hr
암호: hr -> java1234

HR 계정 사용하려면?
1. 계정 lock 풀기 (unlock)
2. 암호 바꾸기

*/

alter user hr account unlock; --계정 lock 풀기
--alter user hr account lock; --계정 잠그기

alter user hr identified by java1234; --암호 바꾸기

-- HR이 소유한 table 목록
select * from tabs;

-- 7개 샘플 데이터
select * from employees;    -- 직원 정보
select * from jobs;         -- 직원들의 직업 정보
select * from departments;  -- 직원들의 부서 정보
select * from locations;    -- 부서가 위치한 지역 정보
select * from countries;    -- 지역이 속한 국가 정보
select * from regions;      -- 국가가 속한 대륙 정보
select * from job_history;  -- 직원들의 이직 이력


/*

Oracle
1. 회사명
2. 제품명

수업 = Oracle + SQL

SQL, Structured Query Language 구조화된 질의 언어
- 오라클 데이터베이스 <-> 클라이언트 툴 (=사람(개발자))


오라클
- 데이터베이스(Database): 데이터의 집합(=저장소) > DB
- 데이터베이스 관리 시스템: DataBase Management System > DBMS
- 오라클 = DB + DBMS
- 오라클 DBMS 중 하나이다.


오라클 + SQL은 누가 공부?
1. 데이터베이스 관리자, DBA
2. 데이터베이스 개발자, DB 개발자 - DB 팀
3. 응용 프로그램 개발자, 자바 개발자 - 전부 사용 or 일부 사용


클라이언트 프로그램
1. SQL Developer > 오라클과 따로 설치
2. SQL Plus > 오라클과 함께 설치
3. DataGrip
4. DBeaver
5. Orange
6. SQLGate
7. Toad


오라클 서비스
- 화면 출력 X
- 오라클 상태 확인하기: Window+R(실행) > "services.msc" > OracleXXX 찾기

- 아래 두개가 실행중인지 확인!
- OracleServiceXE > 오라클 데이터 서버
- OracleXETNSListenrer > 오라클이 클라이언트툴의 접속을 받아들이는 기능


오라클
- 데이터베이스, DB
- 관계형 데이터베이스, Relational Database > RDBMS


관계형 데이터베이스
- 데이터를 표 형식으로 저장/관리한다.
- SQL를 사용해서 조작한다.


SQL
1. DBMS 제작사와 독립적이다.
 - 모든 관계형 데이터베이스에 공통적으로 적용하기 위해 만들어진 언어
 - 어떤 회사, 어느 버전... 상관없이 대부분의 관계형 데이터베이스에 사용 가능
 - DBMS 제작사에서 SQL라는 언어를 자신의 제품에 적용
 
2. 표준 SQL, ANSI-SQL
 - 모든 DBMS에 적용 가능한 SQL
 - 계속해서 버전업 중..
 - 초창기(SQL-86) -> SQL89, SQL92, SQL99...

3. 대화식 언어
 - 비절차지향
 - 질문 > 답변 > 질문 > 답변 x N
 
4. 종류
 a. 표준 SQL(ANSI)
  - 모든 DBMS > 공통 > 사용하는 DBMS가 바뀌어도 공부 X
  
 b. 각 DBMS 제작사별 SQL > 확장 SQL
  - DBMS별로 문법이 서로 다르다 > 사용하는 DBMS가 바뀌면 다시 공부 O
  - 오라클 > PL/SQL
  
  
오라클 수업의 비중(100) = ANSI-SQL(50~60) + PL/SQL(20~30) + 설계, 기타(10)



ANSI-SQL 종류: 하는 일에 따라 카테고리 나뉜다

1. DDL
    - Data Definition Language
    - 데이터 정의어
    - 테이블, 뷰, 사용자, 인덱스 등의 데이터베이스 오브젝트를 생성/수정/삭제하는 명령어
    - 구조를 생성/관리하는 명령어
        a. CREATE: 생성
        b. DROP: 삭제
        c. ALTER: 수정
    - 데이터베이스 관리자
    - 데이터베이스 담당자
    - 프로그래머(일부)
    
2. DML
    - Data Manipulation Language
    - 데이터 조작어
    - 데이터베이스의 데이터를 추가/수정/삭제/조회하는 명령어
    - 사용 빈도가 가장 높다
    - 명령어
        a. SELECT: 조회(읽기) > R (************************************************) 너무너무 중요
        b. INSERT: 추가       > C
        c. UPDATE: 수정       > U
        d. DELETE: 삭제       > D
    - 데이터베이스 관리자
    - 데이터베이스 담당자
    - 프로그래머 (************) : 우리 수업에 오라클이 있는 이유!
    
3. DCL
    - Data Control Language
    - 데이터 제어어
    - 계정 권한 관리, 보안 통제, 트랜지션 처리 등...
    - 명령어
        a. COMMIT
        b. ROLLBACK
        c. GRANT
        d. REVOKE
    - 데이터베이스 관리자
    - 데이터베이스 담당자
    - 프로그래머(일부)

4. DQL
    - Data Query Language
    - DML 중에 SELECT문을 따로 부른다

5. TCL
    - Transaction Control Language
    - DCL 중에 COMMIT, ROLLBACK만 따로 부른다.
    
    

오라클 인코딩
- 설정 > 변경 가능
- 버전에 따라 다르다
    - 오라클 1.0 ~ 8i: EUC-KR
    - 오라클 9i ~ 현재: UTF-8
    

Express Edition
- 무료 버전
- 11g
- 18c


*/


-- 파란색: 키워드     > SQL의 키워드(=명령어)는 대소문자 구분하지 않는다
-- tabs: 객체(식별자) > SQL의 식별자는 대소문자를 구분하지 않는다.

select * from tabs;
SELECT * FROM tabs;

select * from TABS;


select * from tabs where table_name = 'JOBS'; -- 결과 O: SQL은 데이터의 대/소문자를 구분한다. (*****)
select * from tabs where table_name = 'jobs'; -- 결과 X: SQL은 상수의 대/소문자를 구분한다.

-- 1. 키워드 > 대문자
-- 2. 식별자 > 소문자로 많이 쓴다

SELECT * FROM tabs;

SELECT * FROM tabs; -- 선택 후 Alt+' 누르면 패턴별로 알아서 바꿔준다
-- 하지만 회사마다, 프로젝트마다 표기 방식 다를 수 있으므로...
-- 우리는 키워드 > 소문자, 식별자 > 캐멀 표기법으로 연습하자!


-- DB Object 생성 시 식별자 주의점
create table aaa (
    num number
);


--31글자는 에러: ORA-00972: identifier is too long > longer than 30 bytes was specified.
create table aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa ( --30글자
    num number
);


/*

    관계형 데이터베이스 모델
    - 릴레이션(Relation) == 테이블(Table)
    
    
    테이블
    - DB   테이블의 구조 > Scheme, 스키마 > 컬럼의 집합
    - 자바 클래스의 구조 >                > 속성(멤버변수)의 집합
    
    컬럼
    - 속성(Attribute)
    
    행
    - 튜플(Tuple)
    - 행(Row), 레코드(Record)
    - 인스턴스(Instance)
    
    
    
    ex) 학생 릴레이션
    
    - 학생(번호,이름,나이,성별) > 릴레이션 스키마 표기
      - 도메인
        - 번호: 1 이상의 정수
        - 이름: 한글 2~5자
        - 나이: 14~16세 이내의 정수
        - 성별: M/F 1문자 택일
      - 차수: 4 > 속성(컬럼) 개수
      
      
      [번호]  [이름]  [나이]  [성별]            [취미]
      1       홍길동     14       M             독서, 먹방보기
      2       아무개     15       F             공부
      3       호호호     16       F             낮잠
      3       호호호     16       F  > 지양
      
      - 카디날리티 > 행의 개수 > 3
    
    
릴레이션 + 릴레이션 = 연산
표 + 표 = 연산


관계대수식의 연산

연산자(테이블)
셀렉션(단항): 조건에 따라 원하는 행을 추출하는 연산 (조건이 없으면 그대로 반환된다)
프로젝션(단항): 조건(컬럼 이름)에 따라 원하는 컬럼을 추출하는 연산 (조건이 없으면 그대로 반환된다)
합집합
차집합
조인(내부 조인)

*/