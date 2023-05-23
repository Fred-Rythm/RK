import java.io.*;
import java.net.*;

class TCPClient {
    public static void main(String[] argv) throws Exception {

        for (int i = 0; i <= 1000000; i++) {
            Socket clientSocket = new Socket(argv[1], 6789);
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            outToServer.writeInt(i);
            outToServer.flush();
            clientSocket.close();
        }
    }
}
