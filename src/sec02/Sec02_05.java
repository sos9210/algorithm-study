package sec02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sec02_05 {
    public int solution(int n){
        int answer = 0;
        int[] tmp = new int[n+1];
        for (int i = 2; i < tmp.length; i++) {
            if(tmp[i] == 0){
                answer++;
                for (int j = i; j <= n; j=j+i) {
                    tmp[j] = 1;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        Sec02_05 T = new Sec02_05();
        int n = in.nextInt();
        System.out.println(T.solution(n));
        return ;
    }
}
