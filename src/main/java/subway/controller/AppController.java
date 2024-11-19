package subway.controller;

import java.util.ArrayList;
import java.util.List;
import subway.view.InputView;
import subway.view.OutputView;

public class AppController {
    private OutputView outputView;
    private InputView inputView;
    private final ArrayList<ManagementController> managementControllers = (ArrayList<ManagementController>) List.of(new StationManagementController(),
            new LineManagementController(), new SectionManagementController());

    public AppController() {
        outputView = OutputView.getInstance();
        inputView = InputView.getInstance();
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
