import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static int dx[] = { 0, 0, -1, 1 };
	public static int dy[] = { -1, 1, 0, 0 };// up down left right for delta search

	public boolean visit[][];// 빙하 존재하면 트루
	public boolean sel[][];

	int n;
	int m;
	int res = 0;
	int mem_x = 0;
	int mem_y = 0;
	int ice_counter = 0;// 빙하의 개수
	int ice_sub = 0;
	
	public Main(int n, int m) {

		this.n = n;

		this.m = m;

		visit = new boolean[n][m];

		sel = new boolean[n][m];

	}

	void dfs(int cur_x, int cur_y, int arrin[][]) {

		sel[cur_y][cur_x] = true;

		res++;

		for (int i = 0; i < dx.length; i++) {

			if (cur_x + dx[i] < m && cur_x + dx[i] >= 0 && cur_y + dy[i] < n && cur_y + dy[i] >= 0
					&& arrin[cur_y + dy[i]][cur_x + dx[i]] != 0 && sel[cur_y + dy[i]][cur_x + dx[i]] != true) {

				switch (i) {

				case 0:

					dfs(cur_x, cur_y - 1, arrin);

					break;

				case 1:

					dfs(cur_x, cur_y + 1, arrin);

					break;

				case 2:

					dfs(cur_x - 1, cur_y, arrin);

					break;

				case 3:

					dfs(cur_x + 1, cur_y, arrin);

					break;

				}

			}

		}

		return;

	}// 용도는 오로지 빙하의 덩어리 분할 여부 확인용. 덩어리의 빙하 개수를 반환

	void dfs2(int cur_x, int cur_y, int arr2d[][]) {

		if (this.visit[cur_y][cur_x] == false || this.sel[cur_y][cur_x] == true) {

			return;

		} // 바다이므로 패스

		else if (this.visit[cur_y][cur_x] != false) {

			this.ice_counter++;

			int sea_counter = 0;

			for (int k = 0; k < dx.length; k++) {

				if (arr2d[cur_y + dy[k]][cur_x + dx[k]] == 0 && sel[cur_y + dy[k]][cur_x + dx[k]] != true) {

					sea_counter++;

				} // 방향 측이 바다인 경우

			} // 델타 끝

			arr2d[cur_y][cur_x] = arr2d[cur_y][cur_x] - sea_counter;

			if (arr2d[cur_y][cur_x] <= 0) {

				ice_sub++;

				this.visit[cur_y][cur_x] = false;

				arr2d[cur_y][cur_x] = 0;

			}
			else {
				mem_x = cur_x;

				mem_y = cur_y;
				
			}


		} // 현 좌표에 빙산이 위치한다.

		sel[cur_y][cur_x] = true;

		for (int i = 0; i < dx.length; i++) {

			if (cur_x + dx[i] < m && cur_x + dx[i] >= 0 && cur_y + dy[i] < n && cur_y + dy[i] >= 0
					&& arr2d[cur_y + dy[i]][cur_x + dx[i]] != 0 && sel[cur_y + dy[i]][cur_x + dx[i]] != true) {

				switch (i) {

				case 0:

					dfs2(cur_x, cur_y - 1, arr2d);

					break;

				case 1:

					dfs2(cur_x, cur_y + 1, arr2d);

					break;

				case 2:

					dfs2(cur_x - 1, cur_y, arr2d);

					break;

				case 3:

					dfs2(cur_x + 1, cur_y, arr2d);

					break;

				}

			}

		}

		return;

	}// 용도는 오로지 빙하의 덩어리 분할 여부 확인용. 덩어리의 빙하 개수를 반환 ???? 델타적용후 녹이는거는 큰수부터.. BFS사용??

	public static void main(String[] args) throws IOException {

		// 0이 붙은 수 만큼 년마다 수치 감소

		// 빙산 내부에도 바다가 존재가능

		// 상하좌우 델타탐색으로 각 위치마다 0의 위치 조정

		// dfs로 특정 빙하 연결성분 계산후 전체 성분과 대조하여 두동강 낫는지 확인

		// 만일 동강 끝까지 안나면 0출력

		// 객체로 만들어서 해볼까? 클래스 좌표 해서..

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String a;

		a = br.readLine();

		StringTokenizer st = new StringTokenizer(a);

		int n = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(st.nextToken());

		int arr2d[][] = new int[n][m];

		Main m2obj = new Main(n, m);

		for (int i = 0; i < n; i++) {

			a = br.readLine();

			st = new StringTokenizer(a);

			for (int z = 0; z < m; z++) {

				arr2d[i][z] = Integer.parseInt(st.nextToken());

				if (arr2d[i][z] != 0) {

					m2obj.visit[i][z] = true;
					m2obj.mem_x=z;
					m2obj.mem_y=i;

				}

			}

		} // input

		int dfs_flag = 0;

		int answer = 0;

		while (true) {

			answer++;

			m2obj.sel = new boolean[n][m];
			
			m2obj.dfs2(m2obj.mem_x,m2obj.mem_y , arr2d);
			
			//System.out.println(Arrays.deepToString(arr2d));

			//System.out.println(dfs_flag + "@@ ice_C= " + m2obj.ice_counter + " year=" + answer);

			m2obj.ice_counter = m2obj.ice_counter - m2obj.ice_sub;
			
			m2obj.sel= new boolean[n][m];
			
			m2obj.dfs(m2obj.mem_x, m2obj.mem_y, arr2d);// 덩어리와 비교 할 준비
			

			dfs_flag = m2obj.res;

			//System.out.println(dfs_flag + "@@ ice_C= " + m2obj.ice_counter + " year=" + answer);
            if (m2obj.ice_counter == 0 || dfs_flag==0) {
                
				answer = 0;
                
				break;

			} // 빙하는 다 녹았는데
			if (dfs_flag != m2obj.ice_counter) {

				break;

			}
            
			m2obj.res = 0;
			m2obj.ice_counter=0;
			m2obj.ice_sub=0;
		} // while end

		System.out.println(answer);

	}// main end

}