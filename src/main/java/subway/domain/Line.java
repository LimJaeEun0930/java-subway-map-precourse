package subway.domain;

import java.util.ArrayList;

public class Line {
    private String name;
    private ArrayList<Station> stations = new ArrayList<>();

    public Line(String name, Station start, Station end) {
        this.name = name;
        this.stations.add(start);
        this.stations.add(end);
    }

    public String getName() {
        return name;
    }

    public boolean addSection(Station station, int sequence) {
        if (stations.contains(station)) {
            return false;
        }
        stations.add(sequence - 1, station);
        return true;
    }
}
