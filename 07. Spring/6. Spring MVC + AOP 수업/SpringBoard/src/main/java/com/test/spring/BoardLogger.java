package com.test.spring;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class BoardLogger {

	//모든 페이지 > 로그 기록
	// - 모든 URL
	
	@Pointcut("execution(public * com.test.spring.BoardController.*(..))")
	public void pc1() {
		
	}
	
	@After("pc1()")
	public void log(JoinPoint joinPoint) {
		
		//JoinPoint -> 주업무 add를 실행 중에 보조업무 실행 -> add 메소드의 인자값을 얻어올 수 있다
		//기록 형태: [언제 - 누가] 어떤 URL에 접속?
		//언제: Calendar로 처리
		//누가: Session 필요 - Request에서 얻어올 수 있다
		//URL: Request 필요
		//주 업무의 매개변수에 HttpServletRequest req 모두 추가하기 + HttpSession도 그냥 넣어버리자
		
		//joinPoint.getArgs -> 매개변수를 obj 배열로 받아온다
		
		HttpServletRequest req = null;
		HttpSession session = null;
		
		for (Object obj : joinPoint.getArgs()) {
			
			//obj instanceof HttpServletRequest: obj가 HttpServletRequest의 하위 obj인가? (=형변환 가능한지?)
			if (obj instanceof HttpServletRequest) {
				req = (HttpServletRequest)obj;
				
			} else if (obj instanceof HttpSession) {
				session = (HttpSession)obj;
			}
		}
		
		if (req != null && session != null) {
			
			//[언제 - 누가] URL
			Calendar now = Calendar.getInstance();
			
			System.out.printf("[LOG] [%tF %tT - %s] %s\n"
								, now, now
								, session.getAttribute("auth") != null ? session.getAttribute("auth") : "익명"
								, req.getRequestURI());
		}
		
	}
}
