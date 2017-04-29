package dao;

import java.lang.reflect.Method;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//求QuestionDao类中有哪些方法
		Method[] m = QuestionDao.class.getDeclaredMethods();
		
		for(Method method:m){
			System.out.println(method.getName());
		}
		
	}

}
