import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.nio.ByteBuffer;

public class UDPServer {

    public static void main(String[] args) throws IOException {
        int port = Integer.parseInt(args[1]);
        DatagramSocket sock = new DatagramSocket(port);
        while(true){
            byte[] data = ByteBuffer.allocate(8).putInt(

            )
        }


    }
}
