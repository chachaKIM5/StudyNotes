package com.test.java.question.Class;

public class Q06 {

	public static void main(String[] args) {
		
		Refrigerator r = new Refrigerator();
		
		Item item1 = new Item();
		item1.setName("김치");
		item1.setExpiration("2022-4-9");
		r.add(item1);

		Item item2 = new Item();
		item2.setName("깍두기");
		item2.setExpiration("2022-4-2");
		r.add(item2);
		
		Item item3 = new Item();
		item3.setName("멸치볶음");
		item3.setExpiration("2022-4-4");
		r.add(item3);
		
		Item item4 = r.get("깍두기");
		System.out.printf("\n%s의 유통기한: %s\n", item4.getName(), item4.getExpiration());
		
		System.out.printf("냉장고 안의 총 아이템 개수: %d개\n", r.count());
		
		r.listItem();
		
	} //main
} //class


class Refrigerator {
	private int itemNum = 0;
	private Item[] items = new Item[100];
	
	
	public void add(Item item) {
		
		if (itemNum == 100) {
			System.out.println("냉장고에 공간이 없습니다.");
			
			return;
		} else {
		
		this.items[itemNum] = item;
		System.out.printf("\'%s\'를 냉장고에 넣었습니다.\n", this.items[itemNum].getName());
		itemNum++;
		}
	}

	public Item get(String name) {

		Item pick = new Item();
		
		for (int i=0 ; i<100 ; i++) {
			if (this.items[i].getName().equals(name)) {

				pick = this.items[i];
				itemNum--;

				this.items[i] = null;
				return pick;
			}
		} return null;
	} 
	
	
	public int count() {
		
		int num = 0;
		for (int i=0 ; i<100 ; i++) {
			if (this.items[i] != null) {
				num++;
			}
		} return num;
	}
	
	public void listItem() {
		
		System.out.println("\n[냉장고 아이템 목록]");
		for (int i=0 ; i<100 ; i++) {
			if (items[i] != null) {
				System.out.printf("%s(%s)\n", this.items[i].getName()
										  , this.items[i].getExpiration());
			}
		}
		
	}
	
	
}


class Item {
	private String name;
	private String expiration;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExpiration() {
		return expiration;
	}
	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}
	
	
}