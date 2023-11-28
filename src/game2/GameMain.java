package game2;

/*
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.

*/


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GameMain {
    public static void main(String[] args) {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        Scanner scanner = new Scanner(System.in);
        System.out.print("경주에 참여할 자동차 수를 입력해 주세요.");
        Car[] cars = new Car[scanner.nextInt()];

        System.out.print("코스의 길이를 입력해 주세요.");
        int gameLength = scanner.nextInt();

        for(int i = 0 ; i < cars.length;i++){
            cars[i] = new Car();
            cars[i].setName("Car"+i);
        }

        for(int i = 0 ;i < gameLength ;i++){
            for(int c = 0 ; c < cars.length;c++){
                if(!cars[c].go(random.nextInt(10)))continue;
                /*
                if(cars[c/2].getScore() > cars[c].getScore()) continue;
                Car car = cars[c/2];
                cars[c/2] = cars[c];
                cars[c] = car;
                */
            }


        }
        for(int c = 0 ; c < cars.length;c++){
            System.out.print(cars[c].getName() + " : ");
            System.out.print(cars[c].getLoaction());
            System.out.println();
        }


        for(int c = 0 ; c < cars.length;c++){
            System.out.print(cars[c].getName() + "의 거리 : ");
            System.out.println(cars[c].getScore());

        }


    }
}
