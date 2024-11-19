package main.java.subway.controller;

import main.java.subway.domain.Station;
import main.java.subway.repository.StationRepository;

public class StationController {
    public static StationController stationController = new StationController();

    private StationController() {
    }

//    public static StationController getInstance() {
//        if (stationController == null) {
//            stationController = new StationController();
//        }
//        return stationController;
//    }
    public static Station getStationByName(String input) {
        for (Station station : StationRepository.stations()) {
            if (input.equals(station.getName())) {
                return station;
            }
        }
        return null;
    }

}
