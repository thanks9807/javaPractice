package game2;

import java.util.Random;

public class Car {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public int getScore() {
        return score;
    }

    private int score;

    public String getLoaction() {
        return loaction;
    }

    private String loaction = "";

    boolean go(int n){
        if(n >= 4){
            score++;
            loaction += "-";
            return true;
        }
        return false;
    }

}
