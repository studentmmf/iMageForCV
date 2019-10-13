package org.models;

public class Test {

	public static void main(String[] args) {
		BaseDAOImpl base = new BaseDAOImpl();
		//User user = new User("Vasya", "123");
		//base.save(user);
		//String str = base.findPasswordByLogin("Vasyaa");
		boolean a = base.userExists("Vasya");
		//User a = base.findUserById(1);
		//System.out.println(str);
		System.out.println(a);
		//base.updatePassword("Vasya", "321");
	}

}
