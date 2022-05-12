-- ex28_oracle_cloud.sql

/*

    오라클 클라우드 서비스
    https://www.oracle.com/kr/cloud/free/
    
    오라클 클라우드에서 수업할 내용 2가지
    - VM(Virtual Machine) 가상 컴퓨터 > 2대까지 > 나중에 웹 수업 > 프로젝트 운영 or 포트폴리오(웹)
    - Oracle Autonomous Database 2개 > 11g > 19c
    
    - 무료 서비스 > 1인 사용 적당, 여러 명 사용은 버벅임
    - 가입할 때 홈 영역은 대한민국 춘천으로 하는 편이 좋다

    
    가상 서버
    - 운영체제 > Ubuntu 20.04 LTS
    - 접속 계정 > "ubuntu" + ""
    
    
    ---------------------------------------------------------------
    
    리눅스-putty 터미널 명령어
    pwd
    - Print working directory
    - 현재 작업중 폴더의 경로
    - /home/ubuntu/ > ubuntu 계정의 홈 디렉토리
    
    
    ls <옵션>
    - List Directory Contents
    - '-a': all. 모든 파일과 디렉토리를 다 출력해라 (숨긴 파일 / 디렉토리)
    - '-l': long. 정보를 상세하게
    ex) ls -a -l
    ex) ls -al
    ex) ls -la
    
    
    clear
    - Clear Screen
    
    
    방향키 (위, 아래)
    - 지금까지 실행했던 명령어의 이력 탐색
    
    
    man <명령어>
    - User's Manual
    
    
    cd
    - change directory
    ex) cd ...
    ex) cd 자식폴더
    - 프롬프트 표시 형식: 계정명@서버이름:현재폴더$
    - 홈디렉토리(~): ubuntu@ubuntu:~$
    ex) cd ~: 홈 디렉토리로 이동
    ex) cd  : 홈 디렉토리로 이동
    ex) cd -: 이전 디렉토리로 이동
    

    free
    - 메모리 상태를 출력
    
    
    date
    - 현재 시각 출력: 초기값 - 우리나라 기준이 X
    
    $ sudo dpkg-reconfigure tzdata
    - 현재 시각 설정하기 (Asia - Seoul 선택)
    - 현재 사용자 > ubuntu
    - 모든 권한을 가진 관리자 > root
    - sudo: 관리자 권한으로 명령어 실행
    

    swap 메모리 설정하기
    1. $ sudo fallocate -l 4G /swapfile
    2. $ sudo chmod 600 /swapfile
    3. $ sudo mkswap /swapfile
    4. $ sudo swapon /swapfile
    5. free 해보면 swap 메모리 설정된 것 확인 가능
    그러나 ubuntu 서버 종료된 후 재실행하면 위 과정 다시 거쳐야 함... > 윈도우의 시작프로그램과 같이 등록하기
    
    
    파일 열기 > 보기 or 편집
    1. cat <파일경로>
        - 파일의 내용을 보여준다
        - 읽기 작업
        - $ cat /etc/fstab
    
    2. 리눅스의 메모장 기능을 하는 프로그램: vi, vim, nano...
        vim 사용법
        1) sudo vim /etc/fstab
        2) i 누르면 insert mode로
        3) /swapfile swap swap defaults 0 0
        4) 나가기 > esc 누르고 :wq


    ----------------------------------------------

    MobaXterm
    - Session > SSH > Advanced SSH Setting > Use private key 탭에서 key 파일 추가, Bookmark setting 탭에서 Session name 설정
    
    쉘
    1. bash
    2. zsh

    Swap
    - 메모리 부족을 보완하기 위해 하드디스크 일부를 메모리처럼 사용하게 해 준다.
    
    붙여넣기
    - Ctrl + V (X)
    - Shift + Insert (O)
    

    ----------------
    
    리눅스에서 패키지(프로그램) 설치하기
    - apt
    - apt-get
    
    
    1. $ sudo apt-get update //현재 시스템의 패키지 상태를 최신 버전으로 업데이트
    2. $ sudo apt-get install nginx //install + 설치하고 싶은 패키지 이름
        : apt-get이 서버에서 패키지를 검색, 알아서 설치해 준다
    3. $ sudo systemctl status nginx //현재 프로그램의 상태(설치되었는지 확인!)
    4. $ sudo systemctl stop nginx   //실행중인 패키지를 중단한다
    5. $ sudo systemctl start nginx  //패키지를 시작한다
    6. $ sudo systemctl enable nginx //서버 시작 시 같이 실행된다.
    7. $ sudo systemctl disable nginx//6의 자동 시작 중지
    
    - 웹 서버 설치하기
    - 위 과정에서 nginx 설치 > 방화벽 열고 ip주소만 알면 접속할 수 있도록 설정
    
    오라클 클라우드에서 방화벽 열기
    - 네트워킹 > 가상 클라우드 네트워크 > vcn-20220504-0931 > 보안 목록 세부정보
    - 수신 규칙 추가, 대상 포트 범위 80
    - 수신 규칙 추가, 대상 포트 범위 443
    
    ubuntu에서 방화벽 열기
    - sudo iptables -I INPUT 1 -p tcp --dport 80 -j ACCEPT
    - sudo iptables -I INPUT 1 -p tcp --dport 443 -j ACCEPT

    - 브라우저 주소창에 내 ip 주소 입력
    - welcome to nginx 페이지 뜨면 설정 성공
    
    
    - welcome to nginx 초기 페이지를 내가 만든 페이지로 바꿔보기!
    - 메모장에서 html 파일 생성 (C:\class\hello.html)
    - 내 컴퓨터 파일 -> 서버로. 파일을 호스트 간에 전송: FTP 프로그램 이용, 웹서버는 보안 강화된 SFTP 이용
    - mobaXterm은 FTP, SFTP 기능도 이미 탑재!
    - mobaXterm에서 session > SFTP > ip주소, username ubuntu 입력하고 key 파일 추가, bookmark setting에서 이름 수정가능
    
    - mobaXterm의 SFTP: Nginx 기본 홈 디렉토리: /var/www/html
    - 콘솔에서 $ sudo chmod -R 777 /var/www/html -> 쓰기 권한 얻기
    
    
*/