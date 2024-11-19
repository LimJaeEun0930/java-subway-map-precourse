package main.java.subway.controller;

import static main.java.subway.controller.StationController.getStationByName;
import static main.java.subway.repository.StationRepository.addStation;
import static main.java.subway.repository.StationRepository.deleteStation;
import static main.java.subway.view.OutputView.outputView;
import static main.java.subway.view.StationInputView.stationInputView;

import main.java.subway.domain.Station;

public class StationManagementController extends ManagementController {

    @Override
    public void run() {
        String choice = stationInputView.selectToDo();
        System.out.println();
        if (choice.equals("B")) {
            return;
        }
        if (choice.equals("1")) {
            registerStation();
        }
        if (choice.equals("2")) {
            removeStation();
        }
        if (choice.equals("3")) {
            outputView.printAllStations();
        }
    }

    private void registerStation() {
        String newStationName = stationInputView.getNewStation();
        Station newStation = StationController.createStation(newStationName);
        addStation(newStation);
        System.out.println();
        System.out.println("[INFO] 지하철 역이 등록되었습니다.");
        System.out.println();
    }

    private void removeStation() {
        String stationNameToDelete = stationInputView.getStationNameToDelete();
        Station station = getStationByName(stationNameToDelete);
        deleteStation(station);
    }

}
