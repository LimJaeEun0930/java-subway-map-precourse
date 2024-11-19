package main.java.subway.domain;

import java.util.LinkedList;

public class Line {
    private String name;
    private LinkedList<Station> stations = new LinkedList<>();

    public Line(String name, Station start, Station end) {
        this.name = name;
        this.stations.add(start);
        this.stations.add(end);
    }

    public boolean isSectionInLine(Station station) {
        return stations.contains(station);
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

    public int getStationLength() {
        return stations.size();
    }

    public void removeSection(Station station) {
        stations.remove(station);
    }

    @Override
    public String toString() {
        return name;
    }
}
