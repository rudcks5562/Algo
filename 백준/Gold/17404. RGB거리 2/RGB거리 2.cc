
#include<stdlib.h>
#include<stdio.h>
#include<algorithm>
#include<math.h>
#include<iostream>
#include <vector>
#include <string.h>
using namespace std;


int N;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);



	cin >> N;
	
	vector<vector<int>> map(N, vector<int>(3, 0));
	int ans = 1001*1001;
	
	
	int r, g, b;
	for (int i = 0; i < N; i++) {
		cin >> r >> g >> b;
		map[i][0] = r;
		map[i][1] = g;
		map[i][2] = b;
	}
	for (int z = 0; z < 3; z++) {// start고정
		int DP[1001][3];//start, cur, color

		for (int j = 0; j < 3; j++) {
			if (j == z) DP[0][z] = map[0][z];
			else DP[0][j] = 1001*1001;
		}
		
		for (int i = 1; i < N; i++) {

			int tempR = min(DP[i - 1][1], DP[i - 1][2]);
			int tempG = min(DP[i - 1][0], DP[i - 1][2]);
			int tempB = min(DP[i - 1][0], DP[i - 1][1]);

			for (int s = 0; s < 3; s++) {

				if (s == 0) {
					DP[i][0] = tempR + map[i][0];
				}
				else if (s == 1) {
					DP[i][1] = tempG + map[i][1];
				}
				else {
					DP[i][2] = tempB + map[i][2];
				}
			}
		}
		if (N < 1) {
			break;
		}
		for (int j = 0; j <= 2; j++) {
			if (j == z) continue;
			ans = min(ans, DP[N-1][j]);
		}
		

	}

	cout << ans;



	



	return 0;
}