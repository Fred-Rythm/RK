import java.io.*;
import java.net.*;

public class TCPServer {

    public static void main (String args[]) throws Exception {
        int port = Integer.parseInt(args[0]);
        int number = 0;
        int prevNumber;

        ServerSocket welcomeSocket = new ServerSocket(port);
        while(true){
            System.out.println("Waiting for client request");
            Socket connectSocket = welcomeSocket.accept();
            InputStream in = connectSocket.getInputStream();
            DataInputStream dataIn = new DataInputStream(in);
            try{
                while(true){
                    prevNumber = number;
                    number = dataIn.readInt();
                    //System.out.println(number);
                    if(number > 0 && number != prevNumber+1){
                        System.out.println("Error! Number: " + number + "  previous Number: " + prevNumber);
                    }
                }
            }catch(EOFException e){}
            connectSocket.close();
        }
    }
}
