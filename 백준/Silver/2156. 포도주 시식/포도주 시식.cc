
#include <iostream>
#include <array>
#include<algorithm>
#include <vector>


using namespace std;

int main()
{
    cin.tie(0)->sync_with_stdio(0);

    int n;
    cin >> n;
    vector<int> DP(n+1);// 가로진행
    vector<int> input(n+1);// 세로진행

    for (int i = 1; i <= n; i++) {
        int t;
        cin >> t;
        input[i] = t;
    }

    DP[0] = 0;
    DP[1] = input[1];
    DP[2] = DP[1] + input[2];

    if (n <= 2) {
        if (n == 1) {
            cout << input[1];
            return 0;
        }
        cout << DP[n]<<endl;
        return 0;
    }
    
   //cout << DP[1] << DP[2] << "? \n";


    for (int i = 3; i <= n; i++) {
        
        int a, b, c;

        a = DP[i - 3] + input[i - 1] + input[i];
        b = DP[i - 2] + input[i];
        c = DP[i - 1];

        DP[i] = max(a, max(b, c));
       // printf("%d : %d    , a:%d, b: %d, c:%d \n",i,DP[i],a,b,c);
    }

    cout << DP[n] << endl;

    return 0;


}


