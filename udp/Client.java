import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

class Client {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        File path = new File(bufferedReader.readLine());

        BufferedReader inFromUser = new BufferedReader(new FileReader(path));

        DatagramSocket clientSocket = new DatagramSocket();

        InetAddress IPAddress = InetAddress.getByName("localhost");
        String sentence = inFromUser.readLine();
        byte[] sendData = sentence.getBytes();

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
        System.out.println("Message sent to port: 9876 with length: " + sendData.length);

        clientSocket.send(sendPacket);

        clientSocket.close();
    }
}