
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

    int N,P,ans=0;
    cin >> N;

    vector<vector<int>>maps(N+1, vector<int>(N+1, 0));
    vector<vector<int>>map2(N+1,vector<int>(N+1,0));

    for (int s = 1; s <= N; s++) {
        
        for (int z = 1; z <= N; z++) {
            int temp=0;
            cin >> temp;
            maps[s][z] = temp;
        }
    }
    cin >> P;

    for (int p = 0; p < P; p++) {

        int r, c;
        cin >> r >> c;
        map2[r][c] = 1;
    }


    vector<vector<int>>DP(1010,vector<int>(1010,0));
    vector<vector<int>>DP2(1010, vector<int>(1010,0));

    for (int i = 0; i <= N; i++) {

        DP[i][0] = 0;
        DP2[i][0] = 0;

    }
    for (int j = 1; j <= N; j++) {

        DP[0][j] = 0;
        DP2[0][j] = 0;
    }
    for (int i = 1; i <=N; i++) {

        for (int j = 1; j <= N; j++) {


            if (DP[i - 1][j] == DP[i][j - 1]) {
                DP[i][j] = maps[i][j] + max(DP[i - 1][j], DP[i][j - 1]);


                if (DP2[i - 1][j] >= DP2[i][j - 1]) {
                    DP2[i][j] = map2[i][j] + max(DP2[i - 1][j], DP2[i][j - 1]);
                }
                else {
                    DP2[i][j] = map2[i][j] + max(DP2[i - 1][j], DP2[i][j - 1]);
                }
            }
            else {
                DP[i][j] = maps[i][j] + max(DP[i - 1][j], DP[i][j - 1]);

                if (DP[i - 1][j] > DP[i][j - 1]) {
                    DP2[i][j] = map2[i][j] + DP2[i - 1][j];
                }
                else if (DP[i - 1][j] < DP[i][j - 1]) {
                    DP2[i][j] = map2[i][j] + DP2[i][j - 1];
                }
            }
        }

    }






    printf("%d %d\n",DP[N][N],DP2[N][N]);


    return 0;
}
