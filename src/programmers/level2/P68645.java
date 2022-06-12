package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P68645 {
    public static int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];
        int[][] mat= new int[n][n];

        int x=-1, y=0, idx=1;
        //아래 -> 오른쪽 -> 대각선 왼쪽 을 한 싸이클로 잡는다
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                //위에 설명한 3가지 방향이 한 사이클이므로 i%3 == 0 이면 아래, i%3 == 1 이면 오른쪽, i%3 == 2면 대각선방향
                if(i%3==0){ //아래로
                    x++;
                }else if(i%3==1){//오른쪽으로
                    y++;
                }else{//대각선으로
                    x--;
                    y--;
                }
                mat[x][y]= idx++;
            }
        }
        
        idx=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j]==0) break;
                answer[idx++]= mat[i][j];
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Arrays.stream(solution(4)).forEach(v-> System.out.print(v+" "));
    }
}
