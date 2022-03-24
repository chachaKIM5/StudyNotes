package com.test.java.question.Class;

public class Q01 {
	
	public static void main(String[] args) {
		
		
		Book b1 = new Book();
		
		b1.setTitle("자바의 정석");
		b1.setPrice(45000);
		b1.setAuthor("남궁성");
		b1.setPublisher("도우출판");
		b1.setIsbn("8994492038"); 
		b1.setPage(1022);
		
		System.out.println(b1.info());
		
		
	}
}


class Book {
	
	private String title;
	private int price;
	private String author;
	private String publisher;
	private String pubYear = "2019";
	private String isbn;
	private int page;
	
	
	
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		
		if (checkTitle(title)) {
			this.title = title;
		} else {
			System.out.println("올바르지 않은 제목입니다.");
		}
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		
		if (price >= 0 && price <=1000000) {
			this.price = price;			
		} else {
			System.out.println("올바르지 않은 가격입니다.");
		}
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPubYear() {
		return pubYear;
	}

	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		if (page >= 1) {
			this.page = page;
		} else {
			System.out.println("올바르지 않은 페이지수입니다.");
		}
	}
	
	
	
	private boolean checkTitle(String title) {
		
		
		if (title.length() <= 50) {
		
			for (int i=0 ; i<title.length() ; i++) {
				
				char c = title.charAt(i);
				
				if ((c < '가' || c > '힣')
						&& (c < 'a' || c > 'z')
						&& (c < 'A' || c > 'Z')
						&& (c < '0' || c > '9')
						&& (c != ' ' )) {
					
					return false;
				} 
			}	
		}
		
		return true;

		
	}
	
	
	public String info() {
		

		String result = String.format("제목: %s\n", this.title)
						+ String.format("가격: %d\n", this.price)
						+ String.format("저자: %s\n", this.author)
						+ String.format("출판사: %s\n", this.publisher)
						+ String.format("발행년도: %s\n", this.pubYear)
						+ String.format("isbn: %s\n", this.isbn)
						+ String.format("페이지: %,d\n", this.page);
		
		return result;
		
	}

} //class Book

