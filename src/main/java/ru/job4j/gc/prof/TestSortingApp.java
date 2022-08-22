package ru.job4j.gc.prof;

import ru.job4j.ui.console.action.UserAction;
import ru.job4j.ui.console.action.sort.ExitAction;
import ru.job4j.ui.console.action.sort.GenerateDataAction;
import ru.job4j.ui.console.action.sort.SortAction;
import ru.job4j.ui.console.input.ConsoleInput;
import ru.job4j.ui.console.input.Input;
import ru.job4j.ui.console.input.ValidateInput;
import ru.job4j.ui.console.output.ConsoleOutput;
import ru.job4j.ui.console.output.Output;

import java.util.List;
import java.util.Random;

public class TestSortingApp {

    public void init(Input input, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Enter select: ");
            UserAction action = actions.get(select);
            run = action.execute(input, null);
        }
    }

    private void showMenu(List<UserAction> actions) {
        System.out.println("Menu.");
        for (int i = 0; i < actions.size(); i++) {
            System.out.printf("%d. %s%n", i, actions.get(i).name());
        }
    }

    public static void main(String... args) {
        Input validate = new ValidateInput(
                new ConsoleInput()
        );
        Output output = new ConsoleOutput();
        Data data = new RandomArray(new Random());
        Sort bubbleSort = new BubbleSort();
        Sort insertSort = new InsertSort();
        Sort mergeSort = new MergeSort();
        List<UserAction> actions = List.of(
                new GenerateDataAction(data),
                new SortAction("Bubble Sort", bubbleSort, data),
                new SortAction("Insert Sort", insertSort, data),
                new SortAction("Merge Sort", mergeSort, data),
                new ExitAction()
        );

        new TestSortingApp().init(validate, actions);

    }

}
