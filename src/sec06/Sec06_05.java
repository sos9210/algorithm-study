package sec06;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Sec06_05 {
    public String solution(int n, int[] arr) {
        /*// HashMap을 권장함.
        String answer = "U";
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
            if(map.get(arr[i]) > 1) {
                return "D";
            }
        }

        return answer;
         */
        String answer = "U";
        Arrays.sort(arr);
        for (int i = 0; i < n-1; i++) {
            if(arr[i] == arr[i+1]){
                return "D";
            }
        }

        return answer;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Sec06_05 T = new Sec06_05();
        System.out.println(T.solution(n,arr));
        return ;
    }

}
