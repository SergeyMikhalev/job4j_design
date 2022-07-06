package ru.job4j.chat;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    private final String path;
    private final String botAnswers;
    private List<String> phrases;
    private final List<String> log = new ArrayList<>(100);
    private boolean ended = false;
    private boolean answer = true;
    private Random random = new Random();

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        phrases = readPhrases();
        while (!ended) {
            String phrase = scanner.nextLine();
            processCommands(phrase);
            log.add(phrase);
            if (answer) {
                makeAnswer();
            }
        }
        saveLog();
    }

    private void makeAnswer() {
        String botsAnswer = phrases.get(random.nextInt(phrases.size()));
        System.out.println(botsAnswer);
        log.add(botsAnswer);
    }

    private void processCommands(String phrase) {
        switch (phrase) {
            case OUT:
                ended = true;
                answer = false;
                break;
            case STOP:
                answer = false;
                break;
            case CONTINUE:
                answer = true;
                break;
            default:
        }
    }

    private List<String> readPhrases() {
        List<String> result = new ArrayList<>(20);
        try {
            Files.lines(Path.of(path)).forEach(result::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void saveLog() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(botAnswers))) {
            for (String s : log) {
                writer.write(s);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("phrases.txt", "log.txt");
        cc.run();
    }


}
