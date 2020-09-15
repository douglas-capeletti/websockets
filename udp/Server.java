import java.net.DatagramPacket;
import java.net.DatagramSocket;

class Server {
    public static void main(String[] args) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(9876);
        System.out.println("Server started at port: 9876");

        byte[] receiveData = new byte[100000];
        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            serverSocket.receive(receivePacket);

            String sentence = new String(receivePacket.getData());
            System.out.println("Mensagem recebida: " + sentence);
        }
    }
}