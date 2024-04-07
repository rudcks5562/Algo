

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	
	
	public static long N,P,Q;
	public static HashMap<Long , Long> map= new HashMap<Long, Long>();
	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		
		N= sc.nextLong();
		P= sc.nextLong();
		Q= sc.nextLong();
		
		
		map.put(0L, 1L);
		
		
		Function(N);
		
		System.out.println(map.get(N));
		
		
		
		
		

	}
	
	private static long Function(long n2) {
		
		if(map.containsKey(n2)) {
			return map.get(n2);
		}
		
		long one= Function( Get_Gauss(n2,P));
		long two= Function(Get_Gauss(n2, Q));
		
			
		map.put(n2, one+two);
		
		return one+two;
		
	}

	public static long Get_Gauss(long i,long backward) {
		
		
		long res= (long) Math.floor(i/backward);
		return res;
		
	}
	
	
	
	
	

}
