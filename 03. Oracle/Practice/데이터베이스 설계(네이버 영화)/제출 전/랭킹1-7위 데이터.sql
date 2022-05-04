

-- 1 신비한 동물들과 덤블도어의 비밀

insert into tblMovie(seq, rseq, title, engtitle, audience, runningtime, likes, summary, releasedate)

values(1, 2, '신비한 동물들과 덤블도어의 비밀', 'Fantastic Beasts: The Secrets of Dumbledore, 2022', 1090198, 142, 4329, '가장 위험한 마법에 맞선, 세상을 구할 전쟁이 시작된다!
    1930년대, 제2차 세계대전에 마법사들이 개입하게 되면서
     강력한 어둠의 마법사 그린델왈드의 힘이 급속도로 커진다.
     덤블도어는 뉴트 스캐맨더에게 위대한 마법사 가문 후손,
     마법학교의 유능한 교사, 머글 등으로 이루어진 팀에게 임무를 맡긴다.
     이에 뉴트와 친구들은 머글과의 전쟁을 선포한
     그린델왈드와 추종자들, 그의 위험한 신비한 동물들에 맞서 세상을 구할 거대한 전쟁에 나선다.
     한편 전쟁의 위기가 최고조로 달한 상황 속에서 덤블도어는
     더 이상 방관자로 머물 수 없는 순간을 맞이하고, 서서히 숨겨진 비밀이 드러나는데…', '2022-04-13');
     
     
insert into tblMovieGenre(seq, mseq, gseq) values(seq.nextVal, 1, 2);
insert into tblMovieGenre(seq, mseq, gseq) values(seq.nextVal, 1, 6);
insert into tblMovieGenre(seq, mseq, gseq) values(seq.nextVal, 1, 12);


insert into tblMovieCountry(seq, mseq, cseq) values(seq.nextVal, 1, 2);


insert into tblMovievideo(seq, mseq, division, title, regdate, video) values(seq.nextVal, 1, '예고편', '티저 예고편', '2021-12-17', 'https://movie.naver.com/movie/bi/mi/mediaView.naver?code=164122&mid=51343');
insert into tblMovievideo(seq, mseq, division, title, regdate, video) values(seq.nextVal, 1, '예고편', '2차 예고편', '2022-03-16', 'https://movie.naver.com/movie/bi/mi/mediaView.naver?code=164122&mid=51943');
insert into tblMovievideo(seq, mseq, division, title, regdate, video) values(seq.nextVal, 1, '예고편', '파이널 예고편', '2022-04-12', 'https://movie.naver.com/movie/bi/mi/mediaView.naver?code=164122&mid=52130');
insert into tblMovievideo(seq, mseq, division, title, regdate, video) values(seq.nextVal, 1, '메이킹', 'Wizarding World 스페셜 영상', '2021-12-17', 'https://movie.naver.com/movie/bi/mi/mediaView.naver?code=164122&mid=51344');
insert into tblMovievideo(seq, mseq, division, title, regdate, video) values(seq.nextVal, 1, '메이킹', '[스페셜 영상] 덤블도어의 첫 번째 군대', '2022-03-18', 'https://movie.naver.com/movie/bi/mi/mediaView.naver?code=164122&mid=51966');


insert into tblPhoto(seq, mseq, category, photoURL, title) values(seq.nextVal, 1, '스틸컷', 'https://movie.naver.com/movie/bi/mi/photoView.naver?code=164122&imageNid=6760599', '영화 <신비한 동물들과 덤블도어의 비밀> 스틸 이미지');
insert into tblPhoto(seq, mseq, category, photoURL, title) values(seq.nextVal, 1, '스틸컷', 'https://movie.naver.com/movie/bi/mi/photoView.naver?code=164122&imageNid=6760934', '영화 <신비한 동물들과 덤블도어의 비밀> 스틸 이미지');
insert into tblPhoto(seq, mseq, category, photoURL, title) values(seq.nextVal, 1, '포스터', 'https://movie.naver.com/movie/bi/mi/photoView.naver?code=164122&imageNid=6760050', '메인 포스터');
insert into tblPhoto(seq, mseq, category, photoURL, title) values(seq.nextVal, 1, '포스터', 'https://movie.naver.com/movie/bi/mi/photoView.naver?code=164122&imageNid=6753475', '1차 포스터');
insert into tblPhoto(seq, mseq, category, photoURL, title) values(seq.nextVal, 1, '포스터', 'https://movie.naver.com/movie/bi/mi/photoView.naver?code=164122&imageNid=6760053', '파이널 포스터');


insert into tblQuote(seq, mseq, ID, mpseq, line, role, likes, regdate) values(seq.nextVal, 1, 'tlaw****', 2, '정답, 후플푸프에 3점', '알버스 덤블도어', 61, '2022-04-14');
insert into tblQuote(seq, mseq, ID, mpseq, line, role, likes, regdate) values(seq.nextVal, 1, 'tlaw****', 3, '이제 누가 널 사랑해줄까?', '겔러트 그린델왈드', 30, '2022-04-15');
insert into tblQuote(seq, mseq, ID, mpseq, line, role, likes, regdate) values(seq.nextVal, 1, 'klos****', 3, '난 적이 아니야. 그때나 지금이나.', '겔러트 그린델왈드', 26, '2022-04-13');
insert into tblQuote(seq, mseq, ID, mpseq, line, role, likes, regdate) values(seq.nextVal, 1, 'misy****', 1, '가장 완벽한 계획이 뭔지 알아? 무계획이야.', '뉴트 스캐맨더', 25, '2022-04-13');
insert into tblQuote(seq, mseq, ID, mpseq, line, role, likes, regdate) values(seq.nextVal, 1, 'klos****', 2, '내가 동조했던 이유는, 널 사랑했기 때문이야.', '알버스 덤블도어', 19, '2022-04-13');


insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 1, (select m.seq from tblMoviePerson m where m.name = '에디 레드메인'), '주연', '뉴트 스캐맨더');
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 1, (select m.seq from tblMoviePerson m where m.name = '주드 로'), '주연', '알버스 덤블도어');
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 1, (select m.seq from tblMoviePerson m where m.name = '매즈 미켈슨'), '주연', '겔러트 그린델왈드');
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 1, (select m.seq from tblMoviePerson m where m.name = '댄 포글러'), '주연', '제이콥 코왈스키');
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 1, (select m.seq from tblMoviePerson m where m.name = '앨리슨 수돌'), '주연', '퀴니 골드스틴');
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 1, (select m.seq from tblMoviePerson m where m.name = '에즈라 밀러'), '주연', '크레덴스 베어본');
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 1, (select m.seq from tblMoviePerson m where m.name = '칼럼 터너'), '주연', '테세우스 스캐맨더');
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 1, (select m.seq from tblMoviePerson m where m.name = '제시카 윌리엄스'), '주연', '율랄리 힉스');
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 1, (select m.seq from tblMoviePerson m where m.name = '데이빗 예이츠'), '감독', null);


insert into tblRatings(seq, score, contents, regdate, likes, nlikes, mseq, ID) values(seq.nextVal, 6, '진짜 해리포터와 덤블도어랑의 의리로 봄 +영상미랑 CG는 괜찮은데..스토리는 너무 기대하지 마시길 중간에 호그와트 나올때 찡하긴함', '2022-04-13', 446, 37, 1, 'choi****');
insert into tblRatings(seq, score, contents, regdate, likes, nlikes, mseq, ID) values(seq.nextVal, 6, '이 시리즈의 끝을 꼭 봐야겠어', '2022-04-13', 368, 36, 1, 'ldkp****');
insert into tblRatings(seq, score, contents, regdate, likes, nlikes, mseq, ID) values(seq.nextVal, 4, ' 뭔가 스토리가 혼잡스럽다.그리고 덤블도어 교수님도 결혼식 초대해주지 혼자 외롭게 뭐야 후플푸프 -3점!', '2022-04-13', 340, 52, 1, 'mari****');
insert into tblRatings(seq, score, contents, regdate, likes, nlikes, mseq, ID) values(seq.nextVal, 8, '본인 세계관 파괴를 일삼는 롤링의 각본 탓인지 스토리의 개연성이 많이 떨어지지만,그럼에도 불구하고 뉴트 스캐맨더의 어정쩡한 자세와 흔들리는 눈빛이 참 반갑다.', '2022-04-13', 271, 28, 1, 'silk****');
insert into tblRatings(seq, score, contents, regdate, likes, nlikes, mseq, ID) values(seq.nextVal, 6, '신비한 동물사전4을 위한 초석이었.. 아니 이거 1편 2편볼때 했던 말 같은데...? 힝 또 속았지?', '2022-04-13', 254, 28, 1, 'band****');


insert into tblMovieReivew(seq, contents, regdate, title, views, recommendedNum, mseq, ID) values(seq.nextVal, '신비한 동물사전 3 감독 데이빗 예이츠 출연 캐서린 워터스턴, 조니 뎁, 주드 로, 에디 레드메인, 에즈라 밀러 개봉 미국 평점 리뷰보기 1편은 당시의 시대상과 세계관을 새롭게 ...', '2020-12-01', '신비한 동물 사전 시리즈의 핵심적인 문제점이라면 ', 430, 0, 1, 'hera****');
insert into tblMovieReivew(seq, contents, regdate, title, views, recommendedNum, mseq, ID) values(seq.nextVal, '4월 13일 개봉하는 영화 신비한 동물들과 덤블도어의 비밀입니다.완전 기다리던 영화였는지라..오늘 아침에 조조할인으로 보고 왔는데요.. 이 작품은 신비한 동물사전 시리즈 세번째 작품이기도 합니다.원래 신비한 동물사전 시리...', '2022-04-13', '[영화감상] 신비한 동물들과 덤블도어의 비밀...', 94, 0, 1, 'sakg****');
insert into tblMovieReivew(seq, contents, regdate, title, views, recommendedNum, mseq, ID) values(seq.nextVal, '신비한 동물들과 덤블도어의 비밀 감독 데이빗 예이츠 출연 주드 로, 에디 레드메인, 에즈라 밀러, 매즈 미켈슨... 개봉 2022.04.... 리뷰보기 한줄평 : 개봉하자마자 퇴근하고 보러 감...', '2022-04-13', '[판타지/모험] 신비한 동물들과 덤블도어의 비밀...', 16, 0, 1, '0107****');
insert into tblMovieReivew(seq, contents, regdate, title, views, recommendedNum, mseq, ID) values(seq.nextVal, '220418전주 송천동 영화관 CGV 전주에코시티 로마네시티 신비한 동물들과 덤블도어의 비밀 네이버 지도가 첨부되었습니다. 네이버 지도는 원본 포스트에서 볼수 있습니다. 원본보기 1544-1122주소전북 전주시 덕진구 세병2길 10 ...', '2022-04-22', '전주 송천동 영화관 CGV 전주에코시티 로마네시티...', 8, 0, 1, 'dduz****');
insert into tblMovieReivew(seq, contents, regdate, title, views, recommendedNum, mseq, ID) values(seq.nextVal, '아 오늘 날씨 무지좋습니다....... 요즘 이래저래....... 가슴이 답답 하네욤코로나 ~ 는 종식이 안되는 듯하네요. 앞으로 점점 어떻게 될련지 모르겠구요확진자는 점점 늘어 나는 추세인듯하더군요.. 벌써 저의동네 도확진자몇명이...', '2022-04-28', '오늘날씨 좋네요', 3, 0, 1, 'cowb****');


insert into tblUser(id, gender, age) values('tlaw****', 'm', 20);
insert into tblUser(id, gender, age) values('klos****', 'f', 25);
insert into tblUser(id, gender, age) values('misy****', 'f', 30);
insert into tblUser(id, gender, age) values('choi****', 'f', 23);
insert into tblUser(id, gender, age) values('ldkp****', 'm', 20);
insert into tblUser(id, gender, age) values('mari****', 'f', 35);
insert into tblUser(id, gender, age) values('silk****', 'm', 33);
insert into tblUser(id, gender, age) values('band****', 'm', 19);
insert into tblUser(id, gender, age) values('hera****', 'm', 40);
insert into tblUser(id, gender, age) values('sakg****', 'f', 42);
insert into tblUser(id, gender, age) values('0107****', 'f', 33);
insert into tblUser(id, gender, age) values('dduz****', 'm', 38);
insert into tblUser(id, gender, age) values('cowb****', 'f', 27);
insert into tblUser(id, gender, age) values('13th****', 'm', 19);
insert into tblUser(id, gender, age) values('freg****', 'f', 15);
insert into tblUser(id, gender, age) values('aaa6****', 'f', 30);
insert into tblUser(id, gender, age) values('high****', 'm', 40);
insert into tblUser(id, gender, age) values('bith****', 'f', 45);
insert into tblUser(id, gender, age) values('ehdt****', 'm', 52);
insert into tblUser(id, gender, age) values('turt****', 'm', 57);
insert into tblUser(id, gender, age) values('aa_7****', 'f', 27);
insert into tblUser(id, gender, age) values('askf****', 'f', 23);
insert into tblUser(id, gender, age) values('inve****', 'm', 17);
insert into tblUser(id, gender, age) values('0nik****', 'f', 27);
insert into tblUser(id, gender, age) values('dnfl****', 'f', 25);
insert into tblUser(id, gender, age) values('sons****', 'm', 25);
insert into tblUser(id, gender, age) values('nj08****', 'f', 15);
insert into tblUser(id, gender, age) values('gile****', 'm', 55);
insert into tblUser(id, gender, age) values('rkrk****', 'f', 45);
insert into tblUser(id, gender, age) values('eva7****', 'm', 35);


insert into tblAwards(seq, mpseq, content) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '에디 레드메인'), '2015년 제 36회 골든 라즈베리 시상식 최악의 남우조연상');
insert into tblAwards(seq, mpseq, content) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '에디 레드메인'), '2014년 제 72회 골든 글로브 시상식 남우주연상-드라마');
insert into tblAwards(seq, mpseq, content) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '주드 로'), '2007년 32회 세자르영화제 공로상');
insert into tblAwards(seq, mpseq, content) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '매즈 미켈슨'), '2020년 68회 산세바스티안국제영화제 은조개상 - 남우주연상');
insert into tblAwards(seq, mpseq, content) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '매즈 미켈슨'), '2020년 제 33회 유럽영화상 유러피안 남우주연상');


insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '에디 레드메인'), '13th****', '대니쉬걸로 알게되어 팬이 되었는데 연기력 진짜 짱..대니쉬걸에서 에디 레드메인이 여성화되는 제스처나 표정 말투 등등 진짜 소름돋는 연기때문에 긴영화임에도 불구하고 빨려들어가듯이 집중해서 ...', '2016-12-26', '섬세한 연기를 너무 잘하는 배우', 598, 2);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '에디 레드메인'), 'freg****', '레미제라블에서 처음 본 배우..주연이 아니였음에도 관객들에게 그의 이름을 각인 시킬 수 있었던 그 만의 매력이 있었다. 이번 신비한 동물사전에서 그 만의 분위기를 잘 보여줬다고 생각한다.에디 ...', '2016-11-29', '에디만의 독특한 느낌과 분위기.. 앞으로가 기대됩니다.', 773, 2);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '주드 로'), 'aaa6****', '<매력적인 섹시가이 주드 로를 기억하다.. > 런던 출신의 섹시한 눈빛을 지닌 배우 주드로 그가 제 9회 유럽영화제 (10월 22~26) 개막작 추적과 함께 돌아온다! 가끔은 진지하게, 가...', '2008-10-23', '매력적인 섹시가이 주드 로를 기억하다..', 4099, 3);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '주드 로'), 'high****', '섹시 스타 주드 로 완벽 변신!!!!! 피플지 선정 2000년 "가장 아름다운 50인" 피플지 선정 2004년 "세계에서 가장 섹시한 남자" 1위!!!!!!!! 와우~ 역시나 멋진 주드 로!! 그런 그가 2009...', '2009-11-17', '섹시 스타 주드 로 완벽 변신!!!!', 3188, 1);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '주드 로'), 'bith****', '요즘 <컨테이젼>모르면 영화 얘기도 하지 말라면서요?! +_+ 그 만큼 사람들에게 회자되고 있는 <컨테이젼>을 보고왔습니다 간단한 리뷰에 앞서서 우선 이 영화가 왜 사람들에게 ...', '2011-09-21', '혹성탈출을 뛰어넘는 전율!! <컨테이젼>', 1577, 1);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '매즈 미켈슨'), 'ehdt****', '아직 국내 인지도는 여느 유명 할리우드 배우들과 비교해 조금 떨어지지만 굉장히 멋지고 훌륭한 배우입니다. 더헌트로 칸 남우주연상 수상도 했고 국내와 달리 해외에서는 큰 인기를 누리고 있습니...', '2014-02-22', '내가 제일 사랑하고 좋아하는 배우!', 1221, 4);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '매즈 미켈슨'), 'turt****', '한니발 시즌1을 보면서 알게된 배우입니다 침착하면서 부드럽고 그렇지만 언제는 날카로운 이미지를 보유한 배우같아요 한니발 드라마에서도 출중한 연기력을 보여주지만 영화 "더 헌트...', '2014-03-24', '진정한 연기파 배우', 886, 3);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '댄 포글러'), 'proz****', '나의 청소년기를 빛내 준 해리포터 시리즈의스핀오프 영화 신비한 동물사전을 보고 왔어요~~~~~~전 해리포터 덕후고 남친은 책은 안보고 영화만 본 머글인데남친 평: 이름 나올 때 좀 헷갈리긴 했지만...', '2016-11-23', '자신만의 캐릭터를 적절하게 소화하는 배우', 336, 1);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '댄 포글러'), 'fndl****', '필자는 분노의 핑퐁으로 이 영화를 알게 되었다. 스토리나 개연성이 형편없어서 B급 싸구려 코미디영화라는 혹평이 존재하지만, 막장 스토리와는 별개로 배우나 연출의 퀄리티가 낮지 않다. 영화관...', '2018-04-14', '코미디에"만" 특화된 것 같은 배', 128, 0);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '에즈라 밀러'), 'aa_7****', '천의 얼굴을 가진게 배우라더니. 이자식을 두고 한말이구나.. 어쩜그리 표정표정하나가. 오묘함이 넘실넘실거린다. 대성하겠다..같이 사진한장 찍었음 좋겠다. 헌데 표정하나하나가 너무 생생하게 느...', '2012-08-28', '사진을 보면 볼수록 너무 매력적이다. ', 4405, 10);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '에즈라 밀러'), 'askf****', '일단 월플라워와 케빈에대하여를 봐라. 무조건.이 배우를 알게된건 월플라워.그의 연기력에 소름돋은건 케빈에대하여이다.그의 작품은 그리 많지 않지만 그의 연기력은 극찬을 해도 모자를 정도로 뛰어...', '2013-08-05', '에즈라밀러,미모와 소름돋는 연기를 갖춘 주목해야 할 배우.', 2571, 5);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '에즈라 밀러'), 'inve****', '내가 에즈라밀러를 알게된 건 올해 초, <케빈에 대하여>를 보고 나서그때당시만 해도 별 생각 없었다. 그냥 연기잘하는 어린 배우. 사실 초점이 케빈에게 가있어야 하는데, 영화 연출상 계속 엄...', '2015-10-05', '연기뿐만 아니라 사람 자체가 매력적이다.', 1458, 4);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '에즈라 밀러'), '0nik****', '인터뷰같은거 보면 이분은 연기를 하기전에 인물에 대한 공부? 연구? 같은걸 하고 연기하는 티가 난다 ㅠㅠ 되게 캐릭터에 대해서 깊숙히 이해하고 연기하는데에서 섬세한 연기가 나온다. 일화를 하나...', '2017-01-17', '섬세한 연기력 ㅠㅠ ', 86, 1);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '데이빗 예이츠'), 'sons****', '데이빗 예이츠, 해리포터와 불사조 기사단의 감독이자 해리포터와 혼혈 왕자의 감독. 진짜 허접한 감독인것 같다.. 불사조 기사단이, 흥행에는 두번째로 성공한 작품이지만, 그것은 이 영화의 작품성 ...', '2008-02-19', '아.. 정말 너무했다.', 16433, 25);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '데이빗 예이츠'), 'nj08****', '본격 미소녀 연애 판타지물이 되버린겁니까? 방금 혼혈왕자를 보고 왔습니다.. 아무리봐도 기억나는거라곤 론의 연애사 뿐인데.... 뭐죠 대체.. 제가 소설을 난독증이 있어서 잘못읽은걸까요?.. ...', '2009-07-15', '어째서 해리포터 시리즈가......', 6162, 12);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '데이빗 예이츠'), 'gile****', '어제 해리포터와 혼혈왕자를 보고와서.. 보기전에 네이버평을 보고 나서 마음의 준비는 하고 갔더랬습니다. 아무리 영화가 엉망으로 나왔다하더라도, 이제까지 끌고온 스토리의 힘도 있고, 완벽하게 판...', '2009-07-20', '감독이 문제일까요, 아니면 극작가가 문제일까요.', 2993, 6);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '데이빗 예이츠'), 'rkrk****', '(참고로 저는 원작 한권도 안봤고 영화의 작품성 으로만 판단하니 태클걸진 말아주시길.) 해리포터가 불사조기사단이 나올때까지만해도 시리즈의절정은 <아즈카반의 죄수>와 <불의 잔>이...', '2009-07-22', '불사조기사단-범작.혼혈왕자-걸작.(영화 스포있음)', 1250, 0);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '데이빗 예이츠'), 'eva7****', '당시 해리포터와 불사조 기사단 개봉 당시 저는 예고편을 보고 긴장감이 넘치더군요 . 5편 소설을 안봐서 소설 이야기도 조금 알겠다 , 하는 심정이었습니다 . 그리고 불사조 기사단에 대해 검색...', '2009-09-13', '데이빗 예이츠 ?', 671, 0);

insert into tblFilmcompanyMovie(seq, fseq, mseq, role) values(seq.nextVal, 1, 1, '수입');
insert into tblFilmcompanyMovie(seq, fseq, mseq, role) values(seq.nextVal, 1, 1, '배급');



-- 2 공기살인

insert into tblMovie(seq, rseq, title, engtitle, audience, runningtime, likes, summary, releasedate)
values(2, 2, '공기살인', 'TOXIC, 2022', 146927, 108, 1130, '“알고 있었죠, 사람이 죽을 수도 있다는 거”
봄이 되면 나타났다 여름이 되면 사라지는 죽음의 병.
 공기를 타고 대한민국에 죽음을 몰고 온 살인무기의 실체를 밝히기 위한 그들의 사투.
 증발된 범인, 피해자는 증발되지 않았다!', '2022-04-22');
 
 
insert into tblMovieGenre(seq, mseq, gseq) values(seq.nextVal, 2, 1);


insert into tblMovieCountry(seq, mseq, cseq) values(seq.nextVal, 2, 1);


insert into tblMovievideo(seq, mseq, division, title, regdate, video) values(seq.nextVal, 2, '예고편', '티저 예고편', '2022-03-25', 'https://movie.naver.com/movie/bi/mi/mediaView.naver?code=196362&mid=52000');
insert into tblMovievideo(seq, mseq, division, title, regdate, video) values(seq.nextVal, 2, '예고편', '메인 예고편', '2022-04-11', 'https://movie.naver.com/movie/bi/mi/mediaView.naver?code=196362&mid=52119');
insert into tblMovievideo(seq, mseq, division, title, regdate, video) values(seq.nextVal, 2, '메이킹', '관객 추천 영상', '2022-04-22', 'https://movie.naver.com/movie/bi/mi/mediaView.naver?code=196362&mid=52226');
insert into tblMovievideo(seq, mseq, division, title, regdate, video) values(seq.nextVal, 2, '메이킹', '배우 응원 메시지 영상', '2022-04-27', 'https://movie.naver.com/movie/bi/mi/mediaView.naver?code=196362&mid=52252');
insert into tblMovievideo(seq, mseq, division, title, regdate, video) values(seq.nextVal, 2, '메이킹', '무대인사 현장 영상', '2022-05-02', 'https://movie.naver.com/movie/bi/mi/mediaView.naver?code=196362&mid=52279');


insert into tblPhoto(seq, mseq, category, photoURL, title) values(seq.nextVal, 2, '스틸컷', 'https://movie.naver.com/movie/bi/mi/photoView.naver?code=196362&imageNid=6760895', '영화 <공기살인> 스틸 이미지');
insert into tblPhoto(seq, mseq, category, photoURL, title) values(seq.nextVal, 2, '스틸컷', 'https://movie.naver.com/movie/bi/mi/photoView.naver?code=196362&imageNid=6760896', '영화 <공기살인> 스틸 이미지');
insert into tblPhoto(seq, mseq, category, photoURL, title) values(seq.nextVal, 2, '프로모션', 'https://movie.naver.com/movie/bi/mi/photoView.naver?code=196362&imageNid=6763733', '영화 <공기살인> VIP 시사회 현장');
insert into tblPhoto(seq, mseq, category, photoURL, title) values(seq.nextVal, 2, '프로모션', 'https://movie.naver.com/movie/bi/mi/photoView.naver?code=196362&imageNid=6763736', '영화 <공기살인> VIP 시사회 현장');
insert into tblPhoto(seq, mseq, category, photoURL, title) values(seq.nextVal, 2, '포스터', 'https://movie.naver.com/movie/bi/mi/photoView.naver?code=196362&imageNid=6762067', '메인 포스터');


insert into tblQuote(seq, mseq, ID, mpseq, line, role, likes, regdate) values(seq.nextVal, 2, 'silv****', (select m.seq from tblMoviePerson m where m.name = '김상경'), '죄 없는 사람들이 죽은 거잖아!', '정태훈', 3, '2022-04-24');
insert into tblQuote(seq, mseq, ID, mpseq, line, role, likes, regdate) values(seq.nextVal, 2, 'lhws****', (select m.seq from tblMoviePerson m where m.name = '김상경'), '우리가족살려내라', '정태훈', 2, '2022-04-27');


insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 2, (select m.seq from tblMoviePerson m where m.name = '김상경'), '주연', '정태훈');
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 2, (select m.seq from tblMoviePerson m where m.name = '이선빈'), '주연', '한영주');
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 2, (select m.seq from tblMoviePerson m where m.name = '윤경호'), '주연', '서우식');
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 2, (select m.seq from tblMoviePerson m where m.name = '서영희'), '주연', '한길주');
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 2, (select m.seq from tblMoviePerson m where m.name = '장혁진'), '조연', '조대표');
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 2, (select m.seq from tblMoviePerson m where m.name = '김정태'), '조연', '현종');
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 2, (select m.seq from tblMoviePerson m where m.name = '송영규'), '조연', '정경한');
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 2, (select m.seq from tblMoviePerson m where m.name = '이지훈'), '조연', '인호');
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 2, (select m.seq from tblMoviePerson m where m.name = '조용선'), '감독', null);

insert into tblRatings(seq, score, contents, regdate, likes, nlikes, mseq, ID) values(seq.nextVal, 10, '가습기살균제 피해자 입니다. 사람들의 기억에서 사라지는 사건이었는데 소재원 작가님은 포기하지 않으셨습니다. 하지만 영화가 개봉한다 했을때 내심 걱정도 되었습니다. 영화를 보고나니 영화를 만들어주신 분들께 감사를 드...', '2022-04-22', 248, 13, 2, 'kmyu****');
insert into tblRatings(seq, score, contents, regdate, likes, nlikes, mseq, ID) values(seq.nextVal, 10, '방금 보고나왔는데 요 최근 한국영화중 최고.. 배우들 연기는 물론이고 스토리도 최고였음 얼른 이 문제 해결되길 바람... 대한민국 국민이면 이 영화 한번 쯤 보는게 좋을 듯', '2022-04-22', 138, 25, 2, 'fowe****');
insert into tblRatings(seq, score, contents, regdate, likes, nlikes, mseq, ID) values(seq.nextVal, 10, '우연치않게 개봉일날 보게되었는데 소재 자체가 너무나도 마음이 아프네요. 어떻게 더 좋게 해줄수 없을까 생각한 부모님의 마음을 이용하여 가장 소중한것을 스스로 파괴해버린 죄책감을 가지게하는 … 정말 마음아픈 이야기였습...', '2022-04-22', 105, 21, 2, 'kk_s****');
insert into tblRatings(seq, score, contents, regdate, likes, nlikes, mseq, ID) values(seq.nextVal, 10, '소재원 작가가 이번에는 어떤 이야기로 생각을 만들지 궁금했다. 이 작가가 쓴 드라마나 영화나 소설은 생각을 하게 만든다. 이번에도 그랬다. 극장에서 나와 약속을 취소하고 집으로 갔다. 이 영화의 평가가 과연 옳은가 ...', '2022-04-22', 78, 10, 2, 'ssa4****');
insert into tblRatings(seq, score, contents, regdate, likes, nlikes, mseq, ID) values(seq.nextVal, 10, '많은 사람들이 알아야하는 영화', '2022-04-24', 76, 13, 2, 'silv****');


insert into tblMovieReivew(seq, contents, regdate, title, views, recommendedNum, mseq, ID) values(seq.nextVal, '사계절이 아름다운 대한민국.추운 겨울이 지나고 이제 완연한 봄에 들어서고 있어 봄나들이 계획 세우며 기대 중인 분들도 많으시겠지만...4월22일 대개봉을 앞두고 있는 <공기살인> 재난영화를 보고 나면이 봄이 마냥 반갑지만은 ...', '2022-04-07', '재난실화영화 <공기살인> 4월22일 대개봉이네요~', 160, 2, 2, 'lore****');
insert into tblMovieReivew(seq, contents, regdate, title, views, recommendedNum, mseq, ID) values(seq.nextVal, '안녕하세요 신비에요.오늘 소개할 영화는 " 공기살인 " 입니다.영화 제목이 다소 어감이 좀 별로긴 하지만 ㄷㄷㄷ아마 ㅇㅅ 살균제 사건이 떠오르실 겁니다.. 해당 내용을 모티브로 만든 실화바탕영화고요. 벌써 10년도 더 지났지만 아직...', '2022-04-22', '[공기살인] 가습기 살균제 피해자들은 아직도 싸우고 ...', 21, 0, 2, 'mapa****');
insert into tblMovieReivew(seq, contents, regdate, title, views, recommendedNum, mseq, ID) values(seq.nextVal, '안녕하세요! 오늘은 영화 [공기살인] 리뷰를 들고 왔습니다.오랜만에 실화를 바탕으로 만든 영화를 관람한 것 같네요 공기살인 감독 조용선 출연 김상경, 이선빈, 윤경호, 서영희 개봉 2022.04.22. 대한민국 평점...', '2022-05-01', '영화 [공기살인] 관람 리뷰 (스포X)', 2, 0, 2, 'a_ra****');
insert into tblMovieReivew(seq, contents, regdate, title, views, recommendedNum, mseq, ID) values(seq.nextVal, '[영화 공기살인] 개,돼지 몇 마리 죽었을 뿐인데 호들갑이네, 나는 영국인이냐.대한민국이 떠들썩하게 만든 가습기 살균제 사건을 영화로 만든 공기살인은 실화라는 특징으로 오락성을 배제한 진지한 영화다.어차피 알고 있는 이야기라는 ...', '2022-04-26', '[영화 공기살인] 개,돼지 몇 마리 죽었을 뿐인데...', 19, 0, 2, 'h907****');
insert into tblMovieReivew(seq, contents, regdate, title, views, recommendedNum, mseq, ID) values(seq.nextVal, '20210706코엑스 메가박스 4-L-18익무인 나눔 시사회2.5/5 가습기살균제 참사를 통해 누군가는 반드시 해야 할, 끝나지 않은 현재 진행형인 우리 모두의 이야기-네이버 영화-"알고 있었죠, 사람이 죽을 수도 있다는 거"봄이 되면 나타났다 ...', '2022-04-14', '[블라인드]<균> 이렇게나 민감한 이야기를 이렇게나...', 40, 0, 2, 'acts****');


