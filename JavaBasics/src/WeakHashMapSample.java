import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;




class User{
	
	String name;
	int age;
	
	User(String name,int age){
		this.name = name;
		this.age = age;
	}
}



public class WeakHashMapSample {

	
	
	
	
	public static void main(String args[]) {
	
		Map<User,String> whashMap = new WeakHashMap<User,String>();
		
		Map<User,String> hashMap = new HashMap<User,String>();
		
		User user = new User("Akkhil",1);
		User user2 = new User("Kumar",2);
		User user3 = new User("gupta",3);
		
		whashMap.put(user, "first");
		whashMap.put(user2, "sec");
		whashMap.put(user3, "third");
		
		hashMap.put(user, "first");
		hashMap.put(user2, "sec");
		hashMap.put(user3, "third");

		user = null;
	//	user2 = null;
	//	user3 = null;
		
		
		whashMap = null;
		hashMap = null;
		
		
		System.gc();
		
		
		if(hashMap.size()!=0){
			System.out.println(" Not yet GC "+ hashMap.size());
		}else{
			System.out.println(" GC after  "+ hashMap.size());
			
		
		
		}
		
		
		
		
		
	}
	
	
}
