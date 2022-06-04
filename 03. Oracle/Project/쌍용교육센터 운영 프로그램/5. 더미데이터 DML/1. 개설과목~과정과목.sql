-- 과정 (수아님 부분)
/*
insert into tblCourse values(seq_course.nextval, '(디지털컨버젼스)AWS 클라우드 활용 자바(Java) Full-Stack 개발자 양성 과정'); -- Spring, Java, AWS, Oracle, HTML, CSS, JavaScript, jquery, jsp, spring, mybatis
insert into tblCourse values(seq_course.nextval, '실무 프로젝트 기반 자바&빅데이터 개발자 양성과정'); -- python, r프로그래밍
insert into tblCourse values(seq_course.nextval, '(빅데이터 전문가) 웹기반 빅데이터 활용 전문 개발자 양성과정'); -- python, MongoDB, Hadoop, Servlet/JSP, Spring/MyBatis
insert into tblCourse values(seq_course.nextval, 'AWS 활용 및 데이터 분석·시각화'); -- Spring, Java, AWS
insert into tblCourse values(seq_course.nextval, '안드로이드 앱 프로그래밍'); -- 안드로이드 프로그래밍, 안드로이드 DB 
insert into tblCourse values(seq_course.nextval, '웹 프론트엔드 클라우드 콘솔 개발자 양성'); -- Node, React, Vue, Angular, Python, MariaDB, MongoDB
insert into tblCourse values(seq_course.nextval, '(디지털컨버전스)자바(JAVA)기반 공공데이터 융합 개발자 양성과정'); -- Servlet/JSP, Spring/MyBatis, git
insert into tblCourse values(seq_course.nextval, '웹기반 빅데이터 전문 개발자 양성과정'); -- Spring, Java, MongoDB, Hadoop, node
*/



/*
과목 tblSubject 24개
과정과목 tblSubjectCourse 24개
교재 tblBook 22개
개설과목 tblOpenedSubject 36개
교재-개설과목 tblBookSubject 36개
*/


-- 과목
insert into tblSubject values(seq_subject.nextVal, 'Spring');
insert into tblSubject values(seq_subject.nextVal, 'Java');
insert into tblSubject values(seq_subject.nextVal, 'AWS');
insert into tblSubject values(seq_subject.nextVal, 'Oracle');
insert into tblSubject values(seq_subject.nextVal, 'HTML');                 --5
insert into tblSubject values(seq_subject.nextVal, 'CSS');
insert into tblSubject values(seq_subject.nextVal, 'JavaScript');
insert into tblSubject values(seq_subject.nextVal, 'jquery');
insert into tblSubject values(seq_subject.nextVal, 'jsp');
insert into tblSubject values(seq_subject.nextVal, 'mybatis');              --10
insert into tblSubject values(seq_subject.nextVal, 'python');
insert into tblSubject values(seq_subject.nextVal, 'r프로그래밍');
insert into tblSubject values(seq_subject.nextVal, 'MongoDB');
insert into tblSubject values(seq_subject.nextVal, 'Hadoop');
insert into tblSubject values(seq_subject.nextVal, 'Servlet/JSP');          --15
insert into tblSubject values(seq_subject.nextVal, 'Spring/Mybatis');
insert into tblSubject values(seq_subject.nextVal, '안드로이드 프로그래밍');
insert into tblSubject values(seq_subject.nextVal, '안드로이드 DB');
insert into tblSubject values(seq_subject.nextVal, 'Node');
insert into tblSubject values(seq_subject.nextVal, 'React');                --20
insert into tblSubject values(seq_subject.nextVal, 'Vue');
insert into tblSubject values(seq_subject.nextVal, 'Angular');
insert into tblSubject values(seq_subject.nextVal, 'MariaDB');
insert into tblSubject values(seq_subject.nextVal, 'git');






-- 과정과목 (과정과목번호, 과목번호, 과정번호)
-- java 필수 포함

--1 (디지털컨버젼스)AWS 클라우드 활용 자바(Java) Full-Stack 개발자 양성 과정 : Spring, java, AWS
insert into tblSubjectCourse values (SEQ_SUBJECTCOURSE.nextval, 1, 1);
insert into tblSubjectCourse values (SEQ_SUBJECTCOURSE.nextval, 2, 1);
insert into tblSubjectCourse values (SEQ_SUBJECTCOURSE.nextval, 3, 1);

