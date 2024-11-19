package main.java.subway.view;

import static subway.appconfig.AppConstants.WRONG_INPUT;

public class StationInputView extends InputView{

    public StationInputView() {
        super("123B");
    }

    protected void printSelectPage() {
        System.out.println("## 역 관리 화면");
        System.out.println("1. 역 등록");
        System.out.println("2. 역 삭제");
        System.out.println("3. 역 조회");
        System.out.println("B. 돌아가기");
        System.out.printf("%n" + "## 원하는 기능을 선택하세요." + "%n");
    }
}
