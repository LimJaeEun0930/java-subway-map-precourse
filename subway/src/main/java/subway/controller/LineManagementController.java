package main.java.subway.controller;

import static main.java.subway.controller.LineController.lineController;
import static main.java.subway.repository.LineRepository.addLine;
import static main.java.subway.repository.LineRepository.deleteLineByName;
import static main.java.subway.view.LineInputView.lineInputView;
import static main.java.subway.view.OutputView.outputView;

import main.java.subway.domain.Line;

public class LineManagementController extends ManagementController{

    @Override
    public void run() {
        String choice = lineInputView.selectToDo();
        if (choice.equals("1")) {
            Line newLine = lineController.createLine();
            addLine(newLine);
            return;
        }
        if (choice.equals("2")) {
            String lineNameToDelete = lineInputView.getLineNameToDelete();
            deleteLineByName(lineNameToDelete);
            return;
        }
        if (choice.equals("3")) {
            outputView.printAllLines();
        }
    }

}
