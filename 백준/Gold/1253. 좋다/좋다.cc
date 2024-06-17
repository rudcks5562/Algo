// algo1.cpp : 이 파일에는 'main' 함수가 포함됩니다. 거기서 프로그램 실행이 시작되고 종료됩니다.
//

#include <iostream>
#include <array>
#include<algorithm>


using namespace std;

int main()
{

    int N;
    int ans = 0;

    cin >> N;


    long long* arrs = new long long[N];


    for (int s = 0; s < N; s++) {

        cin >> arrs[s];
    }
    // n= 1~2000, 

    sort(arrs, arrs + N);


    for (int i = 0; i < N; i++) {// 평가받을 수

        for (int f = 0; f < N; f++) {// 더할 첫번째수 

            if (i == f) continue;// 다른 두 수 이므로..
            bool flag = false;
            int start = f + 1;
            int end = N - 1;
            while (start <= end) {

                
                int mid= (start + end) / 2;// 더할 두 번째 수를 이분탐색으로 찾기.

                if (mid == i) {// 끝점이 i에 도달하였으므로 이 이상의 탐색은 무의미.

                    if (arrs[f] + arrs[mid] > arrs[i]) {// 예상치가 탐색치 보다 큰 경우 최대예상값을 줄이고
                        end = mid - 1;
                    }
                    else {// 반대이면 최소예상치를 증폭
                        start = mid + 1;

                    }
                }
                else {// mid 가 i 가 아닌경우. 탐색 진행중

                    if (arrs[f] + arrs[mid] > arrs[i])// 예상치가 큰 경우 
                        end = mid - 1;
                    else if (arrs[f] + arrs[mid] < arrs[i])// 예상치가 작은경우 
                        start = mid + 1;
                    else {// 예상치가 목표i와 같은경우->정답. 
                        flag = true;
                        ans++;
                        break;
                    }


                }




            }
            if (flag) { break; }




        }






    }

    cout << ans;


    delete[] arrs;


}


