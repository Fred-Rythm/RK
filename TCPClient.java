import java.io.*;
import java.net.*;
/*
* 1. TCP macht keine Fehler bzw. bei UDP ist die Fehlerrate viel höher, da Absender keine Empfangsbestätigung bekommt -> Daten gehen bei Übertragung durch Bitfehler usw verloren.
* 2.1 java.net.BindException (mehrere Server hören auf dem gleichen Port; für wen sind eingehende Pakete gemeint?)
* 2.2 TCP: java.net.UnknownHostException UDP: Fehler
* 2.3 TCP: java.net.ConnectException: Connection refused UDP: kein Fehler
* 3 Die Fehlerrate wird viel geringer
*   höhere Übertragungsrate kann zu einer Netzüberlastung kommen -> wie auf Autobahn: zu viele Autos -> Stau. Durch langsameres senden sinkt Fehlerrate.
* */
class TCPClient {
    public static void main(String[] argv) throws Exception {

        for (int i = 0; i <= 1000000; i++) {
            Socket clientSocket = new Socket(argv[0], Integer.parseInt(argv[1]));
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            outToServer.writeInt(i);
            outToServer.flush();
            clientSocket.close();
        }
    }
}
