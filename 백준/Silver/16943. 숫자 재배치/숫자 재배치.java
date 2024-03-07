
import java.util.Arrays;
import java.util.Scanner;

public class Main{

	
	public static int A,B;
	public static int C=-1;// answer;
	public static int A2arr[];// 순열 뽑기용
	public static int B2arr[];
	public static int select[];
	public static boolean visit[];
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		A= sc.nextInt();
		B= sc.nextInt();
		
		int A_size= String.valueOf(A).length();
		int B_size = String.valueOf(B).length();
		
		A2arr= new int [A_size];
		B2arr= new int[B_size];
		select= new int[A_size];
		visit = new boolean[A_size];
		
	//	System.out.println("ori-A: "+A);
		
		for(int s=0;s<A_size;s++) {
			
			A2arr[s]=   String.valueOf(A).charAt(s)-'0';
			//System.out.println(A2arr[s]+"?");
			
		}
		for(int s=0;s<B_size;s++) {
			
			B2arr[s]= String.valueOf(B).charAt(s)-'0';
			
		}

		
		if(A_size>B_size) {
			System.out.println(C);
			return;
		}
		else if(A_size==B_size) {
			Function(0,A_size,0);// make perm
		}
		else {
			//System.out.println("START");
			Function2(0, A_size,0);
			
		}
		
		
		
		
		System.out.println(C);
		
		
		
		
		

	}

	private static void Function(int cnt,int limit,int valid) {
		
		if(valid==-1) {// B보다 작은 조건 성립하지 않는 경우 
			return;
		}
	//	System.out.println(Arrays.toString(select)+"val : "+valid);
		
		if(cnt>=limit) {
			
			
			//System.out.println(Arrays.toString(select)+"@"+valid);
			int current=arrtoi(select);
			if(current==B) {
				return;
			}
			if(C==-1) {
				C=current;
			}
			else if(C!=-1 && C<current) {
				C=current;
			}
			
			
			return;
		}
		
		int temp_valid= valid;
		
		for(int s=0;s<limit;s++) {

			
			
			if(visit[s]) {
				continue;
			}
			if(cnt==0 && A2arr[s]==0) {// 0으로 시작하는 순열은 필요없음. 
				continue;
			}
			
			if (B2arr[cnt]< A2arr[s] && valid!=1){// B와의 대소관계를 판별하는 플래그 
			
				// -1 : 관계상실, 0 : 중립, 1 : 관계성립 
				
			//	System.out.println(B2arr[cnt]+"<<b ,#, a>>"+A2arr[s]+"val= "+valid);
				valid=-1;
				
				
			}
			else if(B2arr[cnt]>A2arr[s]) {
			//	System.out.println(B2arr[cnt]+"<<b , a>>"+A2arr[s]);
				valid=1;
			}
			
			
			select[cnt]= A2arr[s];
			visit[s]= true;
			Function(cnt+1, limit,valid);
			visit[s]=false;
			valid= temp_valid;

			// 424 333 

			
		}
		
		
	}// func end 
	
	
	public static int arrtoi(int[]arr) {
		
		int res=0;
		int size=arr.length-1;
		int cnt=0;
		
		for(int s=size;s>=0;s--) {
			
			res+= Math.pow(10,cnt)*arr[s];
			//System.out.println(res);
			cnt++;
		}
		
		return res;
		
		
	}
	private static void Function2(int cnt,int limit,int valid) {
		

		//System.out.println(Arrays.toString(select)+"val : "+valid);
		
		if(cnt>=limit) {
			
			
			//System.out.println(Arrays.toString(select)+"@"+valid);
			int current=arrtoi(select);
			if(current==B) {
				return;
			}
			if(C==-1) {
				C=current;
			}
			else if(C!=-1 && C<current) {
				C=current;
			}
			
			
			return;
		}
		
		
		for(int s=0;s<limit;s++) {

			
			
			if(visit[s]) {
				continue;
			}
			if(cnt==0 && A2arr[s]==0) {// 0으로 시작하는 순열은 필요없음. 
				continue;
			}
			
			
			select[cnt]= A2arr[s];
			visit[s]= true;
			Function2(cnt+1, limit,valid);
			visit[s]=false;
			//valid= temp_valid;

			// 424 333 

			
		}
		
		
	}// func end 
	
	
	
	

}
