package sec08;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        for (int i = 0; i < c; i++) {
            int n = sc.nextInt();
            int sum = 0;
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                int score = sc.nextInt();
                arr[j] = score;
                sum += score;
            }
            int devided = sum/n;
            double cnt = 0;
            double nn = n;
            for (int j = 0; j < n; j++) {
                if(arr[j] > devided){
                    cnt++;
                }
            }
            double result = cnt/n*100;
            System.out.println(String.format("%.3f",result) + "%");
        }
    }
}
