package subway;

import java.util.Scanner;
import subway.appconfig.AppConfig;
import subway.controller.AppController;

public class Application {
    public static void main(String[] args) {
        AppConfig.initialize();

        AppController appController = new AppController();
        appController.run();

    }
}
