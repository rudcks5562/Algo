

import java.util.Scanner;

public class Main {
	public static char map[][];
	public static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N= sc.nextInt();// 3*2^n; // n=10 down
		sb= new StringBuilder();
		
		map= new char[N][2*N-1];// y x 
		
		
		for(int i=0;i<N;i++) {
			
			for(int j=0;j<2*N-1;j++) {
				map[i][j]=' ';
			}
		}
		
		
	
		function(0, N-1, N);
		
		//0 :3= 1개 map size=5 
		//1 : 6 3개+1개 map size =11
		//2: 12 mapsize=23
		//3: 24  2n-1 ?
		
		// x=하단의 별은 2n+1 등차수열꼴로 증가 
		// y=제공됨 N 
		
		
		for(int i=0;i<N;i++) {
			
			for(int j=0;j<2*N-1;j++) {
				
				
				sb.append(map[i][j]);
				
			}
			sb.append("\n");
		}
		
		
		System.out.println(sb);
		
		
		
	}

	private static void function(int y,int x,int n) {
		

		if(n==3) {
			
			map[y][x]= '*';
			map[y+1][x-1]='*';
			map[y+1][x+1]='*';
			
			for(int s=x-2;s<=x+2;s++) {
				
				map[y+2][s]='*';
				
			}
			return ;
			
		}
		
		function(y, x, n/2);// up
		function(y+n/2, x-n/2, n/2);//L
		function(y+n/2, x+n/2, n/2);//R
		
		
		
		
		
		
	}
	

	
	
	
	

}
