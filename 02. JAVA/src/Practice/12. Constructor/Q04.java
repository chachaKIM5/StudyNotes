package com.test.java.question.constructor;

public class Q04 {

	public static void main(String[] args) {
		
	} //main
} //Q04


class Barista {
	
	public Espresso makeEspresso(int bean) {
		Coffee.bean += bean;
		Coffee.espresso += 1;
		Coffee.beanTotalPrice += Coffee.beanUnitPrice * bean;
		Espresso e1 = new Espresso(bean);
		return e1;
		
	}
	
	public Espresso[] makeEspressoes(int bean, int count) {
		
	}
	
	public Latte makeLatte(int bean, int milk) {
		
	}
	
	public Latte[] makeLattes(int bean, int milk, int count) {
		
	}

	public Americano makeAmericano(int bean, int water, int ice) {
		
	}
	
	public Americano[] makeAmericanos(int bean, int water, int ice, int count) {
		
	}
	
	public void result() {
		
	}


}




class Coffee {
	public static int bean;
	public static int water;
	public static int ice;
	public static int milk;
	public static int beanUnitPrice = 1;
	public static double waterUnitPrice = 0.2;
	public static int iceUnitPrice = 3;
	public static int milkUnitPrice = 4;
	public static int beanTotalPrice;
	public static int waterTotalPrice;
	public static int iceTotalPrice;
	public static int milkTotalPrice;
	public static int americano;
	public static int latte;
	public static int espresso;
	
}


class Espresso {
	private int bean;
	
	
	
	public int getBean() {
		return bean;
	}
		
	public void setBean(int bean) {
		this.bean = bean;
	}
	
	
	public void drink() {
		System.out.printf("원두 %dg으로 만들어진 에스프레소를 마십니다.", this.bean);
	}


}


class Latte {
	private int bean;
	private int milk;


	public int getBean() {
		return bean;
	}


	public void setBean(int bean) {
		this.bean = bean;
	}


	public int getMilk() {
		return milk;
	}


	public void setMilk(int milk) {
		this.milk = milk;
	}
	
	
	public void drink() {
		System.out.printf("원두 %dg, 우유 %dml으로 만들어진 라테를 마십니다."
														, this.bean
														, this.milk);
		
	}
}


class Americano {
	private int bean;
	private int water;
	private int ice;
	

	
	public int getBean() {
		return bean;
	}


	public void setBean(int bean) {
		this.bean = bean;
	}


	public int getWater() {
		return water;
	}


	public void setWater(int water) {
		this.water = water;
	}


	public int getIce() {
		return ice;
	}


	public void setIce(int ice) {
		this.ice = ice;
	}


	public void drink() {
		System.out.printf("원두 %dg, 물 %dml, 얼음 %d개로 만들어진 아메리카노를 마십니다."
																, this.bean
																, this.water
																, this.ice);
	}
}


