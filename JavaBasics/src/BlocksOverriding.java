


class SuperClass{
	static{
		System.out.println(" Inside super static");
	}
	{
		System.out.println(" Inside super");
	}
	public SuperClass() {
		System.out.println(" Inside super constructor ");
	}
}



class SubClass extends SuperClass{
static{
	System.out.println(" Inside sub static");
	}
	
	{
		System.out.println(" Inside sub");
	}
	
	public SubClass() {
		System.out.println(" Inside sub constructor ");
	}
	
}


public class BlocksOverriding {
	
	  public static void main(String args[]) {
		
		  new SuperClass();
		  
		  new SubClass();
		  
	}
	
	

}
