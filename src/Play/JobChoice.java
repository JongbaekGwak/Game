package Play;

import java.util.Scanner;

import Character.Knight;

public class JobChoice {

	private static Scanner scan = new Scanner(System.in);

	public static void jobChoice() {
		boolean choice = true;
		while (choice) {
			System.out.println();
			System.out.println("직업 선택");
			System.out.println();
			System.out.println("--------------------------");
			System.out.print("1. 기사  ");
			System.out.println();
			System.out.println("0. 돌아가기");
			System.out.println("--------------------------");
			System.out.print("선택> ");

			int runChoice = scan.nextInt();

			System.out.println();

			if (runChoice == 1) {
				PlayMain.character = new Knight();
				System.out.println(PlayMain.character.name + " 을(를) 선택 하셧습니다.");
				System.out.println();
				PlayGame.start();
				break;
			} else if (runChoice == 0) {
				PlayMain.main(null);
				break;
			} else {
				System.out.println("잘못된 번호를 입력 하셧습니다.");
			}
		}
	}

}
