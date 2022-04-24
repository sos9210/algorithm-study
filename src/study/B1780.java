package study;

import java.util.Scanner;

public class B1780 {
    static int[][] paper;
    static int[] count = new int[3];
    private static boolean isCheck(int x, int y, int length){
        int c = paper[x][y];
        for (int i = x; i < x+length; i++) {
            for (int j = y; j < y+length; j++) {
                if(c != paper[i][j]) return false;  //탐색범위에서 다른숫자가 나오면 false
            }
        }
        //탐색범위에서 다른숫자가 나오지 않으므로 true
        return true;
    }
    private static void DFS(int x, int y,int length){
        if(isCheck(x,y,length)){
            count[paper[x][y]] += 1;
        }else{
            //isCheck()에서 false가 나왔으므로 종이를 9등분한다.
            int newLength = length/3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    DFS(x+newLength*i, y+newLength*j, newLength);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                paper[i][j] = sc.nextInt()+1;   // -1은 count[]에 넣을수없으므로 +1해서 계산한다.
            }
        }
        DFS(0,0,N);

        System.out.println(count[0]);
        System.out.println(count[1]);
        System.out.println(count[2]);
    }
}
