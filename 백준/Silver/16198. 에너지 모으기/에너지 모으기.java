

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int answer=0;// 최대값.
	public static int N;
	public static int input_arr[];

	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String input =br.readLine();
		StringTokenizer st;
		
		N= Integer.parseInt(input);
		
		input_arr= new int[N];
		input = br.readLine();
		st= new StringTokenizer(input);
		
		for(int s=0;s<N;s++) {
			
			input_arr[s]= Integer.parseInt(st.nextToken());
			
			
		}
		
		//System.out.println(check(1));
		Function(0,0);
		
		System.out.println(answer);
		

	}

	private static void Function(int cnt, int sum) {
	
		
		if(cnt==N-2) {
			
			answer= Math.max(sum, answer);
			
			
			return;
		}
		
		for(int s=1;s<N-1;s++) {
			
			if(input_arr[s]==-1) {
				continue;
			}
			int temp=check(s);

			if(temp<0) {// 탈출조건 
				
				
				continue;
				
			}
			else {// 곱을 sum에 더하고 나서 현 인덱스를 음수처리 후 재귀.
				int tempo= input_arr[s];
				//System.out.println("s= "+s+" temp(add)= "+temp+"?"+"del(tempo)= "+tempo);
				input_arr[s]=-1;
				
				Function(cnt+1, sum+temp);
				input_arr[s]=tempo;
				
			}
			
			
			
			
		}
		
		
		
		
		
		
		
	}

	private static int check(int s) {
		
		int left=0;
		int right=0;
		int res=1;
		
		for(int cur=s+1;cur<N;cur++) {
			
			while(input_arr[cur]!=-1) {
				
				left= input_arr[cur];
				break;
				
			}
			if(left!=0) {
				break;
			}
			
		}
		for(int cur=s-1;cur>=0;cur--) {
			
			while(input_arr[cur]!=-1) {
				
				right= input_arr[cur];
				break;
				
			}
			if(right!=0) {
				break;
			}
			
		}
		
		if(left!=0&&right!=0&& left!=-1&& right!=-1) {
			//System.out.println("s= "+s+ " l="+left+" right= "+right);
			
			res= left*right;
		}
		else {
			res=-1;
		}
		
		
		
		return res;
	}

}
