package study;

import java.util.Scanner;

public class B2580_new1 {
    static int[][] sudoku = new int[9][9];

    private static boolean isCheck(int row, int col, int num){
        for (int i = 0; i < 9; i++) {
            if(sudoku[row][i] == num){
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if(sudoku[i][col] == num){
                return false;
            }
        }

        int rows = (row/3) * 3;
        int cols = (col/3) * 3;
        for (int i = rows; i < rows+3; i++) {
            for (int j = cols; j < cols+3; j++) {
                if(sudoku[i][j] == num){
                    return false;
                }
            }
        }
        return true;
    }

    public static void DFS(int row,int col){
        if(col > 8){
            DFS(row+1,0);
            return;
        }
        if(row > 8){
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
                if(isCheck(row,col,i)){
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
}