--2 실무 프로젝트 기반 자바&빅데이터 개발자 양성과정 : java, python, r프로그래밍
insert into tblSubjectCourse values (SEQ_SUBJECTCOURSE.nextval, 2, 2);
insert into tblSubjectCourse values (SEQ_SUBJECTCOURSE.nextval, 11, 2);
insert into tblSubjectCourse values (SEQ_SUBJECTCOURSE.nextval, 12, 2);

--3 (빅데이터 전문가) 웹기반 빅데이터 활용 전문 개발자 양성과정: java, MongoDB, Servlet/JSP
insert into tblSubjectCourse values (SEQ_SUBJECTCOURSE.nextval, 2, 3);
insert into tblSubjectCourse values (SEQ_SUBJECTCOURSE.nextval, 13, 3);
insert into tblSubjectCourse values (SEQ_SUBJECTCOURSE.nextval, 15, 3);

--4 AWS 활용 및 데이터 분석·시각화: Spring, java, AWS
insert into tblSubjectCourse values (SEQ_SUBJECTCOURSE.nextval, 1, 4);
insert into tblSubjectCourse values (SEQ_SUBJECTCOURSE.nextval, 2, 4);
insert into tblSubjectCourse values (SEQ_SUBJECTCOURSE.nextval, 3, 4);

--5 안드로이드 앱 프로그래밍: 안드로이드 프로그래밍, 안드로이드 DB, java
insert into tblSubjectCourse values (SEQ_SUBJECTCOURSE.nextval, 17, 5);
insert into tblSubjectCourse values (SEQ_SUBJECTCOURSE.nextval, 18, 5);
insert into tblSubjectCourse values (SEQ_SUBJECTCOURSE.nextval, 2, 5);

--6 웹 프론트엔드 클라우드 콘솔 개발자 양성: React, Vue, java
insert into tblSubjectCourse values (SEQ_SUBJECTCOURSE.nextval, 20, 6);
insert into tblSubjectCourse values (SEQ_SUBJECTCOURSE.nextval, 21, 6);
insert into tblSubjectCourse values (SEQ_SUBJECTCOURSE.nextval, 2, 6);

--7 (디지털컨버전스)자바(JAVA)기반 공공데이터 융합 개발자 양성과정: java, Spring/MyBatis, git
insert into tblSubjectCourse values (SEQ_SUBJECTCOURSE.nextval, 2, 7);
insert into tblSubjectCourse values (SEQ_SUBJECTCOURSE.nextval, 16, 7);
insert into tblSubjectCourse values (SEQ_SUBJECTCOURSE.nextval, 24, 7);

--8 웹기반 빅데이터 전문 개발자 양성과정: java, Hadoop, node
insert into tblSubjectCourse values (SEQ_SUBJECTCOURSE.nextval, 2, 8);
insert into tblSubjectCourse values (SEQ_SUBJECTCOURSE.nextval, 14, 8);
insert into tblSubjectCourse values (SEQ_SUBJECTCOURSE.nextval, 19, 8);






set define off; --해당 코드 있어야 문자열 'Servlet' 값에 추가 가능

