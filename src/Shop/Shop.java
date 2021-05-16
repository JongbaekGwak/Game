package Shop;

import Play.PlayGame;
import Play.PlayMain;

public class Shop {
	public static void Shop() {

		System.out.println("-------------------------------");
		System.out.println("게임을 시작 합니다.");
		System.out.println("1.무기 상점 | 2.방어구 상점 | 3.물약 상점");
		System.out.println("4.돌아가기");
		System.out.println("0.메인화면");
		System.out.println("-------------------------------");
		System.out.print("선택> ");

		int shopChoice = PlayMain.scan.nextInt();

		if (shopChoice == 0) {
			PlayMain.character = null;
			PlayMain.main(null);
		} else if (shopChoice == 1) {
			WeaponShop.WeaponShop();
		} else if (shopChoice == 4) {
			PlayGame.start();
		} else {
			System.out.println("-------------------------------");
			System.out.println("아직 구현이 안되었습니다.");
			System.out.println("-------------------------------");
			Shop();
		}
	}
}
