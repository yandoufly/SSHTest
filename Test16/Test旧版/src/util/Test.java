package util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		System.out.println(null==null);
		
//		Set<String> set = new HashSet<String>();
//		
//		set.add("11");
//		set.add("12312312");
//		set.add(null);
//		set.add("1121");
//		set.add("123123");
//		set.add("111111123");
//		set.add(null);
//		
		List<String> list = new ArrayList<String>();
		list.add(null);
		list.add(null);
		list.add(null);
		list.add(null);
		list.add(null);
		list.add(null);
	
		System.out.println(list.size());
		
		while(list.contains(null)){
		list.remove(null);
		}
		

	
		System.out.println(list.size());
//		
//		for(String s:set){
//			System.out.println(s);
//		}
		

		

	}

}
