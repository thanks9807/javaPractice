package game1;

import java.util.Random;

public class RandomBox {
    Random random ;
    RESULT[] box = {RESULT.Correct,RESULT.Fail,RESULT.Bomb};
    public RandomBox() {
        random= new Random();
        random.setSeed(System.currentTimeMillis());
    }

    RESULT getNumber(int n){

        for(int i = 0 ;i < 50 ;i++){
            int j = random.nextInt()%3;
            RESULT result = box[j];
            box[j] = box[0];
            box[0] = result;

        }
        return box[n];
    }
}
