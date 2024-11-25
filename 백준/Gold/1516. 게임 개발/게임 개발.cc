
#include <iostream>
#include <array>
#include<algorithm>
#include <vector>
#include<string>
#include<cmath>

using namespace std;

vector<int> res(501, 0);// 정답제출용 
vector<bool> visit(501, false);
int main()
{
    cin.tie(0)->sync_with_stdio(0);
    void Function1(const vector<int>& v, const vector<vector<int>>& ad,int start);
    int N=0;
    cin >> N;
    vector<int> V(N,0);// 비용 입력받기 
    vector<vector<int>> adj(N,vector<int>(0,0));// 노드간 연결관계
    vector<int> indegree(N, 0);
    
    for (int i = 0; i < N; i++) {

        int time;
        int beforeContruct;
        int cur=0;
        cin >> time;
        V[i] = time;
         while (cur != -1) {
             cin >> cur;
             
             if (cur != -1) {

                
                 adj[i].push_back(cur - 1);
                 indegree[i]++;
             }
             else {
                 break;
             }
         }
        
    }
    res[0] = V[0];
    for (int i = 0; i < N; i++) {
        Function1(V, adj, i);
    }


    for (int r = 0; r < N; r++) {

        cout << res[r] << "\n";


    }

    return 0;
}
void Function1(const vector<int>& v, const vector<vector<int>>& ad, int start) {

    if (visit[start]) return;
    visit[start] = true;

    //cout << res[start] << "!!@ \n";
    int cost = 0;

    for (int before : ad[start]) {
        if (!visit[before]) {
            Function1(v,ad,before);
        }
        cost = max(cost, res[before]);
    }

    // 현재 건물의 완료 시간 = 선행 건물의 최대 완료 시간 + 현재 건물의 건설 시간
    res[start] = cost + v[start];
    

}


