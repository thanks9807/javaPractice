package chat;

import java.io.*;
import java.net.Socket;

public class ChatOutputStream extends Thread {
    byte[] data;

    public ChatOutputStream(byte[] data) {
        this.data = data;
    }

    void sendAll(){

        for(int i = 0 ; i <ChatServer.clientSockets.size();i++){
            try {
                Socket socket = ChatServer.clientSockets.get(i);
                OutputStream outputStream = socket.getOutputStream();
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);

                bufferedOutputStream.write(data);
                bufferedOutputStream.flush();

                //bufferedWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }
    }


    @Override
    public void run() {
        super.run();
        sendAll();



    }
}
