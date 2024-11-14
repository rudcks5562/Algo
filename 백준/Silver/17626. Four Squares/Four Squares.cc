#include<iostream>
#include<algorithm>
#include<vector>
#include<limits.h>






int main() {
    std::ios::sync_with_stdio(false); std::cin.tie(NULL); std::cout.tie(NULL);
    int n;
    std::cin>>n;
    std::vector<int>dp(n + 1, 0);
    dp[1] = 1;

    for(int i=2;i<=n;i++){

        int minss= INT_MAX;
        for(int j=1;j*j<=i;j++){
            int idx= i-j*j;
            minss= std::min(minss,dp[idx]);

        }

        dp[i]=minss+1;

    }

    std::cout<<dp[n];



    return 0;
}
