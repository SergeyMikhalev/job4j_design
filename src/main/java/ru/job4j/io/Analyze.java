package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Analyze {
    private boolean serverAvailable = false;
    private List<String> data = new ArrayList<>(10);

    public void unavailable(String source, String target) {
        data.clear();

        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            in.lines().forEach(s -> {
                if ((s.startsWith("4") || s.startsWith("5")) && !serverAvailable) {
                    serverAvailable = true;
                    data.add(s.split(" ")[1] + ";");
                }
                if ((s.startsWith("2") || s.startsWith("3")) && serverAvailable) {
                    serverAvailable = false;
                    data.add(s.split(" ")[1] + ";" + System.lineSeparator());
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (data.size() > 0) {
            try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
                data.forEach(out::print);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Analyze().unavailable("server.log", "unavailable.csv");

    }
}
