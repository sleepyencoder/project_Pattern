package graphicsEditor;

// 실행 진입점 클래스
public class GMain {
	public static void main(String[] args) {
		GMainFrame mainFrame = new GMainFrame(); // 메인 프레임 생성
		mainFrame.setVisible(true); // 화면에 표시
		mainFrame.initialize(); // 초기화 메서드 호출
	}
}
