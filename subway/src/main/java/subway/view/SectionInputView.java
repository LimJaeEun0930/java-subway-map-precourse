package main.java.subway.view;

import static main.java.subway.appconfig.ErrorConstants.ERROR_NON_EXIST_LINE;
import static main.java.subway.appconfig.ErrorConstants.ERROR_NON_EXIST_STATION;
import static main.java.subway.appconfig.ErrorConstants.ERROR_NON_EXIST_STATION_IN_LINE;
import static main.java.subway.appconfig.ErrorConstants.ERROR_WRONG_INPUT;

import main.java.subway.controller.LineController;
import main.java.subway.controller.StationController;
import main.java.subway.domain.Line;
import main.java.subway.domain.Station;

public class SectionInputView extends InputView{
    public static SectionInputView sectionInputView = new SectionInputView();

    private SectionInputView() {
        super("123B");
    }

    protected void printSelectPage() {
        System.out.println("## 구간 관리 화면");
        System.out.println("1. 구간 등록");
        System.out.println("2. 구간 삭제");
        System.out.println("B. 돌아가기");
    }

    public Line getLineToAddSection() {
        while (true) {
            System.out.println("## 노선을 입력하세요.");
            String input = scanner.nextLine();
            Line lineByName = LineController.getLineByName(input);
            if (lineByName != null) {
                return lineByName;
            }
            System.out.println(ERROR_NON_EXIST_LINE);
        }
    }

    public Line getLineToRemove() {
        while (true) {
            System.out.println("## 삭제할 구간의 노선을 입력하세요.");
            String input = scanner.nextLine();
            Line lineByName = LineController.getLineByName(input);
            if (lineByName != null) {
                return lineByName;
            }
            System.out.println(ERROR_NON_EXIST_LINE);
        }
    }

    public Station getSectionToAdd() {
        while (true) {
            System.out.println("## 역이름을 입력하세요.");
            String input = scanner.nextLine();
            Station station = StationController.getStationByName(input);
            if (station != null) {
                return station;
            }
            System.out.println(ERROR_NON_EXIST_STATION);
        }
    }

    public Station getSectionToRemove(Line line) {
        while (true) {
            System.out.println("## 삭제할 구간의 역을 입력하세요.");
            String input = scanner.nextLine();
            Station station = StationController.getStationByName(input);
            if (line.isSectionInLine(station)) {
                return station;
            }
            if (!line.isSectionInLine(station)) {
                System.out.println(ERROR_NON_EXIST_STATION_IN_LINE);
            }
            System.out.println(ERROR_NON_EXIST_STATION);
        }
    }

    public int getSequenceToAdd(Line line) {
        while (true) {
            try {
                System.out.println("## 순서를 입력하세요.");
                int input = scanner.nextInt();
                if (validateRange(line, input)) {
                    continue;
                }
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_WRONG_INPUT);
            }
        }
    }

    private boolean validateRange(Line line, int input) {
        if (input <= 0 || input > line.getStationLength() + 1) {
            System.out.println(ERROR_WRONG_INPUT);
            return true;
        }
        return false;
    }
}
