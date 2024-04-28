

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N,M;
	public static int input_arr[];
	public static boolean DP[][];

	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st;
		StringBuilder sb= new StringBuilder();
		
		N= Integer.parseInt(input);
		
		input = br.readLine();
		st= new StringTokenizer(input);
		input_arr= new int[N];
		
		DP= new boolean[N+1][N+1];
		
		for(int i=0;i<N;i++) {
			input_arr[i]= Integer.parseInt(st.nextToken());
		}
		
		input =br.readLine();
		M= Integer.parseInt(input);
		
		
		
		for(int i=1;i<=N;i++) {
			
			DP[i][i]=true;// 한자리 숫자 
			
		}
		for(int i=1;i<=N-1;i++) {
			
			if(input_arr[i-1]==input_arr[i]) {
				DP[i][i+1]=true;//2자리 숫자 
				
			}
			
		}
		
		for(int i=2;i<N;i++) {
			
			for(int j=1;j<=N-i;j++) {
				
				if(input_arr[j-1]==input_arr[j+i-1] && DP[j+1][j+i-1]) {
					
					DP[j][j+i]=true;
				}
				
			}
			
		}
		
		
		
		
		
		
		for(int tc=0;tc<M;tc++) {
			
			input = br.readLine();
			st= new StringTokenizer(input);
			
			int first= Integer.parseInt(st.nextToken());
			int sec= Integer.parseInt(st.nextToken());
			
			sb.append((DP[first][sec]) ? 1:0).append("\n");
			
			
			
		}
		
		
		System.out.println(sb);
		
	}

}
