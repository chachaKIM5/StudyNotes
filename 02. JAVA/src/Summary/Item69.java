package com.test.java;

public class Item69 {

	public static void main(String[] args) {
		
		//[SUMMARY] 표준 API 함수형 인터페이스, 람다식 (2022. 4. 13. 오전 12:49:57)
		
		/*
		 
		 * 표준 API 함수형 인터페이스?
		   : 람다식을 사용하기 위해 JDK에서 제공하는 인터페이스(오직 람다식을 저장하는 용도)
		   
		   
  			1. Consumer (매개변수 O, 반환값 X)
				- (매개변수) -> {구현부}
				
				- Consumer<T>
				- BiConsumer<T,U>
				- andThen
				
				 
			2. Supplier (매개변수 X, 반환값 O)
				- () -> {return 값}
				
				- Supplier<T>
				
				
			3. Function (매개변수 O, 반환값 O)
				- (매개변수) -> {return 값}
			
				- Function<T,R>
				- BiFunction<T,U,R>
				- andThen()
				- compose()
			
			
			4. Operator (동일한 자료형의 매개변수 2개 O, 반환값 O)
				- (매개변수) -> {return 값}
				- 매개변수와 반환값이 자료형 동일
			
				- BinaryOperator
				
				
			5. Predicate (매개변수 O, 반환값(boolean) O)
				- (매개변수) -> {return 값}
				- 반환값이 boolean
				
				- Predicate<T>
				- BiPredicate<T,U>
				- and(), or(), negate()
				- isEqual()
		  
		  
		 */
	}
}
