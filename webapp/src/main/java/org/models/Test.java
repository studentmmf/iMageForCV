package org.models;

public class Test {

	public static void main(String[] args) {
		BaseDAOImpl base = new BaseDAOImpl();
		
		boolean a = base.userExists("Vasya");
		
		System.out.println(a);
		
	}

}
