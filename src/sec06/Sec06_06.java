package sec06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Sec06_06 {
    /*
    public int[] solution(int n, int[] arr) {
        int[] answer = new int[2];
        int tmp = 0;
        for (int i = 1; i < n; i++) {
            if(arr[tmp] > arr[i]) {
                if(answer[0] == 0)
                    answer[0] = tmp+1;
                answer[1] = i+1;
                tmp=i;
            }else if(arr[tmp] != arr[i]){
                tmp = i;
            }
        }

        return answer;
    }
     */
    public ArrayList<Integer> solution(int n, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        int[] tmp = arr.clone();
        Arrays.sort(tmp);
        for (int i = 0; i < n; i++) {
            if(arr[i] != tmp[i]){
                answer.add(i+1);
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
        Sec06_06 T = new Sec06_06();
        for (int i : T.solution(n,arr)) {
            System.out.print(i + " ");
        }
        return ;
    }

}
