
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st;
		int N= Integer.parseInt(input);
		input = br.readLine();
		st=new StringTokenizer(input);
		
		int arrs[]= new int[N];
		
		for(int s=0;s<N;s++) {
			arrs[s]=Integer.parseInt(st.nextToken());

		}
		
		long a=0;
		long b=0;
		int min= Integer.MAX_VALUE;
		
		for(int i=0;i<N;i++) {
			
			
				int left=i+1;
				int right=N-1;
				
				while(left<=right) {
					
					int mid= (left+right)/2;
					int sum= arrs[i]+arrs[mid];
					 
					
					if(Math.abs(sum)<min) {
						
						a=arrs[i];
						b=arrs[mid];
						min= Math.abs(sum);
						
						
					}
					
					if(sum<0) {
						left=mid+1;
					}
					else {
						right=mid-1;
					}
					
					

					//System.out.println("mid: "+mid+" left= "+left+" right= "+right+" a= "+a+" b= "+b+" min= "+min+" sum= "+Math.abs(arrs[i]+arrs[(int) mid]));
					
				}
				//System.out.println(target+" r="+right+" = "+arrs[(int) right]+ "a= "+a+" b= "+b);
				
					
					
				
				
			
			
			
			
		}
		
		System.out.println(a+" "+b);
		
		
		
		
		
	}

}
