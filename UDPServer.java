import java.io.*;
import java.net.*;
import java.nio.*;

public class UDPServer {

    public static void main(String[] args) throws IOException {
        int prevNumber;
        int number = 0;
        DatagramSocket sock = new DatagramSocket(Integer.parseInt(args[0]));
        while(true){
            byte[] rcvData = new byte[1024];
            try{
                while(true) {
                    DatagramPacket rcvPkt = new DatagramPacket(rcvData,rcvData.length);
                    sock.receive(rcvPkt);
                    prevNumber = number;
                    number = ByteBuffer.wrap(rcvPkt.getData(), 0, rcvPkt.getLength()).getInt();
                    //System.out.println(number);
                    if(number > 0 && number != prevNumber+1){
                        System.out.println("Error! Number: " + number + "  previous Number: " + prevNumber);
                    }
                }
            }catch(Exception e){}
        }
    }
}