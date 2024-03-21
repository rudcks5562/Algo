



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int N;
	public static int map[][];
	public static int answer=0;
	public static int dx[]= {-1,1,1,-1};// left up ~ clock dir->
	public static int dy[]= {-1,-1,1,1};
	public static int white=0;
	public static int black=0;
	public static int chess[][];
	public static boolean visit[][];
	

	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		N= Integer.parseInt(input);
		StringTokenizer st;
		map =new int[N][N];
		visit = new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			
			input = br.readLine();
			st =new StringTokenizer(input);
			
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}// input end 
		
        chess = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                chess[i][j] = (i+j) % 2;
            }
        }
		
		DFS(0,0,chess[0][0],0);// start == white ==0
		DFS(0,1,chess[0][1],0);

		
		answer= white+black;
		
		System.out.println(answer);
		

	}



	private static void DFS(int y, int x, int color, int cnt) {
		
		
		
		if(y>=N) {
			
			if(color==0) {
				
				white= Math.max(white, cnt);
				
			}
			else {
				black= Math.max(black, cnt);
			}
			
			
			return;
		}
		
		
		int next_x= x+2;
		
		int next_y = y;
		
		
		if(next_x>=N) {
			next_y++;
		
			if(next_y<N) {
				
				if(chess[next_y][0]==color) {
					
					next_x=0;
					
				}
				else {
					next_x=1;
				}
				
			}
			
		}
		
		if(map[y][x]==0) {
			
			
			DFS(next_y, next_x, color, cnt);
			return;
			
		}
		
		if(bis(y,x)) {
			
			visit[y][x] = true;
			DFS(next_y,next_x,color,cnt+1);
			visit[y][x]=false;
			
		}
		
		DFS(next_y,next_x,color,cnt);// 살리고 패스 
		
	}



	private static boolean bis(int y, int x) {// 대각체크 
		// 대각선 4방향 표시
        for(int i = 0; i < 4; i++) {

            int ny = y + dy[i];
            int nx = x + dx[i];

            while(check(ny,nx)) {

                if(visit[ny][nx] == true) {
                    return false;
                }

                ny += dy[i];
                nx += dx[i];
            }

        }
        return true;
	}
	public static boolean check(int y,int x) {// 인덱스 체크 
		
        if(y >= 0 && y < N && x >= 0 && x < N) {
            return true;
        }
        else {
            return false;
        }
		
		
		
	}
	

	
	
	

	
	
	
	
	
	
	
	

}