insert into tblUser(id, gender, age) values('silv****', 'm', 20);
insert into tblUser(id, gender, age) values('lhws****', 'f', 30);
insert into tblUser(id, gender, age) values('kmyu****', 'm', 25);
insert into tblUser(id, gender, age) values('fowe****', 'f', 26);
insert into tblUser(id, gender, age) values('kk_s****', 'm', 32);
insert into tblUser(id, gender, age) values('ssa4****', 'f', 49);
insert into tblUser(id, gender, age) values('silv****', 'm', 42);
insert into tblUser(id, gender, age) values('lore****', 'f', 29);
insert into tblUser(id, gender, age) values('mapa****', 'f', 33);
insert into tblUser(id, gender, age) values('a_ra****', 'm', 39);
insert into tblUser(id, gender, age) values('h907****', 'm', 32);
insert into tblUser(id, gender, age) values('acts****', 'm', 36);
insert into tblUser(id, gender, age) values('gkgl****', 'm', 36);
insert into tblUser(id, gender, age) values('swam****', 'm', 36);
insert into tblUser(id, gender, age) values('tjal****', 'm', 36);
insert into tblUser(id, gender, age) values('soft****', 'm', 36);
insert into tblUser(id, gender, age) values('uni1****', 'm', 36);
insert into tblUser(id, gender, age) values('atti****', 'm', 36);
insert into tblUser(id, gender, age) values('eryn****', 'm', 36);
insert into tblUser(id, gender, age) values('olan****', 'm', 36);
insert into tblUser(id, gender, age) values('aidm****', 'm', 36);
insert into tblUser(id, gender, age) values('jaem****', 'm', 36);
insert into tblUser(id, gender, age) values('kyub****', 'm', 36);
insert into tblUser(id, gender, age) values('yoon****', 'm', 36);
insert into tblUser(id, gender, age) values('wkrt****', 'm', 36);
insert into tblUser(id, gender, age) values('into****', 'm', 36);
insert into tblUser(id, gender, age) values('mcla****', 'm', 36);
insert into tblUser(id, gender, age) values('getu****', 'm', 36);
insert into tblUser(id, gender, age) values('kkwo****', 'm', 36);
insert into tblUser(id, gender, age) values('wula****', 'm', 36);
insert into tblUser(id, gender, age) values('ww49****', 'm', 36);


insert into tblAwards(seq, mpseq, content) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '김상경'), '2018년 38회 황금촬영상 시상식 심사위원특별상');
insert into tblAwards(seq, mpseq, content) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '김상경'), '2007년 제 1회 대한민국 영화연기대상 최고의 눈물연기상');
insert into tblAwards(seq, mpseq, content) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '윤경호'), '제 39회 황금촬영상 시상식 최우수 남우조연상');
insert into tblAwards(seq, mpseq, content) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '서영희'), '2010년 30회 한국영화평론가협회상 여우주연상');
insert into tblAwards(seq, mpseq, content) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '서영희'), '제 8회 대한민국 영화대상 여우주연상');


insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '김상경'), 'gkgl****', '영화를 볼때 배우때문에 참 편안하다 라는 생각이 들때가 있는데 저는 김상경씨를 보면 그런거 같아요 부담이 안된단 말이죠 ^^..살인의 추억하고 몽타주를 재밌게 봤는데요 형사역을 잘하셔서 그런걸...', '2015-02-14', '보면 볼수록 편안한 배우', 987, 3);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '이선빈'), 'swam****', '^^.. 저는 당신의 팬입니다. 마담앙투완을 보고 반해서~ 팬이 되었어요. 예쁘기도 하지만.. 넘 오랜만에 여배우 느낌나는 페이스. 게다.. 연기도. 연기만 보고 나이가 좀 있는 줄 알았는데 넘 어리신....', '2016-06-25', '당신의 팬입니다!!', 272, 2);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '윤경호'), 'tjal****', '같이 출연하신 배우들 가운데 인지도가 높은편은 아니지만 기죽지않고 연기가 정말 좋았습니다. 뭐 전문가는 아니지만영화보고나서 저 배우누구일까? 잘한다! 라는 생각이 들어서영화보고난 후에 궁금...', '2018-11-05', '너무 멋지십니다.', 180, 3);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '윤경호'), 'soft****', '어제 동래 롯데시네마에서 영화 보았는데요..ㅎㅎ게이 연기 진심 좋았습니다..연기 잘히십니다..건승하세요..^^ 200자이상...ㅡㅡ뭘 더이상 어떻게 쓰라고 200자를 쓰라고 그러나..ㅜㅜ리뷰 100자이상...', '2018-11-12', '게이연기 ㅎㅎ', 159, 1);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '윤경호'), 'uni1****', '저 배우 누구지? 남편과 애기했더랬습니다. 어디서 보긴봤는데... 기억은 잘 안나지만 새롭게 알게 된 배우세요. 연기 너물 훌륭해서 칭찬글 남겨봅니다. 다른 배우들도 인지도에 맞게 잘하셨지만 이...', '2018-11-22', '연기 정말 잘하시네요.', 110, 1);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '윤경호'), 'atti****', '처음 윤경호님을 인지하게 된 건 티브이 드라마였던 걸로 기억하는데, 그 때도 놀라웠습니다만 이후로도계속... 작품에 등장하실 때마다 반갑게 보아 왔었습니다. 주변에서 영화 <완벽한 타인>을...', '2019-01-02', '인상적인 연기자 윤경호님...', 24, 0);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '서영희'), 'eryn****', '음...왜 리뷰가 없지?....^^ .......지금 생각하면 웃기지만 ......난 이 배우가 나이가 굉장히 많은 아줌마(심하면 할머니 ㅋ) 배우인줄 알았다 이유가 좀 어이없는데....마파도인가 그 할매들 많...', '2008-02-24', '꾸준히 있을 것 같은 배우', 7362, 20);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '서영희'), 'olan****', '@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 어쩜 그렇게 연기를 잘하는지~ 서영희의 대표작인 <추격자>, <김복남 살인사건의 전말> 이 두편의 영화를 다 봤지만, 처...', '2011-05-17', '서영희는 진짜~', 1661, 4);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '서영희'), 'aidm****', '이 배우에겐 모든 찬사와 칭찬을 다 한다해도 부족할듯.. 어느역할이 주어진다고 하더라도 그 안에서 존재감을 뿜어내는 미친연기력의 배우.. 김복남 살인사건의 전말을 보고 울었었다. 물론 처...', '2013-10-16', '세상에서 가장 아름다운 배우 서영희..', 1225, 8);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '서영희'), 'jaem****', '연기력은 정말 여자 연예인중에서 탑이라고 생각하는데뭐랄까 되게 비중있는 배역을 못맡는듯 오히려 그래서 연기력이 빛을 발휘하기도 하지만김복남 살인사건에서의 연기력은 정말 압권이였는데 최근...', '2016-03-10', '연기력은 최고인데 작품운이 많지 않네요. ', 86, 0);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '서영희'), 'kyub****', '저는 영화를 정말 사랑하고, 영화를 통해 많은 것을 생각하고 느끼는 사람입니다.하지만 딱히 좋아하는 배우는 없었습니다. 그 인물에 집중하고, 연기의 질을 따지는 부분은제가 평가할 부분이 아니라 ...', '2016-05-21', '서영희님 존경합니다. ', 152, 4);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '장혁진'), 'yoon****', '마동석이 살빠지면 이분처럼 될거같다.. 눈매가 좀 처진듯하면서 날카로운 눈매가 둘이 똑닮았더라..요즘 구해줘에서 활약중이신데 마동석이 살 빠지면 이분처럼 되겠구나 하는 생각이 들음..더 할말없...', '2017-09-13', '이분 눈을 자세히 봤는데', 74, 0);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '김정태'), 'wkrt****', '맨날 악역을 도맡아 하지만 미워할수 없는 배우 멋있습니다. 연기 짱 200자이상 써야만 등록할수 있다내요 111111111111111111111111111111111111111111111111111111111111111111111111 111111111111...', '2013-03-22', '11', 592, 1);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '이지훈'), 'into****', '금성무 닮은 아저씨 금성무 닮은 아저씨 금성무 닮은 아저씨 금성무 닮은 아저씨 금성무 닮은 아저씨 금성무 닮은 아저씨 금성무 닮은 아저씨 금성무 닮은 아저씨 금성무 닮은 아저씨 금성무 닮은 아저...', '2013-11-02', '금성무 닮은 아저씨', 134, 0);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '이지훈'), 'mcla****', '자 누구예요? 어디예요? 어디예요? 저기예요? 거기예요? 안경 벗어봐요. 괜찮아요? 왜그랬어요? 괜찮아요. 잘 대처했어요. 잠시만.요 일상생활엔 지장 없으실거예요. 안과예요. 어이구 마준규씨네 팬입...', '2017-11-27', '제가 의삽니다.', 270, 1);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '조용선'), 'getu****', '노브레싱이여 시작은 좋은데말야 ㅋ예고편에 완전 다보여주잖아 그럼뭐야 작품안에도 보여줄게 별로없으니 그런거자나 너무 허술해 첫작품 ㅡㅡ 너무뻔한전개자나 ;; 좀 다른 영화처럼 세심하게 햇어...', '2013-10-16', '첫작품 별로네', 365, 3);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '조용선'), 'kkwo****', '영화에 깊이가 하나도 없네요. 작품성이 없으면 재미라도 있어야 되지 않겠습니까?노브레싱 보면서 이거 만든 감독님은 대체 누구실까, 하고 생각했는데 다행이 첫 작품 하신 분이네요.두 번째 작품 ...', '2013-11-04', '첫작품이었나여? 책좀읽으셔야 할듯', 270, 2);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '조용선'), 'wula****', '올해만에 곱씹어본영화중 스토커이고 노브레싱이였습니다,간만에 나랑드사이다같은 청량함? 3번만에 코끝이 찡해서 본 영화,슬램덩크같은 순수함과 감동이있었던,심플하지만 청출어람에 반짝반짝 빛났...', '2013-11-05', '오늘일부로3번', 95, 1);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '조용선'), 'ww49****', '영화 개봉하고 얼마 안되서 본 사람입니다. 영화를 자주 안봐서 오랜만에 엄마와 함께 봤는데 너무나 맘에 듭니다. 첫작품인지는 모르겠지만 저는 너무 재밌습니다. 서인국이 개그를 보여줘 너무 좋았...', '2013-12-02', 'very good', 40, 1);


insert into tblFilmcompanyMovie(seq, fseq, mseq, role) values(seq.nextVal, 2, 2, '제작');
insert into tblFilmcompanyMovie(seq, fseq, mseq, role) values(seq.nextVal, 3, 2, '배급');



-- 3 닥터스트레인지 --개봉 전, 명대사 및 평점 없음

insert into tblMovie(seq, rseq, title, engtitle, audience, runningtime, likes, summary, releasedate)
values(3, 2, '닥터 스트레인지: 대혼돈의 멀티버스', 'Doctor Strange in the Multiverse of Madness, 2022', null, 126, 9778, '지금껏 본 적 없는 마블의 극한 상상력!
광기의 멀티버스가 깨어난다
끝없이 균열되는 차원과 뒤엉킨 시공간의 멀티버스가 열리며
 오랜 동료들, 그리고 차원을 넘어 들어온 새로운 존재들을 맞닥뜨리게 된 ‘닥터 스트레인지’.
 대혼돈 속, 그는 예상치 못한 극한의 적과 맞서 싸워야만 하는데….', '2022-05-04');


insert into tblMovieGenre(seq, mseq, gseq) values(seq.nextVal, 3, 19);
insert into tblMovieGenre(seq, mseq, gseq) values(seq.nextVal, 3, 2);
insert into tblMovieGenre(seq, mseq, gseq) values(seq.nextVal, 3, 6);


insert into tblMovieCountry(seq, mseq, cseq) values(seq.nextVal, 3, 2);


insert into tblMovievideo(seq, mseq, division, title, regdate, video) values(seq.nextVal, 3, '예고편', '스페셜 티저', '2021-12-28', 'https://movie.naver.com/movie/bi/mi/mediaView.naver?code=182016&mid=51423');
insert into tblMovievideo(seq, mseq, division, title, regdate, video) values(seq.nextVal, 3, '예고편', '티저 예고편', '2022-02-14', 'https://movie.naver.com/movie/bi/mi/mediaView.naver?code=182016&mid=51740');
insert into tblMovievideo(seq, mseq, division, title, regdate, video) values(seq.nextVal, 3, '예고편', '60초 예고편', '2022-04-04', 'https://movie.naver.com/movie/bi/mi/mediaView.naver?code=182016&mid=52053');
insert into tblMovievideo(seq, mseq, division, title, regdate, video) values(seq.nextVal, 3, '예고편', '광기의 멀티버스 30초 예고편', '2022-04-13', 'https://movie.naver.com/movie/bi/mi/mediaView.naver?code=182016&mid=52135');
insert into tblMovievideo(seq, mseq, division, title, regdate, video) values(seq.nextVal, 3, '메이킹', '"멀티버스의 문을 열다" 제작기 영상', '2022-04-19', 'https://movie.naver.com/movie/bi/mi/mediaView.naver?code=182016&mid=52194');


insert into tblPhoto(seq, mseq, category, photoURL, title) values(seq.nextVal, 3, '스틸컷', 'https://movie.naver.com/movie/bi/mi/photoView.naver?code=182016&imageNid=6762383', '영화 <닥터 스트레인지: 대혼돈의 멀티버스> 스틸 이미지');
insert into tblPhoto(seq, mseq, category, photoURL, title) values(seq.nextVal, 3, '스틸컷', 'https://movie.naver.com/movie/bi/mi/photoView.naver?code=182016&imageNid=6762376', '영화 <닥터 스트레인지: 대혼돈의 멀티버스> 스틸 이미지');
insert into tblPhoto(seq, mseq, category, photoURL, title) values(seq.nextVal, 3, '스틸컷', 'https://movie.naver.com/movie/bi/mi/photoView.naver?code=182016&imageNid=6762377', '영화 <닥터 스트레인지: 대혼돈의 멀티버스> 스틸 이미지');
insert into tblPhoto(seq, mseq, category, photoURL, title) values(seq.nextVal, 3, '포스터', 'https://movie.naver.com/movie/bi/mi/photoView.naver?code=182016&imageNid=6763093', '메인 포스터');
insert into tblPhoto(seq, mseq, category, photoURL, title) values(seq.nextVal, 3, '포스터', 'https://movie.naver.com/movie/bi/mi/photoView.naver?code=182016&imageNid=6759149', '티저 포스터');


insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 3, (select m.seq from tblMoviePerson m where m.name = '베네딕트 컴버배치'), '주연', '닥터 스트레인지');
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 3, (select m.seq from tblMoviePerson m where m.name = '엘리자베스 올슨'), '주연', '완다 막시모프');
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 3, (select m.seq from tblMoviePerson m where m.name = '베네딕트 웡'), '조연', '웡');
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 3, (select m.seq from tblMoviePerson m where m.name = '레이첼 맥아담스'), '조연', null);
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 3, (select m.seq from tblMoviePerson m where m.name = '치웨텔 에지오포'), '조연', null);
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 3, (select m.seq from tblMoviePerson m where m.name = '소치틀 고메즈'), '조연', null);
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 3, (select m.seq from tblMoviePerson m where m.name = '샘 레이미'), '감독', null);


