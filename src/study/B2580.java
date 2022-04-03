package study;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B2580 {
    static int[][] sudoku;
    public static void DFS(int x, int y) {

        //다음 row영역 DFS실행
        if(y == 9){
            DFS(x+1,0);
            return;
        }

        //스도쿠를 전부 돌았으면 실행
        if(x == 9){
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(sudoku[i][j] + " ");
                }
                System.out.println();
            }
            //스도쿠의 값을 전부 출력했으니 프로그램 강제종료실행
            System.exit(0);
        }
        if(sudoku[x][y] == 0){
            for (int i = 1; i <= 9; i++) {  //sudoku[x][y] 좌표값이 0이면 check메서드 실행
                if(check(x,y,i)){
                    sudoku[x][y] = i;
                    DFS(x,y+1);
                }
            }
            sudoku[x][y] = 0;
            return;
        }
        DFS(x,y+1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sudoku = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = sc.nextInt();
            }
        }
            //row ,col
        DFS(0,0);

    }

    // DFS메서드의 if문에서 호출하는 메서드.. val값이 해당 row와 col과 정사각형영역에 존재하는지 체크한다.
   private static boolean check(int x, int y,int val){
        //row영역 체크해서 val의 값이 있는지 체크하고 있으면 false 리턴한다
        for (int i = 0; i < 9; i++) {
            if(sudoku[x][i] == val){
                return false;
            }
        }
       //col영역 체크해서 val의 값이 있는지 체크하고 있으면 false 리턴한다
        for (int i = 0; i < 9; i++) {
            if(sudoku[i][y] == val){
                return false;
            }
        }

        //정사각형 영역을 체크하기위해 chkX와 chkY에는 정사각형 영역의 죄상단 좌표를 구한다.
        int chkX = (x/3)*3;
        int chkY = (y/3)*3;
        //정사각형 좌상단 부터 우하단 좌표영역까지 val값이 존재하는지 차례대로 체크한다.
        for (int i = chkX; i < chkX+3; i++) {
            for (int j = chkY; j < chkY+3; j++) {
                if(sudoku[i][j] == val){
                    return false;
                }
            }
        }
        return true;
    }
}
