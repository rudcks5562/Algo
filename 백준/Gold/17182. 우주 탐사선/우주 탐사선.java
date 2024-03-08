

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int N,K;// node fig,start node 
	public static int dis[][];// smallest distance
	public static int answer=Integer.MAX_VALUE;
	public static boolean visit[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st= new StringTokenizer(input);
		
		N= Integer.parseInt(st.nextToken());
		K= Integer.parseInt(st.nextToken());
		
		dis= new int[N][N];
		
		for(int i=0;i<N;i++) {
			input = br.readLine();
			st=new StringTokenizer(input);
			for(int j=0;j<N;j++) {

				dis[i][j]= Integer.parseInt(st.nextToken());
				
			}
		} // input end 
		floyd();
		
		//System.out.println(Arrays.deepToString(dis)); //checked
		visit= new boolean[N];
		visit[K]= true;
		DFS(K,0,0);
		
		System.out.println(answer);
		

	}


	private static void DFS(int start, int cnt, int sum) {
		
		if(cnt==N-1) {
			
			answer=Math.min(answer, sum);
			//System.out.println(answer+"ans");
			return;
		}
		//System.out.println(sum+"sum");
		for(int s=0;s<N;s++) {
			
			if( visit[s]==true) {
				continue;
			}
			
			int temp= dis[start][s];
			
			visit[s]= true;
			DFS(s,cnt+1,sum+temp);
			visit[s]=false;
			
			
		}
		
		
		
	}


	private static void floyd() {//10^3 timecomplexity
		
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					
					if(i==j)continue;
					
					dis[i][j]= Math.min(dis[i][j], dis[i][k]+dis[k][j]);
					
				}
			} 
			
		}//for3 end
		
		
		
	}

}
