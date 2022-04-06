package com.test.java.question.FileIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


public class Q07 {
	
	public static HashMap<String, HashMap<String, Integer>> map = new HashMap<String, HashMap<String, Integer>>();

	
	public static void main(String[] args) {
		
		//Calendar 사용 X, 24시간 체계기 때문에 비교연산자로 그냥 계산해도 됨
		//직원들의 지각과 조퇴를 카운트하시오.
		//출근: 오전 9시, 퇴근: 오후 6시
		//C:\class\java\파일_입출력_문제\출결.dat

		
		try {
			
			File file = new File("C:\\class\\java\\파일_입출력_문제\\출결.dat");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			String name;
			boolean Late;
			boolean Early;
			
			while ((line = reader.readLine()) != null) {
				
				String[] data = line.split(",");
				String[] arrive = data[2].split(":");
				String[] leave = data[3].split(":");
				
				name = data[1];
				
				if (Integer.parseInt(arrive[0]) >= 9) {
					Late = true;
				} else {
					Late = false;
				}
				
				
				if (Integer.parseInt(leave[0]) < 18) {
					Early = true;
				} else {
					Early = false;
				}
				
				if (Late) {
					map.put(name, countLate(name));
				}
				
				if (Early) {
					map.put(name, countEarly(name));
				}
				
			}
			
			reader.close();
			
			
			System.out.println("[이름]\t[지각]\t[조퇴]");
			
			Set<String> set = map.keySet();
				
			Iterator<String> iter = set.iterator();
			
			while (iter.hasNext()) {
				
				String key = iter.next();			
				System.out.printf("%s\t%3d회\t%3d회\n", key
										, map.get(key).get("지각")
										, map.get(key).get("조퇴"));
			}
			
		} catch (Exception e) {
			System.out.println("Q07.main");
			e.printStackTrace();
		}	
		
	}

	
	
	
	
	
	
	
	private static HashMap<String, Integer> countEarly(String name) {

		if (!map.containsKey(name)) {
			 	HashMap<String, Integer> temp = new HashMap<String, Integer>();
			 	temp.put("조퇴", 1);
			 	return temp;
		} else {
			map.get(name).put("조퇴", (map.get(name).get("조퇴") == null ? 0 : (map.get(name).get("조퇴") + 1)));
			return map.get(name);
		}
	}

	private static HashMap<String, Integer> countLate(String name) {
		
		if (!map.containsKey(name)) {
			 HashMap<String, Integer> temp = new HashMap<String, Integer>();
			 temp.put("지각", 1);
			 return temp;
		
		} else {
			map.get(name).put("지각", (map.get(name).get("지각") == null ? 0 : (map.get(name).get("지각") + 1)));
			return map.get(name);
		}
	
	
	}

	
	
}
