

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {

	int x;
	int y;
	int value;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Point(int x, int y, int value) {
		this.x = x;
		this.y = y;
		this.value = value;
	}

}

public class Main {

	static int N, M;
	static int map[][];
	static int dx[] = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };// 0,←, ↖, ↑, ↗, →, ↘, ↓, ↙
	static int dy[] = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
	static int input_dir[];
	static int input_dis[];
	static int visit[][];

	static Queue clouds = new LinkedList<Point>();
	static Queue imp_sector = new LinkedList<Point>();

	public static void main(String[] args) throws IOException {

		// (N, 1), (N, 2), (N-1, 1), (N-1, 2)

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		StringTokenizer st = new StringTokenizer(a);

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		input_dir = new int[M];
		input_dis = new int[M];
		visit = new int[N][N];

		for (int i = 0; i < N; i++) {
			a = br.readLine();
			st = new StringTokenizer(a);
			for (int j = 0; j < N; j++) {

				map[i][j] = Integer.parseInt(st.nextToken());

			}

		}

		for (int s = 0; s < M; s++) {
			a = br.readLine();
			st = new StringTokenizer(a);

			input_dir[s] = Integer.parseInt(st.nextToken());
			input_dis[s] = Integer.parseInt(st.nextToken());
		} // input end

		// limit
		// 2<=N<=50 , 1<=M<=100 , val=0~100, 1<=dir<=8 , 1<=dis<=50

		// (N, 1), (N, 2), (N-1, 1), (N-1, 2)
		clouds.offer(new Point(0, N - 1, map[0][N - 1]));
		clouds.offer(new Point(1, N - 1, map[1][N - 1]));
		clouds.offer(new Point(0, N - 2, map[0][N - 2]));
		clouds.offer(new Point(1, N - 2, map[1][N - 2]));

		// init

		for (int s = 0; s < M; s++) {

			int move = input_dis[s];
			int dir = input_dir[s];

			int sz = clouds.size();

			for (int t = 0; t < sz; t++) {

				Point cur = (Point) clouds.poll();

				cur = coordinator_manager(dir, move, cur.x, cur.y);

				map[cur.y][cur.x]++;

				imp_sector.add(cur);

			} // rain

		//	for (int i = 0; i < N; i++) {

		//		for (int j = 0; j < N; j++) {

			//		System.out.print(map[i][j] + " ");
		//		}
		//		System.out.println("");
		//	}

		//	System.out.println("after rain");

			// checked

			int orimap[][] = new int[N][N];

			for (int i = 0; i < N; i++) {

				for (int j = 0; j < N; j++) {

					orimap[i][j] = map[i][j];
				}
			}

			sz = imp_sector.size();

			for (int t = 0; t < sz; t++) {// cp bug

				Point cur = (Point) imp_sector.poll();

				visit[cur.y][cur.x]++;

				for (int d = 1; d <= 8; d++) {
					if (d % 2 != 0) {
						continue;
					}
					int now_x = cur.x;
					int now_y = cur.y;
					now_x += dx[d];
					now_y += dy[d];

					if (now_x < 0 || now_y < 0 || now_x >= N || now_y >= N || orimap[now_y][now_x] == 0) {

						continue;
					}

					map[cur.y][cur.x] = map[cur.y][cur.x] + 1;

				}

			}

		//	for (int i = 0; i < N; i++) {

			//	for (int j = 0; j < N; j++) {

			//		System.out.print(map[i][j] + " ");
		//		}
			//	System.out.println("");
			//}

			//System.out.println("after cpbug");

			for (int i = 0; i < N; i++) {// searching
				for (int j = 0; j < N; j++) {

					if (map[i][j] >= 2 && visit[i][j] == 0) {

						clouds.add(new Point(j, i, map[i][j] - 2));
						map[i][j] = map[i][j] - 2;
					}

				}

			}

			// 3 all clouds gone
		//	for (int i = 0; i < N; i++) {

			//	for (int j = 0; j < N; j++) {

		//			System.out.print(visit[i][j] + " ");
		//		}
		//		System.out.println("");
		//	}
		//	System.out.println("vvvvvvvvvvvvvvvvvvvvvv");
			visit = new int[N][N];

		//	for (int i = 0; i < N; i++) {

		//		for (int j = 0; j < N; j++) {

			//		System.out.print(map[i][j] + " ");
		//		}
		//		System.out.println("");
		//	}
		//	System.out.println("----------------------------");

		} // cmd end

		int sum = 0;

		for (int i = 0; i < N; i++) {

			for (int j = 0; j < N; j++) {

				sum += map[i][j];
			}
		}

		System.out.println(sum);

	}// main end

	public static Point coordinator_manager(int dir, int seq, int x, int y) {

		Point temp = new Point(x, y, map[y][x]);
		int now_x = x;
		int now_y = y;

		// System.out.println("dir= " + dir + " " + "seq= " + seq + " " + " x= " + x + "
		// y= " + y);

		switch (dir) {

		case 1:
			now_x = x + dx[1] * seq;
			now_y = y + dy[1] * seq;

			if (now_x < 0) {

				int temp1 = Math.abs(now_x);
				temp1 = temp1 % N;
				if (temp1 == 0) {
					now_x = 0;
				} else {
					now_x = N - temp1;
				}

			} else {

				if (now_x >= N) {
					now_x = now_x % N;

				}

			}
			if (now_y < 0) {

				int temp1 = Math.abs(now_y);
				temp1 = temp1 % N;
				if (temp1 == 0) {
					now_y = 0;
				} else {
					now_y = N - temp1;
				}

			} else {
				if (now_y >= N) {
					now_y = now_y % N;

				}

			}

			temp.x = now_x;
			temp.y = now_y;
			temp.value = map[temp.y][temp.x];

			break;

		case 2:
			now_x = x + dx[2] * seq;
			now_y = y + dy[2] * seq;

			if (now_x < 0) {

				int temp1 = Math.abs(now_x);
				temp1 = temp1 % N;
				if (temp1 == 0) {
					now_x = 0;
				} else {
					now_x = N - temp1;
				}

			} else {

				if (now_x >= N) {
					now_x = now_x % N;

				}

			}
			if (now_y < 0) {

				int temp1 = Math.abs(now_y);
				temp1 = temp1 % N;
				if (temp1 == 0) {
					now_y = 0;
				} else {
					now_y = N - temp1;
				}

			} else {
				if (now_y >= N) {
					now_y = now_y % N;

				}

			}

			temp.x = now_x;
			temp.y = now_y;
			temp.value = map[temp.y][temp.x];

			break;

		case 3:
			now_x = x + dx[3] * seq;
			now_y = y + dy[3] * seq;

			if (now_x < 0) {

				int temp1 = Math.abs(now_x);
				temp1 = temp1 % N;
				if (temp1 == 0) {
					now_x = 0;
				} else {
					now_x = N - temp1;
				}

			} else {

				if (now_x >= N) {
					now_x = now_x % N;

				}

			}
			if (now_y < 0) {

				int temp1 = Math.abs(now_y);
				temp1 = temp1 % N;
				if (temp1 == 0) {
					now_y = 0;
				} else {
					now_y = N - temp1;
				}

			} else {
				if (now_y >= N) {
					now_y = now_y % N;

				}

			}

			temp.x = now_x;
			temp.y = now_y;
			temp.value = map[temp.y][temp.x];

			break;

		case 4:
			now_x = x + dx[4] * seq;
			now_y = y + dy[4] * seq;

			if (now_x < 0) {

				int temp1 = Math.abs(now_x);
				temp1 = temp1 % N;
				if (temp1 == 0) {
					now_x = 0;
				} else {
					now_x = N - temp1;
				}

			} else {

				if (now_x >= N) {
					now_x = now_x % N;

				}

			}
			if (now_y < 0) {

				int temp1 = Math.abs(now_y);
				temp1 = temp1 % N;
				if (temp1 == 0) {
					now_y = 0;
				} else {
					now_y = N - temp1;
				}

			} else {
				if (now_y >= N) {
					now_y = now_y % N;

				}

			}

			temp.x = now_x;
			temp.y = now_y;
			temp.value = map[temp.y][temp.x];

			break;

		case 5:
			now_x = x + dx[5] * seq;
			now_y = y + dy[5] * seq;

			if (now_x < 0) {

				int temp1 = Math.abs(now_x);
				temp1 = temp1 % N;
				if (temp1 == 0) {
					now_x = 0;
				} else {
					now_x = N - temp1;
				}

			} else {

				if (now_x >= N) {
					now_x = now_x % N;

				}

			}
			if (now_y < 0) {

				int temp1 = Math.abs(now_y);
				temp1 = temp1 % N;
				if (temp1 == 0) {
					now_y = 0;
				} else {
					now_y = N - temp1;
				}

			} else {
				if (now_y >= N) {
					now_y = now_y % N;

				}

			}

			temp.x = now_x;
			temp.y = now_y;
			temp.value = map[temp.y][temp.x];

			break;

		case 6:
			now_x = x + dx[6] * seq;
			now_y = y + dy[6] * seq;

			if (now_x < 0) {

				int temp1 = Math.abs(now_x);
				temp1 = temp1 % N;
				if (temp1 == 0) {
					now_x = 0;
				} else {
					now_x = N - temp1;
				}

			} else {

				if (now_x >= N) {
					now_x = now_x % N;

				}

			}
			if (now_y < 0) {

				int temp1 = Math.abs(now_y);
				temp1 = temp1 % N;
				if (temp1 == 0) {
					now_y = 0;
				} else {
					now_y = N - temp1;
				}

			} else {
				if (now_y >= N) {
					now_y = now_y % N;

				}

			}

			temp.x = now_x;
			temp.y = now_y;
			temp.value = map[temp.y][temp.x];

			break;

		case 7:
			now_x = x + dx[7] * seq;
			now_y = y + dy[7] * seq;

			if (now_x < 0) {

				int temp1 = Math.abs(now_x);
				temp1 = temp1 % N;
				if (temp1 == 0) {
					now_x = 0;
				} else {
					now_x = N - temp1;
				}

			} else {

				if (now_x >= N) {
					now_x = now_x % N;

				}

			}
			if (now_y < 0) {

				int temp1 = Math.abs(now_y);
				temp1 = temp1 % N;
				if (temp1 == 0) {
					now_y = 0;
				} else {
					now_y = N - temp1;
				}

			} else {
				if (now_y >= N) {
					now_y = now_y % N;

				}

			}

			temp.x = now_x;
			temp.y = now_y;
			temp.value = map[temp.y][temp.x];

			break;

		case 8:
			now_x = x + dx[8] * seq;
			now_y = y + dy[8] * seq;
			//System.out.println(now_x + "@ " + now_y);
			if (now_x < 0) {

				int temp1 = Math.abs(now_x);
				temp1 = temp1 % N;
				if (temp1 == 0) {
					now_x = 0;
				} else {
					now_x = N - temp1;
				}

			} else {

				if (now_x >= N) {
					now_x = now_x % N;

				}

			}
			if (now_y < 0) {

				int temp1 = Math.abs(now_y);
				temp1 = temp1 % N;
				if (temp1 == 0) {
					now_y = 0;
				} else {
					now_y = N - temp1;
				}

			} else {
				if (now_y >= N) {
					now_y = now_y % N;

				}

			}

			temp.x = now_x;
			temp.y = now_y;
			temp.value = map[temp.y][temp.x];
			//System.out.println(now_x + " " + now_y);
			break;

		}

		return temp;

	}

}
