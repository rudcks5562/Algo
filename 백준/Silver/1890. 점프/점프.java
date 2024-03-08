
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int N;//4~100
	public static int map[][];
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st;
		
		N= Integer.parseInt(input);
		
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			input = br.readLine();
			st= new StringTokenizer(input);
			for(int j=0;j<N;j++) {
				
				map[i][j] = Integer.parseInt(st.nextToken());
				
			}
			
			
		}// input end 
		
		long DP[][] = new long[N+1][N+1];
		
		DP[1][1]=1;
		
		for(int i=1;i<=N;i++) {
			
			for(int j=1;j<=N;j++) {
				
				if(DP[i][j]!=0) {
					
					int nums= map[i-1][j-1];
					if(nums==0) {
						System.out.println(DP[N][N]);
						return;
					}
					
					if(i+nums<=0|| i+nums>N) {
						
						
						
					}
					else {
						DP[i+nums][j]+=DP[i][j];
					}
					
					
					
					if(j+nums<=0||j+nums>N) {
						
						
					}
					else {
						
						
						DP[i][j+nums]+=DP[i][j];
					}
					
					
				}
				
				
			}
			
			
			
		}// for end 
		
		
		//System.out.println(DP[N][N]);
		
		
		
	}

}
