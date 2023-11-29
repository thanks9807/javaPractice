package myKakaoServer.Feat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;


//1. 접속하는 Client들에게 로그인 서비스를 제공하는 Thread을 만들어주는 곳
//2.

public class LoginServer extends Thread{
    ServerSocket serverSocket;
    Socket socket;
    private static Map<String,Map<String,Integer>> userMap = new HashMap<String,Map<String,Integer>>();
    public LoginServer(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    @Override
    public void run() {
        super.run();
        //Wait Client
        userMapInit();
        while(true){
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("접속이 있습니다. : "+socket.getInetAddress());
            //입력을 기다리는 새로운 Thread만들기
            Thread clientInputReciveThread = new ClientInputReciveThread(socket);
            clientInputReciveThread.start();
        }



    }

    private void userMapInit() {
        //FileInputStream fileInputStream;
        FileReader fileReader;
        BufferedReader bufferedReader;
        //유저 파일을 연다.
        try {
            //fileInputStream = new FileInputStream();
            fileReader = new FileReader("C:\\Users\\Playdata\\IdeaProjects\\ClassPractice\\src\\myKakaoServer\\Data\\user.csv");
            bufferedReader = new BufferedReader(fileReader);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //유저 정보를 읽어온다.
        try {

            String line;
            while((line = bufferedReader.readLine()) != null){
                //유저 정보를 해시맵에 저장한다.
                System.out.println(line);
                if(line.startsWith("#")) continue;
                String[] data = line.split(",");

                Map<String,Integer> passwardMap = new HashMap<String,Integer>();
                passwardMap.put(data[1],Integer.parseInt(data[2]));
                userMap.put(data[0],passwardMap);
                System.out.println(userMap);


            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
