package study;

import java.util.*;

public class B1759_DFS {
    public static boolean isValid() {
        int mo = 0; int ja = 0;
        for (char x : combi) {
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                mo++;
            } else {
                ja++;
            }
        }
        if (mo >= 1 && ja >= 2) {
            return true;
        }
        return false;
    }

    static int L,C;
    static char combi[];
    static char[] input;

    public void solution(int index,int level){
        if(L == level){
            if (isValid()) {
                System.out.println(combi);
            }
        }else{
            for (int i = index; i < C; i++) {
                combi[level] = input[i];
                solution(i+1,level+1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();//4
        C = sc.nextInt();//6
        combi = new char[L];
        input = new char[C];
        for (int i = 0; i < C; i++) {
            input[i] = sc.next().toCharArray()[0];
        }
        Arrays.sort(input);
        B1759_DFS T = new B1759_DFS();
        //a t c i s w 정렬

        T.solution(0,0);
    }
}
