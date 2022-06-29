package Taxi;

public class Taxi {
    //Fields
    int taxiNumber;  //택시 번호
    int fuel;  //주유량
    int currentSpeed;  //현재 속도
    static final int basicDistance = 2;  //기본 거리
    static final int basicFare = 2800;  //기본 요금
    static final int fareForDistance= 100;  //거리당 요금
    int totalFare;  //최종 요금
    String status;   //상태: 일반, 운행 중, 탑승 불가

    //Constructors
    public Taxi() {
        this.taxiNumber = taxiNumber;
        this.status = "일반";
    }

//    운행시작
//    운행 시작 전 주유상태 체크하고 주유량이 10 이상이어야 운행 가능
    boolean isOnboardable() {
        return fuel>=10;
    }

    public void operating() {
        if (isOnboardable()) {
            System.out.println("운행 시작");
            this.status = "일반";
        }
        System.out.println("운행 불가");
        this.status = "탑승 불가";
    }

//    승객 탑승
//    승객 탑승은 상태가 '일반'일 때만 가능
//    그 외 택시는 '탑승 불가' 처리
//    '일반' 상태 택시가 승객을 태우면 '운행 중' 상태로 변경
    public void onBoard(String destination) {
        if (this.status.equals("일반")){
            this.status = "운행 중";
            System.out.println("목적지 "+destination+"으로 이동합니다.");
        } else {
            this.status = "탑승 불가";
            System.out.println("탑승 불가");
        }
    }

//    속도 변경
//    변경할 속도 입력 받아서 현재 속도에서 추가하거나 뺄 수 있어야 함
    public void changeSpeed(int changeSpeed) {
        this.currentSpeed = changeSpeed;
    }

//    거리당 요금 추가
//    기본 거리보다 먼 곳은 추가요금
//    기본 거리와 추가 요금은 자유롭게 산정
    public void fareAdd(int distanceToDestination) {
        if(distanceToDestination>basicDistance){
            this.totalFare= basicFare + (distanceToDestination-basicDistance)*fareForDistance;
        } else {
            this.totalFare = basicFare;
        }
    }

//    요금 결제
//    최종 요금을 출력
    public void pay() {
        this.totalFare = totalFare;
        System.out.println("총 요금은 "+totalFare+"원입니다.");
    }

    public static void main(String[] args) {
        Taxi taxi = new Taxi();
        taxi.operating();
        taxi.isOnboardable();
        taxi.onBoard("신사동");
        taxi.changeSpeed(30);
        taxi.fareAdd(12);
        taxi.pay();
    }
}

