#include <iostream>
#include <vector>
#include <string>
#include <queue>
#include<cstdio>
#include<algorithm>
#include<utility>

	
	
int main() {
	std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);
    std::cout.tie(NULL);
    
	int T;
	std::cin>>T;
	
	
	//std::cout<<"logs";
	
//	cmd temp;
//	temp.n=0;
//	int rights=1000;
//	temp.now_dd(temp.n);
//	temp.cmd_s();
	
	
	

	for(int i=0;i<T;i++){
		
		int left=0,right=0;
		std::cin>> left >> right;
		
		if(left==right){
			
			std::cout<<"\n";
			continue;
		}
		
		std::queue<std::pair<int,std::string> > q;
		
		
		
		q.push(std::make_pair(left,""));
		bool visit[10000]={false};
		visit[left]= true;
		
		
		while(!q.empty()){
			
			int cur= q.front().first;
			std::string cur_2=q.front().second;
			
			q.pop();
		
			if(cur==right){

			std::cout<<cur_2<<"\n";


			break;
				
			}
			
		int D, S, L, R, temp;
        // D 연산
        D = (cur * 2) % 10000;
        if (!visit[D])
        {
            visit[D] = true;
            q.push(make_pair(D, cur_2 + "D"));
        }

        // S 연산
        S = cur - 1 < 0 ? 9999 : cur - 1;
        if (!visit[S])
        {
            visit[S] = true;
            q.push(make_pair(S, cur_2 + "S"));
        }

        // L 연산
        L = (cur % 1000) * 10 + (cur / 1000);
        if (!visit[L])
        {
            visit[L] = true;
            q.push(make_pair(L, cur_2 + "L"));
        }

        // R 연산
        R = cur / 10 + (cur % 10) * 1000;
        if (!visit[R])
        {
            visit[R] = true;
            q.push(make_pair(R, cur_2 + "R"));
        }
			
			
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	return 0;
}