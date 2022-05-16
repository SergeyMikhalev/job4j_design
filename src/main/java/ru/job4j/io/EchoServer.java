package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {

                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    for (String str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {
                        if (str.startsWith("GET")) {
                            String cmd = parseMsg(str);
                            if ("Bye".equals(cmd)) {
                                System.out.println("Got 'Bye' server close cmd. Closing server....");
                                server.close();
                            }
                        }
                        System.out.println(str);
                    }
                    out.flush();
                }
            }
        }
    }

    private static String parseMsg(String s) {
        String rsl = "";
        String[] substrings = s.split(" ");
        if (substrings.length > 1) {
            String[] msg = substrings[1].split("=", 2);
            if ((msg.length > 1) && ("/?msg".equals(msg[0]))) {
                rsl = msg[1];
            }
        }
        return rsl;
    }
}
