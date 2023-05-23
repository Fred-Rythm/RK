import java.net.*;
import java.io.*;

import static java.lang.System.in;

public class TCPServer {


        public static void main(String[] args) throws IOException {
            ServerSocket welcomeSocket = new ServerSocket(2345);
            while(true) {

                Socket connectionSocket = welcomeSocket.accept();
                DataInputStream dataIn = new DataInputStream(connectionSocket.getInputStream());
                int i = dataIn.readInt();
                System.out.println(i);
                connectionSocket.close();
            }
        }

}
