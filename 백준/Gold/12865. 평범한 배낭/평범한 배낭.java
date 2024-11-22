import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;





public class Main {

	public static int N,K;
	public static int DP[][];
    public static int arr_w[];
    public static int arr_v[];
    

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		N=  Integer.parseInt(st.nextToken());
		K= Integer.parseInt(st.nextToken());
		
        arr_w =  new int[N+1];
        arr_v = new int[N+1];

		DP = new int[N+1][K+1];// i , w 
		for(int s=1;s<=N;s++) {
			String temp = br.readLine();
			st = new StringTokenizer(temp);
			int temp_w = Integer.parseInt(st.nextToken());
			int temp_v = Integer.parseInt(st.nextToken());
			
            arr_w[s] = temp_w;
            arr_v[s] = temp_v;
			
			
			
		}

        for(int i=1;i<=N;i++){
            
            for(int k=1;k<=K;k++){
                
                if(k>= arr_w[i]){
                    
                    DP[i][k] = Math.max(DP[i-1][k],DP[i-1][k-arr_w[i]]+arr_v[i]);
                    
                }
                else{
                    DP[i][k]=DP[i-1][k];
                }
                
            }
            
        }
        
        
        System.out.println(DP[N][K]);
		

	//	System.out.println(Arrays.toString(DP));

		
		//System.out.println(Arrays.toString(DP));

		

	}
	
	

	
	
	
	
	
	

}
