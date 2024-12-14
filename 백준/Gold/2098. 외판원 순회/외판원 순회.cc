
#include<stdlib.h>
#include<stdio.h>
#include<algorithm>
#include<math.h>
#include<iostream>
#include <vector>

using namespace std;
#define INF 987654321;

int N;

vector<vector<int>>W(16, vector<int>(16, 0));// 비용행렬
vector<vector<int>> DP(16, vector<int>(1 << 16, -1));// 
int TSP(int start, int visit);

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	//TSP problem- boj 2098


	// 2~16
	cin >> N;



	for (int i = 0; i < N; i++) {

		for (int j = 0; j<N;j++) {

			cin>>W[i][j];
		}
	}// input end


	cout<<TSP(0, 1);


	return 0;

}

int TSP(int start, int visit)// start에서 not visit을 경유하여 최적으로 비용을 소모하는
{
	if (visit == ((1 << N)-1)) {// 기저조건
		if (W[start][0] == 0) //이동불가능
			return INF;
		return W[start][0];

	}
	if (DP[start][visit] != -1) {// 이미 기록된 DP면?
		return DP[start][visit];
	}
	// 새로운 DP면?
	DP[start][visit] = INF;


	for (int i = 0; i < N; i++) {

		if (W[start][i] == 0) {// 길없음
			continue;
		}
		if ((visit & (1 << i)) == (1 << i)) {// 이미 방문된 마을
			continue;
		}

		DP[start][visit] = min(DP[start][visit], W[start][i] + TSP(i, visit | (1 << i)));

	}


	return DP[start][visit];
}
