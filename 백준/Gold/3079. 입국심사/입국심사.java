import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static long N,M;// 심사대 n <= 10만 사람수 m 10억(시간두)  
	public static long answer=0L;
	public static long input_arr[];

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st= new StringTokenizer(input);
		
		
		N= Long.parseLong(st.nextToken());
		M= Long.parseLong(st.nextToken());
		
		input_arr= new long[(int) N];

		for(int s=0;s<N;s++) {
			
			input= br.readLine();
			input_arr[s]= Integer.parseInt(input);
			
			
		}
		
		long left= 1L;
		long right= 1000000000L*(1000000000L);// 걸릿는 시간의 수직선상. 
		
		answer=right;
		while(left<=right) {
			
			long mid = (left+right)/2;
			
			if(check(mid,M)) {
				answer=Math.min(answer, mid);
				right=mid-1;
				
			}
			else{
				
				left=mid+1;
				
			}
			
			
			
		}// while end 
		System.out.println(answer);
		
		

	}
    public static boolean check(long mid,long m) {
    for (int i = 0; i < N; ++i) {
      m -= mid / input_arr[i];

      if (m <= 0) {
        return true;
      }
    }
    return false;
  }

}
