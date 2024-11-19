package main.java.subway.view;

public class MainInputView extends InputView {

    public MainInputView() {
        super("1234Q");
    }
    @Override
    protected void printSelectPage() {
        System.out.println("## 메인화면");
        System.out.println("1. 역 관리");
        System.out.println("2. 노선 관리");
        System.out.println("3. 구간 관리");
        System.out.println("4. 지하철 노선도 출력");
        System.out.println("Q. 종료");
    }
}
