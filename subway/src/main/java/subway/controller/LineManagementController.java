package main.java.subway.controller;

import static main.java.subway.controller.LineController.lineController;
import static main.java.subway.repository.LineRepository.addLine;
import static main.java.subway.view.LineInputView.lineInputView;

import main.java.subway.domain.Line;

public class LineManagementController extends ManagementController{

    @Override
    public void run() {
        while (true) {
            String choice = lineInputView.selectToDo();
            if (choice.equals("B")) {
                break;
            }
            if (choice == "1") {
                Line newLine = lineController.createLine();
                addLine(newLine);
            }
        }
    }
}
