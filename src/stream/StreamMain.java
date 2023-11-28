package stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamMain {
    public static void main(String[] args) {

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
           fileInputStream = new FileInputStream("src/stream/testFile.txt");
           fileOutputStream = new FileOutputStream("src/stream/testFile3.txt");
           byte[] num = fileInputStream.readAllBytes();
           for (int i =0 ; i < num.length;i++){
               //System.out.println(num);
               fileOutputStream.write(num[i]);
           }




        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (NullPointerException e){

            }
        }


    }
}
