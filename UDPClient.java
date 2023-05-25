import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;

public class UDPClient {


    public static void main(String[] args) throws IOException {

        String ipAddress = args[0];
        final int port = Integer.parseInt(args[1]);
        byte[]sendData;
        DatagramSocket sock = new DatagramSocket();
        for(int i = 0; i <=100000;i++)
        {
            sendData = ByteBuffer.allocate(4).putInt(i).array();
            DatagramPacket sendPkt = new DatagramPacket(sendData,sendData.length, InetAddress.getByName(ipAddress),port);
            sock.send(sendPkt);
        }
    }
}