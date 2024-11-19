package main.java.subway.view;

import static main.java.subway.appconfig.AppConstants.ERROR_ALREADY_EXIST_LINE;
import static main.java.subway.appconfig.AppConstants.ERROR_ALREADY_EXIST_STAION;
import static main.java.subway.appconfig.AppConstants.ERROR_LINE_NAME_NOT_END_WITH_SUFFIX;
import static main.java.subway.appconfig.AppConstants.ERROR_NON_EXIST_LINE;
import static main.java.subway.appconfig.AppConstants.ERROR_TOO_SHORT_LINE_NAME;
import static main.java.subway.controller.LineController.getLineByName;
import static main.java.subway.repository.LineRepository.deleteLineByName;

import java.util.Optional;
import main.java.subway.domain.Line;
import main.java.subway.domain.Station;
import main.java.subway.repository.StationRepository;

public class LineInputView extends InputView {
    public static LineInputView lineInputView = new LineInputView();

    private LineInputView() {
        super("123B");
    }
    protected void printSelectPage() {
        System.out.println("## 노선 관리 화면");
        System.out.println("1. 노선 등록");
        System.out.println("2. 노선 삭제");
        System.out.println("3. 노선 조회");
        System.out.println("B. 돌아가기");
        System.out.printf("%n" + "## 원하는 기능을 선택하세요." + "%n");
    }

    public String getNewLineName() {
        while (true) {
            System.out.println("## 등록할 노선 이름을 입력하세요.");
            String input = scanner.nextLine();
            if (validateLineName(input) == true) {
                return input;
            }
        }
    }

    public String getLineNameToDelete() {
        while (true) {
            System.out.println("## 삭제할 노선 이름을 입력하세요.");
            String input = scanner.nextLine();
            if (getLineByName(input) != null) {
                return input;
            }
            System.out.println(ERROR_NON_EXIST_LINE);
        }
    }

    public Station getNewLineStartStation() {
        while (true) {
            System.out.println("## 등록할 노선의 상행 종점역 이름을 입력하세요.");
            String input = scanner.nextLine();
            if (isInStations(input)) {
                return StationRepository.stations().stream()
                        .filter(station -> station.getName().equals(input)).findFirst().get();
            }
        }
    }

    public Station getNewLineEndStation() {
        while (true) {
            System.out.println("## 등록할 노선의 하행 종점역 이름을 입력하세요.");
            String input = scanner.nextLine();
            if (isInStations(input)) {
                return StationRepository.stations().stream()
                        .filter(station -> station.getName().equals(input)).findFirst().get();
            }
        }
    }

    private boolean validateLineName(String input) {
        if (getLineByName(input) != null) {
            System.out.println(ERROR_ALREADY_EXIST_LINE);
            return false;
        }
        if (input.length() < 2) {
            System.out.println(ERROR_TOO_SHORT_LINE_NAME);
            return false;
        }
        if (!input.endsWith("선")) {
            System.out.println(ERROR_LINE_NAME_NOT_END_WITH_SUFFIX);
            return false;
        }
        return true;
    }

    private static boolean isInStations(String input) {
        return StationRepository.stations().stream().filter(station -> station.getName().equals(input)).findFirst()
                .isPresent();
    }
}
