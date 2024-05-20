

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int array[][];
	public static int DP[][];// big
	public static int DP2[][];// small
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st;
		
		N= Integer.parseInt(input);
		array= new int[N+1][3];
		DP= new int[N+1][3];
		DP2= new int[N+1][3];
		
		for(int p=0;p<N;p++) {
			
			input= br.readLine();
			st= new StringTokenizer(input);
			
			for(int s=0;s<3;s++) {
				
				array[p][s]= Integer.parseInt(st.nextToken());
				
				
			}
			
		}// input comp 
		
		
		DP[0][0]= array[0][0];
		DP[0][1]= array[0][1];
		DP[0][2]= array[0][2];
		
		DP2[0][0]= array[0][0];
		DP2[0][1]= array[0][1];
		DP2[0][2]= array[0][2];
		// init  dp 
		
		
		for(int p=1;p<=N;p++) {
			
			DP[p][0]= Math.max(DP[p-1][0], DP[p-1][1])+array[p][0];
			DP[p][1]= Math.max(Math.max(DP[p-1][0], DP[p-1][1]),DP[p-1][2])+array[p][1];
			DP[p][2]= Math.max(DP[p-1][1], DP[p-1][2])+array[p][2];
		
			DP2[p][0]= Math.min(DP2[p-1][0], DP2[p-1][1])+array[p][0];
			DP2[p][1]= Math.min(Math.min(DP2[p-1][0], DP2[p-1][1]),DP2[p-1][2])+array[p][1];
			DP2[p][2]= Math.min(DP2[p-1][1], DP2[p-1][2])+array[p][2];
		}
		
		System.out.print(Math.max(Math.max(DP[N][0], DP[N][1]),DP[N][2])+" ");
		System.out.println(Math.min(Math.min(DP2[N][0], DP2[N][1]),DP2[N][2]));
		
		
		
		
		
		
		
	}

}
