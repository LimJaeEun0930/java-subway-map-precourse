package main.java.subway.controller;

import static main.java.subway.controller.StationController.getStationByName;
import static main.java.subway.controller.StationController.stationController;
import static main.java.subway.repository.StationRepository.addStation;
import static main.java.subway.repository.StationRepository.deleteStation;
import static main.java.subway.repository.StationRepository.stations;
import static main.java.subway.view.StationInputView.stationInputView;

import main.java.subway.domain.Station;

public class StationManagementController extends ManagementController {

    @Override
    public void run() {
        String choice = stationInputView.selectToDo();
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
            printAllStations();
        }

    }

    private void registerStation() {
        String newStationName = stationInputView.getNewStation();
        Station newStation = new Station(newStationName);
        addStation(newStation);
    }

    private void removeStation() {
        String stationNameToDelete = stationInputView.getStationNameToDelete();
        Station station = getStationByName(stationNameToDelete);
        deleteStation(station);
    }

    private void printAllStations() {
        System.out.println("## 역 목록");
        for (Station station : stations()) {
            System.out.printf("INFO " + station + "%n");
        }
        System.out.println();
    }
}
