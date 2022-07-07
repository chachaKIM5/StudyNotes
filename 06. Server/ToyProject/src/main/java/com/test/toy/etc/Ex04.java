package com.test.toy.etc;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ex04 {

	public static void main(String[] args) throws Exception {
		
		/*
		  
		  	Jsoup 방식
		  	- 인증이 불필요한 페이지에서 사용 가능
		  	- 인증이 필요한 페이지에서 사용? 아예 불가능은 아니지만... 고비용, 잘 사용 X
		  	- JavaScript 실행이 필요한 페이지에서 사용 불가능 > Ajax 페이지
		  	
		  	
		  	웹 응용 프로그램 자동화 프로그램
		  	- 셀레니움
		  	- 사람 대신에 프로그램이 사람처럼 웹 사이트에 방문해서 여러가지 행동을 하는 프로그램
		  	- 크롤링 작업도 가능
		  	- 인증이 필요한 페이지에서 사용 가능
		  	- JavaScript 실행이 필요한 페이지에서 사용 가능
		  	- 준비물 > 드라이버 > 브라우저 종류 + 버전마다 다름
		
		 */
		
		//m1();
		//m2();
		m3();
		
	}//main


	private static void m3() {
		String webDriverID = "webdriver.chrome.driver";
		String path = "C:\\class\\chromedriver.exe";
		
		System.setProperty(webDriverID, path);
		
		//client-combined-3.141.59.jar
		ChromeOptions options = new ChromeOptions();
		options.setCapability("ignoreProtectedModeSettings", true);
		
		
		//브라우저 + 사람
		WebDriver driver = new ChromeDriver(options);
		
		String url = "http://lms1.sist.co.kr/worknet/SLogin.asp";
		driver.get(url);
		
		WebElement id = driver.findElement(By.id("strLoginID"));
		id.sendKeys("김승연");
		
		WebElement pwd = driver.findElement(By.id("strLoginPwd"));
		pwd.sendKeys("1321");
		
		WebElement btn = driver.findElement(By.cssSelector(".login-btn > input"));
		btn.click();
		
		try {
			
			WebElement eID = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#content tr:nth-child(5) > td:nth-child(2)")));
			
			System.out.println("나의 교육 기간: " + eID.getText());
			
		} catch (Exception e) {
			System.out.println("> 오류 발생 + " + e.toString());
		}
		
		
		
		
	}

	private static void m2() {
		
		String webDriverID = "webdriver.chrome.driver";
		String path = "C:\\class\\chromedriver.exe";
		
		System.setProperty(webDriverID, path);
		
		//client-combined-3.141.59.jar
		ChromeOptions options = new ChromeOptions();
		options.setCapability("ignoreProtectedModeSettings", true);
		
		
		//브라우저 + 사람
		WebDriver driver = new ChromeDriver(options);
		
		String url = "http://localhost:8090/toy/etc/expage.do";
		driver.get(url);
		
		WebElement name = driver.findElement(By.id("name"));
		System.out.println(name.getText());
		
	}

	private static void m1() throws Exception {
		
		String url = "http://localhost:8090/toy/etc/expage.do";
		
		Document doc = Jsoup.connect(url).get();
		
		Element span = doc.selectFirst("body > main > section > div > span");
		System.out.println(span.text());
		
		Element span2 = doc.selectFirst("#name");
		System.out.println(span2.text());
	}
	
	
	
}
