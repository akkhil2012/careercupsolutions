package java8.stream;

import java.util.stream.Stream;

class User{
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User(String name) {
		this.name = name;
	}
}


public class StreamSample {
	public static void main(String args[]) {
		
		User u1 = new User("akkhil");
		User u2 = new User("kumar");
		User u3 = new User("gupta");
		
		User[] userArray = {u1,u2,u3};
		
		Stream<User> userStream = Stream.of(userArray);
	   Stream<User> parallelStream = userStream.parallel();
	
	   
		userStream.forEach(d -> System.out.println(d.name));
		
		
		System.out.println(" Parallel stream is "+ parallelStream.count());
		
		
		
	}
}
