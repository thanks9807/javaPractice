package myKakaoServer.Feat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientInputReciveThread extends Thread{
    public ClientInputReciveThread(Socket socket) {
        this.socket = socket;
    }

    Socket socket;

    @Override
    public void run() {
        super.run();
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        Command command = new Command();
        try {
            inputStreamReader = new InputStreamReader(socket.getInputStream());
            bufferedReader = new BufferedReader(inputStreamReader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 계속 Client의 입력만 받는다.
        // inputOrigin를 Command클래스에 처리를 맡긴다.
        while(true){
            String inputOrigin;
            try {
                inputOrigin = bufferedReader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("clinet :"+inputOrigin);
            command.isCommand(inputOrigin);
        }
    }
}
