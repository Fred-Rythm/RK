import java.net.*;
import java.io.*;

import static java.lang.System.in;

public class TCPServer {


        public static void main(String[] args) throws IOException {
            String sentence;
            ServerSocket welcomeSocket = new ServerSocket(2345);
            while(true) {

                Socket connectionSocket = welcomeSocket.accept();
                DataInputStream dataIn = new DataInputStream(in);
                int i = dataIn.readInt();
                System.out.println(i);
            }
        }

}