insert into tblMovieReivew(seq, contents, regdate, title, views, recommendedNum, mseq, ID) values(seq.nextVal, '2021년이면 내가 18살이구만.. 고2.. 과연그때까지 살아있을까... 제 3세계대전이 일어나서 세계가 멸망할수도 있고 문제인이 나라를 이상하게 만들수도있고... 지금은 그래픽카드가 RTX2080ti 까지나왔다 2021년 에는 RTX9080이 나올수도...', '2019-02-16', '저는 이글을 2년뒤인 2021년에 볼 예정입니다', 4887, 11, 3, 'vita****');
insert into tblMovieReivew(seq, contents, regdate, title, views, recommendedNum, mseq, ID) values(seq.nextVal, '닥터 스트레인지는 타임스톤에 마법을 걸어 두었습니다.타노스에게 넘겨주기 직전 타임스톤은 별처럼 위장을 하고 있는 상태였죠.닥터는 스톤이 파괴될걸 미리 알고 있었습니다.그래서 스톤이 파괴되려할때 다시 그자리로 돌아와 별이 되...', '2019-05-03', '미래에서 왔습니다', 6924, 4, 3, 'idso****');
insert into tblMovieReivew(seq, contents, regdate, title, views, recommendedNum, mseq, ID) values(seq.nextVal, '이전 닥터 스트레인지 1편을 보신 분들은 아실 겁니다. 마법사들 중 유일하게 탈모였던 에인션트 원은 탈모라는 무시무시한 중죄를 저지름으로써 소서러 슈프림으로 거듭했죠.자신의 스승이 탈모라는 중죄를 저지른 것을 본 모르도는 충격...', '2019-05-16', '탈모 스트레인지 2', 637, 3, 3, 's220****');
insert into tblMovieReivew(seq, contents, regdate, title, views, recommendedNum, mseq, ID) values(seq.nextVal, '마블 시네마톡 네이버 카페본 카페는 MCU의 세계관을 다룬, 마블 스튜디오가 직접 제작한 영화들에 대한 팬카페입니다.카페 주소: http://cafe.naver.com/stanlee닥터 스트레인지 2편의 개봉을 기다리며 함께 이야기 나눌 마블 팬분들을 ...', '2019-04-25', '[초대장] 마블 영화 네이버 팬카페', 470, 1, 3, 'mc_g****');
insert into tblMovieReivew(seq, contents, regdate, title, views, recommendedNum, mseq, ID) values(seq.nextVal, '닥터스트레인지1 재밋었는데 2도 엄청 기대중 ㅠㅠㅠㅠㅠㅠㅠㅠㅠ ♥♥♥배네딕트 컴버배치 배우 너무 좋아요 진짜 너무 좋아요닥스2에서 엔드게임 끝나고 난 후의 상황이 나올 것 같아요 (그렇죠!~>??)아이언맨 얘기도 좀 나올 것 같...', '2019-05-26', '개봉 언제죠... 개봉 하면 당장 달려갑니다...', 116, 1, 3, 'hmin****');


insert into tblUser(id, gender, age) values('vita****', 'm', 19);
insert into tblUser(id, gender, age) values('idso****', 'f', 29);
insert into tblUser(id, gender, age) values('s220****', 'm', 31);
insert into tblUser(id, gender, age) values('mc_g****', 'm', 43);
insert into tblUser(id, gender, age) values('hmin****', 'f', 26);
insert into tblUser(id, gender, age) values('osy7****', 'f', 32);
insert into tblUser(id, gender, age) values('rlae****', 'm', 25);
insert into tblUser(id, gender, age) values('jw30****', 'f', 36);
insert into tblUser(id, gender, age) values('may9****', 'm', 54);
insert into tblUser(id, gender, age) values('hspp****', 'f', 42);
insert into tblUser(id, gender, age) values('xc48****', 'f', 35);
insert into tblUser(id, gender, age) values('sbw0****', 'm', 23);
insert into tblUser(id, gender, age) values('ews1****', 'f', 20);
insert into tblUser(id, gender, age) values('red1****', 'm', 21);
insert into tblUser(id, gender, age) values('ssww****', 'f', 22);
insert into tblUser(id, gender, age) values('iccu****', 'f', 28);
insert into tblUser(id, gender, age) values('njoy****', 'm', 32);
insert into tblUser(id, gender, age) values('rhcn****', 'm', 37);
insert into tblUser(id, gender, age) values('yel4****', 'm', 35);
insert into tblUser(id, gender, age) values('dkdl****', 'f', 25);


insert into tblAwards(seq, mpseq, content) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '베네딕트 컴버배치'), '2022년 42회 런던 비평가 협회상 남우주연상');
insert into tblAwards(seq, mpseq, content) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '베네딕트 컴버배치'), '2022년 시네마 뱅가드상');
insert into tblAwards(seq, mpseq, content) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '엘리자베스 올슨'), '2021년 29회 MTV 영화 & TV 어워즈 TV - 최고의 배우상');
insert into tblAwards(seq, mpseq, content) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '레이첼 맥아담스'), '2016년 31회 산타바바라 국제영화제 아메리칸 리비에라상');
insert into tblAwards(seq, mpseq, content) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '치웨텔 에지오포'), '2019년 35회 선댄스영화제 알프레드 P. 슬로안 상');
insert into tblAwards(seq, mpseq, content) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '샘 레이미'), '2010년 36회 새턴 어워즈 최우수 호러상');


insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '베네딕트 컴버배치'), 'osy7****', '닥터스트레인지 역을 맡으신 베네딕트 컴버배치시죠 참 연기도 잘하고 좋았습니다! 셜록은 아직 못 봤는데 한번 봐야겠어요~ 앞으로도 훌륭한 연기 기대해봅니다!닥터스트레인지 역을 맡으신 베네딕트 ...', '2020-08-12', '놀라운 배우', 13, 0);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '베네딕트 컴버배치'), 'rlae****', '엥 왜 이렇게 리뷰가 없죠??? 정말 최고의 배우라고 해도 과찬이 아닐 정도로 연기가 너무나 뛰어난 것.... 아 저런게 명품연기이구나 싶었습니다ㅠㅠ 셜록 드라마를 처음 보고 "엥 배우가 얼굴이 좀.....', '2020-05-23', '최애 배우 베네딕트..ㅎ', 16, 0);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '베네딕트 컴버배치'), 'jw30****', '베네딕트 처음봤을때가 셜록 유령신부에서였는데요, 그땐 뭔 저렇게 생긴사람이 다있담하고 봤는데 세상에 끝날때되니까 너무 존멋인거임! 그래서 그거 본날 셜록 시즌1,2,3 정복하고 베네딕트님한테 ...', '2017-01-10', '베네딕트 큐컴버배치', 94, 0);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '베네딕트 컴버배치'), 'may9****', '다른 리뷰들을 보면 알 수 있듯이 베네딕트 컴버배치는 미친 매력의 소유자 잘생김을 연기하는 배우이다 셜록 뿐만아니라 이미테이션게임 스타워즈등 다양한 작품에 등장하는 바람직한 배우이다또 처...', '2016-01-04', '잘생김을 연기하다', 139, 0);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '베네딕트 컴버배치'), 'hspp****', '연기도잘하고 얼굴도 인상적이고항상 연기하는 캐릭터도 특이해서기억이 많이 나는 배우임니돠.거의 대부분의 사람이 영국드라마 셜록으로 이배우를 접했을텐데요저도 마찬가집니다.외국배우이지만 정...', '2015-01-23', '한국에서도 인기많은 베네딕트 컴버배치', 150, 0);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '엘리자베스 올슨'), 'xc48****', '개인적으로 mcu에서 실수중하나가 스칼렛위치를 넣은것이 아닐까싶다.연기력또한 아쉽고.. 물론 능력? 이 워낙 cg투성이니깐 배우가 연기하기 힘들겠다만 나올떄마다 뭔가 항상 아쉬움. 1234567890-...', '2017-05-07', '정말 좋은배우인데.', 266, 0);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '엘리자베스 올슨'), 'sbw0****', '미국에 유명한 올슨자매중 막내인 엘리자베스 올슨 .. 그녀를 처음 "어벤져스:에이지 오브 울트론"에서 보았을때 그녀의 모습이 아직도 생생하게 느껴졌다. 그녀가 출연한 영화 대표작은 그녀의 첫영화...', '2016-05-14', '그녀의 모습을 처음 관객들에게 보여준 영화...', 1205, 0);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '엘리자베스 올슨'), 'ews1****', '4월 23일 드디어 어벤져스:에이지 오브 울트론(The Avengers: Age of Ultron, 2015)이 개봉을 하였습니다.이전에 나오던아이언맨(로버트 다우니 주니어) 캡틴 아메리카(크리스 에반스) 호크 아이 (제...', '2015-04-27', '어벤져스 스칼렛 위치의 올리자베스 올슨 넌 누구냐!', 3211, 1);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '엘리자베스 올슨'), 'red1****', '커다란 눈. 해맑은 미소 속에 자리잡은 깊이를 알수 없는 눈동자. 쾌활하기만 할 것 같은 천진함 뒤로 느껴지는 어딘지 모를 슬픔. 우리나라에는 아직까지 많이 알려지지 않은 배우 엘리자베스 올슨...', '2014-05-12', '엘리자베스 올슨, 그녀의 눈부신 날들은 이제부터 시작', 7202, 2);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '레이첼 맥아담스'), 'ssww****', '예뻐예뻐예뻐예뻐예뻐예뻐예뻐예뻐예뻐예뻐예뻐예뻐예뻐예뻐예뻐예뻐예뻐예뻐예뻐예뻐예뻐예뻐예뻐예뻐예뻐예뻐예뻐예뻐예뻐예뻐예뻐예뻐예뻐예뻐예뻐예뻐예뻐예뻐예뻐예뻐예뻐예뻐예뻐예뻐예뻐예뻐예...', '2017-02-12', '다 필요없고 예뻐', 158, 2);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '레이첼 맥아담스'), 'iccu****', '친구 권유로 노트북을 우연히 보게 됐는데영화 스토리도 좋지만 여배우가 얼굴도 예쁘고 연기도 잘했다고 기억하고 있었는데그게 이 배우였구나...노트북 감명깊게 본 영화라 기억에 남네요승승장구...', '2016-11-11', '노트북에서 인상깊었던 여배우', 546, 2);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '레이첼 맥아담스'), 'njoy****', '다수가 묵인하는 진실을 밝히는 것이 언론의 의무이고, 그 의무를 찾는 업이 언론인데,우리나라의 언론과 미국의 언론의 차이는 무엇인가?라고 생각해봅니다.국익이 우선되며 개인의 고통은 무시되는 ...', '2016-03-01', '역시 영화는 이렇게 만드는 것', 169, 1);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '레이첼 맥아담스'), 'rhcn****', '그렇게 눈에 들어오는 외모를 가진 여배우는 아니지만어느날 "으?"그러더니 어바웃에선 "으 아"그녀의 따스운 미소는 아름답고영화인지를 잊게 하는 영화속에 져며드는 연기가좋은 사람으로 인식되었...', '2015-12-15', '처음엔....', 589, 1);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '레이첼 맥아담스'), 'yel4****', '노트북 말고도 엄청난 명작들을 찍었는데 수상이 고작 코미디?키스상? 노트북이 너무 심오해서 그런가 레이첼 정말 좋다ㅠㅠㅠㅠㅠ그냥 좋다 1년에 영화 2~3편 찍은 것도 많이 찍었다고 생각했었는데 ...', '2014-03-18', '이럴수가', 2430, 2);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '치웨텔 에지오포'), 'dkdl****', '오늘 노예12년을 보고 온 한 사람으로서 맹세하건데 저 사람은 정말 대단한 배우다. 노예12년의 노예 "솔로몬" 역을 그렇게 잘 소화해낼 배우가 치웨텔 에지오포말고 누가 있을까. 정말 영화를 보...', '2014-03-02', '연기가 진실한 배우', 779, 2);


insert into tblFilmcompanyMovie(seq, fseq, mseq, role) values(seq.nextVal, 4, 3, '수입');
insert into tblFilmcompanyMovie(seq, fseq, mseq, role) values(seq.nextVal, 4, 3, '배급');



-- 4 니 부모 얼굴이 보고 싶다

insert into tblMovie(seq, rseq, title, engtitle, audience, runningtime, likes, summary, releasedate)
values(4, 3, '니 부모 얼굴이 보고 싶다', ' ', 249690, 111, 1246, '“누군가 잘못했겠지
하지만 내 아들은 절대 아니야”
명문 한음 국제중학교 학생 ‘김건우’가
같은 반 친구 4명의 이름이 적힌 편지를 남긴 채,
의식불명 상태로 호숫가에서 발견된다.
 
병원 이사장의 아들 ‘도윤재’
전직 경찰청장의 손자 ‘박규범’
한음 국제중학교 교사의 아들 ‘정이든’
그리고, 변호사 ‘강호창’(설경구)의 아들 ‘강한결’.
 
가해자로 지목된 아이들의 부모들은
자신의 권력과 재력을 이용해 사건을 은폐하려고 한다.
하지만, 담임 교사 ‘송정욱’(천우희)의 양심 선언으로
건우 엄마(문소리) 또한 아들의 죽음에 관한 진실을 알게 된다.
 
세상의 이목이 한음 국제중학교로 향하고,
자신의 아이들을 지키기 위한 가해자 부모들의 추악한 민낯이 드러나는데…
 
자식이 괴물이 되면, 부모는 악마가 된다', '2022-04-27');


insert into tblMovieGenre(seq, mseq, gseq) values(seq.nextVal, 4, 1);


insert into tblMovieCountry(seq, mseq, cseq) values(seq.nextVal, 4, 1);


insert into tblMovievideo(seq, mseq, division, title, regdate, video) values(seq.nextVal, 4, '예고편', '캐릭터 영상', '2022-04-25', 'https://movie.naver.com/movie/bi/mi/mediaView.naver?code=159812&mid=52229');
insert into tblMovievideo(seq, mseq, division, title, regdate, video) values(seq.nextVal, 4, '예고편', '30초 예고편', '2022-04-13', 'https://movie.naver.com/movie/bi/mi/mediaView.naver?code=159812&mid=52138');
insert into tblMovievideo(seq, mseq, division, title, regdate, video) values(seq.nextVal, 4, '예고편', '메인 예고편', '2022-04-07', 'https://movie.naver.com/movie/bi/mi/mediaView.naver?code=159812&mid=52086');
insert into tblMovievideo(seq, mseq, division, title, regdate, video) values(seq.nextVal, 4, '메이킹', '제작기 영상', '2022-04-19', 'https://movie.naver.com/movie/bi/mi/mediaView.naver?code=159812&mid=52158');


insert into tblPhoto(seq, mseq, category, photoURL, title) values(seq.nextVal, 4, '스틸컷', 'https://movie.naver.com/movie/bi/mi/photoView.naver?code=159812&imageNid=6762835', '영화 <니 부모 얼굴이 보고 싶다> 스틸 이미지');
insert into tblPhoto(seq, mseq, category, photoURL, title) values(seq.nextVal, 4, '스틸컷', 'https://movie.naver.com/movie/bi/mi/photoView.naver?code=159812&imageNid=6762836', '영화 <니 부모 얼굴이 보고 싶다> 스틸 이미지');
insert into tblPhoto(seq, mseq, category, photoURL, title) values(seq.nextVal, 4, '프로모션', 'https://movie.naver.com/movie/bi/mi/photoView.naver?code=159812&imageNid=6763835', '영화 <니 부모 얼굴이 보고 싶다> 언론시사회 현장');
insert into tblPhoto(seq, mseq, category, photoURL, title) values(seq.nextVal, 4, '프로모션', 'https://movie.naver.com/movie/bi/mi/photoView.naver?code=159812&imageNid=6763833', '영화 <니 부모 얼굴이 보고 싶다> 언론시사회 현장');
insert into tblPhoto(seq, mseq, category, photoURL, title) values(seq.nextVal, 4, '포스터', 'https://movie.naver.com/movie/bi/mi/photoView.naver?code=159812&imageNid=6763368', '메인 포스터');


insert into tblQuote(seq, mseq, ID, mpseq, line, role, likes, regdate) values(seq.nextVal, 4, 'qmdl****', (select m.seq from tblMoviePerson m where m.name = '천우희'), '용서받을 기회는 아버님이 없애신 거예요.', '송정욱', 17, '2022-04-27');
insert into tblQuote(seq, mseq, ID, mpseq, line, role, likes, regdate) values(seq.nextVal, 4, 'miss****', (select m.seq from tblMoviePerson m where m.name = '천우희'), '당신들이 애들보다 더해요. 자식 앞에서 부끄러운 줄 아세요.', '송정욱', 11, '2022-04-28');
insert into tblQuote(seq, mseq, ID, mpseq, line, role, likes, regdate) values(seq.nextVal, 4, 'hard****', (select m.seq from tblMoviePerson m where m.name = '오달수'), '내가 말했잖아... 세상 모든 아빠들은 똑같다고.', '도지열', 9, '2022-04-28');


insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 4, (select m.seq from tblMoviePerson m where m.name = '설경구'), '주연', '강호창');
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 4, (select m.seq from tblMoviePerson m where m.name = '천우희'), '조연', '송정욱');
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 4, (select m.seq from tblMoviePerson m where m.name = '문소리'), '조연', '건우 엄마');
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 4, (select m.seq from tblMoviePerson m where m.name = '오달수'), '조연', '도지열');
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 4, (select m.seq from tblMoviePerson m where m.name = '고창석'), '조연', '정선생');
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 4, (select m.seq from tblMoviePerson m where m.name = '강신일'), '조연', '교장');
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 4, (select m.seq from tblMoviePerson m where m.name = '김홍파'), '조연', '박무택');
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 4, (select m.seq from tblMoviePerson m where m.name = '성유빈'), '조연', '강한결');
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 4, (select m.seq from tblMoviePerson m where m.name = '김지훈'), '감독', null);


