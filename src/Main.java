import sec02.Sec02_01;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
//      char c = in.next().charAt(0);System.out.print(Sec01_01.solution(str, c)); //sec01-01 문자찾기
//      System.out.println(Sec01_02.solution(str)); //sec01-02 대소문자변환
//        System.out.println(Sec01_03.solution(str)); // Sec01_03 문장 속 단어
/*      //Sec01_04 단어 뒤집기
        String[] str = new String[cnt];
        for(int i=0; i < cnt; ++i){
            str[i] = in.next();
        }
        for (String x : Sec01_04.solution(cnt, str)) {
            System.out.println(x);
        }
 */
//        System.out.println(Sec01_05.solution(str)); //특정문자뒤집기
//        System.out.println(Sec01_06.solution(str)); //중복문자제거
//        System.out.println(Sec01_07.solution(str)); //회문문자열
//        System.out.println(Sec01_08.solution(str)); //유효한 팰린드롬
//        System.out.println(Sec01_09.solution(str)); //숫자만 추출
//        char ch = in.next().charAt(0);System.out.println(Sec01_10.solution(str,ch)); //가장 짧은 문자거리
//        System.out.println(Sec01_11.solution(str)); //문자열 압축
//        System.out.println(Sec01_12.solution(n,str)); //암호
        String input1 = in.nextLine();
        String[] s = input1.split(" ");
        int tmp = 0;
        for (int i=0; i < n; ++i){
            int input2 = Integer.parseInt(s[i]);
            if(input2 > tmp){
                System.out.print(Sec02_01.solution(input2)+" "); //큰 수 출력하기
            }
            tmp = input2;
        }
        return ;
    }
}