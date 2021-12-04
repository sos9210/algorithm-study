package sec02;

import java.util.ArrayList;
import java.util.Scanner;

public class Sec02_03 {

    public ArrayList<String> solution(int[] a, int[] b, int n) {
         //내가푼것
        ArrayList<String> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(a[i] - b[i] == 1 || b[i] - a[i] == 2){
                answer.add("A");
            }else if(b[i] - a[i] == 1 || a[i] - b[i] == 2){
                answer.add("B");
            }else{
                answer.add("D");
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Sec02_03 T = new Sec02_03();
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
        }
        for (String result: T.solution(a,b,n)) {
            System.out.println(result);
        }
    }

}
