

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
	
	static boolean [] visit = new boolean[100001];
	static int [] parent = new int [100001];
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int X=  Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		if(X==K) {
			System.out.println(0);
			System.out.println(X);
			return ;
		}
		

		
		BFS(X,K);
		
		Stack stack = new Stack<>();
		
		int st_input= K;
		stack.push(K);
		while(X!= st_input) {
			
			int val = parent[st_input];
			stack.push(val);
			st_input = val;
			
		}
		
		
		
		int size = stack.size();
		
		//System.out.println(stack.toString());

		for(int s=size-1;s>=0;s--) {
			
			System.out.print(stack.get(s)+" ");
			
		}
				
		
		return;
		
	}
	
	
	static void BFS(int x, int k){
		
		Queue q = new LinkedList<>();
		int depth = 0;
		
		q.offer(x);
		visit[x]=true;
		
		while(!q.isEmpty()) {
			
			int q_sz = q.size();
			for(int s=0;s<q_sz;s++) {
				
				int cur = (int) q.poll();
				//System.out.println(cur+"?");

				
				if(cur== k) {
					System.out.println(depth);
					//System.out.println("@@?");
					return;
				}
				
				if(cur+1<=100000 && visit[cur+1]==false) {
					
					int temp = cur+1;
					visit[temp]=true;
					q.add(temp);
					parent[cur+1]= cur;
					
				}
				if(cur-1>=0 && visit[cur-1]==false) {
					
					int temp = cur-1;
					visit[temp]=true;
					q.add(temp);
					parent[cur-1]= cur;
					
				}
				if(cur*2>=0  && cur*2<=100000 && visit[cur*2]==false) {
					int temp = cur*2;
					visit[temp]=true;
					q.add(temp);
					parent[cur*2]= cur;
					
				}
				
				
			}
			
			depth++;
		}
		
		
		
	}

}
