package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatServer {
    static List<Socket> clientSockets = new ArrayList<Socket>();
    static Map<String,Socket> clientMap = new HashMap<String,Socket>();
    public static void main(String[] args) {
        ServerSocket serverSocket;
        //List<Socket> clientSockets = new ArrayList<Socket>();

        //ChatMessageOutput msgThread = new ChatMessageOutput(clientSockets);


        try {
            serverSocket = new ServerSocket(9999);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while(true){
            try {
                //처음 접속하는 곳
                Socket client = serverSocket.accept();
                clientSockets.add(client);

                System.out.println(client.getInetAddress() + "에서 접속했습니다. 현재 유저 수 :" + clientSockets.size());
                Thread thread01 = new ChatMessageInput(client);
                thread01.start();

            } catch (IOException e) {
                System.out.println(e.getMessage());
                break;

            }


        }

    }






}
