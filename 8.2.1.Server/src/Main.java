import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("server started");
        int port = 8098;

        ServerSocket serverSocket = new ServerSocket(port);
        Socket clientSocket = serverSocket.accept();
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        out.println("Write your name");
        String userName = in.readLine();
        out.println("Are you child? (yes/no)");
        String resp = in.readLine();
        if (resp.equals("yes")) {
            out.println("Welcome to the kids area, " + userName + "! Let's play!");
        } else {
            out.println("Welcome to the adult zone, " + userName + "! Have a good rest, or a good working day!");
        }
    }
}
