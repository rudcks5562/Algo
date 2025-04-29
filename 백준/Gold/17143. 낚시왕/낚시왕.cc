
#include <iostream>
#include <array>
#include<algorithm>
#include <vector>
#include<string>
#include<cmath>
#include <queue>
#include <map>
using namespace std;

struct Shark;
vector<Shark*> Sharks;
int R, C, S;
struct Shark {
    int num;
    int x;
    int y;
    int velocity;
    int direction; //pos, velocity, direction, size ~d = (1, 2, 3, 4)(U, D, R, L)
    int size;
    bool active;
    Shark() {
        num = -1;
        x = -1;
        y = -1;
        velocity = 0;
        direction = 0;
        size = 0;
        active = false;

    }
    Shark(bool act) {
        num = -1;
        x = -1;
        y = -1;
        velocity = 0;
        direction = 0;
        size = 0;

        active = act;
    }


    void Simulate(vector<vector<Shark>>& map, vector<vector<Shark>>& Amap,Shark* ptr) {// movement + eat(사이즈 큰 상어로 덮어씌우기)

        int height = R;
        int width = C;
        int tempX, tempY;
        tempX = x;
        tempY = y;

        switch (direction)
        {
        case 1:
            velocity = velocity % ((height-1)*2);
            break;
        case 2:
            velocity = velocity % ((height - 1) * 2);
            break;
        case 3:
            velocity = velocity % ((width - 1) * 2);
            break;
        case 4:
            velocity = velocity % ((width - 1) * 2);
            break;

        default:
            break;
        }
        for (int v = 0; v < velocity; v++) {

            if (direction == 1 || direction == 2) {

                if (direction == 1) {
                    tempY--;
                    if (tempY == 0) {
                        tempY = 2;
                        direction = 2;
                       
                    }
                }
                else {//d=2
                    tempY++;
                    if (tempY > height) {
                        tempY = height-1;
                        direction = 1;
                        
                    }
                }

            }
            else if(direction==3||direction==4){

                if (direction == 3) {
                    tempX++;
                    if (tempX > width) {
                        tempX = width-1;
                        direction = 4;
                     
                    }
                }
                else {//d=4
                    tempX--;
                    if (tempX == 0) {
                        tempX = 2;
                        direction = 3;
                       
                    }
                }

            }
        }// for end




        if (Amap[tempY][tempX].active) {// 다른 원소 이미존재.

            if (Amap[tempY][tempX].size < size ) {
                // 이동시키려는 상어 크기가 더 큰 경우 
                //&& temp_num > map[tempY][tempX].num

                Amap[tempY][tempX].velocity = velocity;
                Amap[tempY][tempX].direction = direction;
                Amap[tempY][tempX].size = size;
                Amap[tempY][tempX].active = true;
                Amap[tempY][tempX].y = tempY;
                Amap[tempY][tempX].x = tempX;
                Amap[tempY][tempX].num = num;

              //  ptr = &Amap[tempY][tempX];
        
            }
            else {// 기존원소보다 사이즈 작은데 들어옴.
                active = false;

            }

        }
        else if (Amap[tempY][tempX].active == false) {
            Amap[tempY][tempX].velocity = velocity;
            Amap[tempY][tempX].direction = direction;
            Amap[tempY][tempX].size = size;
            Amap[tempY][tempX].active = true;
            Amap[tempY][tempX].y = tempY;
            Amap[tempY][tempX].x = tempX;
            Amap[tempY][tempX].num = num;
           // ptr = &Amap[tempY][tempX];

        }


    }


};

int BeforeSimulate(vector<vector<Shark>>& maps, int currentR);// 땅에서 가장 가까운 shark 제거






int main()
{
    cin.tie(0)->sync_with_stdio(0);




    int ans = 0;
    cin >> R >> C >> S;

    vector<vector<Shark>> map(R+1, vector<Shark>(C+1,Shark(false)));//겹치는 것 확인용


    if (S == 0) {
        cout << "0";
        return 0;
    }

    for (int zz = 0; zz < S; zz++) {

        int r, c, s, d, z;// pos,velocity,direction,size ~ d=(1,2,3,4)(U,D,R,L)
        cin >> r >> c >> s >> d >> z;

        map[r][c].num = zz;
        map[r][c].velocity = s;
        map[r][c].direction = d;
        map[r][c].size= z;
        map[r][c].active = true;
        map[r][c].y = r;
        map[r][c].x = c;
        Sharks.push_back(&map[r][c]);
    }// input end

    for (int c = 0; c < C ; c++) {// c is character posX

        int res = BeforeSimulate(map, c + 1);//낚시꾼 땅에서 가까운 상어 제거.
        int cnt = 0;

        ans += res;
        vector<vector<Shark>> AfterMap(R + 1, vector<Shark>(C + 1, Shark(false)));

        for (auto shark : Sharks) {
            if (shark->active==true) {
                shark->Simulate(map, AfterMap,shark);
            }
        }

         cnt = 0;

        // cout <<"cur ans: "<< ans << "\n";
         Sharks.clear();
         for (int i = 1; i <= R; i++) {

             for (int j = 1; j <= C; j++) {

                 if (AfterMap[i][j].active == false) {
                     map[i][j].active = false;

                    // cout << "@ ";
                 }
                 else {
                   //  cout << AfterMap[i][j].num << " ";
                     map[i][j] = AfterMap[i][j];
                     Sharks.push_back(&map[i][j]);
                 }


             }
            // cout << "\n";
         }

    }



    cout << ans << "\n";

        return 0;
}

int BeforeSimulate(vector<vector<Shark>>& maps, int currentR)
{
    int size = maps.size();

    for (int z = 1; z < size; z++) {

        if (maps[z][currentR].active) {

            maps[z][currentR].active = false;
            maps[z][currentR].direction = -1;
            maps[z][currentR].velocity = 0;
            int temp = maps[z][currentR].size;
            maps[z][currentR].size = 0;
            int tempNum = maps[z][currentR].num;
            maps[z][currentR].num = 0;
            int cnt = 0;


            return temp;
        }


    }


    return 0;
}
