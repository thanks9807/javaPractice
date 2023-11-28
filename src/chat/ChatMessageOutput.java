package chat;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.List;
public class ChatMessageOutput{


    public ChatMessageOutput() {

    }


    void sendMsgAll(String msg){
        for(int i = 0 ; i <ChatServer.clientSockets.size();i++){
            try {
                Socket socket = ChatServer.clientSockets.get(i);
                OutputStream outputStream = socket.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

                bufferedWriter.write(msg+"\n");
                bufferedWriter.flush();

                //bufferedWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }
    }


    public void send(String id, String msg) {
        try {
            Socket socket = ChatServer.clientMap.get(id);
            OutputStream outputStream = socket.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            bufferedWriter.write(msg+"\n");
            bufferedWriter.flush();

            //bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
