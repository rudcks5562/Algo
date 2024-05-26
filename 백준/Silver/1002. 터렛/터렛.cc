#include <iostream>
#include <cmath>>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main() {
	
	

    int ans=0;//2,1,0,-1
    int TC;
    std::cin>>TC;
    
    for(int s=0;s<TC;s++){
	
    	
    		int x1,y1,r1,x2,y2,r2;
    		std::cin>> x1 >> y1 >> r1 >> x2>> y2>>r2;
    		
    		

			double d= sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
			double round= r1>r2 ? (r1-r2):(r2-r1);// 두 반지름의 차이  

			if(d==0&& r1==r2){//두 점이 같은 점  
				
				std::cout<<"-1"<<"\n";
				continue;
			}
			else if(r1+r2==d|| round==d){// 반지금 합이 목표점과 거리가 같거나 (외접) , 내접  
				std::cout<<"1"<<"\n"; 
			}
			else if(round<d&& d<r1+r2){
				std::cout<<"2"<<"\n";
				
			}
			else{
				std::cout<<"0"<<"\n";
			}

    	
    	
	
}
    
	
	return 0;
	
	
	
	
	
}