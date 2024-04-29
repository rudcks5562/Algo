

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class pos{
	
	int x;
	int y;
	public pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
	
}

class city{
	
	int idx;
	int sum;
	public city(int idx, int sum) {
		this.idx = idx;
		this.sum = sum;
	}
	
}

public class Main{
	
	static pos a;
	static pos start;
	public static int N;
	public static int arrs[];
	public static pos[] list;
	public static ArrayList<city> citylist[];
	public static int dis[];

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st= new StringTokenizer(input);
		
		start= new pos(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		a=  new pos(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		input= br.readLine();
		N= Integer.parseInt(input);
		if(N==0) {
			
			System.out.println(-1);
			return;
			
		}
		list= new pos[N+2];
		
		
		arrs= new int[100001];
		
		for(int s=2;s<=arrs.length-1;s++) {
			arrs[s]=s;
		}
		for(int s=2;s<=arrs.length-1;s++) {
			
			if(arrs[s]==0) {
				continue;
			}
			for(int j=2*s;j<arrs.length;j+=s) {
				
				arrs[j]=0;
				
			}
		}// checked
		
		
		
		list[0]=(start);
		
		for(int s=1;s<N+1;s++) {
			input = br.readLine();
			st= new StringTokenizer(input);
			
			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			
			list[s]=(new pos(a,b));
			
			
		}

		list[N+1]=(a);
		
		citylist= new ArrayList[9999];
		
		for(int i=0;i<N+2;i++) {
			
			citylist[i]= new ArrayList<>();
			
		}
		
		
		
		

		for(int i=0;i<N+2;i++) {
			
			for(int j=0;j<N+2;j++) {
				
				if(i==j) {
					continue;
				}
				pos a= list[i];
				pos b= list[j];
				int dist= Get_distance(a, b);
				
				if(arrs[dist]!=0) {
					
					citylist[i].add(new city(j,dist));
				}
			}
		}
		
		
		
		dis= new int[N+2];
		
		DIJ();
		
		
		
		if(dis[N+1]==Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		System.out.println(dis[N+1]);
		

		
	

	}


	private static void DIJ() {
		
		
		int sz= list.length;
		
		
		Queue<Integer> pq= new LinkedList<>();
		pq.add(0);
		
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[0]=0;
		
		
		while(!pq.isEmpty()) {
			
			int cur= pq.poll();
			

			
			for(city a: citylist[cur]) {
				
				int tdx= a.idx;
				int d= a.sum;
				
				if(dis[cur]!=Integer.MAX_VALUE) {
					
					int cost= dis[cur]+d;
					
					if(dis[tdx]>cost) {
						
						dis[tdx]=cost;
						
						pq.add(tdx);
					}
					
				}
				
				
	
				
			}
			
			
			
		}
		

		
		return;
		
		
	}
	public static int Get_distance(pos a, pos b) {// checked
		
		int res=0;
		
		if(a.x==b.x&& a.y==b.y) {
			
			return 0;
		}
		
		
		
		int temp_a=(int) Math.pow(Math.abs(a.x-b.x),2)+ (int)Math.pow(Math.abs(a.y-b.y),2);
		
		res= (int)Math.sqrt(temp_a);
	
		return res;
	}

}
