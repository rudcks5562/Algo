
#include<stdlib.h>
#include<stdio.h>
#include<algorithm>
#include<math.h>
#include<iostream>
#include <vector>
#include <string.h>
using namespace std;


int N, M;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);



	cin >> N;
	vector<pair<int, int>> first;
	for (int i = 0; i < N; i++) {
		int temp = 0;
		cin >> temp;
		first.push_back(make_pair(temp, i));
	}
	cin >> M;
	vector<pair<int, int>> sec;
	for (int i = 0; i < M; i++) {
		int temp = 0;
		cin >> temp;
		sec.push_back(make_pair(temp, i));
	}


	sort(first.begin(), first.end(),  [](pair<int,int>a,pair<int,int>b) {
		if (a.first == b.first) {

			return a.second < b.second;
		}
		return a.first > b.first;
		}
		);

	sort(sec.begin(), sec.end(), [](pair<int, int>a, pair<int, int>b) {
		if (a.first == b.first) {

			return a.second < b.second;
		}
		return a.first > b.first;
		}
	);

	//for (int i = 0; i < first.size(); i++) cout << first[i].first << " "<<first[i].second<<" @ ";
	//cout << endl;
	//for (int i = 0; i < sec.size(); i++) cout << sec[i].first << " " << sec[i].second<<" \n";


	vector<int> last;

	int idxa = 0, idxb = 0, limita = 0, limitb = 0;
	while (idxa < N && idxb < M) {
		if (first[idxa].first == sec[idxb].first) {// 가리키는 두 값이 같은경우
			if (limita > first[idxa].second) idxa++;// 원본 인덱스 체크보다 이전인 경우
			else if (limitb > sec[idxb].second) idxb++; // 이미 넘어간 영역인 경우 위와동일
			else {// 영역체크 통과
				limita = first[idxa].second;//영역 갱신
				limitb = sec[idxb].second;
				last.push_back(first[idxa].first);//정답기록
				idxa++;
				idxb++;
			}
		}
		else if (first[idxa].first > sec[idxb].first) idxa++;// 정렬된 값 중 더 높은 값을 줄여가는 것 (인덱스 증가시 줄어드니까)
		else idxb++;
	}




	cout << last.size()<<endl;
	for (int i = 0; i < last.size(); i++) cout << last[i] << " ";
	return 0;
}