
/*
대면/비대면(교육생)
수료생
수령방법
자격증 - 교육생
자격증
*/


-- 대면/비대면 수업 등록 내역 (교육생)
create table tblHomeStudent (
    seq number not null,
    stuseq number not null,
    ocseq number not null,
    classday date not null,
    home varchar2(9) default '비대면' not null,

    constraint tblHomeStudent_seq_pk primary key(seq),
    constraint tblHomeStudent_stuseq_fk foreign key(stuseq) references tblStudent(seq),
    constraint tblHomeStudent_ocseq_fk foreign key(ocseq) references tblOpenedCourse(seq),
    constraint tblHomeStudent_home_ck check (home in ('대면', '비대면'))
);

create sequence seq_homeStudent;


-- 수료생
create table tblGraduate (
    seq number not null,
    ocseq number not null,
    stuseq number not null,
    jseq number not null,
    place varchar2(90) not null,
    salary varchar2(60) not null,
    education varchar2(60) not null,
    employment char not null,
    
    constraint tblGraduate_seq_pk primary key(seq),
    constraint tblGraduate_ocseq_fk foreign key(ocseq) references tblOpenedCourse(seq),
    constraint tblGraduate_stuseq_fk foreign key(stuseq) references tblStudent(seq),
    constraint tblGraduate_jseq_fk foreign key(jseq) references tblJob(seq),
    constraint tblGraduate_employment_ck check (employment in ('y', 'n'))
);

create sequence seq_graduate;


--수령방법
create table tblDelivery (
    seq number not null,
    stuseq number not null,
    osseq number not null,
    delivery varchar2(10) not null,
    receipt char not null,
    
    constraint tblDelivery_seq_pk primary key(seq),
    constraint tblDelivery_stuseq_fk foreign key(stuseq) references tblStudent(seq),
    constraint tblDelivery_osseq_fk foreign key(osseq) references tblOpenedSubject(seq),
    constraint tblDelivery_delivery_ck check (delivery in ('방문', '택배')),
    constraint tblDelivery_receipt_ck check (receipt in ('y', 'n'))
);

create sequence seq_delivery;


--자격증
create table tblCertificate (
    seq number not null,
    certificateName varchar2(60) not null,
    
    constraint tblCertificate_seq_pk primary key(seq)
);

create sequence seq_certificate;


--자격증 - 교육생
create table tblCertificateStudent (
    seq number not null,
    stuseq number not null,
    cseq number not null,
    adate date not null,
    
    constraint tblCertificateStudent_seq_pk primary key(seq),
    constraint tblCertificateStudent_stuseq_fk foreign key(stuseq) references tblStudent(seq),
    constraint tblCertificateStudent_cseq_fk foreign key(cseq) references tblCertificate(seq)
);

create sequence seq_certificateStudent;