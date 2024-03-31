#include <iostream>
#include <cmath>

void Function(int cnt);
bool check(int y);

int N=0;
int answer=0;
int visit[16];
	 

int main(int argc, char** argv) {
	
	
	std::cin>>N;
	
	
	Function(0);// 한 행에 하나의 퀸만 존재 가능, 한 열에 하나의 퀸만 존재 가능 대각선은 체크함수로 판별 
	
	
	
	printf("%d\n",answer);
	
	
	
	return 0;
	
	
}

void Function(int cnt){
	
	if(cnt>=N){
		//printf("%d ??? \n",answer);
		answer++;
		
		return;
	}
	
	
	for(int i=0;i<N;i++){// 모든 열에 대하여  
		
		visit[cnt]=i;// [cnt][i] 놓는다면?-> 백트래킹  
		if(check(cnt)==true){// 판별해보기 [cnt][i]에 퀸을 놓아도 될까?  
			
			Function(cnt+1);// 다음 행에 비숍 놓기  
			
		}
		
		
		
		
	}
	
	
	
	
	
}

bool check(int y){// 행의 정보  
	


for(int z=0;z<y;z++){// 위에 부분만 체크하면 된다. top down으로 재귀 함수가 진행중이므로  
	
	if(visit[y]==visit[z] || y-z== abs(visit[y]-visit[z])){// 배열에 저장된 열의 값이 같거나 (y는 실제 놓은 정보이고 z는 놓을 수 있는 곳을 탐색키 위한 가정임 1열1퀸의 법칙을 어기는지 확인하기 위한 것) 
	// 대각선의 법칙 x좌표차이 y좌표차이가 각각  같은거면 대각선에 위치한다.  
		
		return false;
	}	
	
}






	
	
	
	return true;
}



