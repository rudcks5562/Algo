
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int DP[][];
	public static int answer;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input1= br.readLine();
		String input2= br.readLine();
		int size= input1.length();
		
		
		
		DP= new int[1001][1001];
		
		
		for(int i=1;i<=size;i++) {
			char temp1= input1.charAt(i-1);
			
			for(int j=1;j<=input2.length();j++) {
				
				
				char temp2 = input2.charAt(j-1);
				
				if(temp1==temp2) {
					
					DP[i][j]= DP[i-1][j-1]+1;
					answer= Math.max(DP[i][j], answer);
					
				}
				else {
					
					DP[i][j]= Math.max(DP[i-1][j], DP[i][j-1]);
					
					
				}
				
				
			}
			
			
		}
		
		
		System.out.println(answer);
		
		
		
		
	}

}
