package subway.controller;

import java.util.Scanner;
import subway.view.InputView;
import subway.view.OutputView;

public class AppController {
    private OutputView outputView;
    private InputView inputView;
    public AppController() {
        outputView = OutputView.getInstance();
        inputView = InputView.getInstance();
    }

    public void run() {
        while (true) {
            String choice = inputView.selectToDo();

        }
    }

}
