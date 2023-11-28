package day07;

//Thread의 장점과 단점
//장점 : 작업 속도가 빨라진다. 비동기 작업 가능
//단점: 컴텍스트 스위치가 많이 일어나면 오히려 작업 속도가 느려질 수 있다.
// 동기화가 어려워짐, 스레드 세이프하지 않을 수 있다.

public class Thread01Main {
    public static void main(String[] args) {

        // Thread 상속 받은 거 사용법
        Thread thread01 = new Thread01();
        thread01.start();

        // Runnable 인터페이스 구현한 쓰레드 사용법
        Runnable thread02 = new Thread02();
        Thread thread2 = new Thread(thread02);
    }
}
