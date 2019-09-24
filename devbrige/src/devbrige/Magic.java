package devbrige;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Magic {

	    static void isMagic(String num) 
	    { 
	    	List <String> list = new ArrayList<>();
			StringBuilder sb = new StringBuilder(num);
			
			// generate all possible combinations for magic number
			for(int i = 0; i <sb.length(); i++) {
			list.add(sb.toString());
			sb.append(sb.charAt(0)).deleteCharAt(0);
			}
		
			// checking num for magic
			for(int j = 1; j<= num.length(); j++) {
			String result = String.valueOf(j*Integer.valueOf(num));
				list.remove(result);
			}
			if(list.isEmpty()) {
	           System.out.println(num + ": It's magic!\n");     
	        } else {
	        	System.out.println(num + ": It isn't magic...\n"); 
	        }
	  
	    }

	public static void main(String[] args) {
		boolean running = true;
		Scanner sc = new Scanner(System.in);
		
		while(running) {
		System.out.println("Enter a number:\n"
				+ "or\n"
				+ "Press [x] to exit");
	
		String num = sc.nextLine().strip();
		if(num.equals("x")) {
			System.out.println("Good luck!");
			break; 
		}
		try {
			Integer.parseInt(num);
			isMagic(num);
		} catch (Exception e) {
			System.out.println("Wrong input format...\n");
		}
		
		}
		sc.close();	    
	}

}
