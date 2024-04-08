

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

	
	public static int bottle_size[]= new int[3];
	public static TreeSet<Integer> ans= new TreeSet<Integer>();
	public static int visit[][][]= new int[201][201][201];
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		for(int s=0;s<3;s++) {
			
			bottle_size[s]=sc.nextInt();
			
		}
		
		
		ans.add(bottle_size[2]);
		
		DFS(0,0,bottle_size[2]);
		
	
		StringBuilder sb= new StringBuilder();
		
		
		for( int temps :ans) {
			
			sb.append(temps+" ");
			
		}
		System.out.println(sb.toString());

	}

	private static void DFS(int a, int b, int c) {
		
		if(visit[a][b][c]!=0) {
			
			return;
			
		}
		visit[a][b][c]=1;
		
		if(a==0) {
			
			ans.add(c);
			
			
		}
		
		//a->b
		if(a>0) {
			
			if(a+b>=bottle_size[1]) {
				int temp= bottle_size[1]-b;// 옮길 대상에서 채워야 하는 물의 양 
				//a= a-temp;
				
				//b=bottle_size[1];
				
				DFS(a-temp,bottle_size[1],c);
			}
			else {

				
				DFS(0,a+b,c);
				
			}
			
			
		}
		
		
		
		//a->c
		
		if(a>0) {
			
			if(a+c>=bottle_size[2]) {
				int temp= bottle_size[2]-c;
				//a= a-temp;
				
				//b=bottle_size[1];
				
				DFS(a-temp,b,bottle_size[2]);
			}
			else {
				//a=0;
			//	b=bottle_size[1];
				DFS(0,b,c+a);
				
			}
			
		}
		
		
		if(b>0) {
			if(b+a>=bottle_size[0]) {
				int temp= bottle_size[0]-a;
				//a= a-temp;
				
				//b=bottle_size[1];
				
				DFS(bottle_size[0],b-temp,c);
			}
			else {
				//a=0;
			//	b=bottle_size[1];
				DFS(a+b,0,c);
				
			}
			
			
		}// b->a
		
		
		
		if(b>0) {
			if(b+c>=bottle_size[2]) {
				int temp= bottle_size[2]-c;
				//a= a-temp;
				
				//b=bottle_size[1];
				
				DFS(a,b-temp,bottle_size[2]);
			}
			else {
				//a=0;
			//	b=bottle_size[1];
				DFS(a,0,b+c);
				
			}
			
			
		}//b->c
		
		if(c>0) {
			
			if(c+a>=bottle_size[0]) {
				int temp= bottle_size[0]-a;
				//a= a-temp;
				
				//b=bottle_size[1];
				
				DFS(bottle_size[0],b,c-temp);
			}
			else {
				//a=0;
			//	b=bottle_size[1];
				DFS(a+c,b,0);
				
			}
			
			
		}//c-a
		if (c>0) {
			if(c+b>=bottle_size[1]) {
				int temp= bottle_size[1]-b;
				//a= a-temp;
				
				//b=bottle_size[1];
				
				DFS(a,bottle_size[1],c-temp);
			}
			else {
				//a=0;
			//	b=bottle_size[1];
				DFS(a,0,c+b);
				
			}
			
			
			
		}//c-b
		
		
		
	}

}
