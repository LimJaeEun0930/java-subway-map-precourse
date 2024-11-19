package subway.view;

import static subway.appconfig.AppConstants.WRONG_INPUT;

import java.util.Scanner;

public final class InputView {
    private final String options = "1234Q";
    private static InputView inputView;
    final Scanner scanner = new Scanner(System.in);
    private InputView() {
    }

    public static InputView getInstance() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    public String selectToDo() {
        while (true) {
            printMainPage();
            String input = scanner.nextLine();
            if (input.length() == 1 && this.options.contains(input)) {
                return input;
            }
            System.out.println(WRONG_INPUT);
        }
    }

    private static void printMainPage() {
        System.out.println("## 메인화면");
        System.out.println("1. 역 관리");
        System.out.println("2. 노선 관리");
        System.out.println("3. 구간 관리");
        System.out.println("4. 지하철 노선도 출력");
        System.out.println("Q. 종료");
        System.out.printf("%n" + "## 원하는 기능을 선택하세요." + "%n");
    }

}