package main.java.subway.view;

import main.java.subway.domain.Line;

public class LineInputView extends InputView {

    public LineInputView() {
        super("123B");
    }
    protected void printSelectPage() {
        System.out.println("## 노선 관리 화면");
        System.out.println("1. 노선 등록");
        System.out.println("2. 노선 삭제");
        System.out.println("3. 노선 조회");
        System.out.println("B. 돌아가기");
        System.out.printf("%n" + "## 원하는 기능을 선택하세요." + "%n");
    }
}
