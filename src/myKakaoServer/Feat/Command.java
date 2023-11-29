package myKakaoServer.Feat;

public class Command {
    public void isCommand(String inputOrigin) {
        if(inputOrigin.startsWith("LOGIN")){
            login(inputOrigin);
        }

    }

    void login(String inputOrigin){

    }

}
