package main.java.subway;

import main.java.subway.appconfig.AppConfig;
import main.java.subway.controller.AppController;



public class Application {
    public static void main(String[] args) {
        AppConfig.initialize();
        AppController appController = new AppController();
        appController.run();

    }
}
