package main.java.subway.controller;

import java.util.ArrayList;
import java.util.List;
import main.java.subway.view.InputView;
import main.java.subway.view.MainInputView;
import main.java.subway.view.OutputView;

public class AppController {
    private OutputView outputView;
    private InputView inputView;
    private final ArrayList<ManagementController> managementControllers = new ArrayList<>(List.of(new StationManagementController(),
            new LineManagementController(), new SectionManagementController()));

    public AppController() {
        outputView = OutputView.getInstance();
        inputView = new MainInputView();
    }

    public void run() {
        while (true) {
            String choice = inputView.selectToDo();
            if (choice.equals("Q")) {
                break;
            }
            if (choice.equals("4")) {
                LineController.printAllLineInfo();
            }
            ManagementController controller = managementControllers.get(Integer.parseInt(choice) - 1);
            controller.run();
        }
    }

}