-- 교재 (교재번호, 교재명, 출판사, 저자)
insert into tblBook values(seq_tblbook.nextVal, '코드로 배우는 스프링 웹 프로젝트', '남가람북스', '구멍가게 코딩단');
insert into tblBook values(seq_tblbook.nextVal, 'Java의 정석 3판', '도우출판', '남궁성');
insert into tblBook values(seq_tblbook.nextVal, '당신이 지금 알아야 할 AWS', '비제이퍼블릭', '이영호, 한동수');
insert into tblBook values(seq_tblbook.nextVal, '데이터베이스 개론과 실습', '한빛아카데미', '박우창, 남송휘');
insert into tblBook values(seq_tblbook.nextVal, 'Do it! 자바 프로그래밍 입문', '이지스퍼블리싱', '박은종');              --5
insert into tblBook values(seq_tblbook.nextVal, '윤성우의 열혈 Java 프로그래밍', '오렌지미디어', '윤성우');  
insert into tblBook values(seq_tblbook.nextVal, '모던 자바스크립트 Deep Dive', '위키북스', '이웅모');
insert into tblBook values(seq_tblbook.nextVal, '자바스크립트+jQuery', '영진닷컴', '박성배');
insert into tblBook values(seq_tblbook.nextVal, '쉽게 배우는 JSP 웹 프로그래밍', '한빛아카데미', '송미영');
insert into tblBook values(seq_tblbook.nextVal, '스프링 부트 JSP + MyBatis + MySQL', '온노트', '향단코드');              --10
insert into tblBook values(seq_tblbook.nextVal, 'Do it! 점프 투 파이썬', '이지스퍼블리싱', '박응용');                 
insert into tblBook values(seq_tblbook.nextVal, '빅데이터 분석 도구 R 프로그래밍', '에이콘출판사', '권정민');
insert into tblBook values(seq_tblbook.nextVal, '몽고DB 완벽 가이드', '한빛미디어', '크리스티나 초도로 외 2명');
insert into tblBook values(seq_tblbook.nextVal, 'Hadoop 보안', '에이콘출판사', '수디쉬 나라야난');
insert into tblBook values(seq_tblbook.nextVal, 'JSP & Servlet 웹 프로그래밍 입문', '앤써북', '정동진, 최주호');         --15
insert into tblBook values(seq_tblbook.nextVal, '깡쌤의 안드로이드 프로그래밍', '쌤즈', '강성윤');                    
insert into tblBook values(seq_tblbook.nextVal, 'Node.js 교과서', '길벗', '조현영');
insert into tblBook values(seq_tblbook.nextVal, '초보자를 위한 리액트 200제', '정보문화사', '이정열');
insert into tblBook values(seq_tblbook.nextVal, 'Vue.js 프로젝트 투입 일주일 전', '비제이퍼블릭', '고승원'); 
insert into tblBook values(seq_tblbook.nextVal, '러닝! Angular 4', '위키북스', '브래드 데일리');                         --20
insert into tblBook values(seq_tblbook.nextVal, 'MariaDB 구축과 활용', '에이콘출판사', '다니엘 바솔로뮤');            
insert into tblBook values(seq_tblbook.nextVal, '팀 개발을 위한 Git, GitHub', '한빛미디어', '정호영, 진유림');







-- 개설과목: 6개월씩 12개 과정, !!!!개설과정당!!! 2개월씩 3개 > 36개
-- values (개설과목번호, 개설과정번호, 교사번호, 과정과목번호, 강의진행여부, 과목시작일, 과목종료일)


--현시점 강의인원(교사): 1, 2, 3, 4, 5, 6번 교사
--강의예정 인원: 7, 8, 2, 3, 4번 교사
--대타 대기인원(등록된 강의없음): 9, 10번 교사


--개설과정번호 > 개설과정명 : 해당 개설과목 3개
--개설과정 1 (수료) > (디지털컨버젼스)AWS 클라우드 활용 자바(Java) Full-Stack 개발자 양성 과정 : Spring, java, AWS
insert into tblOpenedSubject(seq, ocseq, tseq, scseq, isprogress, startdate, enddate) values (seq_OpenedSubject.nextVal, 1, 1, 1, '강의종료', '2021-10-18', '2021-12-17');
insert into tblOpenedSubject(seq, ocseq, tseq, scseq, isprogress, startdate, enddate) values (seq_OpenedSubject.nextVal, 1, 1, 2, '강의종료', '2021-12-18', '2022-02-17');
insert into tblOpenedSubject(seq, ocseq, tseq, scseq, isprogress, startdate, enddate) values (seq_OpenedSubject.nextVal, 1, 1, 3, '강의종료', '2022-02-18', '2022-04-18');

--개설과정 2 > 실무 프로젝트 기반 자바&빅데이터 개발자 양성과정 : java, python, r프로그래밍
insert into tblOpenedSubject(seq, ocseq, tseq, scseq, isprogress, startdate, enddate) values (seq_OpenedSubject.nextVal, 2, 2, 4, '강의종료', '2021-12-15', '2022-02-14');
insert into tblOpenedSubject(seq, ocseq, tseq, scseq, isprogress, startdate, enddate) values (seq_OpenedSubject.nextVal, 2, 2, 5, '강의종료', '2022-02-15', '2022-04-16');
insert into tblOpenedSubject(seq, ocseq, tseq, scseq, isprogress, startdate, enddate) values (seq_OpenedSubject.nextVal, 2, 2, 6, '강의중', '2022-04-17', '2022-06-20');

--개설과정 3 > (빅데이터 전문가) 웹기반 빅데이터 활용 전문 개발자 양성과정: java, MongoDB, Servlet/JSP
insert into tblOpenedSubject(seq, ocseq, tseq, scseq, isprogress, startdate, enddate) values (seq_OpenedSubject.nextVal, 3, 3, 7, '강의종료', '2022-01-31', '2022-04-01');
insert into tblOpenedSubject(seq, ocseq, tseq, scseq, isprogress, startdate, enddate) values (seq_OpenedSubject.nextVal, 3, 3, 8, '강의중', '2022-04-02', '2022-06-04');
insert into tblOpenedSubject(seq, ocseq, tseq, scseq, isprogress, startdate, enddate) values (seq_OpenedSubject.nextVal, 3, 3, 9, '강의예정', '2022-06-05', '2022-08-08');

