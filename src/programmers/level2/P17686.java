package programmers.level2;

import java.util.Arrays;
import java.util.Comparator;
//파일명 정렬
//https://velog.io/@hyeon930/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%ED%8C%8C%EC%9D%BC%EB%AA%85-%EC%A0%95%EB%A0%AC-Java
public class P17686 {
    public static String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String[] file1 = detach(s1);
                String[] file2 = detach(s2);

                int headValue = file1[0].compareTo(file2[0]);

                //head부분에서 compareTo 결과 0이면 같은 문자이므로
                //number부분에서 정렬한다.
                if(headValue == 0) {
                    int num1 = Integer.parseInt(file1[1]);
                    int num2 = Integer.parseInt(file2[1]);

                    return num1 - num2;
                } else {
                    return headValue;
                }
            }
            //head number tail 세부분으로 나눈다.
            private String[] detach(String str) {
                StringBuilder head = new StringBuilder();
                StringBuilder number = new StringBuilder();
                StringBuilder tail = new StringBuilder();

                int idx = 0;
                for( ; idx < str.length() ; ++idx) {
                    char ch = str.charAt(idx);
                    if(ch >= '0' && ch <= '9') break;   //숫자가 나오면 탈출
                    head.append(ch);
                }

                for( ; idx < str.length() ; ++idx) {
                    char ch = str.charAt(idx);
                    if(!(ch >= '0' && ch <= '9')) break;   //숫자가 아니면 탈출
                    number.append(ch);
                }

                for( ; idx < str.length() ; ++idx) {
                    char ch = str.charAt(idx);  //나머지 부분은 꼬리부분이므로 끝까지
                    tail.append(ch);
                }

                String[] file = {head.toString().toLowerCase(), number.toString(), tail.toString()};

                return file;
            }
        });
        return files;
    }
    public static void main(String[] args) {
        //Arrays.stream(solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"})).forEach(v-> System.out.print(v + " "));
        System.out.println();
        Arrays.stream(solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"})).forEach(v-> System.out.print(v + " "));
    }
}
