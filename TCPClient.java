/*
* 1. TCP macht keine Fehler bzw. bei UDP ist die Fehlerrate viel höher, da Absender keine Empfangsbestätigung bekommt -> Daten gehen bei Übertragung durch Bitfehler usw verloren.
* 2.1 java.net.BindException (mehrere Server hören auf dem gleichen Port; für wen sind eingehende Pakete gemeint?)
* 2.2 TCP: java.net.UnknownHostException UDP: Fehler
* 2.3 TCP: java.net.ConnectException: Connection refused UDP: kein Fehler
* 3 Die Fehlerrate wird viel geringer
*   höhere Übertragungsrate kann zu einer Netzüberlastung kommen -> wie auf Autobahn: zu viele Autos -> Stau. Durch langsameres senden sinkt Fehlerrate.
* */
import java.io.*;
import java.net.*;

public class TCPClient {

    public static void main(String args[]) throws Exception {
        Socket clientSocket = new Socket("localhost", 2345);
        OutputStream out = clientSocket.getOutputStream();
        DataOutputStream dataOut = new DataOutputStream(out);
        for(int i = 0; i<=1000000;i++) {
            dataOut.writeInt(i);
            System.out.println("Sending: " + i);
        }
        dataOut.close();
        clientSocket.close();
    }
}

