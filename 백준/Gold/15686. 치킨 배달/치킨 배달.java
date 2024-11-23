import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


class chickenpoint extends homepoint{

	public chickenpoint(int a, int b) {
		super(a, b);
	
	}
}

class homepoint{
	
	public int x;
	public int y;
	public int C_D=100001;
	public homepoint(int a, int b) {
		this.x=a;
		this.y=b;
	}
	
	public int check_C_D(int othersD_y,int othersD_x) {
		
		//임의의 두 칸 (r1, c1)과 (r2, c2) 사이의 거리는 |r1-r2| + |c1-c2|로 구한다.
		
		int temp1= Math.abs(othersD_x-this.x)+Math.abs(othersD_y-this.y); 
		
		
		
		return temp1;
	}
}





public class Main {
	
	public static int map[][];
	
	public static int min_value=1000001;
	
	public static boolean visit[];
	
	public static void comb(int cnt, int n,int r,List<homepoint> homelist,List<chickenpoint> chicklist) {
		
		if(r==0) {
			
		
			//System.out.println(Arrays.toString(visit));
			
			
			int city_point1=0;
			
			for(int as=0;as<homelist.size();as++) {
				int C_D1=1000001;
				
				for(int kk=0;kk<n;kk++) {
				
				if(visit[kk]==true) {
					
				// 최소 치킨리스트 에서 치킨거리 구할 것 
					
					 int temp1= homelist.get(as).check_C_D(chicklist.get(kk).y,chicklist.get(kk).x);
					
					 C_D1=Math.min(temp1, C_D1);
				
				}
				
				}
				
				city_point1+=C_D1;
				
			}// 도시 치킨거리 측정 
			//System.out.println(city_point1+";;");
			Main.min_value=Math.min(min_value, city_point1);
			
			
		}
		if(n==cnt) {
			
			return;
		}
		
		
		
		
		visit[cnt]=true;
		comb(cnt+1, n, r-1,homelist,chicklist);
		visit[cnt]=false;
		comb(cnt+1, n, r,homelist,chicklist);	
		
		
	}
	
	
	

	public static void main(String[] args) throws IOException {
		//도시의 칸은 (r, c)와 같은 형태로 나타내고, r행 c열 또는 위에서부터 r번째 칸, 왼쪽에서부터 c번째 칸을 의미한다. r과 c는 1부터 시작한다.
		//치킨 거리는 집과 가장 가까운 치킨집 사이의 거리이다. 즉, 치킨 거리는 집을 기준으로 정해지며,
		//각각의 집은 치킨 거리를 가지고 있다. 도시의 치킨 거리는 모든 집의 치킨 거리의 합이다.
		
		//임의의 두 칸 (r1, c1)과 (r2, c2) 사이의 거리는 |r1-r2| + |c1-c2|로 구한다.
		//0은 빈 칸, 1은 집, 2는 치킨집이다.
		
		// 도시의 치킨거리 값이 가장 작게 나와야함.
		//도시의 치킨집 최대 M개를 고르고 나서..나머지는 폐업 - m은 제시되는듯?
		
		
		
		// 필요한 기능
		// 1. 집의 좌표를 입력하여 현재 제시된 모든 치킨집과의 거리를 계산하여 치킨거리를 출력해주는 함수
		// 2. 모든 치킨집, 집,을 각각 구분하여 저장할 저장소
		// 3. 
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String a= br.readLine();
		StringTokenizer st= new StringTokenizer(a);
		
		int n=Integer.parseInt(st.nextToken());
		int m= Integer.parseInt(st.nextToken());
		
		List<homepoint> homelist= new ArrayList<>();
		List<chickenpoint> chicklist= new ArrayList<>();
		
		Main.map= new int [n][n];
		
		for(int i=0;i<n;i++) {
			
			a= br.readLine();
			
			st= new  StringTokenizer(a);
			
			for(int j=0;j<n;j++) {
				
				Main.map[i][j]=Integer.parseInt(st.nextToken());
				
				if(Main.map[i][j]==1) {
					
					homelist.add(new homepoint(j, i));
					
				}
				else if(Main.map[i][j]==2) {
					
					chicklist.add(new chickenpoint(j, i));
				}
				
			}
		}// input clear!
		
		Main.visit= new boolean[chicklist.size()];
		
		Main.comb(0, chicklist.size(),m,homelist,chicklist);

		//comb(int cnt, int n,int r,List<homepoint> homelist,List<chickenpoint> chicklist) {
		
		
		
		System.out.println(Main.min_value);

		
	}

}