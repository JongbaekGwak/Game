package Play;

import java.util.Scanner;

public class PlayGame {
	private static Scanner scan = new Scanner(System.in);

	public static void start() {
		System.out.println("--------------------------");
		System.out.println("게임을 시작 합니다.");
		System.out.println("1.Play | 2.스탯 | 3.캐릭터 선택");
		System.out.println("0.메인화면");
		System.out.println("--------------------------");
		System.out.print("선택> ");

		int startChoice = scan.nextInt();
		if (startChoice == 1) {
			play();
		} else if (startChoice == 2) {
			stat();
		} else if (startChoice == 3) {
			JobChoice.jobChoice();
		} else if (startChoice == 0) {
			PlayMain.character = null;
			PlayMain.main(null);
		}
	}

	public static void stat() {
		System.out.println("--------------------------");
		System.out.println("Lv : " + PlayMain.character.Lv);
		System.out.println("EXP : " + PlayMain.character.EXP);
		System.out.println();
		System.out.println("스탯 : ");
		System.out.println("공격력 : " + PlayMain.character.ATK);
		System.out.println("방어력 : " + PlayMain.character.DEF);
		System.out.println("최대 HP : " + PlayMain.character.maxHP);
		System.out.println("최대 MP : " + PlayMain.character.maxMP);
		System.out.println("힘 : " + PlayMain.character.STR);
		System.out.println("민첩 : " + PlayMain.character.DEX);
		System.out.println("지능 : " + PlayMain.character.INT);
		System.out.println("운 : " + PlayMain.character.LUK);
		System.out.println("스킬 : " + PlayMain.character.skillName);
		System.out.println();
		System.out.println("소지금 : " + PlayMain.character.Gold);
		System.out.println("--------------------------");
		System.out.println();
		start();
	}

	public static void play() {
		boolean play = true;

		while (play) {

			System.out.println("이동합니다.");

			int gameRun = (int) (Math.random() * 4);

			if (gameRun == 0) {
				System.out.println("아직 몬스터를 못 만났습니다.");

			} else if (gameRun == 1) {
				System.out.println("몬스터를 마주쳤습니다.");
				System.out.println("몬스터가 도망 갑니다.");
				System.out.println("계속 이동합니다");

			} else if (gameRun == 2) {
				System.out.println("몬스터를 마주쳣습니다.");
				System.out.println("--------------------------");
				System.out.println("1.싸우기 | 2.도망가기");
				System.out.println("0.메인으로");
				System.out.println("--------------------------");
				System.out.print("선택> ");

				int choice = scan.nextInt();
				System.out.println();

				if (choice == 0) {
					PlayMain.character = null;
					PlayMain.main(null);
				} else if (choice == 1) {
					PlayFight.fight();
				} else if (choice == 2) {
					System.out.println("도망 갑니다.");
				}
			} else {
				System.out.println("돌아 갑니다.");
			}
		}
	}
}
