-- ex09_numerical_function.sql


/*

    숫자 함수(=수학 함수)
    - 자바의 Math 클래스 역할
    
    
    round()
    - 반올림 함수
    - number round(컬럼명)

*/


select
    height / weight,
    round(height / weight),
    round(height / weight, 1),
    round(height / weight, 2),
    round(height / weight, 3),
    round(height / weight, 0)
from tblComedian;

select round(avg(basicpay)) from tblInsa;



/*

    floor(), trunc()
    - 절삭 함수
    - 무조건 내림 함수
    - number floor(컬럼명)
    - number trunc(컬럼명 [, 소수이하자릿수])
    
*/


select 
    height / weight,
    round(height / weight),
    floor(height / weight),
    trunc(height / weight, 1),
    trunc(height / weight, 2)
from tblComedian;






/*

    ceil()
    - 무조건 올림 함수
    - number ceil(컬럼명)

*/

select
    height / weight,
    round(height / weight),
    floor(height / weight),
    ceil(height / weight)
from tblComedian;


-- 시스템 테이블
select * from dual; -- 1행 1열 테이블

select 100 + 100 from tblComedian;
select 100 + 100 from tblInsa;
select 100 + 100 from dual;

select sysdate from tblInsa;
select sysdate from dual;

select
    floor(9.9999999999999999999999999),
    ceil(9.00000000000000000000000001)
from dual;




/*

    mod()
    - 나머지 함수
    - number mod(피제수, 제수)

*/


select
    10 / 3,
    floor(10 / 3) as "몫",
    mod(10, 3) as "나머지"
from dual;


select
    abs(10),
    abs(-10), --절대값 함수
    power(2, 2), --제곱 함수
    power(2, 3),
    power(2, 4),
    sqrt(4),
    sqrt(16),
    sqrt(64)
from dual;