

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		
		while(true) {
		String input = br.readLine();
		if(input.equals("end")) {
			System.out.println(sb.toString());
			return;
		}

		boolean result= check(input);
		
		sb.append("<").append(input).append(">").append(" is ");
		if(result) {
			
		}
		else {
			sb.append("not ");
		}
		sb.append("acceptable.\n");
		
		}
		
		
		
		
		
	}

	private static boolean check(String input) {
		
		
		//System.out.println(input+" start");
		int bit= (1<<3);// 1bit: aeiou check,2bit: combocheck ,3 bit: same check
		// 1,0,0 = true bit 
		int size=input.length();
		
		char memory='?';
		int is_vowel=0;
		int is_not_vowel=0;
		
		for(int s=0;s<size;s++) {
			
		char element= input.charAt(s);
		
		//System.out.println(element+" currvo= "+is_vowel+" currnotvo "+is_not_vowel+" s= "+s);

		
		
		
		if(element=='a'||element=='e'||element=='o'||element=='i'||element=='u') {
				is_not_vowel=0;
				if(bit<((1<<3)|(1<<2))) {
					bit=bit|(1<<2);
					
				}
				if(is_vowel<2) {
					is_vowel++;
				}
				else {
					//System.out.println("1");
					return false;
				}
				
			}// 모음 체크 및 모음콤보 기록 
			else {
				is_vowel=0;
				if(is_not_vowel<2) {
					is_not_vowel++;
				}
				else {
					//System.out.println("2"+" "+is_not_vowel);
					return false;
				}
				
			}// 자음 콤보 3개 체크 
			
			
			if(memory==element) {
				
				if(element=='e'|| element=='o') {
					
					continue;
					
				}
				else {
					//System.out.println("3");
					return false;
				}
				
			}
			
			
			
			
			memory=element;
			
		}// for end 
		
		
		//System.out.println("END");
		
		
		
		
		if(bit==((1<<3)|(1<<2))){
			
			return true;
		}
		
		
		return false;
	}

}
