

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	
	public static int[] input_arr;
	public static int DP[][];
	public static int limit;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		int N= Integer.parseInt(input);
		
		input_arr= new int[N+1];
		
		input = br.readLine();
		StringTokenizer st= new StringTokenizer(input);
		
		for(int s=1;s<=N;s++) {
			int temp= Integer.parseInt(st.nextToken());
			
			input_arr[s]= input_arr[s-1]+temp;// 누적합 
		}// input end 
		
		DP= new int[N+1][4];// idx , 0 and train
		
		limit= Integer.parseInt(br.readLine());
		
		
		
		

		for(int train=1;train<=3;train++) {//기관차에 대해 
				
			for(int s=train*limit;s<=N;s++) {	
				
				DP[s][train]= Math.max(DP[s-1][train], DP[s-limit][train-1]+  get_value(s-limit,s));
				// 이전값 참조 vs 호차 갈아바꾸기
				
				
			}// 123for end
			
			
			
		}//for end 
		
		
		System.out.println(DP[N][3]);
		
		
	}

	private static int get_value(int start, int end) {//구간합 리턴 
		
		int res=0;
		
		res=  input_arr[end]-input_arr[start];
		return res;
	}

}
