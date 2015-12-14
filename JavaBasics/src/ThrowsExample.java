import java.io.IOException;
import java.sql.SQLException;


public class ThrowsExample {
	
	public static void main(String args[]){
		
		String number = "123";
		try {
	        if (number.length() > 5) {
	            throw new IllegalArgumentException();
	        }
	        Integer.parseInt(number);

	    } catch (IOException|SQLException e) {
	        e.printStackTrace();
	    }


			
	}

}
