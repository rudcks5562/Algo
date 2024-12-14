
#include<stdlib.h>
#include<stdio.h>
#include<algorithm>
#include<math.h>
#include<iostream>
#include <vector>
#include <string.h>
using namespace std;



int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	int N;
	int ans = 0;
	
	cin >> N;

	vector<int> input(100001, 0);
	int DP[2][100001];
	memset(DP, 0, sizeof(DP));
	

	for (int i = 0; i < N; i++) {

		cin >> input[i];

	}

	DP[0][0] = DP[1][0] = input[0];
	ans = input[0];
	for (int i = 0; i < N; i++) {

		DP[0][i] = DP[1][i] = input[i];

		if (i != 0) {

			DP[0][i] = max(DP[0][i-1] + input[i], DP[0][i]);// 누적합 vs 다음원소 순수값

			DP[1][i] = max(DP[0][i-1], DP[1][i-1] + input[i]);// 삭제가 여기서 된것이거나, 이전삭제+



		}


		ans = max(ans, max(DP[0][i], DP[1][i]));// 부분적으로 고를수 있기 때문에 뒤로넘어가면 반드시포함하게되는 꼴이라서 매번 기록


	}

	cout << ans;






	return 0;

}
