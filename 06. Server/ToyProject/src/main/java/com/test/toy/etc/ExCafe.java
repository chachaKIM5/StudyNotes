package com.test.toy.etc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ExCafe {

	public static void main(String[] args) {
		
		
		//https://www.banapresso.com/menu의 메뉴 이름, 영문이름, 이미지 주소 DB에 가져오기
		
		String webDriverID = "webdriver.chrome.driver";
		String path = "C:\\class\\chromedriver.exe";
		
		System.setProperty(webDriverID, path);
		
		ChromeOptions options = new ChromeOptions();
		options.setCapability("ignoreProtectedModeSettings", true);
		
		WebDriver driver = new ChromeDriver(options);
		String url = "https://www.banapresso.com/menu";
		driver.get(url);
		
		
	}
}
