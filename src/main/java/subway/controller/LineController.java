package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class LineController {
    private static LineController lineController;

    private LineController() {
    }

    public static LineController getInstance() {
        if (lineController == null) {
            lineController = new LineController();
        }
        return lineController;
    }
    public static Line getLineByName(String input) {
        for (Line line : LineRepository.lines()) {
            if (input.equals(line.getName())) {
                return line;
            }
        }
        return null;
    }

    public static void printAllLineInfo() {

    }
}
