import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

public class UDPClient {


    public static void main(String[] args) throws IOException {

        String ipAddress = "127.0.0.1";
        int port = 2345;
        byte[]sendData = new byte[1024];
        DatagramSocket sock = new DatagramSocket(port);
        for(int i = 0; i <=1000000;i++)
        {

            sendData = ByteBuffer.allocate(8).putInt(i).array();
            DatagramPacket sendPkt = new DatagramPacket(sendData,sendData.length, InetAddress.getByName(ipAddress),port);
            sock.send(sendPkt);
        }
    }
}
