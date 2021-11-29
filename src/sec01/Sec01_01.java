package sec01;

import java.util.Scanner;
//1.문자찾기
public class Sec01_01 {
    public static int solution(String str, char t) {
        int answer = 0;
        str = str.toUpperCase();
        t = Character.toUpperCase(t);
		/*
		for(int i=0; i < str.length(); ++i) {
			if(str.charAt(i) == t) {
				++answer;
			}
		}
		*/
        for(char x : str.toCharArray()) {
            if(x == t) {
                ++answer;
            }
        }
        return answer;
    }
}
