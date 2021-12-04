package sec02;

import java.util.Scanner;

public class Sec02_02 {
    /*  //내가푼것.
    public ArrayList<Integer> solution(int[] arr){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if(list.get(cnt) < arr[i]){
                list.add(arr[i]);
                cnt++;
            }
        }
        return list;
    }
     */
    //강의
    public int solution(int n,int[] arr){
        int answer = 1, max = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] > max){
                answer++;
                max=arr[i];
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Sec02_02 T = new Sec02_02();
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        int cnt[] = new int[input1];
        for (int i = 0; i < input1; i++) {
            cnt[i] = in.nextInt();
        }
        //System.out.print(T.solution(cnt).size());
        System.out.print(T.solution(input1,cnt));
        return ;
    }
}
