package programmers.level2;

import java.util.Arrays;

//https://velog.io/@hyeon930/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%ED%96%89%EB%A0%AC%EC%9D%98-%EA%B3%B1%EC%85%88-Java
//행렬의 곱셈
public class P12949 {
    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for(int i = 0 ; i < arr1.length ; ++i){
            for(int j = 0 ; j < arr2[0].length ; ++j){
                for(int k = 0 ; k < arr1[0].length ; ++k) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {
/*        Arrays.stream(solution(new int[][]{{1, 4}, {3, 2}, {4, 1}}, new int[][]{{3, 3}, {3, 3}})).forEach(v ->{
                Arrays.stream(v).forEach(s-> {
                    System.out.print(s+" ");
                });
            System.out.println();
        });*/
        Arrays.stream(solution(new int[][]{{2,3,2}, {4,2,4}, {3,1,4}}, new int[][]{{5,4,3}, {2,4,1},{3,1,1}})).forEach(v ->{
                Arrays.stream(v).forEach(s-> {
                    System.out.print(s+" ");
                });
            System.out.println();
        });
    }
}
