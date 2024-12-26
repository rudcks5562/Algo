#include <iostream>
#include <array>
#include<algorithm>
#include <vector>
#include<string>
#include<cmath>
# define MAX 4000001

using namespace std;

int main()
{
    cin.tie(0)->sync_with_stdio(0);


    int N,ans;
    cin >> N;
    ans = 0;
    if (N == 1) {
        cout << 0 << endl;
        return 0;
    }
    vector<int> primes(MAX+1, 1);
    vector<int> psum;


    int temp_sum = 0;

    //1 소수 확인 함수 또는 배열 생성
    // 부분합 만들기
    // 
    for (int s = 2; s*s<= N; s++) {

        if (primes[s] == 1) {
           
            
            //psum.push_back(temp_sum);

            for (int z = s * s; z <= N; z += s) {// 4인경우 이전 순회에서 뒤집어보면 3*4 를 햇을테니 4*4부터..
                primes[z] = -1;
            }
        }
    }
    for (int i = 2; i <= N; i++) // 소수들을 벡터에 담음 -> 계산 편리
    {
        if (primes[i] == 1) {
            
            psum.push_back(temp_sum);
            temp_sum += i;
        }
    }

    int left = 1;
    int right = 1;

    //구간합 벡터 완성.
    while (true) {

        int temp = psum[right] - psum[left-1];

        if (temp >N) {
            left++;
        }
        else if (temp < N) {
            right++;
        }
        else if(temp==N){
            //cout << "L:" << left << " right= " << right << endl;
            ans++;
            right++;
        }
        if (right >= psum.size()) { break; }

    }
    if (primes[N] == 1) {
        ans++;
    }

    cout << ans;
  





    return 0;
}
