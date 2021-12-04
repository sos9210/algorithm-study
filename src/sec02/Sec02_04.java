package sec02;

import java.util.ArrayList;
import java.util.Scanner;

public class Sec02_04 {
    public int[] solution(int s) {
        String answer = "";
        int[] result = new int[s];
        result[0] = 1;
        result[1] = 1;
        for (int i = 2; i < s; i++) {
            result[i] = result[i-1] + result[i-2];
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        Sec02_04 T = new Sec02_04();
        int input1 = in.nextInt();
        for (int i = 0; i < input1; i++) {
            System.out.print(T.solution(input1)[i]+" ");

        }
    }
}
