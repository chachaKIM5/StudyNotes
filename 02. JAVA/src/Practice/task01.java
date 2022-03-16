package com.test.java;

public class task01 {

	public static void main(String[] args) {
		
		
		//자료형 + 변수 + 리터럴 + 출력 연습
		
				//1. 정수형: byte
					System.out.println("1. 정수형: byte 연습\r");
					
					//1)
					byte family = 4;
					System.out.println("우리 가족은 " + family + "명입니다.");
					
					//2)
					byte classmate = 30;
					System.out.println("우리 반은 " + classmate + "명입니다.");
				
					//3)
					byte floor = 25;
					System.out.println("이 건물은 " + floor + "층입니다.");
				
					//4)
					byte month = 3;
					byte date = 7;
					System.out.println("오늘은 " + month + "월 " + date + "일입니다.");
					
					//5)
					byte apple = 2;
					byte melon = 3;
					System.out.println("과일은 총 " + (apple + melon) + "개 있습니다.");
					
					//6) 
					byte temperatureYesterday = 3;
					byte temperatureToday = 6;
					System.out.println("오늘 기온은 어제보다 " + (temperatureToday - temperatureYesterday) + "도 높습니다.");

					//7)
					byte battery = 50;
					System.out.println("배터리가 " + battery + "% 남았습니다.");
					
					//8)
					byte age = 27;
					System.out.println("김승연: \"저는 " + age +"살입니다.\"");
					
					//9)
					byte day = 3;
					System.out.println("\'수업 " + day + "일차 어렵지만 재미있다!\'");
					
					//10)
					byte box = 12;
					byte stock = 5;
					System.out.println("창고에 재고가 " + (stock * box) + "개 남아 있어요.");
					
					System.out.println("");
					System.out.println("");
				
					
				//2. 정수형: short
					System.out.println("2. 정수형: short 연습\r");
					
					//1)
					short height = 167;
					System.out.println("제 키는 " + height + "cm입니다.");
					
					//2)
					short mountainHeight = 170 ;
					System.out.println("부천 원미산의 해발고도는 약 " + mountainHeight + "m입니다.");
					
					//3)
					short year = 2022;
					System.out.println("지금은 " + year + "년입니다.");
					
					//4)
					short wage = 9160;
					System.out.println(year + "년 최저임금은 " + wage + "원입니다.");
					
					//5
					short birthyear = 1996;
					System.out.println("저는 " + birthyear + "년에 태어났습니다.");
					
					//6
					System.out.println("저는 " + (year - birthyear + 1) + "살입니다.");
					
					//7)
					short calorieOfBread = 114;
					byte bread = 2;
					System.out.println("오늘 아침에 " + (bread * calorieOfBread) + "kcal를 먹었다.");

					//8)
					short capacity = 256;
					short usedCapacity = 120;
					System.out.println("남은 저장 공간은 " + (capacity - usedCapacity) + "GB입니다.");
				
					//9)
					short fee = 500;
					System.out.println("서비스 수수료는 " + fee + "원입니다.");
					
					//10)
					short price = 10000;
					short shippingFee = 2500;
					short quantity = 2;
					System.out.println(quantity + "개 구매하시면 " + (price * quantity + shippingFee) + "원입니다.");
					
					System.out.println("");
					System.out.println("");
					
					
				//3. 정수형: int
					System.out.println("3. 정수형: int 연습\r");
					
					//1)
					int price2 = 45000;
					System.out.println("이 옷은 " + price2 + "원입니다.");
					
					//2)
					int price3 = 100000;
					System.out.println("이 가방은 " + price3 + "원입니다.");

					//3) 
					int saving = 150000;
					System.out.println("한 달에 " + saving + "원씩 저금해야지!");

					//4)
					int population = 50000000;
					System.out.println("대한민국 인구는 약 " + population + "명이다.");
					
					//5)
					int price4 = 380000;
					int price5 = 60000;
					System.out.println("게임기와 게임팩을 사는 데 " + (price4 + price5) + "원을 썼다.");

					//6)
					int earth = 40000;
					System.out.println("지구의 둘레는 약 " + earth + "km이다.");

					//7)
					int covid19 = 210716;
					System.out.println("오늘 코로나 확진자 수는 " + covid19 + "명입니다.");
					
					//8)
					int total = 4456261;
					System.out.println("누적 확진자 수는 " + (total + covid19) + "명입니다.");
					
					//9)
					int vaccine = 31802879;
					System.out.println("백신 3차 접종자 수는 누적 " + vaccine + "명입니다.");
					
					//10) 
					int salary = 515200;
					System.out.println("이번 달 아르바이트 월급은 " + salary + "원이다.");
					
					System.out.println("");	
					System.out.println("");	

					
				//4. 정수형: long
					System.out.println("4. 정수형: long 연습\r");
				
					//1)
					long worldPopulation = 7953952577L;
					System.out.println("세계 인구 수는 " + worldPopulation + "명입니다.");
					
					//2)
					long worldPopulation2 = 9800000000L;
					System.out.println("2050년 세계 인구 수는 약 " + worldPopulation2 + "명으로 예상됩니다.");
					
					//3)
					long Max = Long.MAX_VALUE;
					System.out.println("long 자료형의 최댓값은 " + Max + "입니다.");
					
					//4)
					long Min = Long.MIN_VALUE;
					System.out.println("long 자료형의 최솟값은 " + Min + "입니다.");

					//5) 
					long credit = Max;
					System.out.println("통장 잔고가 " + credit + "원으로 늘어나는 꿈을 꿨다.");
					
					//6)
					long money = 200000000000L;
					System.out.println("그는 자산 " + money + "원의 사업가다.");
								
					//7)
					long money2 = 4003909023L;
					System.out.println("그는 통장에 " + money2 + "원이 있다.");
					
					//8)
					long sales = 50000000000L;
					System.out.println("그 회사의 작년 매출은 약 " + sales + "원이다.");
					
					//9)
					long korGdp = 1910745000000000L;
					System.out.println((year - 1) + "년 우리나라 실질 GDP는 " + korGdp + "원입니다.");
						
					//10)
					long lotto1995 = 24734392128L;
					System.out.println("이번 회차 로또 당첨금은 " + lotto1995 + "원입니다.");
		 
					System.out.println("");
					System.out.println("");
					

				//5. 실수형: float
					System.out.println("5. 실수형: float 연습\r");
					
					//1)
					float pi = 3.14F;
					System.out.println("원주율은 " + pi + "입니다.");
					
					//2)
					float width = 31.5F;
					System.out.println("길이는 " + width + "cm입니다.");
					
					//3)
					float width2 = 50.5F;
					System.out.println("이 옷의 가슴너비는 " + width2 + "cm입니다.");

					//4)
					float temperatureF = 33.8F;
					System.out.println("섭씨 1도는 화씨 " + temperatureF + "도입니다.");
							
					//5)
					float weight = 6.8F;
					System.out.println("이 강아지는 " + weight + "kg입니다.");
					
					//6)
					float weight2 = 1.5F;
					System.out.println("이 노트북은 " + weight2 + "kg입니다.");
					
					//7)
					float average = 88.25F;
					System.out.println("평균 점수는 " + average + "점입니다.");

					//8)
					float turnout = 36.9F;
					System.out.println("이번 대선 사전 투표율은 " + turnout + "%입니다.");
					
					//9)
					float discount = 12.5F;
					System.out.println("할인율은 " + discount + "%입니다.");
					
					//10)
					float temperatureC = 5.5F;
					System.out.println("섭씨 " + temperatureC + "도는 화씨 " + (temperatureC * temperatureF) + "도입니다.");
					
					System.out.println("");
					System.out.println("");

					
				//6. 실수형: double
					System.out.println("6. 실수형: double 연습\r");
					
					//1)
					double pi2 = 3.14159265358979323846264338327D;
					System.out.println("원주율을 계속해서 계산하면 " + pi2 + "...이다.");
					
					//2)
					double div = 0.3333333333333333333333333333D;
					System.out.println("1을 3으로 나누면 " + div + "...이다.");
					
					//3)
					double div2 = 1.1111111111111111D;
					System.out.println("10을 9로 나누면 " + div2 + "...이다.");
					
					//4)
					double route2 = 1.41421356237309504880D;
					System.out.println("루트 2의 값은 " + route2 + "...이다.");
					
					//5)
					double width3 = 31.66666666666666666666666D;
					System.out.println("길이는 약 " + width3 + "cm입니다.");
					
					//6)
					double weight5 = 5.98872302359D;
					System.out.println("무게는 약 " + weight5 + "g입니다.");
								
					//7)
					double p1 = 1.3205239325D;
					System.out.println("성분이 약 " + p1 + "% 함유되어 있다.");
					
					//8)
					double p2 = 0.0000005D;
					System.out.println("유해물질이 약 " + p2 + "% 검출되었다.");
					
					//9)
					double p3 = 0.000009732D;
					System.out.println("당첨 확률은 약 " + p3 + "%입니다.");
					
					//10
					double p4 = 99.999999999999D;
					System.out.println("우리 팀이 이길 확률은 " + p4 + "%야.");
					
					System.out.println("");
					System.out.println("");
					
					
				//7. 문자형: char
					System.out.println("7. 문자형: char 연습\r");
					char grade1 = 'A';
					char grade2 = 'B';
					char grade3 = 'C';
					char grade4 = 'D';
					char grade5 = 'E';
					
					//1)
					System.out.println("국어 성적은 " + grade1 + "등급입니다.");
					
					//2)
					System.out.println("수학 성적은 " + grade2 + "등급입니다.");
					
					//3)
					System.out.println("영어 성적은 " + grade3 + "등급입니다.");
					
					//4)
					System.out.println("과학 성적은 " + grade4 + "등급입니다.");
					
					//5)
					System.out.println("체육 성적은 " + grade5 + "등급입니다.");
					
					//6)
					char lastName1 = '김';
					System.out.println("우리나라에 가장 많은 성씨는 " + lastName1 + "씨입니다.");
					
					//7)
					char lastName2 = '최';
					System.out.println("아버지는 " + lastName1 + "씨, 어머니는 " + lastName2 + "씨입니다.");
					
					//8)
					char atSign = '@';
					System.out.println("이메일 주소는 aaaaaa" + atSign + "gmail.com입니다." );
					
					//9)
					char num = '9';
					System.out.println("한 자리 수 숫자 중 가장 큰 것은 " + num + "입니다.");

					//10)
					char star = '☆';
					System.out.println("별표 특수문자는 " + star + "입니다.");
					
					System.out.println("");
					System.out.println("");

					
				//8. 논리형: boolean
					System.out.println("8. 논리형: boolean 연습\r");
					
					//1)
					boolean flag1 = true;
					System.out.println("1은 홀수다.: " + flag1);

					//2)
					boolean flag2 = false;
					System.out.println("2는 홀수다. : " + flag2);
					
					//3)
					boolean flag3 = true;
					System.out.println("1+1은 2이다.: " + flag3);

					//4)
					boolean flag4 = false;
					System.out.println("2+2는 3이다.: " + flag4);
					
					//5)
					boolean flag5 = true;
					System.out.println("10-9는 1이다.: " + flag5);
					
					//6)
					boolean flag6 = false;
					System.out.println("5+5는 11이다.: " + flag6);
					
					//7)
					boolean flag7 = true;
					System.out.println("9x9는 81이다.: " + flag7);
					
					//8)
					boolean flag8 = false;
					System.out.println("3.5는 정수다.: " + flag8);
					
					//9)
					boolean flag9 = true;
					System.out.println("10은 자연수다.: " + flag9);
					
					//10)
					boolean flag10 = false;
					System.out.println("50은 홀수다.: " + flag10);
				
					System.out.println("");
					System.out.println("");

					
				//9. 참조형 > 문자열 String
					System.out.println("9. 참조형: 문자열 String 연습\r");
					
					//1)
					String introduce1 = "안녕하세요? ";
					System.out.println(introduce1);
					
					//2)
					String introduce2 = "김승연입니다. ";
					System.out.println(introduce2);
					
					//3)
					String introduce3 = "잘 부탁드립니다. ";
					System.out.println(introduce1 + introduce2 + introduce3);
					
					//4)
					String name = "김승연";
					System.out.println("안녕하세요, \'" + name + "\'입니다.");
					
					//5)
					String birth = "960506";
					System.out.println("제 생일은 \'" + birth + "\'입니다."); 
					
					//6)
					String male = "남자";
					String female = "여자";
					System.out.println("저는 " + female + "입니다.");
					
					//7)
					String hobby = "게임";
					System.out.println("저는 " + hobby + "를(을) 좋아합니다.");
					
					//8)
					String path = "C:\\class\\java";
					System.out.println("수업 파일 저장 경로는 " + path + "입니다.");
					
					//9)
					String introduce4 = "Hello";
					System.out.println("\"" + introduce4 + "\"");
					
					//10)
					String introduce5 = "Nice to meet you";
					System.out.println("\"" + introduce5 + "\"");
					
					
							
		
	}
	
}
