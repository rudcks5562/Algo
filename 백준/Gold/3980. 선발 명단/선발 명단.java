
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	
	public static int N;//tc 
	public static int skill_list[][];
	public static StringBuilder sb;
	public static int answer=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		N= Integer.parseInt(input);
		StringTokenizer st;
		sb= new StringBuilder();
		
		
		while(--N>=0) {
			
			skill_list= new int[11][11];// 선수 , 포지션
			 answer=0;
			//System.out.println("TC= "+N);
			for(int i=0;i<11;i++) {
				input = br.readLine();
				st= new StringTokenizer(input);
				for(int j=0;j<11;j++) {
					//System.out.println("i= "+i+" j= "+j);
					skill_list[i][j]= Integer.parseInt(st.nextToken());
				//	System.out.print(skill_list[i][j]+" ");
				}
				//System.out.println("");
			}// input end
			
			//System.out.println((1<<4)+" is it?= "+((1<<4)&48)+" bit= "+48);
			Function(0,0,0);
			
			sb.append(answer).append("\n");
			
		}
		System.out.println(sb);
		
		
	}

	private static void Function(int cnt, int sum,int bit){
		
		if(cnt==11) {
			//System.out.println(sum);
			answer=Math.max(sum, answer);
			return;
		}
		for(int s=0;s<11;s++) {
			//System.out.println((1<<s)+" is it?= "+((1<<s)&bit)+" bit= "+bit);
			if(((1 << s)& bit)==(1<<s)) {
				
				continue;
			}
			if(skill_list[cnt][s]==0) {
				continue;
			}
			Function(cnt+1,sum+skill_list[cnt][s],bit+(1<<s));
			
		}
		
		
		
	}

}
