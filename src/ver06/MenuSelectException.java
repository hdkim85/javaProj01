package ver06;

public class MenuSelectException extends Exception{
	public MenuSelectException() {
		super("번호의 범위가 잘못 입력되었습니다.");
	}
}
