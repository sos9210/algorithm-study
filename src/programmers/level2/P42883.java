package programmers.level2;

//큰 수 만들기
//문자길이가 최대 100백만이기 때문에 완전탐색불가.
//StringBuilder로 메모리절약필요
public class P42883 {
    public static String solution(String number, int k) {
        int now = 0;
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int len = number.length() -k;
        for(int i=0; i<len; i++) { //number길이 - k 만큼만 (뽑아야하는 문자길이만큼만)
            int max = 0;
            //now는 앞서 탐색된 문자의 인덱스 번호+1 이다.
            for(int j=now; j<=i+k; j++) {   //i+k로 하는 이유는 뒷자리가 남아야 나머지 숫자도 뽑을 수 있기 때문
                int tmp_num = number.charAt(j)-'0';
                if(max < tmp_num) {
                    now = j+1;              //현재 탐색된 문자의 인덱스번호+1은 다음 탐색시작부분으로 저장한다.
                    max = tmp_num;
                }
            }
            sb.append(max);

        }
        answer = sb.toString();
        return answer;
    }
    public static void main(String[] args) {
       // System.out.println(solution("1924",2));
        System.out.println(solution("1231234",3));
        System.out.println(solution("4177252841",4));
    }
}
