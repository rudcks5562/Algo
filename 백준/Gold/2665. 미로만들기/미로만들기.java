

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class player implements Comparable<player>{
	
	int x;
	int y;
	int sum;
	public player(int x, int y, int sum) {
		this.x = x;
		this.y = y;
		this.sum = sum;
	}
	@Override
	public int compareTo(player o) {
		
		return this.sum-o.sum;
	}
	
}



public class Main {
	public static int N;
	public static int map[][];
	public static int answer=Integer.MAX_VALUE;
	public static int dx[]= {0,0,1,-1};
	public static int dy[]= {1,-1,0,0};

	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		N= Integer.parseInt(input);
		
		map= new int[N][N];
		
		for(int i=0;i<N;i++) {
			input = br.readLine();
			
			for(int j=0;j<N;j++) {
				map[i][j] = input.charAt(j)-'0';// 1 white 0black
			}
		}// for end
		
		
		DIJ();
		
		if(answer==0) {
			System.out.println(0);
		}
		else {
			System.out.println(answer);
		}

		
		

	}


	private static void DIJ() {
		
		int dis[][]= new int[N][N];
		boolean visit[][]= new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			
			
			for(int j=0;j<N;j++) {
				dis[i][j]=Integer.MAX_VALUE;
			}
		}// for end
		dis[0][0]=0;
		visit[0][0] = true;
		
		PriorityQueue<player> pq= new PriorityQueue<player>();
		pq.add(new player(0,0,0));
		
		while(!pq.isEmpty()) {
			
			player cur= pq.poll();
			
			for(int d=0;d<4;d++) {
				
				int next_x= cur.x+dx[d];
				int next_y= cur.y+dy[d];
				
				if(next_x<0|| next_x>=N|| next_y<0|| next_y>=N) {// 경계값 체크 
					
					continue;
				}
				
				
					if(dis[next_y][next_x]<cur.sum+check_black(next_y, next_x)|| visit[next_y][next_x]) {
						continue;
					}
		
					//System.out.println(check_black(next_y, next_x)+"??"+"cur.y= "+cur.y+" cur.x= "+cur.x);
					pq.add(new player(next_x, next_y, cur.sum+check_black(next_y, next_x)));
					dis[next_y][next_x]= cur.sum+check_black(next_y, next_x);
					visit[next_y][next_x]=true;
					
				
				
				
				
			}// for end 
			
			
			
			
		}
		
		
//		for(int i=0;i<N;i++) {
//			
//			for(int j=0;j<N;j++) {
//				System.out.print(dis[i][j]+" ");
//			}
//			System.out.println("");
//		}// for end
		
		
		answer= dis[N-1][N-1];
		
		
		
	}


	private static int check_black(int next_y, int next_x) {
		
		if(map[next_y][next_x]==0) {//검은방
			return 1;
		}
		else {// 흰방
			return 0;
		}

	}

}
