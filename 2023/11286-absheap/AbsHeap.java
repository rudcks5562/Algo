
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class AbsHeap {

	public static void main(String[] args) throws NumberFormatException, IOException {
	
		
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N= Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				
				if(Math.abs(o1) > Math.abs(o2)) {
					
					return 1;
				}
				else if(Math.abs(o1)== Math.abs(o2)) {
					
					return o1-o2;
				}
				else {
					return -1;
				}
				
				
				
			}
			
		});
		
		//배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다. 절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.
		
		StringBuilder sb= new StringBuilder();
		
		for(int i=0;i<N;i++) {
			int input=Integer.parseInt(br.readLine());
			if(input==0) {
				if(pq.isEmpty()) {
					sb.append("0\n");
				}
				else {
					sb.append(pq.poll());
					sb.append("\n");
				}
				
				
			}
			else if(input!=0) {
				pq.add(input);
				
			}
			
			
		}
		
		
		System.out.println(sb);
		

	}

}
