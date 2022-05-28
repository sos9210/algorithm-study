package programmers.level2;
import java.util.*;
class CourseInfo{
    String courseName;  //코스명
    int count;          //코스개수
    public CourseInfo (String courseName, int count) {
        this.courseName = courseName;
        this.count = count;
    }
}
public class P72411 {
    static Map<String,CourseInfo> courseInfo = new HashMap<>();
    public static String[] solution(String[] orders, int[] course) {
        //일단 course의 갯수에 맞는 모든 코스메뉴구성을 구한다
        for (int i = 0; i < orders.length; i++) {
            for (int j = 0; j < course.length; j++) {
                char[] toChar = orders[i].toCharArray();
                Arrays.sort(toChar);
                findCourse(String.valueOf(toChar),course[j],"",0,0);
            }
        }

        //Map에서 CourseInfo객체를 꺼내서 List에 담고 count로 정렬한다.
        List<CourseInfo> list = new ArrayList<>(courseInfo.values());
        Collections.sort(list,((o1, o2) -> o2.count - o1.count));
        List<String> result = new ArrayList<>();

        //모든 코스메뉴구성에서 구하고자 하는 코스길이인 메뉴중에 count가 가장 높은 값들을 result에 담는다.
        //길이와 count가 같은경우에는 같이 넣는다.
        for (int i = 0; i < course.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < list.size(); j++) {
                if(list.get(j).courseName.length() == course[i] && max <= list.get(j).count && list.get(j).count != 1){
                    max = list.get(j).count;
                    result.add(list.get(j).courseName);
                }
            }
        }
        //String[] 으로 변환하고 알파벳 오름차순으로 정렬한다.
        String[] strings = result.toArray(new String[0]);
        Arrays.sort(strings);
        return strings;
    }

    //조합가능한 모든 코스메뉴들을 Map<코스명,개수> 형식으로 Map에 넣는다.
    public static void findCourse(String order, int courseLength,String courseName, int idx, int count){
        if(courseLength == count){
            if(courseInfo.get(courseName) == null){
                courseInfo.put(courseName,new CourseInfo(courseName, 1));
            }else{
                CourseInfo info = courseInfo.get(courseName);
                info.count += 1;
                courseInfo.put(courseName,info);
            }
            return;
        }
        for (int i = idx; i < order.length(); i++) {
            findCourse(order,courseLength , courseName+order.charAt(i),i+1,count+1);
        }
    }
    public static void main(String[] args) {
/*        Arrays.stream(solution(
                new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4}
        )).forEach( v -> System.out.print(v + " "));*/
        System.out.println();
        Arrays.stream(solution(
                new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2, 3, 5}
        )).forEach( v -> System.out.print(v + " "));
    }
}
