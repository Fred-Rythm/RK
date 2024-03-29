import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;

public class UDPClient {


    public static void main(String[] args) throws IOException {

        //String ipAddress = "127.0.0.0";
        int port = Integer.parseInt(args[1]);
        byte[]sendData;
        DatagramSocket sock = new DatagramSocket(2346);
        for(int i = 0; i <=100000;i++)
        {
            System.out.println(i);
            sendData = ByteBuffer.allocate(4).putInt(i).array();
            DatagramPacket sendPkt = new DatagramPacket(sendData,sendData.length, InetAddress.getByName(args[0]),port);
            sock.send(sendPkt);
        }
        sock.close();
    }
}
