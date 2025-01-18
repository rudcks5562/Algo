
#include<stdlib.h>
#include<stdio.h>
#include<algorithm>
#include<math.h>
#include<iostream>
#include <vector>
#include <queue>
#include <string>
#include <memory.h>
using namespace std;


int cheeseNums = 0;
int BFS(int N, int M, vector<vector<int>>& maps, vector<vector<int>>& checker);
int dx[] = {1,-1,0,0};
int dy[] = { 0,0,-1,1 };

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);


	int N, M;
	bool noCheese = true;
	cin >> N >> M;

	vector<vector<int>> maps(N, vector<int>(M, 0));
	vector<vector<int>> airChecker(N, vector<int>(M, -1));

	for (int i = 0; i < N; i++) {

		for (int j = 0; j < M; j++) {

			int temp;
			cin >> temp;
			maps[i][j] = temp;
			if (temp == 0) {
				continue;
			}
			else {//cheese 존재
				airChecker[i][j] = 0;// cheese valid-> 계산시에 양수로 저장할까?
				noCheese = false;
				cheeseNums++;
			}
		}
	}
	//치즈가 없는 경우도 있는가?
	if (noCheese) {
		cout << "0" << endl;
		return 0;
	}



	int ans = BFS(N,M,maps,airChecker);

	cout << ans << endl;


	return 0;
}

int BFS(int N, int M, vector<vector<int>>& maps, vector<vector<int>>& checker)
{
	int ans = 0;


	int tempCnt = 0;// cheese melted cnt

	while (tempCnt != cheeseNums) {
		queue<pair<int, int>> q;
		q.push(make_pair(0, 0));
		vector<vector<int>> visit(N, vector<int>(M, 0));


		while (!q.empty()) {

			int sz = q.size();
			for (int qsz = 0; qsz < sz; qsz++) {

				pair<int, int> cur = q.front();
				int cur_x = cur.second;
				int cur_y = cur.first;
				q.pop();

				for (int d = 0; d < 4; d++) {

					if (cur_x + dx[d] < 0 || cur_y + dy[d] < 0 || cur_x + dx[d] >= M || cur_y + dy[d] >= N) {//array bound check
						continue;
					}
					if (visit[cur_y + dy[d]][cur_x + dx[d]] == 1) {// already visited
						continue;
					}
					if (maps[cur_y + dy[d]][cur_x + dx[d]] == 1) {//meet cheese
						continue;

					}
					visit[cur_y + dy[d]][cur_x + dx[d]] = 1;
					q.push(make_pair(cur_y + dy[d], cur_x + dx[d]));
					checker[cur_y + dy[d]][cur_x + dx[d]] = 1;// 외곽 공기(1)와 갇힌 공기(-1)를 구분한다.


				}// delta end


			}// qsz for end
			

		}// out air check end
		// 이제 2면이상 접촉하는 치즈를 녹여야 한다.
		
		queue<pair<int, int>> secQ;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				if (maps[i][j] == 1) {
					int ConditionCnt = 0;
					int dir[4];
					dir[0] = checker[i + 1][j];
					dir[1] = checker[i - 1][j];
					dir[2] = checker[i ][j+1];
					dir[3] = checker[i ][j-1];// 테두리에는 치즈가 없으므로..

					for (int temp : dir) {

						if (temp == 1) {
							ConditionCnt++;

						}
					}
					if (ConditionCnt >= 2) {
						pair<int, int> item = make_pair(i, j);
						secQ.push(item);
						//cout << "@@@y= " << i << " x= " << j << " DEL      cnt= " << ConditionCnt << endl;

					}
					//cout << "y= " << i << " x= " << j << " cnt= " << ConditionCnt << endl;
				}
			}
		}// 치즈 녹이기 끝.
		int secQsz = secQ.size();
		for (int qq = 0; qq < secQsz; qq++) {

			pair<int,int> cur=secQ.front();
			int y = cur.first;
			int x = cur.second;
			maps[y][x] = 0;
			checker[y][x] = 1;// 이것이 외곽공기인지 아닌지 판단은 다음 순회에서 가능하므로 + 녹았으니까 외곽이 닿은거 아닌가?
			tempCnt++;
			secQ.pop();
			//cout << "y= " << y << " x= " << x  << endl;

		}

		//cout << "--------?" << "\n";
		/*
				for (int i = 0; i < N; i++) {

			for (int j = 0; j < M; j++) {


				cout << maps[i][j] << " ";
				}

		cout << "\n";
		}
		cout << "--------" << "\n";
		*/


		ans++;
	}//치즈 전체단계 순회의 끝




	return ans;
}
