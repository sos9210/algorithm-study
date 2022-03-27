package study;

import java.util.Arrays;
import java.util.Scanner;

public class B1759_DFS_new {
    static char[] arr;
    static char[] list;
    static int L,C;
    public static boolean isChecking() {
        int mocnt = 0;
        int jacnt = 0;
        for (char x :list) {
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u')  ++mocnt;
            else ++jacnt;
        }
        if(mocnt >= 1 && jacnt >= 2){
            return true;
        }
        return false;
    }

    public static void DFS(int level,int idx) {
        if(level == L){
            if(isChecking()) System.out.println(list);
        }else{
            for (int i = idx; i < C; i++) {
                list[level] = arr[i];
                DFS(level+1, i+1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();   //4
        C = sc.nextInt();   //6
        arr = new char[C];
        list = new char[L];
        for (int i = 0; i < C; i++) {
            arr[i] = sc.next().charAt(0);
        }
        Arrays.sort(arr);

        DFS(0,0);

    }
}
