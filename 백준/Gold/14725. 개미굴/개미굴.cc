#include <iostream>
#include <algorithm>
#include <string>
#include <map>
#include <vector>


using namespace std;

struct Tries {


    map<string, Tries*> data;



    void insert(vector<string>& input,int depth) {

        if (depth == input.size()) {
            return;
        }
        string key = input[depth];

        auto iter = data.find(input[depth]); // 

        if (iter != data.end()) {

            data[key]->insert(input, depth + 1);
        }
        else {
            Tries* node = new Tries();
            data.insert({ key,node });
            data[key]->insert(input, depth + 1);
        }



      

    }
    void dfs(int depth) { // DFS
        for (auto& ch : data) {
            for (int i = 0; i < depth; ++i) // 깊이 당 -- 
                cout << "--";
            cout << ch.first << '\n';
            ch.second->dfs(depth + 1);
        }
    }


};



struct Node {
    map<string, Node*> child;

    void insert(vector<string> v, int idx) {
        if (idx == v.size()) return;
        auto iter = child.find(v[idx]); // map<string,Node*>::iterator iter
        if (iter != child.end()) { // 이미 존재
            iter->second->insert(v, idx + 1);
        }
        else {
            Node* n = new Node;
            child.insert({ v[idx],n });
            n->insert(v, idx + 1);
        }
    }

    void print(int idx) {
        if (child.empty()) return;
        for (auto iter = child.begin(); iter != child.end(); iter++) {
            for (int i = 0; i < idx; i++) cout << "--";
            cout << iter->first << "\n";
            iter->second->print(idx + 1);
        }
    }

};

int main()
{
    ios::sync_with_stdio(0);

    cin.tie(0)->sync_with_stdio(0);
    
    
    int N;

    cin >> N;

    Tries* root = new Tries;
  //  Node* root2 = new Node;

    for (int t = 0; t < N; t++) {

        int k = 0;
        cin >> k;
        vector<string> foodList;

        for (int seq = 0; seq < k; seq++) {

            string input;
            cin >> input;
            foodList.push_back(input);
        }

        root->insert(foodList,0);

    }

    root->dfs(0);
    delete root;
    return 0;
}



