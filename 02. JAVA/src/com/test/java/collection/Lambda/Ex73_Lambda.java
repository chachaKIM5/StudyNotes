package com.test.java.collection.Lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Ex73_Lambda {

	public static void main(String[] args) {
		
		//Ex73_Lambda.java
		
		//익명 객체 활용하는 곳 > 람다식 활용하는 곳
		
		Random rnd = new Random();
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		for(int i=0 ; i<10 ; i++) {
			nums.add(rnd.nextInt(20) + 1);
		}
		
		System.out.println(nums);
		
		
		//오름차순 정렬
		nums.sort(new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		
		System.out.println(nums);
		
		
		//위 익명 객체를 단 한 줄로...?! 내림차순 정렬
		nums.sort((o1, o2) -> o2 - o1);
		System.out.println(nums);
		
		
		
		
//		예제] com.test.java\\data\\user.txt 정렬하기
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("data\\user.txt"));
			
			ArrayList<User> list = new ArrayList<User>();
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				String[] ctemp = temp[4].split("-"); //2022-01-01
				
				Calendar c = Calendar.getInstance();
				c.set(Integer.parseInt(ctemp[0]), Integer.parseInt(ctemp[1])
												, Integer.parseInt(ctemp[2]));
				
				User user = new User(temp[0]
									, temp[1]
									, Integer.parseInt(temp[2])
									, temp[3]
									, c);
				
				list.add(user);
			}
			
			System.out.println(list);
			
			
			//8개의 객체 > 정렬!
			  Collections.sort(nums); //ArrayList<Integer>	정렬 가능
			//Collections.sort(list); //ArrayList<User>		정렬 불가능? User의 어떤 특성으로 정렬해야 할지 모르니까
			
			//Comparator로 객체의 '나이'를 기준으로 정렬해보자
			  
			  //나이 오름차순
			  list.sort(new Comparator<User>() {
				  
				  public int compare(User o1, User o2) {
					  
					  return o1.getAge() - o2.getAge();
				  }
			  });
			  
			  System.out.println(list);
			  
			  
			  //나이 내림차순
			  list.sort((o1, o2) -> o2.getAge() - o1.getAge());
			  System.out.println(list);
			  
			  
			  
			  //이름 오름차순
			  list.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
			  System.out.println(list);
			
			  
			  
			  //날짜 오름차순
			  list.sort((o1, o2) -> o1.getHireDate().compareTo(o2.getHireDate()));
			  System.out.println(list);
			  
			  
			  //직급 순으로는 어떻게 정렬할까? 직급 내림차순 (부장 > 차장 > 과장 > 대리 > 사원)
			  //규칙성이 없을 경우 Comparator를 직접 구현... 노가다...!
			  list.sort((o1, o2) -> {
				  
				  if (o1.getPosition().equals("부장") && o2.getPosition().equals("차장")) {
					  return -1;
				  } else if (o1.getPosition().equals("부장") && o2.getPosition().equals("과장")) {
					  return -1;
				  } else if (o1.getPosition().equals("부장") && o2.getPosition().equals("대리")) {
					  return -1;
				  } else if (o1.getPosition().equals("부장") && o2.getPosition().equals("사원")) {
					  return -1;
				  } else if (o1.getPosition().equals("차장") && o2.getPosition().equals("부장")) {
					  return 1;
				  } else if (o1.getPosition().equals("차장") && o2.getPosition().equals("과장")) {
					  return -1;
				  } else if (o1.getPosition().equals("차장") && o2.getPosition().equals("대리")) {
					  return -1;
				  } else if (o1.getPosition().equals("차장") && o2.getPosition().equals("사원")) {
					  return -1;
				  } else if (o1.getPosition().equals("과장") && o2.getPosition().equals("부장")) {					  
					  return 1;
				  } else if (o1.getPosition().equals("과장") && o2.getPosition().equals("차장")) {					  
					  return 1;
				  } else if (o1.getPosition().equals("과장") && o2.getPosition().equals("대리")) {					  
					  return -1;
				  } else if (o1.getPosition().equals("과장") && o2.getPosition().equals("사원")) {					  
					  return -1;
				  } else if (o1.getPosition().equals("대리") && o2.getPosition().equals("부장")) {			
					  return 1;
				  } else if (o1.getPosition().equals("대리") && o2.getPosition().equals("차장")) {					  
					  return 1;
				  } else if (o1.getPosition().equals("대리") && o2.getPosition().equals("과장")) {					  
					  return 1;
				  } else if (o1.getPosition().equals("대리") && o2.getPosition().equals("사원")) {					  
					  return -1;
				  } else if (o1.getPosition().equals("사원") && o2.getPosition().equals("부장")) {
					  return 1;
				  } else if (o1.getPosition().equals("사원") && o2.getPosition().equals("차장")) {
					  return 1;
				  } else if (o1.getPosition().equals("사원") && o2.getPosition().equals("과장")) {
					  return 1;
				  } else if (o1.getPosition().equals("사원") && o2.getPosition().equals("대리")) {
					  return 1;
				  } else {
					  return 0;
				  }});
			  		
			  
			  System.out.println(list);
			  
			  
		} catch (Exception e) {
			System.out.println("Ex73_Lambda.main");
			e.printStackTrace();
		}
		
		
	} //main
}


//1,홍길동,25,사원,2011-02-05
class User {
	
	private String seq; 
	private String name; 
	private int age; 
	private String position; 
	private Calendar hireDate; 

	public User(String seq, String name, int age, String position, Calendar hireDate) {
		super();
		this.seq = seq;
		this.name = name;
		this.age = age;
		this.position = position;
		this.hireDate = hireDate;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Calendar getHireDate() {
		return hireDate;
	}

	public void setHireDate(Calendar hireDate) {
		this.hireDate = hireDate;
	}

	@Override
	public String toString() {
		return String.format("User [seq=%s, name=%s, age=%s, position=%s, hireDate=%tF]\n", seq, name,
				age, position, hireDate);
	}

	

	
	
}