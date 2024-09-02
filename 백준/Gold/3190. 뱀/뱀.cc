
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

    int N, K, L;
    int ans = 0;
    cin >> N;

    vector <vector <int>> maps(N,vector<int>(N,0));
    vector<pair<int,int>>snake;// 초기 길이 1, 지나온길 기록용(몸통이 위치)
    vector<pair<int, char>> record;
    int currentDirection = 2;//(상우하좌,1,2,3,4) 초기값 오른쪽.
    bool gameFlag = true;
    int dx[] = { 0,1,0,-1 };
    int dy[] = { -1,0,1,0};
    int cur_x = 0;
    int cur_y = 0;

    cin >> K;
    for (int s = 0; s < K; s++) {

        int rows, cols;
        cin >> cols >> rows;
        maps[cols-1][rows-1] = 1;// 사과.
    }
    cin >> L;
    for (int s = 0; s < L; s++) {

        int x;
        char c;// D=right, L=left
        cin >> x >> c;

        record.push_back(pair<int, char>(x, c));
    }
    // input end

    //.push_back(pair<int, int>(0, 0));// 초기이동좌표
    // 벽이나 길이증가 없음.
    sort(record.begin(), record.end());

    while (gameFlag == true) {// 좌표정의 0=빈칸, 1=사과, 2=자기자신몸

       // std::cout << ans<<" ST: current dir= " << currentDirection << " cur_y= " << cur_y << ", cur_x= " << cur_x << endl;
        
        if (cur_x == 0 && cur_y == 0 &&ans==0) {// 초기처리
            cur_x++;
            if (maps[0][1] == 1) {
                maps[0][1] = 2;
                snake.push_back(pair<int, int>(0, 0));
            }
            snake.push_back(pair<int, int>(0, 1));

            ans++;
            continue;
        }
        else {
            // 0. 기록에 방향이 전환되는지 체크한다.
            if (record.size()>0 && record.front().first == ans) {// 진행되는 초수와 기록을 대조 일치하면..
                char nextDir = record.front().second;
                if (nextDir == 'L'){ //
                    currentDirection--;
                }
                else if (nextDir == 'D') {
                currentDirection++;
                }
                if (currentDirection == 0) {
                    currentDirection = 4;
                }
                else if (currentDirection == 5) {
                    currentDirection = 1;
                }
                record.erase(record.begin());// 제거
               // std::cout << "CHANGED current dir= " << currentDirection << " cur_y= " << cur_y << ", cur_x= " << cur_x << endl;

                //(상우하좌, 1, 2, 3, 4)// 오른쪽90 = ++
            }

            //1. 머리를 현방향으로 내민다.

            for (int d = 0; d < 4; d++) {

                if (currentDirection-1 == d) {
                  //  std::cout << cur_y << cur_x << endl;
                    cur_x +=dx[d];
                    cur_y +=dy[d];
                //    std::cout << cur_y << cur_x << endl;
                    if (cur_x < 0 || cur_y < 0 || cur_x >= N || cur_y >= N) {// 벽과충돌
                        gameFlag = false;
                        break;
                    }
                    if (maps[cur_y][cur_x] == 2) {//내 몸과 충돌
                        gameFlag = false;
                     //   std::cout << "BODY CHECK\n";
                        break;
                    }
                }

            }
            if (gameFlag == false) {
                break;
            }
            // 머리내밀기 성공.
           // std::cout << "current dir= " << currentDirection << "NEXT: cur_y= " << cur_y << ",NEXT: cur_x= " << cur_x << endl;
            snake.push_back(pair<int, int>(cur_y, cur_x));// 머리위치 기록.

           // std::cout << "snake ADD : " << cur_y << " ," << cur_x << endl;
            if (maps[cur_y][cur_x] == 1) {// 사과존재시 
                maps[cur_y][cur_x] = 2;

            }
            else {
                maps[cur_y][cur_x] = 2;

                int temp_y = snake.front().first;
                int temp_x = snake.front().second;
                maps[temp_y][temp_x] = 0;
                if (snake.size() > 0) {
                  //  std::cout << "snake ERASE : " << temp_y << " ," << temp_x << endl;
                    snake.erase(snake.begin());//꼬리제거
                }
            }
            ans++;
           // std::cout << "SEQ END"<<endl;
        }//else end
    }//while end


    std::cout << ans+1;
    return 0;
}
