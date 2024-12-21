#include<stdio.h>
#include<stdlib.h>




int n,w;// 전체수/2와 소대제한  
int dp[3][10001]={ 0};// dp배열  dp[N][1] 에 대한 초기설정 필요  0=both   1 = up  2 = down
int arr[2][10001];// 실제 배\열  
int res[10000];



int min(int a, int b){
	
	if(a>b){
		
		return b;
	}
	else{
		return a;
	}
  

}
int min1(int a, int b,int c, int d){
	int temp=0;
	
	temp=min(a,b);
	
	temp=min(temp,c);
	temp=min(temp,d);
	
	return temp;
  

}

void solve(){
	
 	int up,down,vertical;// 2 ? 1 
	int answer=-1;
	
	

	
	
	for(int i=2;i<=n;i++){
		
	if(arr[0][i-2]+arr[0][i-1]<=w){
		up=1;
	}
	else{
		up=2;
	}
////////////////////////////////////
	if(arr[1][i-1]+arr[1][i-2]<=w){
		down=1;
	}
	else{
		down=2;
	}
/////////////////////
	if(arr[1][i-1]+arr[0][i-1]<=w){
		
		vertical=1;
	}
	else{
		
		vertical=2;
	}	
		
		dp[0][i]=min1(dp[0][i-2]+up+down,dp[0][i-1]+vertical,dp[1][i-1]+down+1,dp[2][i-1]+up+1);
		dp[1][i]=min(dp[0][i-1]+1,dp[2][i-1]+up);
		dp[2][i]=min(dp[0][i-1]+1,dp[1][i-1]+down);
		
		
		
	}
	
	//필요요소들을 모두 정의한 후 최소값을 찾는 코드를 구현하여 반환한다. 
	return ;
	
}// dp 배열 정제 과정  

int main() {
	
	int t=0;// testcase num
	int ans;
	int T;
	scanf("%d",&t);
	T=t;
	while(t--){
		scanf("%d %d",&n,&w);
		 
		for(int i=0;i<n;i++){
			scanf("%d",&arr[0][i]);
			
		}
		for(int i=0;i<n;i++){
			
			scanf("%d",&arr[1][i]);
			
		}
		
		int ori_onezero=arr[1][0];
		int ori_zerozero=arr[0][0];
		/////////////////////////////////4가지 분류 초기 디피배열 
		if(arr[0][0]+arr[1][0]<=w){
			dp[0][1]=1;
			
		}
		else{
			dp[0][1]=2;
		}
		dp[1][1]=1;
		dp[2][1]=1;
		
		solve();
		
		ans=dp[0][n];
		

		
		
		//아래 만 연결 
		if(arr[1][0]+arr[1][n-1]<=w){
		
		dp[2][1]=1;
		dp[1][1]=1;
		dp[0][1]=2;
		
		arr[1][0]=100001;
		solve();
		arr[1][0]= ori_onezero;
		
		ans=min(ans,dp[1][n]);

		}
		
		// 위 만 연결 
		if(arr[0][0]+arr[0][n-1]<=w){
			
		dp[2][1]=1;
		dp[1][1]=1;
		dp[0][1]=2;
		
		arr[0][0]=100001;
		solve();
		arr[0][0]= ori_zerozero;
		
		ans=min(ans,dp[2][n]);	
			
		
		}
		
		
		//둘 다 
		
		if(arr[0][0]+arr[0][n-1]<=w && arr[1][0]+arr[1][n-1]<=w){
			
		arr[0][0]=100001;
		arr[1][0]=100001;
		
		dp[2][1]=1;
		dp[1][1]=1;
		dp[0][1]=2;
			
		solve();	
			
		ans=min(ans,dp[0][n-1]);
		arr[0][0]= ori_zerozero;
		arr[1][0]= ori_onezero;	
		
		}///////// check
		
		if(n==1){
		
			//if(arr[0][0]+arr[0][1]<=w){
				
			//	ans=1;
			//}
			
			if(arr[0][0]+arr[1][0]<=w){
				ans=1;
			}
			
			
			
			else{
				ans=2;
			}
			
			
			
			
		}
		
		
	//	for(int i=1;i<=n;i++){
	//		printf("dp 0 %d= %d",i,dp[0][i]);
	//		printf("dp 1 %d= %d",i,dp[1][i]);
	//		printf("dp 2 %d= %d\n",i,dp[2][i]);
	//	}
		

		res[t]=ans;
		
		// 선형 배열에 대해 원형 배열과 동일 조건을 제공키 위해 사전조건을 정의한다 4가지로 무의 경우 아래의 경우 위의 경우 둘다의 경우
		//연결되어있음을 가정한 초기조건을 구현 후 dp배열을 정렬한다. 
		
		
		
		
		
		
		
		
	}
	
	for(int i=T-1;i>=0;i--){
		
		printf("%d\n",res[i]);
	}
	
	
	return 0;
}