--개설과정 4 > AWS 활용 및 데이터 분석·시각화: Spring, java, AWS
insert into tblOpenedSubject(seq, ocseq, tseq, scseq, isprogress, startdate, enddate) values (seq_OpenedSubject.nextVal, 4, 4, 10, '강의종료', '2022-02-14', '2022-04-14');
insert into tblOpenedSubject(seq, ocseq, tseq, scseq, isprogress, startdate, enddate) values (seq_OpenedSubject.nextVal, 4, 4, 11, '강의중', '2022-04-15', '2022-06-14');
insert into tblOpenedSubject(seq, ocseq, tseq, scseq, isprogress, startdate, enddate) values (seq_OpenedSubject.nextVal, 4, 4, 12, '강의예정', '2022-06-14', '2022-08-15');

--개설과정 5 > 안드로이드 앱 프로그래밍: 안드로이드 프로그래밍, 안드로이드 DB, java
insert into tblOpenedSubject(seq, ocseq, tseq, scseq, isprogress, startdate, enddate) values (seq_OpenedSubject.nextVal, 5, 5, 13, '강의종료', '2022-03-04', '2022-05-03');
insert into tblOpenedSubject(seq, ocseq, tseq, scseq, isprogress, startdate, enddate) values (seq_OpenedSubject.nextVal, 5, 5, 14, '강의중', '2022-05-04', '2022-07-04');
insert into tblOpenedSubject(seq, ocseq, tseq, scseq, isprogress, startdate, enddate) values (seq_OpenedSubject.nextVal, 5, 5, 15, '강의예정', '2022-07-05', '2022-09-05');

--개설과정 6 > 웹 프론트엔드 클라우드 콘솔 개발자 양성: React, Vue, java
insert into tblOpenedSubject(seq, ocseq, tseq, scseq, isprogress, startdate, enddate) values (seq_OpenedSubject.nextVal, 6, 6, 16, '강의중', '2022-04-25', '2022-06-24');
insert into tblOpenedSubject(seq, ocseq, tseq, scseq, isprogress, startdate, enddate) values (seq_OpenedSubject.nextVal, 6, 6, 17, '강의예정', '2022-06-25', '2022-08-25');
insert into tblOpenedSubject(seq, ocseq, tseq, scseq, isprogress, startdate, enddate) values (seq_OpenedSubject.nextVal, 6, 6, 18, '강의예정', '2022-08-26', '2022-10-26');

--개설과정 7 > (디지털컨버젼스)AWS 클라우드 활용 자바(Java) Full-Stack 개발자 양성 과정 : Spring, java, AWS
insert into tblOpenedSubject(seq, ocseq, tseq, scseq, isprogress, startdate, enddate) values (seq_OpenedSubject.nextVal, 7, 1, 1, '강의중', '2022-05-02', '2022-07-01');
insert into tblOpenedSubject(seq, ocseq, tseq, scseq, isprogress, startdate, enddate) values (seq_OpenedSubject.nextVal, 7, 1, 2, '강의예정', '2022-07-02', '2022-09-02');
insert into tblOpenedSubject(seq, ocseq, tseq, scseq, isprogress, startdate, enddate) values (seq_OpenedSubject.nextVal, 7, 1, 3, '강의예정', '2022-09-03', '2022-11-03');

--개설과정 8 > (디지털컨버전스)자바(JAVA)기반 공공데이터 융합 개발자 양성과정: java, Spring/MyBatis, git
insert into tblOpenedSubject(seq, ocseq, tseq, scseq, isprogress, startdate, enddate) values (seq_OpenedSubject.nextVal, 8, 7, 19, '강의예정', '2022-06-27', '2022-08-26');
insert into tblOpenedSubject(seq, ocseq, tseq, scseq, isprogress, startdate, enddate) values (seq_OpenedSubject.nextVal, 8, 7, 20, '강의예정', '2022-08-27', '2022-10-28');
insert into tblOpenedSubject(seq, ocseq, tseq, scseq, isprogress, startdate, enddate) values (seq_OpenedSubject.nextVal, 8, 7, 21, '강의예정', '2022-10-29', '2022-12-30');