insert into tblRatings(seq, score, contents, regdate, likes, nlikes, mseq, ID) values(seq.nextVal, 10, '하… 기가 막힌다 진짜… 무서운 점은… 내가 저 상황이라고 해도 다를 게 있을까…? 많은 생각이 들게 하는 영화. 사이다 결말은 아니었지만… 여운이 길게 남았다. 잘 만든 영화임은 확실하다. 연기파 배우들만 모여서 ...', '2022-04-27', 132, 15, 4, '123j****');
insert into tblRatings(seq, score, contents, regdate, likes, nlikes, mseq, ID) values(seq.nextVal, 10, '대한민국 연기 잘하는 배우 그냥 싹끌어모아서 그런지 연기 진짜 개소름.. 꼭 봐야할 ㄹㅈㄷ', '2022-04-27', 100, 13, 4, 'pino****');
insert into tblRatings(seq, score, contents, regdate, likes, nlikes, mseq, ID) values(seq.nextVal, 9, '밴틀리 vs 제네시스 승자는?', '2022-04-27', 89, 18, 4, 'ljsk****');
insert into tblRatings(seq, score, contents, regdate, likes, nlikes, mseq, ID) values(seq.nextVal, 10, '나는 다를 수 있을까...', '2022-04-27', 73, 3, 4, 'adon****');
insert into tblRatings(seq, score, contents, regdate, likes, nlikes, mseq, ID) values(seq.nextVal, 10, '현실은 몇배는 더 잔인하다.', '2022-04-27', 72, 3, 4, 'miss****');


insert into tblMovieReivew(seq, contents, regdate, title, views, recommendedNum, mseq, ID) values(seq.nextVal, '지천명 아이돌 설저씨가 드디어 급기야 지난 토요일에 열린 2017 청룡영화제에서 인기스타상을 손에 쥐었다. 영화 "우상" 촬영하면서 점점 더 까무잡잡하게 태닝을 하고 있는지 이젠 아예 카레빵맨 컬러가 되어서 청룡영화제 포토...', '2017-11-27', '[팬질] 설경구의 인기비결은 외모 맞다!!_청룡영화상', 314, 6, 4, 'lame****');
insert into tblMovieReivew(seq, contents, regdate, title, views, recommendedNum, mseq, ID) values(seq.nextVal, '전에 학교에서 아주 재미있게 본 책인데 영화로 된다니 기쁠 따름 이네요. 그런데 오달수 나와서.. 보기가 좀 구렇네요.. 안그래도 여학생이라서..보기가 좀 그래요.. 어떻게 좀 안될까요..ㅇㅅㅇ..흙흙 아 200자 내외 짜증난다고요오오...', '2018-03-24', '오달수 나와서..', 637, 4, 4, 'jimi****');
insert into tblMovieReivew(seq, contents, regdate, title, views, recommendedNum, mseq, ID) values(seq.nextVal, '<니 부모 얼굴이 보고 싶다>설경구-오달수-천우희-고창석-문소리-강신일-김홍파5월 29일(월) 크랭크인, 최강의 명품 배우 라인업! 영화 <니 부모 얼굴이 보고 싶다>가 설경구, 오달수, 천우희, 고창석, 문소리, ...', '2017-06-16', '일본 동명 희곡 원작 <니 부모 얼굴이 보고 싶다> 크랭크인', 1088, 2, 4, 'kkci****');
insert into tblMovieReivew(seq, contents, regdate, title, views, recommendedNum, mseq, ID) values(seq.nextVal, '니 부모 얼굴이 보고 싶다 감독 김지훈 출연 설경구 개봉 2022.04.27. 대한민국 평점 리뷰보기 으아 정말 보는내내 제 뜨건 정의에 주먹이 참 많이도 참았습돠 시지비연수역점 늦게 입...', '2022-04-27', '니 부모 얼굴이 보고 싶다', 11, 0, 4, 'tcu2****');
insert into tblMovieReivew(seq, contents, regdate, title, views, recommendedNum, mseq, ID) values(seq.nextVal, '뉴스에서, 혹은 학창시절에 흔히 접할 수 있었던 학교폭력에 대한 이야기를 영화 <니 부모 얼굴이 보고 싶다>로 제작했다는 영화 정보는 그 주제의 심각성 때문에 사실 볼까 말까 고민을 하게 만들었다. 동영상이 첨부되었습니다...', '2022-04-30', '[영화 니 부모 얼굴이 보고 싶다 정보&노스포 리뷰]', 7, 0, 4, 'sole****');


insert into tblUser(id, gender, age) values('qmdl****', 'f', 23);
insert into tblUser(id, gender, age) values('miss****', 'm', 35);
insert into tblUser(id, gender, age) values('hard****', 'f', 42);
insert into tblUser(id, gender, age) values('123j****', 'm', 32);
insert into tblUser(id, gender, age) values('pino****', 'f', 38);
insert into tblUser(id, gender, age) values('ljsk****', 'm', 72);
insert into tblUser(id, gender, age) values('adon****', 'f', 62);
insert into tblUser(id, gender, age) values('lame****', 'f', 35);
insert into tblUser(id, gender, age) values('jimi****', 'm', 62);
insert into tblUser(id, gender, age) values('kkci****', 'm', 17);
insert into tblUser(id, gender, age) values('tcu2****', 'f', 17);
insert into tblUser(id, gender, age) values('sole****', 'f', 33);
insert into tblUser(id, gender, age) values('love****', 'f', 23);
insert into tblUser(id, gender, age) values('spro****', 'm', 42);
insert into tblUser(id, gender, age) values('tita****', 'f', 53);
insert into tblUser(id, gender, age) values('chul****', 'f', 55);
insert into tblUser(id, gender, age) values('ladi****', 'm', 53);
insert into tblUser(id, gender, age) values('ssan****', 'm', 66);
insert into tblUser(id, gender, age) values('bus0****', 'm', 23);
insert into tblUser(id, gender, age) values('mach****', 'f', 18);
insert into tblUser(id, gender, age) values('phw6****', 'm', 25);
insert into tblUser(id, gender, age) values('hanl****', 'f', 20);
insert into tblUser(id, gender, age) values('aej0****', 'm', 23);
insert into tblUser(id, gender, age) values('dohc****', 'f', 32);
insert into tblUser(id, gender, age) values('kid2****', 'm', 37);
insert into tblUser(id, gender, age) values('nesi****', 'm', 35);
insert into tblUser(id, gender, age) values('hhhs****', 'f', 22);
insert into tblUser(id, gender, age) values('pmar****', 'm', 20);
insert into tblUser(id, gender, age) values('oasi****', 'f', 16);
insert into tblUser(id, gender, age) values('75kw****', 'f', 23);
insert into tblUser(id, gender, age) values('7jrw****', 'f', 20);
insert into tblUser(id, gender, age) values('soom****', 'm', 30);
insert into tblUser(id, gender, age) values('shgu****', 'm', 33);
insert into tblUser(id, gender, age) values('ckdg****', 'f', 34);
insert into tblUser(id, gender, age) values('jomo****', 'm', 43);
insert into tblUser(id, gender, age) values('slim****', 'm', 48);
insert into tblUser(id, gender, age) values('sayb****', 'f', 50);


insert into tblAwards(seq, mpseq, content) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '설경구'), '2021년 41회 한국영화평론가협회상 남우주연상');
insert into tblAwards(seq, mpseq, content) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '설경구'), '2021년 제 42회 청룡영화상 남우주연상');
insert into tblAwards(seq, mpseq, content) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '천우희'), '2021년 41회 황금촬영상 시상식 최우수 여우주연상');
insert into tblAwards(seq, mpseq, content) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '문소리'), '2021년 41회 한국영화평론가협회상 여우주연상');
insert into tblAwards(seq, mpseq, content) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '문소리'), '2021년 제 42회 청룡영화상 여우주연상');
insert into tblAwards(seq, mpseq, content) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '오달수'), '2016년 11회 맥스무비 최고의 영화상 최고의 남자조연 배우상');
insert into tblAwards(seq, mpseq, content) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '고창석'), '2011년 20회 부일영화상 남우 조연상');
insert into tblAwards(seq, mpseq, content) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '강신일'), '2021년 9회 서울구로국제어린이영화제 구키프상 - 엑터상');
insert into tblAwards(seq, mpseq, content) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '김홍파'), '2021년 40회 황금촬영상 시상식 촬영감독이 선정한 인기상');
insert into tblAwards(seq, mpseq, content) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '성유빈'), '2019년 28회 부일영화상 신인 남자 연기상');
insert into tblAwards(seq, mpseq, content) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '성유빈'), '2019년 제 6회 들꽃영화상 남우주연상');
insert into tblAwards(seq, mpseq, content) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '김지훈'), '2013년 22회 중국금계백화영화제 최우수 외국어영화 감독상');


insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '설경구'), 'love****', ' ', '2022-02-04', '극장판 재창조자들의 제왕', 5, 0);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '설경구'), 'spro****', '최근 몸무게를 급격히 줄인 배우들이 꽤 있다. 그것도 드라마가 아닌 영화를 위해서!ㅎㅎ 20kg을 감량하여 화제가 된 그! 김명민!!! 너무 과도하게 빼서 그런걸까? 탈진과 저혈당, 위장병을 동원...', '2009-10-27', '고무줄 체중을 보여준 연기파 배우들은 뉴구~?', 1939, 1);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '천우희'), 'tita****', '최근에 본 많은 영화들 중, "인생 영화 중 하나"로 꼽을 만큼 좋아하는 "라라랜드"그리고 필자 만큼이나, "라라랜드"를 좋아하는 한국의 배우가 있었으니..."한국판 가상 라라랜드 캐스팅"에서 여주...', '2017-04-06', '"어느날" 천우희란 배우가 있음에, 감사하다', 78, 0);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '천우희'), 'chul****', '영화 써니를 올만에 봤어요 악역으로 나온 본드녀 연기가 정말 최고더라구요, 진짜 본드흡입하는 불량소녀같았어요..ㅎㅎㅎ찾아보니 천우희 님이군요^^: 악역으로 나온지라 별로 주목받진 못했던걸로 ...', '2017-03-08', '써니 본드녀 연기는 최고였습니다', 60, 0);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '천우희'), 'ladi****', '배우가 배우 같아야 배우제~ 천우희님 지금처럼 좋은 연기 쭉 이어가 주시기 바랍니다. 항상응원해요! ㅎ배우가 배우 같아야 배우제~ 천우희님 지금처럼 좋은 연기 쭉 이어가 주시기 바랍니다. 항상응...', '2016-07-06', '간만에 보는 진짜배기 영화배우 천우희님', 39, 0);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '천우희'), 'ssan****', '내가본 천우희라는 배우는 의외로 많은 영화에 나왔지만. 써니에서 본드연기로 극중에서 엄청난 몰입감을 준 배우이다. 온몸으로 떨리는 몸짓 눈 슬프지만 웃고있는 친구들과 우정의 사랑을 받고싶어 ...', '2016-05-10', '천우희...숨겨져 있는 보석', 122, 0);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '천우희'), 'bus0****', '너무 좋습니다. 독립영화를 보곤 하는데 인상 깊은 영화가 "파수꾼" 과 "한공주" 였습니다. 파수꾼에서 처음 본 이제훈이란 배우에게 연신 감탄하며 깊게 고민했고한공주에서 본 천우희라는 배우를 ...', '2015-07-11', '우리나라에 연기로 승부 거는 사람이 있다는게', 174, 0);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '오달수'), 'mach****', '요새는 정말 많은 사람들이 옛날에 자기 아랫도리를 주체 못했던 일로 고생을 심하게 하고 있다. 근데 이거 인과응보다. 아무리 옛날에 한 일이라도, 그게 10년이 됐든, 20년이 됐든 결국 원인은 결과...', '2018-03-13', '오달수가 주는 교훈', 556, 5);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '오달수'), 'phw6****', '정말 믿었었던 배우이기에밀양연극촌 연극도 찾아보기까지한 배우이기에 믿었지만 결국 성추행범끝까지 안 들어날줄 알았었나 보죠그래서 이렇게 사과가 늦었나요어떻게 해서든 한순간의 판단으로 이렇...', '2018-03-02', '정말 믿었었던 배우', 2469, 15);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '오달수'), 'hanl****', '요즘 뜨는 영화엔 주인공도 중요하지만, 조연 배우의 역할도 중요한듯!! 빛나는 외모보다, 개성있는 연기와 독특한 캐릭터로 극에 활력을 불어 넣어주는 씬 스틸러(Scene Stealer)!! +) 씬 스틸러란?...', '2010-08-31', '뜨는 영화에는 다 있다?! 명품 씬스틸러들 모두 모인...', 2842, 2);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '오달수'), 'aej0****', '당신은 이들을 그 어떤 드라마, 영화등에서 주연으로 만난 적이 없다. 하지만, 그들의 목소리, 얼굴, 기가막힌 연기력을 단, 한 장면만 보더라도 무릎을 탁! 치며 외치게 될 것이다! 기가 ...', '2009-09-07', '당신이 알려고 하지 않아도 단연코 기억되는 그들...', 3521, 3);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '오달수'), 'dohc****', '개성 [individuality] : 더 이상 분할할 수 없는 독립적 존재인 개체를 다른 개체와 구별할 수 있게 하는 독자적인 특성 이 얼마나 멋진 이야기인가 ‘독립적 존재’ 요즘 드라마, 음악, 소설 등 ...', '2009-08-28', '다른 어떤 곳에서도 볼 수 없는 영화 속 다양한 장르 프로젝트!!', 2041, 1);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '고창석'), 'kid2****', '안녕하세요 언제나 고창석님의 영원한 팬인 배우지망생입니다.16살밖에 안됬지만 고창석님같은 배우가되기 위하여 끊임없이 노력하고있습니다.전 반드시 끝까지 노력해서 제가 존경하는 배우이신 고창...', '2013-09-06', '고창석님', 412, 0);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '고창석'), 'nesi****', 'http://nesil0.blog.me/130120135856 오오미 ㅡ 귀요미(?) 고창석입니다. 오호ㅡ 이 배우 그 두번째 올만에 배우 포스팅을 하는데요ㅡ 물론 잘자란 아역배우나 싱크로율 100% 배우도 배우 포스팅...', '2012-03-20', '오오미 ㅡ 귀요미(?) 고창석입니다. 오호ㅡ...', 720, 0);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '강신일'), 'hhhs****', '뒷늦게나마 천암함프로젝트 영화를 봤습니다.거기서 강신일 님께서 연기하는 변호사 역할도 인상깊었습니다.우리 사회에 빛이 되는 배우가 되어 주시기를 기원드립니다. 새누리당이 읽어버린 10년 운...', '2015-05-05', '천안함프로젝트 잘 보았습니다.. 힘내세요 ^^', 20, 0);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '강신일'), 'pmar****', '용기있게 출연하신 것 보고서 크게 감동 받았습니다. 예술인을 예술만 해야한다고, 정치적 생각없음이 자랑이라도 되는양 생각하는 사람들이 있지만 어리석은 생각이죠. 기본이 제대로 되지 않은 나라...', '2013-12-13', '천안함프로젝트', 26, 1);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '강신일'), 'oasi****', '천안함과 같이 침몰하네요... 이제 연극이나 하시면서 다시 언더그라운드로 씐나게 ㄱㄱㅅ 도재체가 이해가 안가네 ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ...', '2013-10-02', '그동안에 좋았던 이미지 한방에~~~~', 44, 0);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '김홍파'), '75kw****', '오늘 "악인은 살아있다"라는 영화를 보았다. 약간은 공포스러운 영화였다.영화 중 김홍파는 악인이었다. 그것도 참으로 잔인한 악인의 역할이었다. 보는 내내 예상하기 어려울 정도의 줄거리와 리얼한 ...', '2015-07-26', '리얼한 연기력 대단하다', 775, 2);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '성유빈'), '7jrw****', '낯이 익는다고 생각했는데, 대호에 나왔었군요..앞으로가 정말 기대되는 배우네요..^^ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ...', '2016-11-25', '토마스 쿡 뮤비에 나오는 분 맞죠?', 186, 0);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '성유빈'), 'soom****', '처음에 영화의 거대한 분위기에 걸맞지 않게 너무 재미없어서 실망했으나 점점 현빈의 어머니 (혜경궁)이 나오고 아이들이....너무 불쌍하게 나와ㅆ는데 그때부터 재밌어이면서... 점점 좀 재미보...', '2014-05-02', '역린', 405, 2);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '김지훈'), 'shgu****', '7광구 부터 타워 솔직히 저는 화려한 휴가도 별로 였지만 그래도 실화에 기초한 시나리오 때문에눈물샘 자극하는 신파로 관객을 모을수있엇다고 생각합니다.그러나 7광구나 타워...모두 뭔가를 보여주...', '2012-12-18', '자꾸 블록버스터 찍지마세요 자신이 잘하는걸 찾으세요.', 3149, 9);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '김지훈'), 'ckdg****', '타운 영화보면서 (솔직히 끝까지보기도 싫었음) 이건 좀 아니다 싶었습니다.. 한국 영화 수준이 이렇게 낮았나 싶었어요.. 그리고 도저히 이 어설픈 재난 영화를 찍은 감독은 누구인지 궁금하여 알게된...', '2013-03-09', '김지훈 감독님. 더 이상 영화 만들지 마세요..', 838, 8);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '김지훈'), 'jomo****', '제가 글 쓰는걸 별로 좋아하지 않는 독수리 타법인데도 이렇게 글을 쓰네요.솔직히 7광구, 타워..... 한국에 블록버스터 영화를 만들려는 노력 (그 의도가 정말 순수한 열망인지, 상업적 계산에 의한 ...', '2012-12-30', '김지훈 감독님께..', 1354, 5);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '김지훈'), 'slim****', '7광구 감독이라는걸 알고도 봤습니다.결론은 눈도 썩고 귀도 썩었습니다.등장인물들은 현실감 떨어지는 대사나 치고 연기력도 쓸데없이 감정표현 극도로 내놓는 오바나 싸지르고 있고, 카메라 연출은 ...', '2013-01-10', '언론에서 하도 띄워주길래한번봤는데', 449, 5);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '김지훈'), 'sayb****', '제작비가 1000원이라고 해도 그 1000원이 아까운 영화 우리나라 최고의 연기파배우를 연기처럼 사라지게 한 대단한 감독님.. 보는내내 닭살이 돋아 힘들었네요. 빽이 대단하신거 같으세요. 7광구 이후...', '2013-03-09', '이 돈으로 불우한 이웃을 도우세요.', 200, 3);


