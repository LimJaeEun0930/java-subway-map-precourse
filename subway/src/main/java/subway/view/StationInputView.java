package main.java.subway.view;

import static main.java.subway.appconfig.AppConstants.ERROR_ALREADY_EXIST_STAION;
import static main.java.subway.appconfig.AppConstants.ERROR_STATION_NAME_NOT_END_WITH_SUFFIX;
import static main.java.subway.appconfig.AppConstants.ERROR_TOO_SHORT_STATION_NAME;
import static subway.appconfig.AppConstants.WRONG_INPUT;

import main.java.subway.domain.Station;
import main.java.subway.repository.StationRepository;

public class StationInputView extends InputView{
    public static StationInputView stationInputView = new StationInputView();

    private StationInputView() {
        super("123B");
    }

    protected void printSelectPage() {
        System.out.println("## 역 관리 화면");
        System.out.println("1. 역 등록");
        System.out.println("2. 역 삭제");
        System.out.println("3. 역 조회");
        System.out.println("B. 돌아가기");
    }

    public String getNewStation() {
        while (true) {
            System.out.println("## 등록할 역 이름을 입력하세요.");
            String input = scanner.nextLine();
            if (validateStationName(input) == true) {
                return input;
            }
        }
    }

    private static boolean validateStationName(String input) {
        if (StationRepository.stations().stream().filter(station -> station.getName().equals(input)).findFirst().isPresent()) {
            System.out.println(ERROR_ALREADY_EXIST_STAION);
            return false;
        }
        if (input.length() < 2) {
            System.out.println(ERROR_TOO_SHORT_STATION_NAME);
            return false;
        }
        if (!input.endsWith("역")) {
            System.out.println(ERROR_STATION_NAME_NOT_END_WITH_SUFFIX);
            return false;
        }
        return true;
    }
}
