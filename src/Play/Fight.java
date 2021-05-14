package Play;

import java.util.Scanner;

import Monster.Monster;
import Monster.Ork;

public class Fight {
	private static Scanner scan = new Scanner(System.in);

	public static void fight() {
		Monster mob;
		int mobNo = (int) (Math.random() * 1);
		if (mobNo == 0) {
			mob = new Ork();
		} else {
			mob = new Ork();
		}

		System.out.println("--------------------------");
		System.out.println(mob.name + "를 만났습니다.");
		System.out.println("--------------------------");

		boolean fight = true;

		while (fight) {

			System.out.println("1. 공격  2." + PlayMain.character.skillName);
			System.out.print("선택> ");

			int att = scan.nextInt();

			if (att == 1) {
				System.out.println("공격!");
				int dmg = ((int) PlayMain.character.ATK - mob.DEF);
				int attEva = (int) ((Math.random() * 100) - (mob.DEF));
				System.out.println("공격 성공 확률 : " + attEva);
				if (attEva == 0) {
					System.out.println(mob.name + "이 회피 하였습니다.");
				} else {
					System.out.println(mob.name + "에게 " + dmg + "의 데미지!");
					mob.HP -= dmg;
					System.out.println("몬스터 남은 HP : " + mob.HP);
					if ((mob.HP) <= 0) {
						System.out.println("사냥에 성공 하였습니다.");
						int mobExp = 0;
						int exep = PlayMain.character.Lv - mob.Lv;
						if (exep > 0) {
							mobExp += (int) ((mob.EXP) / exep);
						} else if (exep < 0) {
							mobExp += ((mob.EXP) * (exep * -1));
						} else if (exep == 0) {
							mobExp += mob.EXP;
						}
						PlayMain.character.EXP += mobExp;
						if (PlayMain.character.EXP == 100) {
							PlayMain.character.EXP -= 100;
							PlayMain.character.STR++;
							PlayMain.character.DEX++;
							PlayMain.character.Lv++;
							if (PlayMain.character.Lv % 2 == 0) {
								PlayMain.character.INT++;
								PlayMain.character.LUK++;
							}
						}
						PlayMain.character.Gold += mob.dropGold;
						PlayGame.start();
						break;
					}
				}
			} else if (att == 2) {
				System.out.println(PlayMain.character.skillName + " 공격!");
				int dmg = ((int) ((PlayMain.character.ATK - mob.DEF) * 1.5));
				int attEva = (int) ((Math.random() * 100) - (mob.DEF));
				System.out.println("공격 성공 확률 : " + attEva);
				if (attEva == 0) {
					System.out.println(mob.name + "이 회피 하였습니다.");
				} else {
					System.out.println(mob.name + "에게 " + dmg + "의 데미지!");
					mob.HP -= dmg;
					if ((mob.HP) <= 0) {
						System.out.println("사냥에 성공 하였습니다.");
						int mobExp = 0;
						int exep = PlayMain.character.Lv - mob.Lv;
						if (exep > 0) {
							mobExp += (int) ((mob.EXP) / exep);
						} else if (exep < 0) {
							mobExp += ((mob.EXP) * (exep * -1));
						} else if (exep == 0) {
							mobExp += mob.EXP;
						}
						PlayMain.character.EXP += mobExp;
						if (PlayMain.character.EXP == 100) {
							PlayMain.character.EXP -= 100;
							PlayMain.character.STR++;
							PlayMain.character.DEX++;
							PlayMain.character.Lv++;
							if (PlayMain.character.Lv % 2 == 0) {
								PlayMain.character.INT++;
								PlayMain.character.LUK++;
							}
						}
						PlayMain.character.Gold += mob.dropGold;
						PlayGame.start();
						break;
					}
				}
			}

			System.out.println("--------------------------");
			
			System.out.println(mob.name + "의 공격");
			int mobDmg = ((int) (mob.ATK - PlayMain.character.DEF));
			int mobAttEva = (int) ((Math.random() * 100) - (PlayMain.character.DEF));
			System.out.println("공격 성공 확률 : " + mobAttEva);
			if (mobAttEva == 0) {
				System.out.println(mob.name + "이 회피 하였습니다.");
			} else {
				System.out.println(mob.name + "에게 " + mobDmg + "의 데미지를 받았습니다.");
				PlayMain.character.HP -= mobDmg;
				if ((PlayMain.character.HP) <= 0) {
					System.out.println("사망 하였습니다.");
					System.out.println("메인으로 돌아 갑니다.");
					PlayMain.character.HP += PlayMain.character.maxHP;
					PlayMain.main(null);
				}
			}
		}

	}
}


