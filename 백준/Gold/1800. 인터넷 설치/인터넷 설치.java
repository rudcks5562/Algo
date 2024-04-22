

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



 class node implements Comparable<node>{
	int nums;
	int cost;
	public node(int nums, int cost) {
		this.nums = nums;
		this.cost = cost;
	}
	@Override
	public int compareTo(node o) {
		// TODO Auto-generated method stub
		return this.cost-o.cost;
	}
	
	
}
public class Main {
	public static int N,P,K;//node, cable, freenums
	public static ArrayList<node>[] nodelist;
	
	
	


	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		StringTokenizer st= new StringTokenizer(input);
		
		
		N= Integer.parseInt(st.nextToken());
		P= Integer.parseInt(st.nextToken());
		K= Integer.parseInt(st.nextToken());
		
		
		nodelist= new ArrayList[N+1];
		
		for(int n=1;n<=N;n++) {
			nodelist[n]= new ArrayList<>();
			
		}
		
		
		
		for(int s=0;s<P;s++) {
			input = br.readLine();
			st= new StringTokenizer(input);
			
			int temp_a= Integer.parseInt(st.nextToken());
			int temp_b= Integer.parseInt(st.nextToken());
			int temp_v= Integer.parseInt(st.nextToken());
			
			nodelist[temp_a].add(new node(temp_b,temp_v));
			nodelist[temp_b].add(new node(temp_a,temp_v));
			
		}
		
		
		
		
		
		
		//정답인 비용 + K 오버 비용 
		
		int left=0;
		int right= 100000001;
		int answer=-1;
		
		while(left<=right) {
			
			int mid= (left+right)/2;
			
			if(DIJ(mid)==true) {// 이 비용으로 N까지 도달이 가능한 경우 
				answer=mid;
				//System.out.println(answer+"ans");
				right= mid-1;
				
			}else {
				
				left=mid+1;
				
			}
		}
		
		
		System.out.println(answer);
		
		
		
		
		
		
		
		
	}

	

	private static boolean DIJ(int mid) {
		
		int dis[]= new int[N+1];
		for (int i = 2; i <= N; i++) {
			dis[i] = 100000001;
		}
		PriorityQueue<node> pq= new PriorityQueue<>();
		
		pq.add(new node(1,0));
		
		while(!pq.isEmpty()) {// mid 값을 넘으면 1로 추정 아니면 0으로 추정.
			
			node cur= pq.poll();
			
			int size= nodelist[cur.nums].size();
			//System.out.println(size+"sz");
			for(int s=0;s<size;s++) {
				
				int next= nodelist[cur.nums].get(s).nums;
				int next_cost= nodelist[cur.nums].get(s).cost<=mid ? 0:1;
				//System.out.println(next_cost+"??");
				if(dis[next]>next_cost+cur.cost) {
					
					dis[next]= next_cost+cur.cost;
					pq.add(new node(next,dis[next]));
					
				}
			}
			
			
			
		}// while end
		//System.out.println(dis[N]+" mid= "+mid);
		return dis[N]<=K;
	}

}
