package study;

import java.util.Scanner;

public class B14889 {
    static int[][] map;
    static int count;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;
    public static void DFS(int idx, int total) {
        if(total == count/2){
            diff();
            return;
        }
        for (int i = idx; i < count; i++) {
            if(!visit[i]){
                visit[i] = true;
                DFS(i+1,total+1);
                visit[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        count = sc.nextInt();
        map = new int[count][count];
        visit = new boolean[count];
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        DFS(0,0);
        System.out.println(min);
    }

    private static void diff(){
        int start = 0;
        int link = 0;

        for (int i = 0; i < count-1; i++) {
            for (int j = i+1; j < count; j++) {
                if(visit[i] == true && visit[j] == true){
                    start += map[i][j];
                    start += map[j][i];
                }else if(visit[i] == false && visit[j] == false){
                    link += map[i][j];
                    link += map[j][i];
                }
            }
        }
        int diff = Math.abs(start - link);
        if (diff == 0) {
            System.out.println(diff);
            System.exit(0);
        }

        min = Math.min(diff, min);
    }
}