insert into tblFilmcompanyMovie(seq, fseq, mseq, role) values(seq.nextVal, 5, 4, '제작');
insert into tblFilmcompanyMovie(seq, fseq, mseq, role) values(seq.nextVal, 6, 4, '제작');
insert into tblFilmcompanyMovie(seq, fseq, mseq, role) values(seq.nextVal, 7, 4, '배급');



-- 5 앵커

insert into tblMovie(seq, rseq, title, engtitle, audience, runningtime, likes, summary, releasedate)
values(5, 3, '앵커', 'Anchor, 2022', 160430, 111, 1167, '"제 죽음이 정세라 앵커의 입을 통해 보도되면 너무 기쁠 것 같아요"
생방송 5분 전, 방송국 간판 앵커 "세라"(천우희)에게
 자신이 살해될 것이라며 죽음을 예고하는 제보전화가 걸려온다.
 장난전화로 치부하기에는 찝찝한 마음을 감출 수 없는 "세라".
 진짜 앵커가 될 기회라는 엄마 "소정"(이혜영)의 말에
 "세라"는 제보자의 집으로 향하고 제보자인 "미소"와 그녀의 딸의 시체를 목격한다.
 
 그날 이후, "세라"의 눈앞에 죽은 "미소"의 모습이 자꾸만 떠오르기 시작한다.
 사건 현장에서 미소의 주치의였던 정신과 의사 "인호"(신하균)를 마주하게 되며
 그에 대한 "세라"의 의심 또한 깊어지는데…
 
 완벽했던 앵커를 뒤흔들 충격적인 진실을 확인하라!', '2022-04-20');
 
 
insert into tblMovieGenre(seq, mseq, gseq) values(seq.nextVal, 5, 7);


insert into tblMovieCountry(seq, mseq, cseq) values(seq.nextVal, 5, 1);


insert into tblMovievideo(seq, mseq, division, title, regdate, video) values(seq.nextVal, 5, '예고편', '티저 예고편', '2022-03-25', 'https://movie.naver.com/movie/bi/mi/mediaView.naver?code=190374&mid=52006');
insert into tblMovievideo(seq, mseq, division, title, regdate, video) values(seq.nextVal, 5, '예고편', '메인 예고편', '2022-04-05', 'https://movie.naver.com/movie/bi/mi/mediaView.naver?code=190374&mid=52071');
insert into tblMovievideo(seq, mseq, division, title, regdate, video) values(seq.nextVal, 5, '예고편', '리뷰 스팟', '2022-04-20', 'https://movie.naver.com/movie/bi/mi/mediaView.naver?code=190374&mid=52203');
insert into tblMovievideo(seq, mseq, division, title, regdate, video) values(seq.nextVal, 5, '메이킹', '제작기 영상', '2022-04-07', 'https://movie.naver.com/movie/bi/mi/mediaView.naver?code=190374&mid=52098');


insert into tblPhoto(seq, mseq, category, photoURL, title) values(seq.nextVal, 5, '스틸컷', 'https://movie.naver.com/movie/bi/mi/photoView.naver?code=190374&imageNid=6761750', '영화 <앵커> 스틸 이미지');
insert into tblPhoto(seq, mseq, category, photoURL, title) values(seq.nextVal, 5, '스틸컷', 'https://movie.naver.com/movie/bi/mi/photoView.naver?code=190374&imageNid=6761752', '영화 <앵커> 스틸 이미지');
insert into tblPhoto(seq, mseq, category, photoURL, title) values(seq.nextVal, 5, '프로모션', 'https://movie.naver.com/movie/bi/mi/photoView.naver?code=190374&imageNid=6675250', '영화 <앵커> 리딩 현장');
insert into tblPhoto(seq, mseq, category, photoURL, title) values(seq.nextVal, 5, '프로모션', 'https://movie.naver.com/movie/bi/mi/photoView.naver?code=190374&imageNid=6761839', '영화 <앵커> 런칭쇼 현장');
insert into tblPhoto(seq, mseq, category, photoURL, title) values(seq.nextVal, 5, '포스터', 'https://movie.naver.com/movie/bi/mi/photoView.naver?code=190374&imageNid=6762121', '메인 포스터'); 


insert into tblQuote(seq, mseq, ID, mpseq, line, role, likes, regdate) values(seq.nextVal, 5, 'kilk****', (select m.seq from tblMoviePerson m where m.name = '천우희'), '동반자살이 아니라 살인 후 자살입니다.', '정세라', 4, '2022-04-24');


insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 5, (select m.seq from tblMoviePerson m where m.name = '천우희'), '주연', '정세라');
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 5, (select m.seq from tblMoviePerson m where m.name = '신하균'), '주연', '최인호');
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 5, (select m.seq from tblMoviePerson m where m.name = '이혜영'), '주연', '이소정');
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 5, (select m.seq from tblMoviePerson m where m.name = '차래형'), '조연', '민기태');
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 5, (select m.seq from tblMoviePerson m where m.name = '박지현'), '조연', '서승아');
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 5, (select m.seq from tblMoviePerson m where m.name = '남문철'), '조연', '보도국장');
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 5, (select m.seq from tblMoviePerson m where m.name = '임성재'), '조연', '김형사');
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 5, (select m.seq from tblMoviePerson m where m.name = '김영필'), '조연', '허기정');
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 5, (select m.seq from tblMoviePerson m where m.name = '정지연'), '감독', null);


insert into tblRatings(seq, score, contents, regdate, likes, nlikes, mseq, ID) values(seq.nextVal, 7, '해리가 앵커를 만났을 때', '2022-04-20', 79, 26, 5, 'pu4n****');
insert into tblRatings(seq, score, contents, regdate, likes, nlikes, mseq, ID) values(seq.nextVal, 8, '배우들의 연기가 좋고 긴장감 있었음', '2022-04-20', 55, 20, 5, 'wlwh****');
insert into tblRatings(seq, score, contents, regdate, likes, nlikes, mseq, ID) values(seq.nextVal, 8, '나름 좋은 반전. 예상하지 못하면 잼나다.', '2022-04-20', 51, 17, 5, 'cvac****');
insert into tblRatings(seq, score, contents, regdate, likes, nlikes, mseq, ID) values(seq.nextVal, 9, '천우희가 처음부터 끝까지 끌고 가는 연기력, 이어지는 긴장감이 좋아서 괜찮게 느껴졌어요. 다른 배우들의 연기, 스토리나 내용 전개, 의미도 괜찮았구요. 개인적으로는 코로나 팬데믹이었던 최근 1년 중에서 한국영화 탑3...', '2022-04-24', 43, 12, 5, 'sang****');
insert into tblRatings(seq, score, contents, regdate, likes, nlikes, mseq, ID) values(seq.nextVal, 7, '부모가 된다는 건 99퍼센트의 불안속에서 1퍼센트의 행복을 찾아내는 과정일 것이다', '2022-04-21', 37, 10, 5, 'somy****');


insert into tblMovieReivew(seq, contents, regdate, title, views, recommendedNum, mseq, ID) values(seq.nextVal, '4월 20일 개봉되는 영화 앵커입니다. 원래는 2020년 개봉예정이였는데, 코로나로 소식이 없었다가..2년만에 개봉되는 작품입니다.그러고보니 천우희배우의 영화들이 코로나로 인해 많이 밀린거 같아요..앵커에, 니...', '2022-04-20', '[영화감상] 앵커 (2022)', 49, 0, 5, 'sakg****');
insert into tblMovieReivew(seq, contents, regdate, title, views, recommendedNum, mseq, ID) values(seq.nextVal, '배우 천우희가 공포 스릴러 영화 <곡성>에서 보여줬던 귀신 같은 이미지는 아직까지 떠오를 정도로 대단했다. 그래서인지 영화 <앵커>에서 천우희가 보여준 미스터리한 캐릭터 또한 그녀의 개성과 딱 맞아 떨어진다는 느낌을...', '2022-04-23', '[영화 앵커 정보&노스포 리뷰] 반전 스릴러에 엮인 천...', 12, 0, 5, 'sole****');
insert into tblMovieReivew(seq, contents, regdate, title, views, recommendedNum, mseq, ID) values(seq.nextVal, '감독 정지연 출연 천우희, 신하균, 이혜영 개봉 2022.04.20. 대한민국 평점 리뷰보기 정지연 감독이 연출한 <앵커>는 방송국 9시 뉴스 앵커가 제보전화의 사건 현장을...', '2022-04-19', '[앵커]를 보고(스포)', 42, 0, 5, 'film****');
insert into tblMovieReivew(seq, contents, regdate, title, views, recommendedNum, mseq, ID) values(seq.nextVal, '[영화 앵커] 반전을 위해 무리하게 꿰어 맞춘 해리성 장애코로나 거리두기가 조금씩 정상에 가까워 지고 있다.이미 완성되었지만 눈치를 보면서 묵혀둔 영화들이 조금씩 보따리를 풀고 있다.코로나 시기에 다양성 영화를 만나는 즐거움은 ...', '2022-04-22', '[영화 앵커] 반전을 위해 무리하게 꿰어 맞춘 해리성 장애', 17, 0, 5, 'h907****');
insert into tblMovieReivew(seq, contents, regdate, title, views, recommendedNum, mseq, ID) values(seq.nextVal, '20220421의정부태흥 CGV 9-H-9스피드쿠폰 현금3/5 "제 죽음이 정세라 앵커의 입을 통해 보도되면 너무 기쁠 것 같아요"생방송 5분 전, 방송국 간판 앵커 "세라"(천우희)에게자신이 살해될 것이라며 죽음을 예고하는 제보전화가 걸려온다....', '2022-04-21', '[앵커]<현금>(29번째) 동어반복, 크레센도, 점입가경...', 3, 0, 5, 'acts****');


insert into tblUser(id, gender, age) values('kilk****', 'f', 23);
insert into tblUser(id, gender, age) values('pu4n****', 'f', 32);
insert into tblUser(id, gender, age) values('wlwh****', 'm', 35);
insert into tblUser(id, gender, age) values('cvac****', 'm', 20);
insert into tblUser(id, gender, age) values('sang****', 'f', 25);
insert into tblUser(id, gender, age) values('somy****', 'f', 28);
insert into tblUser(id, gender, age) values('sakg****', 'm', 43);
insert into tblUser(id, gender, age) values('sole****', 'm', 39);
insert into tblUser(id, gender, age) values('film****', 'f', 47);
insert into tblUser(id, gender, age) values('h907****', 'm', 30);
insert into tblUser(id, gender, age) values('acts****', 'm', 20);
insert into tblUser(id, gender, age) values('morb****', 'm', 40);
insert into tblUser(id, gender, age) values('sang****', 'f', 50);
insert into tblUser(id, gender, age) values('cher****', 'm', 35);
insert into tblUser(id, gender, age) values('ljr0****', 'f', 42);
insert into tblUser(id, gender, age) values('zmfl****', 'f', 18);


insert into tblAwards(seq, mpseq, content) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '신하균'), '2021년 57회 백상예술대상 TV 남자최우수연기상');
insert into tblAwards(seq, mpseq, content) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '신하균'), '2019년 제 39회 한국영화평론가협회상 남우주연상');
insert into tblAwards(seq, mpseq, content) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '이혜영'), '1992년 13회 청룡영화상 여우조연상');
insert into tblAwards(seq, mpseq, content) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '정지연'), '2014년 8회 대단한 단편영화제 심사위원 특별언급 수상');


insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '신하균'), 'morb****', '악녀로 몇 년만에 신하균을 스크린에서 보게 되었다. 엄청 굵어진 입가 주름하며 최소 50대로 보이는 외모로 변해서 나름 충격이었음. 이 분 나이는...', '2017-11-19', '안 보던 사이에 엄청 나이들어보이시는...', 414, 1);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '신하균'), 'sang****', '그가 한 작품을 손에 꼽을 정도로 밖에 보진 못했지만 그 작품들을 보면서 감탄할 수 있고 소름이 돋을 수 있다는건 어려운 일이라고 생각한다. 하지만 이 배우 "신하균"이라는 배우는 해냈다. 떄...', '날짜', '언제나 기대되는 배우', 2104, 16);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '이혜영'), 'cher****', '이혜영 씨의 초기작도 몇 편 봤고, SBS 시사 프로 진행 하던 모습도 기억납니다. 제 생각에는 발성, 발음, 배우다운 사고방식, 빛에 따라 매력적인 굴곡을 만들어 내는 광대뼈, 카리스파 넘치는 갈색 ...', '2015-07-22', '한국 여배우 중 최고의 마스크', 160, 5);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '박지현'), 'ljr0****', '샤브샵샵스르뱌스뱌샵샵스샤부샵샤부샤갸샵 샤브샵샵스르뱌스뱌샵샵스샤부샵샤부샤갸샵샤브샵샵스르뱌스뱌샵샵스샤부샵샤부샤갸샵샤브샵샵스르뱌스뱌샵샵스샤부샵샤부샤갸샵샤브샵샵스르뱌스뱌샵샵스샤...', '2018-05-07', '곤지암 보기전에 명대사보고 무슨 이딴 대사가 다있냐고...', 530, 0);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '박지현'), 'zmfl****', '이번에 곤지암을 보고 팬이 된 사람입니다.영화를 보는데 너무 예쁘셔서 눈이 호강했습니다. 가장 무서운 장면이 지현 배우님이 귀신으로 나오신.. 그 장면입니다!! 슷브슷브스븟스 라는말로 유행되고 ...', '2018-03-31', '예뻐요! 지현 배우님!!', 996, 2);