--개설과정 9 > 웹기반 빅데이터 전문 개발자 양성과정: java, Hadoop, node
insert into tblOpenedSubject(seq, ocseq, tseq, scseq, isprogress, startdate, enddate) values (seq_OpenedSubject.nextVal, 9, 8, 22, '강의예정', '2022-08-16', '2022-10-15');
insert into tblOpenedSubject(seq, ocseq, tseq, scseq, isprogress, startdate, enddate) values (seq_OpenedSubject.nextVal, 9, 8, 23, '강의예정', '2022-10-16', '2022-12-18');
insert into tblOpenedSubject(seq, ocseq, tseq, scseq, isprogress, startdate, enddate) values (seq_OpenedSubject.nextVal, 9, 8, 24, '강의예정', '2022-12-19', '2023-02-20');

--개설과정 10 > 실무 프로젝트 기반 자바&빅데이터 개발자 양성과정 : java, python, r프로그래밍
insert into tblOpenedSubject(seq, ocseq, tseq, scseq, isprogress, startdate, enddate) values (seq_OpenedSubject.nextVal, 10, 2, 4, '강의예정', '2022-08-18', '2022-10-19');
insert into tblOpenedSubject(seq, ocseq, tseq, scseq, isprogress, startdate, enddate) values (seq_OpenedSubject.nextVal, 10, 2, 5, '강의예정', '2022-10-19', '2022-12-20');
insert into tblOpenedSubject(seq, ocseq, tseq, scseq, isprogress, startdate, enddate) values (seq_OpenedSubject.nextVal, 10, 2, 6, '강의예정', '2022-12-21', '2023-02-22');

--개설과정 11 > (빅데이터 전문가) 웹기반 빅데이터 활용 전문 개발자 양성과정: java, MongoDB, Servlet/JSP
insert into tblOpenedSubject(seq, ocseq, tseq, scseq, isprogress, startdate, enddate) values (seq_OpenedSubject.nextVal, 11, 3, 7, '강의예정', '2022-09-08', '2022-11-10');
insert into tblOpenedSubject(seq, ocseq, tseq, scseq, isprogress, startdate, enddate) values (seq_OpenedSubject.nextVal, 11, 3, 8, '강의예정', '2022-11-11', '2023-01-10');
insert into tblOpenedSubject(seq, ocseq, tseq, scseq, isprogress, startdate, enddate) values (seq_OpenedSubject.nextVal, 11, 3, 9, '강의예정', '2023-01-10', '2023-03-13');

--개설과정 12 > AWS 활용 및 데이터 분석·시각화: Spring, java, AWS
insert into tblOpenedSubject(seq, ocseq, tseq, scseq, isprogress, startdate, enddate) values (seq_OpenedSubject.nextVal, 12, 4, 10, '강의예정', '2022-11-07', '2023-01-07');
insert into tblOpenedSubject(seq, ocseq, tseq, scseq, isprogress, startdate, enddate) values (seq_OpenedSubject.nextVal, 12, 4, 11, '강의예정', '2023-01-08', '2023-03-09');
insert into tblOpenedSubject(seq, ocseq, tseq, scseq, isprogress, startdate, enddate) values (seq_OpenedSubject.nextVal, 12, 4, 12, '강의예정', '2023-03-09', '2022-05-10');







-- 교재-개설과목 (번호, 교재번호, 개설과목번호)
-- 같은 과목 종류여도 다른 교재 사용하는 경우 있음!

-- 개설과목 1, 2, 3: Spring, java, AWS
insert into tblBookSubject(seq, bseq, osseq) values (SEQ_BOOKSUBJECT.nextVal, 1, 1);
insert into tblBookSubject(seq, bseq, osseq) values (SEQ_BOOKSUBJECT.nextVal, 2, 2);
insert into tblBookSubject(seq, bseq, osseq) values (SEQ_BOOKSUBJECT.nextVal, 3, 3);

-- 개설과목 4, 5, 6: java, python, r프로그래밍
insert into tblBookSubject(seq, bseq, osseq) values (SEQ_BOOKSUBJECT.nextVal, 2, 4);
insert into tblBookSubject(seq, bseq, osseq) values (SEQ_BOOKSUBJECT.nextVal, 11, 5);
insert into tblBookSubject(seq, bseq, osseq) values (SEQ_BOOKSUBJECT.nextVal, 12, 6);

