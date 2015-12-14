package java8.lambda;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import javax.xml.stream.events.StartDocument;


class User{
	
	String name;

	public User(String name) {
		this.name = name;
	}
	
}

class MyComparator implements Comparator<User>{

	public int compare(User o1, User o2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}


class TestClass implements Runnable{

	public void run() {
		System.out.println(" Inside runnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
		
	}
	
}

interface Test{
	int operate();
}

public class LambdaExample {
	
	
	void sum(Test t){
		
	}
	
	
	public static void main(String args[]) {
		LambdaExample test = new LambdaExample();
		List<User> lst = new LinkedList<User>();	

		lst.add(new User("akkhil"));
		lst.add(new User(" is "));
		lst.add(new User("a"));
		lst.add(new User("--"));
		lst.add(new User("person"));
		
		lst.sort((User n1,User n2) -> compare((n1.name), n2.name));
		
		lst.forEach(n -> System.out.println(n));
		
	}


	private static Object compare(User n1, User n2) {
		// TODO Auto-generated method stub
		return null;
	}

}
  