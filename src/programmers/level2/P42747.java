package programmers.level2;

import java.util.Arrays;

//H-index
public class P42747 {
    public static int solution(int[] citations) {
        int answer = 0;
        //오름차순 정렬
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;

            //h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하
            //정렬했기때문에 h보다 크거나 같은 값이나오면 바로 리턴
            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }
        //정답은 citations길이를 초과하는건 없음.
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3,0,6,1,5})); //3
        System.out.println(solution(new int[]{1,4})); // 1
        System.out.println(solution(new int[]{0,1,2})); // 1
        System.out.println(solution(new int[]{3, 4, 5, 11, 15, 16, 17, 18, 19, 20})); // 7
        System.out.println(solution(new int[]{20,21,22,23})); // 4
        System.out.println(solution(new int[]{4,4,4})); // 3
        System.out.println(solution(new int[]{5,3,3,8,10})); // 3
        System.out.println(solution(new int[]{5,4,3,8,10})); // 4

    }
}
