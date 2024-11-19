package subway.controller;

import subway.domain.Station;
import subway.domain.StationRepository;

public class StationController {
    private static StationController stationController;

    private StationController() {
    }

    public static StationController getInstance() {
        if (stationController == null) {
            stationController = new StationController();
        }
        return stationController;
    }
    public static Station getStationByName(String input) {
        for (Station station : StationRepository.stations()) {
            if (input.equals(station.getName())) {
                return station;
            }
        }
        return null;
    }

}
