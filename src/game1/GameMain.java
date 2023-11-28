package game1;

public class GameMain {

    public static void main(String[] args) {
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");
        Player player = player1;
        RandomBox box = new RandomBox();
        while(!(player1.getHp() == 0) || !(player2.getHp() == 0)){
            if(player == player2){
                player = player1;
            }else{
                player = player2;
            }

            System.out.println(player.getName() +"님 차례입니다.");
            int n = player.PlayerInput();
            RESULT result = box.getNumber(n-1);
            if(result == RESULT.Correct){

                if(player.getScore() == 2){
                    System.out.println(player.getName() +"님이 승리하였습니다. ");
                    break;
                }
                System.out.println(player.getName() +"님이 정답을 뽑았습니다. ");
                player.setScore(player.getScore()+1);
                System.out.println(player.getName() +"님의 점수 : "+ player.getScore());
            }
            else if (result == RESULT.Fail){
                System.out.println(player.getName() +"님이 꽝을 뽑았습니다. ");
                player.setHp(player.getHp()-1);
                System.out.println(player.getName() +"님의 하트 갯수 : "+ player.getHp());
            }
            else if (result == RESULT.Bomb){
                System.out.println(player.getName() +"님이 폭탄을 뽑았습니다. ");
                player.setHp(player.getHp()-1);
                System.out.println(player.getName() +"님의 하트 갯수 : "+ player.getHp());
                player.setScore(player.getScore()-1);
                System.out.println(player.getName() +"님의 점수 : "+ player.getScore());
            }




        }


    }
}
