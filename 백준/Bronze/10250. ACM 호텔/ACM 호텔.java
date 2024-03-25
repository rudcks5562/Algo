

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		
		int tc; 
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String input =br.readLine();
		StringTokenizer st; 
		StringBuilder sb= new StringBuilder();
		
		tc= Integer.parseInt(input);
		
		for(int t=0;t<tc;t++) {
			
			input= br.readLine();
			st= new StringTokenizer(input);
			
			int h= Integer.parseInt(st.nextToken());// 높이
			int w= Integer.parseInt(st.nextToken());// 가로 
			int n= Integer.parseInt(st.nextToken());
			
			
			int a= n/h+1;//호수 추가
			int b=n%h;// 층수 
			int answer;
			if(b==0) {
				b=h;
				a=n/h;
				answer= 100*b+a;
			}
			else {
				answer= 100*b+a;
			}
			
			
			
			
			sb.append(answer+"\n");
			
		}
		System.out.println(sb);
		

	}

}
