

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int T,W;
	public static int input_down[];
	public static int DP[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st=  new StringTokenizer(input);
		
		T= Integer.parseInt(st.nextToken());
		W= Integer.parseInt(st.nextToken());
		
		input_down= new int[T+1];
		
		
		for(int Time=0;Time<T;Time++) {
			
			input= br.readLine();
		
			input_down[Time+1]= Integer.parseInt(input);
			
		}
		
		// DP[w][2][n] // 교체수 ,위치 , 시간별 최대 
		DP= new int[W+1][T+1];
		

		// 현재위치는 moved의 횟수로 추정가능.
		

		
		for(int t=1;t<=T;t++) {
			
			
			int cur= input_down[t];
			
			if(cur==1) {
				
				DP[0][t]=DP[0][t-1]+1;
				
			}
			else {
				
				DP[0][t]= DP[0][t-1];
				
			}
			
			for(int w=1;w<=W;w++) {
				
				
				if(cur == 1) { //지금 자두 떨어지는 위치 1이라면,
                    if(w%2 == 0) { //현재 w 값이 짝수라서 짝수 횟수만큼 이동하여 자두가 현재 위치 1에 있다면
                        DP[w][t] = Math.max(DP[w][t-1] + 1, DP[w-1][t-1]);
                        //D 배열에는, 이동하지 않고 그대로 자두 하나를 얻는것과, 이동하여 자두 하나를 얻지 않는 것 중에 최댓값이 들어가게 된다.
                    }
                    else { //현재 w가 홀수라서 내 위치가 2라서 떨어지는 자두와 위치가 일치하지 않는다면
                        DP[w][t] = Math.max(DP[w-1][t-1] + 1, DP[w][t-1]);
                        //이동하여 자두를 하나 얻는것과, 이동하지 않고 자두를 얻지 않는것 중 최댓값
                    }
                }
                else { //현재 자두가 떨어지는 위치가 2라면
                    if(w%2 == 0) {
                        DP[w][t] = Math.max(DP[w-1][t-1] + 1, DP[w][t-1]);
                    }
                    else {
                        DP[w][t] = Math.max(DP[w][t-1] + 1, DP[w-1][t-1]);
                    }
                }
				
				
			}
			
		}
		
		
		
		int ans=0;
		
		System.out.println(Math.max(ans, DP[W][T]));
		
		
		
		
		
		
		
		
		

		
		

	}

}
