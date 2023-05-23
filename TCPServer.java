import java.io.*;
import java.net.*;
public class TCPServer {
    public static void main(String[] argv) throws Exception
    {
        ServerSocket welcomeSocket = new ServerSocket(6789);
        int alt = -1;
        while(true) {
            Socket connectSocket = welcomeSocket.accept();
            DataInputStream inFromClient =
                    new DataInputStream(connectSocket.getInputStream());
            int i = inFromClient.readInt();
            if(alt  == -1) {
                alt = i;
            } else {
                if(i != alt + 1) {
                    System.err.println("Die Zahlenfolge ist nicht fortlaufend!!! (vorletzte Zahl: " + alt +
                            " letzte Zahl: " + i + ")");
                }
                alt = i;
            }
            connectSocket.close();
        }
    }
}
