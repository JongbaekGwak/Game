package Inventory;

import java.util.Scanner;

import Play.PlayGame;
import Play.PlayMain;

public class Inventory {
	public static Scanner scan = new Scanner(System.in);

	public static void Inventory() {

		if (PlayMain.inven[0] == null) {
			System.out.println("인벤토리가 비어 있습니다.");
			PlayGame.start();
		} else {
			for (int i = 0; i < PlayMain.inven.length; i++) {
				if (PlayMain.inven[i] != null) {
					System.out.println();
					System.out.println("인벤토리");
					System.out.println("-------------------------------");
					System.out.println((i + 1) + ". " + PlayMain.inven[i].name);
					System.out.println("능력치 : ");
					if (PlayMain.inven[i].STR != 0) {
						System.out.println("STR +" + PlayMain.inven[i].STR);
					}
					if (PlayMain.inven[i].DEX != 0) {
						System.out.println("DEX +" + PlayMain.inven[i].DEX);
					}
					if (PlayMain.inven[i].INT != 0) {
						System.out.println("INT +" + PlayMain.inven[i].INT);
					}
					if (PlayMain.inven[i].LUK != 0) {
						System.out.println("LUK +" + PlayMain.inven[i].LUK);
					}
					
					System.out.println("-------------------------------");
					PlayGame.start();
				} else {
					System.out.println();
					System.out.println("-------------------------------");
					System.out.println("1.게임으로 돌아가기");
					System.out.println("0.메인화면");
					System.out.println("-------------------------------");
					System.out.print("선택> ");

					int choice = scan.nextInt();

					if (choice == 0) {
						PlayMain.main(null);
					} else if (choice == 1) {
						PlayGame.start();
					} else {
						System.out.println("-------------------------------");
						System.out.println("잘못된 번호를 입력 하셧습니다.");
						System.out.println("-------------------------------");
						Inventory();
					}
				}
			}
		}
	}
}
