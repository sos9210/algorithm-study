package sec03;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Sec03_02 {
    public List<Integer> solution(int n, int m, int[] a, int[] b){
        List<Integer> answer = new ArrayList<>();
        Arrays.sort(a);
        Arrays.sort(b);
        int p1=0 , p2=0;
        while (p1<n && p2<m)
            if(a[p1] == b[p2]){
                answer.add(a[p1]);
                p1++;
                p2++;
            }else if(a[p1] < b[p2]) p1++;
            else p2++;

        return answer;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int[] arr1 = new int[n];
        for (int i=0; i < n; ++i) {
            arr1[i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] arr2 = new int[m];
        for (int i=0; i < m; ++i) {
            arr2[i] = in.nextInt();
        }
        Sec03_02 T = new Sec03_02();
        for (int x: T.solution(n,m,arr1,arr2)) {
            System.out.print(x+" ");
        }
    }
}
