import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

		//입력
        int n = Integer.parseInt(bf.readLine());
        int[] arr = Arrays.stream(bf.readLine().split(" "))
                .mapToInt(x -> Integer.parseInt(x))
                .toArray();
        
        int max = Integer.MAX_VALUE;
        int[] answer = new int[2];
        
        //각 용액에 대해
        for(int i = 0; i < n ; i++){
            int left = i + 1;
            int right = n - 1;
            
            //이진탐색으로 0에 가까운 특성값 찾기
            while(left <= right){
                int mid = (left + right) / 2;

                int sum = arr[i] + arr[mid];

                if(Math.abs(sum) < max){
                    answer[0] = arr[i];
                    answer[1] = arr[mid];
                    max = Math.abs(sum);
                }

                if(sum < 0) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
        }

        bw.write(answer[0] + " " + answer[1]);

        bw.flush();
        bw.close();
    }

}