package Q35_TCPClientServerChat;
import java.io.*;
import java.net.*;
public class Server {
     public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server started. Waiting for client...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true);

            BufferedReader keyboard =
                    new BufferedReader(new InputStreamReader(System.in));

            String message;

            while (true) {
                message = in.readLine();
                System.out.println("Client: " + message);

                System.out.print("Server: ");
                message = keyboard.readLine();
                out.println(message);

                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
            }

            socket.close();
            serverSocket.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
