package main.java.subway.view;

import static main.java.subway.repository.LineRepository.lines;
import static main.java.subway.repository.StationRepository.stations;

import main.java.subway.domain.Line;
import main.java.subway.domain.Station;

public final class OutputView {
    public static OutputView outputView = new OutputView();

    private OutputView() {
    }

    public void printAllLineInfo() {
        System.out.println("## 지하철 노선도");
        for (Line line : lines()) {
            System.out.println("[INFO] " + line);
            System.out.println("[INFO] ---");
            for (Station station : line.getStations()) {
                System.out.println("[INFO] " + station);
            }
            System.out.println();
        }
    }

    public void printAllLines() {
        System.out.println("## 노선 목록");
        for (Line line : lines()) {
            System.out.println("[INFO] " + line);
        }
    }

     public void printAllStations() {
        System.out.println("## 역 목록");
        for (Station station : stations()) {
            System.out.printf("INFO " + station + "%n");
        }
        System.out.println();
    }
}
