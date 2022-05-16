/* 교사 part 1

1) 로그인 (주민등록번호 뒷자리로)
2) 강의스케줄 조회
본인의 강의 스케줄 확인(강의예정/강의중/강의종료로 구분): 과목번호, 과정명, 과정기간(시작,끝), 강의실, 과목명, 과목기간, 교재명, 교육생 등록 인원
과목번호로 특정 과목 선택 시 해당 과정에 등록된 교육생 정보 확인: 이름, 전화번호, 등록일, 수료or중도탈락
3) 배점 입출력
강의를 마친 과목에 한해 특정 과목 선택, 배점 정보를 출결, 필기, 실기로 구분해 등록
과목 목록 전체 출력: 과목번호, 과정명, 과정기간(시작,끝), 강의실, 과목명, 과목기간(시작,끝), 교재명, 출결배점, 필기배점, 실기배점
특정 과목 선택 출력(과목번호로): 출결배점, 실기배점, 시험날짜, 시험문제

*/




-- 1. 교사 로그인
select * from tblTeacher;
select count(*) from tblTeacher where jumin = '입력 주민번호 뒷자리'; -- 결과값이 0이면 실패, 1이면 성공



-- 2-1. 강의 스케줄 조회
-- 본인의 강의 스케줄 확인(강의예정/강의중/강의종료로 구분)
-- : 과목번호, 과정명, 과정기간(시작,끝), 강의실, 과목명, 과목기간, 교재명, 교육생 등록 인원
select
    os.seq as "개설과목번호",
--    sc.sseq as "과목번호",
    c.courseName as "과정명",
    oc.startdate as "과정시작일",
    oc.enddate as "과정종료일",
    cr.classroomname as "강의실명",
    s.subjectname as "과목명",
    os.startdate as "과목시작일",
    os.enddate as "과목종료일",
    os.isprogress as "강의진행여부",
    b.booktitle as "교재명",
    (select count(*) from tblSignUp where ocseq = oc.seq and (dropoutdate is null or dropoutdate > os.enddate)) as "교육생 등록 인원"
    
from tblOpenedSubject os
    inner join tblSubjectCourse sc on os.scseq = sc.seq
    inner join tblCourse c on sc.cseq = c.seq
    inner join tblOpenedCourse oc on os.ocseq = oc.seq
    inner join tblClassroom cr on oc.rseq = cr.seq
    inner join tblSubject s on sc.sseq = s.seq
    inner join tblBookSubject bs on os.seq = bs.osseq
    inner join tblBook b on bs.bseq = b.seq
        where os.tseq = (select seq from tblTeacher where jumin = '조회할 교사 주민번호 뒷자리')
                order by oc.startdate, os.startdate asc;


-- 1명을 중도탈락 처리하고 다시 조회해보기
--update tblSignUp set dropoutdate = '2022-03-18' where seq = 1;




-- 2-2. 과목번호로 특정 과목 선택 > 해당 과정에 등록된 교육생 정보 확인: 이름, 전화번호, 등록일, 수료or중도탈락

select * from tblSubject;
select * from tblStudent;

select
    stu.name as "이름",
    stu.tel as "전화번호",
    stu.regdate as "등록일",
    case
        when su.completiondate is not null then '수료'
        when su.dropoutdate is not null then '중도탈락'
        else '수강중'
    end as "현재 상태"
    
/* 과목번호 = 과목 종류 번호일 경우
from tblSubject s inner join tblSubjectCourse sc on s.seq = sc.sseq
                  inner join tblCourse c on sc.cseq = c.seq
                  inner join tblOpenedCourse oc on c.seq = oc.cseq
                  inner join tblSignUp su on oc.seq = su.ocseq
                  inner join tblStudent stu on su.stuseq = stu.seq
                  where s.seq = 조회할 과목번호;
*/

--과목번호 = 개설과목번호일 경우
from tblOpenedSubject os inner join tblOpenedCourse oc on os.ocseq = oc.seq
                  inner join tblSignUp su on oc.seq = su.ocseq
                  inner join tblStudent stu on su.stuseq = stu.seq
                  where os.seq = 조회할 개설과목번호;





--3.1 강의를 마친 과목에 한해 특정 과목 선택, 배점 정보를 출결, 필기, 실기로 구분해 등록

insert into tblscoring(seq, osseq, attrate, wtestrate, ptestrate)
    values(seq_Scoring.nextVal, (select seq from tblOpenedSubject where isprogress = '강의종료' and seq = 개설과목번호), 출결배점, 필기배점, 실기배점);


--3.2 시험 날짜와 시험 문제 추가

insert into tblTest(seq, osseq, testdate, testtype, question)
    values (seq_Test.nextVal, '개설과목번호', '원하는 날짜', '필기/실기 중 하나의 값', '시험문제');


--3.3 과목 목록 전체 출력: (해당 교사가 맡은) 과목번호, 과정명, 과정기간(시작,끝), 강의실, 과목명, 과목기간(시작,끝), 교재명, 출결배점, 필기배점, 실기배점
--    배점 미등록 시 null로 출력

select
    os.seq as "개설과목번호",
--    sc.sseq as "과목번호",
    c.courseName as "과정명",
    oc.startdate as "과정시작일",
    oc.enddate as "과정종료일",
    cr.classroomname as "강의실명",
    s.subjectname as "과목명",
    os.startdate as "과목시작일",
    os.enddate as "과목종료일",
    os.isprogress as "강의진행여부",
    b.booktitle as "교재명",
    score.attrate as "출결배점",
    score.wtestrate as "필기배점",
    score.ptestrate as "실기배점"
    
from tblOpenedSubject os
    inner join tblSubjectCourse sc on os.scseq = sc.seq
    inner join tblCourse c on sc.cseq = c.seq
    inner join tblOpenedCourse oc on os.ocseq = oc.seq
    inner join tblClassroom cr on oc.rseq = cr.seq
    inner join tblSubject s on sc.sseq = s.seq
    inner join tblBookSubject bs on os.seq = bs.osseq
    inner join tblBook b on bs.bseq = b.seq
    left outer join tblScoring score on os.seq = score.osseq
        where os.tseq = (select seq from tblTeacher where jumin = '조회할 교사 주민번호 뒷자리')
                order by oc.startdate, os.startdate asc;
                

--3.3 특정 과목 선택 출력(과목번호로): 출결배점, 필기배점, 실기배점, 시험날짜, 시험문제
--    배점, 시험문제 미등록 시 null로 출력

select
    os.seq as "과목번호",
    score.attrate as "출결배점",
    score.wtestrate as "필기배점",
    score.ptestrate as "실기배점",
    t.testdate as "시험날짜",
    t.testtype as "시험유형",
    t.question as "시험문제"
    
from tblScoring score
    right outer join tblOpenedSubject os on score.osseq = os.seq
    inner join tblTest t on os.seq = t.osseq
        where os.seq = 개설과목번호
            order by t.testdate asc;
        