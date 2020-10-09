package hw6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    static void addListener(Scanner in){
        Thread thread = new Thread(() -> {
            String str;

            while (true) {
                str = in.nextLine();
                System.out.println("server: " + str);
                if (str.equals("/end")) {
                    break;
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }


    public static void main(String[] args) {

        final String IP_ADDRESS = "localhost";
        final int PORT = 8189;

        Socket socket = null;
        Scanner in = null;
        PrintWriter out = null;

        try {
            socket = new Socket(IP_ADDRESS, PORT);
            System.out.println("connected to server");

            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true);

            addListener(in);


            Scanner consoleIn = new Scanner(System.in);
            String str;

            while (true){
                str = consoleIn.nextLine();
                out.println(str);

                if (str.equals("/end")){
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
