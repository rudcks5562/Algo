

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static int T;
	public static int A_size;
	public static int B_size;
	
	public static int input_a[];
	public static int input_b[];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input= br.readLine();
		
		
		T= Integer.parseInt(input);
		
		
		A_size= Integer.parseInt(br.readLine());
		input_a= new int[A_size];
		input = br.readLine();
		StringTokenizer st= new StringTokenizer(input);
		
		for(int s=0;s<A_size;s++) {
			
			input_a[s]= Integer.parseInt(st.nextToken());
			
			
		}
		
		ArrayList<Long> a_list= new ArrayList<>();
		
		
		for(int s=0;s<A_size;s++) {
			
			long sum=0;
			
			for(int z=s;z<A_size;z++) {
				
				sum+= input_a[z];
				a_list.add(sum);
			}
		}// for end 
		
		B_size= Integer.parseInt(br.readLine());
		input_b= new int[B_size];
		input = br.readLine();
		 st= new StringTokenizer(input);
		
		for(int s=0;s<B_size;s++) {
			
			input_b[s]= Integer.parseInt(st.nextToken());
			
			
		}
		
		ArrayList<Long> b_list= new ArrayList<>();
		
		
		for(int s=0;s<B_size;s++) {
			
			long sum=0;
			
			for(int z=s;z<B_size;z++) {
				
				sum+= input_b[z];
				b_list.add(sum);
			}
		}// for end 
		
		
		
		
		Collections.sort(a_list);
		Collections.sort(b_list);
		
		int point_a=0;
		int point_b=b_list.size()-1;
		long answer=0;
		
		
		
		
		while(point_a<a_list.size() && point_b>=0) {
			
			
			

			
			long res= a_list.get(point_a)+b_list.get(point_b);
			//System.out.println(point_a+" "+point_b+" ans= "+answer+" res= "+res);
			if(T== res) {
				long fig_a=0;
				long fig_b=0;
				
				long a= a_list.get(point_a);
				long b= b_list.get(point_b);
				
				while(point_a< a_list.size() && a_list.get(point_a)==a) {
					point_a++;
					fig_a++;
				}
				while(point_b>= 0 && b_list.get(point_b)==b) {
					point_b--;
					fig_b++;
					
				}
				answer+=fig_a*fig_b;
			}// if end
			else {
				if(T>res) {
					point_a++;
				}
				
				else {// t<res
					point_b--;

				}
			
			}// else end
			
			
		}// while end 
		
		
		
		
		
		
		
		System.out.println(answer);
		
		
		
		

	}

}
