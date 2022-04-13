package study;

import java.util.Scanner;

public class B14889_new {
    static int total;
    static int[][] map;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;
    private static void DFS(int idx, int count) {
        if(count == total/2){
            diff();
            return;
        }
        for (int i = idx; i < total; i++) {
            if(!visit[i]){
                visit[i] = true;
                DFS(i+1,count+1);
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        total = sc.nextInt();
        map = new int[total][total];
        visit = new boolean[total];
        for (int i = 0; i < total; i++) {
            for (int j = 0; j < total; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        DFS(0,0);
        System.out.println(min);
    }
    private static void diff(){
        int start = 0;
        int link = 0;
        for (int i = 0; i < total-1; i++) {
            for (int j = i+1; j < total; j++) {
                if(visit[i] == true && visit[j] == true){
                    start += map[i][j];
                    start += map[j][i];
                }else if(visit[i] == false && visit[j] == false){
                    link += map[i][j];
                    link += map[j][i];
                }
            }
        }
        int diff = Math.abs(start-link);
        if(diff == 0){
            System.out.println(diff);
            System.exit(0);
        }
        min = Math.min(diff,min);

    }
}
