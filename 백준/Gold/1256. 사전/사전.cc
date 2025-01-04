
#include <iostream>
#include <array>
#include<algorithm>
#include <vector>
#include<string>
#include<cmath>

using namespace std;


int main()
{
    cin.tie(0)->sync_with_stdio(0);

    int N, M, K;// a=n, z=m, k=obj idx
   
    cin >> N >> M >> K;


    vector<vector<long>> DP(101, vector<long>(101, 0));// dp [A][Z] a의 개수 A z의개수 Z인 경우 나오는 문자열의 총량

 

    for (int i = 1; i <= 100; i++) {
        DP[i][0] = 1; 
        DP[0][i] = 1;
    }
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= M; j++) {
            DP[i][j] = DP[i - 1][j] + DP[i][j - 1];
            if (DP[i][j] > 1000000000) DP[i][j] = 1000000000;
        }
    }
    if(DP[N][M] < K) {
        cout << -1; 
        return 0;
    }
    int a_cnt = N;
    int z_cnt = M;
    for (int s = 0; s < N + M; s++) {
        if (a_cnt == 0) {
            cout << 'z';
            z_cnt--;
            continue;
        }
        else if (z_cnt == 0) {
            cout << 'a';
            a_cnt--;
            continue;
        }
        int a_start = DP[a_cnt - 1][z_cnt];//생성 개수
        int z_start = DP[a_cnt][z_cnt - 1];

        //cout << a_start << endl;


        if (K <= a_start) {//a로 시작하는 경우의 문자열
            cout << 'a';
            a_cnt--;
        }
        else {// z로 시작하는 문자열
            K = K - a_start;
            cout << 'z';
            z_cnt--;
        }




    }







    cout << "\n";


    return 0;
}