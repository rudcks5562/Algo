

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
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




public class Main {
	
	public static int N,M;
	public static int map[][];
	public static int dx[]= {1,-1,0,0};
	public static int dy[]= {0,0,-1,1};
	public static pos two_pos;
	public static int res_map[][];
	

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String input =br.readLine();
		StringTokenizer st= new StringTokenizer(input); 
		
		
		N= Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		map= new int[N][M];
		res_map=new int[N][M];
		
		for(int i=0;i<N;i++) {
			
			input= br.readLine();
			st= new StringTokenizer(input);
			
			for(int j=0;j<M;j++) {
				
				map[i][j]= Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					
					two_pos= new pos(j,i);
				}
				res_map[i][j]=-1;
			}
			
		}// for end 
		
		
		BFS(two_pos);
		res_map[two_pos.y][two_pos.x]=0;
		for(int i=0;i<N;i++) {
			
			for(int j=0;j<M;j++) {
				
				
				if(map[i][j]==0) {
					res_map[i][j]=0;
				}
				
			}
			
		}
		
		for(int i=0;i<N;i++) {
			
			for(int j=0;j<M;j++) {
				
				
				System.out.print(res_map[i][j]+" ");
				
			}
			System.out.println("");
		}
		
	}


	private static void BFS(pos two_pos2) {
		
		Queue q= new LinkedList<pos>();
		
		q.add(two_pos2);
		res_map[two_pos2.y][two_pos2.x]=-1;
		
		int depth=1;
		
		while(!q.isEmpty()) {
			
			int sz= q.size();
			
			for(int s=0;s<sz;s++) {
				
				pos cur= (pos) q.poll();
				//System.out.println("cur@"+ cur.y+" "+cur.x);
				
				for(int d=0;d<4;d++) {
					
					int next_x= cur.x+dx[d];
					int next_y = cur.y+dy[d];
					
					if(next_x<0|| next_y<0|| next_x>=M|| next_y>=N) {
						continue;
					}
					if(map[next_y][next_x]==0) {
						
						continue;
					}
					if(res_map[next_y][next_x]!=0&& res_map[next_y][next_x]>0) {
						continue;
					}
					
					q.add(new pos(next_x,next_y));
					res_map[next_y][next_x]=depth;
					//System.out.println("add"+ next_y+" "+next_x);
				}
				
			}// for end 
			
			depth++;
		}// while end
		
		
		
	}

}
