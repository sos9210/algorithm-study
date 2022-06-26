package programmers.level2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Car {
    String carNumber;
    int inTime = 0;
    int outTime = 0;
    String status;
    int totalTime;
    public Car (String carNumber,int inTime, int outTime, String status){
        this.carNumber = carNumber;
        this.inTime = inTime;
        this.outTime = outTime;
        this.status = status;
    }
}

public class P92341 {
    public static int[] solution(int[] fees, String[] records) {
        Map<String,Car> map = new HashMap<>();
        for (int i = 0; i < records.length; i++) {
            String[] cars = records[i].split(" ");
            if(map.get(cars[1]) == null){
                String[] time = cars[0].split(":");
                Car car = new Car(cars[1],
                        (Integer.parseInt(time[0])*60) + (Integer.parseInt(time[1])),
                        1439,
                        cars[2]);

                map.put(car.carNumber,car);
                continue;
            }
            timeCalc(cars, map,fees);
        }
        int[] answer = new int[map.size()];
        int idx = 0;
        Car[] cars = map.values().toArray(new Car[map.size()]);

        //차량넘버순으로 정렬
        Arrays.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return Integer.parseInt(o1.carNumber) - Integer.parseInt(o2.carNumber);
            }
        });
        for (Car i :cars) {
            Car car = i;
            if(car.status.equals("IN")){
                car.totalTime = car.totalTime + car.outTime - car.inTime;
            }
            int cost = 0;
            if(fees[0] >= car.totalTime){ //주차시간이 기본시간보다 적으면 기본요금 적용한다.
                cost=fees[1];
            }else {
                cost = ((car.totalTime - fees[0]) / fees[2]) * fees[3] + fees[1];  //요금계산..  (주차시간 - 기본시간) / 단위시간) * 단위요금
                if((car.totalTime - fees[0]) % fees[2] != 0) cost += fees[3];       //주차시간이 단위시간에 정확히 나눠지지않는경우
            }
            answer[idx++] = cost;
        }

        return answer;
    }
    public static void timeCalc(String[] cars, Map<String,Car> map, int[] fees){
        Car car = map.get(cars[1]);
        String[] time = cars[0].split(":");
        if(cars[2].equals("IN")){ //입차
            car.inTime = (Integer.parseInt(time[0])*60) + (Integer.parseInt(time[1]));
            car.outTime = 1439;
            car.status = "IN";
        }else{      //출차
            car.outTime = (Integer.parseInt(time[0])*60) + (Integer.parseInt(time[1]));
            car.status = "OUT";
            int timeDiff = car.outTime - car.inTime;
            car.totalTime += timeDiff;
        }
        map.put(car.carNumber,car);
    }
    public static void main(String[] args) {
                        //기본시간,기본요금,단위시간,단위요금
        Arrays.stream(solution(new int[]{180, 5000, 10, 600},
                new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"}
        )).forEach(v -> System.out.print(v+" "));
    }
}
