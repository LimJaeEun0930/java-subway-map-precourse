package main.java.subway.controller;


import static main.java.subway.view.LineInputView.lineInputView;

import main.java.subway.domain.Line;
import main.java.subway.domain.Station;
import main.java.subway.repository.LineRepository;

public class LineController {
    public static LineController lineController = new LineController();

    private LineController() {
    }

    public Line createLine() {
        String newLineName = lineInputView.getNewLineName();
        Station startStation = lineInputView.getNewLineStartStation();
        Station endStation = lineInputView.getNewLineEndStation();
        System.out.println("[INFO] 지하철 노선이 등록되었습니다.");
        return new Line(newLineName, startStation, endStation);
    }

    public static Line getLineByName(String input) {
        for (Line line : LineRepository.lines()) {
            if (input.equals(line.getName())) {
                return line;
            }
        }
        return null;
    }
}
