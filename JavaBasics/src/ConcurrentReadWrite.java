import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


class Threads implements Runnable{

	HashMap<Integer, String> chm = new HashMap<Integer, String>();
	
	
	int i = 1;
	public void run() {
		for(int j=0;j<5;j++){
		chm.put(j++, "test"+j);
		chm.put(j++, chm.get(j++)+"replace");
		}
		System.out.println(" Map size "+ chm.size()+" thread is "+ Thread.currentThread().getName());
	}
	
	
	
	
}




public class ConcurrentReadWrite {
	
	
	
	
	public static void main(String args[]) {
		
		Threads ts = new Threads();
		
		
		for(int i=0;i<5;i++){
		Thread t = new Thread(ts);
		t.setName(" Thread "+i);
		t.start();
		}
		
	}

}
