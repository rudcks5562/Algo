
#include <iostream>
#include <array>
#include<algorithm>
#include <vector>
#include<string>
#include<cmath>
#include <queue>
#include"memory.h"

using namespace std;
int BFS(int M, int N, int H);
int maps[101][101][101];

//priority_queue<pair<int, pair<int, int>>> pq;// h,y,x;
queue<pair<int, pair<int, int>>> q;

int main()
{
    cin.tie(0)->sync_with_stdio(0);

    memset(maps, 0, sizeof(maps));

    int M, N, H;
    cin >> M >> N >> H;
    int checker = 0;//1 개수
    int minusChecker = 0;

    for (int s = 0; s < H; s++) {

        for (int i = 0; i < N; i++) {

            for(int j=0;j<M;j++){
            
                cin>>maps[s][i][j];
                if (maps[s][i][j] == 1) {
                    q.push(make_pair(s, make_pair(i, j)));
                    checker++;
                }
                if (maps[s][i][j] == -1) {
                    minusChecker++;
                }
            }
        }
    }// input end
    if (checker+minusChecker == H * M * N) {
        cout << "0" << endl;
        return 0;
    }


    int ans=BFS(M, N, H);

    if (ans == -1) {
        cout << "-1";
    }
    else {
        cout << ans-1 ;
    }
    


    return 0;
}

int BFS(int M, int N, int H)
{
    int dx[] = { 1,-1,0,0,0,0 };
    int dy[] = { 0,0,1,-1,0,0 };
    int dz[] = { 0,0,0,0,1,-1 };
    int depth = 0;

    while (!q.empty()) {

        int sz = q.size();
       // cout << "sz is= " << sz<<endl;
        for (int s = 0; s < sz; s++) {
            auto cur = q.front();
            int cur_h, cur_x, cur_y;
            cur_h = cur.first;
            cur_y = cur.second.first;
            cur_x = cur.second.second;
            //cout << cur_h << " " << cur_y <<" " << cur_x << endl;
            q.pop();

            for (int d = 0; d < 6; d++) {
                int next_x = cur_x + dx[d];
                int next_y = cur_y + dy[d];
                int next_z = cur_h + dz[d];
               // cout <<"next is" << next_z << " " << next_y << " " << next_x << endl;
                if (next_x < 0 || next_y < 0 || next_z < 0 || next_x >= M || next_y >= N || next_z >= H) {// array bound check
                    continue;
                }
                if (maps[next_z][next_y][next_x] == 1 || maps[next_z][next_y][next_x] == -1) {// 이미 익은 토마토이거나(방문됨) 도달못하는 곳 체크
                    continue;
                }
                maps[next_z][next_y][next_x] = 1;// 익음
                q.push(make_pair(next_z, make_pair(next_y, next_x)));


            }
            /*
                        for (int s = 0; s < H; s++) {

                for (int i = 0; i < N; i++) {

                    for (int j = 0; j < M; j++) {


                        cout << maps[s][i][j] << " ";

                    }
                    cout << "\n";
                }
                cout << "---" << endl;
            }// input end
            
            
            */


        }
        

      //  cout << "seq end" << endl;
       // cout << "depth is= " << depth + 1 << endl;

        depth++;


        }
    // 모두 익은건지 아닌지 체크
    for (int s = 0; s < H; s++) {

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < M; j++) {

                if (maps[s][i][j] == 0) {
                    return -1;

                }
            }
        }
    }// input end


    return depth;
}
