package D230613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Nums {
	
	public static int N;// 1<=N<=1500
	
	public static int map[][];
	
	public static int max_x;
	public static int max_y;
	
	public static int cnt;
	public static int cur;
	
	public static int answer=0;
	
	public static void main(String[] args) throws IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a;
		a=br.readLine();
		N= Integer.parseInt(a);
		map= new int[N][N];
		int temp_max=0;
		for(int i=0;i<N;i++) {
			a=br.readLine();
			StringTokenizer st= new StringTokenizer(a);
			for(int j=0;j<N;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());

			}
		}// input end 
		
		// max coord check comp
		
		

		Integer arrs[]= new Integer[2*N]; 
		
		int cnt=N;
		
		for(int s=0;s<N;s++) {
			arrs[s]=map[s][0];
		}

		
		for(int i=1;i<N;i++) {
			
			for(int j=0;j<N;j++) {
				
				arrs[cnt]= map[j][i];
				
				cnt++;
				
			}
			Arrays.sort(arrs,new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					
					return o2-o1;
				}
		
			});
			
			cnt=N;
		}
		
		
		
		//System.out.println(Arrays.toString(arrs));
		System.out.println(arrs[N-1]);
		
		
		return ;

	}

	
	
	
	

}
