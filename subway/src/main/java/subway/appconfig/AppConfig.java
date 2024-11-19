package main.java.subway.appconfig;

import static main.java.subway.controller.LineController.getLineByName;
import static main.java.subway.controller.StationController.getStationByName;
import static main.java.subway.domain.LineRepository.addLine;
import static main.java.subway.domain.StationRepository.addStation;

import main.java.subway.controller.LineController;
import main.java.subway.controller.StationController;
import main.java.subway.domain.Line;
import main.java.subway.domain.Station;
import main.java.subway.view.OutputView;


public class AppConfig {
    public static void initialize() {
        StationController.getInstance();
        LineController.getInstance();
        OutputView.getInstance();
        initializeStations();
        initializeLines();
        initializeLineSection();
    }

    private static void initializeStations() {
        addStation(new Station("교대역"));
        addStation(new Station("강남역"));
        addStation(new Station("역삼역"));
        addStation(new Station("남부터미널역"));
        addStation(new Station("양재역"));
        addStation(new Station("양재시민의숲역"));
        addStation(new Station("매봉역"));
    }

    private static void initializeLines() {
        addLine(new Line("2호선", getStationByName("교대역"), getStationByName("역삼역")));
        addLine(new Line("3호선", getStationByName("교대역"), getStationByName("매봉역")));
        addLine(new Line("신분당선", getStationByName("강남역"), getStationByName("양재시민의숲역")));
    }

    private static void initializeLineSection() {
        getLineByName("2호선").addSection(getStationByName("강남역"), 2);
        getLineByName("3호선").addSection(getStationByName("남부터미널역"), 2);
        getLineByName("3호선").addSection(getStationByName("양재역"), 3);
        getLineByName("신분당선").addSection(getStationByName("양재역"), 2);
    }

}
