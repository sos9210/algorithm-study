package study;

import java.util.Scanner;

public class B2580_new {
    static int[][] sudoku = new int[9][9];

    public static void DFS(int row,int col){
        if(col == 9){
            DFS(row+1,0);
            return;
        }
        if(row == 9){
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(sudoku[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);
        }
        if(sudoku[row][col] == 0){
            for (int i = 1; i <= 9; i++) {
                if (isCheck(row, col,i)) {
                    sudoku[row][col] = i;
                    DFS(row,col+1);
                }
            }
            sudoku[row][col] = 0;
            return;
        }
        DFS(row,col+1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = sc.nextInt();
            }
        }

       DFS(0,0);
    }

    private static boolean isCheck(int row,int col,int chkNum){

        for (int i = 0; i < 9; i++) {
            if(sudoku[row][i] == chkNum){
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if(sudoku[i][col] == chkNum){
                return false;
            }
        }

        int chkX = (row/3)*3;
        int chkY = (col/3)*3;
        for (int i = chkX; i < chkX+3; i++) {
            for (int j = chkY; j < chkY+3; j++) {
                if(sudoku[i][j] == chkNum){
                    return false;
                }
            }
        }

        return true;
    }
}
