package ru.job4j.ui.console.input;

public interface Input {
    String askStr(String question);
    int askInt(String question);
    int askInt(String question, int max);
}
