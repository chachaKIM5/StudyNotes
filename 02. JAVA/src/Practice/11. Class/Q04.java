package com.test.java.question.Class;

public class Q04 {

	public static void main(String[] args) {
		
		
		Employee e1 = new Employee();
		
		e1.setName("홍길동");
		e1.setDepartment("홍보부");
		e1.setPosition("부장");
		e1.setTel("010-1234-5678");
		e1.setBoss(null);
		
		e1.info();
		
		
		Employee e2 = new Employee();
		
		e2.setName("아무개");
		e2.setDepartment("홍보부");
		e2.setPosition("사원");
		e2.setTel("010-2541-8569");
		e2.setBoss(e1);
		
		e2.info();
		
		
	}//main
}//class



class Employee {
	
	private String name;
	private String department;
	private String position;
	private String tel;
	private Employee boss;
	
	
	
	public String getName() {
		return name;
	}
	
	private boolean checkName(String name) {
		
		if (name.length() < 2 || name.length() > 5) {
			return false;
		}
		
		for (int i=0 ; i<name.length() ; i++) {
			if (name.charAt(i) < '가' || name.charAt(i) > '힣') {
				return false;
			}
		}
				
		return true;
	}
	
	public void setName(String name) {
		if (checkName(name)) {
			this.name = name;
		} else {
			System.out.println("이름 형식이 올바르지 않습니다.");
		}
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		if (department.equals("영업부") || department.equals("기획부") ||
			department.equals("총무부") || department.equals("총무부") ||
			department.equals("홍보부")) {
		
			this.department = department;
		}
	}	
	
	public String getPosition() {
		return position;
	}
	
	public void setPosition(String position) {
		if (position.equals("부장") || position.equals("과장") ||
			position.equals("대리") || position.equals("사원")) {
			
			this.position = position;
		}
	}

	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		if (tel.substring(3, 4).equals("-") && tel.substring(8, 9).equals("-")
			&& tel.startsWith("010")) {
			
			this.tel = tel;
			
		} else {
			
			System.out.println("연락처 형식이 올바르지 않습니다.");
		}
	}
	
	
	public Employee getBoss() {
		return boss;
	}
	
	public void setBoss(Employee boss) {
		if (boss == null) {
			this.boss = null;
		} else if (boss.department.equals(this.department)) {
			this.boss = boss;
		}
	}
	

	public void info() {
		
		System.out.printf("[%s]\n", this.name);
		System.out.printf("- 부서: %s\n", this.department);
		System.out.printf("- 직위: %s\n", this.position);
		System.out.printf("- 연락처: %s\n", this.tel);
		
		if (this.boss == null) {
			System.out.printf("- 직속상사: 없음\n\n");
		} else {
			System.out.printf("- 직속상사: %s(%s %s)\n", this.boss.name
												   , this.boss.department
												   , this.boss.position);

		}
	}	
}
