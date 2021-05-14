package Play;

import java.util.Scanner;

import Character.Character;

public class PlayMain {
	public static Character character;
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		boolean run = true;

		while (run) {
			System.out.println("PlayMain");
			System.out.println("접속을 환영합니다.");
			System.out.println();
			System.out.println("--------------------------");
			System.out.print("1. 시작  ");
			System.out.println("2. 종료");
			System.out.println("--------------------------");
			System.out.print("선택> ");

			int selectNo = scan.nextInt();

			System.out.println();

			if (selectNo == 1) {
				JobChoice.jobChoice();
			} else if (selectNo == 2) {
				System.out.println("게임을 종료 합니다.");
				break;
			} else {
				System.out.println("잘못된 번호를 입력 하셧습니다.");
			}

		}
	}
}
