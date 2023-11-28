package chat;

import java.io.*;
import java.net.Socket;

public class ChatMessageInput extends Thread{

    Socket socket;

    public ChatMessageInput(Socket socket) {
        this.socket=socket;
    }

    @Override
    public void run() {
        super.run();

        BufferedReader bufferedReader = null;
        try {
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);

            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            //최초 입력은 ID
            String userID = bufferedReader.readLine();
            ChatServer.clientMap.put(userID,socket);

            ChatMessageOutput output  = new ChatMessageOutput();

            while(true){
                String str = "0";
                //메시지 받는 곳
                str= bufferedReader.readLine();
                System.out.println(userID+ " : " + str);
                //여기까지 메시지를 받는 곳

                //각종 특별 입력 정리하는 곳
                boolean isCommand = false;
                for(String id : ChatServer.clientMap.keySet()){
                    if(str.startsWith(id)){
                        String msg = str.replace(id,"(Secret Mode)");
                        output.send(id,userID+ " : " + msg);
                        isCommand = true;
                    }

                }

                if(str.startsWith("-userlist")){
                    str = "";
                    for(String id: ChatServer.clientMap.keySet()){
                        str += id+" ";
                    }

                    output.send(userID,str);
                    isCommand = true;
                }

                if(isCommand) continue;
                //여기까지 특별입력 정리하는 곳
                
                
                //메시지를 모든 클라이언트들에게 보내는 곳

                output.sendMsgAll(userID+ " : " + str);

                if(str.startsWith("pic")){
                    //그림 파일 받을 준비
                    System.out.println("그림 파일 받을 준비.");
                    //inputStream.reset();

                    byte[] data = bufferedInputStream.readAllBytes();
                    System.out.println(data);
                    System.out.println("바이트 데이터가 들어왔습니다.");


                }



                if(str.equals("0")) break;
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }




        if(bufferedReader != null){
            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }



    }
}