insert into tblFilmcompanyMovie(seq, fseq, mseq, role) values(seq.nextVal, 8, 5, '제작');
insert into tblFilmcompanyMovie(seq, fseq, mseq, role) values(seq.nextVal, 9, 5, '제작');
insert into tblFilmcompanyMovie(seq, fseq, mseq, role) values(seq.nextVal, 10, 5, '배급');



-- 6 로스트 시티

insert into tblMovie(seq, rseq, title, engtitle, audience, runningtime, likes, summary, releasedate)
values(6, 2, '로스트 시티', 'The Lost City, 2022', 103622, 111, 331,
'전설의 트레저를 차지하기 위해 재벌 페어팩스(다니엘 래드클리프)는 유일한 단서를 알고 있는 베스트셀러 작가 로레타(산드라 블록)를 납치하게 된다.
 어쩔 수 없는 비지니스 관계로 사라진 그녀를 찾아야만 하는 책 커버모델 앨런(채닝 테이텀)은 의문의 파트너(브래드 피트)와 함께 위험한 섬에서 그녀를 구하고 무사히 탈출해야만 하는데… 
 적과 자연의 위험이 도사리는 일촉즉발 화산섬
 대환장 케미의 그들이 생존하여 섬을 탈출할 수 있을까?', '2022-04-20');
 
 
insert into tblMovieGenre(seq, mseq, gseq) values(seq.nextVal, 6, 19);
insert into tblMovieGenre(seq, mseq, gseq) values(seq.nextVal, 6, 11);
insert into tblMovieGenre(seq, mseq, gseq) values(seq.nextVal, 6, 5);
insert into tblMovieGenre(seq, mseq, gseq) values(seq.nextVal, 6, 6);


insert into tblMovieCountry(seq, mseq, cseq) values(seq.nextVal, 6, 2);


insert into tblMovievideo(seq, mseq, division, title, regdate, video) values(seq.nextVal, 6, '예고편', '메인 예고편', '2022-03-24', 'https://movie.naver.com/movie/bi/mi/mediaView.naver?code=212098&mid=51997');
insert into tblMovievideo(seq, mseq, division, title, regdate, video) values(seq.nextVal, 6, '예고편', '티저 예고편', '2021-12-22', 'https://movie.naver.com/movie/bi/mi/mediaView.naver?code=212098&mid=51387');
insert into tblMovievideo(seq, mseq, division, title, regdate, video) values(seq.nextVal, 6, '메이킹', '나는 자연인이다 in 로스트 시티 영상', '2022-04-19', 'https://movie.naver.com/movie/bi/mi/mediaView.naver?code=212098&mid=52193');
insert into tblMovievideo(seq, mseq, division, title, regdate, video) values(seq.nextVal, 6, '메이킹', '리얼 자연인의 리얼 추천 영상 (ft. 정형석 성우 겸 배우)', '2022-04-27', 'https://movie.naver.com/movie/bi/mi/mediaView.naver?code=212098&mid=52249');
insert into tblMovievideo(seq, mseq, division, title, regdate, video) values(seq.nextVal, 6, '인터뷰', '찰떡케미 인터뷰 with 안현모 통역사', '2022-04-15', 'https://movie.naver.com/movie/bi/mi/mediaView.naver?code=212098&mid=52154');


insert into tblPhoto(seq, mseq, category, photoURL, title) values(seq.nextVal, 6, '스틸컷', 'https://movie.naver.com/movie/bi/mi/photoView.naver?code=212098&imageNid=6753090', '영화 <로스트 시티> 스틸 이미지');
insert into tblPhoto(seq, mseq, category, photoURL, title) values(seq.nextVal, 6, '스틸컷', 'https://movie.naver.com/movie/bi/mi/photoView.naver?code=212098&imageNid=6761361', '영화 <로스트 시티> 스틸 이미지');
insert into tblPhoto(seq, mseq, category, photoURL, title) values(seq.nextVal, 6, '스틸컷', 'https://movie.naver.com/movie/bi/mi/photoView.naver?code=212098&imageNid=6761362', '영화 <로스트 시티> 스틸 이미지');
insert into tblPhoto(seq, mseq, category, photoURL, title) values(seq.nextVal, 6, '스틸컷', 'https://movie.naver.com/movie/bi/mi/photoView.naver?code=212098&imageNid=6761364', '영화 <로스트 시티> 스틸 이미지');
insert into tblPhoto(seq, mseq, category, photoURL, title) values(seq.nextVal, 6, '포스터', 'https://movie.naver.com/movie/bi/mi/photoView.naver?code=212098&imageNid=6760937', '메인 포스터');


insert into tblQuote(seq, mseq, ID, mpseq, line, role, likes, regdate) values(seq.nextVal, 6, 'biuo****', (select m.seq from tblMoviePerson m where m.name = '채닝 테이텀'), '맨스플레인 해봐요', '앨런 캐프리손', 0, '2022-05-03');


insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 6, (select m.seq from tblMoviePerson m where m.name = '산드라 블록'), '주연', '로레타 세이지');
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 6, (select m.seq from tblMoviePerson m where m.name = '채닝 테이텀'), '주연', '앨런 캐프리손');
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 6, (select m.seq from tblMoviePerson m where m.name = '다니엘 래드클리프'), '주연', '에비게일 페어팩스');
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 6, (select m.seq from tblMoviePerson m where m.name = '애덤 니'), '감독', null);
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 6, (select m.seq from tblMoviePerson m where m.name = '아론 니'), '감독', null);


insert into tblRatings(seq, score, contents, regdate, likes, nlikes, mseq, ID) values(seq.nextVal, 4, '이 영화의 진미는 영화를 다 보고 나서 웃긴다는 것이다. 다시 생각하면 생각할수록 왜 내가 이 영화를 13000(그 와중에 cgv..가격 젤 먼저 인상되서 더 비싼 가격)에 봤는지를 헛웃음이...', '2022-04-20', 31, 5, 6, 'milk****');
insert into tblRatings(seq, score, contents, regdate, likes, nlikes, mseq, ID) values(seq.nextVal, 6, '그가 사라지자 영화의 재미도 사라졌다', '2022-04-22', 17, 0, 6, 'band****');
insert into tblRatings(seq, score, contents, regdate, likes, nlikes, mseq, ID) values(seq.nextVal, 2, '최고의캐스팅으로 빗어낸 찰흙덩어리', '2022-04-20', 20, 3, 6, 'smy1****');
insert into tblRatings(seq, score, contents, regdate, likes, nlikes, mseq, ID) values(seq.nextVal, 4, '이것은 액션인가 로맨스인가. 지금까지 이런 영화는 많았다~. 비싼 배우님들 모시고 이게 뭐하는 짓이냐 !!!', '2022-04-20', 22, 5, 6, 'geuz****');
insert into tblRatings(seq, score, contents, regdate, likes, nlikes, mseq, ID) values(seq.nextVal, 7, '작품성과 별개로 S급 배우들의 덜떨어진 모습을 보는 건 역시 재미있다.', '2022-04-21', 17, 4, 6, 'magi****');


insert into tblMovieReivew(seq, contents, regdate, title, views, recommendedNum, mseq, ID) values(seq.nextVal, '안녕하세요정말 오랜만에 글을 쓰는 것 같습니다.여러모로 바쁜 일도 있었고요즘 드라마를 계속해서 보고 있어서...영화 글을 쓰기가 버거웠네요어떤 드라마를 보았는지 조만간 간단하게 글을 적어볼까 합니다.하여튼! 영화에 소홀해진 것...', '2022-04-23', '『로스트 시티 : The Lost City 2022』뻔하지만 생각없이...', 45, 2, 6, 'mhrh****');
insert into tblMovieReivew(seq, contents, regdate, title, views, recommendedNum, mseq, ID) values(seq.nextVal, '산드라 블록이 오랜만에 코믹 액션 어드벤처 영화 로스트 시티(The Lost City, 2022)로 극장가를 찾아왔다. 이번에는 여성 군단(?) 대신 채닝 테이텀, 브래드 피트, 다니엘 래드클리프 같은 스타 배우들과 함께 호흡을 맞췄다. 개인적으...', '2022-04-24', '[영화 로스트 시티 정보&리뷰] 산드라 블록의 코믹...', 11, 0, 6, 'sole****');
insert into tblMovieReivew(seq, contents, regdate, title, views, recommendedNum, mseq, ID) values(seq.nextVal, '[영화 로스트 시티] 남녀 주인공 캐릭터가 뒤바뀐 로맨싱 스톤제목부터 보물찾기를 암시한다.정글에서 보물 찾는 소동극은 영화 소재로 식상하면서도 성공이 보장되는 줄거리다.예고편에 대환장 코믹이라는 문구와 다른 제법 그럴싸한 스...', '2022-04-21', '[영화 로스트 시티] 남녀 주인공 캐릭터가 뒤바뀐 로맨싱...', 20, 0, 6, 'h907****');
insert into tblMovieReivew(seq, contents, regdate, title, views, recommendedNum, mseq, ID) values(seq.nextVal, '20220422의정부 CGV 5-E-10스피드쿠폰 현금3.5/5 전설의 트레저를 차지하기 위해 재벌 페어팩스(다니엘 래드클리프)는 유일한 단서를 알고 있는 베스트셀러 작가 로레타(산드라 블록)를 납치하게 된다. 어쩔 수 없는 비지니스 관계로 사라...', '2022-04-22', '[로스트 시티]<현금>(30번째) 구리구리한 이야기를...', 4, 0, 6, 'acts****');
insert into tblMovieReivew(seq, contents, regdate, title, views, recommendedNum, mseq, ID) values(seq.nextVal, '영화 리뷰 블로거인서로이웃 "킴지" 님이 주최하신응모 이벤트에 당첨되어,지난 금요일에 롯데시네마월드타워에서 열린영화 "로스트 시티" 시사회에다녀왔습니다.티켓과 시사회 기념품동시 수령!주인공 로레타(산드라 블록)가극 중에서 입...', '2022-04-17', '영화 "로스트 시티" 버라이어티 시사회 후기.', 52, 0, 6, 'dlcj****');


insert into tblUser(id, gender, age) values('biuo****', 'f', 22);
insert into tblUser(id, gender, age) values('milk****', 'f', 21);
insert into tblUser(id, gender, age) values('smy1****', 'f', 30);
insert into tblUser(id, gender, age) values('geuz****', 'f', 35);
insert into tblUser(id, gender, age) values('magi****', 'm', 19);
insert into tblUser(id, gender, age) values('mhrh****', 'm', 17);
insert into tblUser(id, gender, age) values('h907****', 'm', 27);
insert into tblUser(id, gender, age) values('dlcj****', 'm', 35);
insert into tblUser(id, gender, age) values('amis****', 'f', 24);
insert into tblUser(id, gender, age) values('yeon****', 'f', 28);
insert into tblUser(id, gender, age) values('gksl****', 'f', 36);
insert into tblUser(id, gender, age) values('love****', 'f', 31);
insert into tblUser(id, gender, age) values('yein****', 'm', 29);
insert into tblUser(id, gender, age) values('ppsm****', 'm', 20);



insert into tblAwards(seq, mpseq, content) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '산드라 블록'), '2019년 28회 MTV 영화 & TV 어워즈 최고의 공포연기상');
insert into tblAwards(seq, mpseq, content) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '산드라 블록'), '2014년 제 19회 크리틱스 초이스 시상식 액션영화 여우주연상');
insert into tblAwards(seq, mpseq, content) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '채닝 테이텀'), '2015년 24회 MTV 영화 & TV 어워즈 최고의 코믹연기상');
insert into tblAwards(seq, mpseq, content) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '다니엘 래드클리프'), '2016년 49회 시체스영화제 오피셜 판타스틱-남우주연상');
insert into tblAwards(seq, mpseq, content) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '다니엘 래드클리프'), '2012년 제 21회 MTV 영화 & TV 어워즈 최고의 캐스트');


insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '산드라 블록'), 'amis****', '동서양, 남여배우 다 통 털어서 제가 젤 좋아하는 배우입니다. 정말 인간적이고 아름다운 배우, 산드라 포에버~~~ 그녀가 출연한 영화는 거의 다 봤습니다. 오래된 영화 중, 누구나 다 아는 영화인 당...', '2015-05-25', '그녀가 출연한 모든 영화', 1106, 1);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '산드라 블록'), 'yeon****', '연기 너무너무 잘하고 너무너무 아름다운배우ㅠㅠㅠㅠ프로포즈부터 그래비티까지 진짜 짱이에요... 한번 만나보고 싶어여 !!!!!!!!!!!!!!!!!!!!!!!!!! Im your big FAN !!!!!!!!!!!!!!!!!! ♡연기 너...', '2015-01-13', '만나보고싶은 배우@!!!!', 1399, 0);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '다니엘 래드클리프'), 'gksl****', '다니엘래드클리프 너무너무멋있어욤~~~~잘생기구,해리포터연기두잘하구♥여태까지나온해리포터영화다봤어욤♥ 샹훼♥샹훼♥샹훼♥샹훼♥샹훼♥샹훼♥샹훼♥샹훼♥샹훼♥샹훼♥샹훼♥샹훼샹훼♥샹훼♥샹...', '2007-12-28', '♥', 5118, 2);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '다니엘 래드클리프'), 'love****', '해리포터 (다니엘 래드 클리프)가 캐이티 렁에게 키스하는 것 정말 느낌이 이상했대염 ...ㅋㅋ 또 해리미온느랑 해리포터가 사귄다는 설도 근데 아니라고 함...........................................', '2008-02-05', 'love', 3548, 2);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '다니엘 래드클리프'), 'yeon****', '해리포터 영화 1~8 까지 4번보고, 해리포터 책 1~8까지 1번씩 봤는데 보고 또보고 해도 너무 재미있는 책이예요!!! 근데 해리포터 2 나옴 정말 좋겠는데 나왔나요 조앤롤링이 해리포터 2를 썼다나 뭐...', '2014-07-30', '해리포터', 653, 0);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '다니엘 래드클리프'), 'yein****', '해리포터로 알게되고 해리포터 팬이기 때문에 확실히 얼굴 보자마자 해리포터 떠오르는 게 당연한데 이상하게 스크린 안에서는 절대 해리포터 생각이 안 날 정도로 연기력이 좋은 것 같음. 뭔가 한 영...', '2020-04-23', '진짜..연기력....', 44, 0);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '다니엘 래드클리프'), 'ppsm****', '한때 마의 16세를 잘못넘긴 예로 빠지지 않는 배우였습니다.... 우리의 유년시절의 추억 해리포터. 그 주인공이 불사조 기사단때부터 외모가 폭삭 변하나 싶더니 혼혈왕자에서 결국 모두가 탄식을...', '2014-11-26', '성장통을 딛고 더욱 성숙해진 우리의 해리포터', 405, 0);


insert into tblFilmcompanyMovie(seq, fseq, mseq, role) values(seq.nextVal, 11, 6, '수입');
insert into tblFilmcompanyMovie(seq, fseq, mseq, role) values(seq.nextVal, 11, 6, '배급');



-- 7 범죄도시2 (개봉전, 평점 명대사 없음)

