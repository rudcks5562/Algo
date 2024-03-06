

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static StringBuilder sb;
	public static TreeSet<Integer> list= new TreeSet<>();
	public static int output[];

	public static void main(String[] args) throws IOException {
//		N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
//
//		N개의 자연수 중에서 M개를 고른 수열
//		같은 수를 여러 번 골라도 된다.
//		고른 수열은 비내림차순이어야 한다.
//		길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
		
		
		
//		첫째 줄에 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
//
//		둘째 줄에 N개의 수가 주어진다. 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.
		
//		한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
//
//		수열은 사전 순으로 증가하는 순서로 출력해야 한다.
		
		
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		int N,M;
		StringTokenizer st= new StringTokenizer(input);
		
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		
		int input_arr[] = new int[N];
		input= br.readLine();
		st= new StringTokenizer(input);
		
		for(int s=0;s<N;s++) {
			
			input_arr[s]= Integer.parseInt(st.nextToken());
			//list.add(input_arr[s]);
		}
		output = new int[M];
		
		sb= new StringBuilder();
		Arrays.sort(input_arr);
		for(int s=0;s<N;s++) {
			
			//input_arr[s]= Integer.parseInt(st.nextToken());
			list.add(input_arr[s]);
			
		}
	
		Arrays.fill(output, 10001);
		
			Function(N,M,0);
		
		
		
		System.out.println(sb);
		
		

	}

	private static void Function(int n, int m, int cnt) {
	//System.out.println(Arrays.toString(output));
		if(cnt==m) {
			
			// 1000같은 문자열 긴거에 대한 처리 필요
			
			
			for(int s=0;s<m;s++) {
				
				sb.append(output[s]+" ");
				
				
			}
			sb.append("\n");
			
			return;
		}
		// cnt로 input array의 정렬된 배열을 탐색하며 조건에 주어진대로 사전순+ 중복제거를 시행한다.
		
		
		for( int temps : list) {
			 if(cnt==0) {
					output[cnt]= temps;
					Function(n, m,cnt+1);
					
				}
			 else if(temps>=output[cnt-1] ){
				output[cnt]= temps;
				Function(n, m,cnt+1);
			
				
				
			}

		}

		
		
	}

}
