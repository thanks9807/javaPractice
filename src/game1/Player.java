package game1;

import java.util.Scanner;

public class Player {
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    private int hp;

    public String getName() {
        return name;
    }

    private String name;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private int score;
    public Player(String name) {
        this.hp = 5;
        this.name = name;
        this.score = 0;
    }

    public int PlayerInput(){
        System.out.println(name+" : 박스 번호를 입력해주세요.( 1, 2, 3)");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}
