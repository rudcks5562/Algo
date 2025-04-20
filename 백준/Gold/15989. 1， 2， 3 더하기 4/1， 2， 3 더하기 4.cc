
#include <iostream>
#include <array>
#include<algorithm>
#include <vector>
#include<string>
#include<cmath>
#include <queue>
#include"memory.h"
using namespace std;


int main()
{
    cin.tie(0)->sync_with_stdio(0);
    vector<int> DP(10001, 1);//모든 1의합으로 구성된 첫 구성 세팅
     
    for (int i = 2; i < 4; i++) {

        for (int j = i; j < 10001; j++) {//2를 포함한 경우의 수는 2를 더해줘야하기 때문에 2칸 떨어진 DP에서덧셈. 3을 포함하는 경우에는 3을 포함해야하기때문에 3칸 떨어진 칸으로부터 추출.

            DP[j] += DP[j - i];
        }
    }


    int TC = 0;

    cin >> TC;

    vector<int> input(TC, 0);

    for (int t = 0; t < TC; t++) {

        cin >> input[t];

    }

    for (int output : input) {

        cout << DP[output] << "\n";

    }


        return 0;
}