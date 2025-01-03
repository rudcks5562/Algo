
#include <iostream>
#include <array>
#include<algorithm>
#include <vector>
#include<string>
#include<cmath>

using namespace std;
enum cmd {
    none,
    east,
    west,
    north,
    south
};
struct dice{
    int cur_x;
    int cur_y;
    vector<int>west2east = {0,0,0,0};//4136 // 3이 동쪽
    vector<int>north2south = {0,0,0,0};//2156 2가 북쪽

    //up coord- 1,1 down coord- 3,3 
    int GetBottomValue() {// 현재 하단의 기록을 가져온다.
        if (west2east[3] != north2south[3]) {
            return -1;
        }
        return west2east[3];
    }
    int GetTopValue() {// 현재 상단의 기록을 가져온다.
        if (west2east[1] != north2south[1]) {
            return -1;
        }
        return west2east[1];
    }
    void ChangeMyBottomValue(int num) {

        west2east[3] = num;
        north2south[3] = num;
    }
    bool BoundCheck(int n, int m,int next_x,int next_y) {

        if (next_y < 0 || next_x < 0 || next_y >= n || next_x >= m) {
            return false;
        }
        return true;

    }
    void AnswerRead() {
        cout << GetTopValue() << "\n";
        return;
    }
    bool Interaction(int cmd,int n,int m) {// 방향에 직관적인 벡터는 사이클 변환을 남은 벡터는 위아래 갱신만 해주면됨.

        switch (cmd) {

            case 1://동
                if (BoundCheck(n, m, cur_x + 1, cur_y)) {
                    cur_x++;
                    int temp = west2east[0];
                    if (west2east.size() > 0) {
                        west2east.erase(west2east.begin());// pop front
                    }
                    west2east.push_back(temp);

                    int temp_up, temp_down;
                    temp_up = west2east[1];
                    temp_down = west2east[3];
                    north2south[1] = temp_up;
                    north2south[3] = temp_down;
                    AnswerRead();
                    return true;
                }
               
            break;

            case 2://서
                if (BoundCheck(n, m, cur_x - 1, cur_y)) {
                    cur_x--;
                    int temp = west2east[3];

                    west2east.pop_back();

                    west2east.insert(west2east.begin(), temp);

                    int temp_up, temp_down;
                    temp_up = west2east[1];
                    temp_down = west2east[3];
                    north2south[1] = temp_up;
                    north2south[3] = temp_down;
                    AnswerRead();
                    return true;
                }
               
            break;
            
            case 3://북
                if (BoundCheck(n, m, cur_x, cur_y-1)) {
                    cur_y--;
                    int temp = north2south[3];

                    north2south.pop_back();

                    north2south.insert(north2south.begin(), temp);

                    int temp_up, temp_down;
                    temp_up = north2south[1];
                    temp_down = north2south[3];
                    west2east[1] = temp_up;
                    west2east[3] = temp_down;
                    AnswerRead();
                    return true;
                }
                
                break;
            case 4://남
                if (BoundCheck(n, m, cur_x, cur_y+1)) {
                    cur_y++;
                    int temp = north2south[0];
                    if (north2south.size() > 0) {
                        north2south.erase(north2south.begin());// pop front
                    }
                    north2south.push_back(temp);

                    int temp_up, temp_down;
                    temp_up = north2south[1];
                    temp_down = north2south[3];
                    west2east[1] = temp_up;
                    west2east[3] = temp_down;
                    AnswerRead();
                    return true;
                }
                
                break;
        }
        return false;
    }
    void AfterInteration(vector<vector<int>>& maps) {

        if (maps[cur_y][cur_x] == 0) {
            maps[cur_y][cur_x] = this->GetBottomValue();
        }
        else {
            north2south[3] = maps[cur_y][cur_x];
            west2east[3] = maps[cur_y][cur_x];
            maps[cur_y][cur_x] = 0;
        }
        return;
    }
};



int main()
{
    cin.tie(0)->sync_with_stdio(0);

    int N, M, K;
    int start_x, start_y;
    cin >> N >> M >> start_y >> start_x >> K;
    vector<vector<int>>map(N, vector<int>(M, 0));

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {

            cin >> map[i][j];

        }
    }// input comp

    vector<int>cmdRecord(K, 0);

    for (int c = 0; c < K; c++) {
        cin >> cmdRecord[c];

    }

    dice myDice;
    myDice.cur_x = start_x;
    myDice.cur_y = start_y;
    
    for (int c = 0; c < K; c++) {
        int cur_cmd = cmdRecord[c];
        
        if (myDice.Interaction(cur_cmd, N, M)){
            myDice.AfterInteration(map);
        }
       
    }
    return 0;
}