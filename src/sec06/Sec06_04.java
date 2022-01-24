package sec06;

import java.util.Scanner;

public class Sec06_04 {
    public int[] solution(int s, int n, int[] arr){
        int[] answer = new int[s];
        for (int x : arr) {
            int pos=-1;
            for (int i=0; i<s; i++){
                if(x==answer[i]){
                    pos=i; //cache hit!!
                }
            }
            if(pos==-1){
                for (int i = s-1; i >= 1; i--) {
                    answer[i] = answer[i-1];
                }
            }else{
                for (int i = pos; i >= 1; i--) {
                    answer[i] = answer[i-1];
                }
            }
            answer[0]=x;
        }
        return answer;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int s = in.nextInt();
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Sec06_04 T = new Sec06_04();
        for (int i : T.solution(s,n,arr)) {
            System.out.print(i+" ");
        }
        return ;
    }
}
