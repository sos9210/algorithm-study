package study;

public class P361900 {
/*    public static void main(String[] args) {
        int n = 5;
        int answer = 0;
        int a = 0;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            answer = (a+b) % 1234567;
            System.out.println(answer);
            a = b;
            b = answer;
        }
    }*/
    static int[] answer = {-1};
    static int[] lion = new int[11];
    static int max = Integer.MIN_VALUE;

    private static void DFS(int[] apeach,int cnt,int n){
        if(cnt == n+1){
            int apeach_point = 0;
            int lion_point = 0;
            for (int i = 0; i <= 10; i++) {     //0부터 10까지 돌면서 라이언과 어피치 총 점수를 계산한다.
                if(apeach[i] != 0 || lion[i] != 0){
                    if(apeach[i] < lion[i]){
                        lion_point += 10 - i;
                    }else{
                        apeach_point += 10 - i;
                    }
                }
            }
            if(lion_point > apeach_point){  //계산한 결과 라이언점수가 어피치 점수보다 크면 ?
                if(lion_point - apeach_point >= max){   //현재 계산한 라이언 점수 - 어피치 점수가 이전에 계산한 결과보다 크거나 같으면?
                    answer = lion.clone();              //현재 라이언배열을 clone()
                    max = lion_point - apeach_point;
                }
            }
            return;
        }
                                //각 점수판(i)에서 라이언보다 어피치가 크거나 같을때
        for (int i = 0; i <= 10 && lion[i] <= apeach[i]; i++) {
            lion[i]++;
            DFS(apeach,cnt+1,n);
            lion[i]--;
        }
    }
    public static void main(String[] args) {
        int n = 5;
        int[] info = {2,1,1,1,0,0,0,0,0,0,0};
        DFS(info,1,n);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}

