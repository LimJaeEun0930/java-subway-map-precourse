package main.java.subway.view;

import static main.java.subway.appconfig.ErrorConstants.ERROR_UNABLE_FUNCTION;

import java.util.Scanner;

public abstract class InputView {
    String options;
    protected final Scanner scanner = new Scanner(System.in);

    protected InputView(String options) {
        this.options = options;
    }

    public String selectToDo() {
        while (true) {
            printSelectPage();
            System.out.printf("%n" + "## 원하는 기능을 선택하세요." + "%n");
            String input = scanner.nextLine();
            if (input.length() == 1 && this.options.contains(input)) {
                return input;
            }
            System.out.println(ERROR_UNABLE_FUNCTION);
            System.out.println();
        }
    }

    protected void printSelectPage() {
    }

}
