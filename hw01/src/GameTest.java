import java.util.Scanner;

public class GameTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요.\n1. 5판 3승\n2. 3판 2승\n3. 1판 1승\n번호를 입력하세요. ");
		int num = sc.nextInt();
		int round = 0;
		int goal = 0;
		
		switch (num) {
		case 1:
			round = 5;
			goal = 3;
			break;
		case 2:
			round = 3;
			goal = 2;
			break;
		case 3:
			round = 1;
			goal = 1;
			break;
		default:
			System.out.println("잘못된 입력입니다.");
			System.exit(0);
		}
		
		int com_win = 0;
		int user_win = 0;
		for (int i = 0; i < round; i++) {
			int com = (int)(Math.random() * 3) + 1;
			System.out.print("가위바위보 중 하나 입력: ");
			String user = sc.next();
			
			switch (user) {
			case "가위":
				if (com == 1) {
					System.out.println("비겼습니다!!!");
				} else if (com == 2) {
					System.out.println("졌습니다!!!");
					com_win++;
				} else {
					System.out.println("이겼습니다!!!");
					user_win++;
				} break;
			case "바위":
				if (com == 1) {
					System.out.println("이겼습니다!!!");
					user_win++;
				} else if (com == 2) {
					System.out.println("비겼습니다!!!");
				} else {
					System.out.println("졌습니다!!!");
					com_win++;
				} break;
			case "보":
				if (com == 1) {
					System.out.println("졌습니다!!!");
					com_win++;
				} else if (com == 2) {
					System.out.println("이겼습니다!!!");
					user_win++;
				} else {
					System.out.println("비겼습니다!!!");
				} break;
			default:
				System.out.println("잘못된 입력입니다.");
				System.exit(0);
			}
			
			if (user_win >= goal) {
				System.out.println("### 사용자 승!!!");
				System.exit(0);
			} else if (com_win >= goal) {
				System.out.println("### 컴퓨터 승!!!");
				System.exit(0);
			}
		}
		System.out.println("### 무승부!!!");
	}

}
