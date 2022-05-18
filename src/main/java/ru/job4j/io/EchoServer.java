package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {

                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {

                    String str = in.readLine();
                    System.out.println(str);

                    String message = str.split(" ")[1];
                    String[] strings = message.split("/?msg=");

                    Arrays.stream(strings).forEach(System.out::println);

                    if (strings.length > 1) {
                        
                        switch (strings[1]) {
                            case "Exit":
                                System.out.println("Cosing server socket");
                                server.close();
                                break;
                            case "Hello":
                                out.write("HTTP/1.1 200 OK\r\n\r\nHello, dear friend".getBytes());
                                break;
                            default:
                                out.write(("HTTP/1.1 200 OK\r\n\r\n" + strings[1]).getBytes());
                        }
                    }
                    out.flush();
                }
            }
        }
    }

}
