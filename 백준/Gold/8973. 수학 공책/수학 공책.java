

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static int N;
	public static int arr_up[];
	public static int arr_down[];
	public static int cur_b;
	public static int cur_e;
	public static int answer=Integer.MIN_VALUE;
	public static int DP[][];
	public static int sum[][];
	
	
	public static void main(String[] args) throws IOException {
	

		input();
		
		cur_b=0;
		cur_e=0;
		
		

		
		for(int i=0;i<N;i++) {
			
			for(int j=0;j<N;j++) {
				
				if(i==0|j==0) {
					
					DP[i][j]=(arr_up[j]*arr_down[i]);
					
				}
				
				else {
				DP[i][j]= DP[i-1][j-1]+(arr_up[j]*arr_down[i]);
				}
				
			}
			
		}// 누적합 적용 
		
		//System.out.println(Arrays.deepToString(DP));
		
		for(int s=0;s<N;s++) {
			
			Arrays.fill(sum[s], Integer.MIN_VALUE);
		}
		
		
		
		for(int i=0;i<N;i++) {
			
			for(int j=0;j<N;j++) {
				
				if(i+j>=N) {
					continue;
				}
				
				int temp= N-i-j-1;
				if(i==0||j==0) {
					sum[i][j]= DP[i+temp][j+temp];
					
				}
				else {
					sum[i][j]= DP[i+temp][j+temp]-DP[i-1][j-1];
				}
				// 누적합 이동 횟수 
				//System.out.println(i+" "+j+" = "+sum[i][j]);
				

			}
			
		}
		
		//System.out.println(Arrays.deepToString(sum));
		
		for(int i=0;i<N;i++) {
			
			for(int j=0;j<N;j++) {
				
				if(answer<sum[i][j]) {
					
					cur_b=j;
					cur_e=i;
					answer=sum[i][j];
					
				}
				
				

			}
			
		}
		
		
		
		
		
		System.out.println(cur_b+" "+cur_e);
		System.out.println(answer);

	}


	private static void input() throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String input= br.readLine();
		StringTokenizer st;
		N= Integer.parseInt(input);
		DP= new int[N][N];
		sum =new int[N][N];
		arr_up= new int[N];
		arr_down= new int[N];
		
		
		
		input= br.readLine();
		st= new StringTokenizer(input);
		
		for(int s=0;s<N;s++) {
			
			arr_up[s]= Integer.parseInt(st.nextToken());
			
		}
		input= br.readLine();
		st= new StringTokenizer(input);
		
		for(int s=N-1;s>=0;s--) {
			arr_down[s]= Integer.parseInt(st.nextToken());
			
		}
		

		
		
		
		
	}

}
