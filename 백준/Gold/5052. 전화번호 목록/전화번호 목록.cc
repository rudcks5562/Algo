
#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <array>
#include<algorithm>
#include <vector>
#include<string>
#include<cmath>
#include<cstring>

using namespace std;


struct Trie{
    bool finish=false;
    Trie* next[10];

    Trie() : finish(false){
        std::memset(next, 0, sizeof(next));

    }
    ~Trie() {
        for (int i = 0; i < 10; i++)
            if (next[i])
                delete next[i];
    }
    void insert(const char* key) {
        if (*key == '\0')
            finish = true; // 문자열이 끝나는 지점일 경우 표시
        else {
            int curr = *key-'0';
            if (next[curr] == NULL)
                next[curr] = new Trie(); // 탐색이 처음되는 지점일 경우 동적할당
            next[curr]->insert(key + 1); // 다음 문자 삽입
        }
    }
    bool finCheck() {
        return finish;
    }

    // 트라이에서 문자열 찾기
    Trie* find(const char* key) {
        if (*key == '\0') return this; // 문자열이 끝나는 위치를 반환
        int curr = *key - '0';
        if (next[curr] == NULL) return NULL; // 찾는 값이 존재하지 않음
        return next[curr]->find(key + 1); // 다음 문자를 탐색
    }

};// 비교 문자열이 긴 경우 (fin체크로 접두어 식별), 비교 문자열이 짧은 경우 (접두어가 되는경우) 



int main()
{
    cin.tie(0)->sync_with_stdio(0);
    vector<string> ans;
    int TC = 0;
    cin >> TC;
    for (int t = 0;t<TC;t++) {
        int n = 0;
        cin >> n;
        bool flag = false;
        Trie *root = new Trie();
        vector<string> inputV(n, "");
        for (int i = 0; i < n; i++) {
            string inputNum;
            cin >> inputNum;
            inputV[i] = inputNum;
        }
        sort(inputV.begin(), inputV.end());

        for(string cur:inputV){

            string itostr = cur;
            char* chars = new char[itostr.length()+1];
            // char에 string넣기
            //strcpy_s(chars, strlen(itostr.c_str())+1, itostr.c_str());

           strcpy(chars, itostr.c_str());

            
            root->insert(chars);
            delete[] chars;
        }

        for (string temp : inputV) {
            string itostr = temp;
            char* chars2 = new char[itostr.length()+1];
           // strcpy_s(chars2, strlen(itostr.c_str()) + 1, itostr.c_str());
            strcpy(chars2, itostr.c_str());
            Trie* res = root->find(chars2);
            if (res != nullptr && res->finish) {// 접두사 식별
                for (int s = 0; s < 10; s++) {

                    if (res->next[s] != nullptr) {
                        flag = true;
                        break;
                    }
                }
            }
            delete[] chars2;
        }



        if (flag) {
          //  cout << "NO" << "\n";
            ans.push_back("NO");
        }
        else {
           // cout << "YES" << "\n";
            ans.push_back("YES");
        }

        delete root;

    }

    for (string res : ans) {
        cout << res << "\n";
    }


    return 0;
}



