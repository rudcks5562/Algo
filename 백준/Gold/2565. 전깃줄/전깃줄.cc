
#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <array>
#include<algorithm>
#include <vector>
#include<string>
#include<cmath>
#include<cstring>

using namespace std;

bool compare1(pair<int,int>a,pair<int,int>b) {
    return a.first < b.first;
}

int main()
{
    cin.tie(0)->sync_with_stdio(0);
    
    int N;

    vector<pair<int, int>> inputs;

    cin >> N;

    for (int s = 0; s < N; s++) {

        int a, b;
        cin >> a >> b;
        inputs.push_back(make_pair(a, b));

    }

    sort(inputs.begin(),inputs.end(),compare1);

    vector<int>DP(501, 1);
    int ans = 0;

    for (int i = 0; i < N; i++) {

        for (int j = 0; j < i; j++) {

            if (inputs[j].second < inputs[i].second) {
                DP[i] = max(DP[i], DP[j] + 1);
            }


        }
        ans = max(ans, DP[i]);
    }
    cout << N-ans;

    return 0;
}



