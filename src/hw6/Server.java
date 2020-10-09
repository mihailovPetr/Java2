package hw6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {

        ServerSocket server = null;
        Socket socket = null;
        final int PORT = 8189;

        try {
            server = new ServerSocket(PORT);
            System.out.println("Server started");
            socket = server.accept();
            System.out.println("Client connected");

            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            Thread thread = new Thread(() -> {
                String str;
                while (true) {
                    str = in.nextLine();
                    System.out.println("client: " + str);
                    if (str.equals("/end")) {
                        break;
                    }
                }
            });
            thread.setDaemon(true);
            thread.start();


            Scanner consoleIn = new Scanner(System.in);
            while (true) {

                String str = consoleIn.nextLine();
                out.println(str);

                if (str.equals("/end")) {
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
