import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class ReferenceType {
	
	public void test(){
		
		try {
			this.finalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	public static void getCount(int n) /* throws ArithmeticException */{
		Object div = new Object();
		WeakReference<Object> wref = new WeakReference<Object>(div);
		if (wref.get() != null) {
			System.out.println("  Before reclaiming memory ");
			System.gc();
		} else {
			System.out.println(" Weak Reference alread collected");
		}

		Object divSoft = new Object();
		SoftReference<Object> sref = new SoftReference<Object>(divSoft);

		if (sref.get() != null) {
			System.out.println("  Before reclaiming memory: SoftREference ");
			System.gc();
		} else {
			System.out.println(" Weak Reference alread collected");
		}


	}
	
	
	
	
	
	
	
	
	
	
	
	

	public static void main(String args[]) {

		try {
			getCount(10);
			
			new ReferenceType().test();
		} catch (Exception e) {
			System.out.println(" Arithmetic ");
		}

	}

}
