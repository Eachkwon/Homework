package Bus;

import java.util.UUID;

public class Bus {
    //Fields
    int maxPassenger = 30;  //최대 승객수
    int nowPassenger = 0;  //현재 승객수
    int busFare = 1400;          //요금
    String busNumber;     //버스 번호
    int fuel;    //주유량
    int currentSpeed;  //현재속도
    String status;     //상태: 운행, 차고지행

    //Constructors
    public Bus() {
        this.busNumber = UUID.randomUUID().toString();
        this.status = "운행";
    }

    //Method
//    버스 상태 변경 //
//    버스 객체 생성시 최초 상태는 '운행'
//    주유량이 떨어지거나, 운행을 종료할 때는 '차고지행' 상태
//    주유량이 10미만일 경우 '주유가 필요하다'는 메세지 출력
    public void changeState() {
        if(this.fuel<10){
            this.status = "차고지행";
            System.out.println("주유가 필요합니다.");
        }
    }

//    승객 탑승 //
//    '최대 승객 수'이하까지 가능하며 '운행 중'인 상태의 버스만 가능
//    탑승시 현재 승객 수 증가
    boolean isOnboardable() {
        return maxPassenger >= nowPassenger;
    }

    public void onBoard(int passenger) {
        this.nowPassenger += passenger;
        if(isOnboardable()&&this.status.equals("운행")){
            System.out.println("현재 승객의 수는 "+nowPassenger+"명입니다.");
        } else {
            System.out.println("최대 승객 수를 초과하였습니다.");
        }
    }

//    속도 변경 //
//    주유상태 체크, 주유량 10이상이어야 운행 가능
//    경고메세지 '주유량을 확인해 주세요.' print문으로 출력
//    변경할 속도를 입력 받아 현재 속도에서 추가하거나 뺄 수 있어야 함

    public void changeSpeed(int changeSpeed) {
        if(this.status.equals("운행")&&this.fuel>=10) {
            this.currentSpeed = changeSpeed;
        } else {
            System.out.println("주유량을 확인해주세요.");
        }
    }

    public static void main(String[] args) {
        Bus bus = new Bus();
        bus.changeState();
        bus.isOnboardable();
        bus.onBoard(4); //탑승한 승객
        bus.changeSpeed(20);  //바꿀 속도


    }
}