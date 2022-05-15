package programmers;

public class P17682 {
    public static int solution(String dartResult) {
        int answer = 0;
        int one = 0;
        int two = 0;
        int three = 0;
        String[] splitNumber = dartResult.split("[DST][\\W]?");
        String[] splitStr = dartResult.split("\\d+");
        char[] chars = dartResult.toCharArray();
        for (int i = 0; i < 3; i++) {
            if(i == 0){
                if(splitStr[i+1].toCharArray()[0] == 'S'){
                    one = Integer.parseInt(splitNumber[i]);
                }else if(splitStr[i+1].toCharArray()[0] == 'D'){
                    one = Integer.parseInt(splitNumber[i]) * Integer.parseInt(splitNumber[i]);
                }else{
                    one = Integer.parseInt(splitNumber[i]) * Integer.parseInt(splitNumber[i]) * Integer.parseInt(splitNumber[i]);
                }
                if(splitStr[i+1].length() > 1){
                    if(splitStr[i+1].toCharArray()[1] == '*'){
                        one = one * 2;
                    }else{
                        one = one * -1;
                    }
                }
            }

            if(i == 1){
                if(splitStr[i+1].toCharArray()[0] == 'S'){
                    two = Integer.parseInt(splitNumber[i]);
                }else if(splitStr[i+1].toCharArray()[0] == 'D'){
                    two = Integer.parseInt(splitNumber[i]) * Integer.parseInt(splitNumber[i]);
                }else{
                    two = Integer.parseInt(splitNumber[i]) * Integer.parseInt(splitNumber[i]) * Integer.parseInt(splitNumber[i]);
                }
                if(splitStr[i+1].length() > 1){
                    if(splitStr[i+1].toCharArray()[1] == '*'){
                        two = two * 2;
                        one = one * 2;
                    }else{
                        two = two * -1;
                    }
                }
            }

            if(i == 2){
                if(splitStr[i+1].toCharArray()[0] == 'S'){
                    three = Integer.parseInt(splitNumber[i]);
                }else if(splitStr[i+1].toCharArray()[0] == 'D'){
                    three = Integer.parseInt(splitNumber[i]) * Integer.parseInt(splitNumber[i]);
                }else{
                    three = Integer.parseInt(splitNumber[i]) * Integer.parseInt(splitNumber[i]) * Integer.parseInt(splitNumber[i]);
                }
                if(splitStr[i+1].length() > 1){
                    if(splitStr[i+1].toCharArray()[1] == '*'){
                        three = three * 2;
                        two = two * 2;
                    }else{
                        three = three * -1;
                    }
                }
            }
        }
        answer = one + two + three;
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution("1S2D*3T"));
    }
}
