package main.java.subway.controller;

import static main.java.subway.view.LineInputView.lineInputView;
import static main.java.subway.view.SectionInputView.sectionInputView;

import main.java.subway.domain.Line;
import main.java.subway.domain.Station;
import main.java.subway.view.LineInputView;

public class SectionManagementController extends ManagementController {
    @Override
    public void run() {
        String choice = sectionInputView.selectToDo();
        if (choice.equals("1")) {
            registerSection();
        }
        if (choice.equals("2")) {
            removeSection();
        }

    }

    private void registerSection() {
        Line lineToAddSection = sectionInputView.getLineToAddSection();
        Station sectionToAdd = sectionInputView.getSectionToAdd();
        int sequenceToAdd = sectionInputView.getSequenceToAdd(lineToAddSection);
        lineToAddSection.addSection(sectionToAdd, sequenceToAdd);

    }

    private void removeSection() {
        Line line = sectionInputView.getLineToRemove();
        Station section = sectionInputView.getSectionToRemove(line);
        line.removeSection(section);
        System.out.println("[INFO] 구간이 삭제되었습니다.");
    }
}
