package study;

public class P67256 {
    public static String solution(int[] numbers, String hand){
        int left = 10;
        int right = 12;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                sb.append("L");
                left = numbers[i];
            }else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                sb.append("R");
                right = numbers[i];
            }else {
                if(numbers[i] == 0) numbers[i] = 11;
                int leftDiff = (Math.abs(numbers[i]-left))/3 + (Math.abs(numbers[i]-left))%3;
                int rightDiff = (Math.abs(numbers[i]-right))/3 + (Math.abs(numbers[i]-right))%3;
                if(leftDiff == rightDiff){
                    if(hand.equals("left")){
                        left = numbers[i];
                        sb.append("L");
                    }else{
                        right = numbers[i];
                        sb.append("R");
                    }
                }else{
                    if(leftDiff < rightDiff){
                        left = numbers[i];
                        sb.append("L");
                    }else{
                        right = numbers[i];
                        sb.append("R");
                    }
                }
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
    }
}