-- 개설과목 7, 8, 9: java, MongoDB, Servlet/JSP
insert into tblBookSubject(seq, bseq, osseq) values (SEQ_BOOKSUBJECT.nextVal, 5, 7);
insert into tblBookSubject(seq, bseq, osseq) values (SEQ_BOOKSUBJECT.nextVal, 13, 8);
insert into tblBookSubject(seq, bseq, osseq) values (SEQ_BOOKSUBJECT.nextVal, 15, 9);

-- 개설과목 10, 11, 12: Spring, java, AWS
insert into tblBookSubject(seq, bseq, osseq) values (SEQ_BOOKSUBJECT.nextVal, 10, 10);
insert into tblBookSubject(seq, bseq, osseq) values (SEQ_BOOKSUBJECT.nextVal, 2, 11);
insert into tblBookSubject(seq, bseq, osseq) values (SEQ_BOOKSUBJECT.nextVal, 3, 12);

-- 개설과목 13, 14, 15: 안드로이드 프로그래밍, 안드로이드 DB, java
insert into tblBookSubject(seq, bseq, osseq) values (SEQ_BOOKSUBJECT.nextVal, 16, 13);
insert into tblBookSubject(seq, bseq, osseq) values (SEQ_BOOKSUBJECT.nextVal, 4, 14);
insert into tblBookSubject(seq, bseq, osseq) values (SEQ_BOOKSUBJECT.nextVal, 5, 15);

-- 개설과목 16, 17, 18: React, Vue, java
insert into tblBookSubject(seq, bseq, osseq) values (SEQ_BOOKSUBJECT.nextVal, 18, 16);
insert into tblBookSubject(seq, bseq, osseq) values (SEQ_BOOKSUBJECT.nextVal, 19, 17);
insert into tblBookSubject(seq, bseq, osseq) values (SEQ_BOOKSUBJECT.nextVal, 6, 18);

-- 개설과목 19, 20, 21: Spring, java, AWS
insert into tblBookSubject(seq, bseq, osseq) values (SEQ_BOOKSUBJECT.nextVal, 1, 19);
insert into tblBookSubject(seq, bseq, osseq) values (SEQ_BOOKSUBJECT.nextVal, 2, 20);
insert into tblBookSubject(seq, bseq, osseq) values (SEQ_BOOKSUBJECT.nextVal, 4, 21);

-- 개설과목 22, 23, 24: java, Spring/MyBatis, git
insert into tblBookSubject(seq, bseq, osseq) values (SEQ_BOOKSUBJECT.nextVal, 5, 22);
insert into tblBookSubject(seq, bseq, osseq) values (SEQ_BOOKSUBJECT.nextVal, 10, 23);
insert into tblBookSubject(seq, bseq, osseq) values (SEQ_BOOKSUBJECT.nextVal, 22, 24);

-- 개설과목 25, 26, 27: java, Hadoop, node
insert into tblBookSubject(seq, bseq, osseq) values (SEQ_BOOKSUBJECT.nextVal, 6, 25);
insert into tblBookSubject(seq, bseq, osseq) values (SEQ_BOOKSUBJECT.nextVal, 14, 26);
insert into tblBookSubject(seq, bseq, osseq) values (SEQ_BOOKSUBJECT.nextVal, 17, 27);

-- 개설과목 28, 29, 30: java, python, r프로그래밍
insert into tblBookSubject(seq, bseq, osseq) values (SEQ_BOOKSUBJECT.nextVal, 2, 28);
insert into tblBookSubject(seq, bseq, osseq) values (SEQ_BOOKSUBJECT.nextVal, 11, 29);
insert into tblBookSubject(seq, bseq, osseq) values (SEQ_BOOKSUBJECT.nextVal, 12, 30);

-- 개설과목 31, 32, 33: java, MongoDB, Servlet/JSP
insert into tblBookSubject(seq, bseq, osseq) values (SEQ_BOOKSUBJECT.nextVal, 5, 31);
insert into tblBookSubject(seq, bseq, osseq) values (SEQ_BOOKSUBJECT.nextVal, 13, 32);
insert into tblBookSubject(seq, bseq, osseq) values (SEQ_BOOKSUBJECT.nextVal, 15, 33);

-- 개설과목 34, 35, 36: Spring, java, AWS
insert into tblBookSubject(seq, bseq, osseq) values (SEQ_BOOKSUBJECT.nextVal, 1, 34);
insert into tblBookSubject(seq, bseq, osseq) values (SEQ_BOOKSUBJECT.nextVal, 2, 35);
insert into tblBookSubject(seq, bseq, osseq) values (SEQ_BOOKSUBJECT.nextVal, 3, 36);