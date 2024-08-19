
#include <iostream>
#include <array>
#include<algorithm>
#include <vector>
#include<string>
#include<cmath>

using namespace std;
void Function(int start, int limit, int curSum,string str);
std::vector <std::string> Ans;


int main()
{
    cin.tie(0)->sync_with_stdio(0);

    int n;

    cin >> n;
    for (int tc = 0; tc < n; tc++) {

        int T=0;
        cin >> T;
        Ans.clear();

        //strWriter[0] = "1";
       // cout << strWriter[0]<<"??";
        Function(2, T, 1,"1");// start, limit, current sum
        std::sort(Ans.begin(), Ans.end());
        for (int i = 0; i < Ans.size(); i++) {
            std::cout << Ans[i] << "\n";
        }
        std::cout << "\n";

    }
    return 0;


}
int CheckStreight(string str) {

    int res = str.at(str.length()-1)-'0';
    int cnt = 0;
    bool flag = false;
    string out = "";

    for (int i = str.length()-2; i >= 0; i = i - 2) {

        if (str.at(i) == '+') {
            break;
        }
        else if (str.at(i) == '-') {
            flag = true;
            break;
        }

        cnt++;
    }

    for (int i = str.length()-1-2*cnt; i < str.length(); i = i + 2) {
        out += str[i];
    }

    res = stoi(out);

    //printf("res: %d\n", res);
    if (flag == true) {
        return -res;
    }
    return res;
}



 void Function(int start, int limit, int curSum,string str) {
   //  printf("start: %d , cursum: %d\n", start, curSum);

     if (start > limit) {
         if (curSum == 0) {

             //cout << str;
             Ans.push_back(str);
             //printf("\n");
             return;
         }
         return;
     }
    // printf("start: %d , cursum: %d\n", start,curSum);


             // printf("expect : %d\n", curSum);
             int temp;
             if (str.compare("1") == 0) {
                 temp = 10 + 2;
                 // printf("???@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");
             }
             else {

                 temp = CheckStreight(str) * 10;
                 if (temp < 0) {
                     temp -= start;
                 }
                 else {
                     temp += start;
                 }
                 // cout << temp << " vs " << str<<"\n";

             }
             Function(start + 1, limit, temp + curSum - (temp / 10), str + " " + to_string(start));
             Function(start + 1, limit, curSum + start,str+"+"+ to_string(start));
             Function(start + 1, limit, curSum - start,str+"-"+to_string(start));

}