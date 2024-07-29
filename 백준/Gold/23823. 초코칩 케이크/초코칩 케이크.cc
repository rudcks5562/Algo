#include <iostream>
#include<algorithm>
#include <vector>


using namespace std;

int main()
{
    cin.tie(0)->sync_with_stdio(0);

    int n,q;

    cin >> n >> q;

    vector<int> vx(n+1);// 가로진행
    vector<int> vy(n+1);// 세로진행
    vector<int> ans(q);

    int maxrChoco = 0, maxrPiece = 0;// x
    int maxcChoco = 0, maxcPiece = 0;//y 

    for (int i = 0; i < q; i++) {

        int t, a;
        cin >> t >> a;

        if (t == 1){ // 가로줄:x

            ++vx[a];
            if (vx[a] > maxrChoco) {
                maxrChoco = vx[a];
                maxrPiece = 1;
            }
            else if (vx[a] == maxrChoco) maxrPiece++;


        }
        else {// 세로줄 

            ++vy[a];
            if (vy[a] > maxcChoco) {
                maxcChoco = vy[a];
                maxcPiece = 1;
            }
            else if (vy[a] == maxcChoco) maxcPiece++;

        }

        if (maxrPiece==0) {
            ans[i] = maxcPiece * n;
        }
        else if (maxcPiece==0) {
            ans[i] = maxrPiece * n;
        }
        else {
            ans[i] = maxrPiece * maxcPiece;
        }



    }
    for (int i = 0; i < q; i++) {

        printf("%d\n", ans[i]);

    }


    return 0;


}


