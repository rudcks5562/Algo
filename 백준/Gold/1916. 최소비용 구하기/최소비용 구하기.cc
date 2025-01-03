
#include<stdlib.h>
#include<stdio.h>
#include<algorithm>
#include<math.h>
#include<iostream>
#include <vector>
#include <string.h>
#include <queue>
using namespace std;
#define MAX 1000000001

int N,M;

struct node{
	int start;
	int end;
	int cost;

	node(int start, int end, int cost) :
		start(start), end(end), cost(cost) {
	}

	bool operator<(const node n)const {

		return this->cost > n.cost;
	}


};


int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N >> M;
	vector<vector<pair<int,int>>>map(1001, vector<pair<int,int>>(0));//인접리스트

	for (int s = 0; s < M; s++)
	{
		int start, end, cost;

		cin >> start >> end >> cost;

		map[start - 1].push_back(make_pair(end-1, cost));

	}
	int startNode, EndNode;

	cin >> startNode >> EndNode;



	priority_queue<node> pq;
	vector<int> dist(N, MAX);
	dist[startNode - 1] = 0;

	for (int s = 0; s < map[startNode-1].size(); s++) {

		int st, ed, ct;
		st = startNode-1;// 시작노드
		ed=map[st][s].first;//연관노드들
		ct=map[st][s].second;// 비용
		dist[ed] = min(ct,dist[ed]);
		node temp(st, ed, ct);
		pq.push(temp);
	}//



	while (!pq.empty()) {

		node cur = pq.top();//현재 꺼내진 노드
		pq.pop();
		


		if (dist[cur.end] < cur.cost)continue;
		for (int s = 0; s < map[cur.end].size(); s++) {//인접 노드 조사
			int next = map[cur.end ][s].first;
			int dis = map[cur.end][s].second + cur.cost;// 현재노드 거리+ 인접노드 거리 계산.
			if (dist[next ] > dis) {
				dist[next ] = dis;
				node temp(cur.start,next,dis);
				pq.push(temp);
			}


		}




	}

	cout << dist[EndNode - 1] << endl;


	return 0;
}
