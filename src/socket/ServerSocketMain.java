package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerSocketMain {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            Socket socket = serverSocket.accept();
            System.out.println(socket.getInetAddress() + "에서 접속했습니다.");

            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            OutputStream outputStream = socket.getOutputStream();
            PrintStream printStream = new PrintStream(outputStream);

            //Client에게 파일 이름 받아오는 코드
            System.out.println("waiting client...");
            String string = bufferedReader.readLine();
            System.out.println(string);
            
            //파일 내용을 퍼오는 코드
            FileReader fr = null;
            fr = new FileReader("src/socket/" + string);
            BufferedReader fileReader = new BufferedReader(fr);

            String total = "";
            String r = null;
            while(( r = fileReader.readLine()) != null){
                total = total + r;
            }
            System.out.println(total);

            //client에게 파일을 보내주는 코드
            printStream.println(total);

            /*
            System.out.print("To client : ");
            Scanner scanner  = new Scanner(System.in);
            outputStream.write(scanner.nextInt());
*/


            inputStream.close();
            outputStream.close();
            serverSocket.close();
            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