insert into tblMovie(seq, rseq, title, engtitle, audience, runningtime, likes, summary, releasedate)
values(7, 3, '범죄도시2', 'the roundup, 2022', null, 106, 7347, '“느낌 오지? 이 놈 잡아야 하는 거”
가리봉동 소탕작전 후 4년 뒤,
 금천서 강력반은 베트남으로 도주한 용의자를 인도받아 오라는 미션을 받는다.
 
 괴물형사 ‘마석도’(마동석)와 ‘전일만’(최귀화) 반장은 현지 용의자에게서 수상함을 느끼고,
 그의 뒤에 무자비한 악행을 벌이는 ‘강해상’(손석구)이 있음을 알게 된다.
 
 ‘마석도’와 금천서 강력반은 한국과 베트남을 오가며
 역대급 범죄를 저지르는 ‘강해상’을 본격적으로 쫓기 시작하는데...
 
 나쁜 놈들 잡는 데 국경 없다!
 통쾌하고 화끈한 범죄 소탕 작전이 다시 펼쳐진다!', '2022-05-18');


insert into tblMovieGenre(seq, mseq, gseq) values(seq.nextVal, 7, 16);
insert into tblMovieGenre(seq, mseq, gseq) values(seq.nextVal, 7, 19);


insert into tblMovieCountry(seq, mseq, cseq) values(seq.nextVal, 7, 1);


insert into tblMovievideo(seq, mseq, division, title, regdate, video) values(seq.nextVal, 7, '예고편', '론칭예고편 #1', '2022-02-08', 'https://movie.naver.com/movie/bi/mi/mediaView.naver?code=192608&mid=51698');
insert into tblMovievideo(seq, mseq, division, title, regdate, video) values(seq.nextVal, 7, '예고편', '론칭예고편 #2', '2022-02-08', 'https://movie.naver.com/movie/bi/mi/mediaView.naver?code=192608&mid=50927');
insert into tblMovievideo(seq, mseq, division, title, regdate, video) values(seq.nextVal, 7, '예고편', '티저 예고편', '2022-04-08', 'https://movie.naver.com/movie/bi/mi/mediaView.naver?code=192608&mid=52103');
insert into tblMovievideo(seq, mseq, division, title, regdate, video) values(seq.nextVal, 7, '예고편', '메인 예고편', '2022-04-21', 'https://movie.naver.com/movie/bi/mi/mediaView.naver?code=192608&mid=52213');
insert into tblMovievideo(seq, mseq, division, title, regdate, video) values(seq.nextVal, 7, '예고편', '월드와이드 스페셜 클립', '2022-04-28', 'https://movie.naver.com/movie/bi/mi/mediaView.naver?code=192608&mid=52262');


insert into tblPhoto(seq, mseq, category, photoURL, title) values(seq.nextVal, 7, '스틸컷', 'https://movie.naver.com/movie/bi/mi/photoView.naver?code=192608&imageNid=6764455', '영화 <범죄도시2> 스틸 이미지');
insert into tblPhoto(seq, mseq, category, photoURL, title) values(seq.nextVal, 7, '스틸컷', 'https://movie.naver.com/movie/bi/mi/photoView.naver?code=192608&imageNid=6764456', '영화 <범죄도시2> 스틸 이미지');
insert into tblPhoto(seq, mseq, category, photoURL, title) values(seq.nextVal, 7, '스틸컷', 'https://movie.naver.com/movie/bi/mi/photoView.naver?code=192608&imageNid=6764457', '영화 <범죄도시2> 스틸 이미지');
insert into tblPhoto(seq, mseq, category, photoURL, title) values(seq.nextVal, 7, '프로모션', 'https://movie.naver.com/movie/bi/mi/photoView.naver?code=192608&imageNid=6764290', '영화 <범죄도시2> 글로벌 런칭쇼 현장');
insert into tblPhoto(seq, mseq, category, photoURL, title) values(seq.nextVal, 7, '포스터', 'https://movie.naver.com/movie/bi/mi/photoView.naver?code=192608&imageNid=6763904', '메인 포스터');

insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 7, (select m.seq from tblMoviePerson m where m.name = '마동석'), '주연', '마석도');
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 7, (select m.seq from tblMoviePerson m where m.name = '손석구'), '주연', '강해상');
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 7, (select m.seq from tblMoviePerson m where m.name = '최귀화'), '주연', '전일만');
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 7, (select m.seq from tblMoviePerson m where m.name = '박지환'), '주연', '장이수');
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 7, (select m.seq from tblMoviePerson m where m.name = '허동원'), '조연', '오동균');
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 7, (select m.seq from tblMoviePerson m where m.name = '하준'), '조연', '강홍석');
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 7, (select m.seq from tblMoviePerson m where m.name = '정재광'), '조연', '김상훈');
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 7, (select m.seq from tblMoviePerson m where m.name = '음문석'), '조연', '장기철');
insert into tblMovieMoviePerson(seq, mseq, mpseq, role, casting) values(seq.nextVal, 7, (select m.seq from tblMoviePerson m where m.name = '이상용'), '감독', null);


insert into tblMovieReivew(seq, contents, regdate, title, views, recommendedNum, mseq, ID) values(seq.nextVal, '5월 18일 개봉예정인 영화 범죄도시2입니다.2017년 개봉했었던 영화 범죄도시의 후속편인데요..당시 범죄도시는 688만명을 모으며 흥행했고..마동석,윤계상 두 배우의 활약뿐만 아니라.진선규,허성태,박지환 등 샛별 빌...', '2022-04-29', '[개봉예정] 범죄도시2 (the roundup, 2022)', 20, 0, 7, 'sakg****');
insert into tblMovieReivew(seq, contents, regdate, title, views, recommendedNum, mseq, ID) values(seq.nextVal, '영화 [범죄도시2] 런칭 예고편 : 마동석, 손석구, 최귀화, 박지환, 허동원 : 2022 : 범죄 액션범죄도시의 후속작. 2020년에 개봉 예정이었으나 코로나로 인해 2022년에 개봉.2022 / The Roundup감독: 이상용출연: 마동석, 손석구, 최귀화,...', '2021-11-02', '영화 [범죄도시2] 런칭 예고편 : 마동석, 손석구, 최귀화...', 243, 0, 7, 'shin****');
insert into tblMovieReivew(seq, contents, regdate, title, views, recommendedNum, mseq, ID) values(seq.nextVal, '범죄도시2 2021 the roundup 범죄,액션/한국 : 에이투글로벌제목 : 범죄도시2개요 : 범죄,액션/한국개봉 : 2022.미정평점 : -누적관객수 : -출연 : 마동석(마석도),손석구(강해상),최귀화(전일만),박지환(장이수),허동원(오동균),하준(강...', '2021-11-11', '범죄도시2 2021 the roundup 범죄,액션/한국 : 에이투...', 54, 0, 7, 'a2g8****');


insert into tblUser(id, gender, age) values('shin****', 'f', 25);
insert into tblUser(id, gender, age) values('a2g8****', 'f', 35);
insert into tblUser(id, gender, age) values('hila****', 'm', 46);
insert into tblUser(id, gender, age) values('tjsd****', 'm', 52);
insert into tblUser(id, gender, age) values('pu_e****', 'f', 23);
insert into tblUser(id, gender, age) values('gdcv****', 'm', 26);
insert into tblUser(id, gender, age) values('7mbg****', 'm', 36);
insert into tblUser(id, gender, age) values('s2pm****', 'm', 39);
insert into tblUser(id, gender, age) values('yuki****', 'f', 42);
insert into tblUser(id, gender, age) values('sh90****', 'm', 34);
insert into tblUser(id, gender, age) values('dhwo****', 'f', 31);
insert into tblUser(id, gender, age) values('byma****', 'f', 18);
insert into tblUser(id, gender, age) values('taka****', 'm', 19);
insert into tblUser(id, gender, age) values('tari****', 'm', 22);
insert into tblUser(id, gender, age) values('newc****', 'f', 25);
insert into tblUser(id, gender, age) values('shal****', 'm', 29);
insert into tblUser(id, gender, age) values('kukd****', 'm', 32);
insert into tblUser(id, gender, age) values('2hor****', 'm', 37);
insert into tblUser(id, gender, age) values('moya****', 'f', 38);
insert into tblUser(id, gender, age) values('pjy9****', 'm', 48);


insert into tblAwards(seq, mpseq, content) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '마동석'), '2013년 49회 백상예술대상 영화 남자조연상');
insert into tblAwards(seq, mpseq, content) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '최귀화'), '2017년 17회 디렉터스 컷 어워즈 올해의 새로운 남자배우상');
insert into tblAwards(seq, mpseq, content) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '하준'), '2021년 30회 부일영화상 신인 남자 연기상');
insert into tblAwards(seq, mpseq, content) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '하준'), '2021년 제 24회 부천국제판타스틱영화제 코리안 판타스틱: 장편 배우상');
insert into tblAwards(seq, mpseq, content) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '정재광'), '2021년 22회 전주국제영화제 한국경쟁 - 배우상');
insert into tblAwards(seq, mpseq, content) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '정재광'), '2021년 제 42회 청룡영화상 신인남우상');


insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '마동석'), 'hila****', '연기력도 출중하시고 구수한 전라도 사투리도 좋고 ㅋㅋㅋ 진짜 몸도 좋고 ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ 깡패 운동선수 다 어울리구요 ㅎㅎ 엉성한 역도 다 어울리고 넘 재미있어요 감초역할을 톡톡...', '2012-11-03', '마동석님 나온영화는 다 재미있어요..ㅎㅎ', 3704, 6);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '마동석'), 'tjsd****', '완전 팬이에요.사..사사랑...합니다..이웃사람...짱..대박...아...완전 팬이에요.사..사사랑...합니다..이웃사람...짱..대박...아...완전 팬이에요.사..사사랑...합니다..이웃사람...짱..대박...아...', '2012-11-27', '마동석씨...', 3010, 2);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '마동석'), 'pu_e****', '웃기ㅅ심 아싸일빠당ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ...', '2012-10-31', 'ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ...', 1758, 1);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '마동석'), 'gdcv****', '욕 너무 찰지게 함ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ...', '2014-12-04', '동석이형', 678, 1);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '마동석'), '7mbg****', '연기도 좋고 개성있고 다 좋은데! 너무 다작하시네요......제가 민감한건지 유명한 영화,약간 마이너한 영화 등등 볼때마다 너무 자주 보이시니 몰입이 안 됩니다. 이 역할이 이 역할 같고.... 솔직히 ...', '2013-05-24', '연기도 좋고 개성있고 다 좋은데!', 181, 1);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '최귀화'), 's2pm****', '택시운전사에서 너무너무 무서워서 영화끝나고 나면 꼭 찾아봐야지 했네요..다른 분들도 잘하셨지만.. 최귀화님도 연기 넘 멋졌습니다.~!!젤 첨에 무자비하게 시민 때리는 모습보고 이 분은 이 영화에...', '2017-08-11', '택시운전사에서 처음 뵙네요~!!>.', 405, 1);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '최귀화'), 'yuki****', '어우 막 꿈에나올정도로 웃겨서 ㅜㅜㅜㅜㅜㅜㅜㅜ워매가 너무 인상깊아요봉이 본지 한두달됐는데 왜이제서야 자꾸웃기지........200자나 써야한다니..............ㅇ ㅓ...부산행 안보려고했는데 거기...', '2016-08-14', '봉이보는데 너무 웃겼어요 ㅋㅋㅋㅋㅋㅋㅋㅋㅋ...', 63, 1);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '최귀화'), 'sh90****', '아주 강렬하시더군요...ㅎㅎㅎ장차 크게 성공하실 분이라고 생각합니다.. 봉이 김선달은 사실 이분의 영화라고 해도 과언이 아닌..앞으로 잘 볼게요 ~ !---------------------------------------------...', '2016-08-12', '봉이 김선달에서 제일 씬스틸러 ~ ', 134, 1);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '최귀화'), 'dhwo****', '미생 때 너무 인상깊은 연기를 봐서 그때부터 팬이었습니다. 미생 이후로 이것 저것 검색해서 인터뷰도 읽고 그랬어요. 그때 나홍진 감독님의 곡성을 촬영 중이라는 인터뷰를 기억하고 언제 나오나계속...', '2016-08-04', '미생 때부터 팬이었습니다. ', 430, 1);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '최귀화'), 'byma****', '제가 다른 작품 무엇무엇을 봤다고 말씀은 못 드리고 그저 낯이 익은 배우다 정도 였는데(심지어 곡성은 올해 가장 인상깊게 본 영화인데 거기 나오신 거 아 친군가보다라고 생각. 바로 떠올리지 못...', '2016-07-23', '부산행에서 수많은 배우 분들 중에 가장 여운이 남는...', 1030, 1);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '박지환'), 'taka****', '갑자기 어디서 나타난 연기 괴물인가? 장이수역 진짜 연기 좋았습니다갑자기 어디서 나타난 연기 괴물인가? 장이수역 진짜 연기 좋았습니다갑자기 어디서 나타난 연기 괴물인가? 장이수역 진짜 연기 ...', '2017-10-23', '이분 연기 진짜 최고', 1360, 11);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '박지환'), 'tari****', '이런 연기자가 떠야지 얼굴 믿고 팬심으로만 밀어붙히는 연기자는 한번 싹 갈아버려야함 진짜 박지환 연기자 독보적인 깡패상 연기 정말 인상적이었습니다 물론 그정도 연기력이면 다른 역할도 훌륭히 ...', '2017-11-04', '이 분 연기보고 연기자는 아무나 할 수 있는게 아니...', 1312, 9);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '박지환'), 'newc****', '군대에서 연기도 보여주고 코미디도 보여주고 그랬었는데가끔 무술도 하셨었죠?ㅋㅋㅋ두태산에 같이 못 올라간게 정말 아쉬웠었는데....암튼 이렇게 다시 보게 되네요^^이번에 황정민씨 나왔던 "남자가...', '2014-03-11', '박지환 상병님...', 1471, 7);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '박지환'), 'shal****', '범죄도시 인상깊게 봐서 필모그래피 검색해 봤어요오늘자 영화인 검색 순위 20위입니다.4 마동석, 8 진선규, 9 윤계상16 라이언 고슬링, 19 이병헌, 25 박해일, 26 하정우200자 이상;범죄도시 인상깊게...', '2017-10-17', '장이수 두목님', 785, 4);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '박지환'), 'kukd****', '워낙 캐릭터들이 매력적이라서 이분이 안보이는 듯 하지만진짜 표정들 하나하나가 정말 대단했어요진짜보다 더 진짜 같은 하이퍼 리얼..자연스러다기보다 극리얼..어디선가 그 자리에서 살고 있다 티비...', '2017-12-12', '영화 내내 소름 돋았음요..', 117, 3);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '허동원'), '2hor****', '범죄도시에서 끊임없이 너스레를 떠는 형사역할의 허동원씨. 살짝 사투리를 쓰는 캐릭터가 너무 호감이라서 눈여겨 보고 있습니다.  "뺏지 보여주면 임마들 씩~ 웃어뿐다니까? 뺏찌 보여줘 봤자 칼부터 ...', '2020-12-09', '난 범죄도시에서 이분이 제일 호감이 가더라~', 9, 0);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '허동원'), 'moya****', '범죄도시에서도 눈여겨 봤는데 여기에서도 연기 잘하시더라구요~ 눈에 띄길래 뭔가 낯이 익어 찾아봤더니 역시나.. 범죄도시에서 형사 역할 하셨던~~ㅎㅎ 그때도 참 인상이 오래동안 남았었는데.. 곧 ...', '2019-05-22', '매력 있어요~~', 100, 2);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '하준'), 'pjy9****', '범죄도시라는 영화 자체가주/조연의 구분이 필요 없을 정도로모든 배우가 연기력 탄탄, 재미 탄탄이었어요특히 무섭고 살벌한 분위기의 영화에서홍석은 귀엽고 여린 느낌..?관객과 시선이 같은 입장인...', '2018-02-18', '와 홍석님도 존재가 장난 아녔음', 60, 0);
insert into tblMoviepersonReview(seq, mpseq, id, contents, regdate, title, views, likes) values(seq.nextVal, (select m.seq from tblMoviePerson m where m.name = '하준'), 'flyb****', '2015년, 작년에 열렸던 부산국제영화제에서우연히 양치기들이라는 영화를 보았다.시나리오와 연출도 맘에 들었고주인공 박종환씨의 연기도 매우 좋았지만제일 눈길을 끌었던 배우가 송하준씨였다.양치...', '2016-05-27', '2015년 부산국제영화제에서 양치기를 보고..', 144, 0);


insert into tblFilmcompanyMovie(seq, fseq, mseq, role) values(seq.nextVal, 12, 7, '제작');
insert into tblFilmcompanyMovie(seq, fseq, mseq, role) values(seq.nextVal, 13, 7, '제작');
insert into tblFilmcompanyMovie(seq, fseq, mseq, role) values(seq.nextVal, 14, 7, '제작');
insert into tblFilmcompanyMovie(seq, fseq, mseq, role) values(seq.nextVal, 15, 7, '배급');
insert into tblFilmcompanyMovie(seq, fseq, mseq, role) values(seq.nextVal, 16, 7, '배급');

