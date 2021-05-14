package Play;

import java.util.Scanner;

public class Shop {
	private static Scanner scan = new Scanner(System.in);

	public static void shop() {
		boolean shop = true;
		while (shop) {
			System.out.println();
			System.out.println("상점");
			System.out.println();
			System.out.println("--------------------------");
			System.out.print("1. 목  ");
			System.out.println();
			System.out.println("0. 돌아가기");
			System.out.println("--------------------------");
			System.out.print("선택> ");

			int shopChoice = scan.nextInt();

			System.out.println();

			if (shopChoice == 0) {
				PlayMain.main(null);
			} else if (shopChoice == 1) {

			}

		}
	}

}
