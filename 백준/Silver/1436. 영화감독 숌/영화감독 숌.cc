
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

    int cnt = 0;
    int N;
    std::cin >> N;


    for (int i = 666; cnt <= N; i++) {
        
        string nums = to_string(i);
        if (nums.find("666") != std::string::npos) {
            cnt++;
        }
        if (cnt == N) {
            cout << nums;
            return 0;
        }
    }



    return 0;
}
