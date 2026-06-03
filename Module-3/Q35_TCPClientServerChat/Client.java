package Q35_TCPClientServerChat;
import java.io.*;
import java.net.*;
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true);

            BufferedReader keyboard =
                    new BufferedReader(new InputStreamReader(System.in));

            String message;

            while (true) {
                System.out.print("Client: ");
                message = keyboard.readLine();
                out.println(message);

                if (message.equalsIgnoreCase("exit")) {
                    break;
                }

                message = in.readLine();
                System.out.println("Server: " + message);
            }

            socket.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
