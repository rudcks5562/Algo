

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	
	public static int DP[][];
	public static int map[][];
	public static int delta_x[]= {-1,1,0,0};
	public static int delta_y[]= {0,0,-1,1};
	
	public static int N;
	
	
	
	
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st ;
		N= Integer.parseInt(input);
		
		map= new int[N][N];
		DP= new int[N][N];
		

		
		for(int i=0;i<N;i++) {
			
			input = br.readLine();
			st= new StringTokenizer(input);
			for(int j=0;j<N;j++) {
				
				map[i][j] = Integer.parseInt(st.nextToken());
		
			}
		}// input end 
		
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {

				
				DFS(i,j,1);
				
				
			}
		}// 
		int ans=0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				
			//	System.out.print(DP[i][j]+" ");
				
				ans=Math.max(ans, DP[i][j]);
				
			}
		//	System.out.println("");
		}// 
		
		
		System.out.println(ans);

	}





	private static int DFS(int i, int j, int cnt) {
		
		
		if(DP[i][j]!=0) {
			
			return DP[i][j];
		}

		DP[i][j]=1;
		
		
		for(int d=0;d<4;d++) {
			
			int next_x =j+delta_x[d];
			int next_y = i+delta_y[d];
			
			if(next_x<0|| next_x>=N ||next_y<0 || next_y>=N) {
				continue;
			}// idx check 
			
			if(map[i][j]<map[next_y][next_x]) {// 재귀 가능 조건 
				
				
				DP[i][j] = Math.max(DP[i][j], DFS(next_y,next_x,cnt+1)+1);
						
						
				
				
				
			}
			
		}
		
		
	return DP[i][j];
	}
}
