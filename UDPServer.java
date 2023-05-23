import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.nio.ByteBuffer;

public class UDPServer {

    public static void main(String[] args) throws IOException {
        int port = 2345;
        DatagramSocket sock = new DatagramSocket(port);
        while(true){
            byte[] rcvData = new byte[1024];
            DatagramPacket rcvPkt = new DatagramPacket(rcvData,rcvData.length);
            sock.receive(rcvPkt);
           int i = ByteBuffer.wrap(rcvPkt.getData(),0,rcvPkt.getLength()).getInt();
           System.out.println(i);

        }


    }
}
