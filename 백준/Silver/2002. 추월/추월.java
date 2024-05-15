
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

class car{
	
	boolean is_in;
	int nums;
	String name;
	public car(boolean is_in, int nums, String name) {
		this.is_in = is_in;
		this.nums = nums;
		this.name = name;
	}
	
	
}


public class Main {
	public static int N;
	public static car inputs[];
	public static car outputs[];

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		StringTokenizer st;
		N= Integer.parseInt(input);
		
		inputs = new car[1001];
		outputs= new car[1001];
		
		for(int s=0;s<N;s++) {
			
			input= br.readLine();
			
			inputs[s]= new car(true,s,input);
			
		}
		
		for(int s=0;s<N;s++) {
			
			input= br.readLine();
			
			outputs[s]= new car(false,s,input);
			
			
		}
		
		
		int ans_cnt=0;
		
		int input_counter=0;
		int output_counter=0;
		int dismatch=0;
		
		HashSet<String> checked= new HashSet<String>();
		
		while(input_counter!=N) {
			
			
			
			car car_from_inputs= inputs[input_counter];
			car car_from_outputs= outputs[output_counter];
			
					
			//System.out.println(car_from_inputs.name+" "+car_from_inputs.nums+" dis= "+dismatch);
			//System.out.println(car_from_outputs.name+" "+car_from_outputs.nums);
			if(checked.contains(inputs[input_counter].name)) {// 단속 걸린애 만나면 
				input_counter++;
				continue;
			}
			if(car_from_inputs.name.equals(car_from_outputs.name)) {// 순서일치 
				
				input_counter++;
				output_counter++;
				continue;
				
			}

			else {// 순서 안맞음. 

				checked.add(outputs[output_counter].name);
				//System.out.println("ADD "+outputs[output_counter].name);
				dismatch++;
				output_counter++;

			}
			
			
			
			
			
			
		}
		
		
		System.out.println(dismatch);
		
		
		
		
		
		
		
		
		
		
		

	}

}
