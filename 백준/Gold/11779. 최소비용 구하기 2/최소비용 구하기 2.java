
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static int N,M;
	public static int map[][];
	public static int obj_A,obj_B;
	
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st;
		
		N= Integer.parseInt(input);
		input= br.readLine();
		M= Integer.parseInt(input);
		
		map = new int[N][N];
		
		for(int z=0;z<N;z++) {
			Arrays.fill(map[z], -1);
		}
		
		
		for(int s=0;s<M;s++) {
			input = br.readLine();
			st= new StringTokenizer(input);
			
			int froms= Integer.parseInt(st.nextToken());
			int nexts= Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
		//	System.out.println(cost+" map= "+map[froms-1][nexts-1]+"???");
			
			if(cost>=map[froms-1][nexts-1] && map[froms-1][nexts-1]!=-1) {
			continue;
			}
			else {
				map[froms-1][nexts-1]= cost;
			}
			
			
			
		}
		
		input = br.readLine();
		st = new StringTokenizer(input);
		
		obj_A= Integer.parseInt(st.nextToken());
		obj_B= Integer.parseInt(st.nextToken());
		
		
		
		DIJ();
		
		
		
		
		
		
		
		
		

	}
	private static void DIJ() {
		
		int dis[] = new int[N];
		
	
		
		PriorityQueue<visitor> pq = new PriorityQueue<>();
		pq.add(new visitor(obj_A,0,1,new StringBuilder().append(obj_A)));// start node , sum of cost, record list

		Arrays.fill(dis, N*100000+1);
		dis[obj_A-1]=0;
		while(!pq.isEmpty()) {
			
			//int size= pq.size();
		
			
			visitor cur_vs = pq.poll();
			int cur_node = cur_vs.cur_node;
			
			//System.out.println(cur_node+"cn");
			
			if(cur_node == obj_B) {
				
				System.out.println(cur_vs.cur_cost);
				System.out.println(cur_vs.visit_num);
				System.out.println(cur_vs.records);
				
				return;
			
			}

			
			for(int n=0;n<N;n++) {
				
				if(map[cur_node-1][n]!=-1) {// bus enabled
					
					int cost = map[cur_node-1][n];
				//	System.out.println(cur_node-1+" "+n+" "+map[cur_node-1][n]);
					
					if(dis[n]>cost+dis[cur_node-1]) {
	
						pq.add(new visitor(n+1,+cost+dis[cur_node-1], cur_vs.visit_num+1,new StringBuilder().append(cur_vs.records).append(" "+(n+1))));
						dis[n]=cost+dis[cur_node-1];
				//		System.out.println(Arrays.toString(dis));
					}
					
					
					
					
				}
				
				
				
				
			}// in for end 
			
			
			
			
		
		}// while end 
		
		
		
		
		
	}
	static class visitor implements Comparable<visitor>{
		int cur_node;
		int cur_cost;
		int visit_num;
		StringBuilder records;

		public visitor(int cur_node, int cur_cost, int visit_num, StringBuilder records) {
			this.cur_node = cur_node;
			this.cur_cost = cur_cost;
			this.visit_num = visit_num;
			this.records = records;
		}

		@Override
		public int compareTo(visitor o) {
			
				
			
			return this.cur_cost-o.cur_cost;
		}


		
		
		
	}

}
