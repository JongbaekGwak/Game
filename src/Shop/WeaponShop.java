package Shop;

import Play.PlayGame;
import Play.PlayMain;
import Item.WeaponList;

public class WeaponShop {

	public static void WeaponShop() {
		System.out.println();
		System.out.println("무기 상점");
		System.out.println("-------------------------------");
		System.out.println("1.물리계열 | 2.마법계열 | 3.뒤로가기");
		System.out.println("0.메인화면");
		System.out.println("-------------------------------");
		System.out.print("선택> ");

		int choice = PlayMain.scan.nextInt();

		if (choice == 0) {
			PlayMain.main(null);
		} else if (choice == 1) {
			weapon01();
		} else if (choice == 2) {
			weapon02();
		} else if (choice == 3) {
			Shop.Shop();
		} else {
			System.out.println("-------------------------------");
			System.out.println("잘못된 번호를 입력 하셧습니다.");
			System.out.println("-------------------------------");
			WeaponShop();
		}
	}

	public static void weapon01() {

		System.out.println();
		System.out.println("물리계열 상점");
		System.out.println("-------------------------------");
		System.out.println("구매 하실 아이템의 번호를 입혁하세요");
		System.out.println("0.뒤로가기");
		System.out.println("-------------------------------");

		for (int i = 0; i < PlayMain.weaponList.length; i++) {
			if (PlayMain.weaponList[i] != null) {
				System.out.println("-------------------------------");
				System.out.println((i + 1) + ". " + PlayMain.weaponList[i].name);
				System.out.println("능력치 : ");
				if (PlayMain.weaponList[i].STR != 0) {
					System.out.println("STR +" + PlayMain.weaponList[i].STR);
				}
				if (PlayMain.weaponList[i].DEX != 0) {
					System.out.println("DEX +" + PlayMain.weaponList[i].DEX);
				}
				if (PlayMain.weaponList[i].INT != 0) {
					System.out.println("INT +" + PlayMain.weaponList[i].INT);
				}
				if (PlayMain.weaponList[i].LUK != 0) {
					System.out.println("LUK +" + PlayMain.weaponList[i].LUK);
				}

				System.out.println("구입 금액 : " + PlayMain.weaponList[i].Gold);
				System.out.println("-------------------------------");
			}
		}

		System.out.print("선택> ");
		int itemChoice = PlayMain.scan.nextInt();

		if (PlayMain.weaponList[itemChoice - 1].Gold <= PlayMain.character.Gold) {
			for (int i = 0; i < PlayMain.inven.length; i++) {
				if (PlayMain.inven[i] == null) {
					PlayMain.inven[i] = PlayMain.weaponList[itemChoice - 1];
					PlayMain.character.Gold -= PlayMain.weaponList[itemChoice - 1].Gold;
					System.out.println(PlayMain.weaponList[itemChoice - 1].name + "를 구입하였습니다.");

					PlayMain.character.STR += PlayMain.weaponList[itemChoice - 1].STR;
					PlayMain.character.DEX += PlayMain.weaponList[itemChoice - 1].DEX;
					PlayMain.character.INT += PlayMain.weaponList[itemChoice - 1].INT;
					PlayMain.character.LUK += PlayMain.weaponList[itemChoice - 1].LUK;
					
					PlayMain.character.upDate();
					
					PlayGame.start();
				} else {
					System.out.println("인벤토리가 가득 찼습니다.");
				}
			}
		} else if (PlayMain.weaponList[itemChoice - 1].Gold > PlayMain.character.Gold) {
			System.out.println("-------------------------------");
			System.out.println("골드가 부족합니다 게임으로 돌아 갑니다.");
			System.out.println("-------------------------------");
			PlayGame.start();
		}

	}

	public static void weapon02() {
		System.out.println();
		System.out.println("마법계열 상점");
		System.out.println("-------------------------------");
		System.out.println("구매 하실 아이템의 번호를 입혁하세요");
		System.out.println("0.뒤로가기");
		System.out.println("-------------------------------");

		System.out.print("구현된 아이템 없음");
		System.out.print("선택> ");
	}

}
