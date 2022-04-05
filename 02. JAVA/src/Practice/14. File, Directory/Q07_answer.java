package com.test.java.question.File;

import java.io.File;
import java.util.HashSet;
import java.util.Iterator;

public class Q07_answer {

	public static void main(String[] args) {
		
		HashSet<String> musicA = new HashSet<String>();
		HashSet<String> musicB = new HashSet<String>();
		
		File dirA = new File("C:\\class\\java\\파일_디렉토리_문제\\동일 파일\\MusicA");
		File dirB = new File("C:\\class\\java\\파일_디렉토리_문제\\동일 파일\\MusicB");
		
		File[] filesA = dirA.listFiles();
		File[] filesB = dirB.listFiles();
		
		for (File file : filesA) {
			musicA.add(file.getName());
		}
		
		for (File file : filesB) {
			musicB.add(file.getName());
		}
			
			
//		musicA.addAll(musicB);
//		System.out.println(musicA); //합집합
//		
//		musicA.removeAll(musicB);
//		System.out.println(musicA); //차집합
//		
//		musicA.retainAll(musicB);		
//		System.out.println(musicA); //교집합
		
		Iterator<String> iter = musicA.iterator();
		
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		
		
		//TODO 출력
	}
}
