package myKakaoServer;

import java.io.IOException;
import java.net.ServerSocket;
import myKakaoServer.Feat.*;

public class ServerMainEntry {
    public static void main(String[] args) {
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(9807);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 로그인 기능
        Thread loginServer = new LoginServer(serverSocket);
        loginServer.start();
        // 원하는 파일을 퍼올리는 기능

        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
